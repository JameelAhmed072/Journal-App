package com.edigest.myFirstProject.services;

import com.edigest.myFirstProject.api.response.WeatherResponse;
import com.edigest.myFirstProject.cache.AppCache;
import com.edigest.myFirstProject.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    @Autowired
    private AppCache appCache;
    @Autowired
    private RedisService redisService;
    @Value("${weather.api.key}")
    private String apiKey;
    //   commited this line after adding the configuration in the database
//    private static final String API = "http://api.weatherapi.com/v1/current.json?key=API_KEY &q=CITY&aqi=no";
    @Autowired
    private RestTemplate restTemplate;
    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if(weatherResponse != null){
            return weatherResponse;
        }else{
            String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY, city).replace(PlaceHolders.API_KEYS, apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body != null){
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }
    }

}

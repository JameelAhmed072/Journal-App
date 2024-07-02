package com.edigest.myFirstProject.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse{
    private Current current;

    @Getter
    @Setter
    public class Current{
        private double temp_c;
        private double temp_f;
        private int humidity;
        private int cloud;
        private double feelslike_c;

    }


}






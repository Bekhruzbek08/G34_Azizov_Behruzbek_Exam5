package org.example;

import lombok.Data;

@Data
public class Api {
    private String name;
    private Integer year;
    private Integer number;
    private Boolean found;
    private String date;

    @Override
    public String toString() {
        return "Api{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", number=" + number +
                ", found=" + found +
                ", date='" + date + '\'' +
                '}';
    }

}


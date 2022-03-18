package com.leogg.crud.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@Document("productos")
public class Productos{

    private String id;
    private String nombre;
    private Double precio;
    private LocalDate date_exp;

}

package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class City extends BaseModel {
    private String name;
    @OneToMany
    private List<Theatre> theatres = new ArrayList<>(); // here we directly can't put list in a relational table so we use @OneToMany
}

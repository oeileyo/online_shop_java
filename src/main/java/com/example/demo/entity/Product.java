package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private String size;
    private String description;
    private Integer price;
    private Integer pieces_in_stock; // количество в наличии

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="model_id")
    @JsonIgnore
    private Model model;
    @Column(insertable = false, updatable = false)
    private Long model_id;
}

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String set_number; // артикул
    private String name;

    @OneToMany (mappedBy="model", cascade=CascadeType.ALL)
    private List<Product> productsList;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="manufacturer_id")
    @JsonIgnore
    private Manufacturer manufacturer;
    @Column(insertable = false, updatable = false)
    private Long manufacturer_id;

}

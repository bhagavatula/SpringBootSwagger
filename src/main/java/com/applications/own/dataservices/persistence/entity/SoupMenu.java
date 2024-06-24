package com.applications.own.dataservices.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="soup_menu")
@NamedQuery(name="SoupMenu.findAll", query="SELECT sp FROM SoupMenu sp")
public class SoupMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "soup_id_gen")
    @SequenceGenerator(name = "soup_id_gen", sequenceName = "soup_id_dtls_sequence")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "price", nullable = false)
    private Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
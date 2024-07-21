package br.com.devinvestidor.notification.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_category")
public class Category {

    @Id
    private Long id;
    String description;

    public Category() {}

    public Category(Long id) {
        this.id = id;
    }

    public Category(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
}

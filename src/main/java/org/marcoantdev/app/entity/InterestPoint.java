package org.marcoantdev.app.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@DynamicUpdate
@Table(name = "interest_point")
public class InterestPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @PositiveOrZero(message = "The coordinate Y must be a positive or zero value.")
    @Column(name = "coordinate_x", nullable = false)
    private int coordinateX;
    
    @PositiveOrZero(message = "The coordinate X must be a positive or zero value.")
    @Column(name = "coordinate_y", nullable = false)
    private int coordinateY;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCoordinateX() {
        return coordinateX;
    }
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    public int getCoordinateY() {
        return coordinateY;
    }
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}

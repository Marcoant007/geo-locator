package org.marcoantdev.app.dto;

import org.marcoantdev.app.entity.InterestPoint;
import org.modelmapper.ModelMapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class InterestPointDTO {
    int id;

    @NotBlank(message = "Name cannot be null")
    String name;
    
    @PositiveOrZero(message = "Coordinate X must be greater than or equal to zero")
    @NotNull(message = "Coordinate X cannot be null")
    int coordinateX;
    
    @PositiveOrZero(message = "Coordinate Y must be greater than or equal to zero")
    @NotNull(message = "Coordinate Y cannot be null")
    int coordinateY;

    public static InterestPointDTO returnDTO(InterestPoint interestPoint) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(interestPoint, InterestPointDTO.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

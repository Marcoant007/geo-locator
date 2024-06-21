package org.marcoantdev.app.dto;

import org.marcoantdev.app.entity.InterestPoint;
import org.modelmapper.ModelMapper;

public class InterestPointDTO {
    String name;
    
    int coordinateX;
    
    int coordinateY;

    public static InterestPointDTO returnDTO(InterestPoint interestPoint) {
        ModelMapper modelMapper = new ModelMapper();
        InterestPointDTO interestPointDTO = modelMapper.map(interestPoint, InterestPointDTO.class);
        interestPointDTO.setCoordinateX(interestPoint.getCoordinateX());
        interestPointDTO.setCoordinateY(interestPoint.getCoordinateY());
        interestPointDTO.setName(interestPoint.getName());
        return interestPointDTO;
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

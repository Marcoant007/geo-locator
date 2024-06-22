package org.marcoantdev.app.dto;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.ws.rs.QueryParam;

public class ProximitySearchDTO {

    @PositiveOrZero(message = "Coordinate X must be greater than or equal to zero")
    @QueryParam("x")
    private int x;

    @PositiveOrZero(message = "Coordinate Y must be greater than or equal to zero")
    @QueryParam("y")
    private int y;

    @PositiveOrZero(message = "D-max must be greater than zero")
    @QueryParam("d-max")
    private int dMax;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getdMax() {
        return dMax;
    }

    public void setdMax(int dMax) {
        this.dMax = dMax;
    }
}

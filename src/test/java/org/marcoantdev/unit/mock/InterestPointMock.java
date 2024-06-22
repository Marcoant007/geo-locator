package org.marcoantdev.unit.mock;

import org.marcoantdev.app.dto.InterestPointDTO;
import org.marcoantdev.app.service.InterestPointService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InterestPointMock {

    @Inject
    InterestPointService interestPointService;

    public InterestPointDTO creaInterestPoint(String name, int x, int y) {
        InterestPointDTO dto = new InterestPointDTO();
        dto.setName(name);
        dto.setCoordinateX(x);
        dto.setCoordinateY(y);
        return interestPointService.createInterestPoint(dto);
    }
}

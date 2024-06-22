package org.marcoantdev.unit.mock;

import org.marcoantdev.app.dto.ProximitySearchDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProximitySearchMock {
    public ProximitySearchDTO mockProximitySearchDTO(int x, int y, int dMax) {
        ProximitySearchDTO searchDTO = new ProximitySearchDTO();
        searchDTO.setX(x);
        searchDTO.setY(y);
        searchDTO.setdMax(dMax);
        return searchDTO;
    }
}

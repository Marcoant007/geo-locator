package org.marcoantdev.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.marcoantdev.app.dto.InterestPointDTO;
import org.marcoantdev.app.entity.InterestPoint;
import org.marcoantdev.app.exception.ApiException;
import org.marcoantdev.app.repository.InterestPointRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InterestPointService {

    @Inject
    InterestPointRepository repository;

    @Transactional
    public InterestPointDTO createInterestPoint(InterestPointDTO receiveDTO) {
        try {
            InterestPoint interestPoint = new InterestPoint();
            interestPoint.setName(receiveDTO.getName());
            interestPoint.setCoordinateX(receiveDTO.getCoordinateX());
            interestPoint.setCoordinateY(receiveDTO.getCoordinateY());
            repository.persist(interestPoint);
            return InterestPointDTO.returnDTO(interestPoint);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("Ops... Ocorreu um erro ao cadastrar o ponto futuro", 500);
        }
    }

    public List<InterestPointDTO> getAllInterestPoints() {
        try {
            List<InterestPoint> interestPoints = repository.listAll();
            return interestPoints.stream().map(InterestPointDTO::returnDTO).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("Ops... Ocorreu um erro ao listar os pontos futuros", 500);
        }
    }
}

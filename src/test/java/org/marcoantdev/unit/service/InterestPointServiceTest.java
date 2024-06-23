package org.marcoantdev.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.marcoantdev.app.dto.InterestPointDTO;
import org.marcoantdev.app.dto.ProximitySearchDTO;
import org.marcoantdev.app.repository.InterestPointRepository;
import org.marcoantdev.app.service.InterestPointService;
import org.marcoantdev.unit.mock.InterestPointMock;
import org.marcoantdev.unit.mock.ProximitySearchMock;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InterestPointServiceTest {

    @Inject
    InterestPointService interestPointService;

    @Inject
    InterestPointMock interestPointMock;

    @Inject
    ProximitySearchMock proximitySearchMock;

    @Inject
    InterestPointRepository interestPointRepository;

    @BeforeAll
    @Transactional
    void beforeAll() {
        interestPointRepository.deleteAll();
        interestPointMock.creaInterestPoint("Lanchonete", 27, 12);
        interestPointMock.creaInterestPoint("Posto", 31, 18);
        interestPointMock.creaInterestPoint("Joalheria", 15, 12);
        interestPointMock.creaInterestPoint("Floricultura", 19, 21);
        interestPointMock.creaInterestPoint("Pub", 12, 8);
        interestPointMock.creaInterestPoint("Supermercado", 23, 6);
        interestPointMock.creaInterestPoint("Churrascaria", 28, 2);
    }

    @AfterAll
    @Transactional
    void afterAll() {
        interestPointRepository.deleteAll();
    }

    @Test
    @Transactional
    void testCreateInterestPointSuccess() {
        InterestPointDTO receiveDTO = new InterestPointDTO();
        receiveDTO.setName("Test Point");
        receiveDTO.setCoordinateX(10);
        receiveDTO.setCoordinateY(20);

        InterestPointDTO resultDTO = interestPointService.createInterestPoint(receiveDTO);

        assertNotNull(resultDTO);
        assertEquals(receiveDTO.getName(), resultDTO.getName());
        assertEquals(receiveDTO.getCoordinateX(), resultDTO.getCoordinateX());
        assertEquals(receiveDTO.getCoordinateY(), resultDTO.getCoordinateY());
    }

    @Test
    @Transactional
    void testGetAllInterestPoints() {
        List<InterestPointDTO> interestPoints = interestPointService.getAllInterestPoints();

        assertNotNull(interestPoints);

        InterestPointDTO retrievedFirstPoint = interestPoints.get(0);
        assertEquals("Lanchonete", retrievedFirstPoint.getName());
        assertEquals(27, retrievedFirstPoint.getCoordinateX());
        assertEquals(12, retrievedFirstPoint.getCoordinateY());

        InterestPointDTO retrievedSecondPoint = interestPoints.get(1);
        assertEquals("Posto", retrievedSecondPoint.getName());
        assertEquals(31, retrievedSecondPoint.getCoordinateX());
        assertEquals(18, retrievedSecondPoint.getCoordinateY());

        InterestPointDTO retrievedThirdPoint = interestPoints.get(2);
        assertEquals("Joalheria", retrievedThirdPoint.getName());
        assertEquals(15, retrievedThirdPoint.getCoordinateX());
        assertEquals(12, retrievedThirdPoint.getCoordinateY());

        InterestPointDTO retrievedFourthPoint = interestPoints.get(3);
        assertEquals("Floricultura", retrievedFourthPoint.getName());
        assertEquals(19, retrievedFourthPoint.getCoordinateX());
        assertEquals(21, retrievedFourthPoint.getCoordinateY());

        InterestPointDTO retrievedFifthPoint = interestPoints.get(4);
        assertEquals("Pub", retrievedFifthPoint.getName());
        assertEquals(12, retrievedFifthPoint.getCoordinateX());
        assertEquals(8, retrievedFifthPoint.getCoordinateY());

        InterestPointDTO retrievedSixthPoint = interestPoints.get(5);
        assertEquals("Supermercado", retrievedSixthPoint.getName());
        assertEquals(23, retrievedSixthPoint.getCoordinateX());
        assertEquals(6, retrievedSixthPoint.getCoordinateY());

        InterestPointDTO retrievedSeventhPoint = interestPoints.get(6);
        assertEquals("Churrascaria", retrievedSeventhPoint.getName());
        assertEquals(28, retrievedSeventhPoint.getCoordinateX());
        assertEquals(2, retrievedSeventhPoint.getCoordinateY());
    }

    @Test
    @Transactional
    void testGetAllInterestPointsProximitySuccess() {
        ProximitySearchDTO searchDTO = proximitySearchMock.mockProximitySearchDTO(20, 10, 10);
        List<InterestPointDTO> proximityPoints = interestPointService.getAllInterestPointsProximity(searchDTO);
        assertNotNull(proximityPoints);
        assertEquals(4, proximityPoints.size());
      
        InterestPointDTO retrievedPoint = proximityPoints.get(0);
        assertEquals("Lanchonete", retrievedPoint.getName());
        assertEquals(27, retrievedPoint.getCoordinateX());
        assertEquals(12, retrievedPoint.getCoordinateY());

        InterestPointDTO retrievedThirdPoint = proximityPoints.get(1);
        assertEquals("Joalheria", retrievedThirdPoint.getName());
        assertEquals(15, retrievedThirdPoint.getCoordinateX());
        assertEquals(12, retrievedThirdPoint.getCoordinateY());

        InterestPointDTO retrievedFifthPoint = proximityPoints.get(2);
        assertEquals("Pub", retrievedFifthPoint.getName());
        assertEquals(12, retrievedFifthPoint.getCoordinateX());
        assertEquals(8, retrievedFifthPoint.getCoordinateY());
        
        InterestPointDTO retrievedSixthPoint = proximityPoints.get(3);
        assertEquals("Supermercado", retrievedSixthPoint.getName());
        assertEquals(23, retrievedSixthPoint.getCoordinateX());
        assertEquals(6, retrievedSixthPoint.getCoordinateY());
    }

    @Test
    @Transactional
    void testGetAllInterestPointsProximityNoMatches() {
        ProximitySearchDTO searchDTO = proximitySearchMock.mockProximitySearchDTO(0, 0, 5);
        List<InterestPointDTO> proximityPoints = interestPointService.getAllInterestPointsProximity(searchDTO);

        assertNotNull(proximityPoints);
        assertEquals(0, proximityPoints.size());
    }
}

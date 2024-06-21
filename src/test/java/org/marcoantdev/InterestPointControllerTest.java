package org.marcoantdev;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.marcoantdev.app.dto.InterestPointDTO;
import org.marcoantdev.app.dto.ProximitySearchDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class InterestPointControllerTest {

    @Test
    void testGetAllInterestPoints() {
        given()
          .when().get("/interest-points")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body(is(notNullValue()));
    }

    @Test
    @Transactional
    void testCreateInterestPoint() {
        InterestPointDTO interestPoint = new InterestPointDTO();
        interestPoint.setName("Museum");
        interestPoint.setCoordinateX(40);
        interestPoint.setCoordinateY(73);

        given()
          .contentType(ContentType.JSON)
          .body(interestPoint)
          .when().post("/interest-points")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body("id", notNullValue(), "name", is("Museum"));
    }

    @Test
    @Transactional
    void testCreateAnotherInterestPoint() {
        InterestPointDTO interestPoint = new InterestPointDTO();
        interestPoint.setName("Shopping center");
        interestPoint.setCoordinateX(30);
        interestPoint.setCoordinateY(60);
        given()
          .contentType(ContentType.JSON)
          .body(interestPoint)
          .when().post("/interest-points")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body("id", notNullValue(), "name", is("Shopping center"));
    }

    @Test
    void testGetAllInterestPointsProximity() {
        ProximitySearchDTO params = new ProximitySearchDTO();
        params.setX(40);
        params.setY(73);
        params.setdMax(10);

        given()
          .contentType(ContentType.JSON)
          .queryParam("x", params.getX())
          .queryParam("y", params.getY())
          .queryParam("d-max", params.getdMax())
          .when().get("/interest-points/proximity")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body(is(notNullValue()));
    }
}
package org.marcoantdev.integrations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;
import org.marcoantdev.app.dto.InterestPointDTO;
import org.marcoantdev.app.dto.ProximitySearchDTO;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;

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
  void testCreateInterestPointWithNullName() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName(null);
    interestPoint.setCoordinateX(10);
    interestPoint.setCoordinateY(20);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when()
        .post("/interest-points")
        .then()
        .statusCode(400)
        .contentType(ContentType.JSON)
        .body("parameterViolations[0].message", is("Name cannot be null"));
  }

  @Test
  @Transactional
  void testCreateInterestPointWithNegativeCoordinateX() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Test Point");
    interestPoint.setCoordinateX(-5);
    interestPoint.setCoordinateY(20);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when()
        .post("/interest-points")
        .then()
        .statusCode(400)
        .contentType(ContentType.JSON)
        .body("parameterViolations[0].message", is("Coordinate X must be greater than or equal to zero"));
  }

  @Test
  @Transactional
  void testCreateInterestPointWithNegativeCoordinateY() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Test Point");
    interestPoint.setCoordinateX(10);
    interestPoint.setCoordinateY(-8);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when()
        .post("/interest-points")
        .then()
        .statusCode(400)
        .contentType(ContentType.JSON)
        .body("parameterViolations[0].message", is("Coordinate Y must be greater than or equal to zero"));
  }

  @Test
  @Transactional
  void testCreateInterestPointLanchonete() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Lanchonete");
    interestPoint.setCoordinateX(27);
    interestPoint.setCoordinateY(12);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Lanchonete"));
  }

  @Test
  @Transactional
  void testCreateInterestPointPosto() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Posto");
    interestPoint.setCoordinateX(31);
    interestPoint.setCoordinateY(18);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Posto"));
  }

  @Test
  @Transactional
  void testCreateInterestPointJoalheria() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Joalheria");
    interestPoint.setCoordinateX(15);
    interestPoint.setCoordinateY(12);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Joalheria"));
  }

  @Test
  @Transactional
  void testCreateInterestPointFloricultura() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Floricultura");
    interestPoint.setCoordinateX(19);
    interestPoint.setCoordinateY(21);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Floricultura"));
  }

  @Test
  @Transactional
  void testCreateInterestPointPub() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Pub");
    interestPoint.setCoordinateX(12);
    interestPoint.setCoordinateY(8);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Pub"));
  }

  @Test
  @Transactional
  void testCreateInterestPointSupermercado() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Supermercado");
    interestPoint.setCoordinateX(23);
    interestPoint.setCoordinateY(6);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Supermercado"));
  }

  @Test
  @Transactional
  void testCreateInterestPointChurrascaria() {
    InterestPointDTO interestPoint = new InterestPointDTO();
    interestPoint.setName("Churrascaria");
    interestPoint.setCoordinateX(28);
    interestPoint.setCoordinateY(2);

    given()
        .contentType(ContentType.JSON)
        .body(interestPoint)
        .when().post("/interest-points")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("id", notNullValue(), "name", is("Churrascaria"));
  }

  @Test
  void testGetAllInterestPointsProximity() {
    ProximitySearchDTO params = new ProximitySearchDTO();
    params.setX(20);
    params.setY(10);
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
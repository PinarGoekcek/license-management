package de.hse.gruppe8.jaxrs.resources.security;


import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
public class SecurityInterceptorTest {

    @Test
    void requestWithNoJWTToken() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/companies")
                .then()
                .statusCode(401);
    }

    @Test
    void requestWithJWTToken() {
        //Token expirat at 31.12.2040
        final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjIyNDA2MDc2MDAsImlhdCI6MTY1MjczMjc4MCwiaXNzIjoibGljZW5zZS1tYW5hZ2VtZW50Iiwic3ViIjoidXNlcnRva2VuIiwidWlkIjoxfQ.7cgC15qQ1lI9MJGXx6UyLtD6PkJHJkQ_18dBgIUAF1U";
        given().contentType(ContentType.JSON)
                .when()
                .header("Authorization", "Bearer " + token)
                .get("/companies")
                .then()
                .statusCode(200);
    }


    @Test
    void testUserSecurityContext() {
        //Given
        final Long userId = 1337L;

        //When
        UserSecurityContext userSecurityContext = new UserSecurityContext(userId);

        //Then
        assertEquals(userId, Long.valueOf(userSecurityContext.getUserPrincipal().getName()));
        assertFalse(userSecurityContext.isSecure());
        assertFalse(userSecurityContext.isUserInRole("role"));
        assertEquals("Bearer", userSecurityContext.getAuthenticationScheme());

    }

}
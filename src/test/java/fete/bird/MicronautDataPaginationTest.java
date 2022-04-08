package fete.bird;

import fete.bird.entity.Discount;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MicronautDataPaginationTest extends TestContainerFixture{
    protected HttpRequest request;

    @Inject
    @Client("/")
    protected HttpClient client;

    @Test
    @DisplayName("Should return the discount for discount code")
    void shouldReturnTheDiscountForDiscountCode() {

        // Given
        Discount discountModel = new Discount(null, "Discout-code");
        request = HttpRequest.POST("/discount", discountModel);
        HttpResponse<Discount> rsp = client.toBlocking().exchange(request, Discount.class);
        assertEquals(rsp.getStatus(), HttpStatus.OK);

        // When
        request = HttpRequest.GET(String.format("%s","/discount"));
        HttpResponse<List<Discount>> crsp = client.toBlocking().exchange(request, List.class);

        // Then
        assertEquals(crsp.getStatus(), HttpStatus.OK);
        assertTrue(crsp.body().stream().count() > 0);
    }

}

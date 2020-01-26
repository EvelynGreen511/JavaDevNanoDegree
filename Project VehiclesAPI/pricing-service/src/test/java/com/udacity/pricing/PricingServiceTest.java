package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={PricingServiceApplication.class})
public class PricingServiceTest {

    @MockBean
    private PricingController pricingController;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getPrice() throws Exception {

        String url = "http://localhost:8082/services/price/?vehicleId=1";

        ResponseEntity<Price> response = this.restTemplate.getForEntity(url, Price.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}

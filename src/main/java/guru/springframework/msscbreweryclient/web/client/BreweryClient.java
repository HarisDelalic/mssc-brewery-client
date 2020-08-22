package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {
    public final String BEER_PATH_V1 = "/api/v1/beers/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(BeerDto beerDto) {
        restTemplate.put(apihost + BEER_PATH_V1 + beerDto.getId(), beerDto);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId);
    }

    public String getApihost() {
        return apihost;
    }
}

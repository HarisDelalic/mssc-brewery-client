package guru.springframework.msscbreweryclient.mappers;

import guru.springframework.msscbreweryclient.domain.Beer;
import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}

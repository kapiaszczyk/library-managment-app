package dev.kapiaszczyk.bookstore.library.cityTest;

import dev.kapiaszczyk.bookstore.library.city.City;
import dev.kapiaszczyk.bookstore.library.city.CityRepository;
import dev.kapiaszczyk.bookstore.library.cityCode.CityCode;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    private City city;
    private CityCode cityCode;

    @BeforeEach
    public void setUp() {
        city = new City();
        city.setCityName("Test city");
        cityRepository.save(city);

        cityCode = new CityCode();
        cityCode.setCityCode("12-345");
        cityCode.setCity(city);
        city.addCityCode(cityCode);

        cityRepository.save(city);
    }

    @Test
    public void shouldFindCityByCityName() {
        City foundCity = cityRepository.findByCityName(city.getCityName());

        assertNotNull(foundCity);
        assertThat(foundCity.getCityName(), equalTo(city.getCityName()));
    }

}

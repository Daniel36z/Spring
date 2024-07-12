package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



class IndependencyControllerTest {

    @Autowired
    CountryResponse countryResponse;

    @Autowired
    Optional<Country> country;

    //interceptamos la solicitud a la DB con mockito
    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);

    @Autowired
    DiferenciaEntreFechas  diferenciaEntreFechas = new DiferenciaEntreFechas();

    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock,diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        //Se crea un objeto de tipo respuesta mock
        Country mockCountry = new Country();
        mockCountry.setCountryName("Bolivia");
        mockCountry.setCountryCapital("Sucre");
        mockCountry.setCountryIdependenceDate("06/08/1825");
        mockCountry.setIsoCode("BO");
        mockCountry.setCountryId((long)1);

        //se atiende la request y se le da una respuesta correspondiente
        //al tipo empleando el objeto simulado mock
        Mockito.when(countryRepositoryMock.findCountryByIsoCode("BO")).thenReturn(mockCountry);
    }

    @Test
    void getCountryDetails() {
        ResponseEntity<CountryResponse> respuestaService;
        respuestaService = independencyController.getCountryDetails("BO");

       Assertions.assertEquals("Bolivia",respuestaService.getBody().getCountryName());
    }

    @AfterEach
    void tearDown() {
        System.out.println("fin");
    }

}
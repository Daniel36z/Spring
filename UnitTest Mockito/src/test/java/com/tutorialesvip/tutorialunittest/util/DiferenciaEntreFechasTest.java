package com.tutorialesvip.tutorialunittest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;



class DiferenciaEntreFechasTest {

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas;



    @Test
    void calculateYearsOfIndependency() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();

        LocalDate fechaActual = LocalDate.now();
        String fechaPrueba = "06/08/1825";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaPrueba);
        System.out.println(resultado.getMonths());
        System.out.println(resultado.getYears());
        System.out.println(resultado.getDays());

        Assertions.assertEquals(198,resultado.getYears());
        Assertions.assertEquals(11,resultado.getMonths());
        Assertions.assertEquals(6,resultado.getDays());
    }
}
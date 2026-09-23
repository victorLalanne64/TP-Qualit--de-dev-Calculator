package com.victor.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add_devrait_calculer_la_somme_de_deux_int() {
        // GIVEN
        int a = 2;
        int b = 3;

        // WHEN
        int resultat = calculator.add(a, b);

        // THEN
        assertThat(resultat).isEqualTo(5);
    }

    @Test
    void divide_devrait_calculer_le_quotient_de_deux_int() {
        // GIVEN
        int opG = 10;
        int opD = 2;

        // WHEN
        int resultat = calculator.divide(opG, opD);

        // THEN
        assertThat(resultat).isEqualTo(5);
    }
}
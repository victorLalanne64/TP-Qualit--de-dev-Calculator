package com.victor.calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void add_devrait_calculer_la_somme_de_deux_int() {
        // GIVEN
        int a = 2;
        int b = 3;

        // WHEN
        int resultat = Calculator.add(a, b);

        // THEN
        assertThat(resultat).isEqualTo(5);
    }

    @ParameterizedTest(name = "{0} + {1} doit donner {2}")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-2, 2, 0",
            "0, 0, 0",
            "-1, -2, -3"
    })
    void add_parametre_devrait_calculer_la_somme_de_deux_int(int opG, int opD, int attendu) {
        // WHEN
        int resultat = Calculator.add(opG, opD);

        // THEN
        assertThat(resultat).isEqualTo(attendu);
    }

    @Test
    void divide_devrait_calculer_le_quotient_de_deux_int() {
        // GIVEN
        int opG = 10;
        int opD = 2;

        // WHEN
        int resultat = Calculator.divide(opG, opD);

        // THEN
        assertThat(resultat).isEqualTo(5);
    }

    @Test
    void ensembleChiffres_devrait_retourner_les_chiffres_sans_doublons() {
        // GIVEN
        Calculator calc = new Calculator();

        // WHEN
        Set<Integer> resultat = calc.ensembleChiffres(7679);

        // THEN
        assertThat(resultat).containsExactlyInAnyOrder(6, 7, 9);
    }

    @Test
    void divide_devrait_lever_exception_si_division_par_zero() {
        // GIVEN
        int opG = 10;
        int opD = 0;

        // WHEN & THEN
        assertThatThrownBy(() -> Calculator.divide(opG, opD))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void add_devrait_lever_exception_si_overflow() {
        // GIVEN
        int opG = Integer.MAX_VALUE;
        int opD = 1;

        // WHEN & THEN
        assertThatThrownBy(() -> Calculator.add(opG, opD))
                .isInstanceOf(ArithmeticException.class);
    }
}
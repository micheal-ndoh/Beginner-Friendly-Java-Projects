package com.temp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static com.temp.Main.convert;

public class TemperatureConverterTest {

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, convert(0, 'C', 'F'), 0.01);
        assertEquals(212.0, convert(100, 'C', 'F'), 0.01);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, convert(32, 'F', 'C'), 0.01);
        assertEquals(100.0, convert(212, 'F', 'C'), 0.01);
    }



    
    @Test
    public void testCelsiusToKelvin() {
        assertEquals(273.15, convert(0, 'C', 'K'), 0.01);
        assertEquals(373.15, convert(100, 'C', 'K'), 0.01);
    }

    @Test
    public void testKelvinToCelsius() {
        assertEquals(0.0, convert(273.15, 'K', 'C'), 0.01);
        assertEquals(100.0, convert(373.15, 'K', 'C'), 0.01);
    }

    @Test
    public void testFahrenheitToKelvin() {
        assertEquals(273.15, convert(32, 'F', 'K'), 0.01);
        assertEquals(373.15, convert(212, 'F', 'K'), 0.01);
    }

    @Test
    public void testKelvinToFahrenheit() {
        assertEquals(32.0, convert(273.15, 'K', 'F'), 0.01);
        assertEquals(212.0, convert(373.15, 'K', 'F'), 0.01);
    }

    @Test
    public void testSameUnit() {
        assertEquals(100.0, convert(100, 'C', 'C'), 0.01);
        assertEquals(32.0, convert(32, 'F', 'F'), 0.01);
        assertEquals(273.15, convert(273.15, 'K', 'K'), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUnit() {
        convert(100, 'X', 'C');
    }
}

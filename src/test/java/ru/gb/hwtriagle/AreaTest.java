package ru.gb.hwtriagle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.gb.lesson4.WrongTriangleException;

import static ru.gb.lesson4.Functions.areaGeron;

public class AreaTest {
    @Test
    void areaCalculationTest() throws WrongTriangleException {
        Assertions.assertEquals(2.9047375096555625, areaGeron(2, 3, 4));
    }
}

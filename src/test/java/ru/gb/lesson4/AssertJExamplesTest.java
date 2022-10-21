package ru.gb.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class AssertJExamplesTest {
    @Test
    void assertJTest() {
        Assumptions.assumeTrue(2==2);
        //Assumptions.assumeTrue(1==2);
        //Used if we need to check any precondition; If precondition is wrong test will be ignored.

        List<String> stringList = Arrays.asList("test1", "test3", "test5");
        Assertions.assertAll(
                () ->  assertThat(5).isGreaterThan(4).isLessThan(7),
                () -> assertThat(stringList).containsAnyOf("smth", "test1")
        );
        assertThat(new Functions().isPalindrome("1232")).isFalse();
        assertThat(5).isGreaterThan(4).isLessThan(6);
        assertThat(stringList).containsAnyOf("smth", "test1");
    }
}

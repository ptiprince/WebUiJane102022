package ru.gb.lesson4;

//import ch.qos.logback.classic.Logger;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class FunctionsTest {

    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);

    @BeforeAll
    static void beforeAll() {
        System.out.println("Will be implemented once before all the tests");
        logger.info("Will be implemented once before all the tests");
        WebDriverManager.chromedriver().setup();
    }

    // TRACE, DEBUG, INFO, Warn, ERROR - levels of logs
     @BeforeEach
    void beforeEach() {
         logger.error("Will be implemented once before each test");
        System.out.println("Will be implemented once before each test");
    }

    @Test
    @DisplayName("Check using Palindrome word")
    void IsPalindromeTest(){
        boolean result = new Functions().isPalindrome("123321");
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Check using word which contains odd number of symbols")
    void IsPalindromeTest2(){
        boolean result = new Functions().isPalindrome("1234321");
        Assertions.assertEquals(true, result);
    }

   @ParameterizedTest
   @ValueSource(strings = {"543212345", "123454321"})
    @DisplayName("Parametrized check using Palindrome words")
    void IsPalindromeTestParam(String testWord){
        boolean result = new Functions().isPalindrome(testWord);
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @CsvSource({"543212345, true", "123454321, true", "234567, false"})
    @DisplayName("Parametrized check using words Palindrome and non Palindrome")
    void IsPalindrome(String testWord, boolean expextedResult){
        Assertions.assertEquals(expextedResult, new Functions().isPalindrome(testWord));
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    @DisplayName("Compare cat's age")
    void compareCatAge(Cat cat, Integer age) {
       Assertions.assertEquals(cat.getAge(), age);
    }

    private static List<Arguments> catAndAgeDataProvider(){
        return Arrays.asList(
                Arguments.of(new Cat("Test1", 10), 10),
                Arguments.of(new Cat("Test2", 11), 12)
        );
    }

    /* @AfterEach
    void afterEach() {
        System.out.println("Will be implemented once after each test");
    } */

    @AfterAll
    static void afterAll() {
        System.out.println("Will be implemented once after all the tests");
    }
}

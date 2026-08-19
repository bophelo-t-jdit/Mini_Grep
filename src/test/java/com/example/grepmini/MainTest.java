package com.example.grepmini;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Main Test script")
class MainTest {
    // Target test under test
    private Main main;

    @BeforeEach
    void setup() {
        // Runs before every single test case to ensure structural isolation
        main = new Main();
    }

    @AfterEach
    void tearDown() {
        // Clear resources or structural states if necessary
    }

    @Nested
    @DisplayName("Valid Input Scenarios")
    class SuccessTests {

        @Test
        @DisplayName("Should successfully process standard text values")
        void testProcess_Success() {
            // Arrange & Act
            String result = main.process("hello");

            // Assert
            assertNotNull(result, "Result should not be null");
            assertEquals("HELLO", result, "Should convert string inputs to uppercase");
        }

        @Test
        @DisplayName("Should pass multiple property conditions concurrently")
        void testMultipleProperties() {
            // assertAll runs all checks even if one failing case happens early
            assertAll("State boundaries",
                    () -> assertEquals("A", main.process("a")),
                    () -> assertTrue(main.isValidLength("abc"))
            );
        }
    }

    @Nested
    @DisplayName("Invalid Input Scenarios")
    class ExceptionTests {

        @Test
        @DisplayName("Should throw IllegalArgumentException when input string is null")
        void testProcess_ThrowsExceptionOnNull() {
            // Assert error handling logic cleanly
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                main.process(null);
            });

            assertEquals("Input cannot be null", exception.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "   "})
        @DisplayName("Should return true for various empty or blank text variations")
        void testIsBlank_Parameterized(String input) {
            // Bypasses repetitive boilerplate test methods using input matrices
            assertTrue(main.isBlank(input));
        }
    }
}

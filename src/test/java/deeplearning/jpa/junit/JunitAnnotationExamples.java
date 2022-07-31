package deeplearning.jpa.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class JunitAnnotationExamples {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each");
    }

    @Test
    public void testMethod1(){
        System.out.println("Test method1");
    }

    @DisplayName("testMethod2")
    @Test
    public void abc() {
        System.out.println("Test method2");
    }

    @Disabled("Not implemented fully")
    @Test
    public void testMethod3() {
        System.out.println("Test method3");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After Each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @Nested
    public class TestNested {

        @BeforeEach
        public void beforeEach() {
            System.out.println("Inner class : Before Each");
        }

        @Test
        public void testMethod1(){
            System.out.println("Inner class : Test method1");
        }

        @DisplayName("testMethod2")
        @Test
        public void abc() {
            System.out.println("Inner class : Test method2");
        }

        @Disabled("Inner : Not implemented fully")
        @Test
        public void testMethod3() {
            System.out.println("Inner class : Test method3");
        }

        @AfterEach
        public void afterEach() {
            System.out.println("Inner class : After Each");
        }

        @Nested
        public class TestInnerNested {

            @BeforeEach
            public void beforeEach() {
                System.out.println("Inner most class : Before Each");
            }

            @Test
            public void testMethod1(){
                System.out.println("Inner most class : Test method1");
            }

            @DisplayName("testMethod2")
            @Test
            public void abc() {
                System.out.println("Inner most class : Test method2");
            }

            @Disabled("Inner most : Not implemented fully")
            @Test
            public void testMethod3() {
                System.out.println("Inner most class : Test method3");
            }

            @AfterEach
            public void afterEach() {
                System.out.println("Inner most class : After Each");
            }
        }
    }
}

package junit;

import org.junit.jupiter.api.*;

import javax.security.auth.login.Configuration;


public class jUnitTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("test beforeAll");
    }

    @AfterAll
     static void after1All() {
        System.out.println("test beforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("test beforeEach");
    }

    @AfterEach
    void afterAll() {
        System.out.println("test AfterEach");
    }

    @Test
    void junitTest() {
        System.out.println("test junitTest");
        Assertions.assertTrue(3 > 2);
    }
}

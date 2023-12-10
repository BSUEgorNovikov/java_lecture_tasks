import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void fill1() {
        Main obj = new Main();

        Integer[] expected = {0, 1, 4, 9, 16};

        Integer[] arrayToFill = new Integer[5];
        obj.fill(arrayToFill, integer -> integer * integer);

        assertArrayEquals(expected, arrayToFill);
    }

    @Test
    void fill2() {
        Main obj = new Main();

        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer[] arrayToFill = new Integer[11];
        obj.fill(arrayToFill, integer -> integer);

        assertArrayEquals(expected, arrayToFill);
    }

    @Test
    void fill3() {
        Main obj = new Main();

        Double[] expected = {0.01, 1.01, 2.01, 3.01, 4.01, 5.01, 6.01};

        Double[] arrayToFill = new Double[7];
        obj.fill(arrayToFill, integer -> integer + 0.01);

        assertArrayEquals(expected, arrayToFill);
    }

    @Test
    void fill4() {
        Main obj = new Main();

        Double[] expected = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0};

        Double[] arrayToFill = new Double[7];
        obj.fill(arrayToFill, integer -> integer * 0.5);

        assertArrayEquals(expected, arrayToFill);
    }

    @Test
    void fill5() {
        Main obj = new Main();

        Integer[] expected = {0, 2, 8, 18, 32, 50};

        Integer[] arrayToFill = new Integer[6];
        obj.fill(arrayToFill, integer -> (integer + integer) * integer);

        assertArrayEquals(expected, arrayToFill);
    }

    @Test
    void fill6() {
        Main obj = new Main();

        Integer[] expected = {1, 1, 1, 1, 1, 1};

        Integer[] arrayToFill = new Integer[6];
        obj.fill(arrayToFill, integer -> 1);

        assertArrayEquals(expected, arrayToFill);
    }

    @Test
    void fill7() {
        Main obj = new Main();

        Integer[] expected = {0, 50};

        Integer[] arrayToFill = new Integer[2];
        obj.fill(arrayToFill, integer -> integer * 50);

        assertArrayEquals(expected, arrayToFill);
    }
}
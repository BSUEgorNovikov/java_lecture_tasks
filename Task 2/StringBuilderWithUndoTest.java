import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderWithUndoTest {

    @Test
    void appendTest1() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "";

        stringBuilderWithUndo.append("123456789");
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void appendTest2() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "123456789";

        stringBuilderWithUndo.append("123456789");

        stringBuilderWithUndo.append("appended");
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void appendTest3() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "123456789appended";

        stringBuilderWithUndo.append("123456789");

        stringBuilderWithUndo.append("appended");

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void insertTest1() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "_inserted_";

        stringBuilderWithUndo.append("");
        stringBuilderWithUndo.insert(0, "_inserted_");

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void insertTest2() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "123456789";

        stringBuilderWithUndo.append("123456789");
        stringBuilderWithUndo.insert(2, "_inserted_");
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void insertTest3() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "12_inserted_3456789";

        stringBuilderWithUndo.append("123456789");
        stringBuilderWithUndo.insert(2, "_inserted_");

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void replaceTest1() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "replaced";

        stringBuilderWithUndo.append("");
        stringBuilderWithUndo.replace(0, 0, "replaced");

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void replaceTest2() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "12389";

        stringBuilderWithUndo.append("123456789");
        stringBuilderWithUndo.replace(3, 7, "replaced");
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void replaceTest3() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "123replaced89";

        stringBuilderWithUndo.append("123456789");
        stringBuilderWithUndo.replace(3, 7, "replaced");

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void deleteTest1() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "";

        stringBuilderWithUndo.append("_toDelete_");
        stringBuilderWithUndo.delete(0, 10);

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void deleteTest2() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "12_toDelete_3456789";

        stringBuilderWithUndo.append("12_toDelete_3456789");
        stringBuilderWithUndo.delete(2, 12);
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void deleteTest3() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "123456789";

        stringBuilderWithUndo.append("12345_toDelete_6789");
        stringBuilderWithUndo.delete(5, 15);

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void reverseTest1() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "123456789";

        stringBuilderWithUndo.append("123456789");
        stringBuilderWithUndo.reverse();
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void reverseTest2() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "asdfghjkl";

        stringBuilderWithUndo.append("lkjhgfdsa");
        stringBuilderWithUndo.reverse();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }

    @Test
    void reverseTest3() {
        StringBuilderWithUndo stringBuilderWithUndo = new StringBuilderWithUndo();
        String expected = "program";

        stringBuilderWithUndo.append("program");
        stringBuilderWithUndo.reverse();
        stringBuilderWithUndo.undo();

        assertEquals(expected, stringBuilderWithUndo.toString());
    }
}
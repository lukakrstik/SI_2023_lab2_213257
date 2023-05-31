import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void everyBranchTest() {

        RuntimeException exception = assertThrows(RuntimeException.class,() -> SILab2.function(null, null));
        LinkedList<User> Users = new LinkedList<>();

        //1 2 24
        assertEquals("Mandatory information missing!", exception.getMessage());

        Users.add(new User("Petko", "password", "example@mail.com"));

        //1 3 5 6 7 8.1 8.2 9 10 11 8.3 14 15 17 18 19.1 19.2 20 21 24
        assertTrue(SILab2.function(new User("Viktor", "password!", "example2@mail.com"), Users));

        //1 3 4 5 6 15 17 18 23 24
        assertFalse(SILab2.function(new User(null, "pass !", "majmunceitockacom"), Users));

        //1 3 5 6 7 8.1 9 10 11 12 13 8.3 14 15 17 18 19.1 19.2 20 19.3 22 23 24
        assertFalse(SILab2.function(new User("Petko", "password", "example@mail.com"), Users));

        //1 3 5 6 7 8.1 8.2 9 10 12 8.3 14 15 16 24
        assertFalse(SILab2.function(new User("Viktor", "password2", "example@mail.com"), Users));

    }

    @Test
    void multipleCondition() {
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class,() -> SILab2.function(null, null));
        assertEquals("Mandatory information missing!", exception.getMessage());
        exception = assertThrows(RuntimeException.class,() -> SILab2.function(new User("Luka", null, null), null));
        assertEquals("Mandatory information missing!", exception.getMessage());
        exception = assertThrows(RuntimeException.class,() -> SILab2.function(new User("LukaKrstikj", "password!", null), null));
        assertEquals("Mandatory information missing!", exception.getMessage());
        exception = assertThrows(RuntimeException.class,() -> SILab2.function(new User("Krle", "passwooord!", "krle@mail.com"), null));
        assertNotEquals("Mandatory information missing!", exception.getMessage());
    }

}
import model.Human;
import model.Student;
import org.junit.jupiter.api.Test;
import service.ReflectionDemo;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


public class TestReflectionDemo {
    static final Human human1 = new Human("John", "Smith", 21);
    static final Human human2 = new Human("Александра", "Сергеевна", "Алексеева", 18);
    static final Student student1 = new Student("Joey", "Black", 22, "IT");
    static final Student student2 = new Student("Claire", "Windstorm", 20, "Chemistry");
    
    
    @Test
    void testCountHuman() {
        assertAll(
                () -> assertEquals(1, ReflectionDemo.countHuman(Collections.singletonList(human1))),
                () -> assertEquals(2, ReflectionDemo.countHuman(Arrays.asList("word", human1, human2))),
                () -> assertEquals(3, ReflectionDemo.countHuman(Arrays.asList(human1, human2, student1))),
                () -> assertEquals(4, ReflectionDemo.countHuman(Arrays.asList(
                        student2, human1, "", new int[0], human2, student1, Collections.emptyList())))
        );
    }
}

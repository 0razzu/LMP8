import model.Human;
import model.Student;
import org.junit.jupiter.api.Test;
import service.ReflectionDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestReflectionDemo {
    static final Human human1 = new Human("John", "Smith", 21);
    static final Human human2 = new Human("Александра", "Сергеевна", "Алексеева", 18);
    static final Student student1 = new Student("Joey", "Black", 22, "IT");
    static final Student student2 = new Student("Claire", "Windstorm", 20, "Chemistry");
    
    
    @Test
    void testCountHuman() {
        assertAll(
                () -> assertEquals(0, ReflectionDemo.countHuman(Collections.emptyList())),
                () -> assertEquals(0, ReflectionDemo.countHuman(Arrays.asList("", ""))),
                () -> assertEquals(0, ReflectionDemo.countHuman(null)),
                () -> assertEquals(1, ReflectionDemo.countHuman(Collections.singletonList(human1))),
                () -> assertEquals(2, ReflectionDemo.countHuman(Arrays.asList("word", human1, human2))),
                () -> assertEquals(3, ReflectionDemo.countHuman(Arrays.asList(human1, human1, student1))),
                () -> assertEquals(4, ReflectionDemo.countHuman(Arrays.asList(
                        student2, human1, "", new int[0], human2, student1, Collections.emptyList())))
        );
    }
    
    
    @Test
    void testGetPublicMethodNames() {
        List<String> methodNames1 = ReflectionDemo.getPublicMethodNames(human1);
        List<String> methodNames2 = ReflectionDemo.getPublicMethodNames(student1);
        List<String> methodNames3 = ReflectionDemo.getPublicMethodNames(student2);
        List<String> methodNames4 = ReflectionDemo.getPublicMethodNames(Collections.emptyList());
        
        Collections.sort(methodNames1);
        Collections.sort(methodNames2);
        Collections.sort(methodNames3);
        Collections.sort(methodNames4);
        
        assertAll(
                () -> assertEquals(Arrays.asList(
                        "clone", "equals", "getAge", "getClass", "getFirstName", "getPatronymicName", "getSecondName",
                        "hashCode", "notify", "notifyAll", "setAge", "setFirstName", "setPatronymicName", "setSecondName",
                        "toString", "wait"
                ), methodNames1),
                () -> assertEquals(Arrays.asList(
                        "clone", "equals", "getAge", "getClass", "getDepartment",
                        "getFirstName", "getPatronymicName", "getSecondName", "hashCode", "notify", "notifyAll",
                        "setAge", "setDepartment", "setFirstName", "setPatronymicName", "setSecondName",
                        "toString", "wait"
                ), methodNames2),
                () -> assertEquals(methodNames2, methodNames3),
                () -> assertEquals(Arrays.asList(
                        "add", "addAll", "clear", "contains", "containsAll", "equals", "forEach", "get", "getClass",
                        "hashCode", "indexOf", "isEmpty", "iterator", "lastIndexOf", "listIterator", "notify", "notifyAll",
                        "parallelStream", "remove", "removeAll", "removeIf", "replaceAll", "retainAll", "set", "size",
                        "sort", "spliterator", "stream", "subList", "toArray", "toString", "wait"
                ), methodNames4),
                () -> assertEquals(Collections.emptyList(), ReflectionDemo.getPublicMethodNames(null))
        );
    }
}

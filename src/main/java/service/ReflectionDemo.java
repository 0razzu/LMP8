package service;


import model.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ReflectionDemo {
    public static int countHuman(List<Object> objects) {
        int counter = 0;
        
        if (objects != null)
            for (Object o: objects)
                if (o instanceof Human)
                    counter++;
        
        return counter;
    }
    
    
    public static List<String> getPublicMethodNames(Object object) {
        Set<String> methodNames = new HashSet<>();
        
        if (object != null)
            for (Method m: object.getClass().getMethods())
                if (Modifier.isPublic(m.getModifiers()))
                    methodNames.add(m.getName());
        
        return new ArrayList<>(methodNames);
    }
}

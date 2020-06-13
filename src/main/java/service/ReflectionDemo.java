package service;


import model.Human;

import java.util.List;


public class ReflectionDemo {
    public static int countHuman(List<Object> objects) {
        int counter = 0;
        
        if (objects != null)
            for (Object o: objects)
                if (o instanceof Human)
                    counter++;
        
        return counter;
    }
}

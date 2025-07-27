package com.javatpoint.microservice.springjavaprogram.DesignPatterns.Behavioural;

/*
   Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility
      -->  Iterator
                -> provides a way to access elements of a collection sequentially without exposing its underlying representation.
                -> Provide a uniform way to iterate over a collection of objects.

      --> Real-world Examples
                -> Java Collections (ArrayList, HashSet) using .iterator()
                -> Cursor traversal in databases
                -> XML DOM traversal

      --> Benefits
                -> Uniform traversal without exposing internal structure
                -> Can create multiple iterators on same collection
                -> Decouples traversal logic from collection implementation
*/

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args) {
        System.out.println("Behavioural Design Patterns  -->  Deals with Object interaction & Responsibility");
        System.out.println();
        System.out.println("Behavioural Design Pattern Examples -> Iterator");
        System.out.println("Java Built-in Iterator");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Java Custom Iterator Implementation");
            NameRepository repo = new NameRepository();
            MyIterator iterator2 = repo.createIterator();

            while (iterator2.hasNext()) {
                System.out.println(iterator2.next());
            }



    }
}

interface MyIterator {
    boolean hasNext();
    Object next();
}

interface MyCollection {
    MyIterator createIterator();
}

class NameRepository implements MyCollection {
    public String[] names = {"Alice", "Bob", "Charlie"};

    @Override
    public MyIterator createIterator() {
        return new NameIterator();
    }

    private class NameIterator implements MyIterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}






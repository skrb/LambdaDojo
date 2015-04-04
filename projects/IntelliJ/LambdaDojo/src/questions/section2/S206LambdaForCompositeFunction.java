package questions.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S206LambdaForCompositeFunction {

    static class Person {

        private String first;
        private String last;

        public Person(String first, String last) {
            this.first = first;
            this.last = last;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }
        
        public String toString() {
            return "[" + first + " " + last + "]";
        }
    }

    public S206LambdaForCompositeFunction() {
        sortPerson();
    }

    private void sortPerson() {
        List<Person> persons = Arrays.asList(
                new Person("James", "Brown"),
                new Person("David", "Crosby"),
                new Person("James", "Taylor"),
                new Person("Jackson", "Brown"),
                new Person("Neil", "Young"),
                new Person("Coco", "Taylor")
        );

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // 姓で比較
                String last1 = p1.getLast();
                String last2 = p2.getLast();
                int result = last1.compareTo(last2);

                if (result != 0) {
                    return result;
                } else {
                    // 姓が同じ場合、名で比較
                    String first1 = p1.getFirst();
                    String first2 = p2.getFirst();
                    return first1.compareTo(first2);
                }
            }
        };

        Collections.sort(persons, comparator);
        System.out.println(persons);
    }

    public static void main(String... args) {
        new S206LambdaForCompositeFunction();
    }
}

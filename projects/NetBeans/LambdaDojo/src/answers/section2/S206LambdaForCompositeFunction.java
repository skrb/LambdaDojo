package answers.section2;

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
        sortPersonAnswer1();
        sortPersonAnswer2();
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

    private void sortPersonAnswer1() {
        List<Person> persons = Arrays.asList(
                new Person("James", "Brown"),
                new Person("David", "Crosby"),
                new Person("James", "Taylor"),
                new Person("Jackson", "Brown"),
                new Person("Neil", "Young"),
                new Person("Coco", "Taylor")
        );

        // 単純に Lambda 式で置き換え
        // 順序づけが分かりにくいのは、匿名クラスの場合と同じ
        Comparator<Person> comparator = (p1, p2) -> {
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
        };

        Collections.sort(persons, comparator);
        System.out.println(persons);
    }

    private void sortPersonAnswer2() {
        List<Person> persons = Arrays.asList(
                new Person("James", "Brown"),
                new Person("David", "Crosby"),
                new Person("James", "Taylor"),
                new Person("Jackson", "Brown"),
                new Person("Neil", "Young"),
                new Person("Coco", "Taylor")
        );

        // 姓で比較するコンパレータ
        Comparator<Person> comparatorLast = (p1, p2) -> {
            String last1 = p1.getLast();
            String last2 = p2.getLast();
            return last1.compareTo(last2);
        };

        // 名で比較するコンパレータ
        Comparator<Person> comparatorFirst = (p1, p2) -> {
                String first1 = p1.getFirst();
                String first2 = p2.getFirst();
                return first1.compareTo(first2);
        };

        // 姓で比較するコンパレータと、名で比較するコンパレータを組み合わせる
        Comparator<Person> comparator = comparatorLast.thenComparing(comparatorFirst);

        Collections.sort(persons, comparator);
        System.out.println(persons);
    }

    public static void main(String... args) {
        new S206LambdaForCompositeFunction();
    }
}

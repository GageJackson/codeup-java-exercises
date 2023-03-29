import java.util.Arrays;

public class ArrayExercises {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        int numberOfPeople = 3;
        Person person1 = new Person("Gage");
        Person person2 = new Person("Hubert");
        Person person3 = new Person("Rynda");

        Person [] people = {person1,person2,person3};

        Person [] peeps = new Person[numberOfPeople];

        peeps[0] = person3;
        peeps[1] = person1;
        peeps[2] = person2;

        System.out.println(peeps[0]);
        System.out.println(peeps[1]);
        System.out.println(peeps[2]);

        System.out.println(people[0].getName());
        System.out.println(people[1].getName());
        System.out.println(people[2].getName());

    }
}

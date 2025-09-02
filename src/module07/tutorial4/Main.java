package module07.tutorial4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static module07.tutorial4.ContactType.EMAIL;
import static module07.tutorial4.ContactType.PHONE;
import static module07.tutorial4.Sex.FEMALE;
import static module07.tutorial4.Sex.MALE;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers());

        var values = users.stream()
                .filter(u -> u.sex() == FEMALE)
                .collect(Collectors.toMap(User::name, user -> user));

        values.forEach((key, value) -> System.out.printf("key: %s | value: %s \n", key, value));

    }

    private static List<User> generateUsers(){
        var contacts1 = List.of(
                new Contact("(19)90665-8104", PHONE),
                new Contact("joao@gmail.com", EMAIL)
        );
        var contacts2 = List.of(
                new Contact("(21)92121-9032", PHONE)
        );
        var contacts3 = List.of(
                new Contact("lucas@outlook.com", EMAIL)
        );
        var contacts4 = List.of(
                new Contact("andreia@outlook.com", EMAIL),
                new Contact("andreia@gmail.com", EMAIL)
        );
        var contacts5 = List.of(
                new Contact("(31)93823-8932", PHONE),
                new Contact("(31)92115-0011", PHONE)
        );

        var user1 = new User("João", 26, MALE, new ArrayList<>(contacts1));
        var user2 = new User("Maria", 28, FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Lucas", 19, MALE, new ArrayList<>(contacts3));
        var user4 = new User("Andreia", 40, FEMALE, new ArrayList<>(contacts4));
        var user5 = new User("Vitor", 30, MALE, new ArrayList<>(contacts5));
        var user6 = new User("Bruna", 36, FEMALE, new ArrayList<>());


        return List.of(user1, user2, user3, user4, user5, user6);
    }

}

package module06.tutorial2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<User> users = new TreeSet<>(Comparator.comparingInt(User::getId).reversed());
        users.add(new User(1, "Jão"));
        users.add(new User(4, "Leo"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "Juca"));
        System.out.println(users);

        /* Binary Tree - TreeSet

        Input(n): 80

        100
        /  \
       50  120
       / \
      25 80


       */



    }

}

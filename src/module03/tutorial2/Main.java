package module03.tutorial2;

public class Main {

    public static void main(String[] args){
        var person = new Person("João");
        System.out.println(person.getInfo()); // custom method
        System.out.println(person.name()); // auto-generated getter
    }

}

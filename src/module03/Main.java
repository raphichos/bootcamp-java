package module03;

public class Main {


    public static void main(String[] args) {
        var male = new Person("João");
        male.incAge();
        var female = new Person("Maria");
        System.out.println("Male name: " + male.getName() + " age: " + male.getAge());
        System.out.println("Female name: " + female.getName() + " age: " + female.getAge());
    }

}

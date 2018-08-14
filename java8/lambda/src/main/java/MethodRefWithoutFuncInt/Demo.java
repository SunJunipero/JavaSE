package MethodRefWithoutFuncInt;

public class Demo {

    static String nameAndPosition(FuncInt f, String position, Person person ){
        return f.func(person) + " " + position;
    }

    static String addPosition(FI f, String str){
        return f.func(str);
    }

    public static void main(String[] args) {
        System.out.println(nameAndPosition(Person::getName, "middle", new Person("Alex")));

        Person william = new Person("William");

        System.out.println(addPosition(william::addPosition, "boss"));
    }
}

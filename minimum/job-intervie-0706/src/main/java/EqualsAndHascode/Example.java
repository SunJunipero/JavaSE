package EqualsAndHascode;

import java.util.Objects;

public class Example {
    public static void main(String[] args) {
        Box box = new Box(1, 3);
        Box refBox = box;
        Box box1 = new Box(1, 3);

        System.out.println(box.equals(box1));
        System.out.println(box.equals(refBox));

        System.out.println(box.hashCode() == box1.hashCode());


    }
}

class Box{
    int a;
    int b;

    public Box(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o )
            return true;
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        if(a != ((Box) o).a)
            return false;
        if(b != ((Box) o).b)
            return false;
        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b);
    }
}

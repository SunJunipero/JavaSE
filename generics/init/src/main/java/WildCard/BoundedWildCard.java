package WildCard;

public class BoundedWildCard {
    static void showXY(Coords<?> coords){
        for (int i = 0; i < coords.points.length; i++) {
            System.out.println(coords.points[i].x + " " + coords.points[i].y);
        }
    }

    static void showXYZ(Coords<? extends Point_3D> coords){
        for (int i = 0; i < coords.points.length; i++) {
            System.out.println(coords.points[i].x + " " + coords.points[i].y + " " + coords.points[i].z);
        }
    }
    public static void main(String[] args) {
        Point_2D point_2D = new Point_2D(1, 2);
        Point_2D point_2D1 = new Point_2D(4, 5);
        Point_2D point_2D2 = new Point_2D(6, 5);
        Point_3D point_3D = new Point_3D(5, 6, 1);
        Point_3D point_3D1 = new Point_3D(9, 3, 1);
        Point_4D point_4D = new Point_4D(5, 7, 7, 3);
        Point_4D point_4D1 = new Point_4D(4, 7, 6, 6);

        Point_2D[] points = {point_2D, point_2D1, point_2D2, point_3D, point_3D1, point_4D, point_4D1};
        Point_3D[] point_3DS = {point_3D, point_3D1, point_4D, point_4D1};

        Coords<Point_2D> point_2DCoords = new Coords<>(points);
        System.out.println("\t\t2D");
        showXY(point_2DCoords);
        Coords<Point_3D> point_2DCoords1 = new Coords<>(point_3DS);
        System.out.println("\t\t3D");
        showXYZ(point_2DCoords1);
        showXY(point_2DCoords1);

    }
}

class Point_2D {
    int x;
    int y;

    Point_2D(int x, int y){
        this.x = x;
        this.y = y;
    }

}

class Point_3D extends Point_2D{
    int z;

    Point_3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
}

class Point_4D extends Point_3D{
    int t;

    Point_4D(int x, int y, int z, int t){
        super(x, y, z);
        this.t = t;
    }
}

class Coords<T extends Point_2D>{
    T[] points;

    Coords(T[] arr){
        points = arr;
    }
}
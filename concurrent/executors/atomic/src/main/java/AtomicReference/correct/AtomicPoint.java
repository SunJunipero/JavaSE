package AtomicReference.correct;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicPoint {

    private static class Point{
        final int x;
        final int y;

        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        Point clockWise(){
            return new Point(y, -x);
        }

        @Override
        public String toString() {
            return "x=" + x +" y=" + y;
        }
    }

    private final AtomicReference<Point> point = new AtomicReference<>(new Point(0, 1));

   public void clockWise(){
       point.updateAndGet(Point::clockWise);
       System.out.println(point.get());
   }

}

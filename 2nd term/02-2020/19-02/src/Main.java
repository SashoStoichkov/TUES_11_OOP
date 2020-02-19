import com.oop.*;

public class Main {

    public static void main(String[] args) {
        String expr = "";

        for (String arg : args) {
            expr += arg + " ";
        }

        Point A = new Point(Double.parseDouble(String.valueOf(expr.charAt(0))), Double.parseDouble(String.valueOf(expr.charAt(2))));
        Point B;

        if (expr.length() > 6) {
            B = new Point(Double.parseDouble(String.valueOf(expr.charAt(4))), Double.parseDouble(String.valueOf(expr.charAt(6))));

            if (args.length == 3) {
                System.out.println("Triangle");

                Point C = new Point(Double.parseDouble(String.valueOf(expr.charAt(8))), Double.parseDouble(String.valueOf(expr.charAt(10))));

                Triangle t = new Triangle(A, B, C);

                System.out.println("Perimeter = " + t.getPerimeter());
                System.out.println("Area = " + t.getArea());
            } else if (args.length == 2) {
                System.out.println("Rectangle");

                Rectangle r = new Rectangle(A, B);

                System.out.println("Perimeter = " + r.getPerimeter());
                System.out.println("Area = " + r.getArea());
            }
        } else {
            System.out.println("Circle");

            Circle c1 = new Circle(A, Double.parseDouble(String.valueOf(expr.charAt(4))));

            System.out.println("Perimeter = " + c1.getPerimeter());
            System.out.println("Area = " + c1.getArea());

        }
    }
}

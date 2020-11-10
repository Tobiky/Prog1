

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.System.out;

class EnTriangelOchDessCirklar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.println("Skriv in triangelns sidor:");

        out.print("A: ");
        double a = in.nextDouble();

        out.print("B: ");
        double b = in.nextDouble();

        out.print("C: ");
        double c = in.nextDouble();

        if (a >= b + c || b >= a + c || c >= a + b)
            out.println("Invalid input: Collective inputs must form a valid triangle");
        else {
            double incircleRadius = Triangel.incircleRadius(a, b, c);
            double excircleRadius = Triangel.circumcircleRadius(a, b, c);


            DecimalFormat formater = new DecimalFormat("0.000");

            out.println("Omskrivna cirkelradius: " + formater.format(excircleRadius)
                    + "   Inskrivna cirkelradius: " + formater.format(incircleRadius));
        }
    }
}

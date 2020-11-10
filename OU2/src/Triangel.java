class Triangel {
    // https://en.wikipedia.org/wiki/Incircle_and_excircles_of_a_triangle#Radius
    // https://www.mathalino.com/reviewer/plane-geometry/centers-of-a-triangle#incenter
    // https://en.wikipedia.org/wiki/Triangle#Using_trigonometry
    public static double incircleRadius(double sideA, double sideB, double sideC){
        double s = (sideA + sideB + sideC) / 2;
        double p = s * (s - sideA) * (s - sideB) * (s - sideC);
        double radius = Math.sqrt(p) / s;

        return radius;
    }

    // https://en.wikipedia.org/wiki/Law_of_sines
    // https://math.stackexchange.com/a/2226359
    public static double circumcircleRadius(double sideA, double sideB, double sideC) {

        // Calcluating alfa
        // https://en.wikipedia.org/wiki/Law_of_cosines
        // c^2 = a^2 + b^2 - 2ab*cos(alfa)
        // (c^2 - a^2 - b^2) / -2ab = cos(alfa)
        double p = Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2) ;
        double q = 2 * sideB * sideC;
        double alfa = Math.acos(p / q);

        // Calculating the radius
        double radius =  sideA / Math.sin(alfa) / 2;
        return radius;
    }
}

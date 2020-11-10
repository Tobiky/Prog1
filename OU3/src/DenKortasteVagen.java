public class DenKortasteVagen {
    // mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
    // vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
    // av den andra mellanstationen på index 2 i vektorn.
    public static int[] mellanstationer (double[] a, double[][] b, double[] c)
    {
        int[] stationIndexi = new int[2];
        double length = Double.POSITIVE_INFINITY;

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b[i].length; j++){

                double currentLength = a[i] + b[i][j] + c[j];

                if (currentLength < length) {
                    length = currentLength;
                    stationIndexi[0] = i;
                    stationIndexi[1] = j;
                }
                // for (int k = 0; k < c.length; k++){

                // }
            }
        }
        return stationIndexi;
    }

    // langd returnerar längden av den kortaste vägen.
    public static double langd (double[] a, double[][] b, double[] c)
    {
        int[] stations = mellanstationer(a, b, c);
        return a[stations[0]] + b[stations[0]][stations[1]] + c[stations[1]];
    }
}

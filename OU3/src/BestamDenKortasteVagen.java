import javafx.beans.binding.When;
import org.omg.CORBA.WStringSeqHelper;

import java.lang.invoke.ConstantCallSite;
import java.util.Random;
import java.util.Scanner;

public class BestamDenKortasteVagen {
    public static void main(String[] args) {
        int m = 7;
        int n = 9;

        double[] a = new double[m];
        double[][] b = new double[m][];
        double[] c = new double[n];

        Random r = new Random();

        for (int i = 0; i < m; i++){
            a[i] = r.nextDouble();
            b[i] = new double[n];

            for (int j = 0; j < n; j++)
                b[i][j] = r.nextDouble();
        }
        for (int i = 0; i < n; i++)
            c[i] = r.nextDouble();

        int[] shortestPathStations = DenKortasteVagen.mellanstationer(a, b, c);
        double shortestPathLength = DenKortasteVagen.langd(a, b, c);

        StringBuilder output = new StringBuilder();
        String format;
        for (int i = 0; i < a.length; i++){
            if (i == shortestPathStations[0]) format = "[%d]*%g*     ";
            else format = "[%d]%g     ";

            output.append(String.format(format, i+1, a[i]));

            for (int j = 0; j < b[i].length; j++) {
                if (j == shortestPathStations[1] && i == shortestPathStations[0]) format = "[%d]*%g*,  ";
                else format = "[%d]%g,  ";

                output.append(String.format(format, j+1, b[i][j]));
            }
            output.append('\n');
        }

        System.out.println(output.toString());
        output.delete(0, output.length() - 1);

        for (int i = 0; i < n; i++) {
            if (i == shortestPathStations[1]) format = "[%d]*%g*\n";
            else format = "[%d]%g\n";
            output.append(String.format(format, i+1, c[i]));
        }

        System.out.println(output.toString());

        System.out.println(String.format("Stations: [%d] [%d]", shortestPathStations[0]+1, shortestPathStations[1]+1));
        System.out.println(String.format("Total length: %g", shortestPathLength));

        Scanner in = new Scanner(System.in);
        String input;
        while ( (input = in.nextLine()) != "e") {
            int aIndex = Integer.parseInt(input.charAt(0) + "") - 1;
            int bIndex = Integer.parseInt(input.charAt(1) + "") - 1;
            System.out.println(String.format("Length: %f", a[aIndex] + b[aIndex][bIndex] + c[bIndex]));
        }
    }
}

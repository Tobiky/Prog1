import java.text.DecimalFormat;
import java.util.*; // Scanner, Locale

class Temperaturer {
    public static void main(String[] args) {
        System.out.println("TEMPERATURER\n");

        // inmatningsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print("antalet veckor: ");
        int antalVeckor = in.nextInt();
        System.out.print("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();

        // plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            System.out.println("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble();
        }
        System.out.println();

        // visa temperaturerna
        System.out.println("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.print(t[vecka][matning] + " ");
            System.out.println();
        }
        System.out.println();

        // den minsta, den största och medeltemperaturen – veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];
        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];

        // koden ska skrivas här
        for (int i = 1; i < t.length; i++){
            double veckaMax = t[i][1];
            double veckaMin = t[i][1];
            double veckaSum = 0;

            for (int j = 1; j < t[i].length; j++){
                if (veckaMax < t[i][j]) veckaMax = t[i][j];
                if (veckaMin > t[i][j]) veckaMin = t[i][j];
                veckaSum += t[i][j];
            }
            maxT[i] = veckaMax;
            minT[i] = veckaMin;
            sumT[i] = veckaSum;
            medelT[i] = veckaSum / (t[i].length - 1);
        }

        DecimalFormat formatering = new DecimalFormat("0.0");

        // visa den minsta, den största och medeltemperaturen för varje vecka
        // koden ska skrivas här
        // minT.length = maxT.length = sumT.length = medelT.length
        for (int i = 1; i < minT.length; i++)
            System.out.println("vecka: " + i +
                                " min: " + formatering.format(minT[i]) +
                                " max: " + formatering.format(maxT[i]) +
                                " medel: " + formatering.format(medelT[i]));


        // den minsta, den största och medeltemperaturen - hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = 0;
        double medelTemp = 0;
        // koden ska skrivas här
        // minT.length = maxT.length = sumT.length = medelT.length
        for (int i = 1; i < minT.length; i++){
            if (minTemp > minT[i]) minTemp = minT[i];
            if (maxTemp < maxT[i]) maxTemp = maxT[i];
            sumTemp += sumT[i];
        }
        medelTemp = sumTemp / (antalVeckor * antalMatningarPerVecka);

        // visa den minsta, den största och medeltemperaturen i hela mätperioden
        // koden ska skrivas här
        System.out.println("min: " + formatering.format(minTemp) +
                            " max: " + formatering.format(maxTemp) +
                            " medel: " + formatering.format(medelTemp));
    }
}
import java.util.Random;

import static java.lang.System.out;

class ValjPolylinje
{
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;
    private static final String[] FARGER = new String[] { "blå", "röd", "gul" };

    public static void main (String[] args)
    {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];

        Polylinje shortestYellowLine = new Polylinje();
        double shortestLine = Double.POSITIVE_INFINITY;
        int yellowLines = 0;

        for (int i = 0; i < ANTAL_POLYLINJER; i++){
            Polylinje linje = slumpPolylinje ();

            // visa polylinjerna
            polylinjer[i] = linje;
            out.println(polylinjer.toString());

            // bestäm den kortaste av de polylinjer som är gula
            if (linje.getFarg() == "gul"){
                yellowLines++;

                if (linje.langd() < shortestLine){
                    shortestYellowLine = linje;
                    shortestLine = linje.langd();
                }
            }
        }

        // visa den valda polylinjen
        if (yellowLines == 0)  out.println("Inga gula linjer");
        else                   out.println(shortestYellowLine.toString());

    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt ()
    {
        String n = "" + (char) (65 + rand.nextInt (26));
        int x = rand.nextInt (11);
        int y = rand.nextInt (11);
        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];

        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char valtChar = 0;
        while (antalValdaHorn < antalHorn)
        {
            int namnIndex;
            do {
                valdPunkt = slumpPunkt();
                namnIndex = (int)valdPunkt.getNamn().charAt(0) - 65 - 1;
            }
            while (!valdaNamn[namnIndex]);

            valdaNamn[namnIndex] = true;
            polylinje.laggTill(valdPunkt);
            antalValdaHorn++;
        }

        // sätt färg
        polylinje.setFarg(FARGER[rand.nextInt(2)]);

        return polylinje;
    }
}
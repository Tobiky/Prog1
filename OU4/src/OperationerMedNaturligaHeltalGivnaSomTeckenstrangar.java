import java.util.*; // Scanner
import static java.lang.System.out;
class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
    public static void main (String[] args)
    {
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        // mata in två naturliga heltal
        Scanner in = new Scanner (System.in);
        out.println ("två naturliga heltal:");
        String tal1 = in.next ();
        String tal2 = in.next ();
        out.println ();

        // addera heltalen och visa resultatet
        String summa = addera (tal1, tal2);
        visa (tal1, tal2, summa, '+');


        // subtrahera heltalen och visa resultatet
        String skillnad = subtrahera (tal1, tal2);
        visa (tal1, tal2, skillnad, '-');
    }


    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2)
    {
        StringBuilder resultat = new StringBuilder();
        // Skillnaden av längderna
        int lengthDiff = Math.abs(tal1.length() - tal2.length());

        String padString;
        {
            char[] padCharacters = new char[lengthDiff];
            Arrays.fill(padCharacters, '0');
            padString = new String(padCharacters);
        }


        if (tal1.length() < tal2.length())  tal1 = padString + tal1;
        else                                tal2 = padString + tal2;

        int carry = 0, res;

        for (int i = tal1.length() - 1; i >= 0; i--) {
            char tecken1 = tal1.charAt(i), tecken2 = tal2.charAt(i);

            int teckenVarde1 = Character.digit(tecken1, 10), teckenVarde2 = Character.digit(tecken2, 10);

            res = teckenVarde1 + teckenVarde2 + carry;

            carry = res / 10;

            resultat.append(res % 10);
        }

        if (carry != 0) resultat.append(carry);

        return  resultat.reverse().toString();
    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera (String tal1, String tal2)
    {
        StringBuilder resultat = new StringBuilder();

        // Skillnaden av längderna
        int lengthDiff = Math.abs(tal1.length() - tal2.length());

        String padString;
        {
            char[] padCharacters = new char[lengthDiff];
            Arrays.fill(padCharacters, '0');
            padString = new String(padCharacters);
        }

        if (tal1.length() < tal2.length())  tal1 = padString + tal1;
        else                                tal2 = padString + tal2;

        int carry = 0, res;
        for (int i = tal1.length() - 1; i >= 0; i--) {
            res = Character.digit(tal1.charAt(i), 10) - Character.digit(tal2.charAt(i), 10) + carry;

            if (res < 0){
                carry = -1;
                res += 10;
            }
             else
                carry = 0;

             resultat.append( res );
        }

        // Ta bort alla minustecken i mitten av strängen
        for (int i = 0; i < resultat.length() - 1; i++)
            if (resultat.charAt(i) == '-') resultat.deleteCharAt(i);

        return resultat.reverse().toString();
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa (String tal1, String tal2, String resultat, char operator)
    {
        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length ();
        int len2 = tal2.length ();
        int len = resultat.length ();
        int maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen - len1);

        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);

        // visa heltalen och resultatet
        out.println (" " + tal1);
        out.println (operator + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println ();
        out.println (" " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal)
    {
        StringBuilder sb = new StringBuilder (s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");
        return sb.toString ();
    }
}
import static java.lang.System.out;

public class PolylineTest {
    public static void main(String[] args) {
        Punkt c = new Punkt("C", 2, 3);
        Punkt d = new Punkt("D", 5, 1);

        Polylinje pl1 = new Polylinje();

        Punkt[] testHorn = new Punkt[] {
                new Punkt("A", 3, 4),
                new Punkt("B", 5, 6),
        };
        Polylinje pl2 = new Polylinje(testHorn);

        pl1.laggTill(c);
        pl2.laggTill(d);
        pl2.laggTillFramfor(c, "D");
        out.println(String.format("%s", pl2.getHorn()));
        out.println(pl2.toString());

        pl2.taBort("C");
        out.println(pl2.toString());


        out.println(pl2.getFarg());
        pl2.setFarg("pink");
        out.println(pl2.getFarg());

        double langd = pl2.langd();
        out.println(langd);

        out.println(pl2.getBredd());
        pl2.setBredd(2);
        out.println(pl2.getBredd());

        Polylinje.PolylinjeIterator iterator = pl2.iterator();
        while ( iterator.hasNext() )
            out.println(iterator.next());
    }
}

import static java.lang.System.arraycopy;

public abstract class PolyLinjeTemplate {
    // horn är en lista av punkter som definierar polylinjen.
    private Punkt[] horn;

    // farg är en string som beskriver polylinjens farg.
    private String farg = "svart";

    // bredd är en int som beskriver bredden av polylinjens segment
    private int bredd = 1;

    // den tomma constructorn skapar en tom lista av punkter och ger ingen färg eller bredd till polylinjen.
    public PolyLinjeTemplate() {
        this.horn = new Punkt[0];
    }


    // toString skapar och returnerar en string som visar upp polylinje-objektet på ett godtyckligt sätt.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder('{');

        sb.append('[');
        for (int i = 0; i < horn.length; i++)
            sb.append(horn[i].toString());
        sb.append(']');

        sb.append(", ")
                .append(farg)
                .append(", ")
                .append(bredd);

        return sb.append('}').toString();
    }

    // getHorn returnerar (referensen till) punklistan av polylinjen.
    public final Punkt[] getHorn() {
        return horn;
    }

    // getFarg returnerar (referensen till string:en för) färgen av polylinjen.
    public final String getFarg() {
        return farg;
    }

    // getBredd returnerar bredden av polylinjen.
    public final int getBredd() {
        return bredd;
    }

    // setFarg ändrar färgen av polylinjen.
    public final void setFarg(String farg) {
        this.farg = farg;
    }

    // setBredd ändrar bredden av polylinjen.
    public final void setBredd(int bredd) {
        this.bredd = bredd;
    }

    // setHorn ändrar referensen till den inre punktlistan för polylinjen.
    protected final void setHorn(Punkt[] horn) {
        this.horn = horn;
    }

    // langd räknar ut längden av polylinjen vilket är den totala summan av alla linjesegment.
    public double langd() {
        double total = 0;
        for (int i = 0; i < horn.length - 1; i++)
            total += horn[i].avstand(horn[i + 1]);
        return total;
    }

    // laggTill tar in en refferens till en punkt och lägger in en kopia av den punkten i slutet av polylinjen.
    public final void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];

        arraycopy(this.horn, 0, h, 0, this.horn.length);
        h[this.horn.length] = new Punkt(horn);

        this.horn = h;
    }

    // taBort tar in en string som är en punkts namn och tar bort den punkten från polylinjen.
    public final void taBort(String hornNamn) {
        Punkt[] currentHorn = getHorn();
        Punkt[] newHorn = new Punkt[getHorn().length - 1];

        int offset = 0;
        boolean foundHorn = false;
        for (int i = 0; i < currentHorn.length; i++) {
            if (currentHorn[i].getNamn() == hornNamn)
                offset = -1;
            else
                newHorn[i + offset] = currentHorn[i];
        }

        setHorn(newHorn);
    }

    public abstract void laggTillFramfor(Punkt horn, String hornNamn);

}

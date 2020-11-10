import java.util.Iterator;

public class Polylinje extends PolyLinjeTemplate
{
    public Polylinje() {
        super();
    }

    // Constructorn tar in en punkt lista och kopierar den till denna polylinjes instans
    public Polylinje (Punkt[] horn)
    {
        Punkt[] newHorn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            newHorn[i] = new Punkt (horn[i]);

        setHorn(newHorn);
    }


    // laggTillFramfor tar in refferensen till en punkt och namnet av en punkt som ligger i listan.
    // Den reffererarde punkten placeras framför den punkten - med det ansädda namnet - i listan.
    @Override
    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] currentHorn = getHorn(); //this.horn

        Punkt[] newHorn = new Punkt[currentHorn.length + 1];

        int offset = 0;
        for (int i = 0; i < newHorn.length; i++){
            if (i != currentHorn.length && currentHorn[i].getNamn() == hornNamn){
                newHorn[i] = new Punkt(horn);
                offset--;
            } else {
                newHorn[i] = currentHorn[i + offset];
            }
        }

        setHorn(newHorn);
    }

    public PolylinjeIterator iterator(){
        return new PolylinjeIterator();
    }

    public class PolylinjeIterator implements Iterator<Punkt> {
        private int current;
        private final Punkt[] horn;

        public PolylinjeIterator(){
            horn = Polylinje.this.getHorn();
            current = (horn.length > 0) ? 0 : -1;
        }

        @Override
        public boolean hasNext() {
            return current != -1;
        }

        @Override
        public Punkt next() {
            Punkt horn = this.horn[current++];
            if (current == this.horn.length)
                current = -1;
            return  horn;
        }
    }
}
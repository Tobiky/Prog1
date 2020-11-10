public class PolylinjeRef extends PolyLinjeTemplate {

    public PolylinjeRef (Punkt[] horn)
    {
        setHorn(horn);
    }

    @Override
    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Punkt[] newHorn = new Punkt[getHorn().length + 1];

        int offset = 0;
        for (int i = 0; i < getHorn().length; i++){
            if (getHorn()[i + 1].getNamn() == hornNamn){
                newHorn[i] = horn;
                offset = 1;
            } else {
                newHorn[i + offset] = getHorn()[i];
            }
        }

        setHorn(newHorn);
    }

}

public class Punkt {
    private String namn;
    private int x;
    private int y;

    public Punkt(String namn, int x, int y){
        this.namn = namn;
        this.x    = x;
        this.y    = y;
    }
    public Punkt(Punkt annan) {
        namn = annan.namn;
        x    = annan.x;
        y    = annan.y;
    }

    public String getNamn() { return namn; }

    public int getX()       { return x; }
    public void setX(int x) { this.x = x; }

    public int getY()       { return y; }
    public void setY(int y) { this.y = y; }

    public double avstand(Punkt annan) {
        double deltaX = this.x - annan.x;
        double deltaY = this.y - annan.y;

        return Math.sqrt( Math.pow(deltaX, 2.0) + Math.pow(deltaY, 2.0) );
    }

    @Override
    public String toString() {
        return String.format("(%s %d %d)", namn, x, y);
    }
}

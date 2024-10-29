public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y) {
        super(x, y);
    }

    public Point3D(double x, double y, double z) {
        this(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        //return x + ":" + y + ":" + z;
        return super.toString() + ":" + z;
    }

}

public class PolymorphismExample {

    public static void main(String[] args) {
        Object point = new Point(4., 5.);
        System.out.println(point.toString());
        Object point3D = new Point3D(5,6,7);
        System.out.println(point3D);
    }

}

import java.util.ArrayList;

public class Main {
    public static ArrayList<String> cars;

    public static void main(String[] args) {
//        cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        System.out.println(isFull());
//        System.out.println(haveSpace());
//
//        cars.remove(0);
//        cars.remove(0);
//        System.out.println(cars);


        String[] a = new String[3];

        for (int i = 0; i < 3; i++) {
            a[i] = String.valueOf(i);
        }

        System.out.println(a);

    }

    public static boolean isFull() {
        return (cars.size() == 3);
    }

    public static boolean haveSpace() {
        if (!isFull())
                return true;
        return false;
    }
}

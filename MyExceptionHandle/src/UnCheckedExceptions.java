import java.util.ArrayList;
import java.util.List;

public class UnCheckedExceptions {
    public static void main(String[] args) {

        //NullPointerException Örnegi
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }



        //ArrayIndexOutOfBoundsException Örneği
        int[] array = {1, 2, 3};
        try {
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }



        //ArithmeticException Örneği
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }



        //IllegalArgumentException Örneği
        try {
            printAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }



        //NumberFormatException
        String str2 = "abc";
        try {
            int number = Integer.parseInt(str2);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }



        //IndexOutOfBoundsException
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        try {
            System.out.println(list.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }

    }

    public static void printAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Age: " + age);
    }
}

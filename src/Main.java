import java.util.function.Function;

public class Main {
    public <T> void fill(T[] array, Function<Integer, T> valueProvider) {
        for (int i = 0; i < array.length; i++) {
            array[i] = valueProvider.apply(i);
        }
    }

    public static void main(String[] args) {
//        Integer[] arrayToFill = new Integer[5];
//        fill(arrayToFill, integer -> 2* integer * (1 + 34));
//
//        for (Integer value : arrayToFill) {
//            System.out.print(value + " ");
//        }
    }
}
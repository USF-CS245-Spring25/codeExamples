package basics;

public class Main {

    public static boolean areAllUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i != j) && (arr[i] == arr[j]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a1 = {4, 8, 9, 1, 8, 7, 5};
        System.out.println(areAllUnique(a1));
        int[] a2 = {4, 8, 9, 1, 3, 7, 5};
        System.out.println(areAllUnique(a2));
    }
}

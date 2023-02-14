package Coderbyte.Hard;

public class MaxHeapChecker_M {

    static String result = "";

    public static String MaxHeapChecker(int[] arr) {

        exploreTree(arr, 0, -1, 1);

        return result.isEmpty() ? "max" : result.substring(1);
    }


    private static void exploreTree(int[] ints, int start, int offset, int level) {

        if (start >= ints.length) {
            return;
        }

        if (start > 2) {
            level++;
        }

        int parent = start;
        int left = parent + 2 * level + offset;
        int right = parent + 3 * level + offset;

        if (left < ints.length && ints[parent] < ints[left]) {
            result += "," + ints[left];
        }

        if (right < ints.length && ints[parent] < ints[right]) {
            result += "," + ints[right];
        }

        exploreTree(ints, left, 0, level);
        exploreTree(ints, right, 1, level);
    }

    public static void main(String[] args) {
        // additional node appears

//        int[] ints = {73, 74, 75, 7, 2, 107};
//        System.out.println(MaxHeapChecker(ints));

        int[] ints1 = {1, 5, 10, 2, 3, 10, 1};
        System.out.println(MaxHeapChecker(ints1));

        // additional node does not appear
//        int[] ints2 = {10, 19, 52, 13, 16};
//        System.out.println(MaxHeapChecker(ints2));

//        int[] ints3 = {10, 19, 52, 104, 14};
//        System.out.println(MaxHeapChecker(ints3));

//        int[] ints4 = {1, 5, 10, 2, 3};
//        System.out.println(MaxHeapChecker(ints4));
    }

}
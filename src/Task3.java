public class Task3 {
    public static void main(String[] args) {
        arraysBaseAndDriver();
    }

    public static void arraysBaseAndDriver() {
        int[] array = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        int[] array1 = {1, 4, 7, 1, 8, 9, 2, 1, 3, 8, 0};
        int[] array2 = {1, 1, 2, 1, 1, 1};
        int[] array3 = {0, 0, 0, 0};
        int[] array4 = {};

        removeArrDuplicates(array);
        removeArrDuplicates(array1);
        removeArrDuplicates(array2);
        removeArrDuplicates(array3);
        removeArrDuplicates(array4);
    }

    public static int[] removeArrDuplicates(int[] arr1) {
        int i, j, x = arr1.length - 1;
        for (i = arr1.length - 1; i >= 0; i--) {
            for (j = i; j > 0; j--) {
                if (arr1[i] == arr1[j - 1])
                    break;
            }
            if (j == 0)
                arr1[x--] = arr1[i];
        }

        int[] arr2 = new int[arr1.length - x - 1];
        i = 0;
        for (int k = x + 1; k <= arr1.length - 1; k++, i++) {
            arr2[i] = arr1[k];
        }
        return arr2;
    }
}//End of Task3 class.

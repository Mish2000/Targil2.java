public class Task4 {
    public static void main(String[] args) {
        arraysBaseAndDriver();
    }

    public static void arraysBaseAndDriver() {
        int[] array = {3, 7, 20, 17, 14, 5, 2}; // Up and down array.
        int[] array1 = {5, 8, 90, 21, 78, 89, 2, 4}; // Not up and down array.
        int[] array2 = {1, 3, 6, 11, 10, 9, 4, 2, 0}; // Up and down array.
        int[] array3 = {50, 30, 10, 0, -5, 34, 90}; //Not up and down array.
        int[] array4 = {0, 0, 0, 0, 0, 0};//Not up and down array.
        int[] array5 = {1, 1, 1};//Not up and down array.
        int[] array6 = {1, 0, 1, 0, 1, 0};//Not up and down array.

        upAndDownArray(array);
        upAndDownArray(array1);
        upAndDownArray(array2);
        upAndDownArray(array3);
        upAndDownArray(array4);
        upAndDownArray(array5);
        upAndDownArray(array6);
    }

    public static int upAndDownArray(int[] array) {
        int max = array[0];
        int status = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 0; i < indexFind(array, max); i++) {
            if (array[i] <= array[i + 1]) {
                status++;
                break;
            }
        }
        for (int i = array.length - 1; i > indexFind(array, max); i--) {
            if (array[array.length - 2] >= array[array.length - 1]) {
                status++;
                break;
            }
        }
        if (status == 2) {
            return indexFind(array, max);
        }
        return -1;
    }

    public static int indexFind(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }
} //End of Task4 class.

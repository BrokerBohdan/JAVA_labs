public class Lab4 {
    public static void main(String[] args) {
        // Task 1: Min Abs Element
        System.out.println("Task 1: Find minimum absolute element");
        int[] array1 = {3, -7, 4, -2, 0, 10};
        int[] array2 = {15, -8, 5, -1, 9};
        int[] emptyArray = null;

        // Перевірка для першого масиву
        System.out.println("Array 1 Min Abs Element: " + Task1.findMinAbsElement(array1));

        // Перевірка для другого масиву
        System.out.println("Array 2 Min Abs Element: " + Task1.findMinAbsElement(array2));

        // Task 2: Geometric Mean of Even Elements with Indices Divisible by 5
        System.out.println("\nTask 2: Geometric mean of even elements with index divisible by 5");
        int[] array3 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        int[] array4 = {5, 3, 7, 8, 10, 15, 2, 6, 9, 11, 4, 12};
        
        System.out.println("Array 3 Geometric Mean: " + Task2.findGeometricMean(array3));
        System.out.println("Array 4 Geometric Mean: " + Task2.findGeometricMean(array4));

        // Task 3: Modify Array
        System.out.println("\nTask 3: Modify array");
        int[] array5 = {-5, 0, 7, -2, 10};
        int[] array6 = {0, -3, 4, 6, -1};

        System.out.println("Modified Array 5: ");
        Task3.printArray(Task3.modifyArray(array5));

        System.out.println("Modified Array 6: ");
        Task3.printArray(Task3.modifyArray(array6));
    }
}

class Task1 {
    public static int findMinAbsElement(int[] arr) {
        int minElement = arr[0];
        for (int element : arr) {
            if (Math.abs(element) < Math.abs(minElement)) {
                minElement = element;
            }
        }
        return minElement;
    }
}

class Task2 {
    public static double findGeometricMean(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        double product = 1;
        int count = 0;

        for (int i = 0; i < arr.length; i += 5) {
            if (arr[i] % 2 == 0) {
                product *= arr[i];
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("No even elements with indices divisible by 5.");
        }

        return Math.pow(product, 1.0 / count);
    }
}

class Task3 {
    public static int[] modifyArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        int[] modifiedArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                modifiedArray[i] = arr[i] * -1;
            } else if (arr[i] > 0) {
                modifiedArray[i] = arr[i] - 3;
            } else {
                modifiedArray[i] = -2;
            }
        }

        return modifiedArray;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
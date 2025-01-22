package TatarMath;

public class Math {
    public static int pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static void swap(int[] arr, int a, int b) {
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = java.lang.Math.max(max, arr[i]);
        }
        return max;
    }

    public static int maxDex(int[] arr) {
        int max = 0;
        int i = 0;
        do {
            if (arr[i] == max(arr)) {
                max = i;
                break;
            } else {
                i++;
            }
        } while (max(arr) != arr[i]);
        return max;
    }

    public static int minDex(int[] arr) {
        int max = 0;
        int i = 0;
        do {
            if (arr[i] == min(arr)) {
                max = i;
                break;
            } else {
                i++;
            }
        } while (min(arr) != arr[i]);
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = java.lang.Math.min(min, arr[i]);
        }
        return min;
    }

}

package datastructure450.array;

// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

class Pair {
    int min;
    int max;
}

public class MinMaxWithMinimumComparisons {
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 9, 330, 3000};
        Pair minMaxNaive = getMinMaxNaive(arr, arr.length);
        System.out.println("max :" + minMaxNaive.max + " min :" + minMaxNaive.min);
        Pair minMaxBetterSolution = getMinMaxBetterSolution(arr, arr.length);
        System.out.println("max :" + minMaxBetterSolution.max + " min :" + minMaxBetterSolution.min);
    }

    // O(n) time complexity and 1+2(n-2)
    private static Pair getMinMaxBetterSolution(int[] arr, int n) {
        Pair pair = new Pair();
        int i;
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                pair.max = arr[0];
                pair.min = arr[1];
            } else {
                pair.max = arr[1];
                pair.min = arr[0];
            }
            i = 2;
        } else {
            pair.max = arr[0];
            pair.min = arr[0];
            i = 1;
        }
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > pair.max)
                    pair.max = arr[i];
                if (arr[i + 1] < pair.min)
                    pair.min = arr[i + 1];
            } else {
                if (arr[i + 1] > pair.max)
                    pair.max = arr[i + 1];
                if (arr[i] < pair.min)
                    pair.min = arr[i];
            }
            i += 2;
        }
        return pair;
    }

    // O(n) time complexity and 1+2(n-2)
    private static Pair getMinMaxNaive(int[] arr, int n) {
        Pair pair = new Pair();
        if (n == 1) {
            pair.max = arr[0];
            pair.min = arr[0];
        }
        if (arr[0] > arr[1]) {
            pair.max = arr[0];
            pair.min = arr[1];
        } else {
            pair.max = arr[1];
            pair.min = arr[0];
        }
        for (int i = 2; i < n; i++) {
            if (arr[i] > pair.max)
                pair.max = arr[i];
            else if (arr[i] < pair.min)
                pair.min = arr[i];
        }
        return pair;
    }
}

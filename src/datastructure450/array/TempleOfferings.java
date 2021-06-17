package datastructure450.array;

// https://www.geeksforgeeks.org/temple-offerings/

import java.util.ArrayList;

public class TempleOfferings {
    public static void main(String[] args) {
        int[] templeHeight = {1, 4, 3, 6, 2, 1};
        System.out.println(offeringNumber(templeHeight, templeHeight.length));
        System.out.println(offeringNumberBetterSolution(templeHeight, templeHeight.length));

        ArrayList<String> ArrList = new ArrayList<String>();

        // add the values in Array List
        ArrList.add("Item 1");
        ArrList.add("Item 2");
        ArrList.add("Item 3");
        ArrList.add("Item 4");
        ArrList.add("Item 5");
        System.out.println(ArrList);
        String temp=ArrList.get(1);
        ArrList.set(1,ArrList.get(2));
        ArrList.set(2,temp);
        System.out.println(ArrList);
    }

    // O(n*n) time complexity and O(1) space complexity
    private static int offeringNumber(int[] templeHeight, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (templeHeight[j] < templeHeight[j + 1])
                    left++;
                else
                    break;
            }
            for (int j = i + 1; j < n; j++) {
                if (templeHeight[j] < templeHeight[j - 1])
                    right++;
                else
                    break;
            }
            sum += Math.max(left, right) + 1;
        }
        return sum;
    }

    // O(n) time complexity and O(n) space complexity
    private static int offeringNumberBetterSolution(int[] templeHeight, int n) {
        int[] offeringCounts = new int[n];
        int sum = 0;
        offeringCounts[0] = 1;
        for (int i = 1; i < n; i++) {
            if (templeHeight[i] > templeHeight[i - 1])
                offeringCounts[i] = offeringCounts[i - 1] + 1;
            else
                offeringCounts[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (templeHeight[i] > templeHeight[i + 1] && offeringCounts[i] <= offeringCounts[i + 1])
                offeringCounts[i] = offeringCounts[i + 1] + 1;
        }
        for (int num : offeringCounts)
            sum += num;
        return sum;
    }
}

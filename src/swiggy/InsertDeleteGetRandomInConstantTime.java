package swiggy;

// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandomInConstantTime {
    static List<Integer> nums;
    static Map<Integer, Integer> hash;
    static java.util.Random random;

    public static void main(String[] args) {
        nums = new ArrayList<>();
        hash = new HashMap<>();
        random = new java.util.Random();
        InsertDeleteGetRandomInConstantTime obj = new InsertDeleteGetRandomInConstantTime();
        System.out.println(obj.remove(0));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(0));
    }

    public boolean insert(int val) {
        if (hash.get(val) != null)
            return false;
        int size = hash.size();
        nums.add(val);
        hash.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (hash.get(val) == null)
            return false;
        int index = hash.get(val);
        hash.remove(val);
        int size = nums.size();
        int last = nums.get(size - 1);
        if(size - 1 !=0) {
            swap(nums, index, size - 1);
            hash.put(last, index);
        }
        nums.remove(size - 1);

        return true;
    }

    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}


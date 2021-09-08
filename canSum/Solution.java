import java.util.*;

public class Solution {
    static boolean canSum(int target, int[] nums) { // brute force
        if(target == 0)
            return true;
        if(target < 0) 
            return false;
        for (int num : nums) {
            int rem = target - num;
            if(canSum(rem, nums)) {
                return true;
            }
        }
        return false;
    }


    static boolean canSum(int target, int[] nums, HashMap<Integer, Boolean> map) { // memoization
        if(map.containsKey(target))
            return map.get(target);
        if(target == 0)
            return true;
        if(target < 0) 
            return false;
        for (int num : nums) {
            int rem = target - num;
            if(canSum(rem, nums, map)) {
                map.put(target, true);
                return true;
            }
        }
        map.put(target, false);
        return false;
    }

    static boolean canSumTabulation(int target, int[] nums) {
        boolean[] table = new boolean[target + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for(int i = 0; i <= target; i++) {
            if(table[i] == true) {
                for(int j = 0; j < nums.length; j++) {
                    if(i+nums[j] < table.length)
                        table[i+nums[j]] = true;
                }
            }
        }
        return table[target];
    }

    public static void main(String[] args) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int[] arr = {7, 14, 7, 8, 1};
        System.out.println(canSum(7, arr)); 
        System.out.println(canSum(300 , arr));
        System.out.println(canSum(300, arr, map)); 
        System.out.println(canSumTabulation(7, new int[]{2, 4}));
        System.out.println(canSumTabulation(300, new int[]{7, 14})); 
        System.out.println(canSumTabulation(300, arr)); 

    }
}

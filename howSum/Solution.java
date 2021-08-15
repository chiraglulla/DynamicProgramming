import java.util.*;

class Solution {

    static ArrayList<Integer> howSum(int target, int[] numbers, HashMap<Integer, ArrayList<Integer>> map) {
        if(map.containsKey(target))
            return map.get(target);
        if(target == 0)
            return new ArrayList<Integer>();
        if(target < 0)
            return null;
        
        for(int num: numbers) {
            int rem = target - num;
            ArrayList<Integer> result = howSum(rem, numbers, map);
            if(result != null) {
                result.add(num);
                map.put(target, result);
                return result;
            }
        }
        map.put(target, null);
        return null;
    }

    public static void main(String[] args) {
        int[] num1 = {2,3};
        System.out.println(howSum(7, num1, new HashMap<Integer, ArrayList<Integer>>()));
        int[] num2 = {5, 3, 4, 7};
        System.out.println(howSum(7, num2, new HashMap<Integer, ArrayList<Integer>>()));
        int[] num4 = {2,4};
        System.out.println(howSum(7, num4, new HashMap<Integer, ArrayList<Integer>>()));
        int[] num3 = {7, 14};
        System.out.println(howSum(300, num3, new HashMap<Integer, ArrayList<Integer>>()));
    }
}

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

    static ArrayList<Integer> howSumTabulation(int target, int[] numbers) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= target; i++)
            table.add(i, null);
        table.set(0, new ArrayList<Integer>());
        
        for(int i = 0; i <= target; i++) {
            if(table.get(i) != null) {
                for(int j = 0; j < numbers.length; j++) {
                    if(i+numbers[j] < table.size()){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.addAll(table.get(i));
                        table.set(i+numbers[j], temp);
                        table.get(i+numbers[j]).add(numbers[j]);
                    }
                }
            }
        }
        return table.get(target);
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


        System.out.println(howSumTabulation(7, new int[]{2, 3}));
        System.out.println(howSumTabulation( 7, new int[]{5, 3, 4, 7}));
        System.out.println(howSumTabulation( 7, new int[]{2, 4}));
        System.out.println(howSumTabulation(8, new int[]{2, 3, 5}));
        System.out.println(howSumTabulation( 300, new int[]{7, 14}));
    }
}

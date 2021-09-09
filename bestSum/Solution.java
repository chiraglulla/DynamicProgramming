import java.util.*;

class Solution {

    // static void copyElements(ArrayList<Integer> best, ArrayList<Integer> result) {
    //     for(Integer ele: result) {
    //         best.add(ele);
    //     }
    // }

    static ArrayList<Integer> bestSum(int target, int[] numbers) { // brute force
        if(target == 0) 
            return new ArrayList<Integer>();
        if(target < 0) 
            return null;

        ArrayList<Integer> best = null;

        for(int num: numbers) {
            int rem = target - num;
            ArrayList<Integer> result = bestSum(rem, numbers);

            if(result != null) {
                result.add(num);
                if(best == null || (result.size() < best.size())) {
                    best = null;
                    best = new ArrayList<Integer>(result);
                    // System.out.println(best);
                }
            }
        }
        return best;
    }

    static ArrayList<Integer> bestSum(int target, int[] numbers, HashMap<Integer, ArrayList<Integer>> map) { //memoize
        // 50 //1, 2, 5, 25
        if(map.containsKey(target))
            return map.get(target);
        if(target == 0) 
            return new ArrayList<Integer>();
        if(target < 0)
            return null;

        ArrayList<Integer> best = null;

        for(int num: numbers) {
            int rem = target - num;
            ArrayList<Integer> result = bestSum(rem, numbers, map);

            if(result != null) {
                result.add(num);
                if(best == null || result.size() < best.size()) {
                    best = null;
                    best = new ArrayList<Integer>(result);
                }
            }
        }

        map.put(target, best);
        return best;
    }

    static ArrayList<Integer> bestSumTabulation(int target, int[] numbers) {
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
                        temp.add(numbers[j]);
                        if(table.get(i+numbers[j]) == null || table.get(i+numbers[j]).size() > temp.size())
                            table.set(i+numbers[j], temp);
                    }
                }
            }
        }
        return table.get(target);
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 3, 4, 7};
        System.out.println(bestSum(7, arr1));
        int[] arr2 = {2,3,5};
        System.out.println(bestSum(8, arr2));
        int[] arr3 = {1, 2, 5, 25};
        System.out.println(bestSum(50, arr3, new HashMap<Integer, ArrayList<Integer>>()));

        System.out.println(bestSumTabulation( 7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSumTabulation(8, new int[]{2, 3, 5}));
        System.out.println(bestSumTabulation(8, new int[]{1, 4, 5}));
        System.out.println(bestSumTabulation(100, new int[]{1, 2, 5, 25}));
    }
}

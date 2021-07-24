import java.util.HashMap;

class Solution {

    static int gridTraveler(int m, int n) {  //Recursive Approach
        if(m == 1 && n == 1)
            return 1;
        if(m == 0 || n == 0)
            return 0;
        return gridTraveler(m-1, n) + gridTraveler(m, n-1);
    }

    static long gridTraveler(int m, int n, HashMap<String, Long> map) { //Memoized Solution
        String key1 = m + "," + n;
        if(map.containsKey(key1))
            return map.get(key1);
        if(m == 1 && n == 1)
            return 1;
        if(m == 0 || n == 0)
            return 0;
        map.put(key1, gridTraveler(m-1, n, map) + gridTraveler(m, n-1, map));
        return map.get(key1);
    }

    public static void main(String[] args) {
        HashMap<String, Long> map = new HashMap<String, Long>();
        System.out.println(gridTraveler(25, 25, map));
        System.out.println(map);     
    }
}

import java.util.Scanner;

class Solution {
    static int getKth(int lo, int hi, int k) {
        int count = 0, o = 0;
        TreeMap<Integer, ArrayList<Integer>> sorted = new TreeMap<Integer, ArrayList<Integer>>();
        while (lo <= hi) {
            int temp = lo;
            while (temp != 1) {
                if (temp % 2 == 0)
                    temp /= 2;
                else
                    temp = 3 * temp + 1;
                count++;
            }
            if (sorted.containsKey(count))
                sorted.get(count).add(lo);
            else {
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(lo);
                sorted.put(count, al);
            }
            lo++;
            count = 0;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : sorted.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans.get(k - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lo = sc.nextInt();
        int hi = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getKth(lo, hi, k));
        sc.close();
    }
}
import java.util.*;

class Solution {
    
    static int canConstruct(String target, List<String> wordBank){ //brute force
        if(target.equals(""))
            return 1;

        int ways = 0;
        for(int i = 0; i < target.length(); i++) {
            String prefix = target.substring(0, i+1);
            if(wordBank.contains(prefix)) {
                int temp = canConstruct(target.substring(i+1), wordBank);
                ways += temp;
                    
            }
        }
        return ways;
    }

    static int canConstruct(String target, List<String> wordBank, HashMap<String, Integer> map){ //memoized
        if(map.containsKey(target))
            return map.get(target);
        if(target.equals(""))
            return 1;
        int ways = 0;
        for(int i = 0; i < target.length(); i++) {
            String prefix = target.substring(0, i+1);
            if(wordBank.contains(prefix)) {
                int temp = canConstruct(target.substring(i+1), wordBank, map);
                ways += temp;
            }
        }
        map.put(target, ways);
        return ways;
    }

    //tabulation
    static int countConstructTabulation(String target, List<String> wordBank) {
        int[] table = new int[target.length()+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        
        //abcdef ab abc cd def abcd ef
        //[1, 0, 1, 1, 2, 0, 3]

        for(int i = 0; i <= target.length(); i++) {
            System.out.println("Pass: " + i);
            for(String word: wordBank) {
                if(i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)) {
                    table[i + word.length()] += table[i];
                    System.out.println("For" + i + " " + Arrays.toString(table));
                }
            }
        }
        return table[target.length()];
    }

    
    public static void main(String[] args) {
        List<String> wordBank0 = new LinkedList<String>();
        wordBank0.add("purp");
        wordBank0.add("p");
        wordBank0.add("ur");
        wordBank0.add("le");
        wordBank0.add("purpl");
        System.out.println(countConstructTabulation("purple", wordBank0));

        List<String> wordBank1 = new LinkedList<String>();
        wordBank1.add("ab");
        wordBank1.add("abc");
        wordBank1.add("cd");
        wordBank1.add("def");
        wordBank1.add("abcd");
        wordBank1.add("ef");
        System.out.println(countConstructTabulation("abcdef", wordBank1));

        List<String> wordBank2 = new LinkedList<String>();
        wordBank2.add("bo");
        wordBank2.add("rd");
        wordBank2.add("ate");
        wordBank2.add("t");
        wordBank2.add("ska");
        wordBank2.add("sk");
        wordBank2.add("boar");
        System.out.println(countConstructTabulation("skateboard", wordBank2));

        List<String> wordBank3 = new LinkedList<String>();
        wordBank3.add("a");
        wordBank3.add("p");
        wordBank3.add("ent");
        wordBank3.add("enter");
        wordBank3.add("ot");
        wordBank3.add("o");
        wordBank3.add("t");
        System.out.println(countConstructTabulation("enterapotentpot", wordBank3));

        List<String> wordBank4 = new LinkedList<String>();
        wordBank4.add("e");
        wordBank4.add("ee");
        wordBank4.add("eee");
        wordBank4.add("eeee");
        wordBank4.add("eeeee");
        wordBank4.add("eeeeee");
        wordBank4.add("eeeeeee");
        System.out.println(countConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", wordBank4));
    }
}
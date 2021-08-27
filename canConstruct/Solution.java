import java.util.*;

class Solution {
    
    static boolean canConstruct(String target, List<String> wordBank){ //brute force
        if(target.equals(""))
            return true;
 
        for(int i = 0; i < target.length(); i++) {
            String prefix = target.substring(0, i+1);
            if(wordBank.contains(prefix)) {
                if(canConstruct(target.substring(i+1), wordBank)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean canConstruct(String target, List<String> wordBank, HashMap<String, Boolean> map){ //memoized
        if(map.containsKey(target))
            return map.get(target);
        if(target.equals(""))
            return true;
 
        for(int i = 0; i < target.length(); i++) {
            String prefix = target.substring(0, i+1);
            if(wordBank.contains(prefix)) {
                if(canConstruct(target.substring(i+1), wordBank, map)) {
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }
    
    
    public static void main(String[] args) {
        List<String> wordBank1 = new LinkedList<String>();
        wordBank1.add("ab");
        wordBank1.add("abc");
        wordBank1.add("cd");
        wordBank1.add("def");
        wordBank1.add("abcd");
        System.out.println(canConstruct("abcdef", wordBank1));

        List<String> wordBank2 = new LinkedList<String>();
        wordBank2.add("bo");
        wordBank2.add("rd");
        wordBank2.add("ate");
        wordBank2.add("t");
        wordBank2.add("ska");
        wordBank2.add("sk");
        wordBank2.add("boar");
        System.out.println(canConstruct("skateboard", wordBank2));

        List<String> wordBank3 = new LinkedList<String>();
        wordBank3.add("a");
        wordBank3.add("p");
        wordBank3.add("ent");
        wordBank3.add("enter");
        wordBank3.add("ot");
        wordBank3.add("o");
        wordBank3.add("t");
        System.out.println(canConstruct("enterapotentpot", wordBank3));

        List<String> wordBank4 = new LinkedList<String>();
        wordBank4.add("e");
        wordBank4.add("ee");
        wordBank4.add("eee");
        wordBank4.add("eeee");
        wordBank4.add("eeeee");
        wordBank4.add("eeeeee");
        wordBank4.add("eeeeeee");
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", wordBank4, new HashMap<String, Boolean>()));
    }
}
import java.util.ArrayList;

public class Solution {

    static ArrayList<ArrayList<String>> constructTargetWays(ArrayList<ArrayList<String>> result, String word) {
        // if(result.size() == 0) {
        //     result.add(new ArrayList<String>());
        // }
        for(ArrayList<String> comb: result){
            comb.add(0, word);
        }
        return result;
    }

    static ArrayList<ArrayList<String>> check(String target, ArrayList<String> wordBank) {
        if(target.equals("")){
            ArrayList<ArrayList<String>> finalAns = new ArrayList<ArrayList<String>>();
            finalAns.add(new ArrayList<String>());
            return finalAns; //[[]]
        }

        ArrayList<ArrayList<String>> finalAns = new ArrayList<ArrayList<String>>(); //[]

        for (int i = 0; i < target.length(); i++) {
            String prefix = target.substring(0, i+1);
            if(wordBank.contains(prefix)) {
                ArrayList<ArrayList<String>> result = check(target.substring(i+1), wordBank);
                ArrayList<ArrayList<String>> ways = constructTargetWays(result, prefix);
                finalAns.addAll(ways);
            }
        }
        
        return finalAns;
    }


    public static void main(String[] args) {

        ArrayList<String> wordBank = new ArrayList<String>();

        wordBank.add("purp");
        wordBank.add("p");
        wordBank.add("ur");
        wordBank.add("le");
        wordBank.add("purpl");

       System.out.println(check("purple", wordBank));

        ArrayList<String> wordBank2 = new ArrayList<String>();
        wordBank2.add("ab");
        wordBank2.add("abc");
        wordBank2.add("cd");
        wordBank2.add("def");
        wordBank2.add("abcd");
        wordBank2.add("ef");
        wordBank2.add("c");
        wordBank2.add("abcde");


        System.out.println(check("abcdef", wordBank2));

    //     ArrayList<String> wordBank3 = new ArrayList<String>();

    //     wordBank3.add("bo");
    //     wordBank3.add("rd");
    //     wordBank3.add("ate");
    //     wordBank3.add("t");
    //     wordBank3.add("ska");
    //     wordBank3.add("sk");
    //     wordBank3.add("boar");

    //     System.out.println(allConstruct("skateboard", wordBank3));

        // ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        // ArrayList<ArrayList<String>> arr1 = new ArrayList<ArrayList<String>>();
        // ArrayList<String> arr3 = new ArrayList<String>();
        // arr3.add("ajhjcjvc");
        // arr3.add("bcjdsbcdsdc");
        // arr3.add("dsjsbvsjvd");

        // ArrayList<String> arr4 = new ArrayList<String>();
        // arr4.add("ajhjcjvc");
        // arr4.add("bcjdsbcdsdc");
        // arr4.add("dsjsbvsjvd");

        // arr1.add(arr3);
        // arr1.add(arr4);


        // System.out.println(arr3);
        // System.out.println(arr1);

        // ArrayList<String> arr5 = new ArrayList<String>();
        // arr5.add("ajhjcjvc");
        // arr5.add("bcjdsbcdsdc");
        // arr5.add("dsjsbvsjvd");

        // arr1.add(arr5);

        // arr.addAll(arr1);

        // System.out.println(arr);
    }
}

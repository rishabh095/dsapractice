package codetest;

import java.util.ArrayList;
import java.util.List;

public class SalesforceTest {
    static int result;
    static List<Integer> combinations;
    public static void main(String[] args) {
        result=0;
        combinations=new ArrayList<>();
        System.out.println(findPossibleWaysToScoreUtil(10,combinations));
    }

    private static int findPossibleWaysToScoreUtil(int score, List<Integer> combinations) {
        if(score==0){
            result++;
            System.out.println(combinations);
        }
        if(score<0){
            return result;
        }
        if(score>0){
            if((score-2)>=0){
                combinations.add(2);
                findPossibleWaysToScoreUtil(score-2,combinations);
            }
            if((score-4)>=0){
                combinations.add(4);
                findPossibleWaysToScoreUtil(score-4,combinations);
            }
            if((score-6)>=0){
                combinations.add(6);
                findPossibleWaysToScoreUtil(score-6,combinations);
            }
        }
        if(combinations.size()>0)
            combinations.remove(combinations.size()-1);
        return result;
    }
}

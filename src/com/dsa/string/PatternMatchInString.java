package com.dsa.string;

public class PatternMatchInString {
    public static void main(String[] args) {
        String text="ababcababaadababa";
        String pat="ababa";
        patternMatch(text,pat);
    }

    private static void patternMatch(String text, String pat) {
        int n=text.length();
        int m= pat.length();
        int[] lps=new int[m];
        fillLPS(pat,lps);
        int i=0,j=0;
        while(i<n){
            if(text.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }if(j==m){
                System.out.println("pattern found at "+(i-j));
                j=lps[j-1];
            }
            else if(i<n && text.charAt(i)!=pat.charAt(j)){
                if(j==0)
                    i++;
                else
                    j=lps[j-1];
            }
        }
    }

    private static void fillLPS(String pat, int[] lps) {
        int n=pat.length(),len=0;
        lps[0]=0;
        int i=1;
        while(i<n){
            if(pat.charAt(i)== pat.charAt(len)){
                len++;
                lps[i++]=len;
            }else{
                if(len ==0){
                    lps[i]=0;
                    i++;
                }else
                    len=lps[len-1];
            }
        }
    }
}

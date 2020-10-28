package com.lagou.test;

public class Algorithm {
    public static void main(String[] args) {
        String s = "bb";
        String longestPalindrome = longestPalindrome(s);
        System.out.println("最长的回文子串是-"+longestPalindrome);

    }

    public static String longestPalindrome(String s) {//最长回文字串
        int length = s.length();//字符串长度
        if(length<2){
            return s;
        }
        int max = 1;//存放最长回文字串的长度
        String target = s.substring(0,1);
        for(int i=1;i<=length*2-1;i++){
            if(i%2==1){
                int left=(i-1)/2;
                int right=(i-1)/2;
                int num = 1;
                while (left>0&&right<length-1){
                    left--;
                    right++;
                    if(s.charAt(left)==s.charAt(right)){
                        num = num+2;
                        if(num>max){
                            max = num;
                            target = s.substring(left,right+1);
                        }

                    }else {
                        break;
                    }

                }
            }else{
                int left = i/2-1;
                int right = i/2;
                int num = 0;
                while (left>=0&&right<=length-1){
                    if(s.charAt(left)==s.charAt(right)){
                        num = num+2;
                        if(num>max){
                            max = num;
                            target = s.substring(left,right+1);
                        }
                    }else {
                        break;
                    }
                    left--;
                    right++;

                }
            }
        }
        return target;

    }

}

// Given a string s, reverse the order of words. A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space. Return a string of the words in reverse order concatenated by a single space.

class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        String [] st1=s.stripLeading().split(" ");

        String st2="";
        for(int i=0;i<st1.length;i++){
            if(!st1[i].isEmpty()){
                st2=st1[i]+" "+st2;
            }

            
        }

        return st2.substring(0,st2.length()-1);
    }
}
class Solution {
    public int myAtoi(String input) {
        input=input.trim();
        int n=input.length();
        if (input.length() == 0) {
            return 0;
        }
        int i=0;

        int sign=1;
        if(input.charAt(0)=='-') {
            sign=-1;
            i++;
        } else if(input.charAt(0)=='+'){
            i++;
        }
        long result=0;
        while(i<n && Character.isDigit(input.charAt(i))){
            result=result*10+(input.charAt(i)-'0');
            i++;
             if((result*sign)<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if((result*sign)>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        }
      


        return (int)(result*sign);
    }
}
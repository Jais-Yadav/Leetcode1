class Pair{
    String word;
    int steps;
    public Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
     public int wordLadderLength(String startWord, String targetWord, List<String> wordList) {
     Queue<Pair> q=new LinkedList<>();
     Set<String> st=new HashSet<>();
        for(String i:wordList){
            st.add(i);
        }
        q.add(new Pair(startWord,1));
        if(st.contains(startWord))st.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().word;
            int step=q.peek().steps;
            q.poll();
            if(word.equals(targetWord)==true) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replaceChararr[]=word.toCharArray();
                    replaceChararr[i]=ch;
                    String newWord=new String(replaceChararr);
                    if(st.contains(newWord)==true){
                        st.remove(newWord);
                        q.add(new Pair(newWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return wordLadderLength(beginWord,endWord,wordList);
    }
}
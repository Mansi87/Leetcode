class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<String>();
        int len = wordList.size();
        for(int i=0; i<len; i++){
            set.add(wordList.get(i));
        }

        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true)  return steps;
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char replace[] = word.toCharArray();
                    replace[i] = ch;
                    String replaced = new String(replace);
                    if(set.contains(replaced) == true){
                        set.remove(replaced);
                        q.add(new Pair(replaced, steps+1));
                    }
                }
            } 
        }
        return 0;
    }
}
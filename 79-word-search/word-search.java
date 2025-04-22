class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || word==null || board.length==0 || board[0].length==0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;

        int[] wordFreq = new int[52]; 
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                 wordFreq[c - 'a']++;
            } else {
                wordFreq[c - 'A' + 26]++;
        }
    }

        int[] gridFreq = new int[52];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 char c = board[i][j];
                if (Character.isLowerCase(c)) {
                    gridFreq[c - 'a']++;
                } else {
                     gridFreq[c - 'A' + 26]++;
                 }
            }
        }

        for(int i =0; i<26; i++){
            if(wordFreq[i]>gridFreq[i]){
                return false;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, String word, int i, int j, int ind){
        if(ind==word.length())  return true;

        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(ind)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean result = dfs(board, word, i+1, j, ind+1) ||
                         dfs(board, word, i-1, j, ind+1) ||
                         dfs(board, word, i, j+1, ind+1)||
                         dfs(board, word, i, j-1, ind+1);
        board[i][j] = temp;
        return result;
    }
}
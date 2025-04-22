class Solution {

    private static final Map<Character, String> phoneMap = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6',"mno", '7',"pqrs", '8', "tuv",'9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null || digits.length()==0)  return result;

        backtrack(0, digits, new StringBuilder(), result);
        return result;

    }

    private void backtrack(int ind, String digits, StringBuilder curr, List<String> result){
        if(ind==digits.length()){
            result.add(curr.toString());
            return;
        }
        String possibleLetters = phoneMap.get(digits.charAt(ind));
        for(char ch: possibleLetters.toCharArray()){
            curr.append(ch);

            backtrack(ind+1, digits, curr, result);

            curr.deleteCharAt(curr.length()-1);
        }
    }
}
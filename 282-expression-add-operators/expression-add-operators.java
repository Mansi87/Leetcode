class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String num, int target, int index, long calculated, long tail) {
        if (index == num.length()) {
            if (calculated == target) {
                result.add(path.toString());
            }
            return;
        }

        int len = path.length();

        for  (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            String currentStr = num.substring(index, i + 1);
            long current = Long.parseLong(currentStr);

            if (index == 0) {
                path.append(currentStr);
                backtrack(result, path, num, target, i + 1, current, current);
                path.setLength(len);
            } else {
                
                path.append("+").append(currentStr);
                backtrack(result, path, num, target, i + 1, calculated + current, current);
                path.setLength(len);

                
                path.append("-").append(currentStr);
                backtrack(result, path, num, target, i + 1, calculated - current, -current);
                path.setLength(len);

                
                path.append("*").append(currentStr);
                backtrack(result, path, num, target, i + 1, calculated - tail + tail * current, tail * current);
                path.setLength(len);
            }
        }
    }
}

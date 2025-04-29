class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        long total = 0;
        int mod = (int)1e9+7;
        for(int i=0; i<arr.length; i++){
            int left = i-pse[i];
            int right = nse[i] - i;
            total = (total + (long)arr[i] * left * right) % mod;
        }
        return (int)total;
    }

    private int[] findNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] findPse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
}
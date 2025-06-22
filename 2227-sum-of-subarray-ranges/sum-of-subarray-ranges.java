class Solution {
    public long subArrayRanges(int[] nums) {
        int[] nse = findNse(nums);
        int[] pse = findPse(nums);
        int[] nge = findNge(nums);
        int[] pge = findPge(nums);
        long minSum = 0;
        long maxSum = 0;
        for(int i=0; i<nums.length; i++){
            long leftMin = i-pse[i];
            long rightMin = nse[i]-i;
            minSum += (long)nums[i] * leftMin * rightMin;

            long leftMax = i-pge[i];
            long rightMax = nge[i]-i;
            maxSum += (long)nums[i] * leftMax * rightMax;
        }
        return maxSum - minSum;
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

    private int[] findNge(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            nge[i] = st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nge;
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

    private int[] findPge(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            pge[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }
}
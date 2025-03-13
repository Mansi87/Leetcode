class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(cnt1==0 && nums[i]!=el2){
                cnt1 = 1;
                el1 = nums[i];
            }
            else if(cnt2==0 && nums[i]!=el1){
                cnt2=1;
                el2 = nums[i];
            }
            else if(el1==nums[i]) cnt1++;
            else if(el2==nums[i]) cnt2++;

            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int m = nums.length/3;
        cnt1 = 0; cnt2 = 0;
        for(int i=0; i<nums.length; i++){
            if(el1==nums[i]) cnt1++;
            if(el2==nums[i]) cnt2++;
        }
        if(cnt1>m) ans.add(el1);
        if(cnt2>m && el1!=el2) ans.add(el2);
        if(ans.size() == 2 && ans.get(0)>ans.get(1)){
            swap(ans,0,1);
        }
        return ans;
    }

    private void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int s=0;
        int diff=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                s=nums[l]+nums[i]+nums[r];
                if(s==target) return target;
                if(Math.abs(target-s)<diff){
                    ans=s;
                    diff = Math.abs(target - s);
                }
                if(s<target) l++;
                else r--;
            }
        }
        return ans;
    }
}
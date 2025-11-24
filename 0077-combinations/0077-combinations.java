class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        int start=0;
        return backtrack(nums,k,start,new ArrayList<>());
    }
    public List<List<Integer>> backtrack(int[] nums,int k,int start,List<Integer>list){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return res;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,k,i+1,list);
            list.remove(list.size()-1);
        }
        return res;
    }
}
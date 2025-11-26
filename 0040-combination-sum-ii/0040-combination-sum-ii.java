class Solution {
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        boolean[] visited=new boolean[nums.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        int currSum=0;
        int startI=0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
            backtrack(0,list,visited,currSum,target,nums);
        return res;
    }

    private List<List<Integer>> backtrack(int i,List<Integer> list , boolean[] visited,int currSum,int target,int[] nums){
        if(currSum==target){
            res.add(new ArrayList<>(list));
            return res;
        }
        if(currSum > target) return res;  
        if(i>nums.length-1) return res;
        if(visited[i]) return backtrack(i+1,list,visited,currSum,target,nums);
        if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
            return backtrack(i+1, list, visited, currSum, target, nums);
        }
        visited[i]=true;
        list.add(nums[i]);
        backtrack(i+1,list,visited,currSum+nums[i],target,nums);
        list.removeLast();
        visited[i]=false;
        backtrack(i+1, list, visited, currSum, target, nums);
        return res;
    }
}
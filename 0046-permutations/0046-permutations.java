class Solution {
         List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
            return backtrack(nums,new ArrayList<>(),new boolean[nums.length]);
    }
     private List<List<Integer>> backtrack(int[] nums,List<Integer> list,boolean[] visited)
    {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return res;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;

            list.add(nums[i]);
            visited[i]=true;

            backtrack(nums,list,visited);

            list.removeLast();
            visited[i]=false;
        }
        return res;
    }
}
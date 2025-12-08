class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[10];
        for(int i=0;i<visited.length;i++){
            visited[i] =false;
        }
        backtrack(k,n,visited,list,res,1);
        return res;
    }
    private void backtrack(int k,int remain, boolean[]visited, List<Integer> list,List<List<Integer>> res,int i){
        if(list.size()==k && remain==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size()==k || remain<=0 || i>9) return;
        
        for(int j=i; j<=9; j++){
            visited[j]=true;
            list.add(j);
            backtrack(k,remain-j,visited,list,res,j+1);
            list.remove(list.size()-1);
            visited[j]=false;
        }
    }
}
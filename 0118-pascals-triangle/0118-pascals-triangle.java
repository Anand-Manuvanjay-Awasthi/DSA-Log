class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> lst = new ArrayList<>();
            int res = 1;
            int first = 1;
            lst.add(first);
            for(int j=1;j<numRows;j++){
                res = res * (i - j);
                res = res / j;
                if(res != 0) lst.add(res);
                else continue;
            }
            ans.add(lst);
        }
        return ans;
    }
}
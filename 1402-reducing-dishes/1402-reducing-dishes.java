class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        int ltc = 0;
        Arrays.sort(satisfaction);
        int eleSum=0;
        int total=0;
        for(int i=n-1;i>=0;i--){
            eleSum+=satisfaction[i];
            if(eleSum+total>total){
                total+=eleSum;
            }else break;
        }
        return total;
    }
}
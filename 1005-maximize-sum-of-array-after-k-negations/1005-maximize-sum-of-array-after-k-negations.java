class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //negative hai toh positive will do 
        // zero hai toh jbtk k baar na ho jaaye usi ke sign flip krte rho max possiible sum milega
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int n:nums) q.offer(n);
        while(k-- >0) q.offer(-q.poll());
        int sum=0;
        while(!q.isEmpty()) sum+=q.poll();
        return sum;
    }
}
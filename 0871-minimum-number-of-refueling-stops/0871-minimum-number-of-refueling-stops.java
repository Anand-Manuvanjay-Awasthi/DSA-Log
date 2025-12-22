class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        Queue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int i = 0, n = stations.length, stops = 0, maxDistance = startFuel;
        while (maxDistance < target) {
            while (i < n && stations[i][0] <= maxDistance) {
                q.offer(stations[i++][1]);
            }
            if (q.isEmpty()) return -1;
            maxDistance += q.poll();
            stops++;
        }
        return stops;
    }
}
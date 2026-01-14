class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int k) {
         int n = q.length;
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) w[i] / q[i];
            workers[i][1] = q[i];
        }

        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        double ans = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            double qu = workers[i][1];
            sum += qu;
            pq.add(qu);

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.min(ans, sum * workers[i][0]);
            }
        }
        return ans;
    }
}
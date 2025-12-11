class Solution {
    public int[] getOrder(int[][] tasks) 
    {
        int n = tasks.length;
        int[] order = new int[n];
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++)
        jobs[i] = new Job(i,tasks[i][0],tasks[i][1]);
        Arrays.sort(jobs,(a,b)-> a.start!=b.start ? a.start-b.start : a.time - b.time);
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b)->a.time!=b.time ? a.time-b.time : a.index-b.index);
        int time = jobs[0].start, i = 1,k=0;
        pq.add(jobs[0]);
        while(k<n)
        {
            Job sjf = pq.poll();
            order[k++] = sjf.index;
            time = time + sjf.time; 
            while(i<n && jobs[i].start<=time)
            pq.add(jobs[i++]);
            if(i<n && pq.isEmpty())
            {
                time = jobs[i].start;
                pq.add(jobs[i++]);
            }
        }
        return order;
    }
}
class Job{
        
    int index,start,time;
    Job(int index,int start,int time)
    {
        this.index = index;
        this.start = start;
        this.time = time;
    }
}
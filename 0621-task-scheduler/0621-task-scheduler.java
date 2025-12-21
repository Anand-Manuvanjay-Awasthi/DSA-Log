class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b)-> a.getValue()!=b.getValue() ? b.getValue() - a.getValue():a.getKey()-b.getKey());
        q.addAll(mp.entrySet());

        int count=0;
            while (!q.isEmpty()) {
        int k = n + 1;
        List<Map.Entry> tempList = new ArrayList<>();
        while (k > 0 && !q.isEmpty()) {
            Map.Entry<Character, Integer> top = q.poll(); 
            top.setValue(top.getValue() - 1);
            tempList.add(top); 
            k--;
            count++; 
        }
        for (Map.Entry<Character, Integer> e : tempList) {
            if (e.getValue() > 0) q.add(e);
        }

        if(q.isEmpty()) break;
        count=count+k; 
       }
       return count;
    }
}
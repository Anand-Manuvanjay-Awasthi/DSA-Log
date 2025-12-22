class Solution {
    public int[] diStringMatch(String s) {
        int[] perm = new int[s.length()+1];
        int min=0;int d=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='D') {
                perm[i]=d--;
            }
            else perm[i]=min++;
        }
        perm[s.length()]=min;
        return perm;
    }
}
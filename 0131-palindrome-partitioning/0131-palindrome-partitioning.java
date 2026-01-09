class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return res;
    }
    public void helper(String s,int idx,List<String> ans){
  
        if(idx>=s.length()){
            res.add(new ArrayList(ans));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(idx,i,s)){
                ans.add(s.substring(idx,i+1));
                helper(s,i+1,ans);
                ans.removeLast();
            }
        }
    }
    public boolean isPalindrome(int i,int j,String s){
         while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
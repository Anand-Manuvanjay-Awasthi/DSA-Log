class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s,0,0,"");
        return ans;
    }
    public void helper(String s,int idx,int seg,String path){
        if(seg ==4 && idx==s.length()){
            ans.add(path.substring(0,path.length()-1));
            return;
        }
         if (seg == 4 || idx == s.length()) {
            return;
        }

        for(int len=1;len<=3;len++){
            if(idx+len>s.length()) break;
            String str = s.substring(idx,idx+len);
            if(!isValid(str)) continue;
            helper(s,idx+len,seg+1,path+str+".");
            }
        }
    public boolean isValid(String s){
        if(s.length()>1 && s.charAt(0)=='0') return false;
        int val = Integer.parseInt(s);
        return (val >=0 && val<=255);
    }
}
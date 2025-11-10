class Solution {
    public List<String> letterCombinations(String digits) {
         Map<Character, char[]> keyboard = Map.of(
            '2', new char[] { 'a', 'b', 'c' },
            '3', new char[] { 'd', 'e', 'f' },
            '4', new char[] { 'g', 'h', 'i' },
            '5', new char[] { 'j', 'k', 'l' },
            '6', new char[] { 'm', 'n', 'o' },
            '7', new char[] { 'p', 'q', 'r', 's' },
            '8', new char[] { 't', 'u', 'v' },
            '9', new char[] { 'w', 'x', 'y', 'z' }
);
    return helperFun("",digits,keyboard);
    }

    private List<String> helperFun(String p,String up ,Map<Character,char[]> kb){
        List<String> res = new ArrayList<>();
        if(up.isEmpty()){
            res.add(p);
            return res;
        }
       
        char ch = up.charAt(0);
       char[] mpArray = kb.get(ch);

        for(char c : mpArray) { 
            res.addAll(helperFun(p + c, up.substring(1), kb));
        }
        return res;
    }
}
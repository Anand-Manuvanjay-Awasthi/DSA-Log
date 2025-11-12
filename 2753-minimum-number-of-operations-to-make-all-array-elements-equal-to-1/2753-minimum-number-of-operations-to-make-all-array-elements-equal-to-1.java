class Solution {
    public int minOperations(int[] nums) {
        if(containsOne(nums)) return nums.length-countOne(nums);
        
         int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++)
        {
            int gcd=nums[i];
            for(int j=i+1;j<nums.length;j++)
            {
                gcd=met(gcd,nums[j]);
                if(gcd==1)
                {
                    min=Math.min(min,j-i+1);
                    break;
                }
            }
        }
        if(min==Integer.MAX_VALUE)  return -1;
        else return (min-1)+(nums.length-1);
         
    }
        public static int met(int a,int b)
    {
        if(b==0) return a;
        return met(b,a%b);
    }
        
    
    static boolean containsOne(int[] nums){
        boolean val =false;
        int i=0;
        while(i<nums.length){
            if(nums[i]==1) {
                val = true;
                return val;
            }
            else{
                i++;
            }
        }
        return val;
    }
    static int countOne(int[] nums){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
        }
        return count;
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
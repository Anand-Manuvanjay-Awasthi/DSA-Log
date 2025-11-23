class Solution {
    public int maxSumDivThree(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        
        int sumMod = totalSum % 3;
        if(sumMod == 0) return totalSum;
        
        
        int min1_1 = Integer.MAX_VALUE, min1_2 = Integer.MAX_VALUE;
        int min2_1 = Integer.MAX_VALUE, min2_2 = Integer.MAX_VALUE; 
        
        for(int num : nums) {
            if(num % 3 == 1) {
                if(num < min1_1) {
                    min1_2 = min1_1;
                    min1_1 = num;
                } else if(num < min1_2) {
                    min1_2 = num;
                }
            } else if(num % 3 == 2) {
                if(num < min2_1) {
                    min2_2 = min2_1;
                    min2_1 = num;
                } else if(num < min2_2) {
                    min2_2 = num;
                }
            }
        }
        
        int toRemove = Integer.MAX_VALUE;
        
        if(sumMod == 1) {
          
            if(min1_1 != Integer.MAX_VALUE) {
                toRemove = Math.min(toRemove, min1_1);
            }
            
            if(min2_1 != Integer.MAX_VALUE && min2_2 != Integer.MAX_VALUE) {
                toRemove = Math.min(toRemove, min2_1 + min2_2);
            }
        } else { // sumMod == 2
           
            if(min2_1 != Integer.MAX_VALUE) {
                toRemove = Math.min(toRemove, min2_1);
            }
            
            if(min1_1 != Integer.MAX_VALUE && min1_2 != Integer.MAX_VALUE) {
                toRemove = Math.min(toRemove, min1_1 + min1_2);
            }
        }
        
        return toRemove == Integer.MAX_VALUE ? 0 : totalSum - toRemove;
    }
}
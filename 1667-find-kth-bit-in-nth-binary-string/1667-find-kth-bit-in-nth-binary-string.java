class Solution {
    public char findKthBit(int n, int k) {
        return findKthBitRecursive(n, k);
    }
    
    private char findKthBitRecursive(int n, int k) {
        
        if (n == 1) return '0';
        
        int length = (int)Math.pow(2,n) - 1;  
        int mid = length / 2 + 1; 
        
        if (k == mid) {
            return '1';  // Middle bit is always '1'
        } else if (k < mid) {
            // Left half me calculate kr 
            return findKthBitRecursive(n - 1, k);
        } else {
            // Right half me calculate krna hai
        
            int mirrorK = length - k + 1; // ye keval right half me actual kth bit dikhane ke liye ...like mirroring left half's postion
            char bit = findKthBitRecursive(n - 1, mirrorK);
            // Invert krke return krna hai
            return bit == '0' ? '1' : '0';
        }
    }
}


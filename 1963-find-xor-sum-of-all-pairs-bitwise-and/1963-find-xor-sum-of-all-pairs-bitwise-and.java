class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int x1 = 0;
        for (int v : arr1) x1 ^= v;

        int x2 = 0;
        for (int v : arr2) x2 ^= v;

        return x1 & x2;
    }
}

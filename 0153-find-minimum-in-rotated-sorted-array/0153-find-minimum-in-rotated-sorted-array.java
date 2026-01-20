class Solution {
    public int findMin(int[] arr) {
        if(arr.length==1 || arr[0]<arr[arr.length-1]){
            return arr[0];
        }
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(mid+1<arr.length-1 && arr[mid+1]<arr[mid]){
                return arr[mid+1];
            }
            if(mid>0 && arr[mid-1]>arr[mid]){
                return arr[mid];
            }
            else if(arr[mid]<arr[high]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return arr[arr.length-1];
    }
}
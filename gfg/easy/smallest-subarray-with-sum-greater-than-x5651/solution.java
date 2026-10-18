class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        // code here
        int n = arr.length;
        
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        
        while(j < n) {
            
            sum += arr[j];
            
            while(sum > x) {
                
                minLen = Math.min(minLen, j - i + 1);
                sum -= arr[i];
                i++;
            }
            
            j++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // code here
        int n = arr.length;
        
        int i = 0, j = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        while(j < n) {
            
            if(arr[j] < 0) {
                q.add(arr[j]);
            }
            
            if(j - i + 1 == k) {
                
                if(!q.isEmpty()) {
                    list.add(q.peek());
                }
                else {
                    list.add(0);
                }
                
                if(!q.isEmpty() && arr[i] < 0) {
                    q.poll();
                }
                
                i++;
            }
            
            
            j++;
        }
        
        return list;
    }
}
class Solution {
    
    boolean allZero(int[] freq) {
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    int search(String pat, String txt) {
        // code here
        int m = pat.length();
        int n = txt.length();
        
        int[] freq = new int[26];
        for(char ch: pat.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        int i = 0, j = 0;
        int count = 0;
        
        while(j < n) {
            
            char ch = txt.charAt(j);
            
            freq[ch - 'a']--;
            
            if(j - i + 1 == m) {
                
                if(allZero(freq)) {
                    count++;
                }
                
                char prevCh = txt.charAt(i);
                freq[prevCh - 'a']++;
                i++;
            }
            
            j++;
        }
        
        return count;
        
    }
}
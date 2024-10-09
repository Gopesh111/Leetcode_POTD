class Solution {
    public int minAddToMakeValid(String s) {
        
        int open = 0; 
        int close = 0; 

        // Traverse the string to compute the number of parentheses needed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Every opening parenthesis expects a closing one
                close++;
            } else {
                
                if (close > 0) {
                    close--;
                } else {
                    
                    open++;
                }
            }
        }

       
        return open + close;
    }
}

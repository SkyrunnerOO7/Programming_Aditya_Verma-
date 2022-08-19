LEETCODE QUESTION LINK : https://leetcode.com/problems/super-egg-drop/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1

class Solution {
    
    int t[][] = new int[101][10001];
    
    public int solve(int e, int f) {
        
        if(f == 0 || f == 1){return f;}
        if(e == 1){return f;}
        
        if(t[e][f] != -1){return t[e][f];}
        
        int mn = Integer.MAX_VALUE;
        
        for(int k = 1; k <= f; k++)
        {
            int s1, s2;
            
            if(t[e-1][k-1] != -1){ s1 = t[e-1][k-1];}
            else{ s1 = solve(e-1, k-1);
                  t[e-1][k-1] = s1;}
            
            if(t[e][f-k] != -1){ s2 = t[e][f-k];}
            else{ s2 = solve(e, f-k);
                  t[e][f-k] = s2;}
            
            
            int temp = 1+Math.max(s1, s2);
            
            mn = Math.min(mn, temp);        
        }
        
        return t[e][f] = mn;
    }
    
    public int superEggDrop(int e, int f) {
    
        for(int[] row : t)
        {
            Arrays.fill(row, -1);
        }
        return solve(e,f);
    }
    
}

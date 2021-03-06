class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts); 
        Arrays.sort(verticalCuts); 
        int MOD=1_000_000_007;
        
         int m = horizontalCuts.length, n = verticalCuts.length;
         int maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
         int maxWidth = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        
        for (int i = 1; i < horizontalCuts.length; ++i) 
        {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; ++i) 
        {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        return (int)(maxHeight * 1L * maxWidth % MOD);
    }
}
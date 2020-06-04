/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99151/Super-simple-solution-using-reversed-string
 *  https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99151/Super-simple-solution-using-reversed-string/400365
 */
package com.polyg7ot.lc.lvl4.lc0516;

public class SolutionApproach0DP2 {
    public int longestPalindromeSubseq(String s) {
        // sanity check
        if(s == null || s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        final int L = s.length();
        
        int[][] dp = new int[L + 2][L + 2];
        for(int i = 1; i <= L; i++){
            for(int j = L; j > 0; j--){
                if(s.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j + 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[L][1];
    }
}
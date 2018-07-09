/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Example:
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

*/

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {

      if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0){
        return 0;
    }

    Arrays.sort(envelopes, new Comparator<int[]>() {

      @Override
      public int compare(int[] a, int[] b){
        return Integer.compare(a[0],b[0]);
      }
    });

    int ret = 0, n = envelopes.length;
    int[] dp = new int [n];
    for(int i=0;i<envelopes.length;i++){
      dp[i] = 1;
      for(int j=0;j<i;j++){
        if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
        dp[i] = Math.max(dp[i], dp[j]+1);
      }
      ret = Math.max(ret, dp[i]);
      }
      return ret;
    }
  }

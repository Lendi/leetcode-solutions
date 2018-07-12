/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return 0;

        int cLen = matrix[0].length;
        int rLen = matrix.length;
        int[] h = new int[cLen+1];
        h[cLen] = 0;
        int max = 0;

        for(int row = 0; row < matrix.length; row++)
        {
            Stack<Integer> s = new Stack<Integer>();
            for(int i = 0; i < cLen+1 ; i++)
            {
                if(i < cLen)
                    if(matrix[row][i] == '1')
                    {
                        h[i] += 1;
                    }

                    else h[i] =0;

                if(s.isEmpty() || h[s.peek()] <= h[i])
                {
                    s.push(i);
                }
                else{
                    while(!s.isEmpty() && h[i] < h[s.peek()])
                    {
                        int top = s.pop();
                        int area = h[top] * (s.isEmpty()? i: (i-1-s.peek()) );
                        if( area > max)
                        max = area;

                    }
                    s.push(i);
                }
            }
        }

        return max;

    }
}

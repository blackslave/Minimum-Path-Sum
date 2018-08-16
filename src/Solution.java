/**
 * 採用動態規劃法，建立一個DP陣列用來記錄路徑的總和，而最短路徑為dp[i][j]=Min(dp[i-1][j],dp[i-1][j])
 * 也就是前一次移動的最小權值，將每次最小權值記錄下來後，利用迴圈走訪完整個陣列，求出最後的DP陣列總和即為答案。
 * @author black
 *
 */
public class Solution {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];
        if(m==0||n==0) return 0;
        dp[0][0] = grid[0][0];
        //記錄橫向總和
        for(int i=1;i<n;i++)
        {
        	dp[0][i]= dp[0][i-1]+grid[0][i];
        }
        //記錄縱向總和
        for(int j=1;j<m;j++)
        {
        	dp[j][0]= dp[j-1][0]+grid[j][0];
        }
        //使用記錄下來的總和作為權值，進行路徑選擇，並走訪完陣列
        for(int i=1;i<m;i++)
        {
        	for(int j=1;j<n;j++)
        	{
        		if(dp[i-1][j]<dp[i][j-1])
        			dp[i][j]=dp[i-1][j]+grid[i][j];
        		else
        			dp[i][j]=dp[i][j-1]+grid[i][j];
        	}
        }
        return dp[m-1][n-1];
    }
}

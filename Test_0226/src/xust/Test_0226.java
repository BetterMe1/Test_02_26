package xust;

/*
836. 矩形重叠
矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
给出两个矩形，判断它们是否重叠并返回结果。

示例 1：
输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
输出：true
示例 2：
输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
输出：false
说明：
两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 */
/*
 * 分析：
 * 判断矩形的重叠，一种思路就是一一列举出矩形重叠的情况，判断是否为其中一种，而矩形的重叠要考虑多种情况，我们在思考过程中很有可能就漏掉了某一种。
 * 因此可以逆向思考，考虑矩形不重叠的情况，以一个矩形为参考矩形，另一个矩阵不重叠的情况只会在它的上、下、左、右。
 */
//public class Test_0226 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] rec1 = {2,17,6,20};
//		int[] rec2 = {3,8,6,20};
//		System.out.println(So.isRectangleOverlap(rec1, rec2));
//	}
//}
//class Solution {
//    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//        return !(rec2[0]>=rec1[2] || rec2[2]<=rec1[0] || rec2[3]<=rec1[1] || rec2[1]>=rec1[3]);
//    }
//}
/*
840. 矩阵中的幻方
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

示例 1:
输入: [[4,3,8,4],
      [9,5,1,9],
      [2,7,6,2]]
输出: 1
解释: 
下面的子矩阵是一个 3 x 3 的幻方：
438
951
276
而这一个不是：
384
519
762
总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
提示:
1 <= grid.length = grid[0].length <= 10
0 <= grid[i][j] <= 15
 */
/*
 * 分析：
 * 每个3 x 3 的幻方矩阵都有一个中心点，遍历矩阵中可以成为幻方矩阵的点，判断由此点扩展成的3 x 3矩阵是否是幻方矩阵，是则计数，最终返回计数结果。
 * 而判断由中心点扩展成的3 x 3矩阵是否是幻方矩阵，就要判断它是否满足条件，判断矩阵是否是1到9填充，且无重复，再判断矩阵是否每行，
 * 每列以及两条对角线上的各数之和都相等，此处有个小技巧，若要满足各行、列、对角线之和相等，中心点必须是5，
 * 判断过程若有不符 ，返回false，若全部符合，返回true。
 */
public class Test_0226 {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
		System.out.println(So.numMagicSquaresInside(grid));
	}
}
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
    	int count = 0;
        for(int i=1; i<grid.length-1; i++){
        	for(int j=1; j<grid[0].length-1; j++){
        		if(isMagicSquare(grid,i,j))
        			count++;
        	}
        }
        return count;
    }
    private boolean isMagicSquare(int[][] grid,int i,int j){
    	if(grid[i][j] !=5)
    		return false;
    	int[]flag = new int[9];
    	for(int a=-1; a<=1;a++){
    		for(int b=-1; b<=1; b++){
    			if(1<=grid[i+a][j+b] && grid[i+a][j+b] <=9){
    				if(flag[grid[i+a][j+b]-1] == 1)
    					return false;
    				else
    					flag[grid[i+a][j+b]-1] = 1;
    			}
    			else{
    				return false;
    			}
    		}
    	}
    	if(grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] == grid[i][j]*3 &&
    	    	grid[i][j-1] + grid[i][j+1] == grid[i][j]*2 &&
    	    	grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1]== grid[i][j]*3 &&
    	    	grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] == grid[i][j]*3 &&
    	    	grid[i-1][j] + grid[i+1][j] == grid[i][j]*2 &&
    	    	grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1]== grid[i][j]*3 &&
    	    	grid[i-1][j-1] + grid[i+1][j+1] == grid[i][j]*2 &&
    	    	grid[i-1][j+1] + grid[i+1][j-1] == grid[i][j]*2)
    	    		return true;
    	    	return false;
    }
}
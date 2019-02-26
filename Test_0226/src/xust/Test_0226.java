package xust;

/*
836. �����ص�
�������б� [x1, y1, x2, y2] ����ʽ��ʾ������ (x1, y1) Ϊ���½ǵ����꣬(x2, y2) �����Ͻǵ����ꡣ
����ཻ�����Ϊ��������������ص�����Ҫ��ȷ���ǣ�ֻ�ڽǻ�߽Ӵ����������β������ص���
�����������Σ��ж������Ƿ��ص������ؽ����

ʾ�� 1��
���룺rec1 = [0,0,2,2], rec2 = [1,1,3,3]
�����true
ʾ�� 2��
���룺rec1 = [0,0,1,1], rec2 = [1,0,2,1]
�����false
˵����
�������� rec1 �� rec2 ���Ժ����ĸ��������б����ʽ������
�����е��������궼���� -10^9 �� 10^9 ֮�䡣
 */
/*
 * ������
 * �жϾ��ε��ص���һ��˼·����һһ�оٳ������ص���������ж��Ƿ�Ϊ����һ�֣������ε��ص�Ҫ���Ƕ��������������˼�������к��п��ܾ�©����ĳһ�֡�
 * ��˿�������˼�������Ǿ��β��ص����������һ������Ϊ�ο����Σ���һ�������ص������ֻ���������ϡ��¡����ҡ�
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
840. �����еĻ÷�
3 x 3 �Ļ÷���һ������д� 1 �� 9 �Ĳ�ͬ���ֵ� 3 x 3 ��������ÿ�У�ÿ���Լ������Խ����ϵĸ���֮�Ͷ���ȡ�
����һ����������ɵ� N �� N ���������ж��ٸ� 3 �� 3 �� ���÷��� �Ӿ��󣿣�ÿ���Ӿ����������ģ���

ʾ�� 1:
����: [[4,3,8,4],
      [9,5,1,9],
      [2,7,6,2]]
���: 1
����: 
������Ӿ�����һ�� 3 x 3 �Ļ÷���
438
951
276
����һ�����ǣ�
384
519
762
�ܵ���˵���ڱ�ʾ���������ľ�����ֻ��һ�� 3 x 3 �Ļ÷��Ӿ���
��ʾ:
1 <= grid.length = grid[0].length <= 10
0 <= grid[i][j] <= 15
 */
/*
 * ������
 * ÿ��3 x 3 �Ļ÷�������һ�����ĵ㣬���������п��Գ�Ϊ�÷�����ĵ㣬�ж��ɴ˵���չ�ɵ�3 x 3�����Ƿ��ǻ÷�����������������շ��ؼ��������
 * ���ж������ĵ���չ�ɵ�3 x 3�����Ƿ��ǻ÷����󣬾�Ҫ�ж����Ƿ������������жϾ����Ƿ���1��9��䣬�����ظ������жϾ����Ƿ�ÿ�У�
 * ÿ���Լ������Խ����ϵĸ���֮�Ͷ���ȣ��˴��и�С���ɣ���Ҫ������С��С��Խ���֮����ȣ����ĵ������5��
 * �жϹ������в��� ������false����ȫ�����ϣ�����true��
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
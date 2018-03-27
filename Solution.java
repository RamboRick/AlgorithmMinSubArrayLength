package leetcode209;
import static java.lang.Math.*;

import java.util.Arrays;
// 双指针滑动窗口
// 时间复杂度：O(n)
//空间复杂度：O(1)
public class Solution {
	public int minSubArrayLan(int s, int[] nums){
		int l =0, r = -1; // nums[l...r] 为我们的滑动窗口
		int sum = 0;
		int res = nums.length + 1;
		
		while( l < nums.length){
			if ( r+1 < nums.length && sum < s){
				r++;
				sum += nums[r];
			} else {
				 sum -= nums[l];
				 l++;
			}
			if ( sum >= s){
				res = min(res, r-l+1);
			}
		}
		if ( res == nums.length +1){
			return 0;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tst = { 1,2,2,3,1,3,4,1,1};
		int k = 4;
		Solution testSolution = new Solution();
		int q = testSolution.minSubArrayLan(k,tst);
		System.out.println(q);
	}

}

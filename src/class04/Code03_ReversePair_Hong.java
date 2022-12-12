package class04;

/**
 * 数组中，如果前一个数字大于后一个数字，这两个数字可以组成逆序对
 * 给定一个数组，求其中逆序对的数量，时间复杂度O(NlogN)
 * [7,5,6,4] 输出 5
 * 在改变原顺序的基础上，随机选2个，如果逆序，则满足条件记一条
 * 可以作为面试题
 *
 * @author : zhanpenghong
 * @date : 2022/11/11 17:09
 */
public class Code03_ReversePair_Hong {

	// 归并解
	public int reversePairs(int[] nums) {
		// 不要忘了临界条件的判断
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int l = 0;
		int r = nums.length - 1;
		int m = l + ((r - l) / 2);

		return processReverse(nums, l, m) + processReverse(nums, m + 1, r) + merge(nums, l, m, r);
	}

	public int processReverse(int[] nums, int l, int r) {
		// 递归的结束条件
		if (l >= r) {
			return 0;
		}
		int m = l + ((r - l) >> 1);
		return processReverse(nums, l, m) + processReverse(nums, m + 1, r) + merge(nums, l, m, r);
	}

	// 利用归并排序已经部分有序的特性，实现快速的逆序对的判断
	public int merge(int[] nums, int l, int m, int r) {
		int count = 0;
		int[] help = new int[r - l + 1];
		int pL = l;
		int pR = m + 1;
		int pH = 0;
		while (pL <= m & pR <= r) {
			if (nums[pL] <= nums[pR]) {
				help[pH++] = nums[pL++];
			} else {
				help[pH++] = nums[pR++];
				// pR小于pL，说明pR比pL以及之后所有位置都小，pL后面的元素都可以更pR当前位置组成逆序对
				count += m - pL + 1;
			}
		}
		while (pL <= m) {
			help[pH++] = nums[pL++];
		}
		while (pR <= r) {
			help[pH++] = nums[pR++];
		}
		for (int i = 0; i < help.length; i++) {
			nums[i + l] = help[i];
		}
		return count;
	}

	// 暴力解
	public int reversePairs01(int[] nums) {
		// 不要忘了临界条件的判断
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int count = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					count++;
				}
			}
		}

		return count;
	}
}
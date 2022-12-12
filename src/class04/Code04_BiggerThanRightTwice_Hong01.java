package class04;

//  本题测试链接 : https://leetcode.cn/problems/reverse-pairs/
public class Code04_BiggerThanRightTwice_Hong01 {

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
		int pL = m;
		int pR = r;
		int pH = help.length - 1;
		while (pL >= l & pR > m) {
			if (nums[pL] > nums[pR]) {
				int ppR = pR;
				int ppp = -1;
				while (ppR > m) {
					if ((long) nums[pL] > (long) nums[ppR] * 2) {
						ppp = ppR;
						break;
					} else {
						ppR--;
					}
				}
				if (ppp > 0) {
					// pR小于pL，说明pR比pL以及之后所有位置都小，pL后面的元素都可以更pR当前位置组成逆序对
					count += ppp - m;
				}
				help[pH--] = nums[pL--];
			} else {
				int ppL = pL;
				int ppp = -1;
				while (ppL >= l) {
					if ((long) nums[ppL] > (long) nums[pR] * 2) {
						ppp = ppL--;
					} else {
						break;
					}
				}
				if (ppp >= 0) {
					count += pL - ppp + 1;
				}
				help[pH--] = nums[pR--];
			}
		}
		while (pL >= l) {
			help[pH--] = nums[pL--];
		}
		while (pR > m) {
			help[pH--] = nums[pR--];
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
				if (nums[i] > 2 * nums[j]) {
					count++;
				}
			}
		}

		return count;
	}
}

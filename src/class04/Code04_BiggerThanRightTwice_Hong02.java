package class04;

//  本题测试链接 : https://leetcode.cn/problems/reverse-pairs/
public class Code04_BiggerThanRightTwice_Hong02 {

	public static int reversePairs(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		// l < r
		int mid = l + ((r - l) >> 1);
		return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	public static int merge(int[] nums, int l, int m, int r) {
		// [L....M] [M+1....R]
		int ans = 0;
		// 目前囊括进来的数，是从[M+1, windowR)
		for (int i = m; i >= l; i--) {
			int windowR = r;
			int ppp = -1;
			while (windowR > m) {
				if ((long) nums[i] > (long) nums[windowR] * 2) {
					ppp = windowR;
					break;
				} else {
					windowR--;
				}
			}
			if (ppp > 0) {
				ans += ppp - m;
			}
		}
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
		}
		while (p1 <= m) {
			help[i++] = nums[p1++];
		}
		while (p2 <= r) {
			help[i++] = nums[p2++];
		}
		for (i = 0; i < help.length; i++) {
			nums[l + i] = help[i];
		}
		return ans;
	}

	// for test
	public static int comparator(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > (arr[j] << 1)) {
					ans++;
				}
			}
		}
		return ans;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			if (reversePairs(arr1) != comparator(arr2)) {
				System.out.println("Oops!");
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println("测试结束");
	}

}

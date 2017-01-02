package test.array;

public class FindRangeSortedDuplicatesArray {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 2, 3, 3, 3, 3, 4, 7, 7, 9 };
		Range range = findDuplicateNumberRange(nums, 3);
		System.out.println(range);

		int[] nums2 = { 3, 3, 3, 3 };
		range = findDuplicateNumberRange(nums2, 3);
		System.out.println(range);
	}

	public static Range findDuplicateNumberRange(int[] nums, int toFind) {
		Range notFound = new Range(-1, -1);

		if (nums == null || nums.length == 0) {
			return notFound;
		}

		int startIndex = notFound.startIndex;
		int endIndex = notFound.endIndex;
		int n = nums.length;
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == toFind && (mid == 0 || nums[mid - 1] < toFind)) {
				startIndex = mid;
				break;
			} else if (nums[mid] < toFind) {
				low = mid + 1;
			} else if (nums[mid] >= toFind) {
				high = mid - 1;
			}
		}

		low = 0;
		high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == toFind && (mid == n - 1 || nums[mid + 1] > toFind)) {
				endIndex = mid;
				break;
			} else if (nums[mid] <= toFind) {
				low = mid + 1;
			} else if (nums[mid] > toFind) {
				high = mid - 1;
			}
		}

		return new Range(startIndex, endIndex);
	}

	private static class Range {
		int startIndex;
		int endIndex;

		public Range(int startIndex, int endIndex) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}

		public String toString() {
			return "[" + this.startIndex + ", " + this.endIndex + "]";
		}
	}
}

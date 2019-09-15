import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		
		int[] nums = new int[5];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = (-10 + (int)(Math.random() * (30)));
		}
		
		System.out.println(Arrays.toString(nums));
		sort(nums);
		System.out.println(Arrays.toString(nums));

		}
	
	public static void sort(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int key = nums[i];
			int j = i - 1;
			
			while(j >= 0 && nums[j] > key) {
				nums[j+1] = nums[j];
				j--;
			}
			
			nums[j+1] = key;
		}
	}

}

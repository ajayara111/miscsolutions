public class TwoSum {
    public static  int[] findTwoSum(int[] numbers, int target) {
        java.util.Arrays.sort(numbers);
        int start = 0, end = numbers.length - 1;
        while(start < end) {
            if(numbers[start] + numbers[end] < target) {
                start++;
            }
            else if(numbers[start] + numbers[end] > target) {
                end--;
            }
            else {
                int[] result = {start + 1, end + 1};
                return result;
            }
        }
        return null;
}
    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}
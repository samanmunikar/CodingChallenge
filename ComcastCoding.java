import java.util.*;

public class ComcastCoding {
    public static void main(String args[]) {
      int[] numbers = {2,7,11,15};
      int target = 9;
      
      if (numbers.length < 2 || numbers.length > 30000) {
          throw new RuntimeException("The array numbers has at least two elements and at most 30,000 elements.");
      }
      
      var filteredNumbers = Arrays.stream(numbers)
                            .filter(num -> num > -1000 && num < 1000)
                            .sorted()
                            .toArray();
      
      var result = findSum(numbers, target);
      
      System.out.println(Arrays.toString(result));
    }
    
    public static int[] findSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            
            if (sum == target) {
                return new int[] {leftIndex + 1, rightIndex + 1};
            } else if (sum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        
        return null;
    }
}
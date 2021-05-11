import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //Example inputs + one extra input
        int[] input1 = {1, 2, 1};
        int[] input2 = {0, 1, 2, 2};
        int[] input3 = {1, 2, 3, 2, 2};
        int[] input4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] input5 = {1, 1, 1, 1, 2, 1, 1, 2, 3, 3, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //Printing out the outputs
        System.out.println(totalFruit(input1));
        System.out.println(totalFruit(input2));
        System.out.println(totalFruit(input3));
        System.out.println(totalFruit(input4));
        System.out.println(totalFruit(input5));
    }

    public static int totalFruit(int[] tree) {
        //Checking if the tree is null
        if(tree == null || tree.length == 0) {
            return 0;
        }
        //Using the sliding window approach, the goal is to find the longest consecutive occurrence of 2 numbers
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 1;

        while(j < tree.length) {
            //If there are less than 2 different types of fruits
            if(bucket.size() <= 2) {
                bucket.put(tree[j], j++);
            }
            //If the are more than 2 different types of fruits
            if(bucket.size() > 2) {
                int min = tree.length - 1;
                for(int value: bucket.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;
                bucket.remove(tree[min]);
            }
            maxLength = Math.max(maxLength, j-i);
        }
        return maxLength;
    }
}

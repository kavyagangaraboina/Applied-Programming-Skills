import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        // If permutation size equals array length
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {

            // Skip if already used
            if (temp.contains(num))
                continue;

            temp.add(num); // choose

            backtrack(nums, temp, result); // explore

            temp.remove(temp.size() - 1); // unchoose
        }
    }
}
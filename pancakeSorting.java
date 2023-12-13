969. Pancake Sorting

Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], 
so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. 
Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.


Example 1:

Input: arr = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [1, 4, 2, 3]
After 2nd flip (k = 2): arr = [4, 1, 2, 3]
After 3rd flip (k = 4): arr = [3, 2, 1, 4]
After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
Example 2:

Input: arr = [1,2,3]
Output: []

  
Solution:
  
class Solution {
    //Tc: O(n^2) and Sc: O(1) 
    public List<Integer> pancakeSort(int[] arr) {
         List<Integer> result = new ArrayList<>();

         int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int maxIndex = findMaxIndex(arr, i);

            flip(arr, maxIndex);
            result.add(maxIndex + 1); 
            flip(arr, i);
            result.add(i + 1); 
        }

        return result;
    }

    private int findMaxIndex(int[] arr, int end) {
        int maxIndex = 0;
        for (int i = 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void flip(int[] arr, int k) {
        int start = 0;
        while (start < k) {
            int temp = arr[start];
            arr[start] = arr[k];
            arr[k] = temp;
            start++;
            k--;
        }
    }
}
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.



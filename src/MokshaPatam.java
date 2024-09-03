import java.util.ArrayList;
import java.util.Arrays;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        System.out.println("boardsize: " + boardsize);
        System.out.println(Arrays.deepToString(ladders));
        System.out.println(Arrays.deepToString(snakes));

        int moves = 0;
        // Sort ladders by starting position to make traversing easier
        // Call quicksort method
        quickSort(ladders);
        System.out.println(Arrays.deepToString(ladders));

        // Use recursion to consider all possible combos of ladders.

        // For each combo, add # of moves to reach start of ladders, # of moves b/w ladders, and # of moves to reach end
        // Store all of these counts in an arraylist
        // Return lowest value in arraylist
        return 0;
    }

    // Reference code: https://www.geeksforgeeks.org/quick-sort-algorithm/
    // Quicksort used to organize ladders
    public static void quickSort(int[][] ladders){
        // Find low & high start values for quicksort
        int low = 100;
        int high = 1;
        for (int[] ladder: ladders){
            if (ladder[0] > high) {
                high = ladder[0];
            }
            if (ladder[0] < low) {
                low = ladder[0];
            }
        }
        quickSortHelper(ladders, low, high);
    }

    // Change return type
    // Quicksort helper method
    public static void quickSortHelper(int[][] ladders, int low, int high){
        if (low < high){
            // Get pivot index of array
            int pivot = partition(ladders, low, high);
            // Sort ladders by start value on both sides of the pivot
            // Recursion!
            quickSortHelper(ladders, low, pivot - 1);
            quickSortHelper(ladders, pivot + 1, high);
        }
    }

    // Put all smaller values on left of pivot & bigger values on right
    public static int partition(int[][] ladders, int low, int high){
        // Pivot = last element's start value
        int pivot = ladders[high][0];
        // Index of element smaller than pivot
        int i = low - 1;

        for (int j = low; j < high; j++){
            // If current element's start value is smaller than or equal to pivot's start value
            if (ladders[j][0] <= pivot){
                // Swap smaller & larger elements
                int[] temp = ladders[i];
                ladders[i] = ladders[j];
                ladders[j] = temp;
            }
        }

        // Swap elements into proper positions
        int[] temp2 = ladders[i + 1];
        ladders[i + 1] = ladders[high];
        ladders[high] = temp2;

        return i + 1;
    }
}


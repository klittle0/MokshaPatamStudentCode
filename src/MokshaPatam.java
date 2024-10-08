import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Kate Little
 *
 */

public class MokshaPatam {

    //Return the minimum number of moves to reach the final square on a board
    // With the given size, ladders, and snakes.
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        // Each index represents each square, and each corresponding value represents # of rolls to get there
        int[] rollCounts = new int[boardsize + 1];
        // Maps the starts & ends of all snakes & ladders
        int[] snakesAndLadders = new int[boardsize + 1];
        // Tracks whether a space has been visited before. Index = square #, value = true/false
        boolean[] visited = new boolean[boardsize + 1];
        Queue<Integer> toBeVisited = new LinkedList<>();
        int current = 1;

        // Map all snakes and ladders to the "dictionary" that tracks their starts & ends
        // start = index, end = corresponding value
        for (int[] ladder : ladders) {
            snakesAndLadders[ladder[0]] = ladder[1];
        }
        for (int[] snake : snakes) {
            snakesAndLadders[snake[0]] = snake[1];
        }

        toBeVisited.add(current);
        rollCounts[current] = 0;

        while (!toBeVisited.isEmpty()){
            current = toBeVisited.remove();
            // Help track which nodes are visited so you don't revisit any later on
            visited[current] = true;

            // If you have reached the end
            if (current == boardsize){
                return rollCounts[current];
            }
            // i = 1 through 6 to represent all possible dice rolls
            for (int i = 1; i < 7; i++){
                int next = current + i;
                // Ensure you can't go beyond the last board space
                if (next <= boardsize){
                    // If a snake or ladder begins at next proposed space, actual next space = end of snake/ladder
                    if (snakesAndLadders[next] != 0){
                        next = snakesAndLadders[next];
                    }
                    // If next node has never been visited:
                    if (!visited[next]){
                        // Increment the roll count, but only if it shows a more efficient path
                        if (rollCounts[next] == 0 || rollCounts[current] + 1 < rollCounts[next]){
                            rollCounts[next] = rollCounts[current] + 1;
                            toBeVisited.add(next);
                        }
                        // Otherwise, don't add the next space to the "toBeVisited" because it is already
                        // less efficient than an existing option
                    }
                }
            }
        }
        // Signals that board is impossible to win
        return -1;
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

        int[] boardSpots = new int[boardsize];
        int end = boardsize;
        int start = 1;
        int moves = 0;

        Queue<Integer> toBeVisited = new LinkedList<>();

        toBeVisited.add(start);



        return 0;
    }

    public void BFS(int current, Queue<Integer> toBeVisited, int[][] ladders, int[][] snakes){
        // Base Case is when end of board is reached:
        if (current == 100){
            return;
        }
        // Check to see if current space is the start of any snake or ladder
        for (int[] ladder : ladders){
            if (current == ladder[0]){
                toBeVisited.add(ladder[0]);
                break;
            }
            else if (current == snakes[0]){
               toBeVisited.add(snakes[0]);
                break;
            }
        }
        // I need to move this so it actually works!!
        // If current space doesn't equal ladder or snake start, add 6 following spaces
        for (int i = 0; i < 6; i++){
            toBeVisited.add(current + i);
        }

        // Recursive BFS call
        BFS(toBeVisited.remove(), toBeVisited, ladders, snakes);


        // If the # corresponds to the start of any snakes or ladders, actually just add the ending point
        // Otherwise, just add the # on the board itself

    }


}


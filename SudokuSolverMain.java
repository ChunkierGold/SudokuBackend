public class SudokuSolverMain {
    public static void main(String[] args) throws Exception {
        int[][] test = {{5,3,0,0,7,0,0,0,0}, {6,0,0,1,9,5,0,0,0}, {0,9,8,0,0,0,0,6,0}, {8,0,0,0,6,0,0,0,3}, {4,0,0,8,0,3,0,0,1}, {7,0,0,0,2,0,0,0,6}, {0,6,0,0,0,0,2,8,0}, {0,0,0,4,1,9,0,0,5}, {0,0,0,0,8,0,0,7,9}};
    //    Puzzle testSolver = new Puzzle(test);
    //    int[][] solution = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6}, {9,6,1,5,3,7,2,8,4}, {2,8,7,4,1,9,6,3,5}, {3,4,5,2,8,6,1,7,9}};
        int[][] daily = {{0,0,0,0,0,0,0,6,0}, {7,0,0,9,0,0,0,0,0}, {0,2,0,1,0,5,0,7,4}, {0,0,0,2,0,0,4,0,0}, {0,0,0,0,0,0,0,0,0}, {3,0,0,5,4,0,0,1,8}, {6,0,0,0,8,0,0,0,1}, {0,3,0,0,0,2,0,0,0}, {5,0,0,3,0,6,0,0,0}};
        Puzzle testSolver = new Puzzle(daily);
   //     testSolver.printPuzzle();
        System.out.println();
//        System.out.println(testSolver.checkIfSolved(solution));

     //   System.out.println(testSolver.gridContains(daily, 0, 7, 7));


        testSolver.printArray(testSolver.bruteFroce());
//        testSolver.printPuzzle();
    }
}

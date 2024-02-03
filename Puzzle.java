import java.util.Arrays;
import java.util.HashSet;

public class Puzzle {
  private int[][] sudokuArray;
  private static final int SUM = 45;
  
  public Puzzle() {
    sudokuArray = new int[9][9];
  }
  public Puzzle(int[][] input) {
    sudokuArray = input;
  }

  public void printPuzzle() {
    for (int r = 0; r < sudokuArray.length; r++) {
      for (int c = 0; c < sudokuArray[r].length; c++) {
        System.out.print(sudokuArray[r][c] + " ");
      }
      System.out.println();
    }
  }

  public void printArray(int[][] array) {
    for (int r = 0; r < array.length; r++) {
      for (int c = 0; c < array[r].length; c++) {
        System.out.print(array[r][c] + " ");
      }
      System.out.println();
    }
  }
  public int[][] bruteFroce() {
    int[][] testArray = new int[9][9]; 
    for (int i = 0; i < sudokuArray.length; i++) {
      testArray[i] = Arrays.copyOf(sudokuArray[i], sudokuArray[i].length);
    }

    for (int i = 0; i < testArray.length; i++) {
      for (int j = 0; j < testArray[i].length; j++) {
        if (testArray[i][j] != 0) {
          if (bruteForceHelper(testArray, 0, 0)) {
            return testArray;
          }
        }
      }
    }

    System.out.println("Fuck");
    return null;
  }

  public boolean bruteForceHelper(int[][] testArray, int row, int col) {
    int currentRow = row;
    int currentCol = col;
    if (row == 8 && col == 9) {
      return checkIfSolved(testArray);
    } else {
      if (testArray[row][col] != 0) {
        col++;
        if (col == 9 && row != 8) {
          col = 0;
          row++;
        }
        if (bruteForceHelper(testArray,row,col)) {
          return true;
        }
        return false;
      }
      for (int i = 1; i < 10; i++) {
        if (rowContains(testArray, row, i) || colContains(testArray, col, i) || gridContains(testArray, row, col, i)) {
          continue;
        }
        testArray[row][col] = i;
        col++;
        if (col == 9 && row != 8) {
          col = 0;
          row++;
        }

        if (bruteForceHelper(testArray, row, col)) {
          return true;
        } else if (row == 8 && col == 9) {
          return false;
        }
        row = currentRow;
        col = currentCol;
        testArray[row][col] = 0;
      }
      return false;
    }
  }

  public boolean rowContains(int[][] array, int row, int num) {
    for (int i = 0; i < array[row].length; i++) {
      if (array[row][i] == num) {
        return true;
      }
    } 

    return false;
  }

  public boolean colContains(int[][] array, int col, int num) {
    for (int i = 0; i < array.length; i++) {
      if (array[i][col] == num) {
        return true;
      }
    }
    return false;
  }

  public boolean gridContains(int[][] array, int row, int col, int num) {
    if (row < 3) {
      if (col < 3) {
        for (int r = 0; r < 3; r++) {
          for (int c = 0; c < 3; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      } else if (col >= 3 && col < 6) {
        for (int r = 0; r < 3; r++) {
          for (int c = 3; c < 6; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      } else {
        for (int r = 0; r < 3; r++) {
          for (int c = 6; c < 9; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      }

    } else if (row >= 3 && row < 6) {
      if (col < 3) {
        for (int r = 3; r < 6; r++) {
          for (int c = 0; c < 3; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      } else if (col >= 3 && col < 6) {
        for (int r = 3; r < 6; r++) {
          for (int c = 3; c < 6; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      } else {
        for (int r = 3; r < 6; r++) {
          for (int c = 6; c < 9; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      }

    } else {
      if (col < 3) {
        for (int r = 6; r < 9; r++) {
          for (int c = 0; c < 3; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      } else if (col >= 3 && col < 6) {
        for (int r = 6; r < 9; r++) {
          for (int c = 3; c < 6; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      } else {
        for (int r = 6; r < 9; r++) {
          for (int c = 6; c < 9; c++) {
            if (array[r][c] == num) {
              return true;
            }
          }
        }

      }

    }
    
    return false;
  }

  public boolean checkIfSolved(int[][] puzzle) {
    for (int r = 0; r < puzzle.length; r++) {
      int tempSum = 0;
      for (int c = 0; c < puzzle.length; c++) {
        tempSum += puzzle[r][c];
      }
      if (tempSum != SUM) {
        return false;
      }
    }

    for (int c = 0; c < puzzle.length; c++) {
      int tempSum = 0;
      for (int r = 0; r < puzzle.length; r++) {
        tempSum += puzzle[r][c];
      }
      if (tempSum != SUM) {
        return false;
      }
    }
    
    HashSet<Integer> block = new HashSet<Integer>(); 
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        block.clear();
        for (int k = i; k < (i + 3); k++) {
          for (int l = j; l < (j + 3); l++) {
            block.add(puzzle[k][l]);
          } 
        }
        if (block.size() != 9) {
          return false;
        }
      }
    }

    return true;
  }
}

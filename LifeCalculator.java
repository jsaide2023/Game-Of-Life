/***
 * A class that calculates the life status of Cell
 * in a Grid
 */
public class LifeCalculator {
  /***
   * Calculates the number of alive neighbors around the cell at
   * cells[row][col]
   * @param row, contains the x-coordinate of the cell
   * @param col, contains the y-coordinate of the cell
   * @param aGrid, contains the Grid that the cell[row][col] belongs to
   * @return countAlive, number of alive neighbors
   */
  public static int countAliveNeighbors(int row, int col, Grid aGrid) {
    int countAlive = 0;

    for ( int i = row - 1; i <= row + 1 && i < aGrid.getSIZE_OF_GRID(); i++) {
      if (i < 0) continue;
      for ( int j = col - 1; j <= col + 1 && j < aGrid.getSIZE_OF_GRID(); j++) {
        if (j < 0) continue;
        if (aGrid.cells[i][j].getLifeStatus() == 'X')
          countAlive++;
      }
    }
    if (aGrid.cells[row][col].getLifeStatus() == 'X') // make sure it doesn't count itself as an alive neighbor
      countAlive--;
    return countAlive;
  }

  /***
   * Calculates that status of the cell[row][col] in the next
   * Generation
   * @param row, contains the x-coordinate of the cell
   * @param col, contains the y-coordinate of the cell
   * @param aGrid, contains the Grid that the cell[row][col] belongs to
   * @param newGen, the Grid that will contain the new status of cell[row][col]
   */
  public static void calculateLife (int row, int col, Grid aGrid, Grid newGen) {
    int countAlive = countAliveNeighbors(row, col, aGrid);

    if (aGrid.cells[row][col].getLifeStatus() == 'O' && countAlive == 3) {
      newGen.cells[row][col].setLifeStatus('X');
    }
    else if (countAlive >= 2 && countAlive <= 3 &&
        aGrid.cells[row][col].getLifeStatus() == 'X') {
      newGen.cells[row][col].setLifeStatus('X');
    }
    else {
      newGen.cells[row][col].setLifeStatus('O');
    }
  }

}

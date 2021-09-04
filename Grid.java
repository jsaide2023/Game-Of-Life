/***
 * A class that creates a Grid of Cells in
 * Game of Life
 */
public class Grid {
  private final int SIZE_OF_GRID = 20;
  public Cell [][] cells;

  /***
   * Constructs a Grid Object that contains
   * 2D Array of Cells
   */
  public Grid() {
    cells = new Cell [SIZE_OF_GRID][SIZE_OF_GRID];
    for (int i = 0; i < SIZE_OF_GRID; i++) {
      for (int j = 0; j < SIZE_OF_GRID; j++) {
        cells[i][j] = new Cell('O');
      }
    }
  }

  /***
   * prints the Grid to the console
   */
  public void printGrid() {
    for (int i = 0; i < SIZE_OF_GRID; i++) {
      for (int j = 0; j < SIZE_OF_GRID; j++)
        System.out.print(cells[i][j].getLifeStatus());
      System.out.println();
    }
  }

  /***
   * Saves a copy of supplied Grid into current Grid
   * @param copyGrid the Grid that is to be copied
   */
  public void copyGrid(Grid copyGrid) {
    for (int i = 0; i < SIZE_OF_GRID; i++)
      for (int j = 0; j < SIZE_OF_GRID; j++)
        cells[i][j].setLifeStatus(copyGrid.cells[i][j].getLifeStatus());
  }

  /***
   * Sets all Cells within the Grid to 'O'
   */
  public void clearGrid() {
    for (int i = 0; i < SIZE_OF_GRID; i++)
      for (int j = 0; j < SIZE_OF_GRID; j++)
        cells[i][j].setLifeStatus('O');
  }

  /***
   * returns the value of SIZE_OF_GRID
   * @return value in SIZE_OF_GRID
   */
  public int getSIZE_OF_GRID() {
    return SIZE_OF_GRID;
  }

}

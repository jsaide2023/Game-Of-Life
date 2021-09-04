/***
 * A class that represents a square in a
 * Grid
 */
public class Cell {
  private char lifeStatus;

  /***
   * Constructs a Cell Objects that is initialized
   * with a char
   * @param lifeMark, a character that contains the
   *                  cell's life status
   */
  public Cell (char lifeMark) {
    lifeStatus = lifeMark;
  }

  /***
   * Retrieves the lifeMarker to whomever called
   * the function
   * @return lifeStatus
   */
  public char getLifeStatus() {
    return lifeStatus;
  }

  /***
   * Sets the life Status to the character in
   * lifeMarker
   * @param lifeMarker, a character that contains the
   *                    cell's life status
   */
  public void setLifeStatus(char lifeMarker) {
    this.lifeStatus = lifeMarker;
  }
}

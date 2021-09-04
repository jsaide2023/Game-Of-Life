/***
 * A class that creates a thread to calculate
 * the status of a cell in the next generation
 */
public class CellThreads extends Thread {
  public Signal phaseRunning = new Signal();
  public Signal phaseComplete = new Signal();
  public Signal goForPhase = new Signal();

  private final int row;
  private final int col;
  private final Grid oldGrid;
  private final Grid newOne;
  private final int numGenerations;

  public void resetRunning() { phaseRunning = new Signal(); }
  public void resetComplete() { phaseComplete = new Signal(); }

  public CellThreads(int row, int col, Grid oldGrid, Grid newOne, int numOfGens) {
    this.row = row;
    this.col = col;
    this.oldGrid = oldGrid;
    this.newOne = newOne;
    this.numGenerations = numOfGens;
  }


  public void run() {
    for (int i = 0; i < numGenerations; i++) {
     try {doGenerations(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
  }

  public void doGenerations() throws InterruptedException {
    goForPhase.waitForSignal(); goForPhase = new Signal();
    phaseRunning.setSignal();
    LifeCalculator.calculateLife(row, col, oldGrid, newOne);
    phaseComplete.setSignal();
  }

}

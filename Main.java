import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Grid startingGrid = new Grid();

    File startFile = new File ("src/Start.txt");
    int numOfGen = 0;


    try {
      Scanner in = new Scanner (startFile);
      initializeBoard(startingGrid, in);
      numOfGen = getNumOfGen(in);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println("This Is The Starting Configuration: ");

    startingGrid.printGrid();
    System.out.println();

    lifeThread(startingGrid, new Grid(), numOfGen);

    System.out.println("This Is The Board After " + numOfGen + " Generations: ");
    startingGrid.printGrid();
  }


  public static int getNumOfGen(Scanner in) {
    int numOfGen = 0;
    if (in.hasNext())
      numOfGen = in.nextInt();

    return numOfGen;
  }

  public static void initializeBoard(Grid aGrid, Scanner in) {
      int i = 0;
      while (in.hasNextLine() && i < aGrid.getSIZE_OF_GRID()) {
        String rowHolder = in.nextLine();
        for (int j = 0; j < rowHolder.length(); j++) {
          aGrid.cells[i][j].setLifeStatus(rowHolder.charAt(j));
        }
        i++;
      }
  }

  public static void lifeThread (Grid oldGrid, Grid newGen, int numOfGens)
      throws InterruptedException {

    ArrayList<CellThreads> threads = new ArrayList<>();

    for (int i = 0; i < oldGrid.getSIZE_OF_GRID(); i++) {
      for (int j = 0; j < oldGrid.getSIZE_OF_GRID(); j++) {
        threads.add(new CellThreads(i, j, oldGrid, newGen, numOfGens));
      }
    }

    for (CellThreads t : threads) t.start();
    for (int i = 0; i < numOfGens; i++) {

      for (CellThreads t : threads) t.goForPhase.setSignal();
      for (CellThreads t : threads) t.phaseRunning.waitForSignal();

      for (CellThreads t : threads) t.resetRunning();
      for (CellThreads t : threads) t.phaseComplete.waitForSignal();


      for (CellThreads t : threads) t.resetComplete();

      oldGrid.copyGrid(newGen);     //oldGrid receives a copy of newGen
      newGen.clearGrid();           //clears newGen to save the incoming generation
    }

    for (CellThreads t : threads) t.join();
  }

}

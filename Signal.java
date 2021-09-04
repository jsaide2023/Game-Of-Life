
public class Signal {
  private boolean signalled = false;
  public synchronized void setSignal() { signalled = true; notifyAll();}
  public synchronized void waitForSignal() throws InterruptedException { while (!signalled) wait();}
}

/**
 * javac BitwiseNegSynchronized.java
 */
public class BitwiseNegSynchronized {
    static public Flag flag = new Flag();
    static public void main(String[] args) {
        ThreadStarter thx0 = new ThreadStarter();
        ThreadStarter thx1 = new ThreadStarter();
	    try{
            thx0.start();
            thx1.start();

            thx0.join();
            thx1.join();
        }catch(Exception ex){
            ex.printStackTrace();
        }
	    assert flag.getFlag() : "flag toggle is false";
    }
}

final class Flag {
    private boolean flag = true;
    public synchronized void toggle() {
        flag ^= true;      // Same as flag = !flag;
    }
    public synchronized boolean getFlag() {
        return flag;
    }
}

final class ThreadStarter extends Thread {
    @Override
    public void run() {
        BitwiseNegSynchronized.flag.toggle();
    }
}

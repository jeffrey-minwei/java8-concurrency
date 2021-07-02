/**
 * javac BitwiseNegation.java
 */
public class BitwiseNegation {
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
    public void toggle() { // Unsafe
        flag ^= true;      // Same as flag = !flag;
    }
    public boolean getFlag() { // Unsafe
        return flag;
    }
}

final class ThreadStarter extends Thread {
    @Override
    public void run() {
        BitwiseNegation.flag.toggle();
    }
}

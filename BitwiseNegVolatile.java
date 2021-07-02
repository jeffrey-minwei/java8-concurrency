/**
 * javac BitwiseNegVolatile.java
 */
public class BitwiseNegVolatile {
    static public Flag flag = new Flag();
    static public void main(String[] args) {
        ThreadStarter thx0 = new ThreadStarter();
        ThreadStarter thx1 = new ThreadStarter();
        ThreadStarter thx2 = new ThreadStarter();
        ThreadStarter thx3 = new ThreadStarter();
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
    private volatile boolean flag = true;
    public void toggle() { // Unsafe
        flag ^= true;
    }
    public boolean getFlag() { // safe
        return flag;
    }
}

final class ThreadStarter extends Thread {
    @Override
    public void run() {
        BitwiseNegVolatile.flag.toggle();
    }
}

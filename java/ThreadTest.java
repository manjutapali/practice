class Multithread extends Thread
{
    public Multithread(String name)
    {
        super(name);
    }
    public void run()
    {
        System.out.println("Executing run function: ");
        Thread t = Thread.currentThread();
        for(int i = 0; i < 10; i++)
          System.out.println("Current thread name is: " + t.getName());
    }
}

public class ThreadTest
{
    public static void main(String[] args) {
        Multithread m1 = new Multithread("m1");
        Multithread m2 = new Multithread("m2");
        m1.start();

        try{
          m1.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        m2.start();
    }
}

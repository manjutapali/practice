import java.io.*;

public class SerializationTest
{
    public static void main(String[] args)
    {
        Test t = new Test(10, 20);

        //serialization
        try
        {
            System.out.println("Serializing object.......");

            FileOutputStream file = new FileOutputStream("abc.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(t);

            out.close();
            file.close();

            System.out.println("object serialized");

        }
        catch(IOException e)
        {
            System.out.println("IOException:");
        }

        // Deserializing the object
        Test t1 = null;
        try
        {
            System.out.println("Deserializing object....");

            FileInputStream file = new FileInputStream("abc.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            t1 = (Test) in.readObject();

            in.close();
            file.close();

            System.out.println("Deserialized object");

        }
        catch(IOException e)
        {
            System.out.println("IOException:");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException");
        }

        System.out.println("-------Object contents----------");
        System.out.println("a = " + t1.a);
        System.out.println("b = " + t1.b);

    }
}

class Test implements java.io.Serializable
{
    int a;
    int b;
    public Test(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}

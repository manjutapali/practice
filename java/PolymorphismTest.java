public class PolymorphismTest
{
    public static void main(String[] args)
    {
        AnimalTest d = new AnimalTest("Deer");
        /*
            1. when instance created without parameter, default constructor of both
            child & parent class are called.

            2. When instance is create with parameter, default constructor of parent
            & parameter constructor of child are called.

            3. To invoke parent parameter constructor use super key word with passing parameter
              Eg: super(name);

            4. super() call should be the first line of constructor.
        */

        d.PrintAnimalName();
        System.out.println("Animal " + (d.IsEats() ? "Eats": "does not Eats"));
        /*
            1. to invoke parent class methods that are overriden super key word is used.
              Eg: super.PrintAnimalName();
        */

        // polymorphism
        Animal d2 = new AnimalTest("Devendra");
        // System.out.println("Animal is " + (d2.IsHerbivores() ? "Herbivores" : "carnivores")); - throws error
        d2.PrintAnimalName();
        boolean IsHerbivores = ((AnimalTest) d2).IsHerbivores();
        System.out.println("Animal is " + (IsHerbivores ? "Herbivores" : "carnivores"));

        /*
            1. Parent reference, child instance will make call to the child class methods
              if methods are overriden.
            2. To call child class method should type cast object to child class
              and method call can be made
        */
    }
}

class Animal
{
    private String mAnimal = "";
    public Animal()
    {
        System.out.println("Animal in default constructor Parent class");
    }

    public Animal(String name)
    {
        mAnimal = name;
        System.out.printf("Animal name is %s in parameter constructor in Parent class\n", name);
    }

    public void PrintAnimalName()
    {
        System.out.println("--------Parent class------");
        if(mAnimal.equals(""))
        {
            System.out.println("No Animal");
            return;
        }

        System.out.println("Animal name is " + mAnimal);
    }

    public boolean IsEats()
    {
        System.out.println("------Parent class------");
        return true;
    }

}

class AnimalTest extends Animal
{
    private String mAnimal = "";
    public AnimalTest()
    {
        System.out.println("AnimalTest default constructor");
    }

    public AnimalTest(String name)
    {
        super(name);
        mAnimal = name;
        System.out.printf("Animal name  is %s in parameter constructor in child class\n", name);
    }


    public void PrintAnimalName()
    {
        System.out.println("-------child class------");
        //System.out.println("Is Eats " + super.IsEats());
        System.out.println("Animal name is " + mAnimal);
    }

    public boolean IsEats()
    {
        System.out.println("------child class--------");
        return true;
    }

    public boolean IsHerbivores()
    {
        return true;
    }
}

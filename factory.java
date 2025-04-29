interface Pizza 
{
    void prepare();
}
class MargheritaPizza implements Pizza 
{
    public void prepare() 
    {
        System.out.println("Preparing Margherita Pizza");
    }
}
class PepperoniPizza implements Pizza
 {
    public void prepare() 
    {
        System.out.println("Preparing Pepperoni Pizza");
    }
}

class VeggiePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Veggie Pizza");
    }
}

// Step 3: Create a Factory class to generate objects of concrete classes

class PizzaFactory 
{
        public Pizza getPizza(String type) 
        {
        if (type == null) return null;
        switch (type.toLowerCase()) 
        {
            case "margherita":
                return new MargheritaPizza();
            case "pepperoni":
                return new PepperoniPizza();
            case "veggie":
                return new VeggiePizza();
            default:
                System.out.println("Unknown Pizza type: " + type);
                return null;
        }
    }
}

// Step 4: Client code that uses the factory to get Pizza objects

public class Main {
    public static void main(String[] args)
     {
        PizzaFactory factory = new PizzaFactory();
        
        Pizza pizza1 = factory.getPizza("margherita");
        if (pizza1 != null) pizza1.prepare();

        Pizza pizza2 = factory.getPizza("veggie");
        if (pizza2 != null) pizza2.prepare();

        Pizza pizza3 = factory.getPizza("hawaiian");
        if (pizza3 != null) pizza3.prepare();
    }
}
public class Driver {
    // the bird speak now uses the overridden getName, while the Animal speak is unaffected.
  
    // Bird b2 = new Animal("Squaaaak", 4, "birdy"); does not work, because an Animal is not necessarily a bird. Bird, Y is a subclass of Animal,X, yet X is not always Y.
    public static void main(String[] args) {
      Animal a = new Animal("meow", 3, "Mittens");
      a.speak();
      System.out.println("-----------------------------------");
      Bird b = new Bird("Squaaaak", 4, "birdy", 32.0, "blue");
      b.speak();
      Animal a1 = new Animal("meow", 3, "Mittens");
      Bird b1 = new Bird("Squaaaak", 4, "birdy", 32.0, "blue");
      //Bird b2 = new Animal("Squaaaak", 4, "birdy");
      Animal a2 = new Bird("Squaaaak", 4, "birdy", 32.0, "blue");
    }
  
  }
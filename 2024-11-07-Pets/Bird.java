public class Bird extends Animal {
    private double height;
    private String color;
  
  
    //4.
    public Bird(String noise, int age, String name, double height, String color){
      //In order to construct the Bird you must first call the superclass constructor
      //This is done by saying: super(parameters)
      //e.g. super("Doug",10,"Squaaaak!");
      super(noise, age, name);
      this.height = height;
      this.color = color;
    }
  
  
    //6.Override the speak() method.
    /*WITHOUT REPEATING CODE:
    print the following message replacing the ? with name/age/noise/color/height:
      My name is ?.
      I am ? years old.
      I say ?.
      My feathers are colored ?
      I am ? inches tall
    */
    //You can call the old method using super.speak();
    public void speak(){
      super.speak();
      System.out.println("My feathers are colored " + color + ".");
      System.out.println("I am " + height + " inches tall.");
    }
  
  
  
  
    //7:Override the getName() method so that a bid's name is "The Mighty NAME" instead of "NAME"
    //e.g. "The Mighty Polly" instead of just "Polly"
    //You can call the superclass' getName method using the syntax: super.getName()
  
    //Step 8:In Driver.java answer: What is the difference before and after you override this method?
    //What does this tell us about methods that are overridden?
    public String getName(){
      return("The Mighty " + super.getName());
    }
  
    //Go back and complete steps 9 onwards.
  
  }
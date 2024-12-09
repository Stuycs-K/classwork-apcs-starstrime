import java.util.Scanner;
public class Game{
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    String input;
    Adventurer other = new CodeWarrior();
    System.out.println("Enter username: ");
    Adventurer player = new Merchant(userInput.nextLine());
    while (userInput.hasNextLine()){
      input = userInput.nextLine();
    }
  }
}

import java.util.Scanner;
public class Game{
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    String input;
    Adventurer enemy = new CodeWarrior();
    System.out.println("Enter username: ");
    Adventurer player = new Merchant(userInput.nextLine());
    System.out.println("What will you do? ");
    System.out.println(player+" "+player.getHP()+"/"+player.getmaxHP()+"  "+player.getSpecial()+" "+player.getSpecialName());
    System.out.println(enemy+" "+enemy.getHP()+"/"+enemy.getmaxHP()+"  "+enemy.getSpecial()+" "+enemy.getSpecialName());
    System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
    while (userInput.hasNextLine()){
      input = userInput.nextLine();
    }
  }
}

import java.util.Scanner;
public class Game{
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    String input;
    Adventurer enemy = new CodeWarrior();
    System.out.println("Enter username: ");
    Adventurer player = new Merchant(userInput.nextLine());
    menu(player, enemy);
    while (userInput.hasNextLine()){
      input = userInput.nextLine();
      if (input.equals("a") || input.equals("attack")){
        System.out.println(player.attack(enemy));
      }
      else if (input.equals("sp") || input.equals("special")){
        System.out.println(player.specialAttack(enemy));
      }
      else if (input.equals("su") || input.equals("support")){
        System.out.println(player.support());
      }
      else if (input.equals("quit")){
        break;
      }
      else{
        System.out.println("Invalid input! Please try again.");
      }
      menu(player,enemy);
    }
  }
  public static void menu(Adventurer player, Adventurer enemy){
    System.out.println();
    System.out.println("What will you do? ");
    System.out.println(player+" "+player.getHP()+"/"+player.getmaxHP()+"  "+player.getSpecial()+" "+player.getSpecialName());
    System.out.println(enemy+" "+enemy.getHP()+"/"+enemy.getmaxHP()+"  "+enemy.getSpecial()+" "+enemy.getSpecialName());
    System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
  }
}

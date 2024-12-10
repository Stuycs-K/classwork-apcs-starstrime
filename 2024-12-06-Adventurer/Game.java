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
        if (check(enemy,player)){
          break;
        }
        randAct(enemy, player);
        if (check(player,enemy)){
          break;
        }
      }
      else if (input.equals("sp") || input.equals("special")){
        System.out.println(player.specialAttack(enemy));
        if (check(enemy,player)){
          break;
        }
        randAct(enemy, player);
        if (check(player,enemy)){
          break;
        }
      }
      else if (input.equals("su") || input.equals("support")){
        System.out.println(player.support());
        if (check(enemy,player)){
          break;
        }
        randAct(enemy, player);
        if (check(player,enemy)){
          break;
        }
      }
      else if (input.equals("quit")){
        System.out.println("system quit.");
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
    System.out.println(player+"  "+player.getHP()+" / "+player.getmaxHP()+" HP "+player.getSpecial()+" "+player.getSpecialName());
    System.out.println(enemy+"  "+enemy.getHP()+" / "+enemy.getmaxHP()+" HP "+enemy.getSpecial()+" "+enemy.getSpecialName());
    System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
  }
  public static void randAct(Adventurer enemy, Adventurer player){
    System.out.println();
    int check = (int)(Math.random() * 3);
    if (check == 0){
      System.out.println(enemy.attack(player));
    }
    if (check == 1){
      System.out.println(enemy.specialAttack(player));
    }
    else {
      System.out.println(enemy.support());
    }
  }
  public static boolean check(Adventurer player, Adventurer other){
    if (player.getHP() <= 0){
      System.out.println(player + " has fallen. " + other + " wins the battle with " + other.getHP() + " health remaining, doing " + (-1 * player.getHP()) + " unnecessary damage!");
      return true;
    }
    return false;
  }
}

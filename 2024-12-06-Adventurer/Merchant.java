import java.util.Random;
public class Merchant extends Adventurer{
  private int coins, maxCoins;

  public Merchant(String name){
    super(name, 15);
    coins = 300;
    maxCoins = 99999;
  }
  public Merchant(String name, int hp){
    super(name, hp);
    coins = 300;
    maxCoins = 99999;
  }
  public Merchant(String name, int hp, int coins){
    super(name, hp);
    this.coins = coins;
    maxCoins = 99999;
  }

  public int getSpecial(){
    return coins;
  }
  public void setSpecial(int n){
    coins = n;
  }
  public int getSpecialMax(){
    return maxCoins;
  }
  public String getSpecialName(){
    return "coins";
  }
  public String attack(Adventurer other){
    other.applyDamage(3);
    return ("Dealt 3 damage to " + other.getName() + "! Their health is now " + other.getHP() + "/" + other.getmaxHP());
  }
  public String support(Adventurer other){
    return "";
  }
  public String support(){
    return "";
  }
  public String specialAttack(Adventurer other){
    if (coins >= 500){
      other.applyDamage((coins / 500) * 5);
      restoreSpecial(-((coins / 500) * 500));
      return("Dealt damage to " + other.getName() + "! Their health is now " + other.getHP() + "/" + other.getmaxHP() + ". You now have " + getSpecial() + " coins.");
    }else return ("You do not have enough coins for a special attack.");
  }

}

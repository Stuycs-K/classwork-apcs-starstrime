import java.util.Random;
public class Merchant extends Adventurer{
  private int coins, maxCoins;

  public Merchant(String name){
    super(name);
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
    return "";
  }

}

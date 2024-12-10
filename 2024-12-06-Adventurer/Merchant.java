import java.util.Random;
public class Merchant extends Adventurer{
  private int coins, maxCoins;

  public Merchant(String name){
    super(name, 15);
    coins = 500;
    maxCoins = 99999;
  }
  public Merchant(String name, int hp){
    super(name, hp);
    coins = 500;
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
    int gained = ((int)(Math.random() * 100) + (int)(Math.random() * 100) + 200);
    restoreSpecial(gained);
    return (this + "dealt 3 damage to " + other.getName() + "! Their health is now " + other.getHP() + "/" + other.getmaxHP() + ". " + this + " also hit " + gained + " coins out of " + other + "!");
  }
  public String support(Adventurer other){
    return "";
  }
  public String support(){
    int gained = ((int)(Math.random()*200) + (int)(Math.random()*200) + 400);
    setHP(getHP() + 3);
    restoreSpecial(gained);
    return (this + "found " + gained + " coins on the floor! They also healed for 3 HP!");
  }
  public String specialAttack(Adventurer other){
    if (coins >= 500){
      int damage = (coins / 500) * 5;
      other.applyDamage(damage);
      restoreSpecial(-((coins / 500) * 500));
      return(this + " toseed a bag of money at " + other + ", dealing " + damage + " damage to " + other.getName() + "!");// Their health is now " + other.getHP() + "/" + other.getmaxHP() + ". You now have " + getSpecial() + " coins.");
    }else return ("You do not have enough coins for a special attack. Instead, " + attack(other));
  }

}

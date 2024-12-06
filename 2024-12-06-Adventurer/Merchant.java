import java.util.Random;
public class Merchant extends Adventurer{
  private int money, maxMoney;

  public Merchant(String name){
    super(name);
  }
  public Merchant(String name, int hp){
    super(name, hp);
  }

  public int getSpecial(){
    return money;
  }
  public void setSpecial(int n){
    money = n;
  }
  public int getSpecialMax(){
    return maxMoney;
  }
  public String getSpecialName(){
    return "money";
  }
  public String attack(Adventurer other){
    return "";
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

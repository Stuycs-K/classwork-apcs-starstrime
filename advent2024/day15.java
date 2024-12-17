import java.util.*;
import java.io.*;
public class day15{
  public static void main(String[] args) {
    ArrayList<String> map = day1.parse("d15inputp1.txt");
    ArrayList<String> instruct = day1.parse("d15inputp2.txt");
    // System.out.println(findBoxPos("d15inputp1.txt"));
    go(map, new int[]{24,24}, instruct);
    drawMap(map);
    System.out.println(calc(map));
  }
  // public static ArrayList<String> findBoxPos(String filename){
  //   ArrayList<String> map = day1.parse(filename);
  //   ArrayList<String> boxPos = new ArrayList<String>();
  //   for (int col = 0; col < map.size(); col++){
  //     for (int row = 0; row < map.get(col).length(); row++){
  //       if (map.get(col).charAt(row) == 'O'){
  //         boxPos.add(Arrays.toString(new int[]{col, row}));
  //       }
  //     }
  //   }
  //   return boxPos;
  // }
  static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
  public static void adjust(int[] pos1, int[] pos2, ArrayList<String> map){
    // System.out.println(Arrays.toString(pos1) + Arrays.toString(pos2));
    // drawMap(map);
    map.set(pos2[0], map.get(pos2[0]).substring(0, pos2[1]) + map.get(pos1[0]).charAt(pos1[1]) + map.get(pos2[0]).substring(pos2[1]+1));
    // drawMap(map);
    map.set(pos1[0], map.get(pos1[0]).substring(0, pos1[1]) + "." + map.get(pos1[0]).substring(pos1[1]+1));
    // drawMap(map);
    pos1[0] = pos2[0];
    pos1[1] = pos2[1];
  }
  public static void moveBot(ArrayList<String> map, int[] pos, int dir){
    int[] newpos = new int[]{pos[0]+move[dir][0], pos[1]+move[dir][1]};
    if (map.get(newpos[0]).charAt(newpos[1]) == '#'){
      return;
    }
    if (map.get(newpos[0]).charAt(newpos[1]) == 'O'){
      int[] newnewpos = newpos.clone();
      if (moveBox(map, newnewpos, dir)){
        adjust(pos, newpos, map);
      }else return;
    }else{
      adjust(pos, newpos, map);;
    }
  }
  public static boolean moveBox(ArrayList<String> map, int[] pos, int dir){
    int[] newpos = new int[]{pos[0]+move[dir][0], pos[1]+move[dir][1]};
    if (map.get(newpos[0]).charAt(newpos[1]) == '#'){
      return false;
    }
    else if (map.get(newpos[0]).charAt(newpos[1]) == 'O'){
      int[] newnewpos = newpos.clone();
      if (moveBox(map, newnewpos, dir)){
        adjust(pos, newpos, map);
        return true;
      }else return false;
    }else{
      adjust(pos, newpos, map);
      return true;
    }
  }
  public static void go(ArrayList<String> map, int[] botpos, ArrayList<String> instruct){
    for (String instructions : instruct){
      for (int i = 0; i < instructions.length(); i++){
        char movement = instructions.charAt(i);
        if (movement == '^'){
          moveBot(map, botpos, 0);
        }if (movement == '>'){
          moveBot(map, botpos, 1);
        }if (movement == 'v'){
          moveBot(map, botpos, 2);
        }if (movement == '<'){
          moveBox(map, botpos, 3);
        }
        // drawMap(map);
      }
    }
  }
  public static void drawMap(ArrayList<String> map){
    for (int i = 0; i < map.size(); i++){
      for (int r = 0; r < map.get(i).length(); r++){
        System.out.print(map.get(i).charAt(r));
      }
      System.out.println();
    }
    System.out.println();
  }
  public static int calc(ArrayList<String> map){
    int total = 0;
    for (int r = 0; r < map.size(); r++){
      for (int c = 0; c < map.get(r).length(); c++){
        if (map.get(r).charAt(c) == 'O'){
          total += (100 * r) + c;
        }
      }
    }
    return total;
  }
}
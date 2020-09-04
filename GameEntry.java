public class GameEntry{
private String name; // name of person earning score
private int score; // score value

//Constructs game entries
public GameEntry(String n, int s){
  name = n;
  score = s;
}

// Returns: 
public String getName(){ return name;}
public int getScore(){ return score;}
public String toString(){
  return "(" + name + "," + score + ")";
}














}
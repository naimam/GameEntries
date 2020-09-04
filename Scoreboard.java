/* Class for high scores:
limited to a certain amount of high scores. once limit is reached, new score only qualifies for scoreboard if it is higher than the lowest "high score" */
public class Scoreboard{
  private int numEntries = 0; // num of numEntries
  private GameEntry[] board; //array of game entries (names & scores)
  /* Constructs empty scoreboard with the given capacity for storing entries */
  public Scoreboard(int capacity){
    board = new GameEntry[capacity]; //once capacity is set, board has an array of int
  }
  /* Add new score to collection (if high enough) */
  public void add (GameEntry e){ //obj of GameEntry
    int newScore = e.getScore();  // score of obj of gameentry 
    /*is the new entry rlly a high score?
     if scoreboard length is greater than entry number or if new score is greater than higher than the lowest score  */
    if(numEntries < board.length || newScore > board[numEntries-1].getScore()){
      if(numEntries< board.length) //no score drops from the board
        numEntries++;              // updates num of entries 

      // shift any lower scores rightward to make room for new entry
      int j = numEntries -1; //index last GameEntry will be after completion of operation
      while(j > 0 && board[j-1].getScore() < newScore){ // while last score > 0 and second last score is less than new score
        board[j]=board[j-1];    //previous score shifts right one 
        j--;                    //j decreases until new score > j-1
      } 
      board[j]=e;               //when done, add new entry to scoreboard 
    }
  }
  /** Remove and return the high score at index i */
  public GameEntry remove(int i) throws IndexOutOfBoundsException{
    if(i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    GameEntry temp = board[i];    // save the object to be removed
    for(int j = i; j < numEntries - 1; j++) //count up from i (not down)
      board[j]= board[j+1];             // move one cell to the left
    board[numEntries - 1] = null;     // null out the old last score
    numEntries--;
    return temp;                  //return refrence of the removed object
  }














}
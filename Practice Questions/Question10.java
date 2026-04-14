/*
Create a class Player with below attributes:
playerld - int
playerName-String
runs-int
player Type - String
match Type - String

The above attributes should be private, write getters, setters and parameterized constructor as required.
Create class Solution with main method.
Implement two static methods - findPlayer WithLowestRuns and findPlayer By MatchType in Solution class.

--findPlayerWithLowestRuns method:
This method will take array of Player objects and a String value as input parameters.
The method will return the least runs of the Player from array of Player objects for the given player type.
(String parameter passed). If no Player with the above condition are present in array of Player objects, then the method should return 0

--findPlayerByMatch Type method:
This method will take array of Player objects and String value as input parameters and return the array of Player objects belonging to the match type passed as input parameter in Descending order of playerId.
If no Player with the above condition are present in the array of Player objects, then the method should return null.
Note: No two Players will have the same playerld and runs.

All the searches should be case insensitive
The above mentioned static methods should be called from the main method.

For findPlayer WithLowestRuns method - The main method should print the returned runs as it is if the returned value is greater than 0 or it should print "No such player".
Eg: 25
where 25 is the lowest runs of the Player.

For findPlayerByMatchType method - The main method should print the playerld from the returned Player array for each Player if the returned value is not null.
If the returned value is null then it should print "No Player with given matchType".
Eg:
13
11

where 13 and 11 are the playerld's.
Before calling these static methods in main, use Scanner object to read the values of four Player
objects referring attributes in the above mentioned attribute sequence.

Next, read the value of two String parameter for capturing player type and match Type.
Consider below sample input and output:

Input1:
11
Sachin
100
International
One day
12
Shewag
133
International
Test
13
Varun
78
State
Test
14
Ashwin
67
State
One day
State
One day

Output:
67
14
11

Input2:
11
Sachin
100
International
One day
12
Shewag
133
International
Test
13
Varun
78
State
Test
FIC
14
Ashwin
67
State
District
T20

Output:
No such player
No Player with given match Type
*/
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];

        for(int i=0;i<4;i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int runs = sc.nextInt();
            sc.nextLine();
            String playerType = sc.nextLine();
            String matchType = sc.nextLine();

            players[i] = new Player(id,name,runs,playerType,matchType);
        }

        String inputPlayer = sc.nextLine();
        String inputMatch = sc.nextLine();

        //m1
        int leastRuns = findPlayerWithLowestRuns(players,inputPlayer);
        if(leastRuns != 0){
            System.out.println(leastRuns);
        }else{
            System.out.println("No such player");
        }

        //m2
        Player[] arr= findPlayerByMatch(players,inputMatch);
        if(arr != null){
            for(Player p:arr){
                System.out.println(p.getPlayerId());
            }
        }else{
            System.out.println("No Player with given matchType");
        }

        sc.close();
    }

    private static Player[] findPlayerByMatch(Player[] players, String inputMatch) {
        int count =0;
        for(Player p:players){
            if(p.getMatchType().equalsIgnoreCase(inputMatch)){
                count++;
            }
        }

        if(count == 0) return null;

        Player[] arr = new Player[count];
        int index =0;
        for(Player p:players){
            if(p.getMatchType().equalsIgnoreCase(inputMatch)){
                arr[index++] = p;
            }
        }

        for(int i=0;i<count-1;i++){
            for(int j=i+1;j<count;j++){
                if(arr[i].getPlayerId() < arr[j].getPlayerId()){
                    Player temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        return arr;
    }

    private static int findPlayerWithLowestRuns(Player[] players, String inputPlayer) {
        int low = Integer.MAX_VALUE;

        for(Player p:players){
            if(p.getPlayerType().equalsIgnoreCase(inputPlayer)){
                if(low > p.getPlayerRuns()){
                    low = p.getPlayerRuns();
                }
            }
        }
        
        return low;
    }
}

class Player{
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    Player(int playerId, String playerName, int runs, String playerType, String matchType){
        this.playerId = playerId;
        this.playerName  = playerName;
        this.runs = runs;
        this.playerType =playerType;
        this.matchType = matchType;
    }

    public void setPlayerId(int playerId){
        this.playerId = playerId;
    }

    public int getPlayerId(){
        return playerId;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setRuns(int runs){
        this.runs = runs;
    }

    public int getPlayerRuns(){
        return runs;
    }

    public void setPlayerType(String playerType){
        this.playerType = playerType;
    }

    public String getPlayerType(){
        return playerType;
    }

    public void setMatchType(String matchType){
        this.matchType = matchType;
    }

    public String getMatchType(){
        return matchType;
    }
}
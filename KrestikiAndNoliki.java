import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IVAN91 on 11.04.2017.
 */
// Play Tic-tac-toe!
/*

Grid for game {1,2,3}

              {4,5,6}

              {7,8,9}
*/


public class KrestikiAndNoliki {
    public static boolean result = false;
    public static ArrayList<String> gridForMove = new ArrayList<>();
    public static String winnerComb[]={"123","456","789","147","258","369","159","357"};
    static {
        for(int i = 1;i<10;i++)
        {
            gridForMove.add( String.valueOf(i));
        }

    } //Fill gridForMove

    public static void main (String [] args) throws Exception{
        //Create users!
       User user1 = new User();
       User user2 = new User();
       //Start the game!
        while(true){
            System.out.println("User number one make a move X!");
            makeMove(user1);
            System.out.println("Move was successful, now User one have X on " + user1.moves);
            chekWin(user1);
            //Check winner
            if(result){System.out.println("We have a winner! it's  user number one! (X) ");break;}

            if(gridForMove.isEmpty()){System.out.println("Winner not found ");break;}

            System.out.println("User number two make a move O!");
            makeMove(user2);
            System.out.println("Move was successful, now User two have O on " + user2.moves);

            chekWin(user2);
            //Check winner
            if(result){System.out.println("У нас есть победитель, это Пользователь 2");break;}}
    }

    //Class for Users, wich save move
    public static class User {
        String moves="";}


    //Method for make a move. If move by User was been early already, will delete and try again.
    public static void makeMove(User user)throws Exception{
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                String s = x.readLine(); //Get move
                String temp = s;
                String tempEmpty = ""; //For chek(Empty or equals rules)
                if (Integer.parseInt(temp) <= 0 | Integer.parseInt(temp) > 9) {
                    System.out.println("We have only 1-9 cell. But it was nice  try :D");
                    continue;
                }
                for (String z : gridForMove) {
                    if (temp.equals(z)) {
                        user.moves += s;
                        deleteGrid(z);
                        tempEmpty = "true";
                        break;
                    } else tempEmpty = null;
                }
                if (tempEmpty == null | temp.equals("")) {
                    System.out.println("No no no....Please make a move yet.")
                    ;
                    continue;
                }
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Please try again without empty or another text! " +
                        "Only numbers(See Grid for game in up)");
            }
        }

    }

    //Method for delete user cell in GRID
    public static void deleteGrid(String string){
        for(String x : gridForMove){
            if(string.equals(x)){gridForMove.remove(x);
                break;}
        }
    }

    //When user take a move, check for winner.
    public static void chekWin(User user){
            boolean status = false;
            int count = user.moves.length();
        for(int i = 0;i<winnerComb.length;i++){
                if(status==true){break;}
            if(user.moves.contains(winnerComb[i])){result=true;break;}
           if(user.moves.length()>3){
                for(int z =0;z<count;z++) {
                    String temp3 = user.moves;
                    ArrayList<String> list = new ArrayList<String>();
                    //Need sorted for right check!
                    list.add(0, String.valueOf(temp3.charAt(0)));
                    list.add(0, String.valueOf(temp3.charAt(1)));
                    list.add(0, String.valueOf(temp3.charAt(2)));
                    list.add(0, String.valueOf(temp3.charAt(3)));
                    Collections.sort(list);
                    list.remove(z);
                    temp3="";
                    for(String l : list){
                        temp3 += l;}
                    if(temp3.contains(winnerComb[i])){result=true;status=true;break;}
           }//End  for
                }//End if
                    }// End main for
    }//End main

}//End class

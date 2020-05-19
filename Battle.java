import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    static int player=5,computer=5;
    static Scanner sc =new Scanner(System.in);
    static Random random = new Random();
    public void inputplayer(int[][] arr)
    {
        int x,y;
        System.out.println("\n\nFOR PLAYER: ENTER YOUR CORDINATES OF YOUR 5 SHIPS: ");
        for(int i=0;i<5;i++)
        {
            System.out.print("\nENTER YOUR X CORDINATE of ship "+(i+1)+": ");
            x=sc.nextInt();
            System.out.print("ENTER YOUR Y CORDINATE of ship "+(i+1)+": ");
            y=sc.nextInt();
            if(x>=0&&x<10&y>=0&&y<10) {
                if(arr[x][y]==1)
                {
                    System.out.println("Sorry your ship is already there..try again");
                    i--;
                }
                else
                    arr[x][y] = 1;
            }
            else
            {
                System.out.println("Sorry wrong input..try again");
                i--;
            }
        }

    }
    public void show(int[][] arr)
    {
        for(int i=0;i<10;i++)
        {
            System.out.print(i+" | ");
            for(int j=0;j<10;j++) {
                if(arr[i][j]!=0)
                    System.out.print(arr[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.print(" | "+i+"\n");
        }
        System.out.print("  | "+"0 1 2 3 4 5 6 7 8 9 "+" | ");

    }
    public void comp(int[][] arr)
    {
        Random random = new Random();
        System.out.println("\n\nFOR Computer: ENTER YOUR CORDINATES OF YOUR 5 SHIPS: ");
        int x,y;
        for(int i=0;i<5;i++)
        {
            x=random.nextInt(10);
            y=random.nextInt(10);
            if(x>=0&&x<10&y>=0&&y<10) {
                if(arr[x][y]==1)
                {
                    System.out.println("Sorry your ship is already there..try again");
                    i--;
                }
                else {
                    arr[x][y] = 2;
                    System.out.println("ship Deployed");
                }
            }
            else
            {
                System.out.println("Sorry wrong input..try again");
                i--;
            }
        }

    }
    public void game(int[][] arr)
    {
        int x,y;
        while(player!=0&&computer!=0) {
            System.out.println("\nPlayer turn:- ");
            System.out.println("\tGuess the cordinates of oponent: ");
            System.out.print("\n\tENTER YOUR X CORDINATE of ship: ");
            x = sc.nextInt();
            System.out.print("\tENTER YOUR Y CORDINATE of ship: ");
            y = sc.nextInt();
            if (arr[x][y] == 2) {
                arr[x][y] = 7;
                player--;
            } else
                System.out.print("\tSorry Guess is not correct");
            if(player!=0)
            {

                System.out.println("computer turn:- ");
                System.out.println("\tGuess the cordinates of oponent: -");
                System.out.print("\n\tENTER YOUR X CORDINATE of ship : ");
                x = random.nextInt();
                System.out.print("\tENTER YOUR Y CORDINATE of ship: ");
                y = random.nextInt();
                if (arr[x][y] == 1) {
                    arr[x][y] =8;
                    computer--;
                } else
                    System.out.print("\tSorry Guess is not correct");
            }
        }
        if(player==0)
            System.out.print("\t Hurray player wins");
        else
            System.out.print("\tComputer wins");

    }

    public static void main(String[] args)
    {
        int i,j;
        int[][] arr=new int[10][10];
        Battle b = new Battle();
        System.out.println("-------------------------WELCOME TO THE GAME-------------------------");
        System.out.println("\n HERE IS OUR GAME BOARD\n");
        b.show(arr);
        b.inputplayer(arr);
        System.out.println("\n YOUR POSITIONS OF SHIP IS  \n");
        b.show(arr);
        b.comp(arr);
        b.game(arr);



    }

}

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer>PlayerPosition=new ArrayList<>();
    static ArrayList<Integer>cpuPosition=new ArrayList<>();

    public static void main(String[] args) {

        char[][]MyBoard={
                {' ','|',' ','|',' '},
                {8212,'+',8212,'+',8212},
                {' ','|',' ','|',' '},
                {8212,'+',8212,'+',8212},
                {' ','|',' ','|',' '}
        };

        PrintBoardGame(MyBoard);

        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Your Place (1-9) :");
            int Player=sc.nextInt();

            while(PlayerPosition.contains(Player) || cpuPosition.contains(Player)){
                System.out.println("Position taken");
                Player=sc.nextInt();
            }

            PlacePiece(MyBoard,Player,"Human");
            String result=CheckWinning();
            if(result.length()>0){
                System.out.println(result);
                PrintBoardGame(MyBoard);
                break;
            }

            Random r=new Random();
            int cpu=r.nextInt(9)+1;
            while(PlayerPosition.contains(cpu) || cpuPosition.contains(cpu)){
                cpu=r.nextInt(9)+1;
            }

            PlacePiece(MyBoard,cpu,"computer");
            result=CheckWinning();
            if(result.length()>0){
                System.out.println(result);
                PrintBoardGame(MyBoard);
                break;
            }
            PrintBoardGame(MyBoard);
        }
    }
    public static void PrintBoardGame(char[][]board){
        for(char [] row :board){
            for(char c:row){
                System.out.print(c);
            }
            System.out.println();

        }

    }

    public static void PlacePiece(char [][]gameBoard,int position,String user){

        char symbol=' ';

        if(user.equals("Human") && position >= 1 && position <= 9) {
            symbol = 'X';
            PlayerPosition.add(position);
        }

        if(user.equals("computer") && position >= 1 && position <= 9) {
            symbol = 'O';
            cpuPosition.add(position);
        }

        switch(position){
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                System.out.println("Position do not exists on the board");
                break;
        }


    }

    public static String CheckWinning(){

        List topRow= Arrays.asList(1,2,3);
        List midRow= Arrays.asList(4,5,6);
        List botRow= Arrays.asList(7,8,9);

        List leftCol= Arrays.asList(1,4,7);
        List midCol= Arrays.asList(2,5,8);
        List rightCol= Arrays.asList(3,6,9);

        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(3,5,7);

        List<List>Winning=new ArrayList<List>();
        Winning.add(topRow);
        Winning.add(midRow);
        Winning.add(botRow);

        Winning.add(leftCol);
        Winning.add(midCol);
        Winning.add(rightCol);

        Winning.add(cross1);
        Winning.add(cross2);

        for(List l : Winning){
            if(PlayerPosition.containsAll(l)){
                return "Congrats - you won";
            }else  if(cpuPosition.containsAll(l)){
                return "computer wins";
            }
        }
        if(cpuPosition.size()+PlayerPosition.size()==9){
            return "No winners on this game";
        }
        return "";
    }
}

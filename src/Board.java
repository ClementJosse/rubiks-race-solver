import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    public Tile[][] board = new Tile[5][5];
    public int nb_red,nb_orange,nb_green,nb_yellow,nb_blue,nb_white;
    public Scrambler scrambler;
    private Boolean[][] associateTile;

    Board(){
        NewBoard();
        PrintBoard(board);
        GenerateScrambler();
    }

    private void GenerateScrambler(){
        scrambler = new Scrambler();
        scrambler.PrintScrambler();
    }

    private void NewBoard() {
        // System.out.println("NewBoard");

        nb_red=4;
        nb_orange=4;
        nb_green=4;
        nb_yellow=4;
        nb_blue=4;
        nb_white=4;

        associateTile=new Boolean[5][5];

        int newTileColorNumber;

        for (int i = 0; i<5;i++){
            for (int j = 0; j<5;j++){
                if(i==2 && j==2) {
                    board [2][2] = new Tile(TileColor.EMPTY,0);
                }
                else{
                    do{
                        newTileColorNumber= (int)((Math.random() * 6) + 1);
                        // newTile= new Tile((TileColor.values()[(int) (Math.random() * 6) + 1]),(i*5)+j);
                        // System.out.println(newTileColorNumber+ " i"+ i+" j"+j);
                    }while(!isColorPossible(newTileColorNumber));

                    board [i][j] = new Tile((TileColor.values()[newTileColorNumber]),(i*5)+j);
                }

            }
        }
    }

    public void SolveBoard(){
        System.out.println();
        int heuristicInitial = Heuristic(board);
        System.out.println("global: "+ heuristicInitial);

        int heuristic_i=heuristicInitial;
        List<BoardSate>[] heuristicArray = new ArrayList[heuristicInitial+1];

        for(int i = 0; i <= heuristicInitial; i++) {
            heuristicArray[i] = new ArrayList<>();
        }

        heuristicArray[heuristicInitial].add(new BoardSate(board,".","None", 2, 2));

        System.out.println(heuristicArray[heuristicInitial].get(0).getHistoric());

        while(heuristic_i>=0){
            System.out.println(heuristic_i+" "+heuristicArray[heuristic_i]);
            next3Steps(heuristicArray[heuristicInitial].get(0));
           // System.out.println(PrintBoard(heuristicArray[heuristicInitial].get(0).getBoard()));
            heuristic_i--;
        }

    }

    private void next3Steps(BoardSate boardSate){
        switch(boardSate.previousStep){
            case "u":
                System.out.println("u:rdl");
                break;
            case "r":
                System.out.println("r:dlu");
                break;
            case "d":
                System.out.println("d:lur");
                break;
            case "l":
                System.out.println("l:urd");
                break;
            default:
                System.out.println("0:urdl");
                break;
        }
    }

    private void moveVoidTile(BoardSate boardSate,int i, int j){
        if(boardSate.void_tile_i+i>=0&&boardSate.void_tile_j+j>=0 && boardSate.void_tile_i+i<5&&boardSate.void_tile_j+j<5 ){


        }
    }

    private void FillAssociateTileFalse(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.associateTile[i][j]=false;
            }
        }
    }

    private int Heuristic(Tile[][] board){
        int heuristic = 0;
        int heuristicTileValue;
        FillAssociateTileFalse();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                heuristicTileValue=HeuristicForTile(board,i,j,associateTile);
                //System.out.println(this.scrambler.scrambler[i][j].getTileColorString()+ "ij: "+ i+" "+ j+ " | "+heuristicTileValue);

                heuristic+=heuristicTileValue;
                heuristicTileValue=0;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(associateTile[i][j]){
                    System.out.print("X ");
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }

        return heuristic;

    }




    private int HeuristicForTile(Tile[][]board,int scrambler_case_i, int scrambler_case_j, Boolean[][] associateTile) {
        int board_case_i=scrambler_case_i+1;
        int board_case_j=scrambler_case_j+1;

        System.out.print("s"+scrambler.scrambler[scrambler_case_i][scrambler_case_j].getTileColorString()+"b"+board[board_case_i][board_case_j].getTileColorString());

        if(!associateTile[board_case_i][board_case_j] && Objects.equals(board[board_case_i][board_case_j].getTileColorString(), scrambler.scrambler[scrambler_case_i][scrambler_case_j].getTileColorString())){

            associateTile[board_case_i][board_case_j]=true;
            System.out.println();
            return 0;
        }

        int n = 0;
        boolean isTileFinded =false;

        while(!isTileFinded){

            n++;
            System.out.print("  n "+n+" search :");


            isTileFinded=DiagonalBoardSearch(board_case_i-n,board_case_j,scrambler_case_i,scrambler_case_j,n,1,1);

            if(!isTileFinded){
                isTileFinded=DiagonalBoardSearch(board_case_i,board_case_j+n,scrambler_case_i,scrambler_case_j,n,1,-1);
            }
            if(!isTileFinded){
                isTileFinded=DiagonalBoardSearch(board_case_i+n,board_case_j,scrambler_case_i,scrambler_case_j,n,-1,-1);
            }
            if(!isTileFinded){
                isTileFinded=DiagonalBoardSearch(board_case_i,board_case_j-n,scrambler_case_i,scrambler_case_j,n,-1,1);
            }



        }

        System.out.println();

        return n;
    }

    private boolean isCoordsPossible(int case_check_i, int case_check_j) {
            return (case_check_i<5 && case_check_j<5 && case_check_i>=0 && case_check_j>=0);
    }

    private boolean DiagonalBoardSearch(int case_check_i, int case_check_j, int scrambler_case_i, int scrambler_case_j, int n, int next_i, int next_j){
        for (int i = 0; i < n; i++) {
            if(isCoordsPossible(case_check_i,case_check_j)){
                System.out.print(board[case_check_i][case_check_j].getTileColorString());
                if(!associateTile[case_check_i][case_check_j] && (Objects.equals(board[case_check_i][case_check_j].getTileColorString(), scrambler.scrambler[scrambler_case_i][scrambler_case_j].getTileColorString())) ){
                    System.out.print("<-");
                    associateTile[case_check_i][case_check_j]=true;
                    return true;
                }
            }
            case_check_i+=next_i;
            case_check_j+=next_j;
        }
        return false;

    }

    public void PrintBoard(Tile[][] board) {
        System.out.println("Board :  ");
        for (int i = 0; i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j].getTileColorString());
            }
            System.out.println();
        }
    }

    private boolean isColorPossible(int which) {
        //System.out.println("isColorPossible "+which);
        //System.out.println("blue"+nb_blue+" nb_white"+nb_white+" nb_yellow"+nb_yellow+" nb_red"+nb_red+" nb_green"+nb_green+" nb_orange"+nb_orange);
        boolean state=false;
        switch(which) {
            case (1): // RED
                if(nb_red>0){
                    nb_red=nb_red-1;
                    state= true;
                }
                break;
            case (2): // ORANGE
                if(nb_orange>0){
                    nb_orange--;
                    state= true;
                }
                break;
            case (3): // GREEN
                if(nb_green>0){
                    nb_green--;
                    state= true;
                }
                break;
            case (4): // YELLOW
                if(nb_yellow>0){
                    nb_yellow--;
                    state= true;
                }
                break;
            case (5): // BLUE
                if(nb_blue>0){
                    nb_blue--;
                    state= true;
                }
                break;
            case (6): // WHITE
                if(nb_white>0){
                    nb_white--;
                    state= true;
                }
                break;
        }
        // System.out.println(state);
        return state;
    }
}

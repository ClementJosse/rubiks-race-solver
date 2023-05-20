package rubixrace;

public class Scrambler {
    public Tile[][] scrambler = new Tile[3][3];
    public int nb_red,nb_orange,nb_green,nb_yellow,nb_blue,nb_white;
    public Scrambler(){
        nb_red=4;
        nb_orange=4;
        nb_green=4;
        nb_yellow=4;
        nb_blue=4;
        nb_white =4;

        int newTileColorNumber;

        for (int i = 0; i<3;i++){
            for (int j = 0; j<3;j++){
                    do{
                        newTileColorNumber= (int)((Math.random() * 6) + 1);
                        // newTile= new java.main.Tile((java.main.TileColor.values()[(int) (Math.random() * 6) + 1]),(i*5)+j);
                        // System.out.println(newTileColorNumber+ " i"+ i+" j"+j);
                    }while(!isColorPossible(newTileColorNumber));

                    scrambler [i][j] = new Tile((TileColor.values()[newTileColorNumber]));

            }
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

    public void PrintScrambler() {
        System.out.println("java.main.Scrambler :");
        for (int i = 0; i<3;i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(scrambler[i][j].getTileColorString());
            }
            System.out.println();
        }
    }
}
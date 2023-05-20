package rubixrace;

import java.util.LinkedList;
import java.util.ListIterator;

public class BoardStateLinkedList {
    private LinkedList<BoardState> boardStateLinkedList;
    boolean useDijkstra;
    public BoardStateLinkedList(BoardState initialBoardState) {
        boardStateLinkedList = new LinkedList<>();
        boardStateLinkedList.add(initialBoardState);
        useDijkstra = true;
    }

    public void add(BoardState boardState) {
        if(!useDijkstra){
            ListIterator<BoardState> iterator = boardStateLinkedList.listIterator();
            while (iterator.hasNext()) {
                BoardState currentBoardState = iterator.next();
                if (currentBoardState.heuristic >= boardState.heuristic + 1) {
                    iterator.previous(); // Revenir à l'élément précédent ayant une valeur heuristique supérieure ou égale
                    break;
                }
            }
            iterator.add(boardState);
        }
        else{
            boardStateLinkedList.addLast(boardState);
        }
    }

    public BoardState getFirstElement() {
        BoardState temp = boardStateLinkedList.getFirst();
        return temp;
    }

    public void deleteFirstElement(){
        boardStateLinkedList.removeFirst();
    }

    public int getFirstElementHeuristic(){
        return this.boardStateLinkedList.getFirst().heuristic;
    }

    public String getFirstElementHistoric(){
        return this.boardStateLinkedList.getFirst().getHistoric();
    }

    public void clear() {
        boardStateLinkedList.clear();
    }

    public void printAllHeuristicInTheList() {
//        System.out.println(boardStateLinkedList);
        System.out.print("[ ");
        for (BoardState obj : boardStateLinkedList) {
            System.out.print(obj.heuristic+" ");
        }
        System.out.print("]\n");
    }

}
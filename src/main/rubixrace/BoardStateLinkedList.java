package rubixrace;

import java.util.LinkedList;
import java.util.ListIterator;

public class BoardStateLinkedList {
    private LinkedList<BoardState> boardStateLinkedList;

    public BoardStateLinkedList(BoardState initialBoardState) {
        boardStateLinkedList = new LinkedList<>();
        boardStateLinkedList.add(initialBoardState);
    }

    public void add(BoardState boardState) {
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
}
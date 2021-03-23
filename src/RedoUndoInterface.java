public interface RedoUndoInterface {

    void changeTurnCount(int turnNumber);

    void goForwardOneTurn(int turnNumber);

    void goBackwardOneTurn(int turnNumber);

}

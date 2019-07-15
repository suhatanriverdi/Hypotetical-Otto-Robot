package main;
/*_-> Sample Room Representation <-_
( 'w' ) -> Walls(Borders)
( 'E' ) -> Exit
( '.' ) -> Robot can walk
char [][]board = new char[][] {
{'w','w','w','w','w','w','w','w','w','w'},
{'w','.','.','.','.','.','.','.','.','w'},
{'w','.','.','.','.','.','.','.','.','w'},
{'w','.','.','.','.','.','.','.','.','w'},
{'w','.','.','.','R','.','.','.','.','w'},
{'w','.','.','.','.','.','.','.','.','w'},
{'w','.','.','.','.','.','.','.','.','w'},
{'w','w','w','w','w','w','w','E','w','w'}};
*/
public class GamePlay {
    public static void main(String []args) {
        Game gameObj = new Game();
        gameObj.createRoom(5, 10); // Creates Room with 5 x 10
        gameObj.createExitDoorRandomly();// Creates Exit Door and locates it randomly on bottom borders
        gameObj.createOttoRobot();
        gameObj.printRoom();
        gameObj.startGame();
    }
}
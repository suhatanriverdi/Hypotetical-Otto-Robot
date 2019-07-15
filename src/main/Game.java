package main;

// Game Class
public class Game {
    Room defaultRoom;
    Robot defaultRobot;
    WalkingRobot walkingRobot = new WalkingRobot();
    // Game Constructor
    public Game(){
        
    }
    
    // Creates and Fills the Room
    public void createRoom(int height, int width) {
        Room room = new Room(height, width);
        this.defaultRoom = room;
        room.fillRoom();
    }
    
    // Creates Exit Door on Bottom Line Randomly
    public void createExitDoorRandomly() {
        this.defaultRoom.createRandomExitDoor();
    }
    
    // Prints the Room
    public void printRoom() {
        this.defaultRoom.printRoom();
    }
    
    // Starts Game
    void startGame() {
        System.out.println("('',) Game Started! (,'')\n");
        boolean gameEnd = false;
        while(!gameEnd) {
            this.defaultRobot.moveRobotOneStepAwayRandomly();
//            System.out.println(this.defaultRobot.isOnTheExitDoor(this.defaultRobot.robotLocationX(), defaultRobot.robotLocationY()));
            if(this.defaultRobot.isOnTheExitDoor(this.defaultRobot.robotLocationX(), defaultRobot.robotLocationY())) {
                System.out.println("Hypotatical Otto Robot has Reached to the EXIT DOOR! :)");
                printNumOfStepsToExit();
                walkingRobot.printWalking();
                gameEnd = true;
                break;
            }
            printRoom();
            System.out.println();
        }
    }
    
    // Creates Otto Robot
    void createOttoRobot() {
        this.defaultRobot = new Robot();
    }
    
    // Prints Number of Steps to Reach Exit
    void printNumOfStepsToExit() {
        System.out.println("Steps Counted: " + defaultRobot.numberOfStepsToReachExit());
    }
}
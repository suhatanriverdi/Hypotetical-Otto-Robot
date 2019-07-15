package main;

import java.util.Random;

public class Robot {
    private int stepCounter = 0; // How many steps robot will take
    private Location robotLocation;
    
    // Robot Constructor
    public Robot() { // Constructor
        robotLocation = new Location();
        setRandomRobotLocation();
    }
    
    // Locates Robot in the Room Randomly
    public void setRandomRobotLocation() {
        Random rand = new Random();
        int lower_bound = 1; // To Avoid touching the bottom left corner
        int upper_bound_y = (Room.getRoomWidth()-1); // Exclude y corners
        int randomValue_y = rand.nextInt(upper_bound_y - lower_bound) + lower_bound; // Creates random number between 1 - (Weight-1)
        int upper_bound_x = (Room.getRoomHeight()-1); // Exclude x  corners
        int randomValue_x = rand.nextInt(upper_bound_x - lower_bound) + lower_bound;
        Room.getRoom()[randomValue_x][randomValue_y] = 'R';
        robotLocation.setX(randomValue_x);
        robotLocation.setY(randomValue_y);
//        System.out.printf("Robot is located in (%d, %d) coordinates on the room!\n", robotLocation.getX(), robotLocation.getY());
    }
    
    // Moves Robot One Step Away Randomly
    public void moveRobotOneStepAwayRandomly() {
        Room.getRoom()[robotLocation.getX()][robotLocation.getY()] = '.';
        // Create random number among 0,1,2,3 use it for directions left-right-up-down
        Random rand = new Random();
        boolean hasRobotMoved = false;
        while(!hasRobotMoved) {
            int currentRandNum = rand.nextInt(4);
            switch(currentRandNum) {
                case 0: // Up
                    if(!isOnBounds((robotLocation.getX()-1), robotLocation.getY())) {
                        robotLocation.setX(robotLocation.getX()-1);
                        hasRobotMoved = true;
                        break;
                    }
                case 1: // Right
                    if(!isOnBounds((robotLocation.getX()), robotLocation.getY()+1)) {
                        robotLocation.setY(robotLocation.getY()+1);
                        hasRobotMoved = true;
                        break;
                    }
                case 2: // Down
                    if(isOnTheExitDoor((robotLocation.getX()+1), robotLocation.getY())) {
                        robotLocation.setX(robotLocation.getX()+1);
                        hasRobotMoved = true;
                        break;
                    }
                    if(!isOnBounds((robotLocation.getX()+1), robotLocation.getY())) {
                        robotLocation.setX(robotLocation.getX()+1);
                        hasRobotMoved = true;
                        break;
                    }
                case 3: // Left
                    if(!isOnBounds((robotLocation.getX()), robotLocation.getY()-1)) {
                        robotLocation.setY(robotLocation.getY()-1);
                        hasRobotMoved = true;
                        break;
                    }
                default:
//                    System.out.println("Wall Problem, Robot cannot be moved!");
            }
        }
        stepCounter++;
        Room.getRoom()[robotLocation.getX()][robotLocation.getY()] = 'R';
//        System.out.printf("Robot location is (%d, %d)!\n", robotLocation.getX(), robotLocation.getY());
    }
    
    // Returns Robot Location X
    public int robotLocationX() {
        return robotLocation.getX();
    }
    
    // Returns Robot Location Y
    public int robotLocationY() {
        return robotLocation.getY();
    }
    
    // Returns Robot's Location
    Location robotLocation(){
        return robotLocation;
    }
    
    // Check Where Robot is
    boolean atLocation(Location loc){
        return robotLocation.equals(loc);
    }
    
    // Returns Number of Steps to Reach Exit
    public int numberOfStepsToReachExit() {
        return this.stepCounter;
    }
    
    // Checks if robot is on the boundaries
    boolean isOnBounds(int x, int y) {
        if(x == 0 || y == Room.getRoomWidth()-1 || y == 0 || x == Room.getRoomHeight()-1) {
//            System.out.println("x on border: " + x + " y: " + y);
            return true;
        }
        return false;
    }
    
    // Checks if robot is on the door
    boolean isOnTheExitDoor(int x, int y) {
        if(x == Room.getDoorX() && y == Room.getDoorY()) {
//            System.out.printf("Robot touched the Door(%d, %d)!\n", Room.getDoorX(), Room.getDoorY());
            return true;
        }
        return false;
    }
}
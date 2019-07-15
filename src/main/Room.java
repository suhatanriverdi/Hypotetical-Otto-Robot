package main;

import java.util.Random;

// Room Class
public class Room {
    private static char room[][];
    private static Location exitDoor;
    private static int Height = 0;
    private static int Width = 0;
    /* Sample Room Representation
    w -> Walls(Borders)
    E -> Exit
    . -> Robot can walk
    char [][]board = new char[][] {
    {'w','w','w','w','w','w','w','w','w','w'},
    {'w','.','.','.','.','.','.','.','.','w'},
    {'w','.','.','.','.','.','.','.','.','w'},
    {'w','.','.','.','.','.','.','.','.','w'},
    {'w','.','.','.','.','.','.','.','.','w'},
    {'w','.','.','.','.','.','.','.','.','w'},
    {'w','.','.','.','.','.','.','.','.','w'},
    {'w','w','w','w','w','w','w','E','w','w'}};
    */
    
    // Game Constructor
    public Room(int height, int width){
        room = new char[height][width]; // Create 2D integer array
        this.Height = height;
        this.Width = width;
        this.exitDoor = new Location();
    }
    
    // Fills the Room with Chars
    public void fillRoom() {
        System.out.println("-> Room Dimensions <-");
        System.out.println("Height(x): " + room.length + ", Width(y): " + room[0].length);
        int M = room.length;
        int N = room[0].length;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(i  == 0 || j == 0 || i == M-1 || j == N-1) {
                    room[i][j] = 'w';
                }
                else {
                    room[i][j] = '.';
                }
            }
        }
    }
    
    // Creates the Exit Door and Locates it Randomly on the Bottom Side
    public void createRandomExitDoor() {
        Random rand = new Random();
        int lower_bound = 1; // To Avoid touching the bottom left corner
        int upper_bound = (this.Width-1); // To Avoid touching the bottom right corner
        int randomValueY = rand.nextInt(upper_bound - lower_bound) + lower_bound; // Creates random number between 1 - (Weight-1)
        int bottomValue = this.Height-1;
        exitDoor.setX(bottomValue);
        exitDoor.setY(randomValueY);
        room[bottomValue][randomValueY] = 'E';
        System.out.printf("Door is located in (%d, %d) coordinates on the room!\n", exitDoor.getX(), exitDoor.getY());
    }
    
    // Returns Room Height
    public static char[][] getRoom() {
        return room;
    }
    
    // Returns Room Height
    public static int getRoomHeight() {
        return Height;
    }
    
    // Returns Room Width
    public static int getRoomWidth() {
        return Width;
    }
    
    // Returns Door X Coordinate
    public static int getDoorX() {
        return exitDoor.getX();
    }
    
    // Returns Door Y Coordinate
    public static int getDoorY() {
        return exitDoor.getY();
    }
    
    // Prints the Room
    public void printRoom() {
        int M = room.length;
        int N = room[0].length;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println();
        }
    }
}
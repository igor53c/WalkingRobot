import java.util.ArrayList;

public class Grid {

    int width;
    int height;
    int[][] grid;

    Grid(int width, int height) {
        this.width = width;
        this.height = height;

        grid = new int[width][height];

        for(int w = 0; w < width; w++)
            for(int h = 0; h < height; h++)
                grid[w][h] = -1;
    }

    int getWidth() { return width; }
    int getHeight() { return height; }
    int[][] getGrid() { return grid; }
    int[] getRow(int row) { return grid[row]; }
    int getValue(int row, int col) { return grid[row][col]; }
    void setValue(int row, int col, int value) { grid[row][col] = value; }
    void setObstacle(int row, int col) { grid[row][col] = 0; }
}

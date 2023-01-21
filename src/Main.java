public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(3, 2);

        grid.setObstacle(1, 1);

        System.out.println(WalkingRobot.uniquePaths(grid));

        Grid pathMatrix = WalkingRobot.pathMatrix(grid);

        for(int h = 0; h < pathMatrix.getHeight(); h++) {
            for (int w = 0; w < pathMatrix.getWidth(); w++) {
                System.out.print(pathMatrix.getValue(w, h) + ", ");
            }
            System.out.print("\n");
        }
    }
}
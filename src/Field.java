public class Field {

    boolean right;
    boolean down;
    int width;
    int height;
    Field(int width, int height) {
        right = false;
        down = false;
        this.width = width;
        this.height = height;
    }
}

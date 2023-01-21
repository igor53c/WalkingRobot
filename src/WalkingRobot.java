import java.util.ArrayList;
import java.util.List;

public class WalkingRobot {

    public static int uniquePaths(Grid board) {

        if(board.getValue(board.getWidth() - 1, board.getHeight() - 1) == 0 ||
                board.getWidth() <= 0 || board.getHeight() <= 0)
            return 0;

        int retValue = 0;
        List<Field> fieldList = new ArrayList<>();

        fieldList.add(new Field(0,0));

        while (!fieldList.isEmpty()) {

            Field lastField = fieldList.get(fieldList.size() - 1);

            if (!lastField.right) {
                lastField.right = true;

                if (lastField.width + 1 < board.getWidth() &&
                        board.getValue(lastField.width + 1,lastField.height) == -1) {
                    fieldList.add(new Field(lastField.width + 1, lastField.height));

                    if(lastField.width + 1 == board.getWidth() - 1 && lastField.height == board.getHeight() - 1)
                        retValue++;
                }
            } else if (!lastField.down) {
                lastField.down = true;

                if (lastField.height + 1 < board.getHeight() &&
                        board.getValue(lastField.width,lastField.height + 1) == -1) {
                    fieldList.add(new Field(lastField.width, lastField.height + 1));

                    if(lastField.width == board.getWidth() - 1 && lastField.height + 1 == board.getHeight() - 1)
                        retValue++;
                }
            } else {
                fieldList.remove(lastField);
            }
        }

        return retValue;
    }

    public static Grid pathMatrix(Grid board) {

        if(board.getValue(board.getWidth() - 1, board.getHeight() - 1) == 0 ||
                board.getWidth() <= 0 || board.getHeight() <= 0)
            return board;

        Grid retValue = new Grid(board.getWidth(), board.getHeight());
        List<Field> fieldList = new ArrayList<>();

        for(int w = 0; w < board.getWidth(); w++)
            for(int h = 0; h < board.getHeight(); h++)
                retValue.setValue(w,h,0);

        fieldList.add(new Field(0,0));

        while (!fieldList.isEmpty()) {

            Field lastField = fieldList.get(fieldList.size() - 1);

            if (!lastField.right) {
                lastField.right = true;

                if (lastField.width + 1 < board.getWidth() &&
                        board.getValue(lastField.width + 1,lastField.height) == -1) {
                    fieldList.add(new Field(lastField.width + 1, lastField.height));

                    retValue.setValue(
                            lastField.width + 1,
                            lastField.height,
                            retValue.getValue(lastField.width + 1, lastField.height) + 1
                            );
                }
            } else if (!lastField.down) {
                lastField.down = true;

                if (lastField.height + 1 < board.getHeight() &&
                        board.getValue(lastField.width,lastField.height + 1) == -1) {
                    fieldList.add(new Field(lastField.width, lastField.height + 1));

                    retValue.setValue(
                            lastField.width,
                            lastField.height + 1,
                            retValue.getValue(lastField.width, lastField.height + 1) + 1
                    );
                }
            } else {
                fieldList.remove(lastField);
            }
        }

        return retValue;
    }

}

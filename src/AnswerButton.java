import javax.swing.*;
import java.awt.*;

enum ButtonType{
    WRONG,
    RIGHT
}

public class AnswerButton {
    JButton button;
    ButtonType type = ButtonType.WRONG;

    AnswerButton(){
        button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}

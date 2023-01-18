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
        //button.setOpaque(true);
        button.setContentAreaFilled(false);
       // button.setBackground(Color.RED);
        //button.setForeground(Color.RED);

        button.setBorderPainted(false);
    }
}

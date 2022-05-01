import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingObject extends JFrame {
    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;

    public MovingObject(){
        // TODO:הוראות
        add(new GameScene());
        setSize(WHITH,HIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            // TODO:הוראות
            MovingObject beta=new MovingObject();
            beta.setVisible(true);
        });

    }
}

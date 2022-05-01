import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameInstructions extends JFrame {
    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;
    private final int X_START=0; //מיקום הפאנל
    private final int Y_START=0;
    ImageIcon image=new ImageIcon("image_herow.png");
    JLabel instructions = new JLabel(image);

    public GameInstructions(){
        JFrame fram=new JFrame();
        fram.setSize(1000,1000);
        fram.setVisible(true);
        fram.add(instructions);
              instructions.setText("Help Goku save the world !!\n" +
                        "In order to defeat Priza and save the world, you must collect all 7 Dragon Balls.\n" +
                        "If you miss even one ball,\n" +
                        "Or you're hit by Priza's energy balls three times,\n" +
                        "You will lose and the earth will be destroyed !!!\n" +
                        "\n" +
                        "Go ahead and get going!");


                instructions.setBounds(X_START, Y_START, WHITH, HIGHT);
                //instructions.setIcon(image);
                instructions.setVisible(true);
            fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

}

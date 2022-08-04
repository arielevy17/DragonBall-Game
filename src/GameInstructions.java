import javax.swing.*;
import java.awt.*;

public class GameInstructions extends JPanel {
                                       //  תאריך שינוי אחרון 4.8.22

    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;
    private final int X_START=0; //מיקום הפאנל
    private final int Y_START=150;
    private ImageIcon beacground;

    public GameInstructions(){
        this.setSize(WHITH,HIGHT);
        beacground= new ImageIcon("instructionsBeackground.png");
        repaint();
        JTextArea instructions = new JTextArea("                  Help Goku save the world !!\n" +
                "    In order to defeat Priza and save the world, \n you must collect all 7 Dragon Balls.\n" +
                "    If you miss even one ball,\n" +
                "    Or you're hit by Priza's energy balls three times,\n" +
                "    You will lose and the earth will be destroyed !!!\n" +
                "\n" +
                "    Go ahead and get going!");
        instructions.setFont(new Font("text",Font.BOLD,30));
        instructions.setBackground(null);
        instructions.setForeground(Color.ORANGE);
        this.add(instructions);

                instructions.setVisible(true);
        this.setVisible(true);
       //     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.beacground.paintIcon(this, g, X_START, Y_START);
         doDrawing(g);

        //Toolkit.getDefaultToolkit().sync();
    }
    public void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
    }


}

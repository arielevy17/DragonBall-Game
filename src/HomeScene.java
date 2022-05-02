import javax.swing.*;
import java.awt.*;
                          //     עידכון אחרון: 2.05 15:15


public class HomeScene extends JFrame {

    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;
    JTextArea instructions = new JTextArea("Help Goku save the world !!\n" +
            "In order to defeat Priza and save the world, you must collect all 7 Dragon Balls.\n" +
            "If you miss even one ball,\n" +
            "Or you're hit by Priza's energy balls three times,\n" +
            "You will lose and the earth will be destroyed !!!\n" +
            "\n" +
            "Go ahead and get going!");

    public HomeScene(){
        this.setSize(WHITH,HIGHT);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        JPanel homePanel=new JPanel();
        homePanel.setBounds(0,0,WHITH,HIGHT);
        homePanel.setBackground(Color.CYAN);
        add(homePanel);
        homePanel.setVisible(true);
        JButton newGameB=new JButton();  //  כפתור למשחק חדש
        newGameB.setBounds(WHITH/2,((HIGHT/3)*2)-80,160,50);
        newGameB.setText("New Game");
        newGameB.setBackground(Color.YELLOW);
        newGameB.addActionListener((event)->{
            add(new GameScene());
        });
        add(newGameB);
        newGameB.setVisible(true);

        JButton exitB =new JButton();
        exitB.setBounds(WHITH/2,(HIGHT/3)*2,160,50);
        exitB.setText("Exit");
        exitB.setBackground(Color.RED);
        exitB.addActionListener((event)->{ // **
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
        add(exitB);
        exitB.setVisible(true);
        GameInstructions i=new GameInstructions();

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            HomeScene beta=new HomeScene();
            beta.setVisible(true);
        });
    }


}

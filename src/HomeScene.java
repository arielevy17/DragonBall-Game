import javax.swing.*;
import java.awt.*;
                          //     עידכון אחרון: 4.8.22


public class HomeScene extends JFrame {

    private final int WHITH=1000; // גודל הפאנל
    private final int HIGHT=950;
    private final int WHITH_GAME_SCENE=1300; // גודל הפאנל
    private final int HIGHT_GAME_SCENE=1000;

    public HomeScene(){
        this.setSize(WHITH,HIGHT);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        GameInstructions i=new GameInstructions();
        JPanel homePanel=i;
        homePanel.setBounds(0,0,WHITH,HIGHT);
        add(homePanel);
        homePanel.setVisible(true);
        JButton newGameB=new JButton();  //  כפתור למשחק חדש
        newGameB.setBounds(WHITH/2,((HIGHT/3)*2)-80,160,50);
        newGameB.setText("New Game");
        newGameB.setBackground(Color.YELLOW);
        newGameB.addActionListener((event)->{
            this.setSize(WHITH_GAME_SCENE,HIGHT_GAME_SCENE);
            add(new GameScene());
        });
        add(newGameB);
        newGameB.requestFocus();
        newGameB.setVisible(true);



    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            HomeScene beta=new HomeScene();
            beta.setVisible(true);
        });
    }


}

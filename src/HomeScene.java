import javax.swing.*;
import java.awt.*;
                          //     עידכון אחרון: 30.4 21:42
                          //   כרגע באגים גדולים מדי בclass לכן לא אשתמש בו!!

public class HomeScene extends JFrame {

    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;

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
           // newGameB.setFocusable(false);   TODO: עבד לי פעם אחת, לשאול את שי כיצד להחליף פוקוס בין הפאנלים
            add(new GameScene());
        });
        add(newGameB);
        newGameB.setVisible(true);

        JButton exitB =new JButton();
        exitB.setBounds(WHITH/2,(HIGHT/3)*2,160,50);
        exitB.setText("Exit");
        exitB.setBackground(Color.RED);
        exitB.addActionListener((event)->{ // TODO: לא יוצא לי מהמשחק
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
        add(exitB);
        exitB.setVisible(true);

    }


}

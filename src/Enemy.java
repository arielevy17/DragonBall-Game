import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Enemy {

                             //   שינוי אחרון רלוונטי: 17:16

    Random random=new Random();
    private final int HIGHT=1000;
    private final int TIMER_DELY=2000;

    private int x;
    private int y;
    private int with;
    private int height;
    private Image image;

    public Enemy(int x, int y,ImageIcon image){
        this.x=x;
        this.y=y;
        this.image=image.getImage();
        with=image.getIconWidth();
        height =image.getIconHeight();
    }

    public int getWith() {
        return with;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void move(){
        Timer timer=new Timer(TIMER_DELY, new ActionListener() { // טיימר לתיזמון הפעולהץ בתוך המתודה!!!
            @Override
            public void actionPerformed(ActionEvent e) {
                y=random.nextInt(HIGHT-height);
            }
        });
        timer.start();
    }
}

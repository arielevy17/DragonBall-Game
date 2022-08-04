import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class DragonBall {
    Random random= new Random();
                              //   שינוי אחרון רלוונטי: 8:16


    private final int START_LIFE=3;
    private final int X_STEP=4;
    private final int X_BALL_CHANGE=100;

    private ImageIcon dragonBallPicture;
    private int x;
    private int y;
    private int with;
    private int higth;
    protected boolean visible;
    private ImageIcon gokuPictuer;
    private Hero goku;
    private Rectangle herowRect;


    public DragonBall(int x, int y, ImageIcon image) {
        dragonBallPicture = image;
        this.y = y;
        this.x = x;
        this.with=dragonBallPicture.getIconWidth();
        this.higth=dragonBallPicture.getIconHeight();
        visible = true;
        this.gokuPictuer = new ImageIcon("image_herow-removebg-preview.png"); // תמונת הגיבור
        goku = new Hero(gokuPictuer, START_LIFE);
        herowRect =new Rectangle(goku.getX() , goku.getY(),goku.getWidth(),goku.getHeight());
        setVisible(true);


        // עיצוב הגופן של הd.b counter
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ImageIcon getDragonBallPicture() {
        return dragonBallPicture;
    }



    //  מתודת תזוזה
    public void move() {
                x -= X_STEP;
            }

    public boolean isCatch(DragonBall d){
        boolean ans=false;
        Rectangle dragonBallRect=new Rectangle(this.x,this.y,with,higth);
        if (dragonBallRect.intersects(herowRect)){
            ans=true;
            System.out.println("ball counter ======================= ");
            d.setX(-X_BALL_CHANGE);
            move();
        }
        return ans;
    }


    public void setXHerowRect(int x) {
        this.herowRect.x = x;
    }
    public void setYHerowRect(int y) {
        this.herowRect.y = y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setX(int x) {
        this.x = x;
    }



    public int getY() {
        return y;
    }


}

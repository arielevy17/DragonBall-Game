import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Obstacle {
    private final int START_LIFE=3;
    private final int X_MOVE_CODITION=300;
    private final double X_STEP=2.5;
    private final int OBSTACLE_X_CHANGE=500;

    private double x;
    private double dSpeed=-1.4;
    private int y;
    private int with;
    private int height;
    private Image image;
    private boolean visible;
    private Hero goku;
    private ImageIcon gokuPictuer;
    private Rectangle herowRect;

    Random random= new Random();
                               //   שינוי אחרון רלוונטי: 8:16

    public Obstacle (int x, int y, ImageIcon image){
        this.x=x;
        this.y=y;
        with=image.getIconWidth();
        height=image.getIconHeight();
        this.image=image.getImage();
        visible =true;
        this.gokuPictuer = new ImageIcon("image_herow-removebg-preview.png"); // תמונת הגיבור
        goku = new Hero(gokuPictuer, START_LIFE);
        herowRect =new Rectangle(goku.getX() , goku.getY(),goku.getWidth(),goku.getHeight());
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setdSpeed(double dSpeed) {
        this.dSpeed = dSpeed;
    }

    public double getdSpeed() {
        return dSpeed;
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

    public void setXHerowRect(int x) {
        this.herowRect.x = x;
    }
    public void setYHerowRect(int y) {
        this.herowRect.y = y;
    }


    public void move() {
            if (x > -X_MOVE_CODITION) {
                        x -= X_STEP -dSpeed;  // 4 מהירות מקסימלית

            }
        }



    public boolean getHart(Obstacle o){
        boolean ans=false;
        Rectangle obstacleRect=new Rectangle((int)this.x,this.y,with,height);
        if (obstacleRect.intersects(herowRect)){
            ans=true;
            visible=false;
            System.out.println("hart!!!!! ");
            o.setX(-OBSTACLE_X_CHANGE);
            goku.setLifeCounter(goku.getLifeCounter()-1);
        }
        return ans;
    }
}

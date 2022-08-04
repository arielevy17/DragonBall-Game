import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public  class Hero {
                      //   שינוי אחרון רלוונטי: 15:54

    private  final int SPEED=5;
    final int HEROW_X_START=30;
    final int HEROW_Y_START=350;
    final int DELTA_AFTER_RELEASE=0;
    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;

    private int dragonBallsCounter=0;
    private int dx; // דלתא x (השינוי בx)
    private int dy; //דלתא y (השינוי בy)
    private int x=HEROW_X_START;
    private int y=HEROW_Y_START;
    private int width;
    private int height;
    private int lifeCounter;
    private Image image;
    private Rectangle rectangle;

    public Hero(ImageIcon image, int lifeCounter) {
        this.image=image.getImage();
        this.lifeCounter=lifeCounter;
        width=image.getIconWidth();
        height=image.getIconHeight();
        dragonBallsCounter=0;
        rectangle=new Rectangle(x ,y ,width,height);
    }

    public int getLifeCounter() {
        return lifeCounter;
    }

    public void setLifeCounter(int lifeCounter) {
        this.lifeCounter = lifeCounter;
    }

    public int getDragonBallsCounter() {
        return dragonBallsCounter;
    }
    public void setDragonBallsCounter(int counter) {
        this.dragonBallsCounter = counter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }


    public Rectangle getRectangle() {
        return rectangle;
    }

    public void move(){
            x += dx;
            y += dy;

    }
    // מתודה המאפשרת תזוזה בעת לחיצה על מקשי תנועה
    public  void keyPressed(KeyEvent k){
        int key=k.getKeyCode();
        if (key==KeyEvent.VK_LEFT && getX()>HEROW_X_START){
            dx=-SPEED;

        }
        if (key==KeyEvent.VK_RIGHT && getX()<WHITH-(getWidth()*3)){
            dx=SPEED;
        }
        if (key==KeyEvent.VK_UP && getY()>0){
            dy=-SPEED;
        }
        if (key==KeyEvent.VK_DOWN && getY()<(HIGHT-(getHeight()*1.3))){
            dy=SPEED;
        }
    }
    // מתודה שעוצרת את התנועה בזמן הרמת האצבע מהמקש
     public void keyReleased(KeyEvent k){
        int key=k.getKeyCode();
        if (key==KeyEvent.VK_LEFT){
            dx=DELTA_AFTER_RELEASE;
        }
        if (key==KeyEvent.VK_RIGHT){
            dx=DELTA_AFTER_RELEASE;
        }
        if (key==KeyEvent.VK_UP){
            dy=DELTA_AFTER_RELEASE;
        }
        if (key==KeyEvent.VK_DOWN){
            dy=DELTA_AFTER_RELEASE;
        }
    }

}

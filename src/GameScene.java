import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
//   TODO: לעצב גופן טקס, אולי כדי להחליף בכותרת יותר יפה לנסות

public class GameScene extends JPanel implements ActionListener {

                                   //   שינוי אחרון רלוונטי: 1.5  02:43

    private final int WHITH=1300; // גודל הפאנל
    private final int HIGHT=1000;
    private final int XSTART=0; //מיקום הפאנל
    private final int YSTART=0;
   private final int TEXT_WITH =150;
    private final int TEXT_HIGTH =35;
    private final int LIFE_CUONTER_X=10;
    private final int TEXT_SIZE=15;
    private final int DELTA_TEXT=40;
    private final int DELTA_Y_FRIZA=100;
    private final int OBSTACKE_DELTA_X=40;
    private final int OBSTACKE_DELTA_Y=60;
    private final int LOSS_LIFE_C=0;
    private final int FOUNT_SIZE=40;
    private final int START_LIFE=3;
    private final double DELTA_SPEED=0.7;
    private final ImageIcon ballImage =new ImageIcon("ball_image.png");
    private final ImageIcon obstacleImage =new ImageIcon("obstacle_image.png");
    private final ImageIcon winImage= new ImageIcon("winImage-removebg-preview.png");
    private final ImageIcon lossImage= new ImageIcon("lossImage.png");
    Random random=new Random();

    private Timer timer;
        private Hero goku; // ** לפיתוח עתידי, לעשות:תנאי בחירה שחקנים scanner
        private Enemy friza;
        private  final  int DELAY = 7;
        private final ImageIcon frizaPicture= new ImageIcon("enemy_image.png");
        private final ImageIcon gokuPictuer=new ImageIcon("image_herow.png");
        private ImageIcon baeck;
       private Obstacle obstacle;
       private DragonBall dragonBall;


       private int m=-2000-random.nextInt(30+3000)-3030; // הערך הרנדומלי שאליו יגיע הכדור ויחזור חזרה למסך

       public GameScene(){

           this.requestFocus();
           this.setLayout(null);
            this.setBounds(XSTART,YSTART,WHITH,HIGHT); // גדלי החלון
            addKeyListener(new TAdapter()); //*** ליסנר שבודק כל הזמן האם מקש נלחץ
          this.setBackground(Color.cyan); //  TODO:לשנות לתמונה


           Font gameOverFont=new Font("YOU LOSE!",Font.ITALIC,FOUNT_SIZE);
           JLabel gameOver= new JLabel(lossImage);
           gameOver.setText("     YOU LOSE!"+"\n GAME OVER!!!");
           gameOver.setForeground(Color.RED);
           gameOver.setBounds(XSTART,YSTART,WHITH,HIGHT);
           gameOver.setHorizontalTextPosition(JLabel.CENTER);
           gameOver.setVerticalTextPosition(JLabel.TOP);
           gameOver.setBackground(Color.RED);
           gameOver.setFont(gameOverFont);

           Font winFont=new Font("YOU WIN",Font.ITALIC,FOUNT_SIZE);
           JLabel win=new JLabel(winImage);
           win.setText("    YOU WIN!! \n now we destroy you friza!!");
           win.setForeground(Color.orange);
           win.setBounds(XSTART,YSTART,WHITH,HIGHT);
           win.setHorizontalTextPosition(JLabel.CENTER);
           win.setVerticalTextPosition(JLabel.TOP);
           win.setBackground(Color.orange);
           win.setFont(winFont);

           goku =new Hero(gokuPictuer,START_LIFE);

           JLabel lifeCounterText=new JLabel("amount of life rest: "+ goku.getLifeCounter()); // תיבת טקסט חיים
           Font lifeFount=new Font("life",Font.ITALIC,TEXT_SIZE);  //TODO: עיצוב גופן - עתיד!!
           lifeCounterText.setFont(lifeFount);
           lifeCounterText.setBounds(10,YSTART, TEXT_WITH, TEXT_HIGTH);
           lifeCounterText.setHorizontalTextPosition(JLabel.CENTER);
           lifeCounterText.setBackground(Color.green);
           lifeCounterText.setOpaque(true);
           this.add(lifeCounterText);

           JLabel dragonBCounterText=new JLabel("balls number collected: "+ goku.getDragonBallsCounter()); //תיבת טקסט כמות הכדורים שנאספו
           Font dCounterFount=new Font("dragon counter",Font.ITALIC,TEXT_SIZE);  //TODO: עיצוב גופן - עתיד!!
           dragonBCounterText.setFont(dCounterFount);
           dragonBCounterText.setBounds(WHITH-(TEXT_WITH +DELTA_TEXT),YSTART, TEXT_WITH +TEXT_SIZE, TEXT_HIGTH);
           dragonBCounterText.setHorizontalTextPosition(JLabel.CENTER);
           dragonBCounterText.setBackground(Color.ORANGE);
           dragonBCounterText.setOpaque(true);
           this.add(dragonBCounterText);


           // בניית האוביקטים המרכזים
           baeck=new ImageIcon("beacground.png");
           friza= new Enemy(WHITH-frizaPicture.getIconWidth(),(HIGHT/2)-DELTA_Y_FRIZA,frizaPicture);
           obstacle = new Obstacle(WHITH-frizaPicture.getIconWidth()-OBSTACKE_DELTA_X,friza.getY()+OBSTACKE_DELTA_Y,obstacleImage);
           dragonBall=new DragonBall(WHITH,random.nextInt(HIGHT-(ballImage.getIconHeight()*2)), ballImage);

           Thread t1 = new Thread(() -> { //
               timer=new Timer(DELAY,this);
               timer.start();
               repaint();
               this.setLayout(null);
               setFocusable(true);
               this.setDoubleBuffered(true);
               friza.move();
               while (true) {
                   try {
                       repaint();

                       //  מתודות התזוזה,בדיקה,וחזרה של המכשול

                       obstacle.move();
                       obstacle.setXHerowRect(goku.getX());
                       obstacle.setYHerowRect(goku.getY());
                       if (obstacle.getHart(obstacle)) {
                           try {  // חריגה למקרה של מספר שלילי
                               goku.setLifeCounter(goku.getLifeCounter() - 1); // מעדכן חיים

                            if (goku.getLifeCounter()==LOSS_LIFE_C){ // במקרה של הפסד
                                System.out.println("game over");
                                add(gameOver);
                                //  TODO:הופעת מסך הבית
                                break;
                            }
                           } catch (Exception e){
                               System.out.println("there is a problem."+ "\n please call the technical-support: +972-58-648-9811." );
                           }

                           lifeCounterText.setText("amount of life rest:"+ goku.getLifeCounter()); // TODO: שהחיים יתעדכנו לבד
                       }

                       if (obstacle.getX() < XSTART) {
                           obstacle.setX(WHITH - frizaPicture.getIconWidth() - OBSTACKE_DELTA_X);
                           obstacle.setY(friza.getY() + OBSTACKE_DELTA_Y);
                           System.out.println("im back");
                       }

                       //  מתודות התזוזה,בדיקה,וחזרה של הכדור

                       dragonBall.move();
                       dragonBall.setXHerowRect(goku.getX());
                       dragonBall.setYHerowRect(goku.getY());

                       if (dragonBall.getX()==LOSS_LIFE_C){ //  מקרה של הפסד
                           System.out.println("game over");
                           add(gameOver);
                           //  TODO:הופעת מסך הבית
                           setVisible(true);
                           break;

                       }
                                // מקרה של תפיסה
                       if (dragonBall.isCatch(dragonBall)) {
                           System.out.println(obstacle.getdSpeed());
                           obstacle.setdSpeed(obstacle.getdSpeed() - DELTA_SPEED); // העלאת המהירות
                           System.out.println(obstacle.getdSpeed());
                           goku.setDragonBallsCounter(goku.getDragonBallsCounter() + 1);
                           dragonBCounterText.setText("balls number collected: " + goku.getDragonBallsCounter());
                           }
                       if (goku.getDragonBallsCounter()==7){  //  תנאי לניצחון
                           add(win);
                           break;
                       }
                       if (dragonBall.getX()< m){
                           dragonBall.setX(WHITH);
                           dragonBall.setY(random.nextInt(HIGHT - (ballImage.getIconHeight() * 3)));
                       }


                       Thread.sleep(1);

                   } catch (InterruptedException e) {
                       System.out.println("there is a problem."+ "\n please call the technical-support: +972-58-648-9811." );
                   }
               }

           });
           t1.start();

        }

        // מתודות ציור(גרפיקה)
        public  void paintComponent(Graphics g){
            super.paintComponent(g);
            this.baeck.paintIcon(this,g,XSTART,YSTART);
            doDrawing(g);

            Toolkit.getDefaultToolkit().sync();
        }

        private void doDrawing(Graphics g){  // מתודת גרפיקה שמציירת את התמונה- בלעדיה אין תמונה-חשוב מאוד!!!
            Graphics2D g2d=(Graphics2D) g;

            g2d.drawImage(goku.getImage(),goku.getX(),goku.getY(),this);
            g2d.drawImage(friza.getImage(),friza.getX(),friza.getY(),this);
            g2d.drawImage(obstacle.getImage(),(int) obstacle.getX(), obstacle.getY(),this);
            g2d.drawImage(dragonBall.getDragonBallPicture().getImage(), dragonBall.getX(), dragonBall.getY(), this);
        }

        public void step(){  // מתודה המציירת מחדש לאחר צעד של הדמות
            goku.move();

            repaint(goku.getX()-1,goku.getY()-1,goku.getWidth()+2,goku.getHeight()+2);
        }

        public void actionPerformed(ActionEvent e){
            step();
        }


    private class TAdapter extends KeyAdapter { //** איך מתבצע בדיוק הליסנר הזה

        public void keyReleased(KeyEvent e){
       goku.keyReleased(e);
        }

        public void  keyPressed(KeyEvent e){
            goku.keyPressed(e);
        }
    }

}


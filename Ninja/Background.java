import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    public static Obstacle1 obstacle = new Obstacle1(5);
    public static Wall1 wall1 = new Wall1();
    public static Wall2 wall2 = new Wall2();
    public static Wall3 wall3 = new Wall3();
    public static Wall4 wall4 = new Wall4();
    public static Player player = new Player(3);
    private static final int DELAY_TIME=120;
     public static int delayTime = 120;
     public static int delayObstacle=150;
     private static final int DELAY_OBSTACLE=150;
     public static int delayObstacle2=50;
     private static final int DELAY_OBSTACLE2=50;
     public static int delay=0;
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1);
        addObject(wall1,0,0);
        addObject(wall2,0,600);
        addObject(wall3,400,0);
        addObject(wall4,400,600);
        addObject(player,327,500);
    }
     public int num;
     public void act()
    {
       
        delayTime--;
        delayObstacle--;
        
        delayObstacle();
        delayObstacle2--;
        displayScore();
        nextLevel();
    }
   
    public void randomNumber()
    {
        num = Greenfoot.getRandomNumber(100);
    }
    public void delayObstacle()
    {
        if(delayObstacle<=0)
        {
            releaseObstacle();
            randomNumber();
        }
    }
    public void releaseObstacle()
    {
        if(delayObstacle2<=0)
        {
            if(num%2==0)
            {
            Obstacle1 obstacle = new Obstacle1(5);
            addObject(obstacle,327,0);
            obstacle.move(3);
            delayObstacle2=DELAY_OBSTACLE2;
        }
        else if (num%2!=0)
        {
        
            Obstacle1 obstacle = new Obstacle1(5);
            addObject(obstacle,100,0);
            obstacle.move(3);
            obstacle.rotate();
            delayObstacle2=DELAY_OBSTACLE2;
        }
        }
    }
     public void displayScore()
    {
        showText("Score : "+Player.score,60,33);
    }
    public void nextLevel()
    {
        if(Player.score>=10)
        {
            setBackground("NextLevel2.jpg");
            Greenfoot.stop();
        }
    }
}

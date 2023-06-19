import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed;
    private int timer = 0;
    private int space;
    private static final int MAX_TIME = 20;
    private static int secondTimer = 20;
    public static int score;
    public Player(int speed)
    {
        this.speed = speed;
        setRotation(getRotation()+270);
    }
    public void move(int speed)
    {
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-speed);
        }
         if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+speed);
            setImage("NarutoRun1.png");
        }
    }
    public void imageSwapping1()
    {
       if (timer>=0)
        {
            setImage("NarutoRun1.png");
        }
        if (timer>=10)
        {
            setImage("NarutoRun2.png");
        }
        if (timer>=20)
        {
            setImage("NarutoRun3.png");
        }
        if (timer>=30)
        {
            setImage("NarutoRun4.png");
        }
        if (timer>=40)
        {
            setImage("NarutoRun5.png");
        }
         if (timer>=50)
        {
            setImage("NarutoRun6.png");
            timer = 0;
        }
    }
    
    public void enterSpace(){
        timer++;
        secondTimer--;
        if(Greenfoot.isKeyDown("space")&&secondTimer<=0)
        {
            secondTimer=MAX_TIME;
            space = space+1;
        }
        if(space%2==1)
            {
                setLocation(73,getY());
                imageSwapping2();
            }
            else if(space%2==0)
            {
                setLocation(327,getY());
                imageSwapping1();
            }
    }
    public void imageSwapping2()
    {
       if (timer>=0)
        {
            setImage("MirrorImg1.png");
        }
        if (timer>=10)
        {
            setImage("MirrorImg2.png");
        }
        if (timer>=20)
        {
            setImage("MirrorImg3.png");
        }
        if (timer>=30)
        {
            setImage("MirrorImg4.png");
        }
        if (timer>=40)
        {
            setImage("MirrorImg5.png");
        }
         if (timer>=50)
        {
            setImage("MirrorImg6.png");
            timer = 0;
        }
    }
     public void destroyAlien()
    {
       Obstacle1 obstacle1 = (Obstacle1)getOneIntersectingObject(Obstacle1.class);
        if(obstacle1!=null)
        {
            getWorld().addObject(new Gameover(),200,300);
            Greenfoot.stop();
        }
    }
    public void act()
    {
        move(speed);
        enterSpace();
        destroyAlien();
    }
}

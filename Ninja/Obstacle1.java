import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle1 extends Actor
{
    private int speed;
    public Obstacle1(int speed)
    {
        this.speed = speed;
        setRotation(getRotation()+270);
    }
    public void move(int speed)
    {
        setLocation(getX(),getY()+speed);
         
        if (getY()==599)
        {
            Player.score++;
            World world = getWorld();
            world.removeObject(this);
        }
    }
    public  void rotate()
    {
        setRotation(getRotation()+180);
    }
    public void act()
    {
        move(speed);
    }
}

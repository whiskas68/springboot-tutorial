package demo4;

public class RealRobot implements Irobot {

    public void say(String str){
        System.out.println("hello " + str);
    }

    public static void main (String[] args){
        RealRobot realRobot = new RealRobot();
        realRobot.say("world");
    }

}

public class Display {
    private Numbers hour;
    private Numbers minute;
    private Numbers second;
    private String DisplayNums;

    public Display(){
        hour = new Numbers(24);
        minute = new Numbers(60);
        second = new Numbers(60);

    }
    public Display(int hours, int minutes, int seconds){
        hour = new Numbers(24);
        minute = new Numbers(60);
        second = new Numbers(60);
    }
    public void TickTime(){
        second.increment();
        if(second.getNum() == 0){
            minute.increment();
        }
        if(minute.getNum() == 0){
            hour.increment();
        }
        //Update
    }
    public void setTime(int hours, int minutes, int seconds){
        hour.setNum(hours);
        minute.setNum(minutes);
        second.setNum(seconds);

    }
    public String getTime(){
        return DisplayNums;
    }
    public void updateDisplay(){
        DisplayNums = hour.getDisplayNum() + ":" +  minute.getDisplayNum() + ":" + second.getDisplayNum();
    }

}

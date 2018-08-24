public class Numbers {
    private int top;
    private int num;

    public Numbers(int limit){
        top = limit;
        num = 0;
    }
    public int getNum(){
        return num;
    }
    public String getDisplayNum(){
        if(num < 10){
            return "0" + num;
        }else{
            return "" + num;
        }
    }
    public void setNum(int replacement){
        num = replacement;
    }
    public void increment(){
        num = (num + 1) % top;
    }
}

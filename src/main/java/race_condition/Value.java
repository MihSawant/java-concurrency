package race_condition;

public class Value{
//    private final Object key = new Object();
    volatile int num;
    public Value(int num){
        this.num = num;
    }

    public void incrementValue(){
        num = num + 1;
    }
    public int getValue(){
        return num;
    }
}

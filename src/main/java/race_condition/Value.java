package race_condition;

public class Value{
    private final Object key = new Object();
    int num;
    public Value(int num){
        this.num = num;
    }

    public void incrementValue(){
        synchronized (key){
            num = num + 1;
        }
    }
    public int getValue(){
        return num;
    }
}

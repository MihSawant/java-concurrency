package race_condition;

public class Value{
    int num;
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

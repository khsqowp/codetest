import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MoneyCompare {
    List<Integer> ticket = new ArrayList<>();
    int bonusNum = 0;
    int matchBonusL = 0;
    
    int earnMoney = 0;

    float percentage = 0.0F;
    
    public MoneyCompare(List<Integer> ticket, int bonusNum, int matchBonusL, int earnMoney){
        this.bonusNum = bonusNum;
        this.matchBonusL = matchBonusL;
        this.earnMoney = earnMoney;
        this.ticket = ticket;


    }
    public void SetMoney(int earnMoney){
        this.earnMoney = earnMoney;
    }
    public int GetMoney(){
        return earnMoney;
    }
    public float GetPercentage(){
        return this.percentage;
    }
    
}

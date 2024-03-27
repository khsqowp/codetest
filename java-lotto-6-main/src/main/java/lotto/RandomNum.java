package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.ticketList;

public class RandomNum {
    private static final int lottoSize = 6;
    private Application application = new Application();
    int tempNum;
    boolean isRemoved;
    List<Integer> ticket = null;

    public int RandomNumOneTicket(){
        this.tempNum = Randoms.pickNumberInList(Application.RandomWinningNumMethod());
        this.isRemoved = Application.randomWinningNum.remove(Integer.valueOf(tempNum));
        Application.ticket.add(tempNum);

        return tempNum;
    }

    public List<ArrayList<Integer>> Tickets (ArrayList<Integer> ticket){
        ticketList.add(ticket);
        return ticketList;
    }



}

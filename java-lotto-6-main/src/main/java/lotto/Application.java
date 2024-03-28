package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int tickets = 1000;
    static final int winningCount = 6;
    static final int lottoRange = 45;
    static RandomNum randomnum = new RandomNum();
    static String winningNumStr;
    static int money;
    static int chance = 0;
    static int bonusNum = 0;
    static int matchCountBonus = 0;
    public static List<Integer> lotto = new ArrayList<>();
    public static List<Integer> randomWinningNum = new ArrayList<>();
    public static List<Integer> ticket = new ArrayList<>();
    public static List<ArrayList<Integer>> ticketList = new ArrayList<ArrayList<Integer>>();
    public static List<Integer> matchCounts = new ArrayList<>();
    public static List<Integer> matchBonusL = new ArrayList<>();
    static void InputTicket(){
        //금액 입력 메서도, 오류체크
        money = Integer.parseInt(Console.readLine());
        boolean moneybool = false;
        while(!moneybool){
            try{
                if(money / tickets ==0){
                    throw new IllegalArgumentException("숫자가 1000원 단위가 아닙니다");
                }
                moneybool = true;
            } catch(NumberFormatException e){
                System.out.println("유효하지 않은 입력. 정수가 아닙니다");
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } chance = money/tickets;
    }
    static void ErrorCheck(){
        //6자리 번호 입력 메서드, 오류확인
        winningNumStr = Console.readLine();
        boolean lottoBool = false;
        while(!lottoBool){
            try{
                if(winningNumStr.length() != winningCount) {
                    throw new IllegalArgumentException("갯수가 맞지 않습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 입력");
            } catch (IllegalArgumentException e){
                System.out.println("숫자가 6개가 아닙니다.");
            }
        }
    }
    static void InputWinningNum() {
        //6자리 숫자 리스트화
        ErrorCheck();
        String[] winningNumArr = winningNumStr.split(",");
        Integer[] winningNum = new Integer[winningCount];
        for (int i = 0; i < winningNumArr.length; i++) {
            winningNum[i] = Integer.parseInt(winningNumArr[i]);
        }

        for (int i = 0; i < winningNumArr.length; i++) {
            lotto.add(i, winningNum[i]);
        }
    }

    static void InputBonusNum(){
        //보너스 번호 입력 메서드, 오류확인
        String bonusNumStr = Console.readLine();
         boolean bonusCheck = false;
         while(!bonusCheck){
             try{
                 bonusNum = Integer.parseInt(bonusNumStr);
                 if(lotto.contains(bonusNum)){
                     throw new NumberFormatException("로또6자리 숫자안에 이미 포함되어 있습니다.");
                 }
                 } catch (NumberFormatException e){
                 System.out.println("정수형이 아닙니다.");
             }
         }
    }

    static List<Integer> RandomWinningNumMethod(){
        //1~45 리스트 생성 메서드
        randomWinningNum.clear();
        //1~45 숫자 리스트 생성
        for(int i = 0; i < lottoRange; i++){
        randomWinningNum.add(i, i+1);
        }
        return randomWinningNum;
    }

    static List<Integer> TicketCreate(){
        //6자리 로또 한장 생성
        RandomWinningNumMethod();
        List<Integer> tempNum = null;
        for(int i = 0; i < winningCount; i++){
            ticket.add(randomnum.RandomNumOneTicket());
        }
        return ticket;
    };

    static void BuyTickets(){
        //chance 수 만큼 로또 생성
        for(int i = 0; i < chance; i++){
            ticketList = new RandomNum().Tickets((ArrayList<Integer>) ticket);
        }
    }

    static void CompareOneLotto(List<ArrayList<Integer>> ticketList){
         int matchCount = 0;
         for(int i = 0; i < winningCount; i++){
             if(ticket.contains(lotto.get(i))){
                 matchCount++;
             }
         }
         matchCounts.add(matchCount);
         for(int i = 0; i < winningCount; i++){
             if(ticket.contains(bonusNum)){
                 matchBonusL.add(1);
             }
         }
        for(Integer number : ticket){
            if(lotto.contains(number)) matchCount++;
        matchCounts.add(matchCount);
        }

    }

    static void WinningMoney() {
        CompareOneLotto();


    }

    static void CompareAllLotto() {
        for(int i = 0; i < chance; i++){
            CompareOneLotto();

        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해주세요.");
        InputTicket();
        System.out.print(chance + "개를 구매했습니다.");

        System.out.println("당첨 번호를 입력해주세요");
        InputWinningNum();
        System.out.println("보너스 번호를 입력해 주세요.");
        InputBonusNum();

        System.out.println("당첨 통계 \n ---");
        System.out.println("3개 일치 (5,000원) - " +  + "개");
        System.out.println("4개 일치 (50,000원) - " + + "개");
        System.out.println("5개 일치 (1,500,000원) - " + + "개");
        System.out.println("5개 일치, 보너스볼 일치 (30,000,000원) - " + + "개");
        System.out.println("6개 일치(2,000,000,000원) - " + + "개");
        System.out.println("총 수익률은" + +"%입니다.");





    }
}

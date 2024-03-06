package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String racers = Console.readLine();
        String [] racer_list = racers.split(",");
        String raceerror(racers);
        System.out.println(k);

        for(int i = 0; i < racer_list.length; i++){
            int [] speed[i] = Randoms.pickNumberInRange(0,9);
        }



    }
    public static String raceerror(String [] racer_list) throws IllegalArgumentException{
        for(int i = 0; i < racer_list.length; i++){
            if(racer_list[i].length() > 5){
                throw new IllegalArgumentException("5글자 이내로 해주세요");
            }
        }

        return k;
    }
}

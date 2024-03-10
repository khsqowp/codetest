package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Application {

    static Integer[] youNum;

    //랜덤넘버 만들기
    static Integer[] youNum2() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Integer[] youNum2 = new Integer[3];
        youNum2 = computer.toArray(youNum2);

        youNum = youNum2;
        return youNum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean restart = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");

            // 입력 받아오기
            int input_num = Integer.parseInt(Console.readLine());

            //세자리 숫자를 배열화
            Integer[] my_num = new Integer[3];

            String num2str = Integer.toString(input_num);
            String[] str2arr = num2str.split("");
            for (int i = 0; i < str2arr.length; i++) {
                my_num[i] = Integer.parseInt(str2arr[i]);
            }

            for (int i = 0; i < 2; i++) {
                int digit = input_num % 10;
                my_num[2 - i] = digit;
                input_num /= 10;
            }

            for (int i = 0; i < 3; i++) {
                if (Objects.equals(my_num[i], youNum[i])) {
                    strike += 1;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int ii = 0; ii < 2; ii++) {
                    if (Objects.equals(my_num[i], youNum[ii])) {
                        ball += 1;
                    }
                }
            }
            ball -= strike;

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else {
                if (3 > ball && ball > 0) {
                    System.out.print(ball + "볼");
                    restart = true;
                }
                if (3 > strike && strike > 0) {
                    System.out.println(strike + "스트라이크");
                    restart = true;
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restartnum = Console.readLine();

                    if (restartnum.equalsIgnoreCase("1")) {
                        youNum2();
                    }
                    restart = restartnum.equalsIgnoreCase("1");
                }
            }

        } while (restart);


    }
}

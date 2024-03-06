package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;




public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean restart = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");

            //컴퓨터 랜덤 숫자
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            // 입력 받아오기
            int input_num = Integer.parseInt(Console.readLine());

            //세자리 숫자를 배열화
            int[] you_num = Stream.of(String.valueOf(computer).split("")).mapToInt(Integer::parseInt).toArray();
            int[] my_num = Stream.of(String.valueOf(input_num).split("")).mapToInt(Integer::parseInt).toArray();

            //세자리 숫자가 나오는지 검증
            try {
                int try_num = input_num;
                if (1000 > try_num && try_num > 99) {
                    try_num = 0;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("숫자를 입력해주세요 : ");
            }

            //스트라이크 볼 판별
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                if (my_num[i] == (you_num[0] | you_num[2] | you_num[1])) {
                    ball += 1;
                }
            }
            for (int ii = 0; ii < 3; ii++) {
                if (my_num[ii] == you_num[ii]) {
                    strike += 1;
                    ball -= 1;
                }
            }
            if (ball < 1) {
                ball = 0;
            }
            if ((my_num[0] != you_num[0]) && (my_num[1] != you_num[1]) && (my_num[2] != you_num[2])) {
                System.out.println("낫싱");
            } else if ((my_num[0] == you_num[0]) && (my_num[1] == you_num[1]) && (my_num[2] == you_num[2])) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료 \n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restartnum = Console.readLine();

                restart = restartnum.equalsIgnoreCase("1");


            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        } while (restart);





    }
}

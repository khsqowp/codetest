package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import javax.security.auth.kerberos.KerberosTicket;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int tickets = 1000;
    static final int winningCount = 6;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto lotto = new Lotto();
        List<Lotto> lotto = new List<Lotto>();
        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        int chance = money / tickets;
        System.out.print(chance + "개를 구매했습니다.");

        System.out.println("당첨 번호를 입력해주세요");

    }
}

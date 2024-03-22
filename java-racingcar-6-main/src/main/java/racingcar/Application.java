package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {

    private static final int name_limit = 4;
    private static final int random_Nine = 9;
    private static final int random_Zero =0 ;
    private static String [] racer_list_arr ;
    private static ArrayList<User> racer_list = new ArrayList<User>();
    public static int racer_List_length;// = racer_list.size();
    public static int error_Num = 1;
    public static int racerRep = 0;

//public static class user{
//    String name;
//    int progress;
//    String dash = "-";
//    public user(String name1, int progress){
//        name = name1;
//        this.progress = progress;
//    }
//
//    public void addText(String additionalText){
//        name += additionalText;
//    }
//
//    public void incrementNumber() {
//        progress += 1;
//    }
//}
    public int errorCheck(int receive){
        error_Num = 0;
        for(int i = 0; i < racer_list.size(); i++){
            if(racer_list.get(i).name.length() > name_limit){
                error_Num += 1;
            }
        }
        if(error_Num == 1){
            receive = 0;
        } else {
            System.out.println("이름 길이가 너무 깁니다");
        }
        return receive;
    }
    public void game_Map(String name, int count){

        int tryNum = 0;
        String dash = "-";
        for(int i = 0; i < racer_List_length; i++) {

            if (Randoms.pickNumberInRange(random_Zero, random_Nine) >= 4) {
                //racer_list.get(i).incrementNumber();
                racer_list.get(i).incrementNumber();
            }
            System.out.println(racer_list.get(i).getName() + ":" + dash.repeat(racer_list.get(i).getCount()));
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //레이서 이름 입력받기
        String [] racer_list_arr;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racers = Console.readLine();
        racer_list_arr = racers.split(",");
        //List<User> user = new ArrayList<>();
        //배열을 리스트로 + "-" 추가 변수까지
        for (String racerName : racer_list_arr){
            racer_list.add(new User(racerName, 0));

        }

        //레이서 이름 오류 검사
        Application met = new Application();
        int result = met.errorCheck(0);
        if(result != 0){
            return;
        }

        //시도할 횟수 받기 및 검사
        System.out.println("시도할 회수는 몇회인가요?");
        racerRep = Integer.parseInt(Console.readLine());
        try {
            int racerRep = Integer.parseInt((Console.readLine()));
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다");
        }


        System.out.println("실행결과");
        racer_List_length = racer_list.size();
        for(int i = 0; i < racerRep; i++){
            //racer_list.get(i).addText(":");
            met.game_Map("",0);
            System.out.println();

        }
//        for(int i = 0; i < racerRep; i++){
//
//            met.game_Map(racer_list.get(i).getName(),racer_list.get(i).getCount());
//
//            System.out.println();
//        }

    }

}
/**
 * 유저 클래스를 만들고, 거기에 두가지(String 유저네임, Int 거리) 나중에는 거리로만 sort하면
 * stream 숫자객체로 게임 다 돌리고 이름만 나중에 출력
 * 유저 클래스 사용해보기
 **/
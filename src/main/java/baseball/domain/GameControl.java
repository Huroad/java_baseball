package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameControl {
        private Computer computer;

        public GameControl() {
            this.computer = new Computer();
        }
        public void start() {
        // 컴퓨터 랜덤숫자
        // 다시하기를 눌렀을때만 숫자를 초기화 -- 이부분을 메서드로 만들어서 호출하면 끝
        List<Integer>  computerlist = numArr();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String num;

        // 유효성 검사
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            num = String.valueOf(readLine());
            boolean numtf = NumberTrue.numtrue(num);
            //System.out.println("numtf = " + numtf);
            if (!numtf) {
                continue;
            }

            // 배열에 저장한 값을 볼, 스트라이크로 비교
            //computer <-- 리스트에 저장한 값
            int strike = BaseballGame.baseball(num, computerlist);
            boolean gg = false;
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String regame = String.valueOf(readLine());
                gg = regameture(regame, computerlist);
            }
            if (gg == true) {
                break;
            } else if (gg == false) {
                computerlist = numArr();
            }
            // 종료가 안되면 초기화한번더
        }
    }

    /*private static void computer(List<Integer> computerlist) {

    }*/

    public boolean regameture(String number, List<Integer> computerlist) {
        if(number.equals("1")){
            System.out.println("게임을 새로 시작");
            computerlist.clear();
            computer.clearNumbers();
            return false;
        } else if(number.equals("2")){
            System.out.println("게임 종료");
            return true;
        }
        return true;
    }

    public List<Integer> numArr() {
        return new ArrayList<>(computer.getNumbers());
    }
}

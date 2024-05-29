package baseball.domain;

import java.util.List;

public class BaseballGame {
    public static int baseball(String number, List<Integer> computer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            int numberInt = Character.getNumericValue(number.charAt(i));
            if(computer.contains(numberInt) &&  computer.get(i) == numberInt) {
                strike++;
            } else if (computer.contains(numberInt) &&  computer.get(i) != numberInt) {
                ball++;
            }
        }


        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return strike;
    }
}

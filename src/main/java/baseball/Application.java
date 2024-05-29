package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        // 컴퓨터 랜덤숫자
        // 다시하기를 눌렀을때만 숫자를 초기화 -- 이부분을 메서드로 만들어서 호출하면 끝
        List<Integer> computerlist = new ArrayList<>();
        computer(computerlist);

        System.out.println("숫자 야구 게임을 시작합니다.");
        String num;

        // 유효성 검사
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            num = String.valueOf(readLine());
            boolean numtf = numtrue(num);
            //System.out.println("numtf = " + numtf);
            if(!numtf) {
                continue;
            }

            // 배열에 저장한 값을 볼, 스트라이크로 비교
            //computer <-- 리스트에 저장한 값
            int strike = baseball(num, computerlist);
            boolean gg = false;
            if(strike  == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String regame = String.valueOf(readLine());
                //이부분을 메서드로 뺴야 댑스2를 만족
                gg = regameture(regame, computerlist);
            }
            if(gg == true) {
                break;
            }
        }
    }

    public static List<Integer> computer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    public static boolean numtrue (String number) {
         if (number.length() != 3) {
            //System.out.println("서로 다른 3자리의 수가 아닙니다");
             throw new IllegalArgumentException();
            //return false;
        }

        if (!number.matches("\\d{3}")) {
            System.out.println("숫자만 입력해 주세요");
            throw new IllegalArgumentException();
            //return false;
        }

        boolean numSame = false;
        /*for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j) && i != j) {
                    numSame = true;
                    break;
                }
            }
        }*/


        List<String> arr = Arrays.asList(number.split(""));
        List<String> distinctarr = arr.stream()
                .distinct()
                .collect(Collectors.toList());

        if(distinctarr.size() != 3) {
            System.out.println("중복된 숫자가 있습니다");
            throw new IllegalArgumentException();
            //return false;
        } else if (distinctarr.size() == 3) {
            return true;
        }

        /*if (numSame) {
            System.out.println("중복된 숫자가 있습니다");
            return false;
        }*/
        return true;
    }

    public static int baseball(String number, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        /*for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < number.length(); j++) {
                if(computer.get(i) + 48 == number.charAt(j) && i == j) {
                    strike += 1;
                } else if (computer.get(i) + 48 == number.charAt(j) && i != j) {
                    ball += 1;
                }
            }
        }*/

        for (int i = 0; i < computer.size(); i++) {
            int numberInt = Integer.valueOf(number.charAt(i)) - 48;
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

    public static boolean regameture(String number, List<Integer> computerlist) {
        if(number.equals("1")){
            System.out.println("게임을 새로 시작");
            computerlist.clear();
            computer(computerlist);
            return false;
        } else if(number.equals("2")){
            System.out.println("게임 종료");
            return true;
        }
        return true;
    }
}


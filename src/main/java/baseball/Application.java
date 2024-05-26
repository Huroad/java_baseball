package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num;

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            num = sc.next();

            if (num.length() != 3) {
                System.out.println("서로 다른 3자리의 수가 아닙니다");
                continue;
            }

            if (!num.matches("\\d{3}")) {
                System.out.println("숫자만 입력해 주세요");
                continue;
            }

            boolean numSame = false;
            for (int i = 0; i < num.length(); i++) {
                for (int j = i; j < num.length() - i; j++) {
                    if(num.charAt(i) == num.charAt(j) && i != j){
                        numSame = true;
                        break;
                    }
                }
            }

            if (numSame) {
                System.out.println("중복된 숫자가 있습니다");
            } else {
                System.out.println("중복된 숫자가 없으므로 게임을 시작합니다");
                break;
            }
        }
        System.out.println("입력한 숫자 : " + num);

        List<String> sclist = new ArrayList<String>();

        for (int i = 0; i < num.length(); i++) {
           sclist.add(String.valueOf(num.charAt(i)));
        }
        System.out.println("sclist : " + sclist);
    }
}

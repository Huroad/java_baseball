package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberTrue {
    public static boolean numtrue (String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다");        }

        if (!number.matches("\\d{3}")) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }

        List<String> arr = Arrays.asList(number.split(""));
        List<String> distinctarr = arr.stream()
                .distinct()
                .collect(Collectors.toList());

        if(distinctarr.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
        return true;
    }
}

package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
        generateNumbers();
    }

    public List<Integer> getNumbers() {
        if (numbers.isEmpty()) {
            generateNumbers(); // 비어있는 경우에만 숫자 생성
        }
        return numbers;
    }

    public void generateNumbers() {
        numbers.clear();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
       System.out.println(numbers);
    }

    public void clearNumbers() {
        numbers.clear(); // 리스트 초기화
    }
}


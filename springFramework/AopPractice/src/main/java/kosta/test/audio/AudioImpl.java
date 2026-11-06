package kosta.test.audio;

import org.springframework.stereotype.Component;
import kosta.test.service.Player;

// 과제 다이어그램의 패키지/클래스명을 유지합니다.
@Component
public class AudioImpl implements Player {
    @Override
    public void start(int volumn) {
        // TODO: 과제 실행 결과에 맞게 작성
    }

    @Override
    public String pause() {
        // TODO: 반환값 작성
        return null;
    }

    @Override
    public void stop() {
        // TODO: 과제 실행 결과에 맞게 작성
    }
}
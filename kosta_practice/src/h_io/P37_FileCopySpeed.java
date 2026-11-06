package h_io;

/**
 * ============================================================
 * 문제 37. 파일 복사 속도 비교
 * ============================================================
 *
 * [내용]
 *   같은 파일을 읽고 쓰는 방법을 바꿔 가며 속도를 재서, 버퍼가 왜 중요한지 숫자로 확인합니다.
 *
 * [요구사항]  (다 만들면 [ ] 를 [x] 로 바꿔 보세요)
 *   [ ] 1) 복사할 이미지 파일(수 MB)과 저장할 경로를 args 또는 Scanner 로
 *         입력받습니다.
 *   [ ] 2) ① FileInputStream/FileOutputStream 으로 1바이트씩 ②
 *         byte[1024] 배열 단위 ③
 *         BufferedInputStream/BufferedOutputStream 으로 세 번
 *         복사하고 각각의 소요 시간을 nanoTime 으로 출력합니다.
 *   [ ] 3) 복사한 파일의 크기가 원본과 같은지 File.length() 로 확인합니다.
 *   [ ] 4) 모든 방식에서 try-with-resources 로 자원을 닫으세요.
 *   [ ] 5) 저장할 파일이 이미 있으면 덮어쓰는지, 이어쓰는지(FileOutputStream 두 번째
 *         인수 true) 차이도 실험하세요.
 *
 * [사용할 개념]
 *   바이트 스트림, 보조 스트림(Buffered), try-with-resources,
 *   nanoTime
 */
public class P37_FileCopySpeed {

    public static void main(String[] args) {
        // TODO: 위 [요구사항] 1) ~ 5) 를 순서대로 구현하세요.
    }
}

/*
 * ----- 힌트 (막히면 1번부터 하나씩만 펼쳐 보세요) -----
 * 1) read(byte[]) 는 읽은 바이트 수를 반환하고 끝이면 -1 을 반환합니다.
 * 2) 마지막에 읽은 길이만큼만 write(buf, 0, len) 해야 파일이 깨지지 않습니다.
 * 3) Buffered 는 노드 스트림을 감싸서 쓰는 보조 스트림입니다.
 */

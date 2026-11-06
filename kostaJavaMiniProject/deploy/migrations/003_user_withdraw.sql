-- 회원 탈퇴 처리 (기록은 남기고 개인정보만 가림)
-- deploy/tools/Migrate.java 가 이미 적용된 항목은 건너뛰면서 실행합니다. DB 를 지우는 문장은 없습니다.
ALTER TABLE User ADD COLUMN Withdrawn BOOLEAN NOT NULL DEFAULT FALSE;

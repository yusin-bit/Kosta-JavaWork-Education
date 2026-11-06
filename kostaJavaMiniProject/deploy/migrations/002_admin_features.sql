-- 관리자 기능 확장용 스키마 (회원 정지, 공지사항, 관리자 활동 기록)
-- deploy/tools/Migrate.java 가 이미 적용된 항목은 건너뛰면서 실행합니다. DB 를 지우는 문장은 없습니다.

-- 회원 이용 정지
ALTER TABLE User ADD COLUMN Suspended BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE User ADD COLUMN SuspendReason VARCHAR(100) NULL;

-- 공지사항 (Active 인 공지만 회원 화면에 표시)
CREATE TABLE Notice (
    NoticeNum INT NOT NULL AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Content VARCHAR(1000) NOT NULL,
    Active BOOLEAN NOT NULL DEFAULT TRUE,
    AdminID VARCHAR(20) NOT NULL,
    CreateAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_Notice PRIMARY KEY (NoticeNum)
);

-- 관리자 활동 기록 (요청 본문·비밀번호는 저장하지 않음)
CREATE TABLE AdminLog (
    LogNum INT NOT NULL AUTO_INCREMENT,
    AdminID VARCHAR(20) NOT NULL,
    Action VARCHAR(100) NOT NULL,
    Detail VARCHAR(255) NULL,
    Result INT NOT NULL,
    Ip VARCHAR(45) NULL,
    CreateAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_AdminLog PRIMARY KEY (LogNum)
);

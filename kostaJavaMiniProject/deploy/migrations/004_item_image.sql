-- 물품 사진 (서버에서 JPEG 로 다시 저장한 이미지만 들어감)
-- deploy/tools/Migrate.java 가 이미 적용된 항목은 건너뛰면서 실행합니다. DB 를 지우는 문장은 없습니다.
-- 물품이 삭제되면 사진도 함께 삭제된다 (ON DELETE CASCADE)
CREATE TABLE ItemImage (
    ItemNum INT NOT NULL,
    ContentType VARCHAR(30) NOT NULL,
    Data MEDIUMBLOB NOT NULL,
    Credit VARCHAR(255) NULL,
    UpdateAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT PK_ItemImage PRIMARY KEY (ItemNum),
    CONSTRAINT FK_ItemImage_Item FOREIGN KEY (ItemNum) REFERENCES Item (ItemNum) ON DELETE CASCADE
);

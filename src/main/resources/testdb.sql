use testdb;

DROP TABLE IF EXISTS `Post` CASCADE;

CREATE TABLE `Post`
(
    `post_id`  INT NOT NULL AUTO_INCREMENT COMMENT 'post_id',
    `title`    VARCHAR(255) NOT NULL COMMENT 'title',
    `content`  VARCHAR(255) COMMENT 'content',
    PRIMARY KEY ( `post_id` )
) COMMENT = '게시글';


INSERT INTO Post (post_id, title, content) VALUES
                                             (1, '제목1', '안녕하세요'),
                                             (2, '제목2', '반가워요'),
                                             (3, '제목3', '잘있어요'),
                                             (4, '제목4', '다시만나요'),
                                             (5, '제목5', '아따맘마');
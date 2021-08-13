-- 물건 정보
DROP TABLE useditem cascade constraint;

-- 판매자
DROP TABLE seller cascade constraint;

-- 구매자
DROP TABLE buyer cascade constraint;

-- 중고거래 업로드
DROP TABLE useditem_upload cascade constraint;

DROP SEQUENCE useditem_upload_id_seq;

-- 제품 정보 테이블 
CREATE TABLE useditem (
       useditem_id          VARCHAR2(50) PRIMARY KEY,
       useditem_name      	VARCHAR2(50) NOT NULL,
       useditem_price		VARCHAR2(20) NOT NULL,
       useditem_condition	VARCHAR2(20) NOT NULL,
       useditem_detail		VARCHAR2(200) NOT NULL,
       deal_status			VARCHAR2(20) NOT NULL
);

-- 판매자 테이블
CREATE TABLE seller (
       seller_id          	VARCHAR2(20) PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       phone         		VARCHAR2(20) NOT NULL,
       loc					VARCHAR2(20) NOT NULL,
       sellerGrade			VARCHAR2(20) NOT NULL,
       item         		VARCHAR2(50) NOT NULL,
       dealType				VARCHAR2(20) NOT NULL
);

-- 구매자 테이블
CREATE TABLE buyer (
       buyer_id        		VARCHAR2(20) PRIMARY KEY,
       name                	VARCHAR2(20) NOT NULL,
       phone         		VARCHAR2(20) NOT NULL,
       loc					VARCHAR2(20) NOT NULL,
       buyerGrade			VARCHAR2(20) NOT NULL,
       item         		VARCHAR2(50) NOT NULL,
       dealType				VARCHAR2(20) NOT NULL
);

-- 제품 업로드 테이블
CREATE SEQUENCE useditem_upload_id_seq;
CREATE TABLE useditem_upload (
	   useditem_upload_id     		NUMBER(5) PRIMARY KEY,
	   useditem_upload_name 		VARCHAR2(50) NOT NULL,
       useditem_id           		VARCHAR2(50) NOT NULL,       
       seller_id          			VARCHAR2(20) NOT NULL,
       buyer_id						VARCHAR2(20) NOT NULL
);


ALTER TABLE useditem_upload ADD FOREIGN KEY (useditem_id) REFERENCES useditem (useditem_id);
ALTER TABLE useditem_upload ADD FOREIGN KEY (seller_id) REFERENCES seller (seller_id);
ALTER TABLE useditem_upload ADD FOREIGN KEY (buyer_id) REFERENCES buyer (buyer_id);

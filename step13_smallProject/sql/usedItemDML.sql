-- useditem insert[물건 정보 저장]
insert into useditem values('iPhone', '아이폰XS', '500000', '상', '블랙, 새상품, 산 지 3개월', '판매중');
insert into useditem values('tumbler', '텀블러', '10000', '상', '스타벅스, 초록색, 새상품', '예약중');
insert into useditem values('doll', '인형	', '5000', '중', '미니언, 직구, 6개월 됨', '판매완료');

-- seller insert[판매자 저장]
insert into seller values('seller1', '이건우', '010-111-1111', '서울', '열심', '핸드폰', '직거래');
insert into seller values('seller2', '정치즈', '010-222-2222', '인천', '우수', '텀블러', '택배');
insert into seller values('seller3', '마슈슈', '010-333-3333', '경기', '신입', '인형', '택배');

-- buyer insert[구매자 저장]
insert into buyer values('buyer1', '강아지', '010-444-4444', '서울', '우수', '핸드폰', '택배');
insert into buyer values('buyer2', '고양이', '010-555-5555', '부산', '신입', '텀블러', '택배');
insert into buyer values('buyer3', '고라니', '010-666-6666', '대전', '열심', '인형', '택배');

-- useditem_upload insert[물건 업로드 저장]
insert into useditem_upload values(useditem_upload_id_seq.nextval, '아이폰XS', 'iPhone', 'seller1', 'buyer1');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '텀블러', 'tumbler', 'seller2', 'buyer2');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '인형', 'doll', 'seller3', 'buyer3');

commit;

-- useditem insert[���� ���� ����]
insert into useditem values('iPhone', '������XS', '500000', '��', '��, ����ǰ, �� �� 3����', '�Ǹ���');
insert into useditem values('tumbler', '�Һ�', '10000', '��', '��Ÿ����, �ʷϻ�, ����ǰ', '������');
insert into useditem values('doll', '����	', '5000', '��', '�̴Ͼ�, ����, 6���� ��', '�ǸſϷ�');

-- seller insert[�Ǹ��� ����]
insert into seller values('seller1', '�̰ǿ�', '010-111-1111', '����', '����', '�ڵ���', '���ŷ�');
insert into seller values('seller2', '��ġ��', '010-222-2222', '��õ', '���', '�Һ�', '�ù�');
insert into seller values('seller3', '������', '010-333-3333', '���', '����', '����', '�ù�');

-- buyer insert[������ ����]
insert into buyer values('buyer1', '������', '010-444-4444', '����', '���', '�ڵ���', '�ù�');
insert into buyer values('buyer2', '�����', '010-555-5555', '�λ�', '����', '�Һ�', '�ù�');
insert into buyer values('buyer3', '����', '010-666-6666', '����', '����', '����', '�ù�');

-- useditem_upload insert[���� ���ε� ����]
insert into useditem_upload values(useditem_upload_id_seq.nextval, '������XS', 'iPhone', 'seller1', 'buyer1');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '�Һ�', 'tumbler', 'seller2', 'buyer2');
insert into useditem_upload values(useditem_upload_id_seq.nextval, '����', 'doll', 'seller3', 'buyer3');

commit;

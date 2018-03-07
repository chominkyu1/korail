package com.korail.domain;

public class Criteria {
	private int page;// ���� ������
	private int perPageNum;// �� ȭ�鿡 ������ �ִ� ���ڵ� ��

	public Criteria() {
		page = 1;
		perPageNum = 10;
	}// ������

	public void setPage(int page) {//����� ������ ����
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {//ȭ�鿡 ǥ�õ� ���� ���� ����
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (page-1)* perPageNum; //Mybatis���� ���� ��ŵ�� ���� �� ���ϱ�
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

	public int getPage() {
		return page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}


}

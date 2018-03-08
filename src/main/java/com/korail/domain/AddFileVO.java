package com.korail.domain;

public class AddFileVO {
	private String addFile_Id;
	private String addFile_Path;
	private String tipreview_Id;
	private String discount_Id;
	public String getAddFile_Id() {
		return addFile_Id;
	}
	public void setAddFile_Id(String addFile_Id) {
		this.addFile_Id = addFile_Id;
	}
	public String getAddFile_Path() {
		return addFile_Path;
	}
	public void setAddFile_Path(String addFile_Path) {
		this.addFile_Path = addFile_Path;
	}
	public String getTipreview_Id() {
		return tipreview_Id;
	}
	public void setTipreview_Id(String tipreview_Id) {
		this.tipreview_Id = tipreview_Id;
	}
	public String getDiscount_Id() {
		return discount_Id;
	}
	public void setDiscount_Id(String discount_Id) {
		this.discount_Id = discount_Id;
	}
	@Override
	public String toString() {
		return "AddFileVO [addFile_Id=" + addFile_Id + ", addFile_Path=" + addFile_Path + ", tipreview_Id="
				+ tipreview_Id + ", discount_Id=" + discount_Id + "]";
	}
	
	
}

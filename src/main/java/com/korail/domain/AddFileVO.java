package com.korail.domain;

public class AddFileVO {
	private String addFile_Id;
	private String addFile_Path;
	private String addFile_Name;
	private String addFile_Size;
	private String tipreview_Id;
	private String discount_Id;
	private String addFile_StoredName;
	
	
	
	
	@Override
	public String toString() {
		return "AddFileVO [addFile_Id=" + addFile_Id + ", addFile_Path=" + addFile_Path + ", addFile_Name="
				+ addFile_Name + ", addFile_Size=" + addFile_Size + ", tipreview_Id=" + tipreview_Id + ", discount_Id="
				+ discount_Id + ", addFile_StoredName=" + addFile_StoredName + "]";
	}
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
	public String getAddFile_Name() {
		return addFile_Name;
	}
	public void setAddFile_Name(String addFile_Name) {
		this.addFile_Name = addFile_Name;
	}
	public String getAddFile_Size() {
		return addFile_Size;
	}
	public void setAddFile_Size(String addFile_Size) {
		this.addFile_Size = addFile_Size;
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
	public String getAddFile_StoredName() {
		return addFile_StoredName;
	}
	public void setAddFile_StoredName(String addFile_StoredName) {
		this.addFile_StoredName = addFile_StoredName;
	}
	
	
}

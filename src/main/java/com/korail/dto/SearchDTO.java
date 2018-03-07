package com.korail.dto;

public class SearchDTO {
	private String searchType = "all";
	private String searchText;
	
	public SearchDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public SearchDTO(String searchType, String searchText) {
		super();
		this.searchType = searchType;
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "SearchDTO [searchType=" + searchType + ", searchText=" + searchText + "]";
	}
	
	
}

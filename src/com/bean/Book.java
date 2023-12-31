package com.bean;

public class Book {
	
	private int bid;
	private String bookName,authorName;
	private float price;
	
	//getters and setters
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//ToStringMethod
	@Override
	public String toString() {
		return "Book Details:bid=" + bid + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price;
	}
	
	

}

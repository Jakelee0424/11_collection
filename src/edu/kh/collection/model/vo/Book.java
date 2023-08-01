package edu.kh.collection.model.vo;

public class Book {

	private String title; //제목
	private String author; //저자
	private int price; //가격
	private String publisier; //출판사
	
	public Book() {	}

	public Book(String title, String author, int price, String publicier) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisier = publicier;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisier() {
		return publisier;
	}
	public void setPublisier(String publisier) {
		this.publisier = publisier;
	}

	
	@Override
	public String toString() {
		return "제목= " + title + ", 저자= " + author + ", 가격= " + price + "원" + ", 출판사= " + publisier + "\n";
	}
	
	
	
	
	
}

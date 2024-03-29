package models;

import enums.Binding;
import enums.Language;

public class BookCopy {
	
	protected String identification;
	protected String title;
	
	protected Book book;
	
	protected int numberOfPages;
	protected int printDate;
	
	protected Binding binding;
	protected Language printLanguage;
	
	protected boolean isAvailable;
	protected boolean isDeleted;
	
	
	// Constructors
	
	public BookCopy() {
		this.isAvailable = true;
		this.isDeleted = false;
	}

	public BookCopy(String id, String title, Book book, int numberOfPages, int printDate, Binding binding,
			Language printLanguage, boolean isAvailable, boolean isDeleted) {
		this.identification = id;
		this.title = title;
		this.book = book;
		this.numberOfPages = numberOfPages;
		this.printDate = printDate;
		this.binding = binding;
		this.printLanguage = printLanguage;
		this.isAvailable = isAvailable;
		this.isDeleted = isDeleted;
	}
	
	
	// Getters and setters

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String id) {
		this.identification = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getPrintDate() {
		return printDate;
	}

	public void setPrintDate(int printDate) {
		this.printDate = printDate;
	}

	public Binding getBinding() {
		return binding;
	}

	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	public Language getPrintLanguage() {
		return printLanguage;
	}

	public void setPrintLanguage(Language printLanguage) {
		this.printLanguage = printLanguage;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	// toString
	
	@Override
	public String toString() {
		return "BookCopy [id=" + identification + ", title=" + title + ", book=" + book + ", printLanguage=" + printLanguage + "]\n";
	}
	
	
	
	
	

}

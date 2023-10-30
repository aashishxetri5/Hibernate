/**
 * 
 */
package com.hql.joins;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Author Aashish
 */
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int authorId;

	@Column(name = "author_name")
	private String name;

	@OneToMany(mappedBy = "author")
	private List<Book> allBooks;

	public Author() {
		super();
	}

	public Author(String name, List<Book> allBooks) {
		super();
		this.name = name;
		this.allBooks = allBooks;
	}

	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the allBooks
	 */
	public List<Book> getAllBooks() {
		return allBooks;
	}

	/**
	 * @param allBooks the allBooks to set
	 */
	public void setAllBooks(List<Book> allBooks) {
		this.allBooks = allBooks;
	}

	@Override
	public String toString() {
		return "Author Id:" + authorId + " Author Name: " + name + " Books: " + allBooks;
	}

}

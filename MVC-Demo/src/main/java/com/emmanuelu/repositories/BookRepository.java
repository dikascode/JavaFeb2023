package com.emmanuelu.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuelu.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	 // this method retrieves all the books from the database
    List<Book> findAll();
    
    // this method finds books with language containing the search string
    List<Book> findByLanguageContaining(String search);
    
    
    //Find top 2 order by number of pages
    List<Book> findTop2ByOrderByNumberOfPagesDesc();

}

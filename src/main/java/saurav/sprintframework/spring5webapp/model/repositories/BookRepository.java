package saurav.sprintframework.spring5webapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import saurav.sprintframework.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}

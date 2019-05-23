package saurav.sprintframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import saurav.sprintframework.spring5webapp.model.Author;
import saurav.sprintframework.spring5webapp.model.Book;
import saurav.sprintframework.spring5webapp.model.Publisher;
import saurav.sprintframework.spring5webapp.model.repositories.AuthorRepository;
import saurav.sprintframework.spring5webapp.model.repositories.BookRepository;
import saurav.sprintframework.spring5webapp.model.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}

	private void initData(){
		
		//Saurav
		Author saurav = new Author("Saurav","Rai");
		Publisher publisherSaurav = new Publisher("Made Easy","Bangalore");
		Book sauravBook1 = new Book("DD Designs","1234",publisherSaurav);
		saurav.getBooks().add(sauravBook1);
		sauravBook1.getAuthors().add(saurav);
		
		authorRepository.save(saurav);
		publisherRepository.save(publisherSaurav);
		bookRepository.save(sauravBook1);
		
		//Chandan
		Author chandan = new Author("Chandan","Kumar");
		Publisher publisherChandan = new Publisher("Made Light","Dhanbad");
		Book chandanBook1 = new Book("DD Enjoy","3234",publisherChandan);
		chandan.getBooks().add(chandanBook1);
		
		authorRepository.save(chandan);
		publisherRepository.save(publisherChandan);
		bookRepository.save(chandanBook1);
		
	}

	

}

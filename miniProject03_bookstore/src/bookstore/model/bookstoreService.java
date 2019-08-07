package bookstore.model;

import java.sql.SQLException;
import java.util.ArrayList;

import bookstore.exception.NotExistException;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;

public class bookstoreService {

	private static bookstoreService instance = new bookstoreService();

	private bookstoreService() {
	}

	public static bookstoreService getInstance() {
		return instance;
	}

	// book - CRUD
	public void notExistbook(int bookId) throws NotExistException, SQLException {
		BookDTO book = BookDAO.getBook(bookId);
		if (book == null) {
			throw new NotExistException("�˻��Ͻ� å ������ �����ϴ�.");
		}
	}

	// ��� book ���� ��ȯ
	public ArrayList<BookDTO> getAllbooks() throws SQLException {
		return BookDAO.getAllBooks();
	}

	// book id�� �˻�
	public BookDTO getBook(int bookId) throws SQLException, NotExistException {
		notExistbook(bookId);
		return BookDAO.getBook(bookId);
	}

	// ���ο� book ����
	public boolean addBook(BookDTO book) throws SQLException {
		return BookDAO.addBook(book);
	}
	
//	public boolean addTranslatorName(BookDTO book) throws SQLException {
//		return BookDAO.addTranslatorName(book);
//	}

	// ���� book ����
	public boolean updateBook(int bookName, String PublishMonth) throws SQLException, NotExistException {
		notExistbook(bookName);
		return BookDAO.updateBook(PublishMonth, bookName);
	}

	// book ����
	public boolean deleteBook(int bookId) throws SQLException, NotExistException {
		notExistbook(bookId);
		return BookDAO.deleteBook(bookId);
	}
	
	public boolean authorDeleteBook(int authorId) throws SQLException, NotExistException {
		notExistbook(authorId);
		return BookDAO.authorDeleteBook(authorId);
	}
	
	public boolean publisherDeleteBook(int publisherId) throws SQLException, NotExistException {
		notExistbook(publisherId);
		return BookDAO.publisherDeleteBook(publisherId);
	}
	
	public boolean translatorDeleteBook(int translatorId) throws SQLException, NotExistException {
		notExistbook(translatorId);
		return BookDAO.translatorDeleteBook(translatorId);
	}

	// ****************************************************************************************************

	// Author - CRUD
	public void notExistAuthor(int authorId) throws NotExistException, SQLException {
		AuthorDTO author = AuthorDAO.getAuthor(authorId);
		if (author == null) {
			throw new NotExistException("�˻��Ͻ� �۰��� �� �����մϴ�.");
		}
	}

	public boolean addAuthor(AuthorDTO author) throws SQLException {
		return AuthorDAO.addAuthor(author);
	}
	
	public boolean addAuthor2() throws SQLException {
		return AuthorDAO.addAuthor2();
	}
	
	public boolean addAuthorName(AuthorDTO Author) throws SQLException {
		return AuthorDAO.addAuthorName(Author);
	}

	public boolean updateAuthor(int authorId, String authorName) throws SQLException, NotExistException {
		notExistAuthor(authorId);
		return AuthorDAO.updateAuthor(authorId, authorName);
	}

	public boolean deleteAuthor(int authorId) throws SQLException, NotExistException {
		notExistAuthor(authorId);
		return AuthorDAO.deleteAuthor(authorId);
	}

	public AuthorDTO getAuthor(int authorId) throws SQLException, NotExistException {
		notExistAuthor(authorId);
		return AuthorDAO.getAuthor(authorId);
	}

	public ArrayList<AuthorDTO> getAllAuthors() throws SQLException {
		return AuthorDAO.getAllAuthors();
	}

	// ****************************************************************************************************

	// Translator - CRUD
	public void notExistTranslator(int translatorId) throws NotExistException, SQLException {
		TranslatorDTO Translator = TranslatorDAO.getTranslator(translatorId);
		if (Translator == null) {
			throw new NotExistException("�˻��Ͻ� �������� �� �����մϴ�.");
		}
	}

	public boolean addTranslator(TranslatorDTO translator) throws SQLException {
		return TranslatorDAO.addTranslator(translator);
	}
	
	public boolean addTranslator2() throws SQLException {
		return TranslatorDAO.addTranslator2();
	}
	
	public boolean addTranslatorName(TranslatorDTO translator) throws SQLException {
		return TranslatorDAO.addTranslatorName(translator);
	}

	public boolean updateTranslator(int translatorId, String translatorName) throws SQLException, NotExistException {
		notExistTranslator(translatorId);
		return TranslatorDAO.updateTranslator(translatorId, translatorName);
	}

	public boolean deleteTranslator(int translatorId) throws SQLException, NotExistException {
		notExistTranslator(translatorId);
		return TranslatorDAO.deleteTranslator(translatorId);
	}

	public TranslatorDTO getTranslator(int translatorId) throws SQLException, NotExistException {
		notExistTranslator(translatorId);
		return TranslatorDAO.getTranslator(translatorId);
	}

	public ArrayList<TranslatorDTO> getAllTranslators() throws SQLException {
		return TranslatorDAO.getAllTranslators();
	}

	// ****************************************************************************************************

	public void notExistPublisher(int publisherId) throws NotExistException, SQLException {
		PublisherDTO Publisher = PublisherDAO.getPublisher(publisherId);
		if (Publisher == null) {
			throw new NotExistException("�˻��Ͻ� ���ǻ簡 �� �����մϴ�.");
		}
	}

	public boolean addPublisher(PublisherDTO publisher) throws SQLException {
		return PublisherDAO.addPublisher(publisher);
	}
	
	public boolean addPublisher2() throws SQLException {
		return PublisherDAO.addPublisher2();
	}
	
	public boolean addPublisherName(PublisherDTO Publisher) throws SQLException {
		return PublisherDAO.addPublisherName(Publisher);
	}

	public boolean updatePublisher(int publisherId, String publisherName) throws SQLException, NotExistException {
		notExistPublisher(publisherId);
		return PublisherDAO.updatePublisher(publisherId, publisherName);
	}

	public boolean deletePublisher(int publisherId) throws SQLException, NotExistException {
		notExistPublisher(publisherId);
		return PublisherDAO.deletePublisher(publisherId);
	}

	// ���κ���������Ʈ id�� ���� ���� �˻��ϴ� �޼ҵ�
	public PublisherDTO getPublisher(int publisherId) throws SQLException, NotExistException {
		notExistPublisher(publisherId);
		return PublisherDAO.getPublisher(publisherId);
	}

	public ArrayList<PublisherDTO> getAllPublishers() throws SQLException {
		return PublisherDAO.getAllPublishers();
	}

}

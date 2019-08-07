package bookstore.view;

import bookstore.crawling.bookstoreCrawling;
import bookstore.json.JsonFileRead;
import bookstore.json.JsonFileWrite;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
import bookstore.service.BookstoreController;

public class StartView {

	public static void main(String[] args) {

		BookstoreController controller = BookstoreController.getInstance();
		bookstoreCrawling crawliing = bookstoreCrawling.getInstance();


		// Book���̺� ���� �Է�
		for (BookDTO a : crawliing.getBookList()) {
			System.out.println(a);
		}
		
		// Book�̿� ���̺� ���� �Է�
//		controller.addTranslator2();
//		controller.addAuthor2();
//		controller.addPublisher2();
//		
//		// Book���̺��� ���� ����
//		for (TranslatorDTO a : crawliing.getTransLatorNameList()) {
//			controller.addTranslatorName(a);
//		}
//		for (AuthorDTO a : crawliing.getAuthorList()) {
//			controller.addAuthorName(a);
//		}
//		for (PublisherDTO a : crawliing.getPublisherList()) {
//			controller.addPublisherName(a);
//		}
//
//		// ��� book���̺� ���� ���
//		controller.getAllBook();
//
//		// ��� author���̺� ���� ���
//		controller.getAllAuthor();
//
//		// ��� publisher���̺� ���� ���
//		controller.getAllPublisher();
//
//		// ��� translator���̺� ���� ���
//		controller.getAllTranslator();
		

		// �� ���̺��� ���� ����
//		controller.getBook(3);
//		controller.deleteBook(3);
//		controller.getBook(3);
//
//		controller.getAuthor(4);
//		
//		controller.deleteAuthor(4);
//		System.out.println();
//		controller.getAuthor(4);
//		
//		System.out.println();
//		
//		controller.authorDeleteBook(4);
//		System.out.println();
//		controller.deleteAuthor(4);
//		System.out.println();
//		controller.getAuthor(4);
//		
//		System.out.println();
//		
//		controller.getPublisher(5);
//		
//		System.out.println();
//		
//		controller.deletePublisher(5);
//		System.out.println();
//		controller.getPublisher(5);
//		
//		System.out.println();
//		
//		controller.publisherDeleteBook(5);
//		System.out.println();
//		controller.deletePublisher(5);
//		System.out.println();
//		controller.getPublisher(5);
//		
//		System.out.println();
//		
//		controller.getTranslator(6);
//		
//		System.out.println();
//		
//		controller.deleteTranslator(6);
//		System.out.println();
//		controller.getTranslator(6);
//		
//		System.out.println();
//		
//		controller.translatorDeleteBook(6);
//		System.out.println();
//		controller.deleteTranslator(6);
//		System.out.println();
//		controller.getTranslator(6);
	}

}

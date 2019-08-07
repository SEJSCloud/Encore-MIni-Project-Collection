package bookstore.service;

import java.sql.SQLException;

import bookstore.model.bookstoreService;
import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
import bookstore.view.EndView;
import bookstore.view.FailView;
import bookstore.view.SuccessView;

public class BookstoreController {

	private bookstoreService service = bookstoreService.getInstance();

	private static BookstoreController instance = new BookstoreController();

	public static BookstoreController getInstance() {
		return instance;
	}

	// ��� å �˻� ����
	public void getAllBook() {
		try {
			EndView.bookListView(service.getAllbooks());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� å ����Ʈ �˻��� ���� �߻�");
		}
	}

	// ���� å �˻� ����
	public void getBook(int bookId) {
		try {
			EndView.bookView(service.getBook(bookId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("å �˻��� ���� �߻�");
		}
	}

	// ���ο� å ���� ����
	public void addBook(BookDTO book) {
		try {
			if(service.addBook(book) == true) {
				SuccessView.showSuccess("���ο� å ���� ����");
			}else {
				FailView.showFail("���ο� å ���� ����");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("���ο� å ����� ���� �߻�");
		}
	}
	

	// å ���� ����
	public void updateBook(int bookId, String bookName) {
		try {
			service.updateBook(bookId, bookName);
			SuccessView.showSuccess("å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("å ���� ������ ���� �߻�");
		}
	}

	// å ���� ����
	public void deleteBook(int bookId) {
		try {
			service.deleteBook(bookId);
			SuccessView.showSuccess("å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("å ������ ���� �߻�");
		}
	}
	
	public void authorDeleteBook(int authorId) {
		try {
			service.authorDeleteBook(authorId);
			SuccessView.showSuccess("���� ID�� å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� ID�� å ������ ���� �߻�");
		}
	}
	
	public void publisherDeleteBook(int publisherId) {
		try {
			service.publisherDeleteBook(publisherId);
			SuccessView.showSuccess("���ǻ� ID�� å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� ID�� å ������ ���� �߻�");
		}
	}
	
	public void translatorDeleteBook(int translatorId) {
		try {
			service.translatorDeleteBook(translatorId);
			SuccessView.showSuccess("������ ID�� å ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("������ ID�� å ������ ���� �߻�");
		}
	}
	
//**************************************************************

	// ��� ���� ���� �˻�
	public void getAllAuthor() {
		try {
			EndView.authorListView(service.getAllAuthors());
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("��� ���� �˻��� �����߻� ");
		}
	}

	// ���� ���� �˻�
	public void getAuthor(int authorId) {
		try {
			EndView.authorView(service.getAuthor(authorId));
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("�ش� ���� �˻� ���� ");
		}
	}

	// ���� ���̵�� ���� ���� ����
	public void updateAuthor(int authorId, String authorName) {
		try {
			service.updateAuthor(authorId, authorName);
			SuccessView.showSuccess("���� �̸� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� �̸� ���� ����");
		}
	}

	// ���� ���� ����
	public void addAuthor(AuthorDTO author) {
		try {
			service.addAuthor(author);
			SuccessView.showSuccess("���ο� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� ����� ���� �߻�");
		}
	}
	
	public void addAuthor2() {
		try {
			service.addAuthor2();
			SuccessView.showSuccess("���� �̸� �ߺ����� �� insert ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� �̸� �ߺ����� �� insert�� ���� �߻�");
		}
	}
	
	public void addAuthorName(AuthorDTO Author) {
		try {
			if(service.addAuthorName(Author) == true) {
				SuccessView.showSuccess("���ο� ���� �̸� ���� ����");
			}else {
				FailView.showFail("���ο� ���� �̸� ���� ����");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("���ο� ���� �̸� ����� ���� �߻�");
		}
	}

	// ���� ���� ����
	public void deleteAuthor(int authorId) {
		try {
			service.deleteAuthor(authorId);
			SuccessView.showSuccess("���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���� ������ ���� �߻�");
		}
	}
	
	
//**************************************************************

	// ��� ������ �˻� ����
	public void getAllTranslator() {
		try {
			EndView.translatorListView(service.getAllTranslators());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ��� ������ �˻��� ���� �߻�");
		}
	}

	// ��� ������ �˻� ����
	public void getTranslator(int translatorId) {
		try {
			EndView.translatorView(service.getTranslator(translatorId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("��� ������ �˻��� ���� �߻�");
		}
	}

	// ���ο� ��� ������ ���� ����
	public void addTranslator2() {
		try {
			service.addTranslator2();
			SuccessView.showSuccess("������ �̸� �ߺ����� �� insert ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("������ �̸� �ߺ����� �� insert�� ���� �߻�");
		}
	}
	
	public void addTranslator(TranslatorDTO translator) {
		try {
			service.addTranslator(translator);
			SuccessView.showSuccess("���ο� ������ ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ο� ������ ����� ���� �߻�");
		}
	}
	
	public void addTranslatorName(TranslatorDTO translator) {
		try {
			if(service.addTranslatorName(translator) == true) {
				SuccessView.showSuccess("���ο� �������̸� ���� ����");
			}else {
				FailView.showFail("���ο� �������̸� ���� ����");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("���ο� �������̸� ����� ���� �߻�");
		}
	}

	// ������ ���� ���� ����
	public void updateTranslator(int translatorId, String translatorName) {
		try {
			service.updateTranslator(translatorId, translatorName);
			SuccessView.showSuccess("������ ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("������ ���� ������ ���� �߻�");
		}
	}

	// ������ ���� ���� ����
	public void deleteTranslator(int translatorId) {
		try {
			service.deleteTranslator(translatorId);
			SuccessView.showSuccess("������ ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("������ ���� ������ ���� �߻�");
		}
	}

//**************************************************************	
	
	// ��� ���ǻ� �˻� ����
	public void getAllPublisher() {
		try {
			EndView.publisherListView(service.getAllPublishers());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ���ǻ� �˻��� ���� �߻�");
		}
	}

	// ���ǻ� �˻� ����
	public void getPublisher(int publisherId) {
		try {
			EndView.publisherView(service.getPublisher(publisherId));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� �˻��� ���� �߻�");
		}
	}

	// ���ο� ���ǻ� ���� ����
	public void addPublisher(PublisherDTO publisher) {
		try {
			service.addPublisher(publisher);
			SuccessView.showSuccess("���ο� ���ǻ� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ο� ���ǻ� ���� ����� ���� �߻�");
		}
	}
	
	public void addPublisher2() {
		try {
			service.addPublisher2();
			SuccessView.showSuccess("���ǻ� �̸� �ߺ����� �� insert ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� �̸� �ߺ����� �� insert�� ���� �߻�");
		}
	}
	
	public void addPublisherName(PublisherDTO Publisher) {
		try {
			if(service.addPublisherName(Publisher) == true) {
				SuccessView.showSuccess("���ο� ���ǻ� �̸� ���� ����");
			}else {
				FailView.showFail("���ο� ���ǻ� �̸� ���� ����");
			}
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("���ο� ���ǻ� �̸� ����� ���� �߻�");
		}
	}

	// ���ǻ� ���� ���� ����
	public void updatePublisher(int publisherId, String publisherName) {
		try {
			service.updatePublisher(publisherId, publisherName);
			SuccessView.showSuccess("���ǻ� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� ���� ������ ���� �߻�");
		}
	}

	// ���ǻ� ���� ���� ����
	public void deletePublisher(int publisherId) {
		try {
			service.deletePublisher(publisherId);
			SuccessView.showSuccess("���ǻ� ���� ���� ����");

		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("���ǻ� ���� ������ ���� �߻�");
		}
	}

}

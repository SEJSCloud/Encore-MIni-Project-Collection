package bookstore.crawling;
	
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import bookstore.model.dto.AuthorDTO;
import bookstore.model.dto.BookDTO;
import bookstore.model.dto.PublisherDTO;
import bookstore.model.dto.TranslatorDTO;
	
public class bookstoreCrawling {
	
	private static bookstoreCrawling instance = new bookstoreCrawling();
	
	public static bookstoreCrawling getInstance() {
		return instance;
	}
	
	Document doc = null;
	Elements newsHeadlines = null;
	Elements newsHeadlines1 = null;
	Elements newsHeadlines2 = null;
	Elements newsHeadlines3 = null;
	Elements newsHeadlines4 = null;
	Elements newsHeadlines5 = null;
	BookDTO book = new BookDTO();
	ArrayList<BookDTO> bookList = new ArrayList<BookDTO>();
	ArrayList<TranslatorDTO> translatorNameList = new ArrayList<TranslatorDTO>();
	ArrayList<AuthorDTO> authorList = new ArrayList<AuthorDTO>();
	ArrayList<PublisherDTO> publisherList = new ArrayList<PublisherDTO>();
	ArrayList<TranslatorDTO> translatorList = new ArrayList<TranslatorDTO>();
	
	
	public ArrayList<BookDTO> getBookList() {
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int a = 2;
				int b = 1;
				int c = 3;
				int d = 2;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") || newsHeadlines.text().contains("[<") && ifSecondStringMass.length() > 5) {
					a = a + 1;
					b = b + 1;
					c = c + 1;
					d = d + 1;
				}
				//����
				newsHeadlines1 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ b + ") > a > b");
				
				//�Ⱓ��
				newsHeadlines2 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ a + ")");

				// ����
				newsHeadlines3 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ c + ") > span:nth-child(1)");
				
				// ���η�
				newsHeadlines4 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ c + ") > span:nth-child(3)");
				
				
				// ����, ������, ���ǻ��
				newsHeadlines5 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ d + ")");
				

				String stringTitle = newsHeadlines1.text();

				String stringMass = newsHeadlines2.text();
				int idx1 = stringMass.indexOf("|");
				String secondStringMass = stringMass.substring(idx1 + 1);
				int idx2 = secondStringMass.indexOf("|");
				String thirdStringMass = secondStringMass.substring(idx2 + 2);

				String stringPrice = newsHeadlines3.text();

				String stringDiscountF = newsHeadlines4.text();

				if (!newsHeadlines4.text().contains("%")) {
					stringDiscountF = "0%";
				}
				String stringDiscount = stringDiscountF.replace("%", "");
				int intDiscount = Integer.parseInt(stringDiscount);
				
				String stringMass12 = newsHeadlines5.text();
				String translatorName = null;
				if(stringMass12.contains("(��")) {
					int idx = stringMass12.indexOf("(��");
					if(stringMass12.contains("������)")) {
						int idx6 = stringMass12.indexOf("������)");
						translatorName = stringMass12.substring(idx6+6, idx-1);
						if(stringMass12.contains("������)")) {
							int idx7 = stringMass12.indexOf("������)");
							translatorName = stringMass12.substring(idx7+6, idx-1);
							if(stringMass12.contains("�׸�)")) {
								int idx8 = stringMass12.indexOf("�׸�)");
								translatorName = stringMass12.substring(idx8+5, idx-1);
							}
						}
						if(stringMass12.contains("�׸�)")) {
							int idx9 = stringMass12.indexOf("�׸�)");
							translatorName = stringMass12.substring(idx9+5, idx-1);
						}
					}
				}else if(!stringMass12.contains("(��")){
					translatorName = null;
				}
				
				String stringMass123 = newsHeadlines5.text();
				int idx1123 = stringMass123.indexOf("|");
				String secondeStringMass = stringMass123.substring(0,idx1123+1);
				String stringAuthorName = "";
				String[] array = stringMass123.split("\\(");

				if (stringMass123.contains("(��")) {
					stringAuthorName = newsHeadlines5.text().substring(0, newsHeadlines5.text().indexOf(" ("));
				} else if (!stringMass123.contains("(��")) {
					stringAuthorName = array[0];
				} else if (!secondeStringMass.contains("(")) {
					for (int q = 0; q < idx1 - 1; q++) {
						stringAuthorName += array[q];
					}
					
				}
				
				String stringMass1234 = newsHeadlines5.text();
				int idx11234 = stringMass1234.indexOf(") |");
				String secondStringMass123 = stringMass1234.substring(idx11234 + 4);
				int idx21234 = secondStringMass123.indexOf("| 2");
				String[] array12 = secondStringMass123.split("|");
				String publisherName = "";

				for (int q = 0; q < idx21234-1; q++) {
					publisherName += array12[q];
				}
				
				BookDTO book = new BookDTO(0, stringTitle, thirdStringMass, stringPrice + "��", intDiscount, stringAuthorName , translatorName, publisherName);
				bookList.add(book);

			}
		}
		return bookList;
	}
	
	public ArrayList<TranslatorDTO> getTransLatorNameList(){
		Document doc = null;
		Elements newsHeadlines = null;
		Elements newsHeadlines5 = null;
		
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int d = 2;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					d = d + 1;
				}
				newsHeadlines5 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ d + ")");
				
				String stringMass12 = newsHeadlines5.text();
				String translatorName = null;
				if(stringMass12.contains("(��")) {
					int idx = stringMass12.indexOf("(��");
					if(stringMass12.contains("������)")) {
						int idx1 = stringMass12.indexOf("������)");
						translatorName = stringMass12.substring(idx1+6, idx-1);
						if(stringMass12.contains("������)")) {
							int idx2 = stringMass12.indexOf("������)");
							translatorName = stringMass12.substring(idx2+6, idx-1);
							if(stringMass12.contains("�׸�)")) {
								int idx3 = stringMass12.indexOf("�׸�)");
								translatorName = stringMass12.substring(idx3+5, idx-1);
							}
						}
						if(stringMass12.contains("�׸�)")) {
							int idx4 = stringMass12.indexOf("�׸�)");
							translatorName = stringMass12.substring(idx4+5, idx-1);
						}
					}
				}else if(!stringMass12.contains("(��")){
					translatorName = null;
				}
				
				TranslatorDTO translator = new TranslatorDTO(0,translatorName);
				translatorNameList.add(translator);
			}
		}
		return translatorNameList;
		
	}
		
	
	
	public ArrayList<AuthorDTO> getAuthorList(){
		
		Document doc = null;
		Elements newsHeadlines = null;
		Elements newsHeadlines5 = null;
		
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int d = 2;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					d = d + 1;
				}
				newsHeadlines5 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ d + ")");

				String stringMass = newsHeadlines5.text();
				int idx1 = stringMass.indexOf("|");
				String secondeStringMass = stringMass.substring(0,idx1+1);
				String stringAuthorName = "";
				String[] array = stringMass.split("\\(");

				if (stringMass.contains("(��")) {
					stringAuthorName = newsHeadlines5.text().substring(0, newsHeadlines5.text().indexOf(" ("));
				} else if (!stringMass.contains("(��")) {
					stringAuthorName = array[0];
				} else if (!secondeStringMass.contains("(")) {
					for (int q = 0; q < idx1 - 1; q++) {
						stringAuthorName += array[q];
					}
					
				}
				
				AuthorDTO author = new AuthorDTO(0, stringAuthorName);
				authorList.add(author);
				
			}
			
		}
		return authorList;
		
	}
	
	public ArrayList<PublisherDTO> getPublisherList(){
		Document doc = null;
		Elements newsHeadlines = null;
		Elements newsHeadlines6 = null;
		

		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int d = 2;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					d = d + 1;
				}

				newsHeadlines6 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ d + ")");

				String stringMass = newsHeadlines6.text();
				int idx1 = stringMass.indexOf(") |");
				String secondStringMass = stringMass.substring(idx1 + 4);
				int idx2 = secondStringMass.indexOf("| 2");
				String[] array = secondStringMass.split("|");
				String array1 = "";

				for (int q = 0; q < idx2-1; q++) {
					array1 += array[q];
				}
				
				PublisherDTO publisher = new PublisherDTO(0, array1);
				publisherList.add(publisher);
				
			}

		}
		return publisherList;
	}
	
	public ArrayList<TranslatorDTO> getTranslatorList(){
		Document doc = null;
		Elements newsHeadlines = null;
		Elements newsHeadlines5 = null;
		
		for (int i = 1; i <= 10; i++) {
			try {
				doc = Jsoup.connect(
						"https://www.aladin.co.kr/shop/common/wnew.aspx?ViewRowsCount=25&ViewType=Detail&SortOrder=6&page="
								+ i + "&BranchType=1&PublishDay=84")
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int j = 2; j <= 26; j++) {
				int d = 2;

				newsHeadlines = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1)");
				String ifStringMass = newsHeadlines.text();
				String ifSecondStringMass = ifStringMass.substring(0, ifStringMass.indexOf("]") + 1);
				if (newsHeadlines.text().contains("[") && ifSecondStringMass.length() > 5) {
					d = d + 1;
				}
				newsHeadlines5 = doc.select("#Myform > div:nth-child(" + j
						+ ") > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > ul > li:nth-child("
						+ d + ")");
				
				String stringMass12 = newsHeadlines5.text();
				String translatorName = null;
				if(stringMass12.contains("(��")) {
					int idx = stringMass12.indexOf("(��");
					if(stringMass12.contains("������)")) {
						int idx1 = stringMass12.indexOf("������)");
						translatorName = stringMass12.substring(idx1+6, idx);
						if(stringMass12.contains("������)")) {
							int idx2 = stringMass12.indexOf("������)");
							translatorName = stringMass12.substring(idx2+6, idx);
							if(stringMass12.contains("�׸�)")) {
								int idx3 = stringMass12.indexOf("�׸�)");
								translatorName = stringMass12.substring(idx3+5, idx);
							}
						}
						if(stringMass12.contains("�׸�)")) {
							int idx4 = stringMass12.indexOf("�׸�)");
							translatorName = stringMass12.substring(idx4+5, idx);
						}
					}
				}else if(!stringMass12.contains("(��")){
					translatorName = null;
				}
				
				TranslatorDTO translator = new TranslatorDTO(0, translatorName);
				translatorList.add(translator);
			}
		}
		return translatorList;
	}
		

}

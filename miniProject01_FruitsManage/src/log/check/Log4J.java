package log.check;

public class Log4J {
	
	private static Log4J instance = new Log4J();
	private Log4J(){}
	
	public static Log4J getInstance() {
		return instance;
	}
	
	public static String now() {
		return "---현재 재고 정보입니다---";
	}
	
	public static String upDateInven() {
		return "---새로운 물량이 입고되었습니다---";
	}
	
	public static String upDate() {
		return "---새로운 품목이 입고되었습니다---";
	}
	
	public static String disappear() {
		return "---품목이 소진되었습니다---";
	}
}
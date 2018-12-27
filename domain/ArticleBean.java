package domain;

public class ArticleBean {
	private int seq;
	private String title, content, writer , redDate;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRedDate() {
		return redDate;
	}
	public void setRedDate(String redDate) {
		this.redDate = redDate;
	}
	@Override
	public String toString() {
		return String.format("[게시글]\n"
				+ "글번호 %s\n"
				+ "글제목 %s\n"
				+ "글내용 %s\n"
				+ "작성자 %s\n"
				+ "작성날짜 %s", seq,title,content,writer,redDate);
	}
	
	
}

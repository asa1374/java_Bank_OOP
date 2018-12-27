package service;
import java.util.ArrayList;
import domain.ArticleBean;
public interface ArticleService {
	// Create
	public void createAticle(String title, String content, String writer);
	// read
	public ArrayList<ArticleBean> list();
	public ArrayList<ArticleBean> findWriter(String writer);		//writer 별로
	public ArticleBean findTitle(String title);
	public int countSeq();
	public String redDate();
	// update
	public void updateContent(String title,String content);
	// delete
	public void deleteSeq(String seq);	
}

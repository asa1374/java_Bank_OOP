package service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import domain.ArticleBean;
public class ArticleServiceImpl implements ArticleService{
		private HashMap<String,ArticleBean> map;
		private int seq;
		public ArticleServiceImpl() {
			map = new HashMap<>();
			seq = 0;
		}
	@Override
	public void createAticle(String title, String content, String writer) {
		ArticleBean article = new ArticleBean();
		article.setSeq(article.getSeq());
		article.setContent(content);
		article.setTitle(title);
		article.setWriter(writer);
		article.setRedDate(redDate());
		map.put(String.valueOf(seq), article);
		seq++;
	}
	@Override
	public String redDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}


	@Override
	public ArrayList<ArticleBean> list() {
		ArrayList<ArticleBean> arrays = new ArrayList<>();
		arrays.addAll(map.values());
		return arrays;
	}

	@Override
	public ArrayList<ArticleBean> findWriter(String writer) {
		ArrayList<ArticleBean> array = new ArrayList<>();
		Set<String> set = map.keySet();
		for(String key : set) {
			if(writer.equals(map.get(key).getWriter())) {
				array.add(map.get(key));
			}
		}
		return array;
	}

	@Override
	public ArticleBean findTitle(String title) {
		return map.get(title);
	}

	@Override
	public int countSeq() {
		return map.size();
	}

	@Override
	public void updateContent(String title,String content) {
		if(map.containsKey(title)) {
			map.get(title).setContent(content);
		}
	}

	@Override
	public void deleteSeq(String seq) {
		if(map.containsKey(seq)) {
			map.remove(seq);
		}
		
	}

}

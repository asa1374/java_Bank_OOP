package controller;

import javax.swing.JOptionPane;

import service.ArticleService;
import service.ArticleServiceImpl;

public class ArticleController {
	public void start() {
		ArticleService articleService = new ArticleServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n1.게시글작성\n2.모든게시글\n3.작성자별검색\n4.제목별검색\n5.게시글수\n"
					+ "6.내용수정\n7.글 삭제")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "종료한다.");
				return;
			case "1" :
				articleService.createAticle(JOptionPane.showInputDialog("제목을 입력하세요"),
						JOptionPane.showInputDialog("내용을 입력하세요"), 
						JOptionPane.showInputDialog("작성자 입력"));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, articleService.list());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null,articleService.findWriter(JOptionPane.showInputDialog("작성자를 입력하세요")));
				break;
			case "4" :
				JOptionPane.showMessageDialog(null,articleService.findTitle(JOptionPane.showInputDialog("제목을 입력")));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, articleService.countSeq());
				break;
			case "6" :
				articleService.updateContent(JOptionPane.showInputDialog("제목입력"),
						JOptionPane.showInputDialog("수정할 내용"));
				break;
			case "7 " :
				articleService.deleteSeq(JOptionPane.showInputDialog("글번호 입력"));
				break;
			}
		}
	}
}

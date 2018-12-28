package index;
import javax.swing.JOptionPane;

import controller.*;
public class Index {
	public static void main(String[] args) {
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n1.회원관리\n2.계좌관리\n3.게시판\n4.관리자")) {
			case "0" :return;
			case "1" : 
				new MemberController().start();
				break;
			case "2" : 
				
				break;
			case "3" : 
				new AdminController().start();
				break;
			case "4" : 
				new ArticleController().start();
				break;
			}
		}
	}
}

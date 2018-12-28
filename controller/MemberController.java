package controller;
import javax.swing.JOptionPane;
import service.*;
public class MemberController {
	public void start() {
		MemberService memberService = new MemberServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료버튼\n1.회원가입\n2.회원목록\n3.이름검색\n4.ID검색\n5.회원수\n"
					+ "6.로그인\n7.비밀번호변경\n8.회원탈퇴\n")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "종료됩니다.");
				return;
			case "1" :
				memberService.newMember(JOptionPane.showInputDialog("ID : "),
						JOptionPane.showInputDialog("PASS : "), 
						JOptionPane.showInputDialog("NAME : "), 
						JOptionPane.showInputDialog("SSN : "));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, memberService.findAll());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null,memberService.findByName(JOptionPane.showInputDialog("이름을 검색하시오")));
				break;
			case "4" :
				JOptionPane.showMessageDialog(null,memberService.findById(JOptionPane.showInputDialog("ID검색해주세요")));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null,memberService.count()+"명");
				break;
			case "6" :
				if(memberService.existMember(JOptionPane.showInputDialog("로그인 하실 ID"), JOptionPane.showInputDialog("PASS"))) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				break;
			case "7" :
				memberService.passUpdate(JOptionPane.showInputDialog("ID "), 
						JOptionPane.showInputDialog("PASS "), 
						JOptionPane.showInputDialog("NEW PASS "));
				break;
			case "8" :
				memberService.memberDelete(JOptionPane.showInputDialog("ID "), 
						JOptionPane.showInputDialog("PASS "));
				break;
			}
		}
	}
}

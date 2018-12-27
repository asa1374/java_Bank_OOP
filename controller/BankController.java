package controller;
import javax.swing.JOptionPane;
import domain.MemberBean;
import service.*;
public class BankController {
	public  void start() {
		MemberService memberService = new MemberServiceImpl();
		AccountService accountService = new AccountServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료버튼\n1.회원가입\n2.회원목록\n3.이름검색\n4.ID검색\n5.회원수\n"
					+ "6.로그인\n7.비밀번호변경\n8.회원탈퇴\n"
					+ "9.계좌생성\n10.계좌목록\n11.계좌검색\n"
					+ "12.계좌수\n13.입금하기\n14.출금하기\n15.계좌삭제")) {
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
			case "9" :
				accountService.createAccount(Integer.parseInt(JOptionPane.showInputDialog("첫가입 금액")));
				break;
			case "10" :
				JOptionPane.showMessageDialog(null,accountService.findAll());
				break;
			case "11" :
				JOptionPane.showMessageDialog(null,accountService.findByAccountNum(JOptionPane.showInputDialog("검색하실 계좌번호")));
				break;
			case "12" :
				JOptionPane.showMessageDialog(null, accountService.countAccount()+"개");
				break;
			case "13" :
				accountService.depositMoney(JOptionPane.showInputDialog("입금 계좌번호 "),
						Integer.parseInt(JOptionPane.showInputDialog("입금하실 금액")));
				break;
			case "14" :
				accountService.withdrawMoney(JOptionPane.showInputDialog("출금 계좌번호 "),
						Integer.parseInt(JOptionPane.showInputDialog("출금하실 금액")));
				break;
			case "15" :
				accountService.deleteAccountNum(JOptionPane.showInputDialog("삭제하실 계좌입력"));
				break;
			}
		}
	}
}

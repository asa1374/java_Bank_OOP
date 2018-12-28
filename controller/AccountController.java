package controller;

import javax.swing.JOptionPane;
import service.*;

public class AccountController {
	public void start() {
		AccountService accountService = new AccountServiceImpl();
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료버튼\n1.계좌생성\n2.계좌목록\n3.계좌검색\n" + "4.계좌수\n5.입금하기\n6.출금하기\n7.계좌삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료됩니다.");
				return;
			case "1":
				accountService.createAccount(Integer.parseInt(JOptionPane.showInputDialog("첫가입 금액")));
				break;
			case "2":
				JOptionPane.showMessageDialog(null, accountService.findAll());
				break;
			case "3":
				JOptionPane.showMessageDialog(null,
						accountService.findByAccountNum(JOptionPane.showInputDialog("검색하실 계좌번호")));
				break;
			case "4":
				JOptionPane.showMessageDialog(null, accountService.countAccount() + "개");
				break;
			case "5":
				accountService.depositMoney(JOptionPane.showInputDialog("입금 계좌번호 "),
						Integer.parseInt(JOptionPane.showInputDialog("입금하실 금액")));
				break;
			case "6":
				accountService.withdrawMoney(JOptionPane.showInputDialog("출금 계좌번호 "),
						Integer.parseInt(JOptionPane.showInputDialog("출금하실 금액")));
				break;
			case "7":
				accountService.deleteAccountNum(JOptionPane.showInputDialog("삭제하실 계좌입력"));
				break;
			}
		}
	}
}

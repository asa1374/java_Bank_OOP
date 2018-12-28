package controller;

import javax.swing.JOptionPane;
import service.AdminService;
import service.AdminServiceImpl;

public class AdminController {
	public void start() {
		AdminService adminService = new AdminServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n1.관리자등록\n2.관리자목록\n3.지급별목록\n4.관리자번호찾기\n"
					+ "5.관리자수\n6.관리자로그인\n"
					+ "7.비번변경\n8.직급변경\n9.퇴사")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "종료합니다.");
				return;
			case "1" :
				adminService.createAdmin(JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("비번"),
						JOptionPane.showInputDialog("직급"));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, adminService.list());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null,adminService.findByAuth(JOptionPane.showInputDialog("직급입력")));
				break;
			case "4" :
				JOptionPane.showMessageDialog(null,adminService.findById(JOptionPane.showInputDialog("사원 번호 입력")));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null,adminService.countAdmin()+"명");
				break;
			case "6" :
				JOptionPane.showMessageDialog(null,adminService.existAdmin(JOptionPane.showInputDialog("사원번호 입력"),
						JOptionPane.showInputDialog("비번입력")));
				break;
			case "7" :
				adminService.updatePass(JOptionPane.showInputDialog("사원번호입력"),
						JOptionPane.showInputDialog("비밀번호입력"),
						 JOptionPane.showInputDialog("바꾸실 비밀번호"));
				break;
			case "8" :
				adminService.updateAuth(JOptionPane.showInputDialog("사원번호입력"),
						JOptionPane.showInputDialog("직급입력"));
				break;
			case "9" :
				adminService.deleteAdmin(JOptionPane.showInputDialog("퇴사시킬 사원번호"), 
										JOptionPane.showInputDialog("비번도 입력"));
				break;
			}
		}
	}
}

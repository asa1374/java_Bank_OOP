package service;
import java.util.ArrayList;

/**
 * @author Lee Chang Jun
 * @date 2018. 12. 26.
 * @desc 은행 계좌 서비스
 */
import domain.AccountBean;
public interface AccountService {
	//create
	public void createAccount(int money);
	public String createAccountNum();    //계좌번호 생성
	//read
	public ArrayList<AccountBean> findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccount();
	public String findDate();			//날짜 가져오기
	//update
	public void depositMoney(String accountNum, int money);
	public void withdrawMoney(String accountNum,int money);
	//delete
	public void deleteAccountNum(String accountNum);
	
	
}

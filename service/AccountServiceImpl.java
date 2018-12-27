package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import domain.AccountBean;

/**
 * @author Lee Chang Jun
 * @date 2018. 12. 26.
 * @desc 은행계좌 구현
 */
public class AccountServiceImpl implements AccountService {
	private ArrayList<AccountBean> list;

	public AccountServiceImpl() {
		list = new ArrayList<>();
	}

	/**********************
	 * CREATE
	 ********************/

	@Override
	public void createAccount(int money) {
		AccountBean account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setMoney(money);
		account.setToday(findDate());
		list.add(account);

	}

	@Override
	public String createAccountNum() {
		Random random = new Random();
		String res = random.nextInt(50) + "";
		return res;
	}

	/**********************
	 * READ
	 ********************/
	@Override
	public ArrayList<AccountBean> findAll() {
		return list;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				account = list.get(i);
				break;
			}
		}
		return account;
	}

	@Override
	public int countAccount() {
		return list.size();
	}

	@Override
	public String findDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**********************
	 * UPDATE
	 ********************/
	@Override
	public void depositMoney(String accountNum, int money) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney() + money);
				break;
			}
		}
	}

	@Override
	public void withdrawMoney(String accountNum, int money) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney() - money);
				break;
			}
		}
	}

	/**********************
	 * DELETE
	 ********************/
	@Override
	public void deleteAccountNum(String accountNum) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				list.remove(i);
				break;
			}
		}
	}
}

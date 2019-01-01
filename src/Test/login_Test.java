package Test;

import Action.UserAction;
import DAO.DAOException;

public class login_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		
		// 登录测试
		int id;
		System.out.println("测试用户登录：");
		System.out.println("当密码错误时：");
		id = ua.login(5,"001");
		System.out.println("当密码正确时：");
		id = ua.login(7, "003");
	}
	
}

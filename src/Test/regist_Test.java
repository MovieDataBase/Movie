package Test;

import Action.UserAction;
import Bean.User;
import DAO.DAOException;

public class regist_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		// 注册测试
		System.out.println("测试用户注册：");		
		System.out.println("当用户名重复时：");
		User u = new User();
		u.setUsername("test");
		u.setPassword("123");
		u.setEmail("214124@222.com");
		ua.register(u);
		System.out.println("当用户名不重复时：");
		u.setUsername("hh");
		ua.register(u);
	}
}

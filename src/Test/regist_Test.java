package Test;

import Action.UserAction;
import Bean.User;
import DAO.DAOException;

public class regist_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		// ע�����
		System.out.println("�����û�ע�᣺");		
		System.out.println("���û����ظ�ʱ��");
		User u = new User();
		u.setUsername("test");
		u.setPassword("123");
		u.setEmail("214124@222.com");
		ua.register(u);
		System.out.println("���û������ظ�ʱ��");
		u.setUsername("hh");
		ua.register(u);
	}
}

package Test;

import Action.UserAction;
import DAO.DAOException;

public class login_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		
		// ��¼����
		int id;
		System.out.println("�����û���¼��");
		System.out.println("���������ʱ��");
		id = ua.login(5,"001");
		System.out.println("��������ȷʱ��");
		id = ua.login(7, "003");
	}
	
}

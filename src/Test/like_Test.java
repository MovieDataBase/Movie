package Test;

import Action.UserAction;
import DAO.DAOException;

public class like_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		// ��¼����
		int id;
		System.out.println("�û���¼��");
		id = ua.login(7, "003");
		//���Ե���
		System.out.println("���Ե��ޣ�");
		System.out.println("�������ۣ�");
		ua.like_comment(id, 3);
		System.out.println("�����ѵ��޹������ۣ�");
		ua.like_comment(id, 3);
	}
}

package Action;

import DAO.DAOException;
import Bean.*;

public class Tester {
	public static void main(String[] args) throws DAOException {
		
		UserAction ua = new UserAction();
		MovieAction ma = new MovieAction();
		
		// ע�����
		System.out.println("�����û�ע�᣺");		
		System.out.println("���û����ظ�ʱ��");
		User u = new User();
		u.setUsername("test");
		u.setPassword("123");
		u.setEmail("214124@222.com");
		ua.register(u);
		System.out.println("���û������ظ�ʱ��");
		u.setUsername("hhhhh");
		ua.register(u);

		// ��¼����
		int id;
		System.out.println("�����û���¼��");
		System.out.println("���������ʱ��");
		id = ua.login(3, "002");
		System.out.println("��������ȷʱ��");
		id = ua.login(3, "003");
		
		// ���Ե���
		System.out.println("���Ե��ޣ�");
		System.out.println("�������ۣ�");
		ua.like_comment(id, 2);
		System.out.println("�����ѵ��޹������ۣ�");
		ua.like_comment(id, 2);
		
		// �������
		System.out.println("���������");
		ua.Browse(3, 8);
		ua.Browse(3, 10);
		System.out.println("����û������¼��");
		ua.BrowseList(3);
		
		// ��������
		System.out.println("�������ۣ�");
		System.out.println("�鿴���ۣ�");
		ma.comment_show(3);
		System.out.println("������ۣ�");
		System.out.println("����������۹��ĵ�Ӱ�������ۣ�");
		ma.comment(3, 3, "NB!!!!!!!!!!", 5);
		System.out.println("�����δ���۹��ĵ�Ӱ�������ۣ�");
		ma.comment(4, 3, "���Ը�5�ǣ���û��Ҫ", 4);
		System.out.println("ɾ�����ۣ�");
		System.out.println("ɾ�����˵����ۣ�");
		ma.comment_delete(1, 4);
		System.out.println("ɾ���Լ������ۣ�");
		ma.comment_delete(1, 1);
		System.out.println("�޸����ۣ�");
		System.out.println("�޸ı��˵����ۣ�");
		ma.comment_update(1, 5, "������������������������", 5);
		System.out.println("�޸��Լ������ۣ�");
		ma.comment_update(1, 8, "��β", 2);
		System.out.println("�������۰���������");
		ma.comment_sort(3);
	}
}

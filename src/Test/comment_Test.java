package Test;

import Action.MovieAction;
import DAO.DAOException;

public class comment_Test {
	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		
		// ��������
		System.out.println("�������ۣ�");
		System.out.println("�鿴���ۣ�");
		ma.comment_show(3);
		System.out.println("������ۣ�");
		System.out.println("����������۹��ĵ�Ӱ�������ۣ�");
		ma.comment(5, 3, "NB!!!!!!!!!!", 5);
		System.out.println("�����δ���۹��ĵ�Ӱ�������ۣ�");
		ma.comment(6, 4, "���Ը�5�ǣ���û��Ҫ", 4);
		System.out.println("ɾ�����ۣ�");
		System.out.println("ɾ�����˵����ۣ�");
		ma.comment_delete(5, 9);
		System.out.println("ɾ���Լ������ۣ�");
		ma.comment_delete(5, 8);
		System.out.println("�޸����ۣ�");
		System.out.println("�޸ı��˵����ۣ�");
		ma.comment_update(5, 10, "������������������������", 5);
		System.out.println("�޸��Լ������ۣ�");
		ma.comment_update(5, 13, "��β��", 2);
		System.out.println("�������۰���������");
		ma.comment_sort(3);

	}
}

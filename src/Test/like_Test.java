package Test;

import Action.UserAction;
import DAO.DAOException;

public class like_Test {
	public static void main(String []args) throws DAOException
	{
		UserAction ua = new UserAction();
		// 登录测试
		int id;
		System.out.println("用户登录：");
		id = ua.login(7, "003");
		//测试点赞
		System.out.println("测试点赞：");
		System.out.println("点赞评论：");
		ua.like_comment(id, 3);
		System.out.println("点赞已点赞过的评论：");
		ua.like_comment(id, 3);
	}
}

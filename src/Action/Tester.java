package Action;

import DAO.DAOException;
import Bean.*;

public class Tester {
	public static void main(String[] args) throws DAOException {
		
		UserAction ua = new UserAction();
		MovieAction ma = new MovieAction();
		
		// 注册测试
		System.out.println("测试用户注册：");		
		System.out.println("当用户名重复时：");
		User u = new User();
		u.setUsername("test");
		u.setPassword("123");
		u.setEmail("214124@222.com");
		ua.register(u);
		System.out.println("当用户名不重复时：");
		u.setUsername("hhhhh");
		ua.register(u);

		// 登录测试
		int id;
		System.out.println("测试用户登录：");
		System.out.println("当密码错误时：");
		id = ua.login(3, "002");
		System.out.println("当密码正确时：");
		id = ua.login(3, "003");
		
		// 测试点赞
		System.out.println("测试点赞：");
		System.out.println("点赞评论：");
		ua.like_comment(id, 2);
		System.out.println("点赞已点赞过的评论：");
		ua.like_comment(id, 2);
		
		// 测试浏览
		System.out.println("测试浏览：");
		ua.Browse(3, 8);
		ua.Browse(3, 10);
		System.out.println("输出用户浏览记录：");
		ua.BrowseList(3);
		
		// 测试评论
		System.out.println("测试评论：");
		System.out.println("查看评论：");
		ma.comment_show(3);
		System.out.println("添加评论：");
		System.out.println("如果对已评论过的电影进行评论：");
		ma.comment(3, 3, "NB!!!!!!!!!!", 5);
		System.out.println("如果对未评论过的电影进行评论：");
		ma.comment(4, 3, "可以给5星，但没必要", 4);
		System.out.println("删除评论：");
		System.out.println("删除别人的评论：");
		ma.comment_delete(1, 4);
		System.out.println("删除自己的评论：");
		ma.comment_delete(1, 1);
		System.out.println("修改评论：");
		System.out.println("修改别人的评论：");
		ma.comment_update(1, 5, "啊啊啊啊啊啊啊啊啊啊啊啊", 5);
		System.out.println("修改自己的评论：");
		ma.comment_update(1, 8, "烂尾", 2);
		System.out.println("测试评论按点赞排序");
		ma.comment_sort(3);
	}
}

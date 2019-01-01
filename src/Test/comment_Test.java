package Test;

import Action.MovieAction;
import DAO.DAOException;

public class comment_Test {
	public static void main(String []args) throws DAOException
	{
		MovieAction ma = new MovieAction();
		
		// 测试评论
		System.out.println("测试评论：");
		System.out.println("查看评论：");
		ma.comment_show(3);
		System.out.println("添加评论：");
		System.out.println("如果对已评论过的电影进行评论：");
		ma.comment(5, 3, "NB!!!!!!!!!!", 5);
		System.out.println("如果对未评论过的电影进行评论：");
		ma.comment(6, 4, "可以给5星，但没必要", 4);
		System.out.println("删除评论：");
		System.out.println("删除别人的评论：");
		ma.comment_delete(5, 9);
		System.out.println("删除自己的评论：");
		ma.comment_delete(5, 8);
		System.out.println("修改评论：");
		System.out.println("修改别人的评论：");
		ma.comment_update(5, 10, "啊啊啊啊啊啊啊啊啊啊啊啊", 5);
		System.out.println("修改自己的评论：");
		ma.comment_update(5, 13, "烂尾了", 2);
		System.out.println("测试评论按点赞排序");
		ma.comment_sort(3);

	}
}

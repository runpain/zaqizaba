package cn.zucc.service;

import cn.zucc.dao.CommentDao;
import cn.zucc.entity.Comment;

public class CommentSev {

	
	CommentDao commentDao = new CommentDao();
	
	public void addcomment(Comment comment){
		commentDao.addComment(comment);
	}

	
}

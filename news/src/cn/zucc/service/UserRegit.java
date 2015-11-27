package cn.zucc.service;

import cn.zucc.dao.UserDao;
import cn.zucc.entity.User;

public class UserRegit {
		UserDao userDao = new UserDao();
		//×¢²á
		public boolean regist(User user){
		if(userDao.FindByName(user.getName())!=null) {
			return false;
		}
		userDao.AddUser(user);
		return true;
	}
		//µÇÂ½
		public boolean login(User user){
			User user2 = userDao.FindByName(user.getName());
			if (user2!=null && user2.getPassword().equals(user.getPassword())) {
				return true;				
			}
			return false;		
		}
		

}

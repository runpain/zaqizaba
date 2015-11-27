package cn.zucc.test;

import java.util.List;

import org.junit.Test;

import cn.zucc.dao.UserDao;
import cn.zucc.entity.User;

public class UserDaoTest {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("ç÷ç÷");
		user.setPassword("passwordisnull");
		user.setSex(0);
		user.setHobby("»æ»­");
		UserDao uDao = new UserDao();
		uDao.AddUser(user);
	}*/
	UserDao userDao = new UserDao();
	User user = new User();
	@Test
	public void testadd(){
		User user = new User();
		user.setName("°´´í");
		user.setPassword("sfsf");
		user.setSex(0);
		user.setHobby("³éÏó»­");
		UserDao uDao = new UserDao();
		uDao.AddUser(user);
	}
	
	@Test
	public void testdelet(){
		userDao.DeleteById(1);
	}
	@Test
	public void testfind(){
	    user = userDao.FindById(3);
		System.out.println(user);
	}
	@Test
	public void testupdate(){
		user = userDao.FindById(4);
		user.setPassword("22rrez");
		userDao.UpdateUser(user);
	}
	@Test
	public void testall(){
		List<User> list=userDao.FindAll();
		for(User user:list){
			System.out.println(user);
		}
	
	}
	
}

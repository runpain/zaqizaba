package cn.zucc.service;

import cn.zucc.dao.UserInfoBiz;
import cn.zucc.entity.UserInfo;



public class UserInfoBizImpl {

	UserInfoBiz userInfoBiz = new UserInfoBiz(); 
	//×¢²á
	public boolean regist(UserInfo userInfo){
	if(userInfoBiz.FindByName(userInfo.getUserName())!=null) {
		return false;
	}
	userInfoBiz.AddUserInfo(userInfo);
	return true;
}
	//µÇÂ½
	public UserInfo login(UserInfo userInfo){
		UserInfo userInfo2 = userInfoBiz.FindByName(userInfo.getUserName());
		if (userInfo2!=null && userInfo2.getPassword().equals(userInfo.getPassword())) {
			return userInfo2;				
		}
		return null;		
	}
	
}

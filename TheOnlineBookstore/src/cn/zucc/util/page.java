package cn.zucc.util;

public class page {
	public static final int pageSize = 4;

	public static int getStart(int pageNo) {
		return (pageNo - 1) * pageSize;
	}

	public static int getTotalPage(int totalCount) {
		if (totalCount % pageSize == 0) {
			return totalCount/pageSize;
		}
		return totalCount/pageSize + 1;
	}

}


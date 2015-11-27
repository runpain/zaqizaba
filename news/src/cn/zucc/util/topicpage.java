package cn.zucc.util;

public class topicpage {
	public static final int topicpageSize = 3;

	public static int getStart(int pageNo) {
		return (pageNo - 1) * topicpageSize;
	}

	public static int getTotalPage(int totalCount) {
		if (totalCount % topicpageSize == 0) {
			return totalCount/topicpageSize;
		}
		return totalCount/topicpageSize + 1;
	}

}

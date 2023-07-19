package com.util;

public class MyUtil {
	
	//��ü ������ �� ���ϱ�
	public int getPageCount(int numPerPage, int dataCount) {
		
		int pageCount = 0;
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0)
			pageCount++;
		
		return pageCount;
	}
	
	
	//������ ó�� �޼ҵ�
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		
		int numPerBlock = 5;
		int currentPageSetup; //����������(=ǥ���� ù ������ -1)
		int page;//for���� i����
		
		StringBuffer sb = new StringBuffer();
		
		if(currentPage==0 || totalPage==0) {
			return "";
		}
		
		//
		if(listUrl.indexOf("?")!=-1) {
			listUrl += "&";
		}else {
			listUrl += "?";
		}
		
		// 6 7 8 9 10
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock ==0) {
			currentPageSetup = currentPageSetup-numPerBlock;
		}
		
		// <����
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			
			//<a href="list.jsp?pageNum=5">������</a>&nbsp;
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">������</a>&nbsp;");
			
		}
		
		//�ٷΰ��� ������
		page = currentPageSetup + 1;
		
		while(page <= totalPage && page <= (currentPageSetup+numPerBlock)) {
			if(page==currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
			}else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
			}
			
			page++;
		}
		
		// ����>
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">������</a>&nbsp;");
			
		}
	
		return sb.toString();
	}
	
	
	

}

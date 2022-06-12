package com.micol.notice;

import java.util.ArrayList;
import java.util.List;

import com.micol.notice.service.NoticeService;
import com.micol.notice.service.NoticeVO;
import com.micol.notice.serviceImpl.NoticeServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	Menu menu = new Menu();
    	menu.mainMenu();
    	
    	
    	
    	
//    	NoticeService dao = new NoticeServiceImpl();
//    	NoticeService notice = new NoticeServiceImpl();
//    	List<NoticeVO> list = new ArrayList<>();
//    	list = notice.noticeSelectList();
//    	for(NoticeVO vo : list) {
//    		vo.toString();
//    	}
//    	
//    	NoticeVO vo = new NoticeVO();
//    	vo.setId(1);
//    	System.out.println("======조회 내역======");
//    	vo = dao.noticeSelect(vo);
    	
    }
}


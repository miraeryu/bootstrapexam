package com.micol.notice;

import java.util.Scanner;

import com.micol.notice.service.NoticeService;
import com.micol.notice.serviceImpl.NoticeServiceImpl;
import com.micol.student.serviceImpl.StudentServiceImpl;

public class Menu {
	
	private Scanner sc = new Scanner(System.in);
	
	private void studentTitle() {
		System.out.println("================");
		System.out.println("=1. 전체학생목록  ="); //2.학생정보조회 3.학생 등록 4. 학생수정 5.학생정보삭제 6.종료
		System.out.println("=2. 학생정보조회  =");
		System.out.println("=3. 학생등록     =");
		System.out.println("=4. 학생정보수정  =");
		System.out.println("=5. 학생정보삭제  =");
		System.out.println("=6. 프로그램종료  =");
		System.out.println("================");
		System.out.println("입력>>");
		int studentSelect = sc.nextInt();
		boolean studentrun = true;
		StudentServiceImpl student = new StudentServiceImpl();
		while(studentrun) {
			switch(studentSelect) {
			case 1:
				student.selectListStudent();
				break;
			case 2:
				student.selectStudentVO(null);
				break;
			case 3:
				student.insertStudent(null);
				break;
			case 4:
				student.updateStudent(null);
				break;
			case 5:
				student.deleteStudent(null);
				break;
			case 6:
				System.out.println("메뉴로 돌아갑니다.");
				studentrun = false;
				break;
				
			}
		}
	}
	
	private void noticeTitle() { //1.공지사항 목록 2.등록 3.조회 4.수정 5.삭제 6.종료
		System.out.println("================");
		System.out.println("=1. 공지사항목록  ="); 
		System.out.println("=2. 공지사항등록  =");
		System.out.println("=3. 공지사항조회  =");
		System.out.println("=4. 공지사항수정  =");
		System.out.println("=5. 공지사항삭제  =");
		System.out.println("=6. 프로그램종료  =");
		System.out.println("================");
		System.out.println("입력>>");
		int noticeSelect = sc.nextInt();
		boolean noticerun = true;
		NoticeService notice = new NoticeServiceImpl();
		while(noticerun) {
			switch(noticeSelect) {
			case 1:
				notice.noticeSelectList();
				break;
			case 2:
				notice.noticeInsert(null);
				break;
			case 3:
				notice.noticeSelect(null);
				break;
			case 4:
				notice.noticeUpdate(null);
				break;
			case 5:
				notice.noticeDelete(null);
				break;
			case 6:
				System.out.println("메뉴로 돌아갑니다.");
				noticerun = false;
				break;
				
			}
		}
		
	}
	public void mainMenu() {
		System.out.println("=================");
		System.out.println("=학생및 공지사항 관리=");
		System.out.println("=1. 학생관리      =");
		System.out.println("=2. 공지사항관리   =");
		System.out.println("=3. 프로그램종료   =");
		System.out.println("=================");
		System.out.print("입력>>");
		int menuSelect = sc.nextInt();
		boolean run = true;
		while(run) {
			switch(menuSelect) {
			case 1 :
				studentTitle();
				break;
			case 2 :
				noticeTitle();
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			
			}
			
		}
		sc.close();
		
	}

}

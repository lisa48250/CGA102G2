package com.members.model;

import java.sql.Blob;
import java.util.List;

public class MemberService {
	
	private MembersDAO_interface dao;
	
	public MemberService() {
		dao = new MembersJDBCDAO();
	}
	
	public MemberVO register(String member_email, String member_password,
			String member_name, String member_phone, 
			String member_address) {
		
	MemberVO memberVO = new MemberVO();
	
	memberVO.setMember_email(member_email);
	memberVO.setMember_password(member_password);
	memberVO.setMember_name(member_name);
	memberVO.setMember_phone(member_phone);
	memberVO.setMember_address(member_address);
	dao.register(memberVO);
	
	return memberVO;
	}
	
	public MemberVO addMember(String member_email, String member_password,
			String member_name, String member_phone, 
			String member_address) {
	
	MemberVO memberVO = new MemberVO();
	
	memberVO.setMember_email(member_email);
	memberVO.setMember_password(member_password);
	memberVO.setMember_name(member_name);
	memberVO.setMember_phone(member_phone);
	memberVO.setMember_address(member_address);

	dao.insert(memberVO);
	
	return memberVO;
	}
	
	public MemberVO updateMember(Integer member_id, String member_password,
			String member_name, String member_phone, 
			String member_address) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMember_id(member_id);
		memberVO.setMember_password(member_password);
		memberVO.setMember_name(member_name);
		memberVO.setMember_phone(member_phone);
		memberVO.setMember_address(member_address);
		
		dao.update(memberVO);
		
		return memberVO;
	}
	
//	public MemberVO updateMember(Integer member_id, String member_email, String member_password,
//			String member_name, String member_phone, 
//			String member_address, Integer member_status) {
//		
//		MemberVO memberVO = new MemberVO();
//		
//		memberVO.setMember_id(member_id);
//		memberVO.setMember_email(member_email);
//		memberVO.setMember_password(member_password);
//		memberVO.setMember_name(member_name);
//		memberVO.setMember_phone(member_phone);
//		memberVO.setMember_address(member_address);
//		memberVO.setMember_status(member_status);
//		dao.update(memberVO);
//		
//		return memberVO;
//	}
	
	public void deleteMember(Integer member_id) {
		dao.delete(member_id);
	}

	public MemberVO getOneMember(Integer member_id) {
		return dao.findByPrimaryKey(member_id);
	}

    public MemberVO getfindByAccountAndPassword(String account, String password) {
    	return dao.findByAccountAndPassword(account, password);
    }
	
	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	public void updatePics(byte[] pics, Integer member_id) {
		dao.updatePic(pics, member_id);

	}
	
	public MemberVO findPasswordEmail(String member_email) {
		return dao.findPasswordEmail(member_email);
	}
	
	public void sendMail(String member_email) {
		MemberVO memberVO =dao.findPasswordEmail(member_email);
		
		
		String to = member_email;
		String subject = "雲淡風輕忘記密碼通知";
		
		String name = memberVO.getMember_name();
		String password = memberVO.getMember_password();
		
		String messageText = "Hello!! " + name + "請謹記此密碼 " + password + "\n" + " (已經啟用)";

		EmailService mailsvc = new EmailService();
		mailsvc.sendMail(to, subject, messageText);
	}
	
}
	


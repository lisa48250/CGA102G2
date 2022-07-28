package com.members.model;

import java.util.List;


import com.members.model.MemberVO;

public interface MembersDAO_interface {
	public void register(MemberVO memberVO);
	public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public void delete(Integer member_id);
    public MemberVO findByPrimaryKey(Integer empno);
    public MemberVO findByAccountAndPassword(String account, String password);
    public List<MemberVO> getAll();
    public boolean checkEmail(String Email);
    public void updatePic(byte[] pics, Integer member_id);
    public MemberVO findPasswordEmail(String member_email);
//    public MemberVO findByPrimaryKey(Integer member_id);
//    public List<MemberVO> getAll();

//  public List<EmpVO> getAll(Map<String, String[]> map);
}

package com.example.emaillist.dao;

import com.example.emaillist.vo.UserVo;

public interface UserDao {
	public UserVo getUserByEmailAndPassword(String email, String password);
	public int insert(UserVo vo);
}
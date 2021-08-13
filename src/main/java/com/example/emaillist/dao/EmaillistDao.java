package com.example.emaillist.dao;

import java.util.List;

import com.example.emaillist.vo.EmailVo;

public interface EmaillistDao {
	public List<EmailVo> getList();
	public int insert(EmailVo vo);
	public int delete(Long pk);
}
package com.odi.biz.pro_reply;

import org.springframework.web.multipart.MultipartFile;

public class ProReplyVO {
	private String pro_b_idx, pro_b_subject, pro_b_writer, pro_b_content, pro_b_file_name, pro_b_pwd, pro_b_write_date,
			pro_b_hit, pro_b_ori_name, pro_star, pro_good, pro_bad, p_idx, cust_nickname;

	
	//파일 관련 필드 추가
	private MultipartFile uploadFile;
	
	public String getCust_nickname() {
		return cust_nickname;
	}

	public void setCust_nickname(String cust_nickname) {
		this.cust_nickname = cust_nickname;
	}

	public String tot_cnt() {
		int tot_cnt = Integer.parseInt(pro_good) + Integer.parseInt(pro_bad);
		return String.valueOf(tot_cnt);
	}

	public String getPro_b_idx() {
		return pro_b_idx;
	}

	public void setPro_b_idx(String pro_b_idx) {
		this.pro_b_idx = pro_b_idx;
	}

	public String getPro_b_subject() {
		return pro_b_subject;
	}

	public void setPro_b_subject(String pro_b_subject) {
		this.pro_b_subject = pro_b_subject;
	}

	public String getPro_b_writer() {
		return pro_b_writer;
	}

	public void setPro_b_writer(String pro_b_writer) {
		this.pro_b_writer = pro_b_writer;
	}

	public String getPro_b_content() {
		return pro_b_content;
	}

	public void setPro_b_content(String pro_b_content) {
		this.pro_b_content = pro_b_content;
	}

	public String getPro_b_file_name() {
		return pro_b_file_name;
	}

	public void setPro_b_file_name(String pro_b_file_name) {
		this.pro_b_file_name = pro_b_file_name;
	}

	public String getPro_b_pwd() {
		return pro_b_pwd;
	}

	public void setPro_b_pwd(String pro_b_pwd) {
		this.pro_b_pwd = pro_b_pwd;
	}

	public String getPro_b_write_date() {
		return pro_b_write_date;
	}

	public void setPro_b_write_date(String pro_b_write_date) {
		this.pro_b_write_date = pro_b_write_date;
	}

	public String getPro_b_hit() {
		return pro_b_hit;
	}

	public void setPro_b_hit(String pro_b_hit) {
		this.pro_b_hit = pro_b_hit;
	}

	public String getPro_b_ori_name() {
		return pro_b_ori_name;
	}

	public void setPro_b_ori_name(String pro_b_ori_name) {
		this.pro_b_ori_name = pro_b_ori_name;
	}

	public String getPro_star() {
		return pro_star;
	}

	public void setPro_star(String pro_star) {
		this.pro_star = pro_star;
	}

	public String getPro_good() {
		return pro_good;
	}

	public void setPro_good(String pro_good) {
		this.pro_good = pro_good;
	}

	public String getPro_bad() {
		return pro_bad;
	}

	public void setPro_bad(String pro_bad) {
		this.pro_bad = pro_bad;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}
	
	//파일 업로드 관련 필드
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "ProReplyVO [pro_b_idx=" + pro_b_idx + ", pro_b_subject=" + pro_b_subject + ", pro_b_writer="
				+ pro_b_writer + ", pro_b_content=" + pro_b_content + ", pro_b_file_name=" + pro_b_file_name
				+ ", pro_b_pwd=" + pro_b_pwd + ", pro_b_write_date=" + pro_b_write_date + ", pro_b_hit=" + pro_b_hit
				+ ", pro_b_ori_name=" + pro_b_ori_name + ", pro_star=" + pro_star + ", pro_good=" + pro_good
				+ ", pro_bad=" + pro_bad + ", p_idx=" + p_idx + ", cust_nickname=" + cust_nickname + ", uploadFile="
				+ uploadFile + "]";
	}

}

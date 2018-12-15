package com.odi.domain;

public class UserVO {
	private String cust_id;
	private String cust_pwd;
	private String cust_email;
	private String cust_phone;
	private String cust_level;
	private String cust_addr;
	private String cust_nickname;
	private String cust_login_type;
	private String cust_key;

	public enum LoginType {
		Normal, Naver, Google
	}
	
	public UserVO() {
		
	}

	public UserVO(String cust_id, String cust_pwd, String cust_email, String cust_phone, String cust_level,
			String cust_addr, String cust_nickname, String cust_login_type, String cust_key) {
		super();
		this.cust_id = cust_id;
		this.cust_pwd = cust_pwd;
		this.cust_email = cust_email;
		this.cust_phone = cust_phone;
		this.cust_level = cust_level;
		this.cust_addr = cust_addr;
		this.cust_nickname = cust_nickname;
		this.cust_login_type = cust_login_type;
		this.cust_key = cust_key;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_pwd() {
		return cust_pwd;
	}

	public void setCust_pwd(String cust_pwd) {
		this.cust_pwd = cust_pwd;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_level() {
		return cust_level;
	}

	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}

	public String getCust_addr() {
		return cust_addr;
	}

	public void setCust_addr(String cust_addr) {
		this.cust_addr = cust_addr;
	}

	public String getCust_nickname() {
		return cust_nickname;
	}

	public void setCust_nickname(String cust_nickname) {
		this.cust_nickname = cust_nickname;
	}

	public String getCust_login_type() {
		return cust_login_type;
	}

	public void setCust_login_type(String cust_login_type) {
		this.cust_login_type = cust_login_type;
	}

	public String getCust_key() {
		return cust_key;
	}

	public void setCust_key(String cust_key) {
		this.cust_key = cust_key;
	}



	public static class Builder {
		private String id = "";
		private String pwd = "";
		private String email = "";
		private String phone = "";
		private String level = "";
		private String addr = "";
		private String nickname = "";
		private String loginType = "";
		private String cust_key = "";

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder pwd(String pwd) {
			this.pwd = pwd;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder level(String level) {
			this.level = level;
			return this;
		}

		public Builder addr(String addr) {
			this.addr = addr;
			return this;
		}

		public Builder nickname(String nickname) {
			this.nickname = nickname;
			return this;
		}
		
		public Builder loginType(String loginType) {
			this.loginType = loginType;
			return this;
		}
		public Builder cust_key(String cust_key) {
			this.cust_key = cust_key;
			return this;
		}
		
		public UserVO build() {
			return new UserVO(id, pwd, email,phone,level,addr,nickname, loginType, cust_key);
		}	
	}

	@Override
	public String toString() {
		return "UserVO [cust_id=" + cust_id + ", cust_pwd=" + cust_pwd + ", cust_email=" + cust_email + ", cust_phone="
				+ cust_phone + ", cust_level=" + cust_level + ", cust_addr=" + cust_addr + ", cust_nickname="
				+ cust_nickname + ", cust_login_type=" + cust_login_type + ", cust_key=" + cust_key + "]";
	}
	

}
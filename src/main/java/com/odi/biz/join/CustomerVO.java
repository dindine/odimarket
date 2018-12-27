package com.odi.biz.join;

public class CustomerVO {

    private String cust_id;
    private String cust_pwd;
    private String cust_email;
    private String cust_phone;
    private String cust_level;
    private String cust_addr;
    private String cust_nickname;
    private String cust_login_type;
    private String cust_key;


    //검색조건용 필드 추가
    private String searchCondition;
    private String searchKeyword;


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


    //------------------
    public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }


    @Override
    public String toString() {
        return "CustomerVO [cust_id=" + cust_id + ", cust_pwd=" + cust_pwd + ", cust_email=" + cust_email
                + ", cust_phone=" + cust_phone + ", cust_level=" + cust_level + ", cust_addr=" + cust_addr
                + ", cust_nickname=" + cust_nickname + ", cust_login_type=" + cust_login_type + ", cust_key=" + cust_key
                + ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
    }


}

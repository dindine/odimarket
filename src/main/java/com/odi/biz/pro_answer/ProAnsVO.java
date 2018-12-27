package com.odi.biz.pro_answer;

public class ProAnsVO {
    String pro_a_idx, pro_a_writer, pro_a_content, pro_a_pwd, pro_a_regdate, pro_b_idx, p_idx, cust_nickname;


    public String getCust_nickname() {
        return cust_nickname;
    }

    public void setCust_nickname(String cust_nickname) {
        this.cust_nickname = cust_nickname;
    }

    public String getPro_a_idx() {
        return pro_a_idx;
    }

    public void setPro_a_idx(String pro_a_idx) {
        this.pro_a_idx = pro_a_idx;
    }

    public String getPro_a_writer() {
        return pro_a_writer;
    }

    public void setPro_a_writer(String pro_a_writer) {
        this.pro_a_writer = pro_a_writer;
    }

    public String getPro_a_content() {
        return pro_a_content;
    }

    public void setPro_a_content(String pro_a_content) {
        this.pro_a_content = pro_a_content;
    }

    public String getPro_a_pwd() {
        return pro_a_pwd;
    }

    public void setPro_a_pwd(String pro_a_pwd) {
        this.pro_a_pwd = pro_a_pwd;
    }

    public String getPro_a_regdate() {
        return pro_a_regdate;
    }

    public void setPro_a_regdate(String pro_a_regdate) {
        this.pro_a_regdate = pro_a_regdate;
    }

    public String getPro_b_idx() {
        return pro_b_idx;
    }

    public void setPro_b_idx(String pro_b_idx) {
        this.pro_b_idx = pro_b_idx;
    }

    public String getP_idx() {
        return p_idx;
    }

    public void setP_idx(String p_idx) {
        this.p_idx = p_idx;
    }

    @Override
    public String toString() {
        return "ProAnsVO [pro_a_idx=" + pro_a_idx + ", pro_a_writer=" + pro_a_writer + ", pro_a_content="
                + pro_a_content + ", pro_a_pwd=" + pro_a_pwd + ", pro_a_regdate=" + pro_a_regdate + ", pro_b_idx="
                + pro_b_idx + ", p_idx=" + p_idx + ", cust_nickname=" + cust_nickname + "]";
    }

}

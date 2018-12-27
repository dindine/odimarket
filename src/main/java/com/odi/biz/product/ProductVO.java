package com.odi.biz.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
    private String p_idx;
    private String p_name;
    private String p_price;
    private String p_content;
    private String p_category;
    private String p_regdate;
    private String seller;
    private String p_ori_image1;
    private String p_ori_image2;
    private String p_ori_image3;
    private String p_ori_image4;
    private String p_ori_image5;
    private String p_new_image1;
    private String p_new_image2;
    private String p_new_image3;
    private String p_new_image4;
    private String p_new_image5;
    private String hit;
    private String chat_cnt;

    private String zzim;
    private String cust_id;
    private String zzim_check;

    private String zzim_cnt;

    //파일 관련 필드 추가
    private MultipartFile uploadfile;
    private MultipartFile uploadfile2;
    private MultipartFile uploadfile3;
    private MultipartFile uploadfile4;
    private MultipartFile uploadfile5;


    public String getZzim_cnt() {
        return zzim_cnt;
    }

    public void setZzim_cnt(String zzim_cnt) {
        this.zzim_cnt = zzim_cnt;
    }

    public String getZzim_check() {
        return zzim_check;
    }

    public void setZzim_check(String zzim_check) {
        this.zzim_check = zzim_check;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public MultipartFile getUploadfile2() {
        return uploadfile2;
    }

    public void setUploadfile2(MultipartFile uploadfile2) {
        this.uploadfile2 = uploadfile2;
    }

    public MultipartFile getUploadfile3() {
        return uploadfile3;
    }

    public void setUploadfile3(MultipartFile uploadfile3) {
        this.uploadfile3 = uploadfile3;
    }

    public MultipartFile getUploadfile4() {
        return uploadfile4;
    }

    public void setUploadfile4(MultipartFile uploadfile4) {
        this.uploadfile4 = uploadfile4;
    }

    public MultipartFile getUploadfile5() {
        return uploadfile5;
    }

    public void setUploadfile5(MultipartFile uploadfile5) {
        this.uploadfile5 = uploadfile5;
    }

    public String getP_idx() {
        return p_idx;
    }

    public void setP_idx(String p_idx) {
        this.p_idx = p_idx;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }

    public String getP_regdate() {
        return p_regdate;
    }

    public void setP_regdate(String p_regdate) {
        this.p_regdate = p_regdate;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getP_ori_image1() {
        return p_ori_image1;
    }

    public void setP_ori_image1(String p_ori_image1) {
        this.p_ori_image1 = p_ori_image1;
    }

    public String getP_ori_image2() {
        return p_ori_image2;
    }

    public void setP_ori_image2(String p_ori_image2) {
        this.p_ori_image2 = p_ori_image2;
    }

    public String getP_ori_image3() {
        return p_ori_image3;
    }

    public void setP_ori_image3(String p_ori_image3) {
        this.p_ori_image3 = p_ori_image3;
    }

    public String getP_ori_image4() {
        return p_ori_image4;
    }

    public void setP_ori_image4(String p_ori_image4) {
        this.p_ori_image4 = p_ori_image4;
    }

    public String getP_ori_image5() {
        return p_ori_image5;
    }

    public void setP_ori_image5(String p_ori_image5) {
        this.p_ori_image5 = p_ori_image5;
    }

    public String getP_new_image1() {
        return p_new_image1;
    }

    public void setP_new_image1(String p_new_image1) {
        this.p_new_image1 = p_new_image1;
    }

    public String getP_new_image2() {
        return p_new_image2;
    }

    public void setP_new_image2(String p_new_image2) {
        this.p_new_image2 = p_new_image2;
    }

    public String getP_new_image3() {
        return p_new_image3;
    }

    public void setP_new_image3(String p_new_image3) {
        this.p_new_image3 = p_new_image3;
    }

    public String getP_new_image4() {
        return p_new_image4;
    }

    public void setP_new_image4(String p_new_image4) {
        this.p_new_image4 = p_new_image4;
    }

    public String getP_new_image5() {
        return p_new_image5;
    }

    public void setP_new_image5(String p_new_image5) {
        this.p_new_image5 = p_new_image5;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getZzim() {
        return zzim;
    }

    public void setZzim(String zzim) {
        this.zzim = zzim;
    }

    public String getChat_cnt() {
        return chat_cnt;
    }

    public void setChat_cnt(String chat_cnt) {
        this.chat_cnt = chat_cnt;
    }


    public MultipartFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }

    @Override
    public String toString() {
        return "ProductVO [p_idx=" + p_idx + ", p_name=" + p_name + ", p_price=" + p_price + ", p_content=" + p_content
                + ", p_category=" + p_category + ", p_regdate=" + p_regdate + ", seller=" + seller + ", p_ori_image1="
                + p_ori_image1 + ", p_ori_image2=" + p_ori_image2 + ", p_ori_image3=" + p_ori_image3 + ", p_ori_image4="
                + p_ori_image4 + ", p_ori_image5=" + p_ori_image5 + ", p_new_image1=" + p_new_image1 + ", p_new_image2="
                + p_new_image2 + ", p_new_image3=" + p_new_image3 + ", p_new_image4=" + p_new_image4 + ", p_new_image5="
                + p_new_image5 + ", hit=" + hit + ", chat_cnt=" + chat_cnt + ", zzim=" + zzim + ", cust_id=" + cust_id
                + ", zzim_check=" + zzim_check + ", zzim_cnt=" + zzim_cnt + "]";
    }


}

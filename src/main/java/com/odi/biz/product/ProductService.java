package com.odi.biz.product;

import java.util.HashMap;
import java.util.List;

public interface ProductService {

    //상품 전체 조회
    List<ProductVO> getProductList(ProductVO vo);

    //상품 상세 조회
    ProductVO getProduct(ProductVO vo);

    //상품 입력
    void insertProduct(ProductVO vo);

    //상품 수정
    void updateProduct(ProductVO vo);

    //상품 삭제
    void deleteProduct(ProductVO vo);

    //찜정보
    ProductVO zzimInfo(HashMap<String, Object> hashMap);

    //찜 추가
    int insertZzim(HashMap<String, Object> hashMap);

    //찜카운트
    int zzimCount(ProductVO vo);

    //찜 선택
    void zzimSel(HashMap<String, Object> hashMap);

    //나의 찜 리스트
    List<ProductVO> myZzimList(String cust_id);

    //상품고유번호 지정을 위해 해당 카테고리의 데이터 갯수 조회
    void getP_no(String p_category);

    //존재하는 해당 카테고리의 상품 고유 번호 리스트
    List<String> exitsP_no(String category);

    //카테고리 목록 조회
    List<String> getCategory();

    //카테고리 목록 조회
    void getCategory_IDX(String category_kname);

    //카테고리 별 상품 조회
    List<ProductVO> getProductList_cate(String p_category);


}

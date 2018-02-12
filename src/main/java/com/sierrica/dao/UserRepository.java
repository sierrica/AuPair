package com.sierrica.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

//@Repository
//interface ArticleRepository : JpaRepository<Article, Long>


@Repository
public interface UserRepository extends CrudRepository<com.sierrica.model.User, Long> {
	
	List<com.sierrica.model.User> findByEmail(String email);
	
	
	
	
//	@Transactional
//	@Modifying
//    @Query(value="UPDATE supplier_info c SET gstin_no = :gstinNo , date = :date WHERE pan_no = :panNo")
//    int updateSupplierInfo(@Param("gstinNo") String gstinNo, @Param("date") Date date, @Param("panNo") String panNo);
	
}

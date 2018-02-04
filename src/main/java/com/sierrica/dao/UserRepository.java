package com.sierrica.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.sierrica.model.User;
//@Repository
//public interface UserRepository extends CrudRepository<user, Long> {
public interface UserRepository {
	//public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByEmail(String email);
	
	
//	@Transactional
//	@Modifying
//    @Query(value="UPDATE supplier_info c SET gstin_no = :gstinNo , date = :date WHERE pan_no = :panNo")
//    int updateSupplierInfo(@Param("gstinNo") String gstinNo, @Param("date") Date date, @Param("panNo") String panNo);
	
}

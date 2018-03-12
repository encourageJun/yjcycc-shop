package org.yjcycc.shop.member.mapper;

import org.yjcycc.shop.common.entity.UserCustom;

import java.util.List;
import java.util.Map;

public interface UserCustomMapper {
	
	int save(UserCustom userCustom);
	
	UserCustom findById(String id);

	List<UserCustom> findPager(Map<String,Object> map);
	
}

package com.dobongnadlecoop.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;


/**
 * @author posyo
 * 
 * @설명: DTO, ENTITY 클래스 매핑
 */
public class ModelMapperUtil {

	private static ModelMapper mm = new ModelMapper();
	
	/**
	 * @Method Name : convertDataType
	  * @작성일 : 2021. 1. 25.
	  * @작성자 : posyo
	  * @Method 설명 :
	  * 
	  * S -> T
	  * 
	  * @param <S> 변경 대상 클래스
	  * @param <T> 변경 되는 클래스 = wantClass
	  * @param target : 변경시킬 대상 (값이 들어있음)
	  * @param wantClass : 대상을 변경할 클래스
	  * @return (wantClass)target
	 */
	public static <S, T> T convertDataType(S target, Class<T> wantClass) {
		mm.getConfiguration().setFieldAccessLevel(AccessLevel.PRIVATE).setFieldMatchingEnabled(true);
		return mm.map(target, wantClass);
	}
	
	/**
	 * @Method Name : convertDataType
	  * @작성일 : 2021. 1. 25.
	  * @작성자 : posyo
	  * @Method 설명 :
	  * 
	  * List<S> -> List<T>
	  * 
	  * @param <S> 변경 대상 클래스
	  * @param <T> 변경 되는 클래스 = wantClass
	  * @param target : 변경될 리스트
	  * @param wantClass
	  * @return List (wantClass)target
	 */
	public static <S, T> List<T> convertDataType(List<S> target, Class<T> wantClass) {
		mm.getConfiguration().setFieldAccessLevel(AccessLevel.PRIVATE).setFieldMatchingEnabled(true);
	    return target
	      .stream()
	      .map(element -> mm.map(element, wantClass))
	      .collect(Collectors.toList());
	}
	
	// 혹시 1:1 매핑이 안돼는 모델이있다면 함수더 추가하기
	
}

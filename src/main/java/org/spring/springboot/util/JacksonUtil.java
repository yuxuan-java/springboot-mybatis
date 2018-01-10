package org.spring.springboot.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Json转换工具类
 *
 * @author yuxuan.han
 */
@SuppressWarnings("all")
public class JacksonUtil {
	
	private static volatile JacksonUtil jackson;
	
    private ObjectMapper objectMapper = null;
    
    private JavaType javaType = null;
	
	private JacksonUtil(){
		objectMapper = new ObjectMapper();
	}
	
	public static final JacksonUtil getInstance() {
		if (jackson == null) {
			synchronized(JacksonUtil.class) {
				if (jackson == null) {
					jackson = new JacksonUtil();
				}
			}
		}
		return jackson;
	}
	
	/**
	 * 主要的转Json方法
	 * @param object
	 * @return jsonStr
	 * @throws Exception
	 */
	public String object2Json(Object object) throws Exception {
		return objectMapper.writeValueAsString(object);
	}
	
	/**
	 * json转map
	 * @param json	{"bookId":123,"author":"海明威","name":"老人与海","price":30}
	 * @return	Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> json2Map(String json) throws Exception {
		return objectMapper.readValue(json, Map.class);
	}
	
	/**
	 * json转model
	 * @param json {"bookId":123,"author":"海明威","name":"老人与海","price":30}
	 * @param clazz Model.class
	 * @return	Model
	 * @throws Exception
	 */
	public <T> T json2Model(String json, Class<T> clazz) throws Exception {
		return objectMapper.readValue(json, clazz);
	}
	
	/**
	 * json转list
	 * @param json	
	 * 	[
	 * 		{"bookId":123,"author":"海明威","name":"老人与海","price":30},
	 * 		{"bookId":1234,"author":"海明威2","name":"老人与海2","price":302},
	 * 		{"bookId":12345,"author":"海明威3","name":"老人与海3","price":303}
	 *	]
	 * @param clazz 实体的类对象
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> json2List(String json, Class<T> clazz) throws Exception {
		javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
		return objectMapper.readValue(json, javaType);
	}
	
	/**
	 * 单参数json数据转List<Stirng>
	 * @param json	[{"id":"aaa"},{"id":"bbb"},{"id":"ccc"},{"id":"ddd"}]
	 * @return List<String>
	 * @throws Exception
	 */
	public List<String> json2StringList(String json) throws Exception {
		List<LinkedHashMap<String, String>> idsMapList = objectMapper.readValue(json, List.class);
		List<String> result = new ArrayList<String>();
		for (LinkedHashMap<String, String> map : idsMapList) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				result.add(entry.getValue());
			}
		}
		return result;
	}
}

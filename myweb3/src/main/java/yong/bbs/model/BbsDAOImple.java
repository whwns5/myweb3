package yong.bbs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import yong.emp.model.EmpDAO;

public class BbsDAOImple implements BbsDAO {

	private SqlSessionTemplate sqlMap;
	
	public BbsDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	public List<BbsDTO> bbsList(int cp, int ls) {
		int startnum = (cp - 1) * ls;
		int endnum = cp * ls;
		Map param = new HashMap();
		param.put("startnum", startnum);
		param.put("endnum", endnum);
		List<BbsDTO> list = sqlMap.selectList("bbsList", param);
		return list;
	}

	public int getTotalCnt() {
		int count = sqlMap.selectOne("totalCnt");
		return count;
	}
	
	 
}

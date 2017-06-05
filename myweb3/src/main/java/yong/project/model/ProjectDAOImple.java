package yong.project.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import yong.bbs.model.BbsDTO;

public class ProjectDAOImple implements ProjectDAO {

	private SqlSessionTemplate sqlMap;
	
	public ProjectDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	
	public List<Object> materList(int cp, int ls) {
		int startnum = (cp - 1) * ls;
		int endnum = cp * ls;
		Map param = new HashMap();
		param.put("startnum", startnum);
		param.put("endnum", endnum);
		List<Object> list = sqlMap.selectList("materList", param);
		return list;
	}

	public Object materInfo(Object obj) {
		return sqlMap.selectOne("materInfo", obj);
	}

	public int materUpdate(Object obj) {
		return sqlMap.update("materUpdate", obj);
	}

	public int materInsert(Object obj) {
		return sqlMap.insert("materInsert", obj);
	}

	public int getTotalCnt() {
		int count = sqlMap.selectOne("materTotalCnt");
		return count;
	}

}

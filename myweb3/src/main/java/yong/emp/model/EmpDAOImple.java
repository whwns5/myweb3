package yong.emp.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpDAOImple implements EmpDAO {

	private SqlSessionTemplate sqlMap; // 리모컨
	
	public EmpDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}
	/** 사원 등록 관련 메서드 */
	public int empAdd(EmpDTO dto) {
		return sqlMap.insert("empInsert", dto);
	}
	/** 사원 삭제 관련 메서드 */
	public int empDel(String name) {
		return sqlMap.delete("empDelete", name);
	}
	/** 사원 수정 관련 메서드 */
	public int empUpdate(EmpDTO dto) {
		return sqlMap.update("empUpdate", dto);
	}
	/** 사원 전체조회 관련 메서드 */
	public List<EmpDTO> empList() {
		return sqlMap.selectList("empAllList");
	}
	/** 사원 검색 조회 관련 메서드 */
	/*public EmpDTO empList(int idx) {
		EmpDTO dto = sqlMap.selectOne("empSelect", idx);
		return dto;
	}*/
	public EmpDTO empSearch(int idx) {
		return sqlMap.selectOne("empSelect", idx);
	}
	
	
	
	/*@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public EmpDAOImple() {
		super();
	}
	
	public int empAdd(EmpDTO dto) {
		int count = sqlSessionTemplate.insert("empInsert", dto);
		return count;
	}*/
}

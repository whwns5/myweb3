package yong.emp.model;

import java.util.List;

public interface EmpDAO {
	/** 사원 등록 관련 메서드 */
	public int empAdd(EmpDTO dto);
	/** 사원 삭제 관련 메서드 */
	public int empDel(String name);
	/** 사원 수정 관련 메서드 */
	public int empUpdate(EmpDTO dto);
	/** 사원 전체 조회 관련 메서드 */
	public List<EmpDTO> empList();
	/** 사원 검색 조회 관련 메서드 */
	/*public EmpDTO empList(int idx);*/
	public EmpDTO empSearch(int idx);
	
	
}

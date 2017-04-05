package yong.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	/** 회원가입 관련 메서드 */
	public int memberAdd(MemberDTO mdto);
	/** 아이디 체크 관련 메서드 */
	public boolean idCheck(String id);
	/** 로그인 관련 메서드 */
	public int loginCheck(String input_id, String input_pwd);
	/** 로그인 정보 검색 관련 메서드 */
	public MemberDTO loginInfo(String input_id);
	/** 회원 조건 검색 관련 메서드 */
	public ArrayList<MemberDTO> memberList(String fkey, String fvalue);
}

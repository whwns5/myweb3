package yong.bbs.model;

import java.util.List;

public interface BbsDAO {
	public List<BbsDTO> bbsList(int cp, int ls);
	public int getTotalCnt();
}

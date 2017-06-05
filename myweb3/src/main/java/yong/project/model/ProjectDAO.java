package yong.project.model;

import java.util.List;

import yong.bbs.model.BbsDTO;

public interface ProjectDAO {
	public List<Object> materList(int cp, int ls);
	public Object materInfo(Object obj);
	public int materUpdate(Object obj);
	public int materInsert(Object obj);
	
	public int getTotalCnt();
}

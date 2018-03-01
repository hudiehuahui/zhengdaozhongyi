/**
 * Mar 1, 2018
 */
package com.zdzy.timephd.acupointmap.model;

import com.zdzy.framework.bean.BaseBean;

/** 
 * @ClassName: AcupointMap 
 * @Description: 
 * @author humin 
 * @date Mar 1, 2018 1:25:35 PM 
 *  
 */
public class AcupointMap extends BaseBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 主键
	private int id;
	// 穴位图名称
	private String acupointMapName;
	// 穴位图路径
	private String path;
	// 所属部位
	private int part;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcupointMapName() {
		return acupointMapName;
	}
	public void setAcupointMapName(String acupointMapName) {
		this.acupointMapName = acupointMapName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	
	
	
}

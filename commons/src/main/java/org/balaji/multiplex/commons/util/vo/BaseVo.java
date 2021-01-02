package org.balaji.multiplex.commons.util.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseVo {

	private Date createdDate = null;
	private Date lastUpdatedDate = null;
	private String createdBy = null;
	private String lastUpdatedBy = null;
	private Boolean isDeleted = false;
	private Boolean isActive = true;

}

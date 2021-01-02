package org.balaji.multiplex.commons.service;

import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.util.vo.BaseVo;

import java.util.Optional;

public interface BaseVoMappingService<T extends BaseEntity, VO extends BaseVo> {

	VO map(T t, VO vo);

	default VO map(T t) {
		return map(t, null);
	}

	default VO populateBaseVo(Optional<T> optionalObj) {
		if (!optionalObj.isPresent()) {
			return null;
		}
		T t = optionalObj.get();

		VO vo = map(t, null);
		vo.setCreatedBy(t.getCreatedBy());
		vo.setCreatedDate(t.getCreatedDate());
		vo.setIsActive(t.getIsActive());
		vo.setIsDeleted(t.getIsDeleted());
		vo.setLastUpdatedBy(t.getLastUpdatedBy());
		vo.setLastUpdatedDate(t.getLastUpdatedDate());
		return vo;
	}
}

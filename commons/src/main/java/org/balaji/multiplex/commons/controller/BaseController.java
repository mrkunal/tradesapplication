package org.balaji.multiplex.commons.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.service.BaseService;
import org.balaji.multiplex.commons.service.BaseVoMappingService;
import org.balaji.multiplex.commons.util.dto.Result;
import org.balaji.multiplex.commons.util.vo.BaseVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BaseController<T extends BaseEntity, CO, VO extends BaseVo> {

	private BaseService<T, CO, VO> baseService;
	private BaseVoMappingService<T, VO> mappingService;
	private final Logger logger = LogManager.getLogger(BaseController.class);
	protected final Logger log;

	public BaseController(BaseService baseService, BaseVoMappingService mappingService) {
		super();
		this.baseService = baseService;
		this.mappingService = mappingService;
		this.log = LogManager.getLogger(this.getClass());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Result<VO>> fetch(@PathVariable String id) {
		logger.info("Get Method Called");
		ResponseEntity<Result<VO>> responseEntity = null;
		Result<VO> result = new Result<VO>();
		try {
			Optional<T> obj = baseService.get(id);

			VO viewObject = mappingService.populateBaseVo(obj);
			result.setData(viewObject);
			responseEntity = new ResponseEntity<Result<VO>>(result, HttpStatus.OK);
		} catch (Exception e) {

			responseEntity = new ResponseEntity<Result<VO>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Internal Error occurred While Processing {}", e);
			logger.error(e);
		}

		return responseEntity;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Result<VO>> create(@RequestBody CO coObject) {
		logger.info("POST Method Called");
		ResponseEntity<Result<VO>> responseEntity = null;
		Result<VO> result = new Result<VO>();
		try {
			Optional<T> obj = baseService.create(coObject);
			VO viewObject = mappingService.populateBaseVo(obj);
			result.setData(viewObject);
			responseEntity = new ResponseEntity<Result<VO>>(result, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Result<VO>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Internal Error occurred While Processing {}", e);
			logger.error(e);
		}
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Result<VO>> update(@PathVariable("id") String id, @RequestBody CO coObject ) {
		logger.info("Get Method Called");
		ResponseEntity<Result<VO>> responseEntity = null;
		Result<VO> result = new Result<VO>();
		try {
			Optional<T> resource = baseService.get(id);

			Function<T, Optional<T>> p = (value) -> {
				return baseService.update(coObject, value);
			};

			if (resource.isPresent()) {
				resource = p.apply(resource.get());
			}
			resource.orElseThrow();

			VO viewObject = mappingService.populateBaseVo(resource);
			result.setData(viewObject);
			responseEntity = new ResponseEntity<Result<VO>>(result, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Result<VO>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Internal Error occurred While Processing {}", e);
			logger.error(e);
		}

		return responseEntity;

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Result<List<VO>>> list(@RequestParam(required = false, defaultValue = "0") int offset,
                                                 @RequestParam(required = false, defaultValue = "10") int limit) {

		ResponseEntity<Result<List<VO>>> responseEntity = null;
		Result<List<VO>> result = new Result<List<VO>>();
		Page<T> listObjects = baseService.findAll(PageRequest.of(offset, limit));

		List<VO> voList = listObjects.getContent().stream().map(p -> mappingService.populateBaseVo(Optional.of(p)))
				.collect(Collectors.toList());

		result.setData(voList);

		result.setPageDetails(listObjects);

		responseEntity = new ResponseEntity<Result<List<VO>>>(result, HttpStatus.OK);

		return responseEntity;
	}

}

package org.balaji.multiplex.commons.util.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.balaji.multiplex.commons.util.dto.DataError;
import org.springframework.data.domain.Page;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class Result<D> {

	private D data;
	private List<DataError> errors;
    private Integer totalPage;
    private Integer totalElements;
    private Integer currentPage;
    
	
    


	public Result() {
	}

	public Result(D data) {
		this.data = data;
	}

	public Result(Result<D> result) {
		this.data = result.data;
	}

	/**
	 * Success is the absence of errors
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return (getErrors() == null || getErrors().isEmpty());
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public List<DataError> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<DataError> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "Result [data=" + data + ", errors=" + errors + "]";
	}
	
	public void setPageDetails(Page page)
	{
		this.setCurrentPage(page.getNumber());
		this.setTotalElements(page.getNumberOfElements());
		this.setTotalPage(page.getTotalPages());
		
	}

// convenience method
	public void addError(final DataError error) {
		getErrors().add(error);
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String printErrors() {
		StringWriter sw = new StringWriter();
		for (DataError error : getErrors()) {
			sw.append(error.toString() + '\n');
		}
		return sw.toString();
	}

}

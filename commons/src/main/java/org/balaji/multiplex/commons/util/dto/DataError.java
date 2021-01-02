package org.balaji.multiplex.commons.util.dto;


public class DataError {
	
  private String errorCode;
  private String errorMessage;
  private String errorInfo; 

  public DataError() {
  }

  public DataError(String errorCode, String errorMessage, String errorInfo) {
    this.errorCode = errorCode;
    this.errorMessage=errorMessage;
    this.errorInfo = errorInfo;
  }

public String getErrorCode() {
	return errorCode;
}

public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

public String getErrorInfo() {
	return errorInfo;
}

public void setErrorInfo(String errorInfo) {
	this.errorInfo = errorInfo;
}

@Override
public String toString() {
	return "DataError [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorInfo=" + errorInfo + "]";
}

}

package ru.webinar.camera.exception;

public class UnaccessibleCameraException extends RuntimeException {

	public UnaccessibleCameraException() {
		super();
	}

	public UnaccessibleCameraException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public UnaccessibleCameraException(String detailMessage) {
		super(detailMessage);
	}

	public UnaccessibleCameraException(Throwable throwable) {
		super(throwable);
	}

}

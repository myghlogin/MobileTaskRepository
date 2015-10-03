package ru.webinar.camera.exception;

public class StartCaptureException extends RuntimeException 
{
	public StartCaptureException() {
		super();
	}

	public StartCaptureException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public StartCaptureException(String detailMessage) {
		super(detailMessage);
	}

	public StartCaptureException(Throwable throwable) {
		super(throwable);
	}

}

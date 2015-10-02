package ru.webinar.camera;

public class StartCaptureException extends Exception 
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

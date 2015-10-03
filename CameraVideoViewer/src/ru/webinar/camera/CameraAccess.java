package ru.webinar.camera;

public interface CameraAccess 
{
	void openCamera();
	void startCapture();
	void stopAndReleaseCamera();
}

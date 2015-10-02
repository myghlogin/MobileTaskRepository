package ru.webinar.camera;

import android.view.View;

public interface CameraAccess 
{
	void openCamera() throws UnaccessibleCameraException;
	void startCapture() throws StartCaptureException;
	void stopAndReleaseCamera();
}

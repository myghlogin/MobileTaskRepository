package ru.webinar.camera;

import java.io.IOException;

import ru.webinar.camera.exception.StartCaptureException;
import ru.webinar.camera.exception.UnaccessibleCameraException;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.ViewGroup;

public class CameraAPI1 extends AbstractCamera implements CameraAccess 
{
	private CameraPreview surface;
	private Camera camera;
	
	public CameraAPI1(Context context, ViewGroup surfaceContainer) {
		super(context, surfaceContainer);
		
		surface = new CameraPreview(context);
		surfaceContainer.addView(surface);
	}
	
	public void openCamera()
	{
		try{
			camera = Camera.open();
		} catch(Exception e){
			throw new UnaccessibleCameraException(e);
		}
		
		if(camera == null)
			throw new UnaccessibleCameraException("Device does not have back-facing camera"); 
	}
	
	public void startCapture() {
		try {
			configureCameraAndStartPreview();
		} catch (IOException e) {
			throw new StartCaptureException(e);
		}
	}
	
	private void configureCameraAndStartPreview() throws IOException {
		if(surface.isSurfaceAvaliable()){
			rotateImageIfPortraitOrientation();
			startPreview();
		}
		else
			throw new StartCaptureException("Surface is not avaliable");
	}
	
	private void rotateImageIfPortraitOrientation(){
		if(AbstractCamera.getScreenOrientation(context) == Configuration.ORIENTATION_PORTRAIT)
			camera.setDisplayOrientation(90);
	}
	
	private void startPreview() throws IOException{
		camera.setPreviewDisplay(surface.getHolder());
		camera.startPreview();
	}
	
	public void stopAndReleaseCamera(){
		if(surface.isSurfaceAvaliable()){
			camera.stopPreview();
		}
		camera.release();
	}

}

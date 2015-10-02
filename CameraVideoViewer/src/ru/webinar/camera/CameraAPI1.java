package ru.webinar.camera;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.view.View;
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
	
	public void openCamera() throws UnaccessibleCameraException 
	{
		try{
			camera = Camera.open();
		} catch(Exception e){
			// camera is not available (in use or does not exist)
			throw new UnaccessibleCameraException(e);
		}
		
		if(camera == null)
			throw new UnaccessibleCameraException(); 
	}
	
	public void startCapture() throws StartCaptureException {
		try {
			if(surface.isSurfaceCreated()){
				camera.setPreviewDisplay(surface.getHolder());
				camera.startPreview();
			}
			else{
				throw new StartCaptureException("Surface is not created");
			}
		} catch (IOException e) {
			throw new StartCaptureException(e);
		}
	}
	
	public void stopAndReleaseCamera(){
		if(surface.isSurfaceCreated()){
			camera.stopPreview();
		}
		camera.release();
	}

}

package ru.webinar.camera;

import android.hardware.Camera;

public class CameraUtils 
{
	public static Camera getBackCameraInstance() throws UnaccessibleCameraException
	{
		Camera camera = null;
		
		try{
			camera = Camera.open();
		} catch(Exception e){
			// camera is not available (in use or does not exist)
		}
		
		if(camera == null)
			throw new UnaccessibleCameraException(); 
			
		return camera;
	}
	
	public static void releaseCamera(Camera camera){
		if(camera != null)
			camera.release();
	}
}

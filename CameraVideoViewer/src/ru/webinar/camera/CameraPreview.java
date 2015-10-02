package ru.webinar.camera;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback 
{
	private SurfaceHolder holder;
	private Camera camera;
	private boolean surfaceCreated;
	
	public CameraPreview(Context context) {
		super(context);
		holder = getHolder();
		holder.addCallback(this);	
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		/*try {
			camera.setPreviewDisplay(holder);
			camera.startPreview();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		surfaceCreated = true;
		Log.d("CVV", "surface created");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) 
	{
		/*if(holder.getSurface() == null)
			return;
		
		try{
			camera.stopPreview();
		} catch(Exception e){
			// ignore: tried to stop a non-existent preview
		}
		
		try {
			camera.setPreviewDisplay(holder);
			camera.startPreview();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		Log.d("CVV", "surface changed");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		try{
			//camera.stopPreview();
		} catch(Exception e){
			// ignore: tried to stop a non-existent preview
		}
		surfaceCreated = false;
		Log.d("CVV", "surface destroyed");

	}

	/*public void setCamera(Camera camera) {
		this.camera = camera;
	}*/
	
	public boolean isSurfaceCreated(){
		return surfaceCreated;
	}
	
	

}

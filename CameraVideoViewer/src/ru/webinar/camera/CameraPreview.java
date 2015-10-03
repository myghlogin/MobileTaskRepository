package ru.webinar.camera;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class CameraPreview extends SurfaceView implements SurfaceHolder.Callback 
{
	private SurfaceHolder holder;
	private boolean surfaceAvaliable;
	
	public CameraPreview(Context context) {
		super(context);
		holder = getHolder();
		holder.addCallback(this);	
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		surfaceAvaliable = true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)	{
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		surfaceAvaliable = false;

	}

	public boolean isSurfaceAvaliable(){
		return surfaceAvaliable;
	}
}

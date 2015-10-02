package ru.webinar.camera;

import android.content.Context;
import android.view.ViewGroup;

public abstract class AbstractCamera 
{
	protected ViewGroup surfaceContainer;
	protected Context context;
	
	public AbstractCamera(Context context, ViewGroup surfaceContainer){
		if(context == null || surfaceContainer == null)
			throw new NullPointerException("Arguments must not be null");
		
		this.surfaceContainer = surfaceContainer;
		this.context = context;
	}
}

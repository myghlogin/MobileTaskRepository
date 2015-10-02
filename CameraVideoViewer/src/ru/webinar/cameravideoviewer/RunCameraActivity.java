package ru.webinar.cameravideoviewer;

import ru.webinar.camera.CameraPreview;
import ru.webinar.camera.CameraUtils;
import ru.webinar.camera.UnaccessibleCameraException;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class RunCameraActivity extends Activity implements OnClickListener
{
    private CameraPreview cameraPreview;
    private FrameLayout frame;
    private Camera backCamera;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.d("CVV", "activity created");
        
        initUI();
        
		Log.d("CVV", "activity created");
    }
	
	private void initUI(){
        setContentView(R.layout.activity_run_camera);

        Button runCameraAppBtn = (Button)findViewById(R.id.run_camera_app_btn);
        runCameraAppBtn.setOnClickListener(this);
	}

	private void initCameraAndItsUI(){
		try{
			configureCameraAndItsUI();
		} catch(UnaccessibleCameraException e){
			showToast("Camera ia unaccessible");
		}
	}
	
	private void configureCameraAndItsUI() throws UnaccessibleCameraException {
    	backCamera = CameraUtils.getBackCameraInstance();
    	configureViewToOutputCameraImage(backCamera);
	}
	
	private void configureViewToOutputCameraImage(Camera camera){
    	cameraPreview = new CameraPreview(this, camera);
    	cameraPreview.setVisibility(View.INVISIBLE);
    	frame = (FrameLayout)findViewById(R.id.camera_preview);
    	frame.addView(cameraPreview);
	}
	
	private void showToast(String message){
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onClick(View v) 
	{
		int viewId = v.getId();
		if(viewId == R.id.run_camera_app_btn) {
			cameraPreview.setVisibility(View.VISIBLE);
		}
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("CVV", "activity paused");

		//backCamera.release();
	}

	@Override
	protected void onStart() {
		Log.d("CVV", "activity started");
		super.onStart();
		initCameraAndItsUI();
	}

	@Override
	protected void onResume() {
		Log.d("CVV", "activity resumed");
		super.onResume();
	}

	@Override
	protected void onStop() {
		Log.d("CVV", "activity stoped");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d("CVV", "activity destroyed");
		super.onDestroy();
	}
    
	

}

package ru.webinar.cameravideoviewer;

import ru.webinar.camera.*;
import ru.webinar.camera.exception.StartCaptureException;
import ru.webinar.camera.exception.UnaccessibleCameraException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class RunCameraActivity extends Activity implements OnClickListener
{
    private FrameLayout frameContainer;
    private CameraAccess backCamera;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initUI();
        initCameraAndItsUI();
    }
	
	private void initUI(){
        setContentView(R.layout.activity_run_camera);

        Button runCameraAppBtn = (Button)findViewById(R.id.run_camera_app_btn);
        runCameraAppBtn.setOnClickListener(this);
	}

	private void initCameraAndItsUI(){
		frameContainer = (FrameLayout)findViewById(R.id.camera_preview);
		backCamera = new CameraAPI1(this, frameContainer); 
	}
	
	@Override
	public void onClick(View v) 
	{
		int viewId = v.getId();
		if(viewId == R.id.run_camera_app_btn) {
			try {
				backCamera.startCapture();
			} catch (StartCaptureException e) {
				showToast(e.getMessage());
			}
		}
	}

	private void showToast(String message){
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		try {
			backCamera.openCamera();
		} catch (UnaccessibleCameraException e) {
			showToast(e.getMessage());
		}
	}
	
	@Override
	protected void onPause() {
		backCamera.stopAndReleaseCamera();
		super.onPause();
	}

}

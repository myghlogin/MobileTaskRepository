package ru.webinar.cameravideoviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RunCameraActivity extends Activity implements OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_camera);
        
        Button runCameraAppBtn = (Button)findViewById(R.id.run_camera_app_btn);
        runCameraAppBtn.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) 
	{
		int viewId = v.getId();
		
		if(viewId == R.id.run_camera_app_btn){
			Intent runCameraIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
			if(runCameraIntent.resolveActivity(getPackageManager()) != null)
				startActivity(runCameraIntent);
			else{
				String messageText = getString(R.string.no_camera_app_error_message);
				Toast.makeText(this, messageText, Toast.LENGTH_LONG).show();
			}
		}
		
	}
    

}

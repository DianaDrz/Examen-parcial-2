package com.example.pregunta4;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	private GLSurfaceView superficie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		superficie = new Renderiza(this);
		setContentView(superficie);
	}

	@Override
	protected void onResume() {
		super.onResume();
		superficie.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		superficie.onPause();
	}
}
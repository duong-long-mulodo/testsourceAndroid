package test;

import com.example.testtravis.MainActivity;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.content.IntentFilter;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	MainActivity mActivy = null;
    private Instrumentation mInstrumentation = null;
	private ActivityMonitor monitor = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivy = this.getActivity();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public MainActivityTest(String name) {
		super(MainActivity.class);
		setName(name);
	}
	
	public void init(){
		mInstrumentation = getInstrumentation();
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_VIEW);
		intentFilter.addDataScheme("http");
		intentFilter.addCategory(Intent.CATEGORY_BROWSABLE);
		monitor = mInstrumentation.addMonitor(intentFilter, null, false);
		monitor.waitForActivityWithTimeout(2000);
	}
	
	public void testButtonpress(){
		init();
		
		final EditText text = mActivy.getEditView();
		assertNotNull(text);
		
		final Button press = mActivy.getBtnPress();
		assertNotNull(press);
		
		mActivy.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				text.setText("test test");
				press.performClick();
			}
		});
		
		monitor.waitForActivityWithTimeout(1000);
	}

    public void testButtonreset(){
    	init();
    	
    	final Button reset = mActivy.getBtnReset();
    	assertNotNull(reset);
    	
    	mActivy.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				reset.performClick();
			}
		});
    	
    	monitor.waitForActivityWithTimeout(1000);
    }
}

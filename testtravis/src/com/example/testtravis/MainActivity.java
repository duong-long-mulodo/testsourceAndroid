package com.example.testtravis;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText edit = null;
	TextView text = null;
	Button button = null;
	Button reset = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		text = (TextView)findViewById(R.id.textview);
	    edit = (EditText)findViewById(R.id.edit);
		button = (Button)findViewById(R.id.button);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				text.setText(edit.getText().toString());
			}
		});
		
		reset = (Button)findViewById(R.id.reset);
		
		reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				text.setText("");
			}
		});
		
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public TextView GetTextView(){
		return text;
	}
	public EditText getEditView(){
		return edit;
	}
	public Button getBtnPress(){
		return button;
	}
	public Button getBtnReset(){
		return reset;
	}

}

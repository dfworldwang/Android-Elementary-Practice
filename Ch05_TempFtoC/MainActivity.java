package com.example.ch05_tempftoc;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnCheckedChangeListener, TextWatcher {
	
	RadioGroup unit;		// ���s�s�����
	EditText value;			// �ϥΪ̿�J���ū׭����

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        unit = (RadioGroup)findViewById(R.id.unit);		// ���o���s�s�� 																				
        unit.setOnCheckedChangeListener(this);			// �]�w this ����ť��
        
        value = (EditText)findViewById(R.id.value);		// ���o��J���
        value.addTextChangedListener(this);				// �]�w this ����ť��
    }

    public void afterTextChanged(Editable arg0) {
    	calc();
    }
    
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, 
    		int arg3) {
    	// TextWatcher ��������k, ���B���|�Ψ�
    }
    
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, 
    		int arg3) {
    	// TextWatcher ��������k, ���B���|�Ψ�
    }
    
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
    	calc();
    }
    
    protected void calc() {
    	// ���o��r���
    	TextView degF = (TextView)findViewById(R.id.degF);
    	TextView degC = (TextView)findViewById(R.id.degC);
    	
    	double f = 0, c = 0;		// �x�s�ū׭ȴ��⵲�G
    	
    	if (unit.getCheckedRadioButtonId() == R.id.unitF) {
    		// �Y��ܿ�J�ؤ�ū�
    		
    		// �ץ��b�o��
    		try {
    			f = Double.parseDouble(value.getText().toString());
    		} catch (NumberFormatException e) {
    			f = 0;
    		}
    		
    		c = (f - 32) * 5 / 9;		// �ؤ� => ���
    	} else {						// �Y��ܿ�J���ū�
    		
    		// �ץ��b�o��
    		try {
    			c = Double.parseDouble(value.getText().toString());
    		} catch (NumberFormatException e) {
    			c = 0;
    		}
    		
    		f = c * 9 / 5 + 32;			// ��� => �ؤ�
    	}
    	
    	degC.setText(String.format("%.1f", c) + 
    			getResources().getString(R.string.charC));
    	// �u��ܨ�p���I�� 1 ��
    	// �q�r��귽���J .C �Ÿ�
    	
    	degF.setText(String.format("%.1f", f) + 
    			getResources().getString(R.string.charF));
    	// �u��ܨ�p���I�� 1 ��
    	// �q�r��귽���J .F �Ÿ�
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

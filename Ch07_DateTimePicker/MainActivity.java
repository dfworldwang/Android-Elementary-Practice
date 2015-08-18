package com.example.ch07_datetimepicker;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

// �i�H�� DatePickerDialog �� TimePickerDialog ���O�ӫإߤ��, �ɶ���͵�
// (1) �ǤJ this ��ܭn�b MainActivity ��ܥ�͵� 
// (2) �� MainActivity ��ť������(�ɶ�)�����ɪ��ƥ�

// �p�G�O DatePickerDialog, ��ť���󥲶���@ DatePickerDialog.OnDateSetListener �������w�q�� onDateSet() ��k
// �p�G�O TimePickerDialog, ��ť���󥲶���@ TimePickerDialog.OnTimeSetListener �������w�q�� onTimeSet() ��k       

public class MainActivity extends ActionBarActivity 
	implements OnClickListener, DatePickerDialog.OnDateSetListener, 
	TimePickerDialog.OnTimeSetListener {
	// ��@��ť�����͵��ƥ󪺤���
	// ��@��ť�ɶ���͵��ƥ󪺤���
	
	Calendar c = Calendar.getInstance();		// �إߤ�䪫��
	TextView txDate;		// �O�������r������
	TextView txTime;		// �O���ɶ���r������

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txDate = (TextView)findViewById(R.id.textView1);	
        // ���o�Ψ���ܤ���� TextView
        txTime = (TextView)findViewById(R.id.textView2);
        // ���o�Ψ���ܮɶ��� TextView
        
        txDate.setOnClickListener(this);	// �]�w���U�����r�ɪ���ť����
        txTime.setOnClickListener(this);	// �]�w���U�ɶ���r�ɪ���ť����
    }

    public void onClick(View v) {
    	
    	if (v == txDate) {		// �����O�����r
    		// �إߤ����ܥ�͵�, �öǤJ�]�w�����ɪ���ť����
    		new DatePickerDialog(this, this, 		// �� MainActivity �����ť�ƥ�
    				c.get(Calendar.YEAR),			// �� Calendar ������o�ثe���褸�~  
    				c.get(Calendar.MONTH),				// ���o�ثe�� (�� 0 ��_)
    				c.get(Calendar.DAY_OF_MONTH))		// ���o�ثe��
    				.show();		// ��ܥ�͵�
    	}
    	else if (v == txTime) {		// �����O�ɶ���r
    		// �إ߮ɶ���ܥ�͵�, �öǤJ�]�w�����ɪ���ť����
    		new TimePickerDialog(this, this, 			// �� MainActivity ��ť�ƥ�
    				c.get(Calendar.HOUR_OF_DAY),		// ���o�ثe����(24�p�ɨ�)
    				c.get(Calendar.MINUTE),				// ���o�ثe����
    				true)								// �ϥ� 24 �p�ɨ�  
    				.show();						// ��ܥ�͵�
    		
    	}
    }
    
    @Override
    public void onDateSet(DatePicker v, int y, int m, int d) {	// ��w����᪺�B�z��k
    	
    	txDate.setText("���:" + y + "/" + (m+1) + "/" + d);
    	// �N��w�����ܦb�ù��W
    }
    
    @Override
    public void onTimeSet(TimePicker v, int h, int m) {		// ��w�ɶ��᪺�B�z��k
    	
    	txTime.setText("�ɶ�:" + h + ":" + m);	// �N��w���ɶ���ܦb�ù��W
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

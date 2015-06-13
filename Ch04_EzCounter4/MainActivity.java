package com.example.ch04_ezcounter2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnClickListener, OnLongClickListener {	
	// �ŧi�n��@ OnClickListener ����������ť����
	// ��@ OnLongClickListener ����
	
	TextView txv;		// �ΨӾާ@ textView1 �����ܼ�
	Button btn;			// �ΨӾާ@ button1 �����ܼ�
	int counter = 0;	// �Ψ��x�s�p�ƪ���, ��Ȭ� 0
	
	@Override
	public void onClick(View v) {	// �b�o�̼��g��ť���������w�q�� onClick ��k
		txv.setText(String.valueOf(++counter));		// �N�p�ƭȥ[ 1, �M���ন�r����ܥX�� 																				
	}
	
	@Override 
	public boolean onLongClick(View v) {
		// ��@���� (OnLongClickListener) �����w�q����k
		if (v.getId() == R.id.textView1) {
		// �P�_�ӷ�����O�_����ܭp�ƭȪ� TextView, �Y�O�N�N�p���k�s
			
			counter = 0;
			txv.setText("0");
		}
		else {		// �ӷ����󬰫��s, �N�p�ƭȥ[ 2	
			counter += 2;
			txv.setText(String.valueOf(counter));
		}
		return true;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.textView1);	// ��X�n�ާ@������
        btn = (Button)findViewById(R.id.button1);		// ��X�n�ާ@������
        
        btn.setOnClickListener(this);	
        // �n�� (set) ��ť����, this ��� MainActivity ���󥻨�
        btn.setOnLongClickListener(this);
        // �N MainActivity ����n�������s��������ť��
        txv.setOnLongClickListener(this);
        // �N MainActivity ����n������r���Ҫ�������ť��
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

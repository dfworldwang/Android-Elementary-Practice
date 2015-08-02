package com.example.ch04_ezcounterplus2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// �ƥ�o�ͪ��ӷ�, �٬��Өƥ󪺨ӷ�����. �p�G�Q�n�B�z�o�Өƥ�,
// �����ǳƤ@�ӯ�B�z�Өƥ󪺺�ť����(�κ٬���ť��, Listener), �M��N���n����ӷ�����,
// Android �w�ƥ����U�ӱ`�Ϊ�����w�q�X�\�h�n����ť���󪺤�k. �Ҧp, 
// Button �N�w�q�� setOnClickListener() ��k, �i�H�Ψӵn��(set) [���@�U]�ƥ󪺺�ť����.

public class MainActivity extends ActionBarActivity 
		implements OnClickListener {	
	// �ŧi�n��@ OnClickListener ����������ť����

	TextView txv;		// �ΨӾާ@ textView1 �����ܼ� 
	Button btn;			// �ΨӾާ@ button1 �����ܼ�    
	int counter = 0;	// �Ψ��x�s�p�ƪ���, ��Ȭ� 0
	
	@Override
	public void onClick(View v) {	// �b�o�̼��g��ť���������w�q�� onClick ��k  
		counter += 2;
		txv.setText(String.valueOf(counter));	// �ন�r����ܥX�� 
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.textView1);	// ��X�n�ާ@������
        btn = (Button)findViewById(R.id.button1);		// ��X�n�ާ@������
        btn.setOnClickListener(this);
        txv.setOnClickListener(this);
        // �n�� (set) ��ť����, this ��� MainActivity ���󥻨�
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

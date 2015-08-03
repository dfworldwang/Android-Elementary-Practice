package com.example.ch04_ezcounterplus2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

// �ƥ�o�ͪ��ӷ�, �٬��Өƥ󪺨ӷ�����. �p�G�Q�n�B�z�o�Өƥ�,
// �����ǳƤ@�ӯ�B�z�Өƥ󪺺�ť����(�κ٬���ť��, Listener), �M��N���n����ӷ�����,
// Android �w�ƥ����U�ӱ`�Ϊ�����w�q�X�\�h�n����ť���󪺤�k. �Ҧp, 
// Button �N�w�q�� setOnClickListener() ��k, �i�H�Ψӵn��(set) [���@�U]�ƥ󪺺�ť����.
// �n�B�z�����ƥ�, �����ǳƤ@�ӹ�@ OnLongClickListener ��������ť����, 
// �åB��@�����w�q�� onLongClick() ��k:

// View ���O������, �i�H�ϥ� getId() ��k���o�ӷ����󪺸귽 ID, �ǥѸ귽 ID �N�i�H�ϧO�޵o�ƥ󪺤���

// �����p�ƭȱN�p�ƭȴ�1, �������s�N�p�ƭȥ[2

public class MainActivity extends ActionBarActivity 
		implements OnLongClickListener {	
	// �ŧi�n��@ OnClickListener ����������ť����
	// ��@ OnLongClickListener ����

	TextView txv;		// �ΨӾާ@ textView1 �����ܼ� 
	Button btn;			// �ΨӾާ@ button1 �����ܼ�    
	int counter = 0;	// �Ψ��x�s�p�ƪ���, ��Ȭ� 0
	
	
	@Override
	public boolean onLongClick(View v) {
		// ��@���� (OnLongClickListener) �����w�q����k
		if (v.getId() == R.id.textView1) {
		// �P�_�ӷ�����O�_����ܭp�ƭȪ� TextView, �Y�O�N�N�p�ƴ�@
			counter--;
			txv.setText(String.valueOf(counter));
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
        
        btn.setOnLongClickListener(this);
        // �N MainActivity ����n�������s��������ť��
        txv.setOnLongClickListener(this);
        // �N MainActivity ����n������ܼƦr��������ť��
        
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

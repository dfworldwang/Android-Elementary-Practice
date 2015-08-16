package com.example.ch07_dialogask;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

// Alert ��͵����̦h�i�H�[�J 3 �ӫ��s, ���O�N��_(Negative), ����(Neutral), �άO(Positive)
// �[�J����k�h�� setXxxButton(), 
// �H�W��k���ĤG�ӰѼƥ����ǤJ��@ DialogInterface.OnClickListener ����������, 
// �H�������U�ӫ��s�ɪ� onClick ��ť��. �Y�� null ��ܤ��B�z�o�ӫ��s�ƥ�.

// �n�� MainActivity ��ť��͵������s���ƥ�, 
// �N�n���� MainActivity ��@ DialogInterface.OnClickListener ����:

public class MainActivity extends ActionBarActivity 
		implements DialogInterface.OnClickListener {	// ��@��ť����

	TextView txv;		// �O���w�]�� TextView ����
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.answer);		// ��X�w�]�� TextView
        
        new AlertDialog.Builder(this)			// �إ� Builder ����
        	.setMessage("�A���wAndroid�����?")		// �]�w��ܰT��
        	.setCancelable(false)				// �T�Ϊ�^��������͵�
        	.setIcon(android.R.drawable.ic_menu_edit)	// �ĥΤ��ت��ϥ�
        	.setTitle("Android �ݨ��լd")			// �]�w��͵������D
        	.setPositiveButton("���w", this)		// �[�J�֩w���s�ú�ť�ƥ�
        	.setNegativeButton("�Q��", this)		// �[�J�_�w���s�ú�ť�ƥ�
        	.setNeutralButton("�S�N��", null)		// ����ť���ʫ��s
        	.show();							// ��ܥ�͵�
        
    }
    
    @Override
    public void onClick(DialogInterface dialog, int id) {	// ��@��ť�����w�q����k
    	
    	if (id == DialogInterface.BUTTON_POSITIVE) {	// �p�G���U�֩w��[���w]
    		
    		txv.setText("�A���wAndroid���");
    	}
    	else if (id == DialogInterface.BUTTON_NEGATIVE) {	// �p�G���U�_�w��[�Q��]
    		
    		txv.setText("�A�Q��Android���");
    	}
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

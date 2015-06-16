package com.example.ch05_foodmenu2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void takeOrder(View v) {
    	CheckBox chk;
    	String msg = "";			// �s��n��ܦb�e���W����r�T��
    	// �ΰ}�C�s��Ҧ� CheckBox ���� ID
    	int[] id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
    	
    	for (int i:id) {	// �H�j��v�@�˵��U CheckBox �O�_�Q���
    		chk = (CheckBox)findViewById(i);
    		if (chk.isChecked())		// �Y���Q���
    			msg += "\n" + chk.getText();		// �N����r���οﶵ��r
    												// ���[�� msg �r��᭱ 
    	}
    	
    	if (msg.length() > 0)		// ���I�\ (�r����פj��0)
    		msg = "�A�I�ʪ��\�I�O: " + msg;
    	else
    		msg = "���I�\! ";
    	
    	// �b��r���������I�ʪ�����
    	((TextView)findViewById(R.id.showOrder)).setText(msg);
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

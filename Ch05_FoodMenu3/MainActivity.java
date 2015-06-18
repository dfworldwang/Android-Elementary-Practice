package com.example.ch05_foodmenu2;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �Ҧ��֨���� ID ���}�C
        int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4,
        		R.id.chk5, R.id.chk6, R.id.chk7, R.id.chk8};
        
        for (int id:chk_id) {		// �ΰj����Ҧ��֨�������U��ť����																						
        	CheckBox chk = (CheckBox)findViewById(id);
        	chk.setOnCheckedChangeListener(this);
        }
    }
    
    // �Ψ��x�s�w������ت����X����
    ArrayList<CompoundButton> selected = new ArrayList<CompoundButton>();
    
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    	
    	if (isChecked == true)				// �Y���سQ���
    		selected.add(buttonView);		// �[�춰�X����
    	else								// �Y���سQ����
    		selected.remove(buttonView);	// �۶��X������
    }
    
    public void takeOrder(View v) {
    	
    	String msg = "";			// �x�s�T�����r��
    	
    	for (CompoundButton chk:selected)		// �H�j��v�@�N����r����
    		msg += "\n" + chk.getText();		// �ﶵ��r���[�� msg �r��᭱
    	
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

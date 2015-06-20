package com.example.ch05_foodmenu4;

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
        
        int[] chk_id = {R.id.chk1, R.id.chk2, R.id.chk3, R.id.chk4};
        for (int id:chk_id)		// ���C�� CheckBox ���U��ť����
        	((CheckBox)findViewById(id)).setOnCheckedChangeListener(this);
    }

    int items = 0;		// �O���ثe����\�I���ƶq
    public void onCheckedChanged(CompoundButton chk, boolean isChecked) {
    	int visible;		// CheckBox ��ܪ��A
    	if (isChecked) {	// �Q�����
    		items++;		// �ƶq�[ 1
    		visible = View.VISIBLE;
    		// ���ϥΪ� Visibility �ݩʭȬ� VISIBLE (�i��)
    	}
    	else {				// �Q������
    		items--;		// �ƶq�� 1
    		visible = View.GONE;
    		// ���ϥΪ� Visibility �ݩʭȬ� GONE (���i��)
    	}
    	
    	switch (chk.getId()) {
    	// �̿�����ت��귽 ID, �M�w�n��諸 ImageView
    	
    	case R.id.chk1:
    		findViewById(R.id.output1).setVisibility(visible);
    		break;
    	case R.id.chk2:
    		findViewById(R.id.output2).setVisibility(visible);
    		break;
    	case R.id.chk3:
    		findViewById(R.id.output3).setVisibility(visible);
    		break;
    	case R.id.chk4:
    		findViewById(R.id.output4).setVisibility(visible);
    		break;
    	}
    	
    	String msg;
    	if (items > 0)		// ������ؤj�� 0, ��ܦ��I�\���T��
    		msg = "�A�I���\�I�p�U: ";
    	else				// �_�h��ܽ��I�\���T��
    		msg = "���I�\!";
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

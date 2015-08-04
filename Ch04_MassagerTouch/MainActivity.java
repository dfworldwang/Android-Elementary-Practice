package com.example.ch04_massager2;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;


// ������ OnTouchListener, ��ϥΪ̫���ù��ɤ���Y�|�}�l�_��, �����}�άO�_�� 5 ����
// OnTouchListener �������w�q�� onTouch() ��k:
// �䤤�Ѽ� v �O�ƥ�ӷ�����, �� e �O�x�s��Ĳ����T������. ���O e.getAction() ��k�i�H���oĲ�����ʧ@����
// MotionEvent.ACTION_DOWN, �N��ܬ����Ĳ�I��ù�, MotionEvent.ACTION_UP, �h��������}�ù�

// �n������_��, �i���� getSystemService(Context.VIBRATOR_SERVICE)�Ө��o Vibrator �_�ʪ���

public class MainActivity extends ActionBarActivity 
		implements OnTouchListener {
	
	@Override
	public boolean onTouch(View v, MotionEvent e) {
	// ��@ OnTouchListener Ĳ����ť����������k
		Vibrator vb = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
										// ���U�ù���������r
			vb.vibrate(5000);			// �_�� 5 ��
		}
		else if (e.getAction() == MotionEvent.ACTION_UP) {
										// ��}�ù���������r
			vb.cancel();				// ����_��
		}
		return true;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView txv = (TextView)findViewById(R.id.textView1);
        txv.setOnTouchListener(this);		// �n��Ĳ����ť����
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

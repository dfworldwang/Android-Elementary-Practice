package com.example.ch06_tickettwospinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

// �إ� Spinner �����, �u�ݳ]�w�@�� Entries �ݩʧY�i�ϥ�, �������b values/strings.xml ���إߦr��}�C
// �A�N�}�C�W�٫��w�� Entries �ݩ�,
// �i�ϥ� getSelectedItemPosition() ��k���o Spinner ���󤤿�������د��޽s��   

public class MainActivity extends ActionBarActivity {
	
	TextView txv;
	Spinner cinema, time;		// ���|, �����M�檫��

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.txv);
        cinema = (Spinner)findViewById(R.id.cinema);
        time = (Spinner)findViewById(R.id.time);
    }

    public void order(View v) {
    	
    	String[] cinemas = getResources().getStringArray(R.array.cinemas);
    	// ���o�r��귽�����r��}�C
    	// ���o���|�r��}�C
    	String[] times = getResources().getStringArray(R.array.times);
    	// ���o�����r��}�C
    	int idxCinema = cinema.getSelectedItemPosition();	// ��������|
    	int idxTime = time.getSelectedItemPosition();		// ���������
    	txv.setText("�q" + cinemas[idxCinema] + times[idxTime] + "����");
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

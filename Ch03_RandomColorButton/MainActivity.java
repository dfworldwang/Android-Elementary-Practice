package com.example.ch03_randomcolorbutton;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	TextView txvR, txvG, txvB;
	Button btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ���o 3 �� TextView ������, ������C�⪺ Button
        txvR = (TextView)findViewById(R.id.txvR);
        txvG = (TextView)findViewById(R.id.txvG);
        txvB = (TextView)findViewById(R.id.txvB);
        btn = (Button)findViewById(R.id.button1);
    }

    public void changeColor(View v) {
    	
    	// ���o�üƪ���, ����3�Ӷüƭ�(rgb��)
    	Random x = new Random();
    	int red = x.nextInt(256);			// ��0 ~ 255�������ü�
    	txvR.setText("��: " + red);			// ��ܶüƭ�
    	txvR.setTextColor(Color.rgb(red, 0, 0));	// �N��r�]���ü��C(��)���
    	
    	int green = x.nextInt(256);
    	txvG.setText("��: " + green);
    	txvG.setTextColor(Color.rgb(0, green, 0));	// �N��r�]���ü��C(��)���
    	
    	int blue = x.nextInt(256);
    	txvB.setText("��: " + blue);
    	txvB.setTextColor(Color.rgb(0, 0, blue));	// �N��r�]���ü��C(��)���
    	
    	btn.setTextColor(Color.rgb(red, green, blue));		// ���s�C�� 
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
        if (id == R.id.txvR) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

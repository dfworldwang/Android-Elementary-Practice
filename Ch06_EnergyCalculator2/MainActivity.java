package com.example.ch06_energycalculator2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
		implements OnItemSelectedListener {

	double[] energyRate = {3.1, 4.4, 13.2, 9.7, 5.1, 3.7};
	EditText weight, time;			// �魫�ιB�ʮɶ����
	TextView total, txvRate;		// ��ܯ�q���Ӳv, �p�⵲�G�� TextView
	Spinner sports;					// �B�ʶ��زM��
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �]�w�ܼƪ��
        weight = (EditText)findViewById(R.id.weight);
        time = (EditText)findViewById(R.id.timeSpan);
        total = (TextView)findViewById(R.id.total);
        txvRate = (TextView)findViewById(R.id.txvRate);
        sports = (Spinner)findViewById(R.id.sports);
        sports.setOnItemSelectedListener(this);			// ���U��ť��
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, 
    		int position, long arg3) {
    	// ��ܿ�����B�ʶ��ت��򥻯�q���Ӳv
    	txvRate.setText(String.valueOf(energyRate[position]));
    }
    
    public void onNothingSelected(AdapterView<?> arg0) {
    	// ���ƥ��k���|�Ψ�, �����ݩw�q�@�ӨS�����e����k
    }
    
    public void calc(View v) {
    	// ���o�ϥΪ̿�J���魫
    	double w = Double.parseDouble(weight.getText().toString());
    	// ���o�ϥΪ̿�J���B�ʮɶ�����
    	double t = Double.parseDouble(time.getText().toString());
    	
    	int selected = sports.getSelectedItemPosition();
    	// ���o�ثe������ت�����
    	
    	// �p����ӯ�q = ��q���Ӳv * �魫 * �B�ʮɶ�����
    	long consumedEnergy = Math.round(energyRate[selected]*w*t);
    	
    	total.setText(String.format("���ӯ�q\n %d�a�d", consumedEnergy));
    	// ��ܭp�⵲�G
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

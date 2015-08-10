package com.example.ch06_arrayadapterdrink;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

// �n�b�{�����檺�ɭ��ܰ� Spinner ����ܶ���, �����ǧU ArrayAdapter ����,
// ���|�q���w����ƨӷ������X�C�@�����, �A���ѵ� Spinner �������:

// �ϥ� ArrayAdapter ���Ĥ@�ӨB�J�N�O�إ� ArrayAdapter ������, 
// �� 2 �ӰѼƳq�`���O�ϥΨt�δ��Ѫ� android.R.layout.simple_spinner_item �G��

// Spinner �|�b�ϥΪ��I���H�����ܩҦ�������, ���������]�w�w�q��ܼ˦����G����, 
// �����I�s ArrayAdapter ���O�� setDropDownViewResource() ��k:   

// �٭n�N�ئn�� ArrayAdapter ������Ѽ�, �I�s Spinner ���O�� setAdapter() ��k, 
// �]�w Spinner �n�ϥΪ� ArrayAdapter ����.

public class MainActivity extends ActionBarActivity 
		implements OnItemSelectedListener {
	
	Spinner drink, temp;	// ��ܶ��~���ػP�ū׿ﶵ�� Spinner
	TextView txv;			// ��ܭq�椺�e�� TextView
	String[] tempSet1 = { "�B", "�h�B", "��" };		// �T�طū�
	String[] tempSet2 = { "�B", "�h�B" };			// ��طū�
	String[] drinks = {"�ï]����", "�i�Q����", "�P��ᥤ��", "�f�c��"};		// ����

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txv = (TextView)findViewById(R.id.order);
        temp = (Spinner)findViewById(R.id.temp);	// ���o��ܷūת� Spinner
        drink = (Spinner)findViewById(R.id.drink);	// ���o��ܶ��~���ت� Spinner
        
        ArrayAdapter<String> drinkAd = 
        	new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, drinks);
        // �إ߶��ƫ~���� ArrayAdapter
        drinkAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // ��涵�ت��ﶵ�˦�
        drink.setAdapter(drinkAd);		// �]�w�ϥ� Adapter ����
        
        drink.setOnItemSelectedListener(this);		// �]�w��ť����ƥ�
    }
    
    public void onItemSelected(AdapterView<?> sv, View v, int pos, long id) {
    	
    	String[] tempSet;
    	if (pos == 3)				// �Y����f�c�� (�M�椤�� 4 �Ӷ���)
    		tempSet = tempSet2;		// �ū׿ﶵ�S��[��]
    	else
    		tempSet = tempSet1;
    	
    	ArrayAdapter<String> tempAd = 
    			new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tempSet);
    	// �̾ڷū׿ﶵ�إ� ArrayAdapter
    	// ��楼���}�ɪ���ܼ˦�
    	// �ū׿ﶵ
    	tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	// �]�w�U�Կ�檺�ﶵ�˦�
    	temp.setAdapter(tempAd);		// �]�w�ϥ� Adapter ����
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {	// ���B�z
    	
    }
    
    public void showOrder(View v) {
    	// �N���ƦW�٤ηū׿�ܲզ��@�Ӧr��
    	String msg = drink.getSelectedItem() + ", " + temp.getSelectedItem();
    	// ���o���ƦW��, ���o���׿ﶵ
    	
    	// �N�q�椺�e��ܦb��r�����
    	txv.setText(msg);
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

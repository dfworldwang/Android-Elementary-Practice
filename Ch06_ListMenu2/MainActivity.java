package com.example.ch06_listmenu2;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
	implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ���o ListView ����, �ó]�w���U�ʧ@����ť��
        ListView lv = (ListView)findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
    }

    ArrayList<String> selected = new ArrayList<String>();
    // �x�s�w���������(�\�I)�W�٦r��
    
    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int position,
    		long id) {
    	TextView txv = (TextView)v;		// �N�Q���U�� View �����ন TextView ����
    	
    	String item = txv.getText().toString();		// ���o���ؤ�����r
    	
    	if (selected.contains(item))	// �Y selected ���w���P�W����
    		selected.remove(item);		// �N�N������
    	else							// �Y selected �S���P�W����
    		selected.add(item);			// �N�N���[�� selected ��,
    									// �����w������ت��@��
    	
    	String msg = "";
    	if (selected.size() > 0) {		// �Y selected �������ؼƤj�� 0
    		msg = "�A�I�F:";
    		for (String str:selected)
    			msg += " " + str;
    		// �C�Ӷ��� (�\�I) �W�٫e�Ť@��, �ê��[��T���r��᭱ 
    	} 
    	else 							// �Y selected �������ؼƵ��� 0
    		msg = "���I�\!";
    	
    	TextView msgTxv = (TextView)findViewById(R.id.msgTxv);
    	msgTxv.setText(msg);			// ��ܰT���r��
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

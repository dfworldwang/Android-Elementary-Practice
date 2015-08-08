package com.example.ch06_movielistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

// ListView (�M����) �O�H���C���覡��ܸ�ƪ�����
// ListView ���w�]�欰�S������ƥ�. �ϥΪ̫��U�M�涵��Ĳ�o���O���@�U�ƥ�, �ӫD����ƥ�.
// �n��ť���ƥ�, ������ setOnItemClickListener()
// ��ť����Ѽƻݹ�@�������� OnItemClickListener, 
// ������@����k�u��: onItemClick(AdapterView<?> parent, View view, int position, long id)
// parent �N�� ListView ���󥻨�

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

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, 
    		int position, long id) {
    	
    	// �N�Q���U�� View �����ন TextView
    	TextView txv = (TextView)v;
    	TextView msgTxv = (TextView)findViewById(R.id.msgTxv);
    	msgTxv.setText("�q" + txv.getText() + "����");		// ��ܰT���r��
    	
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

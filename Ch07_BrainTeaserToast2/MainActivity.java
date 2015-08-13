package com.example.ch07_brainteasertoast;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

// Toast ���Ѧ��K�Q�� makeText() ��k, �i�H���w�n��ܪ��T���H����ܪ��ɶ����u�᪽���إߤ@�� Toast ����,
// �A�I�s�o�Ӫ��� show() ��k�Y�i��ܰT��,

// �ϥΪ̦b�s���I��h�Ӱ��D��, ����ߧY��̫ܳ��I�諸����

public class MainActivity extends ActionBarActivity 
		implements OnItemClickListener {

	String[] queArr = {"������û������W?", "����F��S�H�R�Y?", "����ʤ���Y?",
			"���򥬤����_?", "���򹫳̷R���b?", "�����򤣥Ǫk?"};	// �إ߰��D�}�C
	String[] ansArr = { "�y��", "��", "�̥�", "�r��", "���O�p", "����" };
	// �إߵ��װ}�C
	Toast tos;			// �ŧi Toast ���� 
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayAdapter<String> adapter = 
        		new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, queArr);
        // �إߨ� ListView �ϥΪ� ArrayAdapter ����
        // �ϥΤ��ت��G���귽
        // �H queArr �}�C���ƨӷ�
        
        ListView lv = (ListView)findViewById(R.id.lv);		// ���o ListView
        lv.setAdapter(adapter);			// �]�w ListView �ϥΪ� Adapter
        lv.setOnItemClickListener(this);	
        // �]�w ListView ���سQ���ɪ��ƥ��ť��
        tos = Toast.makeText(this, "", Toast.LENGTH_SHORT);		// �إ� Toast ����  
    }

    @Override
    public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
    	
    	tos.setText("����:" + ansArr[pos]);	// �ܧ� Toast ���󪺤�r���e
    	tos.show();							// �ߧY���s���
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

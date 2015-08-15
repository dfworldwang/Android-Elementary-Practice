package com.example.ch07_dialogshow;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// [��͵�](Dialog) �i�H�Ψ���ܤ@�q�T��, �ín�D�ϥΪ̿�J�@�Ǹ�T
// ���ɿ�J�J�I�|�����b��͵��W, ��������͵�������, �ϥΪ̤~��i���L���ާ@.

// AlertDialog ���O�i�H��ܥX�H�U�X�ض���: 
// ���D: �i�]�t��r�ιϥ�(�]�i���S��)
// ���e: �@�q��r�T��, �Τ@�ӥi��ܪ��M����
// ���s: �i�]�t 0 ~ 3 �ӫ��s(�]�i���S��)

// �n��� Alert ��͵�, �Х��ϥ����O AlertDialog.Builder �إ� AlertDialog.Builder ����, 
// �M��Φ�����ӳ]�w��͵��һݪ��������ݩʫ�, �A���͹�ڪ� AlertDialog �������ܥX��.

// AlertDialog.Builder ���� setCancelable() ��k: �]�w�i����^��������͵�
// �Y�ǤJ true �I�s����k, ��ܨϥΪ̥i���������^��������͵�
// �Y�ǤJ false, ��͵��W�N�������Ѩ������s, �_�h�ϥΪ̱N�L�k������͵�.

// �]�w�n��͵��һݪ������P�ݩʫ�, �Y�i�I�s AlertDialog.Builder �� show() ��k�إ� AlertDialog ����,
// ����k�|�۰ʩI�s AlertDialog �� show() ��k��ܥ�͵�.      

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("��͵��ܽd�о�!\n" + "�Ы���^��������͵�");			// �[�J��r�T��
        bdr.setTitle("�w��");			// �[�J���D
        bdr.setIcon(android.R.drawable.presence_away);			// �[�J�ϥ�
        bdr.setCancelable(true);		// ���\����^��������͵�
        bdr.show();
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

package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.org.prism.insurancemodule.R;

public class MainActivity extends Activity {

    private Button bt_firstflow;
    private Button bt_secondflow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnClickListener();
    }

    private void initView() {
        bt_firstflow = (Button) findViewById(R.id.bt_firstflow);
        bt_secondflow = (Button) findViewById(R.id.bt_secondflow);
    }

    private void setOnClickListener() {
        bt_firstflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyInsuranceBuyNothingActivity.class);
                startActivity(intent);
            }
        });
        bt_secondflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsuranceWithFragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}

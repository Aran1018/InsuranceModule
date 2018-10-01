package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.org.prism.insurancemodule.R;

public class LargePictureActivity extends Activity {
    private Button btn_backto_myreportactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_largepicture);
        initView();
    }
    private void initView(){
        btn_backto_myreportactivity = findViewById(R.id.btn_backto_myreportactivity);
        btn_backto_myreportactivity.setOnClickListener(new MyClickListenr());
    }
    private class MyClickListenr implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            finish();
        }
    }

}

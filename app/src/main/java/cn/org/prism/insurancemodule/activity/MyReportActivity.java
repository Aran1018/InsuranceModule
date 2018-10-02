package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;

public class MyReportActivity extends Activity {
    private Title title;
    private ImageView iv_myreport;
    private TextView tv_buynow;
    private Intent intent;
    private RelativeLayout rl_buynow;
    private FrameLayout fl_myreport;
    private FrameLayout fl_largepicture;
    private Button btn_backto_myreportactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myreport);
        initView();
    }

    private void initView() {
        rl_buynow = (RelativeLayout) findViewById(R.id.rl_buynow);
        iv_myreport = findViewById(R.id.iv_myreport);
        iv_myreport.setOnClickListener(new MyClickListener());
        tv_buynow = findViewById(R.id.tv_buynow);
        tv_buynow.setOnClickListener(new MyClickListener());
        fl_myreport = findViewById(R.id.fl_myreport);
        fl_largepicture = findViewById(R.id.fl_largepicture);
        btn_backto_myreportactivity = findViewById(R.id.btn_backto_myreportactivity);
        btn_backto_myreportactivity.setOnClickListener(new MyClickListener());
        initTitle();
    }

    private void initTitle() {
        title = findViewById(R.id.title);
        title.setTitleNameStr(getString(R.string.titleStr_MyReportActivity));
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, 0, getString(R.string.titleStr_BackFromMyReportActivity));
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT1, R.mipmap.myinsurance_title_phone, null);
        title.mSetButtonInfo(buttonLeft);
        title.mSetButtonInfo(buttonRight);
    }

    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_myreport:
                    fl_largepicture.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_backto_myreportactivity:
                    fl_largepicture.setVisibility(View.GONE);
                    break;
                case R.id.tv_buynow:
                    intent = new Intent(MyReportActivity.this, PersonalDataActivity.class);
                    startActivity(intent);
                    break;
                case R.id.rl_buynow:
                    Intent intent = new Intent(MyReportActivity.this, PersonalDataActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    }

}

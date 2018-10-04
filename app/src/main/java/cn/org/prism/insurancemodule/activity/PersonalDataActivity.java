package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;


public class PersonalDataActivity extends Activity {
    private RadioButton rbn_alipay;
    private RadioButton rbn_wechatpay;
    private FrameLayout fl_alipay;
    private FrameLayout fl_wechatpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        initView();
    }
    private void initView(){
        initTitle();
        rbn_alipay = findViewById(R.id.rbn_alipay);
        rbn_wechatpay = findViewById(R.id.rbn_wechatpay);
        fl_alipay = findViewById(R.id.fl_alipay);
        fl_wechatpay = findViewById(R.id.fl_wechatpay);
        fl_alipay.setOnClickListener(new MyRadioButtonClickListener());
        fl_wechatpay.setOnClickListener(new MyRadioButtonClickListener());
    }
    private void initTitle(){
        Title title;
        title = findViewById(R.id.title);
        title.setTitleNameStr(getString(R.string.titleStr_MyReportActivity));
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, R.drawable.selector_btn_titleback, null);
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT1, R.mipmap.myinsurance_title_phone, null);
        title.setOnTitleButtonClickListener(new Title.OnTitleButtonClickListener() {
            @Override
            public void onClick(int id, Title.ButtonViewHolder viewHolder) {
                if (id==Title.BUTTON_LEFT)
                    finish();
            }
        });
        title.mSetButtonInfo(buttonLeft);
        title.mSetButtonInfo(buttonRight);
    }
    public class MyRadioButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fl_alipay:
                    rbn_wechatpay.setChecked(false);
                    rbn_alipay.setChecked(true);
                    break;
                case R.id.fl_wechatpay:
                    rbn_wechatpay.setChecked(true);
                    rbn_alipay.setChecked(false);

                    break;

            }
        }
    }

}

package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;


public class PersonalDataActivity extends Activity {
    private RadioButton rbn_left_picture;
    private RadioButton rbn_right_picture;
    private FrameLayout leftlayout;
    private FrameLayout rightlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldata);
        initView();
    }
    private void initView(){
        initTitle();
        rbn_left_picture = findViewById(R.id.rbn_left_picture);
        rbn_right_picture = findViewById(R.id.rbn_right_picture);
        leftlayout = findViewById(R.id.leftlayout);
        rightlayout = findViewById(R.id.rightlayout);
        leftlayout.setOnClickListener(new MyRadioButtonClickListener());
        rightlayout.setOnClickListener(new MyRadioButtonClickListener());
    }
    private void initTitle(){
        Title title = findViewById(R.id.title);
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
        title.setButtonInfo(buttonLeft);
        title.setButtonInfo(buttonRight);
    }
    public class MyRadioButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.leftlayout:
                    rbn_right_picture.setChecked(false);
                    rbn_left_picture.setChecked(true);
                    break;
                case R.id.rightlayout:
                    rbn_right_picture.setChecked(true);
                    rbn_left_picture.setChecked(false);

                    break;

            }
        }
    }

}

package cn.org.prism.insurancemodule.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.widget.Title;


/*暂时不处理该页面*/
public class EditPersonalDataActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_data);
        initTitle();
    }

    private void initTitle() {
        Title title = findViewById(R.id.title);
        title.setTitleNameStr(getString(R.string.editdata));
        Title.ButtonInfo buttonLeft = new Title.ButtonInfo(true, Title
                .BUTTON_LEFT, R.mipmap.navigationbar_back, null);
        Title.ButtonInfo buttonRight = new Title.ButtonInfo(true, Title
                .BUTTON_RIGHT2, R.mipmap.myinsurance_title_phone, null);
        title.setButtonInfo(buttonLeft);
        title.setButtonInfo(buttonRight);
    }
}


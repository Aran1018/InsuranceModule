package cn.org.prism.insurancemodule.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.org.prism.insurancemodule.R;
import cn.org.prism.insurancemodule.fragment.Fragment_historyreport;
import cn.org.prism.insurancemodule.fragment.Fragment_myoffer;
import cn.org.prism.insurancemodule.fragment.Fragment_thisyearreport;
import cn.org.prism.insurancemodule.widget.Title;

public class InsuranceWithFragmentActivity extends Activity {
    private LinearLayout ll_thisyearreport;
    private LinearLayout ll_histroyreport;
    private LinearLayout ll_myoffer;
    private TextView tv_thisyearreport;
    private TextView tv_historyreport;
    private TextView tv_myoffer;
    private Fragment Ff = new Fragment_thisyearreport();
    private Fragment Fs = new Fragment_historyreport();
    private Fragment Ft = new Fragment_myoffer();
    private Title title;

    private final int ID_FRAGMENT = R.id.fl_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_with_fragment);
        initView();
        setDefaultFragment();
    }
    public void initView(){
        initTitle();
        ll_thisyearreport = findViewById(R.id.ll_thisyearreport);
        ll_histroyreport = findViewById(R.id.ll_histroyreport);
        ll_myoffer = findViewById(R.id.ll_myoffer);
        tv_thisyearreport = findViewById(R.id.tv_thisyearreport);
        tv_historyreport = findViewById(R.id.tv_historyreport);
        tv_myoffer = findViewById(R.id.tv_myoffer);
        ll_thisyearreport.setOnClickListener(new MyClickListener());
        ll_histroyreport.setOnClickListener(new MyClickListener());
        ll_myoffer.setOnClickListener(new MyClickListener());

    }
    private void initTitle(){
        title = findViewById(R.id.title);
        title.setTitleNameStr(getString(R.string.titleStr_InsuranceWithFragmentActivity));
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
    private void setDefaultFragment(){
        FragmentManager ff = getFragmentManager();
        android.app.FragmentTransaction transaction = ff.beginTransaction();
        transaction.replace(R.id.fl_fragment,Ff).commit();
    }
    private class MyClickListener implements View.OnClickListener{

        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_thisyearreport:
                    setLeftChecked();
                    setDefaultFragment();
                    break;
                case R.id.ll_histroyreport:
                    setMiddleChecked();
                    setFragment(Fs,ID_FRAGMENT);
                    break;
                case R.id.ll_myoffer:
                    setRightChecked();
                    setFragment(Ft,ID_FRAGMENT);
                    break;

            }
        }
    }
    @SuppressLint("NewApi")
    private void setLeftChecked(){
        tv_historyreport.setTextColor(getColor(R.color.item_rightText));
        ll_histroyreport.setBackgroundColor(getColor(R.color.white));
        tv_myoffer.setTextColor(getColor(R.color.item_rightText));
        ll_myoffer.setBackgroundColor(getColor(R.color.white));
        tv_thisyearreport.setTextColor(getColor(R.color.white));
        ll_thisyearreport.setBackgroundColor(getColor(R.color.item_rightText));
    }
    @SuppressLint("NewApi")
    private void setMiddleChecked(){
        tv_thisyearreport.setTextColor(getColor(R.color.item_rightText));
        ll_thisyearreport.setBackgroundColor(getColor(R.color.white));
        tv_myoffer.setTextColor(getColor(R.color.item_rightText));
        ll_myoffer.setBackgroundColor(getColor(R.color.white));
        tv_historyreport.setTextColor(getColor(R.color.white));
        ll_histroyreport.setBackgroundColor(getColor(R.color.item_rightText));
    }
    @SuppressLint("NewApi")
    private void setRightChecked(){
        tv_thisyearreport.setTextColor(getColor(R.color.item_rightText));
        ll_thisyearreport.setBackgroundColor(getColor(R.color.white));
        tv_historyreport.setTextColor(getColor(R.color.item_rightText));
        ll_histroyreport.setBackgroundColor(getColor(R.color.white));
        tv_myoffer.setTextColor(getColor(R.color.white));
        ll_myoffer.setBackgroundColor(getColor(R.color.item_rightText));
    }

    private void setFragment(Fragment fragment,int id){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(id,fragment).commit();

    }
}

package com.ADA.activity;

import java.util.SortedMap;

import com.ADA.mbh.R;

import android.R.anim;
import android.R.color;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SetPerActivity extends BaseActivity {

    //�������ã�ȷ��������
    private Button IB_Set;
    private Button IB_Confirm;
    private Button IB_Cancel;

    private ImageView IV_BoyOrGril;
    //�Ա����䣬��ߣ�
    private LinearLayout IV_Sex;
    private LinearLayout IB_Age;
    private LinearLayout IB_Height;
    private LinearLayout IB_Weight;

    //ʱ�䣬���룬��������
    private View Time_Layout;
    private View Hot_Layout;
    private View Distance_Layout;
    private TextView TV_Time_Show;
    private TextView TV_Hot_Show;
    private TextView TV_Distance_Show;

    //��ʾ��
    public static String Temp = "";//��ż���������ַ�����Ȼ������жϷ����Ӧ��������
    public String Type;                            //����Ҫ��������ͣ����䣻 ��ߣ� ���أ�ʱ�䣻���룻����
    public String Flag;                            //����Ҫ��������ͣ����䣻 ��ߣ� ���أ�ʱ�䣻���룻����
    private TextView TV_Age_Show;
    public static String Age_Text = "";
    private TextView TV_Height_Show;
    public static String Height_Text = "";
    private TextView TV_Weight_Show;
    public static String Weight_Text = "";
    //ʱ���������
    public static String Time_Text = "";
    public static String Hot_Text = "";
    public static String Distance_Text = "";
    //���ݸ�TaskActivity��Ŀ������
    public static String GoalShow = "";

    //���̲���
    private View RL_Keyboard_Layout;
    //���̰�ť
    private Button Btn_One;
    private Button Btn_Two;
    private Button Btn_Three;
    private Button Btn_Four;
    private Button Btn_Five;
    private Button Btn_Six;
    private Button Btn_Seven;
    private Button Btn_Eight;
    private Button Btn_Nine;
    private Button Btn_Zero;
    private Button Btn_Point;
    private Button Btn_Delete;
    private Button Btn_Enter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_per);

        //�̳еĳ�ʼ��
        InitBase();
        BaselistionEvent();
        //��ʼ��
        init();
        inItShow();
        listionEvent();
    }

    private boolean isBoy=true;

    private void listionEvent() {
        // TODO Auto-generated method stub
        IV_Sex.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                isBoy=!isBoy;
                Flag = "IV_Sex";
                if(isBoy){
                    ((TextView)IV_Sex.getChildAt(1)).setText(getString(R.string.str_boy));
                    IV_BoyOrGril.setImageResource(R.drawable.man_nospace);
                }else{
                    ((TextView)IV_Sex.getChildAt(1)).setText(getString(R.string.str_girl));
                    IV_BoyOrGril.setImageResource(R.drawable.woman_nospace);
                }
                //setBackgroundResource();
            }
        });

	/*
     *������ ������䣬��ߣ������¼�
	 */
        //���IB_Age���༭����
        IB_Age.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ʾ����
                Flag = "IB_Age";
                Temp = "";//�м��������
                RL_Keyboard_Layout.setVisibility(View.VISIBLE);
                //TV_Age_Show.setBackgroundResource(R.drawable.age_text);
                //TV_Age_Show.setBackgroundColor(Color.argb(255, 0, 255, 0));
                //setBackgroundResource();
            }
        });

        //���IIB_Height���༭���
        IB_Height.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ʾ����
                Flag = "IB_Height";
                Temp = "";//�м��������
                RL_Keyboard_Layout.setVisibility(View.VISIBLE);
                //TV_Height_Show.setBackgroundResource(R.drawable.height_text);
                //setBackgroundResource();
            }
        });

        //���IIB_Weight���༭����
        IB_Weight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ʾ����
                Flag = "IB_Weight";
                Temp = "";//�м��������
                RL_Keyboard_Layout.setVisibility(View.VISIBLE);
                //TV_Weight_Show.setBackgroundResource(R.drawable.weight_text);
                //setBackgroundResource();
            }
        });

        Time_Layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ʾ����
                Flag = "Time_Layout";
                Temp = "";//�м��������
                RL_Keyboard_Layout.setVisibility(View.VISIBLE);
                //TV_Time_Show.setBackgroundResource(R.drawable.time_text);
                //setBackgroundResource();
            }
        });

        Hot_Layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ʾ����
                Flag = "Hot_Layout";
                Temp = "";//�м��������
                RL_Keyboard_Layout.setVisibility(View.VISIBLE);
                //TV_Hot_Show.setBackgroundResource(R.drawable.hot_text);
                //setBackgroundResource();
            }
        });

        Distance_Layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //��ʾ����
                Flag = "Distance_Layout";
                Temp = "";//�м��������
                RL_Keyboard_Layout.setVisibility(View.VISIBLE);
                //TV_Distance_Show.setBackgroundResource(R.drawable.distance_text);
                //setBackgroundResource();
            }
        });

	/*
	 * ���������̵���¼�
	 */
        //��� 1
        Btn_One.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Temp += "1";
                Sort();
            }
        });

        //��� 2
        Btn_Two.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "2";
                Sort();
            }
        });

        //��� 3
        Btn_Three.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "3";
                Sort();
            }
        });

        //��� 4
        Btn_Four.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "4";
                Sort();
            }
        });

        //��� 5
        Btn_Five.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "5";
                Sort();
            }
        });

        //��� 6
        Btn_Six.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "6";
                Sort();
            }
        });

        //��� 7
        Btn_Seven.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "7";
                Sort();
            }
        });

        //��� 8
        Btn_Eight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "8";
                Sort();
            }
        });

        //��� 9
        Btn_Nine.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "9";
                Sort();
            }
        });

        //��� 0
        Btn_Zero.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Temp += "0";
                Sort();
            }
        });

        //��� .
        Btn_Point.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Temp += ".";
//                Sort();
            }
        });

        //���enter��
        Btn_Enter.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                RL_Keyboard_Layout.setVisibility(View.INVISIBLE);

            }
        });

        //���Btn_Delete��
        Btn_Delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(Temp!=null&&Temp.length()>0){
                    Temp = Temp.substring(0, Temp.length() - 1);
                    Sort();
                }
            }
        });

	/*
	 * �����趨��ȷ�������ذ�ť����¼�
	 */
        //����趨��
        IB_Set.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

//                IB_Age.setEnabled(true);
//                IB_Height.setEnabled(true);
//                IB_Weight.setEnabled(true);
            }
        });

        //���ȷ����
        IB_Confirm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

//                IB_Age.setEnabled(false);
//                IB_Height.setEnabled(false);
//                IB_Weight.setEnabled(false);
//
//                TV_Age_Show.setBackgroundResource(R.drawable.age_text_back);
//                TV_Height_Show.setBackgroundResource(R.drawable.height_text_back);
//                TV_Weight_Show.setBackgroundResource(R.drawable.weight_text_back);
//                TV_Time_Show.setBackgroundResource(R.drawable.time_text_back);
//                TV_Hot_Show.setBackgroundResource(R.drawable.hot_text_back);
//                TV_Distance_Show.setBackgroundResource(R.drawable.distance_text_back);


                Intent intent = new Intent();
                intent.setClass(SetPerActivity.this, TaskActivity.class);
                Bundle bundle = new Bundle();
                //����taskActivity,����IB_Type_String��ʾ��Ŀ����
                bundle.putString("IB_Type_String", Type);
                //����taskActivity,����IV_TaskOptionsIcon����Ŀ������
                if (Type.equals("IB_Time") || Type.equals("IB_Burn") || Type.equals("IB_Mountion") || Type.equals("IB_LostWeight")
                        || Type.equals("IB_Interval") || Type.equals("IB_Climbing") || Type.equals("IB_Fluctuate")
                        || Type.equals("IB_Heart_65") || Type.equals("IB_Heart_75") || Type.equals("IB_Heart_85")) {
                    GoalShow = Time_Text;
                    bundle.putString("GoalShow", GoalShow);
                } else if (Type.equals("IB_Hot")) {

                    GoalShow = Hot_Text;
                    bundle.putString("GoalShow", GoalShow);
                } else if (Type.equals("IB_Distance")) {

                    GoalShow = Distance_Text;
                    mHandler.sendEmptyMessage(1);

                    bundle.putString("GoalShow", GoalShow);
                }

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //�������
        IB_Cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SetPerActivity.this.finish();
            }
        });
    }

    private void setBackgroundResource() {
        if(Flag.equals("IV_Sex")){
            IV_Sex.setBackgroundResource(R.drawable.sex_back_ground_onclick);
        }else{
            IV_Sex.setBackgroundResource(R.drawable.sex_back_ground);
        }
        if(Flag.equals("IB_Age")){
            IB_Age.setBackgroundResource(R.drawable.age_back_ground_onclick);
            TV_Age_Show.setBackgroundResource(R.drawable.age_text);
        }else{
            IB_Age.setBackgroundResource(R.drawable.age_back_ground);
            TV_Age_Show.setBackgroundResource(0);
        }
        if(Flag.equals("IB_Height")){
            IB_Height.setBackgroundResource(R.drawable.height_back_ground_onclick);
            TV_Height_Show.setBackgroundResource(R.drawable.height_text);
        }else{
            IB_Height.setBackgroundResource(R.drawable.height_back_ground);
            TV_Height_Show.setBackgroundResource(0);
        }
        if(Flag.equals("IB_Weight")){
            IB_Weight.setBackgroundResource(R.drawable.weight_back_ground_onclick);
            TV_Weight_Show.setBackgroundResource(R.drawable.weight_text);
        }else{
            IB_Weight.setBackgroundResource(R.drawable.weight_back_ground);
            TV_Weight_Show.setBackgroundResource(0);
        }
        if(Flag.equals("Time_Layout")){
            Time_Layout.setBackgroundResource(R.drawable.time_set_onclick);
            TV_Time_Show.setBackgroundResource(R.drawable.time_text);
        }else{
            Time_Layout.setBackgroundResource(R.drawable.time_set);
            TV_Time_Show.setBackgroundResource(0);
        }
        if(Flag.equals("Hot_Layout")){
            Hot_Layout.setBackgroundResource(R.drawable.hot_set_onclick);
            TV_Hot_Show.setBackgroundResource(R.drawable.hot_text);
        }else{
            Hot_Layout.setBackgroundResource(R.drawable.hot_set);
            TV_Hot_Show.setBackgroundResource(0);
        }
        if(Flag.equals("Distance_Layout")){
            Distance_Layout.setBackgroundResource(R.drawable.distance_set_onclick);
            TV_Distance_Show.setBackgroundResource(R.drawable.distance_text);
        }else{
            Distance_Layout.setBackgroundResource(R.drawable.distance_set);
            TV_Distance_Show.setBackgroundResource(0);
        }
    }

    private void inItShow() {
        // TODO Auto-generated method stub

        RL_Big_Layout.setVisibility(View.GONE);
        RL_Big_Layout_Right.setVisibility(View.GONE);
        RL_Middle_Layout.setVisibility(View.GONE);

/**
 * try�жϴ�ModeNowActivity�����activity
 * ��ģʽѡ����룬���ô���
 */
        try {

            Temp = "";//�м��������(���̻�������ɾ��)
            Log.i("����Try ����Try����Try����Try   ", " 000000000000000000000000000000");
            Intent intent = this.getIntent();
            Bundle bundle = intent.getExtras();

            Type = bundle.getString("IB_Type_String");
            if (Type.equals("IB_Time") || Type.equals("IB_Burn") || Type.equals("IB_Mountion") || Type.equals("IB_LostWeight")
                    || Type.equals("IB_Interval") || Type.equals("IB_Climbing") || Type.equals("IB_Fluctuate")
                    || Type.equals("IB_Heart_65") || Type.equals("IB_Heart_75") || Type.equals("IB_Heart_85")) {

                //TV_Time_Show.setBackgroundResource(R.drawable.time_text);
                Hot_Layout.setVisibility(View.GONE);
                Time_Layout.setVisibility(View.VISIBLE);
                Distance_Layout.setVisibility(View.GONE);
                //RL_Keyboard_Layout.setVisibility(View.VISIBLE);
            } else if (Type.equals("IB_Hot")) {

                //TV_Hot_Show.setBackgroundResource(R.drawable.hot_text);
                Hot_Layout.setVisibility(View.VISIBLE);
                Time_Layout.setVisibility(View.GONE);
                Distance_Layout.setVisibility(View.GONE);
                //RL_Keyboard_Layout.setVisibility(View.VISIBLE);
            } else if (Type.equals("IB_Distance")) {

                //TV_Distance_Show.setBackgroundResource(R.drawable.distance_text);
                Hot_Layout.setVisibility(View.GONE);
                Time_Layout.setVisibility(View.GONE);
                Distance_Layout.setVisibility(View.VISIBLE);
                //RL_Keyboard_Layout.setVisibility(View.VISIBLE);
            }
            //RL_Keyboard_Layout.setVisibility(View.GONE);

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
        }

//        //����ť����
//        IB_Age.setEnabled(false);
//        IB_Height.setEnabled(false);
//        IB_Weight.setEnabled(false);

        //������ʾ
        RL_Small_Layout.setVisibility(View.VISIBLE);
        RL_Small_Layout_Right.setVisibility(View.VISIBLE);
        RL_Top_Layout.setVisibility(View.VISIBLE);


    }

    /*
     * ����type�жϵ����˭�����䣬��ߣ����أ���Ȼ����˭������ʾ����
     */
    private void Sort() {
        // TODO Auto-generated method stub
        if(Temp.equals("")) Temp="0";

        if (Flag.equals("IB_Age")) {

            if (Temp.length() > 2) {
                Temp = Temp.substring(0, 2);
            }
            TV_Age_Show.setText(Temp);
            Age_Text = Temp;
            Log.i("SetPerActivity", Age_Text);
        } else if (Flag.equals("IB_Height")) {

            if (Temp.length() > 3) {

                Temp = Temp.substring(0, 3);
            }
            TV_Height_Show.setText(Temp);
            Height_Text = Temp;
            Log.i("SetPerActivity", Height_Text);
        } else if (Flag.equals("IB_Weight")) {

            if (Temp.length() > 3) {
                Temp = Temp.substring(0, 3);
            }
            TV_Weight_Show.setText(Temp);
            Weight_Text = Temp;
            Log.i("SetPerActivity", Weight_Text);
        } else if (Flag.equals("Time_Layout")) {

            if (Temp.length() > 4) {
                Temp = Temp.substring(0, 4);
            }
            TV_Time_Show.setText(Temp);
            //��ȡ��ֵ�����ڴ��ݵ�TaskActivity
            Time_Text = Temp;
        } else if (Flag.equals("Distance_Layout")) {

            if (Temp.length() > 4) {
                Temp = Temp.substring(0, 4);
            }
            TV_Distance_Show.setText(Temp);
            //��ȡ��ֵ�����ڴ��ݵ�TaskActivity
            Distance_Text = Temp;
        } else if (Flag.equals("Hot_Layout")) {

            if (Temp.length() > 4) {
                Temp = Temp.substring(0, 4);
            }
            TV_Hot_Show.setText(Temp);
            //��ȡ��ֵ�����ڴ��ݵ�TaskActivity
            Hot_Text = Temp;
        }
        if(Temp.equals("0")) Temp="";

    }

    /*
     * ��ʼ��
     */
    private void init() {

        //�趨�� ȷ�ϣ�ȡ��
        IB_Set = (Button) findViewById(R.id.IB_Set);
        IB_Confirm = (Button) findViewById(R.id.IB_Confirm);
        IB_Cancel = (Button) findViewById(R.id.IB_Cancel);

        //�Ա����䣬��ߣ�����
        IV_Sex = (LinearLayout) findViewById(R.id.IV_Sex);
        IB_Age = (LinearLayout) findViewById(R.id.IB_Age);
        IB_Height = (LinearLayout) findViewById(R.id.IB_Height);
        IB_Weight = (LinearLayout) findViewById(R.id.IB_Weight);
        //��ʾͼƬ
        IV_BoyOrGril = (ImageView) findViewById(R.id.IV_Boy);

        TV_Age_Show = (TextView) findViewById(R.id.TV_Age_Show);
        TV_Height_Show = (TextView) findViewById(R.id.TV_Height_Show);
        TV_Weight_Show = (TextView) findViewById(R.id.TV_Weight_Show);
        //���̲��ֳ�ʼ��
        RL_Keyboard_Layout = (RelativeLayout) findViewById(R.id.RL_Keyboard_Layout);
        //���̰�����ʼ��
        Btn_One = (Button) findViewById(R.id.Btn_One);

        Btn_Two = (Button) findViewById(R.id.Btn_Two);
        Btn_Three = (Button) findViewById(R.id.Btn_Three);
        Btn_Four = (Button) findViewById(R.id.Btn_Four);
        Btn_Five = (Button) findViewById(R.id.Btn_Five);
        Btn_Six = (Button) findViewById(R.id.Btn_Six);
        Btn_Seven = (Button) findViewById(R.id.Btn_Seven);
        Btn_Eight = (Button) findViewById(R.id.Btn_Eight);
        Btn_Nine = (Button) findViewById(R.id.Btn_Nine);
        Btn_Zero = (Button) findViewById(R.id.Btn_Zero);
        Btn_Point = (Button) findViewById(R.id.Btn_Point);
        Btn_Delete = (Button) findViewById(R.id.Btn_Delete);
        Btn_Enter = (Button) findViewById(R.id.Btn_Enter);

        //ʱ�䣬���룬����
        Time_Layout = (LinearLayout) findViewById(R.id.Time_Layout);
        Hot_Layout = (LinearLayout) findViewById(R.id.Hot_Layout);
        Distance_Layout = (LinearLayout) findViewById(R.id.Distance_Layout);
        TV_Time_Show = (TextView) findViewById(R.id.TV_Time_Show);
        TV_Hot_Show = (TextView) findViewById(R.id.TV_Hot_Show);
        TV_Distance_Show = (TextView) findViewById(R.id.TV_Distance_Show);
    }
}

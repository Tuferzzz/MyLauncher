package com.ADA.activity;

import java.security.PublicKey;
import java.util.concurrent.locks.ReentrantLock;

import javax.security.auth.PrivateCredentialPermission;

import com.ADA.mbh.R;
import com.ADA.util.CircleProgressBar;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends Activity {


    //����
    public String getPassword = "";
    //commen ���ֶ���
    public ImageButton IB_Background_Left_in;
    public ImageButton IB_Background_Left;
    public ImageButton IB_Background_Right_in;
    public ImageButton IB_Background_Right;

    public Button Btn_Back_Bottom;
    public Button Btn_Pause_Bottom;

    public View RL_Big_Layout;
    public View RL_Small_Layout;
    public View RL_Small_Layout_Right;
    public View RL_Big_Layout_Right;
    public View RL_Middle_Layout;
    public View RL_Top_Layout;

    public TextView TV_Gradiend_Show_Top;
    public TextView TV_Distance_Show_Top;
    public TextView TV_Time_Show_Top;
    public TextView TV_Heat_Show_Top;
    public TextView TV_Heart_Show_Top;
    public TextView TV_Speed_Show_Top;
    public TextView TV_Distance;
    public TextView TV_Speed;

    //progressBar�ұ��ٶ�
    public CircleProgressBar PB_Speed;
    public ImageButton IB_Up_Only_Right;
    public ImageButton IB_Up_Both_Right;
    public ImageButton IB_Down_Only_Right;
    public ImageButton IB_Down_Both_Right;
    public static int progressSpeed = 0;
    public ImageView circle_point_imgSpeed;

    //progressBar����¶�
    public CircleProgressBar PB_Gradiend;
    public ImageButton IB_Up_Only;
    public ImageButton IB_Up_Both;
    public ImageButton IB_Down_Only;
    public ImageButton IB_Down_Both;
    public static int progressGradiend = 0;
    public ImageView circle_point_imgGradiend;
//		public TextView TV_GradiendShowLeft;

    public Thread mThread;
    private boolean isRunning = true;
    private Thread myThread;
    private boolean myisRunning = true;

    final public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:

//		        	 TV_GradiendShowLeft.setText("" +progressGradiend);		        	
                    //TV_Gradiend_Show_Top.setText("" +progressGradiend);
                    TV_Speed_Show_Top.setText("" + progressSpeed);
                    break;
                case 1:

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commen);

        InitBase();
        BaselistionEvent();

        ReentrantLock mylock = new ReentrantLock();
        mylock.lock();
        mThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (isRunning) {
                    try {
                        Thread.sleep(100);
//	                    TV_GradiendShowLeft.setText("" +progressGradiend);
//			        	PB_Gradiend.setProgress(progressGradiend,circle_point_img);	
                        mHandler.sendEmptyMessage(0);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        mThread.start();
        mylock.unlock();

//	    
//	    ReentrantLock lock = new ReentrantLock(); 
//	    lock.lock();
//	    myThread = new Thread(new Runnable() {
//
//	        @Override
//	        public void run() {
//	            while (myisRunning) {
//	                try {
//	                    Thread.sleep(100);	                    	                    
//	                  
//	                   
//	                	PB_Speed.setProgress(progressSpeed,circle_point_imgSpeed);	
//			        	
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	            }
//
//	        }
//	    });
//	    myThread.start();
//	    lock.unlock();
    }

    /*
     * �����¼�
     * */
    public void BaselistionEvent() {
        // TODO Auto-generated method stub

        //�¶ȵ���
        IB_Up_Only.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressGradiend += 1;
                PB_Gradiend.setProgress(progressGradiend, circle_point_imgGradiend);
                //TV_GradiendShowLeft.setText("" +progressGradiend);
            }
        });

        //�¶�˫��
        IB_Up_Both.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressGradiend += 2;
                PB_Gradiend.setProgress(progressGradiend, circle_point_imgGradiend);
                //	TV_GradiendShowLeft.setText("" +progressGradiend);
            }
        });

        //�¶ȵ���
        IB_Down_Only.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressGradiend -= 1;
                PB_Gradiend.setProgress(progressGradiend, circle_point_imgGradiend);
                //	TV_GradiendShowLeft.setText("" +progressGradiend);
            }
        });

        //�¶�˫��
        IB_Down_Both.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressGradiend -= 2;
                PB_Gradiend.setProgress(progressGradiend, circle_point_imgGradiend);
                //	TV_GradiendShowLeft.setText("" +progressGradiend);
            }
        });

        //�ٶȵ���
        IB_Up_Only_Right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                progressSpeed += 1;
                speedDeal(progressSpeed);
//				String  progressSpeedString = ""+(progressSpeed/10)+"."+(progressSpeed%10);
//			   TV_Speed_Show_Top.setText(progressSpeedString);
//				PB_Speed.setProgress(progressSpeed,circle_point_imgSpeed);	
            }
        });

        //�ٶ�˫��
        IB_Up_Both_Right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressSpeed += 2;
                speedDeal(progressSpeed);
//					String  progressSpeedString = ""+(progressSpeed/10)+"."+(progressSpeed%10);
//					   TV_Speed_Show_Top.setText(progressSpeedString);
//				PB_Speed.setProgress(progressSpeed,circle_point_imgSpeed);	
            }
        });

        //�ٶȵ���
        IB_Down_Only_Right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressSpeed -= 1;
                speedDeal(progressSpeed);
//					PB_Speed.setProgress(progressSpeed,circle_point_imgSpeed);	
            }
        });

        //�ٶ�˫��
        IB_Down_Both_Right.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                progressSpeed -= 2;
                speedDeal(progressSpeed);
//					String  progressSpeedString = ""+(progressSpeed/10)+"."+(progressSpeed%10);
//					TV_Speed_Show_Top.setText(progressSpeedString);
//					PB_Speed.setProgress(progressSpeed,circle_point_imgSpeed);	
            }
        });


        //commen���ִ���
        //������ ���      ���IB_Background_Left�¼���
        IB_Background_Left.setOnClickListener(new ImageButton.OnClickListener() {
            //document.getElementById("ImageButton1").style.display = "none";
            @Override
            public void onClick(View v) {
                if (v == IB_Background_Left) {
                    //IB_Background_Left���أ�������ʾ
                    RL_Big_Layout.setVisibility(View.GONE);    //��ߴ�ĵ�GONE
                    RL_Small_Layout.setVisibility(View.VISIBLE);//���С��VISIBLE
                    RL_Middle_Layout.setVisibility(View.GONE);//�м�����
                    RL_Big_Layout_Right.setVisibility(View.GONE);    //�ұߴ������
                    RL_Small_Layout_Right.setVisibility(View.VISIBLE);//�ұ�С����ʾ
                }
            }
        });

        //����ұߴ��        ���IB_Background_Left����¼���
        IB_Background_Right.setOnClickListener(new ImageButton.OnClickListener() {
            //document.getElementById("ImageButton1").style.display = "none";
            @Override
            public void onClick(View v) {
                if (v == IB_Background_Right) {
                    RL_Big_Layout.setVisibility(View.GONE);    //��ߴ�ĵ�GONE
                    RL_Small_Layout.setVisibility(View.VISIBLE);//���С��VISIBLE
                    RL_Middle_Layout.setVisibility(View.GONE);//�м�����
                    RL_Big_Layout_Right.setVisibility(View.GONE);    //�ұߴ������
                    RL_Small_Layout_Right.setVisibility(View.VISIBLE);//�ұ�С����ʾ
                }
            }
        });

        // ������С��      ���IB_Background_Left_in
        IB_Background_Left_in.setOnClickListener(new ImageButton.OnClickListener() {
            //document.getElementById("ImageButton1").style.display = "none";
            @Override
            public void onClick(View v) {
                if (v == IB_Background_Left_in) {
                    //�󲼾���ʾ��С��������
                    RL_Small_Layout.setVisibility(View.GONE);//���С������
                    RL_Big_Layout.setVisibility(View.VISIBLE);    //��������ʾ
                    RL_Middle_Layout.setVisibility(View.VISIBLE);//�м���ʾ
                    RL_Big_Layout_Right.setVisibility(View.VISIBLE);    //�ұߴ����ʾ
                    RL_Small_Layout_Right.setVisibility(View.GONE);//С������
                }
            }
        });

        IB_Background_Left_in.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    IB_Background_Left_in.setImageResource(R.drawable.background_left_in_onclick);
                } else {
                    IB_Background_Left_in.setImageResource(R.drawable.background_left_in);
                }
            }
        });

        //  ����ұ�С��    ���IB_Background_Left_in
        IB_Background_Right_in.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == IB_Background_Right_in) {
                    RL_Small_Layout.setVisibility(View.GONE);//���С������
                    RL_Big_Layout.setVisibility(View.VISIBLE);    //��������ʾ
                    RL_Middle_Layout.setVisibility(View.VISIBLE);//�м���ʾ
                    RL_Big_Layout_Right.setVisibility(View.VISIBLE);    //�ұߴ����ʾ
                    RL_Small_Layout_Right.setVisibility(View.GONE);//С������
                }
            }
        });

        IB_Background_Right_in.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    IB_Background_Right_in.setImageResource(R.drawable.background_right_in_onclick);
                } else {
                    IB_Background_Right_in.setImageResource(R.drawable.background_right_in);
                }
            }
        });

        //����
        Btn_Back_Bottom.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == Btn_Back_Bottom) {
                    RL_Big_Layout.setVisibility(View.GONE);    //��ߴ�ĵ�GONE
                    RL_Small_Layout.setVisibility(View.VISIBLE);//���С��VISIBLE
                    RL_Middle_Layout.setVisibility(View.GONE);//�м�����
                    RL_Big_Layout_Right.setVisibility(View.GONE);    //�ұߴ������
                    RL_Small_Layout_Right.setVisibility(View.VISIBLE);//�ұ�С����ʾ
                }
            }
        });

        //��ͣ
        Btn_Pause_Bottom.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == Btn_Pause_Bottom) {
                    RL_Big_Layout.setVisibility(View.GONE);    //��ߴ�ĵ�GONE
                    RL_Small_Layout.setVisibility(View.VISIBLE);//���С��VISIBLE
                    RL_Middle_Layout.setVisibility(View.GONE);//�м�����
                    RL_Big_Layout_Right.setVisibility(View.GONE);    //�ұߴ������
                    RL_Small_Layout_Right.setVisibility(View.VISIBLE);//�ұ�С����ʾ
                }
            }
        });
    }

    /*
     * �ٶ����ݵĴ���
     * */
    private void speedDeal(int progressSpeed) {

        String progressSpeedString = "" + (progressSpeed / 10) + "." + (progressSpeed % 10);
        TV_Speed_Show_Top.setText(progressSpeedString);
        PB_Speed.setProgress(progressSpeed, circle_point_imgSpeed);
    }

    /*
     * ����д���ļ�
     * */
    public void setPasswordFlieDate(String password) {
        //ʵ����SharedPreferences���󣨵�1����
        SharedPreferences mySharedPreferences = getSharedPreferences("password",
                Activity.MODE_PRIVATE);
        //ʵ����SharedPreferences.Editor���󣨵ڶ�����
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        //��putString�ķ�����������
        editor.putString("password", password);
        //�ύ��ǰ����
        editor.commit();
        //ʹ��toast��Ϣ��ʾ����ʾ�ɹ�д������

    }

    /*
     * ���ļ���������
     * */
    public String getPasswordFileDate() {

        //ͬ�����ڶ�ȡSharedPreferences����ǰҪʵ������1��SharedPreferences����
        SharedPreferences sharedPreferences = getSharedPreferences("password",
                Activity.MODE_PRIVATE);
        // ʹ��getString�������value��ע���2��������value��Ĭ��ֵ
        String password = sharedPreferences.getString("password", "123456");

        //ʹ��toast��Ϣ��ʾ����ʾ�ı������������Ϣ
        //Toast.makeText(this, "��ȡ��������"+"\n"+"password" + password,
        ///Toast.LENGTH_LONG).show();
        return password;
    }

    /*
     * ��ʼ��
     * */
    public void InitBase() {
        //commen��ʼ������
        IB_Background_Left_in = (ImageButton) findViewById(R.id.IB_Background_Left_in);
        IB_Background_Left = (ImageButton) findViewById(R.id.IB_Background_Left);
        IB_Background_Right_in = (ImageButton) findViewById(R.id.IB_Background_Right_in);
        IB_Background_Right = (ImageButton) findViewById(R.id.IB_Background_Right);
        Btn_Back_Bottom = (Button) findViewById(R.id.Btn_Back_Bottom);
        Btn_Pause_Bottom = (Button) findViewById(R.id.Btn_Pause_Bottom);

        RL_Big_Layout = (RelativeLayout) findViewById(R.id.RL_Big_Layout);
        RL_Small_Layout = (RelativeLayout) findViewById(R.id.RL_Small_Layout);
        RL_Big_Layout_Right = (RelativeLayout) findViewById(R.id.RL_Big_Layout_Right);
        RL_Small_Layout_Right = (RelativeLayout) findViewById(R.id.RL_Small_Layout_Right);
        RL_Middle_Layout = (LinearLayout) findViewById(R.id.RL_Middle_Layout);
        RL_Top_Layout = (RelativeLayout) findViewById(R.id.Commen_First_Top);

        //�ؼ���ʼ��
        TV_Gradiend_Show_Top = (TextView) findViewById(R.id.TV_Gradiend_Show_Top);
        TV_Distance_Show_Top = (TextView) findViewById(R.id.TV_Distance_Show_Top);
        TV_Time_Show_Top = (TextView) findViewById(R.id.TV_Time_Show_Top);
        TV_Heat_Show_Top = (TextView) findViewById(R.id.TV_Heat_Show_Top);
        TV_Heart_Show_Top = (TextView) findViewById(R.id.TV_Heart_Show_Top);
        TV_Speed_Show_Top = (TextView) findViewById(R.id.TV_Speed_Show_Top);
        TV_Speed = (TextView) findViewById(R.id.TV_Speed);
        TV_Distance = (TextView) findViewById(R.id.TV_Distance);

        //progressBar  PB_Gradiend
        PB_Gradiend = (CircleProgressBar) findViewById(R.id.PB_Gradiend);
        IB_Up_Only = (ImageButton) findViewById(R.id.IB_Up_Only);
        IB_Up_Both = (ImageButton) findViewById(R.id.IB_Up_Both);
        IB_Down_Only = (ImageButton) findViewById(R.id.IB_Down_Only);
        IB_Down_Both = (ImageButton) findViewById(R.id.IB_Down_Both);
        this.circle_point_imgGradiend = (ImageView) findViewById(R.id.circle_point_imgGradiend);
        //	TV_GradiendShowLeft = (TextView)findViewById(R.id.TV_GradiendShowLeft);

        //progressBar  PB_Speed
        PB_Speed = (CircleProgressBar) findViewById(R.id.PB_Speed);
        IB_Up_Only_Right = (ImageButton) findViewById(R.id.IB_Up_Only_Right);
        IB_Up_Both_Right = (ImageButton) findViewById(R.id.IB_Up_Both_Right);
        IB_Down_Only_Right = (ImageButton) findViewById(R.id.IB_Down_Only_Right);
        IB_Down_Both_Right = (ImageButton) findViewById(R.id.IB_Down_Both_Right);
        this.circle_point_imgSpeed = (ImageView) findViewById(R.id.circle_point_imgSpeed);

        PB_Gradiend.setProgress(progressGradiend, circle_point_imgGradiend);
        PB_Speed.setProgress(progressSpeed, circle_point_imgSpeed);

        RL_Big_Layout.setVisibility(View.GONE);
        RL_Big_Layout_Right.setVisibility(View.GONE);
        RL_Middle_Layout.setVisibility(View.GONE);

        //���ó�ʼ����
        //	setPasswordFlieDate("111111");
    }
}

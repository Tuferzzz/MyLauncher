package com.ada.jw;

import com.ada.mcu.service.Beep;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class warningFragment extends Fragment {

	public static warningFragment newInstance(Activity mActivity) {

		warningFragment mWarningFragment = new warningFragment();
		mWarningFragment.currentActivity = (setActivity) mActivity;
		return mWarningFragment;
	}

	private TextView TV_waringNumber;
	private TextView mTVWarningText;
	private ImageButton IB_ok;

	private setActivity currentActivity;
	private View view;

	private String[] textWarning = { "ͨ�Ź���", "��������", "EM���ضϿ�", "��������", "Ƿѹ����",
														"���ع���", "CE��ͣ���ضϿ�", "���ȹ���", "�����趨��ʱ�䣬�����", "�����趨�ܾ��룬�����",
														"�빤����Ա����ڲ��ҳ����������������", "�Լ쳬ʱ", "MCU�ر���ʱ",  "�Լ���...","�Լ����",
														"�ͺ����������"};

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.warning, null, false);

		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		findViewById(view);
		inItUi();
		listionEvent();
	}
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		currentActivity.isWarningOpened = 0;
	}

	/*
	 * ����id
	 */
	private void findViewById(View view) {

		currentActivity.RL_commenTop = currentActivity.findViewById(R.id.RL_commenTop);
		
		TV_waringNumber = (TextView) view.findViewById(R.id.TV_waringNumber);
		mTVWarningText = (TextView) view.findViewById(R.id.TV_refueling);
		IB_ok = (ImageButton) view.findViewById(R.id.IB_ok);

	}

	/*
	 * �����ʼ��
	 */
	private void inItUi() {

		currentActivity.isOrNoAtsetFragment = false;
		currentActivity.RL_commenTop.setVisibility(View.INVISIBLE);
		
		if (currentActivity.data.getSelfCheckStatus()  ==  1) {
			TV_waringNumber.setText("" + 14);
			mTVWarningText.setText(textWarning[13]);
		}else {
			TV_waringNumber.setText("" + currentActivity.numCode);
			mTVWarningText.setText(textWarning[currentActivity.numCode - 1]);
		}	
	}

	/*
	 * �����¼�
	 */
	private void listionEvent() {

		IB_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
				Beep.beep(currentActivity.getApplicationContext());
				currentActivity.switchFragment = 0;
				currentActivity.switchFragment(currentActivity.switchFragment);
			}
		});
	}

}

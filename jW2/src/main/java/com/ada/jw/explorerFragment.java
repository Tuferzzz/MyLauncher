package com.ada.jw;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.ada.mcu.service.Beep;
import com.ada.util.VolumeSeekBar;

public class explorerFragment extends Fragment {

	public static explorerFragment newInstance(Activity mActivity) {

		explorerFragment mExplorerFragment = new explorerFragment();
		mExplorerFragment.currentActivity = (setActivity) mActivity;

		return mExplorerFragment;
	}

	private View view;
	private setActivity currentActivity;

	private CustomViewCallback customViewCallback;
	private WebView webViewExplorer;
	private ImageButton ibBack;
	private VolumeSeekBar seekBar;

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		seekBar.show();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		view = inflater.inflate(R.layout.explorer_fragment, null, false);
		findViewById(view);
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		inItUi();
		listionEvent();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			webViewExplorer.onPause();
		}
		webViewExplorer.reload();// ���أ�����ֹͣ
		super.onPause();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

		currentActivity.RL_commenTop.setVisibility(View.VISIBLE);
		currentActivity.slidingDrawerSet.setVisibility(view.VISIBLE);
		currentActivity.LL_BackAndPause.setVisibility(view.VISIBLE);
		currentActivity.IB_downSmall.setVisibility(view.VISIBLE);

		webViewExplorer.removeAllViews();// ɾ��������ӵ�view
		webViewExplorer.destroy();// ����webView�������ڴ�//����2�䣬�ڶ��ν�������޷�Ӧ
	}

	private void findViewById(View view) {

		webViewExplorer = (WebView) view.findViewById(R.id.webViewExplorer);
		ibBack = (ImageButton) view.findViewById(R.id.TV_Back);
		seekBar = new VolumeSeekBar(getActivity(), view, R.id.volume_seekbar);
	}

	private void inItUi() {

		currentActivity.RL_commenTop = currentActivity
				.findViewById(R.id.RL_commenTop);
		currentActivity.slidingDrawerSet.setVisibility(view.GONE);
		currentActivity.LL_BackAndPause.setVisibility(view.GONE);
		currentActivity.IB_downSmall.setVisibility(view.GONE);

		// webViewExplorer.getSettings().setBlockNetworkImage(true);
		// //��ͼƬ���ط��������������Ⱦ
		// webViewExplorer.getSettings().setRenderPriority(RenderPriority.HIGH);
		// //�����Ⱦ���ȼ�

		// //��������
		// webViewExplorer.getSettings().setAppCacheEnabled(true);
		// //���û���ģʽ
		// webViewExplorer.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		//
		WebSettings settings = webViewExplorer.getSettings();
		settings.setBuiltInZoomControls(true);// ������
		settings.setJavaScriptCanOpenWindowsAutomatically(true); // ֧��ͨ��js���µĴ���
		settings.setJavaScriptEnabled(true);// ֧��JS
		settings.setPluginState(PluginState.ON);// ֧�ֲ��
		settings.setLoadWithOverviewMode(true);// ����Ӧ��Ļ
		webViewExplorer.setWebChromeClient(new DefaultWebChromeClient()); // ������Ƶ
		webViewExplorer.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		webViewExplorer.requestFocusFromTouch();// ����֧�ֻ�ȡ���ƽ���

		webViewExplorer.loadUrl("http://wap.baidu.com");

		// ����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
		// webViewExplorer.setWebViewClient(new WebViewClient(){
		// @Override
		// public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// // TODO Auto-generated method stub
		// //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
		// view.loadUrl(url);
		// return false;
		// }
		// });
		//
	}

	/*
	 * �����¼�
	 */
	private void listionEvent() {
		ibBack.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					ibBack.setBackgroundResource(R.drawable.icon_back_clicked);
					Beep.beep(getActivity().getApplication());
					currentActivity.switchFragment = 6;
					currentActivity
							.switchFragment(currentActivity.switchFragment);
					break;
				case MotionEvent.ACTION_UP:
					ibBack.setBackgroundResource(R.drawable.icon_back);
					break;
				default:
					break;
				}
				return true;
			}
		});
	}

	/**
	 * ����ȫ��
	 */
	private void setFullScreen() {
		// ����ȫ����������ԣ���ȡ��ǰ����Ļ״̬��Ȼ������ȫ��
		currentActivity.getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ȫ���µ�״̬�룺1098974464
		// �����µ�״̬��1098973440
	}

	// ����webview ��
	class MyWebViewClient extends WebViewClient {

		// ���ؽ�����ʱ��
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
		}
	}

	private class DefaultWebChromeClient extends WebChromeClient {
		// һ���ص��ӿ�ʹ�õ�����Ӧ�ó���֪ͨ��ǰҳ����Զ�����ͼ�ѱ���ְ

		// ����ȫ����ʱ��
		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {
			// ��ֵ��callback
			customViewCallback = callback;

			// ��video�ŵ���ǰ��ͼ��

			webViewExplorer.addView(view);// ����һ�䣬�����޷�������Ƶ
			// ������ʾ
			// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			// ����ȫ��
			setFullScreen();
		}

		// �˳�ȫ��
		@Override
		public void onHideCustomView() {
			// TODO Auto-generated method stub
			super.onHideCustomView();

			if (customViewCallback != null) {
				// ���ص�
				customViewCallback.onCustomViewHidden();
			}
			webViewExplorer.setVisibility(View.VISIBLE);// ��������ʾwebView��û����䲥�������
		}

		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			super.onProgressChanged(view, newProgress);
		}
	}
}

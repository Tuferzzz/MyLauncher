package com.ada.jw;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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

public class movieFragment extends Fragment {

	public static movieFragment newInstance(Activity mActivity){
		
		movieFragment mMovieFragment = new movieFragment();
		mMovieFragment.currentActivity = (setActivity)mActivity;
		
		return mMovieFragment;
	}
	
	private View mView;
	private setActivity  currentActivity ;
	
	private WebView webViewMovie;
	private CustomViewCallback customViewCallback;
	private ImageButton ibBack;
	private VolumeSeekBar seekBar;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		mView = inflater.inflate(R.layout.movie_fragment, null,false);
		findViewById(mView);
	
		return mView;
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
		super.onPause();
		webViewMovie.onPause();
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		webViewMovie.removeAllViews();//ɾ��������ӵ�view
	    webViewMovie.destroy();//����webView�������ڴ�//����2�䣬�ڶ��ν�������޷�Ӧ
		currentActivity.RL_commenTop.setVisibility(View.GONE);
		currentActivity.slidingDrawerSet.setVisibility(mView.GONE);
		currentActivity.LL_BackAndPause.setVisibility(mView.GONE);
		currentActivity.IB_downSmall.setVisibility(mView.GONE);
	}

@SuppressLint({ "SetJavaScriptEnabled", "InlinedApi", "NewApi" })
private void inItUi(){
	
	currentActivity.RL_commenTop = currentActivity.findViewById(R.id.RL_commenTop);
	
	currentActivity.slidingDrawerSet.setVisibility(mView.GONE);
	currentActivity.LL_BackAndPause.setVisibility(mView.GONE);
	currentActivity.IB_downSmall.setVisibility(mView.GONE);

	WebSettings  settings= webViewMovie.getSettings();
//		settings.setBlockNetworkImage(true); //��ͼƬ���ط��������������Ⱦ
//		settings.setRenderPriority(RenderPriority.HIGH); //�����Ⱦ���ȼ�
		
	  //����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
		 webViewMovie.setWebViewClient(new WebViewClient(){
		         @Override
		      public boolean shouldOverrideUrlLoading(WebView view, String url) {
		          // TODO Auto-generated method stub
		             //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ���������������
		           view.loadUrl(url);
		          return true;
		      }
		     });
	settings.setBuiltInZoomControls(true);//������
	settings.setJavaScriptEnabled(true);//֧��JS
	 settings.setPluginState(PluginState.ON);// ֧�ֲ��  
	settings.setUseWideViewPort(true);
	settings.setLoadWithOverviewMode(true);//����Ӧ��Ļ
	webViewMovie.setWebChromeClient(new DefaultWebChromeClient()); // ������Ƶ
	webViewMovie.setLayerType(View.LAYER_TYPE_HARDWARE, null);
	webViewMovie.requestFocusFromTouch();//����֧�ֻ�ȡ���ƽ���
	
	webViewMovie.loadUrl("http://movie.youku.com/");
}
	
private class DefaultWebChromeClient extends WebChromeClient {
		// һ���ص��ӿ�ʹ�õ�����Ӧ�ó���֪ͨ��ǰҳ����Զ�����ͼ�ѱ���ְ

		// ����ȫ����ʱ��
		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {
			// ��ֵ��callback
			customViewCallback = callback;

			// ��webViewMovie�ŵ���ǰ��ͼ��
		
			webViewMovie.addView(view);//����һ�䣬�����޷�������Ƶ
			// ������ʾ
			//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			// ����ȫ��
		setFullScreen();
		}
		
		//�˳�ȫ��
		@Override
		public void onHideCustomView() {
		// TODO Auto-generated method stub
		super.onHideCustomView();
		
		if (customViewCallback != null) {
			// ���ص�
			customViewCallback.onCustomViewHidden();
		}
		webViewMovie.setVisibility(View.VISIBLE);//��������ʾwebView��û����䲥�������
		}
		
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			super.onProgressChanged(view, newProgress);
		}
}

/**
 * ����ȫ��
 */
private void setFullScreen() {
	// ����ȫ����������ԣ���ȡ��ǰ����Ļ״̬��Ȼ������ȫ��
	currentActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN);
	// ȫ���µ�״̬�룺1098974464
	// �����µ�״̬��1098973440
}
private void findViewById(View view){
	
	webViewMovie = (WebView)view.findViewById(R.id.webViewMovie);
	webViewMovie.setWebViewClient(new MyWebViewClient());
	ibBack = (ImageButton)view.findViewById(R.id.TV_Back);
	seekBar = new VolumeSeekBar(getActivity(), view, R.id.volume_seekbar);
}
	
/*
 * �����¼�
 * */
private void listionEvent(){
	ibBack.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			int action = event.getAction();
			switch(action) {
				case MotionEvent.ACTION_DOWN:
					ibBack.setBackgroundResource(R.drawable.icon_back_clicked);
					Beep.beep(getActivity().getApplication());
					if (webViewMovie.canGoBack()) {
						webViewMovie.goBack();
					}
					currentActivity.switchFragment = 6;
					currentActivity.switchFragment(currentActivity.switchFragment);
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

//����webview ��
	class MyWebViewClient extends WebViewClient {

		// ���ؽ�����ʱ��
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
		}
	}
}

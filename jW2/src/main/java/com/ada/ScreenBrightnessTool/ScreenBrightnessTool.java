package com.ada.ScreenBrightnessTool;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.view.Window;
import android.view.WindowManager;

public class ScreenBrightnessTool
{
    /**
     * Activty�Զ���������ģʽ
     */
    public static final int ACTIVITY_BRIGHTNESS_AUTOMATIC = -1;
    /**
     * �Զ�����ģʽ
     */
    public static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
    /**
     * �ֶ�����ģʽ
     */
    public static final int SCREEN_BRIGHTNESS_MODE_MANUAL = Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL;
    /**
     * Ĭ������
     */
    public static final int SCREEN_BRIGHTNESS_DEFAULT = 75;
    /**
     * �������
     */
    public static final int MAX_BRIGHTNESS = 100;
    /**
     * ��С����
     */
    public static final int MIN_BRIGHTNESS = 0;

    private static final int mMaxBrighrness = 1000;
    private static final int mMinBrighrness = 20;

    // ��ǰϵͳ����ģʽ
    private boolean sysAutomaticMode;
    // ��ǰϵͳ����ֵ
    private int sysBrightness;

    private Context context;

    //���캯��
    public ScreenBrightnessTool(Context context, int sysBrightness,
            boolean sysAutomaticMode)
    {
        this.context = context;
        this.sysBrightness = sysBrightness;
        this.sysAutomaticMode = sysAutomaticMode;
    }

    /**
     * ������Ļ���ȹ���
     * 
     * @param context
     * @return
     */
    public static ScreenBrightnessTool Builder(Context context)
    {
        int brightness;
        boolean automaticMode;
        try
        {
            // ��ȡ��ǰϵͳ����ֵ
            brightness = Settings.System.getInt(context.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS);
            // ��ȡ��ǰϵͳ����ģʽ
            automaticMode = Settings.System.getInt(
                    context.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS_MODE) == SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        }
        catch (SettingNotFoundException e)
        {
            return null;
        }

        return new ScreenBrightnessTool(context, brightness, automaticMode);
    }

    /**
     * ���ص�ǰϵͳ���ȵ���ģʽ
     * 
     * @return
     */
    public boolean getSystemAutomaticMode()
    {
        return sysAutomaticMode;
    }

    /**
     * ���ص�ǰϵͳ����ֵ
     * 
     * @return
     */
    public int getSystemBrightness()
    {
        return sysBrightness;
    }

    /**
     * ���õ���ģʽ
     * 
     * @param mode
     *            ����ģʽ
     */
    public void setMode(int mode)
    {
        if (mode != SCREEN_BRIGHTNESS_MODE_AUTOMATIC
                && mode != SCREEN_BRIGHTNESS_MODE_MANUAL)
            return;

        sysAutomaticMode = mode == SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        Settings.System.putInt(context.getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE, mode);
    }

    /**
     * ������Ļ����
     * 
     * @param brightness
     *            ����ֵ,ֵΪ0��100
     */
    public void setBrightness(int brightness)
    {
        int mid = mMaxBrighrness - mMinBrighrness;
        int bri = (int) (mMinBrighrness + mid * ((float) brightness)
                / MAX_BRIGHTNESS);

        ContentResolver resolver = context.getContentResolver();
//        Settings.System
//                .putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, bri);
    }
    
    /**
     * ����Ԥ��
     * 
     * @param activity
     *            Ԥ��activity
     * @param brightness
     *            ����ֵ��0.47~1��
     */

    public static void brightnessPreview(Activity activity, float brightness)
    {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = brightness;
        window.setAttributes(lp);
    }
    
    /**
     * ����Ԥ��
     * 
     * @param activity
     *            Ԥ��activity
     * @param percent
     *            �ٷֱȣ�0.0~1.00��
     */
    public static void brightnessPreviewFromPercent(Activity activity,
            float percent)
    {
        float brightness = percent + (1.0f - percent)
                * (((float) mMinBrighrness) / mMaxBrighrness);
        brightnessPreview(activity, brightness);
    }

}
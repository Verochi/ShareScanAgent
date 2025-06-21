package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class ScreenSwitchUtils {
    public static volatile fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils g = null;
    public static boolean h = true;
    public static boolean i;
    public static boolean j;
    public static android.os.Handler k = new fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.ScreenSwitchHandler(null);
    public android.hardware.SensorManager a;
    public fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.OrientationSensorListener b;
    public android.hardware.Sensor c;
    public android.media.AudioManager d;
    public fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.MyVolumeReceiver e;
    public android.content.Context f;

    public class MyVolumeReceiver extends android.content.BroadcastReceiver {
        public MyVolumeReceiver() {
        }

        public /* synthetic */ MyVolumeReceiver(fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils screenSwitchUtils, defpackage.td2 td2Var) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                int streamVolume = fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.this.d.getStreamVolume(3);
                fm.jiecao.jcvideoplayer_lib.JCMediaPlayerListener first = fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst();
                if (first != null) {
                    first.changeSystemVoice(streamVolume);
                }
            }
        }
    }

    public class OrientationSensorListener implements android.hardware.SensorEventListener {
        public android.os.Handler n;

        public OrientationSensorListener(android.os.Handler handler) {
            this.n = handler;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            int i;
            float[] fArr = sensorEvent.values;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            if (((f * f) + (f2 * f2)) * 4.0f >= f3 * f3) {
                i = 90 - java.lang.Math.round(((float) java.lang.Math.atan2(-f2, f)) * 57.29578f);
                while (i >= 360) {
                    i -= 360;
                }
                while (i < 0) {
                    i += com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                }
            } else {
                i = -1;
            }
            android.os.Handler handler = this.n;
            if (handler != null) {
                handler.obtainMessage(888, i, 0).sendToTarget();
            }
        }
    }

    public static class ScreenSwitchHandler extends android.os.Handler {
        public ScreenSwitchHandler() {
        }

        public /* synthetic */ ScreenSwitchHandler(defpackage.ud2 ud2Var) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 888 && 1 == android.provider.Settings.System.getInt(com.moji.tool.AppDelegate.getAppContext().getContentResolver(), "accelerometer_rotation", 0)) {
                int i = message.arg1;
                if (i > 75 && i < 105) {
                    if (fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.j) {
                        return;
                    }
                    com.moji.tool.log.MJLogger.d("ScreenSwitchUtils", "切换成反横屏");
                    if (fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst() != null) {
                        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst().autoFullscreen(-90);
                    }
                    fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.h = false;
                    fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.i = false;
                    fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.j = true;
                    return;
                }
                if (i > 255 && i < 285) {
                    if (fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.i) {
                        return;
                    }
                    com.moji.tool.log.MJLogger.d("ScreenSwitchUtils", "切换成正横屏");
                    if (fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst() != null) {
                        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager.getFirst().autoFullscreen(90);
                    }
                    fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.h = false;
                    fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.i = true;
                    fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.j = false;
                    return;
                }
                if (((i <= 315 || i >= 360) && (i <= 0 || i >= 45)) || fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.h) {
                    return;
                }
                com.moji.tool.log.MJLogger.d("ScreenSwitchUtils", "切换成正竖屏");
                fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.backPress();
                fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.h = true;
                fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.i = false;
                fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.j = false;
            }
        }
    }

    public ScreenSwitchUtils(android.content.Context context) {
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        this.a = sensorManager;
        this.c = sensorManager.getDefaultSensor(1);
        this.d = (android.media.AudioManager) context.getSystemService("audio");
        this.f = context;
    }

    public static fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils init(android.content.Context context) {
        if (g == null) {
            synchronized (fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.class) {
                if (g == null) {
                    g = new fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils(context);
                }
            }
        }
        return g;
    }

    public synchronized void start(boolean z) {
        if (z) {
            if (this.b == null) {
                fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.OrientationSensorListener orientationSensorListener = new fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.OrientationSensorListener(k);
                this.b = orientationSensorListener;
                this.a.registerListener(orientationSensorListener, this.c, 2);
            }
        }
        if (this.e == null) {
            this.e = new fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.MyVolumeReceiver(this, null);
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f.registerReceiver(this.e, intentFilter);
        }
    }

    public synchronized void stop() {
        com.moji.tool.log.MJLogger.e("ScreenSwitchUtils", "listener is stop");
        fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.OrientationSensorListener orientationSensorListener = this.b;
        if (orientationSensorListener != null) {
            this.a.unregisterListener(orientationSensorListener);
            this.b = null;
        }
        fm.jiecao.jcvideoplayer_lib.ScreenSwitchUtils.MyVolumeReceiver myVolumeReceiver = this.e;
        if (myVolumeReceiver != null) {
            try {
                this.f.unregisterReceiver(myVolumeReceiver);
            } catch (java.lang.Exception e) {
                com.moji.tool.log.MJLogger.e("ScreenSwitchUtils", e);
                com.moji.tool.log.MJLogger.postCatchedException(e);
            }
            this.e = null;
        }
    }
}

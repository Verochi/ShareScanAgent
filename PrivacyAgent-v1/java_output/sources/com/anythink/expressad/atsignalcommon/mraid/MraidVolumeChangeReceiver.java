package com.anythink.expressad.atsignalcommon.mraid;

/* loaded from: classes12.dex */
public class MraidVolumeChangeReceiver {
    public static double a = -1.0d;
    private static final java.lang.String b = "android.media.VOLUME_CHANGED_ACTION";
    private static final java.lang.String c = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private android.content.Context d;
    private android.media.AudioManager e;
    private boolean f = false;
    private com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener g;
    private com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeBroadcastReceiver h;

    public static class VolumeChangeBroadcastReceiver extends android.content.BroadcastReceiver {
        private java.lang.ref.WeakReference<com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver> a;

        public VolumeChangeBroadcastReceiver(com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver) {
            this.a = new java.lang.ref.WeakReference<>(mraidVolumeChangeReceiver);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver;
            com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener volumeChangeListener;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (!com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.b.equals(intent.getAction()) || intent.getIntExtra(com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.c, -1) != 3 || (mraidVolumeChangeReceiver = this.a.get()) == null || (volumeChangeListener = mraidVolumeChangeReceiver.getVolumeChangeListener()) == null) {
                return;
            }
            double currentVolume = mraidVolumeChangeReceiver.getCurrentVolume();
            if (currentVolume >= 0.0d) {
                volumeChangeListener.onVolumeChanged(currentVolume);
            }
        }
    }

    public interface VolumeChangeListener {
        void onVolumeChanged(double d);
    }

    public MraidVolumeChangeReceiver(android.content.Context context) {
        this.d = context;
        this.e = (android.media.AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public double getCurrentVolume() {
        android.media.AudioManager audioManager = this.e;
        double streamVolume = ((this.e != null ? r3.getStreamVolume(3) : -1) * 100.0d) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1);
        a = streamVolume;
        return streamVolume;
    }

    public com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener getVolumeChangeListener() {
        return this.g;
    }

    public void registerReceiver() {
        if (this.d != null) {
            this.h = new com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeBroadcastReceiver(this);
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(b);
            this.d.registerReceiver(this.h, intentFilter);
            this.f = true;
        }
    }

    public void setVolumeChangeListener(com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener volumeChangeListener) {
        this.g = volumeChangeListener;
    }

    public void unregisterReceiver() {
        android.content.Context context;
        if (!this.f || (context = this.d) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.h);
            this.g = null;
            this.f = false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}

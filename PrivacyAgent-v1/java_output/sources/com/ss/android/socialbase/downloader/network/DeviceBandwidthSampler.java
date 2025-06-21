package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
public class DeviceBandwidthSampler {
    private static final java.lang.String TAG = "DeviceBandwidthSampler";
    private static volatile com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler instance = null;
    public static volatile boolean isWifi = false;
    private static long sPreviousBytes = -1;
    private long mLastTimeReading;
    private final com.ss.android.socialbase.downloader.network.NetTrafficManager mNetTrafficManager = com.ss.android.socialbase.downloader.network.NetTrafficManager.getInstance();
    private final java.util.concurrent.atomic.AtomicInteger mSamplingCounter = new java.util.concurrent.atomic.AtomicInteger();
    private final com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.SamplingHandler mHandler = new com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.SamplingHandler(com.ss.android.socialbase.downloader.thread.DownloadWatchDog.getThreadLooper());

    public class SamplingHandler extends android.os.Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;

        public SamplingHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.this.addSample();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }

    private DeviceBandwidthSampler() {
    }

    public static long getAllRxBytesWifi() {
        return android.net.TrafficStats.getTotalRxBytes() - android.net.TrafficStats.getMobileRxBytes();
    }

    public static com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler getInstance() {
        if (instance == null) {
            synchronized (com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.class) {
                if (instance == null) {
                    instance = new com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler();
                }
            }
        }
        return instance;
    }

    public static void updateWifiStatus() {
        isWifi = com.ss.android.socialbase.downloader.utils.DownloadUtils.isWifi(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
    }

    public void addFinalSample() {
        addSample();
        sPreviousBytes = -1L;
    }

    public void addSample() {
        try {
            updateWifiStatus();
            long allRxBytesWifi = isWifi ? getAllRxBytesWifi() : android.net.TrafficStats.getMobileRxBytes();
            long j = sPreviousBytes;
            long j2 = allRxBytesWifi - j;
            if (j >= 0) {
                synchronized (this) {
                    long uptimeMillis = android.os.SystemClock.uptimeMillis();
                    this.mNetTrafficManager.addBandwidth(j2, uptimeMillis - this.mLastTimeReading);
                    this.mLastTimeReading = uptimeMillis;
                }
            }
            sPreviousBytes = allRxBytesWifi;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSampling() {
        return this.mSamplingCounter.get() != 0;
    }

    public void startSampling() {
        try {
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "startSampling: mSamplingCounter = " + this.mSamplingCounter);
            if (this.mSamplingCounter.getAndIncrement() == 0) {
                this.mHandler.startSamplingThread();
                this.mLastTimeReading = android.os.SystemClock.uptimeMillis();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void stopSampling() {
        try {
            com.ss.android.socialbase.downloader.logger.Logger.i(TAG, "stopSampling: mSamplingCounter = " + this.mSamplingCounter);
            if (this.mSamplingCounter.decrementAndGet() == 0) {
                this.mHandler.stopSamplingThread();
                addFinalSample();
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}

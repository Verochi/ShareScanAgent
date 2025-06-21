package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public class SegmentStrategy {
    private static final int MAX_THREAD_COUNT = 16;
    private static final long MIN_CONNECT_TIMEOUT = 2000;
    private static final long MIN_READ_TIMEOUT = 4000;
    private static final long SEGMENT_MIN_INIT_SIZE = 5242880;
    private static final long SEGMENT_MIN_SIZE = 65536;
    public static final java.lang.String TAG = "SegmentStrategy";
    private final org.json.JSONObject config;
    private int threadCount;

    private SegmentStrategy(org.json.JSONObject jSONObject) {
        this.config = jSONObject;
    }

    private int calculateThreadCount(int i) {
        int optInt = this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.THREAD_COUNT, 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return getUrlBalance() == 1 ? java.lang.Math.min(optInt, i) : optInt;
        }
        if (getUrlBalance() > 0) {
            return i;
        }
        return 1;
    }

    @androidx.annotation.NonNull
    public static com.ss.android.socialbase.downloader.segment.SegmentStrategy from(@androidx.annotation.NonNull org.json.JSONObject jSONObject) {
        return new com.ss.android.socialbase.downloader.segment.SegmentStrategy(jSONObject);
    }

    private int getUrlBalance() {
        return this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.URL_BALANCE, 2);
    }

    public int getBufferCount() {
        return this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.BUFFER_COUNT, 512);
    }

    public int getBufferSize() {
        return this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.BUFFER_SIZE, 8192);
    }

    public long getConnectTimeout() {
        long optInt = this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.CONNECT_TIMEOUT, -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public int getIpStrategy() {
        return this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.IP_STRATEGY, 0);
    }

    public float getMainRatio() {
        return (float) this.config.optDouble(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.MAIN_RATIO, 0.0d);
    }

    public float getPoorSpeedRatio() {
        return java.lang.Math.min(java.lang.Math.max(0.0f, (float) this.config.optDouble(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.POOR_SPEED_RATIO, 0.0d)), 1.0f);
    }

    public int getRatioSegmentStrategy() {
        return this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.RATIO_SEGMENT, 0);
    }

    public long getReadTimeout() {
        long optInt = this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, -1);
        if (optInt >= 4000) {
            return optInt;
        }
        return -1L;
    }

    public long getSegmentMaxSize() {
        long optInt = this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.SEGMENT_MAX_KB, 0) * 1048576;
        if (optInt < getSegmentMinSize()) {
            return -1L;
        }
        return optInt;
    }

    public long getSegmentMinInitSize() {
        long optInt = this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_INIT_MB, 10) * 1048576;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    public long getSegmentMinSize() {
        long optInt = this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_KB, 512) * 1024;
        if (optInt < 65536) {
            return 65536L;
        }
        return optInt;
    }

    public int getThreadCount() {
        return this.threadCount;
    }

    public boolean segmentOneByOne() {
        return this.config.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SegmentConfig.SEGMENT_MODE, 1) == 0;
    }

    public void updateUrlCount(int i) {
        this.threadCount = calculateThreadCount(i);
    }

    public boolean urlBalance() {
        return getUrlBalance() > 0;
    }

    public boolean urlBalanceStrictly() {
        return getUrlBalance() == 1;
    }
}

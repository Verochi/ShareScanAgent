package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
public class NetTrafficManager {
    private static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private static final java.lang.String TAG = "NetTrafficManager";
    private final java.util.concurrent.atomic.AtomicReference<com.ss.android.socialbase.downloader.network.NetworkQuality> currentNetworkQuality;
    private volatile boolean initiateStateChange;
    private final java.util.ArrayList<com.ss.android.socialbase.downloader.network.NetTrafficManager.NetworkStateChangeListener> listenerList;
    private final com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage mDownloadBandwidth;
    private java.util.concurrent.atomic.AtomicReference<com.ss.android.socialbase.downloader.network.NetworkQuality> nextNetworkQuality;
    private int sampleCount;

    /* renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality;

        static {
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.NetworkQuality.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.NetworkQuality.POOR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[com.ss.android.socialbase.downloader.network.NetworkQuality.MODERATE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[com.ss.android.socialbase.downloader.network.NetworkQuality.GOOD.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[com.ss.android.socialbase.downloader.network.NetworkQuality.EXCELLENT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public static class ConnectionClassManagerHolder {
        public static final com.ss.android.socialbase.downloader.network.NetTrafficManager instance = new com.ss.android.socialbase.downloader.network.NetTrafficManager(null);

        private ConnectionClassManagerHolder() {
        }
    }

    public interface NetworkStateChangeListener {
        void onBandwidthStateChange(com.ss.android.socialbase.downloader.network.NetworkQuality networkQuality);
    }

    private NetTrafficManager() {
        this.mDownloadBandwidth = new com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.initiateStateChange = false;
        this.currentNetworkQuality = new java.util.concurrent.atomic.AtomicReference<>(com.ss.android.socialbase.downloader.network.NetworkQuality.UNKNOWN);
        this.listenerList = new java.util.ArrayList<>();
    }

    public /* synthetic */ NetTrafficManager(com.ss.android.socialbase.downloader.network.NetTrafficManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.socialbase.downloader.network.NetTrafficManager getInstance() {
        return com.ss.android.socialbase.downloader.network.NetTrafficManager.ConnectionClassManagerHolder.instance;
    }

    private com.ss.android.socialbase.downloader.network.NetworkQuality mapBandwidthQuality(double d) {
        return d < 0.0d ? com.ss.android.socialbase.downloader.network.NetworkQuality.UNKNOWN : d < 150.0d ? com.ss.android.socialbase.downloader.network.NetworkQuality.POOR : d < 550.0d ? com.ss.android.socialbase.downloader.network.NetworkQuality.MODERATE : d < 2000.0d ? com.ss.android.socialbase.downloader.network.NetworkQuality.GOOD : com.ss.android.socialbase.downloader.network.NetworkQuality.EXCELLENT;
    }

    private void notifyListeners() {
        try {
            int size = this.listenerList.size();
            for (int i = 0; i < size; i++) {
                this.listenerList.get(i).onBandwidthStateChange(this.currentNetworkQuality.get());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean significantlyOutsideCurrentBand() {
        double d;
        if (this.mDownloadBandwidth == null) {
            return false;
        }
        try {
            int i = com.ss.android.socialbase.downloader.network.NetTrafficManager.AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[this.currentNetworkQuality.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = 0.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
            }
            double average = this.mDownloadBandwidth.getAverage();
            if (average > d2) {
                if (average > d2 * HYSTERESIS_TOP_MULTIPLIER) {
                    return true;
                }
            } else if (average < d * HYSTERESIS_BOTTOM_MULTIPLIER) {
                return true;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public synchronized void addBandwidth(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.mDownloadBandwidth.addMeasurement(d);
            com.ss.android.socialbase.downloader.network.NetworkQuality currentNetworkQuality = getCurrentNetworkQuality();
            if (!this.initiateStateChange) {
                if (this.currentNetworkQuality.get() != currentNetworkQuality) {
                    this.initiateStateChange = true;
                    this.nextNetworkQuality = new java.util.concurrent.atomic.AtomicReference<>(currentNetworkQuality);
                }
                return;
            }
            this.sampleCount++;
            if (currentNetworkQuality != this.nextNetworkQuality.get()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
            }
            if (this.sampleCount >= DEFAULT_SAMPLES_TO_QUALITY_CHANGE && significantlyOutsideCurrentBand()) {
                this.initiateStateChange = false;
                this.sampleCount = 1;
                this.currentNetworkQuality.set(this.nextNetworkQuality.get());
                notifyListeners();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.NetworkQuality getCurrentNetworkQuality() {
        com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return com.ss.android.socialbase.downloader.network.NetworkQuality.UNKNOWN;
        }
        try {
            return mapBandwidthQuality(exponentialGeometricAverage.getAverage());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return com.ss.android.socialbase.downloader.network.NetworkQuality.UNKNOWN;
        }
    }

    public synchronized double getDownloadKBitsPerSecond() {
        com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
        if (exponentialGeometricAverage == null) {
            return -1.0d;
        }
        return exponentialGeometricAverage.getAverage();
    }

    public com.ss.android.socialbase.downloader.network.NetworkQuality register(com.ss.android.socialbase.downloader.network.NetTrafficManager.NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.add(networkStateChangeListener);
        }
        return this.currentNetworkQuality.get();
    }

    public void remove(com.ss.android.socialbase.downloader.network.NetTrafficManager.NetworkStateChangeListener networkStateChangeListener) {
        if (networkStateChangeListener != null) {
            this.listenerList.remove(networkStateChangeListener);
        }
    }

    public void reset() {
        try {
            com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage exponentialGeometricAverage = this.mDownloadBandwidth;
            if (exponentialGeometricAverage != null) {
                exponentialGeometricAverage.reset();
            }
            this.currentNetworkQuality.set(com.ss.android.socialbase.downloader.network.NetworkQuality.UNKNOWN);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}

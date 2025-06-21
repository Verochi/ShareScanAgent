package androidx.core.app;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl mInstance;

    @androidx.annotation.RequiresApi(24)
    public static class FrameMetricsApi24Impl extends androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static android.os.Handler sHandler;
        private static android.os.HandlerThread sHandlerThread;
        int mTrackingFlags;
        android.util.SparseIntArray[] mMetrics = new android.util.SparseIntArray[9];
        private java.util.ArrayList<java.lang.ref.WeakReference<android.app.Activity>> mActivities = new java.util.ArrayList<>();
        android.view.Window.OnFrameMetricsAvailableListener mListener = new androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.AnonymousClass1();

        /* renamed from: androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.Window.OnFrameMetricsAvailableListener {
            public AnonymousClass1() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(android.view.Window window, android.view.FrameMetrics frameMetrics, int i) {
                long metric;
                long metric2;
                long metric3;
                long metric4;
                long metric5;
                long metric6;
                long metric7;
                long metric8;
                long metric9;
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.mTrackingFlags & 1) != 0) {
                    android.util.SparseIntArray sparseIntArray = frameMetricsApi24Impl.mMetrics[0];
                    metric9 = frameMetrics.getMetric(8);
                    frameMetricsApi24Impl.addDurationItem(sparseIntArray, metric9);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl2 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl2.mTrackingFlags & 2) != 0) {
                    android.util.SparseIntArray sparseIntArray2 = frameMetricsApi24Impl2.mMetrics[1];
                    metric8 = frameMetrics.getMetric(1);
                    frameMetricsApi24Impl2.addDurationItem(sparseIntArray2, metric8);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl3 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl3.mTrackingFlags & 4) != 0) {
                    android.util.SparseIntArray sparseIntArray3 = frameMetricsApi24Impl3.mMetrics[2];
                    metric7 = frameMetrics.getMetric(3);
                    frameMetricsApi24Impl3.addDurationItem(sparseIntArray3, metric7);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl4 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl4.mTrackingFlags & 8) != 0) {
                    android.util.SparseIntArray sparseIntArray4 = frameMetricsApi24Impl4.mMetrics[3];
                    metric6 = frameMetrics.getMetric(4);
                    frameMetricsApi24Impl4.addDurationItem(sparseIntArray4, metric6);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl5 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl5.mTrackingFlags & 16) != 0) {
                    android.util.SparseIntArray sparseIntArray5 = frameMetricsApi24Impl5.mMetrics[4];
                    metric5 = frameMetrics.getMetric(5);
                    frameMetricsApi24Impl5.addDurationItem(sparseIntArray5, metric5);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl6 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl6.mTrackingFlags & 64) != 0) {
                    android.util.SparseIntArray sparseIntArray6 = frameMetricsApi24Impl6.mMetrics[6];
                    metric4 = frameMetrics.getMetric(7);
                    frameMetricsApi24Impl6.addDurationItem(sparseIntArray6, metric4);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl7 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl7.mTrackingFlags & 32) != 0) {
                    android.util.SparseIntArray sparseIntArray7 = frameMetricsApi24Impl7.mMetrics[5];
                    metric3 = frameMetrics.getMetric(6);
                    frameMetricsApi24Impl7.addDurationItem(sparseIntArray7, metric3);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl8 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl8.mTrackingFlags & 128) != 0) {
                    android.util.SparseIntArray sparseIntArray8 = frameMetricsApi24Impl8.mMetrics[7];
                    metric2 = frameMetrics.getMetric(0);
                    frameMetricsApi24Impl8.addDurationItem(sparseIntArray8, metric2);
                }
                androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl9 = androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl9.mTrackingFlags & 256) != 0) {
                    android.util.SparseIntArray sparseIntArray9 = frameMetricsApi24Impl9.mMetrics[8];
                    metric = frameMetrics.getMetric(2);
                    frameMetricsApi24Impl9.addDurationItem(sparseIntArray9, metric);
                }
            }
        }

        public FrameMetricsApi24Impl(int i) {
            this.mTrackingFlags = i;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(android.app.Activity activity) {
            if (sHandlerThread == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("FrameMetricsAggregator");
                sHandlerThread = handlerThread;
                handlerThread.start();
                sHandler = new android.os.Handler(sHandlerThread.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                android.util.SparseIntArray[] sparseIntArrayArr = this.mMetrics;
                if (sparseIntArrayArr[i] == null && (this.mTrackingFlags & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new android.util.SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new java.lang.ref.WeakReference<>(activity));
        }

        public void addDurationItem(android.util.SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] remove(android.app.Activity activity) {
            java.util.Iterator<java.lang.ref.WeakReference<android.app.Activity>> it = this.mActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.ref.WeakReference<android.app.Activity> next = it.next();
                if (next.get() == activity) {
                    this.mActivities.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] reset() {
            android.util.SparseIntArray[] sparseIntArrayArr = this.mMetrics;
            this.mMetrics = new android.util.SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public android.util.SparseIntArray[] stop() {
            for (int size = this.mActivities.size() - 1; size >= 0; size--) {
                java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivities.get(size);
                android.app.Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                    this.mActivities.remove(size);
                }
            }
            return this.mMetrics;
        }
    }

    public static class FrameMetricsBaseImpl {
        public void add(android.app.Activity activity) {
        }

        public android.util.SparseIntArray[] getMetrics() {
            return null;
        }

        public android.util.SparseIntArray[] remove(android.app.Activity activity) {
            return null;
        }

        public android.util.SparseIntArray[] reset() {
            return null;
        }

        public android.util.SparseIntArray[] stop() {
            return null;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int i) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.mInstance = new androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl(i);
        } else {
            this.mInstance = new androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl();
        }
    }

    public void add(@androidx.annotation.NonNull android.app.Activity activity) {
        this.mInstance.add(activity);
    }

    @androidx.annotation.Nullable
    public android.util.SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    @androidx.annotation.Nullable
    public android.util.SparseIntArray[] remove(@androidx.annotation.NonNull android.app.Activity activity) {
        return this.mInstance.remove(activity);
    }

    @androidx.annotation.Nullable
    public android.util.SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    @androidx.annotation.Nullable
    public android.util.SparseIntArray[] stop() {
        return this.mInstance.stop();
    }
}

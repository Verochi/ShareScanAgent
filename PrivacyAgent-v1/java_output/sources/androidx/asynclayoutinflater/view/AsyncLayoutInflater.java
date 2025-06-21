package androidx.asynclayoutinflater.view;

/* loaded from: classes.dex */
public final class AsyncLayoutInflater {
    private static final java.lang.String TAG = "AsyncLayoutInflater";
    android.view.LayoutInflater mInflater;
    private android.os.Handler.Callback mHandlerCallback = new androidx.asynclayoutinflater.view.AsyncLayoutInflater.AnonymousClass1();
    android.os.Handler mHandler = new android.os.Handler(this.mHandlerCallback);
    androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateThread mInflateThread = androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateThread.getInstance();

    /* renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest inflateRequest = (androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                inflateRequest.view = androidx.asynclayoutinflater.view.AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    }

    public static class BasicInflater extends android.view.LayoutInflater {
        private static final java.lang.String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        public BasicInflater(android.content.Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public android.view.LayoutInflater cloneInContext(android.content.Context context) {
            return new androidx.asynclayoutinflater.view.AsyncLayoutInflater.BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        public android.view.View onCreateView(java.lang.String str, android.util.AttributeSet attributeSet) throws java.lang.ClassNotFoundException {
            android.view.View createView;
            for (java.lang.String str2 : sClassPrefixList) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (java.lang.ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public static class InflateRequest {
        androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener callback;
        androidx.asynclayoutinflater.view.AsyncLayoutInflater inflater;
        android.view.ViewGroup parent;
        int resid;
        android.view.View view;
    }

    public static class InflateThread extends java.lang.Thread {
        private static final androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateThread sInstance;
        private java.util.concurrent.ArrayBlockingQueue<androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest> mQueue = new java.util.concurrent.ArrayBlockingQueue<>(10);
        private androidx.core.util.Pools.SynchronizedPool<androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest> mRequestPool = new androidx.core.util.Pools.SynchronizedPool<>(10);

        static {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateThread inflateThread = new androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (java.lang.InterruptedException e) {
                throw new java.lang.RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest obtainRequest() {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest acquire = this.mRequestPool.acquire();
            return acquire == null ? new androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest() : acquire;
        }

        public void releaseRequest(androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.view = null;
            this.mRequestPool.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest take = this.mQueue.take();
                try {
                    take.view = take.inflater.mInflater.inflate(take.resid, take.parent, false);
                } catch (java.lang.RuntimeException unused) {
                }
                android.os.Message.obtain(take.inflater.mHandler, 0, take).sendToTarget();
            } catch (java.lang.InterruptedException unused2) {
            }
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.LayoutRes int i, @androidx.annotation.Nullable android.view.ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@androidx.annotation.NonNull android.content.Context context) {
        this.mInflater = new androidx.asynclayoutinflater.view.AsyncLayoutInflater.BasicInflater(context);
    }

    @androidx.annotation.UiThread
    public void inflate(@androidx.annotation.LayoutRes int i, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.NonNull androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) {
            throw new java.lang.NullPointerException("callback argument may not be null!");
        }
        androidx.asynclayoutinflater.view.AsyncLayoutInflater.InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
        obtainRequest.inflater = this;
        obtainRequest.resid = i;
        obtainRequest.parent = viewGroup;
        obtainRequest.callback = onInflateFinishedListener;
        this.mInflateThread.enqueue(obtainRequest);
    }
}

package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public class EditState extends com.sensorsdata.analytics.android.sdk.visual.snap.UIThreadSet<android.app.Activity> {
    private static final java.lang.String TAG = "SA.EditState";
    private final android.os.Handler mUiThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final java.util.Map<java.lang.String, java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.ViewVisitor>> mIntendedEdits = new java.util.HashMap();
    private final java.util.Map<android.app.Activity, java.util.Set<com.sensorsdata.analytics.android.sdk.visual.snap.EditState.EditBinding>> mCurrentEdits = new java.util.HashMap();

    public static class EditBinding implements android.view.ViewTreeObserver.OnGlobalLayoutListener, java.lang.Runnable {
        private boolean mAlive = true;
        private volatile boolean mDying = false;
        private final com.sensorsdata.analytics.android.sdk.visual.snap.ViewVisitor mEdit;
        private final android.os.Handler mHandler;
        private final java.lang.ref.WeakReference<android.view.View> mViewRoot;

        public EditBinding(android.view.View view, com.sensorsdata.analytics.android.sdk.visual.snap.ViewVisitor viewVisitor, android.os.Handler handler) {
            this.mEdit = viewVisitor;
            this.mViewRoot = new java.lang.ref.WeakReference<>(view);
            this.mHandler = handler;
            android.view.ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        private void cleanUp() {
            if (this.mAlive) {
                android.view.View view = this.mViewRoot.get();
                if (view != null) {
                    android.view.ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
                this.mEdit.cleanup();
            }
            this.mAlive = false;
        }

        public void kill() {
            this.mDying = true;
            this.mHandler.post(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAlive) {
                android.view.View view = this.mViewRoot.get();
                if (view == null || this.mDying) {
                    cleanUp();
                    return;
                }
                this.mEdit.visit(view);
                this.mHandler.removeCallbacks(this);
                this.mHandler.postDelayed(this, 5000L);
            }
        }
    }

    private void applyChangesFromList(android.app.Activity activity, android.view.View view, java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.ViewVisitor> list) {
        synchronized (this.mCurrentEdits) {
            if (!this.mCurrentEdits.containsKey(activity)) {
                this.mCurrentEdits.put(activity, new java.util.HashSet());
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.mCurrentEdits.get(activity).add(new com.sensorsdata.analytics.android.sdk.visual.snap.EditState.EditBinding(view, list.get(i), this.mUiThreadHandler));
            }
        }
    }

    private void applyEditsOnActivity(android.app.Activity activity) {
        java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.ViewVisitor> list;
        java.util.List<com.sensorsdata.analytics.android.sdk.visual.snap.ViewVisitor> list2;
        java.lang.String canonicalName = activity.getClass().getCanonicalName();
        android.view.Window window = activity.getWindow();
        android.view.View rootView = (window == null || !window.isActive()) ? null : window.getDecorView().getRootView();
        if (rootView == null) {
            return;
        }
        synchronized (this.mIntendedEdits) {
            list = this.mIntendedEdits.get(canonicalName);
            list2 = this.mIntendedEdits.get(null);
        }
        if (list != null) {
            applyChangesFromList(activity, rootView, list);
        }
        if (list2 != null) {
            applyChangesFromList(activity, rootView, list2);
        }
    }

    private void removeChangesOnActivity(android.app.Activity activity) {
        synchronized (this.mCurrentEdits) {
            java.util.Set<com.sensorsdata.analytics.android.sdk.visual.snap.EditState.EditBinding> set = this.mCurrentEdits.get(activity);
            if (set == null) {
                return;
            }
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.visual.snap.EditState.EditBinding> it = set.iterator();
            while (it.hasNext()) {
                it.next().kill();
            }
            this.mCurrentEdits.remove(activity);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.snap.UIThreadSet
    public void add(android.app.Activity activity) {
        super.add((com.sensorsdata.analytics.android.sdk.visual.snap.EditState) activity);
        applyEditsOnActivity(activity);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.snap.UIThreadSet
    public void remove(android.app.Activity activity) {
        super.remove((com.sensorsdata.analytics.android.sdk.visual.snap.EditState) activity);
        removeChangesOnActivity(activity);
    }
}

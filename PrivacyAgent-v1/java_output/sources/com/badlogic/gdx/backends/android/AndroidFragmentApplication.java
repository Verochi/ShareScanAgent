package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidFragmentApplication extends androidx.fragment.app.Fragment implements com.badlogic.gdx.backends.android.AndroidApplicationBase {
    protected com.badlogic.gdx.ApplicationLogger applicationLogger;
    protected com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks callbacks;
    protected com.badlogic.gdx.backends.android.AndroidFiles files;
    protected com.badlogic.gdx.backends.android.AndroidGraphics graphics;
    public android.os.Handler handler;
    protected com.badlogic.gdx.ApplicationListener listener;
    public java.util.concurrent.Executor t = java.util.concurrent.Executors.newSingleThreadExecutor();
    protected boolean firstResume = true;
    protected boolean isDestroyed = false;
    protected final com.badlogic.gdx.utils.Array<java.lang.Runnable> runnables = new com.badlogic.gdx.utils.Array<>();
    protected final com.badlogic.gdx.utils.Array<java.lang.Runnable> executedRunnables = new com.badlogic.gdx.utils.Array<>();
    protected final com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> lifecycleListeners = new com.badlogic.gdx.utils.SnapshotArray<>(com.badlogic.gdx.LifecycleListener.class);
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.backends.android.AndroidEventListener> u = new com.badlogic.gdx.utils.Array<>();
    protected int logLevel = 2;

    /* renamed from: com.badlogic.gdx.backends.android.AndroidFragmentApplication$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.os.SystemClock.sleep(50L);
            com.badlogic.gdx.backends.android.AndroidFragmentApplication.this.graphics.b();
        }
    }

    /* renamed from: com.badlogic.gdx.backends.android.AndroidFragmentApplication$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.badlogic.gdx.backends.android.AndroidFragmentApplication.this.callbacks.exit();
        }
    }

    public interface Callbacks {
        void exit();
    }

    static {
        com.badlogic.gdx.utils.GdxNativesLoader.load();
    }

    public void addAndroidEventListener(com.badlogic.gdx.backends.android.AndroidEventListener androidEventListener) {
        synchronized (this.u) {
            this.u.add(androidEventListener);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void addLifecycleListener(com.badlogic.gdx.LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.add(lifecycleListener);
        }
    }

    public final boolean b() {
        for (androidx.fragment.app.Fragment parentFragment = getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment.isRemoving()) {
                return true;
            }
        }
        return false;
    }

    public android.widget.FrameLayout.LayoutParams createLayoutParams() {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void createWakeLock(boolean z) {
        if (z) {
            getActivity().getWindow().addFlags(128);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.badlogic.gdx.Application
    public void debug(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    @Override // com.badlogic.gdx.Application
    public void error(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.badlogic.gdx.Application
    public void error(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    @Override // com.badlogic.gdx.Application
    public void exit() {
        this.handler.post(new com.badlogic.gdx.backends.android.AndroidFragmentApplication.AnonymousClass2());
    }

    @Override // com.badlogic.gdx.Application
    public com.badlogic.gdx.ApplicationListener getApplicationListener() {
        return this.listener;
    }

    @Override // com.badlogic.gdx.Application
    public com.badlogic.gdx.ApplicationLogger getApplicationLogger() {
        return this.applicationLogger;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public android.view.Window getApplicationWindow() {
        return getActivity().getWindow();
    }

    @Override // androidx.fragment.app.Fragment, com.badlogic.gdx.backends.android.AndroidApplicationBase
    public android.content.Context getContext() {
        return getActivity();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public com.badlogic.gdx.utils.Array<java.lang.Runnable> getExecutedRunnables() {
        return this.executedRunnables;
    }

    @Override // com.badlogic.gdx.Application
    public com.badlogic.gdx.Files getFiles() {
        return this.files;
    }

    @Override // com.badlogic.gdx.Application
    public com.badlogic.gdx.Graphics getGraphics() {
        return this.graphics;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public android.os.Handler getHandler() {
        return this.handler;
    }

    @Override // com.badlogic.gdx.Application
    public long getJavaHeap() {
        return java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> getLifecycleListeners() {
        return this.lifecycleListeners;
    }

    @Override // com.badlogic.gdx.Application
    public int getLogLevel() {
        return this.logLevel;
    }

    @Override // com.badlogic.gdx.Application
    public long getNativeHeap() {
        return android.os.Debug.getNativeHeapAllocatedSize();
    }

    @Override // com.badlogic.gdx.Application
    public com.badlogic.gdx.Preferences getPreferences(java.lang.String str) {
        return new com.badlogic.gdx.backends.android.AndroidPreferences(getActivity().getSharedPreferences(str, 0));
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public com.badlogic.gdx.utils.Array<java.lang.Runnable> getRunnables() {
        return this.runnables;
    }

    @Override // com.badlogic.gdx.Application
    public com.badlogic.gdx.Application.ApplicationType getType() {
        return com.badlogic.gdx.Application.ApplicationType.Android;
    }

    @Override // com.badlogic.gdx.Application
    public int getVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public android.view.WindowManager getWindowManager() {
        return (android.view.WindowManager) getContext().getSystemService("window");
    }

    public android.view.View initializeForView(com.badlogic.gdx.ApplicationListener applicationListener) {
        return initializeForView(applicationListener, new com.badlogic.gdx.backends.android.AndroidApplicationConfiguration());
    }

    public android.view.View initializeForView(com.badlogic.gdx.ApplicationListener applicationListener, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration) {
        if (getVersion() < 8) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("LibGDX requires Android API Level 8 or later.");
        }
        setApplicationLogger(new com.badlogic.gdx.backends.android.AndroidApplicationLogger());
        com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy = androidApplicationConfiguration.resolutionStrategy;
        if (resolutionStrategy == null) {
            resolutionStrategy = new com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy();
        }
        this.graphics = new com.badlogic.gdx.backends.android.AndroidGraphics(this, androidApplicationConfiguration, resolutionStrategy);
        this.files = new com.badlogic.gdx.backends.android.AndroidFiles(getResources().getAssets(), getActivity().getFilesDir().getAbsolutePath(), androidApplicationConfiguration.sdcard);
        this.listener = applicationListener;
        this.handler = new android.os.Handler();
        com.badlogic.gdx.Gdx.app = this;
        com.badlogic.gdx.Gdx.files = getFiles();
        com.badlogic.gdx.Gdx.graphics = getGraphics();
        createWakeLock(androidApplicationConfiguration.useWakelock);
        useImmersiveMode(androidApplicationConfiguration.useImmersiveMode);
        if (androidApplicationConfiguration.useImmersiveMode && getVersion() >= 19) {
            try {
                com.badlogic.gdx.backends.android.AndroidVisibilityListener.class.getDeclaredMethod("createListener", com.badlogic.gdx.backends.android.AndroidApplicationBase.class).invoke(com.badlogic.gdx.backends.android.AndroidVisibilityListener.class.newInstance(), this);
            } catch (java.lang.Exception e) {
                log("AndroidApplication", "Failed to create AndroidVisibilityListener", e);
            }
        }
        return this.graphics.getView();
    }

    @Override // com.badlogic.gdx.Application
    public void log(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.badlogic.gdx.Application
    public void log(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        synchronized (this.u) {
            int i3 = 0;
            while (true) {
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.backends.android.AndroidEventListener> array = this.u;
                if (i3 < array.size) {
                    array.get(i3).onActivityResult(i, i2, intent);
                    i3++;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.app.Activity activity) {
        if (activity instanceof com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks) {
            this.callbacks = (com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks) activity;
        } else if (getParentFragment() instanceof com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks) {
            this.callbacks = (com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks) getParentFragment();
        } else {
            if (!(getTargetFragment() instanceof com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks)) {
                throw new java.lang.RuntimeException("Missing AndroidFragmentApplication.Callbacks. Please implement AndroidFragmentApplication.Callbacks on the parent activity, fragment or target fragment.");
            }
            this.callbacks = (com.badlogic.gdx.backends.android.AndroidFragmentApplication.Callbacks) getTargetFragment();
        }
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        com.badlogic.gdx.backends.android.AndroidGraphics androidGraphics = this.graphics;
        if (androidGraphics != null) {
            androidGraphics.clearManagedCaches();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        com.badlogic.gdx.backends.android.AndroidGraphics androidGraphics = this.graphics;
        if (androidGraphics != null) {
            androidGraphics.clearManagedCaches();
        }
        super.onDetach();
        this.callbacks = null;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        boolean isContinuousRendering = this.graphics.isContinuousRendering();
        boolean z = com.badlogic.gdx.backends.android.AndroidGraphics.x;
        com.badlogic.gdx.backends.android.AndroidGraphics.x = true;
        this.graphics.setContinuousRendering(true);
        this.t.execute(new com.badlogic.gdx.backends.android.AndroidFragmentApplication.AnonymousClass1());
        this.graphics.pause();
        if (isRemoving() || b() || getActivity().isFinishing()) {
            this.graphics.clearManagedCaches();
            this.isDestroyed = true;
            this.graphics.a();
            this.graphics.b();
        }
        com.badlogic.gdx.backends.android.AndroidGraphics.x = z;
        this.graphics.setContinuousRendering(isContinuousRendering);
        this.graphics.onPauseGLSurfaceView();
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        com.badlogic.gdx.Gdx.app = this;
        com.badlogic.gdx.Gdx.files = getFiles();
        com.badlogic.gdx.Gdx.graphics = getGraphics();
        com.badlogic.gdx.backends.android.AndroidGraphics androidGraphics = this.graphics;
        if (androidGraphics != null) {
            androidGraphics.onResumeGLSurfaceView();
        }
        if (this.firstResume) {
            this.firstResume = false;
        } else {
            this.graphics.resume();
        }
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(java.lang.Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.add(runnable);
            com.badlogic.gdx.Gdx.graphics.requestRendering();
        }
    }

    public void removeAndroidEventListener(com.badlogic.gdx.backends.android.AndroidEventListener androidEventListener) {
        synchronized (this.u) {
            this.u.removeValue(androidEventListener, true);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void removeLifecycleListener(com.badlogic.gdx.LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.removeValue(lifecycleListener, true);
        }
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public void runOnUiThread(java.lang.Runnable runnable) {
        getActivity().runOnUiThread(runnable);
    }

    @Override // com.badlogic.gdx.Application
    public void setApplicationLogger(com.badlogic.gdx.ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override // com.badlogic.gdx.Application
    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    @android.annotation.TargetApi(19)
    public void useImmersiveMode(boolean z) {
        if (!z || getVersion() < 19) {
            return;
        }
        try {
            android.view.View.class.getMethod("setSystemUiVisibility", java.lang.Integer.TYPE).invoke(this.graphics.getView(), 5894);
        } catch (java.lang.Exception e) {
            log("AndroidApplication", "Failed to setup immersive mode, a throwable has occurred.", e);
        }
    }
}

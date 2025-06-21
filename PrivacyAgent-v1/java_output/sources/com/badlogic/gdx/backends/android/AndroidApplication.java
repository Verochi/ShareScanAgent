package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidApplication extends androidx.fragment.app.FragmentActivity implements com.badlogic.gdx.backends.android.AndroidApplicationBase {
    protected com.badlogic.gdx.ApplicationLogger applicationLogger;
    protected com.badlogic.gdx.backends.android.AndroidFiles files;
    protected com.badlogic.gdx.backends.android.AndroidGraphics graphics;
    public android.os.Handler handler;
    protected com.badlogic.gdx.ApplicationListener listener;
    protected boolean firstResume = true;
    protected final com.badlogic.gdx.utils.Array<java.lang.Runnable> runnables = new com.badlogic.gdx.utils.Array<>();
    protected final com.badlogic.gdx.utils.Array<java.lang.Runnable> executedRunnables = new com.badlogic.gdx.utils.Array<>();
    protected final com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> lifecycleListeners = new com.badlogic.gdx.utils.SnapshotArray<>(com.badlogic.gdx.LifecycleListener.class);
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.backends.android.AndroidEventListener> n = new com.badlogic.gdx.utils.Array<>();
    protected int logLevel = 2;
    protected boolean useImmersiveMode = false;
    protected boolean hideStatusBar = false;
    public int t = -1;
    public boolean u = false;

    /* renamed from: com.badlogic.gdx.backends.android.AndroidApplication$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.badlogic.gdx.backends.android.AndroidApplication.this.finish();
        }
    }

    static {
        com.badlogic.gdx.utils.GdxNativesLoader.load();
    }

    public final void a(com.badlogic.gdx.ApplicationListener applicationListener, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration, boolean z) {
        if (getVersion() < 8) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("LibGDX requires Android API Level 8 or later.");
        }
        setApplicationLogger(new com.badlogic.gdx.backends.android.AndroidApplicationLogger());
        com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy = androidApplicationConfiguration.resolutionStrategy;
        if (resolutionStrategy == null) {
            resolutionStrategy = new com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy();
        }
        this.graphics = new com.badlogic.gdx.backends.android.AndroidGraphics(this, androidApplicationConfiguration, resolutionStrategy);
        getFilesDir();
        this.files = new com.badlogic.gdx.backends.android.AndroidFiles(getAssets(), getFilesDir().getAbsolutePath(), androidApplicationConfiguration.sdcard);
        this.listener = applicationListener;
        this.handler = new android.os.Handler();
        this.useImmersiveMode = androidApplicationConfiguration.useImmersiveMode;
        this.hideStatusBar = androidApplicationConfiguration.hideStatusBar;
        com.badlogic.gdx.Gdx.app = this;
        com.badlogic.gdx.Gdx.files = getFiles();
        com.badlogic.gdx.Gdx.graphics = getGraphics();
        if (!z) {
            try {
                requestWindowFeature(1);
            } catch (java.lang.Exception e) {
                log("AndroidApplication", "Content already displayed, cannot request FEATURE_NO_TITLE", e);
            }
            getWindow().setFlags(1024, 1024);
            getWindow().clearFlags(2048);
            setContentView(this.graphics.getView(), createLayoutParams());
        }
        createWakeLock(androidApplicationConfiguration.useWakelock);
        hideStatusBar(this.hideStatusBar);
        useImmersiveMode(this.useImmersiveMode);
        if (!this.useImmersiveMode || getVersion() < 19) {
            return;
        }
        try {
            com.badlogic.gdx.backends.android.AndroidVisibilityListener.class.getDeclaredMethod("createListener", com.badlogic.gdx.backends.android.AndroidApplicationBase.class).invoke(com.badlogic.gdx.backends.android.AndroidVisibilityListener.class.newInstance(), this);
        } catch (java.lang.Exception e2) {
            log("AndroidApplication", "Failed to create AndroidVisibilityListener", e2);
        }
    }

    public void addAndroidEventListener(com.badlogic.gdx.backends.android.AndroidEventListener androidEventListener) {
        synchronized (this.n) {
            this.n.add(androidEventListener);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void addLifecycleListener(com.badlogic.gdx.LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.add(lifecycleListener);
        }
    }

    public android.widget.FrameLayout.LayoutParams createLayoutParams() {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public void createWakeLock(boolean z) {
        if (z) {
            getWindow().addFlags(128);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(java.lang.String str, java.lang.String str2) {
        if (this.logLevel >= 3) {
            getApplicationLogger().debug(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (this.logLevel >= 3) {
            getApplicationLogger().debug(str, str2, th);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(java.lang.String str, java.lang.String str2) {
        if (this.logLevel >= 1) {
            getApplicationLogger().error(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (this.logLevel >= 1) {
            getApplicationLogger().error(str, str2, th);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void exit() {
        this.handler.post(new com.badlogic.gdx.backends.android.AndroidApplication.AnonymousClass1());
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
        return getWindow();
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    public android.content.Context getContext() {
        return this;
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
        return new com.badlogic.gdx.backends.android.AndroidPreferences(getSharedPreferences(str, 0));
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

    public void hideStatusBar(boolean z) {
        if (!z || getVersion() < 11) {
            return;
        }
        android.view.View decorView = getWindow().getDecorView();
        try {
            java.lang.reflect.Method method = android.view.View.class.getMethod("setSystemUiVisibility", java.lang.Integer.TYPE);
            if (getVersion() <= 13) {
                method.invoke(decorView, 0);
            }
            method.invoke(decorView, 1);
        } catch (java.lang.Exception e) {
            log("AndroidApplication", "Can't hide status bar", e);
        }
    }

    public void initialize(com.badlogic.gdx.ApplicationListener applicationListener) {
        initialize(applicationListener, new com.badlogic.gdx.backends.android.AndroidApplicationConfiguration());
    }

    public void initialize(com.badlogic.gdx.ApplicationListener applicationListener, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration) {
        a(applicationListener, androidApplicationConfiguration, false);
    }

    public android.view.View initializeForView(com.badlogic.gdx.ApplicationListener applicationListener) {
        return initializeForView(applicationListener, new com.badlogic.gdx.backends.android.AndroidApplicationConfiguration());
    }

    public android.view.View initializeForView(com.badlogic.gdx.ApplicationListener applicationListener, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration androidApplicationConfiguration) {
        a(applicationListener, androidApplicationConfiguration, true);
        return this.graphics.getView();
    }

    @Override // com.badlogic.gdx.Application
    public void log(java.lang.String str, java.lang.String str2) {
        if (this.logLevel >= 2) {
            getApplicationLogger().log(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (this.logLevel >= 2) {
            getApplicationLogger().log(str, str2, th);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        synchronized (this.n) {
            int i3 = 0;
            while (true) {
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.backends.android.AndroidEventListener> array = this.n;
                if (i3 < array.size) {
                    array.get(i3).onActivityResult(i, i2, intent);
                    i3++;
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        boolean isContinuousRendering = this.graphics.isContinuousRendering();
        boolean z = com.badlogic.gdx.backends.android.AndroidGraphics.x;
        com.badlogic.gdx.backends.android.AndroidGraphics.x = true;
        this.graphics.setContinuousRendering(true);
        this.graphics.pause();
        if (isFinishing()) {
            this.graphics.clearManagedCaches();
            this.graphics.a();
        }
        com.badlogic.gdx.backends.android.AndroidGraphics.x = z;
        this.graphics.setContinuousRendering(isContinuousRendering);
        this.graphics.onPauseGLSurfaceView();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
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
        this.u = true;
        int i = this.t;
        if (i == 1 || i == -1) {
            this.u = false;
        }
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        useImmersiveMode(this.useImmersiveMode);
        hideStatusBar(this.hideStatusBar);
        if (!z) {
            this.t = 0;
            return;
        }
        this.t = 1;
        if (this.u) {
            this.u = false;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(java.lang.Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.add(runnable);
            com.badlogic.gdx.Gdx.graphics.requestRendering();
        }
    }

    public void removeAndroidEventListener(com.badlogic.gdx.backends.android.AndroidEventListener androidEventListener) {
        synchronized (this.n) {
            this.n.removeValue(androidEventListener, true);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void removeLifecycleListener(com.badlogic.gdx.LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.removeValue(lifecycleListener, true);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void setApplicationLogger(com.badlogic.gdx.ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override // com.badlogic.gdx.Application
    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    @Override // com.badlogic.gdx.backends.android.AndroidApplicationBase
    @android.annotation.TargetApi(19)
    public void useImmersiveMode(boolean z) {
        if (!z || getVersion() < 19) {
            return;
        }
        try {
            android.view.View.class.getMethod("setSystemUiVisibility", java.lang.Integer.TYPE).invoke(getWindow().getDecorView(), 5894);
        } catch (java.lang.Exception e) {
            log("AndroidApplication", "Can't set immersive mode", e);
        }
    }
}

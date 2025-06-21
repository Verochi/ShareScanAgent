package com.alimm.tanx.core.ut.core;

/* loaded from: classes.dex */
public class LifeCycleManager {
    private static final java.lang.String TAG = "LifeCycleManager";
    private static volatile com.alimm.tanx.core.ut.core.LifeCycleManager instance;
    private com.alimm.tanx.core.ut.core.LifeCycleManager.ActivityLifeCycle activityLifeCycle;
    private volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> activityVisibleMap = new java.util.concurrent.ConcurrentHashMap<>(1000);
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack> appVisibleCallBacks = new java.util.concurrent.ConcurrentHashMap<>();
    private boolean nowBackground = false;
    private boolean secondUp = false;

    public class ActivityLifeCycle implements android.app.Application.ActivityLifecycleCallbacks {
        private ActivityLifeCycle() {
        }

        public /* synthetic */ ActivityLifeCycle(com.alimm.tanx.core.ut.core.LifeCycleManager lifeCycleManager, com.alimm.tanx.core.ut.core.LifeCycleManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, "onActivityCreated ，activity->" + activity.getClass().getName() + " activitySize->" + com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.size());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, "onActivityPaused，activity.");
            try {
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, "onActivityPaused，activity->" + activity.getClass().getName() + " activitySize->" + com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.size());
                java.lang.String name = activity.getClass().getName();
                if (com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap != null && com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.get(name) != null) {
                    int intValue = ((java.lang.Integer) com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.get(name)).intValue();
                    if (intValue > 1) {
                        com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.put(name, java.lang.Integer.valueOf(intValue - 1));
                    } else {
                        com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.remove(name);
                    }
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            try {
                java.lang.String name = activity.getClass().getName();
                if (com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.get(activity.getClass().getName()) == null) {
                    com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.put(name, 1);
                } else {
                    com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.put(activity.getClass().getName(), java.lang.Integer.valueOf(((java.lang.Integer) com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.get(activity.getClass().getName())).intValue() + 1));
                }
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, "onActivityResumed ，activity->" + activity.getClass().getName() + " activitySize->" + com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.size());
                com.alimm.tanx.core.ut.core.LifeCycleManager.this.setStatus();
                com.alimm.tanx.core.ut.core.LifeCycleManager.this.appVisibleExecute();
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, e);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, "onActivityStarted :，activity->" + activity.getClass().getName() + " activitySize->" + com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.size());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ut.core.LifeCycleManager.TAG, "onActivityStoppedactivity->" + activity.getClass().getName() + " activitySize->" + com.alimm.tanx.core.ut.core.LifeCycleManager.this.activityVisibleMap.size());
            com.alimm.tanx.core.ut.core.LifeCycleManager.this.setStatus();
            com.alimm.tanx.core.ut.core.LifeCycleManager.this.appBackgroundExecute();
        }
    }

    public interface AppVisibleCallBack {
        void appVisibleCallBack(boolean z, boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appBackgroundExecute() {
        notice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appVisibleExecute() {
        notice();
    }

    public static com.alimm.tanx.core.ut.core.LifeCycleManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.ut.core.LifeCycleManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.ut.core.LifeCycleManager();
                }
            }
        }
        return instance;
    }

    private void notice() {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack> concurrentHashMap = this.appVisibleCallBacks;
        if (concurrentHashMap != null) {
            for (java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack> entry : concurrentHashMap.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().appVisibleCallBack(this.nowBackground, this.secondUp);
                } else {
                    unRegister(entry.getKey());
                }
            }
        }
    }

    public void init() {
        this.activityLifeCycle = new com.alimm.tanx.core.ut.core.LifeCycleManager.ActivityLifeCycle(this, null);
        com.alimm.tanx.core.TanxCoreSdk.getApplication().registerActivityLifecycleCallbacks(this.activityLifeCycle);
    }

    public void register(java.lang.String str, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack appVisibleCallBack) {
        if (this.appVisibleCallBacks == null) {
            this.appVisibleCallBacks = new java.util.concurrent.ConcurrentHashMap<>();
        }
        this.appVisibleCallBacks.put(str, appVisibleCallBack);
    }

    public boolean setStatus() {
        if (!this.nowBackground || this.activityVisibleMap.size() <= 0) {
            this.secondUp = false;
        } else {
            this.secondUp = true;
        }
        this.nowBackground = this.activityVisibleMap.size() <= 0;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("UserReport :当前前后台状态：->");
        sb.append(this.nowBackground ? "后台" : "前台");
        com.alimm.tanx.core.utils.LogUtils.d(TAG, sb.toString());
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "UserReport :activityVisibleMap：->" + this.activityVisibleMap.toString());
        return this.nowBackground;
    }

    public void unRegister(java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack> concurrentHashMap;
        try {
            if (android.text.TextUtils.isEmpty(str) || (concurrentHashMap = this.appVisibleCallBacks) == null) {
                return;
            }
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().equals(str)) {
                    it.remove();
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    public void unRegisterAll() {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack> concurrentHashMap = this.appVisibleCallBacks;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }
}

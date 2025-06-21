package com.sensorsdata.sf.ui.view;

@com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreen
/* loaded from: classes19.dex */
public class DialogActivity extends android.app.Activity {
    private static final int DELAY_TIME = 1000;
    private static final int MSG_SCHEDULED = 0;
    private static final java.lang.String TAG = "DialogActivity";
    private java.lang.ref.WeakReference<android.app.Activity> mActivityWeakReference;
    private android.os.Handler mHandlerTimer;
    private java.lang.String mUUID;

    /* renamed from: com.sensorsdata.sf.ui.view.DialogActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (com.sensorsdata.sf.ui.view.DialogActivity.this.mActivityWeakReference != null && com.sensorsdata.sf.ui.view.DialogActivity.this.mActivityWeakReference.get() != null && !((android.app.Activity) com.sensorsdata.sf.ui.view.DialogActivity.this.mActivityWeakReference.get()).isFinishing() && !((android.app.Activity) com.sensorsdata.sf.ui.view.DialogActivity.this.mActivityWeakReference.get()).isDestroyed()) {
                com.sensorsdata.sf.ui.view.DialogActivity.this.sendScheduledMsg();
            } else {
                com.sensorsdata.sf.ui.view.DialogActivity.this.handleFailed();
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.view.DialogActivity.TAG, "current activity is destroy");
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DialogActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private android.view.View buildView(com.sensorsdata.sf.ui.view.DynamicViewHelper dynamicViewHelper, com.sensorsdata.sf.ui.view.AbstractViewDynamic abstractViewDynamic) {
        if (abstractViewDynamic instanceof com.sensorsdata.sf.ui.view.ButtonDynamic) {
            return dynamicViewHelper.handleButton(this, (com.sensorsdata.sf.ui.view.ButtonDynamic) abstractViewDynamic);
        }
        if (abstractViewDynamic instanceof com.sensorsdata.sf.ui.view.LinkViewDynamic) {
            return dynamicViewHelper.handleLinkTextView(this, (com.sensorsdata.sf.ui.view.LinkViewDynamic) abstractViewDynamic);
        }
        if (abstractViewDynamic instanceof com.sensorsdata.sf.ui.view.TextViewDynamic) {
            return dynamicViewHelper.handleTextView(this, (com.sensorsdata.sf.ui.view.TextViewDynamic) abstractViewDynamic);
        }
        if (abstractViewDynamic instanceof com.sensorsdata.sf.ui.view.ImageViewDynamic) {
            return dynamicViewHelper.handleImageView(this, (com.sensorsdata.sf.ui.view.ImageViewDynamic) abstractViewDynamic);
        }
        if (abstractViewDynamic instanceof com.sensorsdata.sf.ui.view.GifViewDynamic) {
            return dynamicViewHelper.handleGifView(this, (com.sensorsdata.sf.ui.view.GifViewDynamic) abstractViewDynamic);
        }
        return null;
    }

    private android.view.View createView(java.lang.String str, java.lang.String str2) {
        try {
            com.sensorsdata.sf.ui.view.DynamicViewHelper dynamicViewHelper = new com.sensorsdata.sf.ui.view.DynamicViewHelper(str2, android.text.TextUtils.isEmpty(str2) ? com.sensorsdata.sf.ui.track.SFTrackHelper.buildPlanProperty(null) : com.sensorsdata.sf.ui.track.SFTrackHelper.buildPlanProperty(com.sensorsdata.sf.core.SFContextManger.getInstance().getPopupPlan(java.lang.Long.parseLong(str2))));
            com.sensorsdata.sf.ui.view.AbstractViewDynamic viewDynamic = dynamicViewHelper.getViewDynamic(str);
            dynamicViewHelper.removeViewDynamic(str);
            if (viewDynamic instanceof com.sensorsdata.sf.ui.view.MaskViewDynamic) {
                android.widget.FrameLayout handleMaskLayout = dynamicViewHelper.handleMaskLayout(this, (com.sensorsdata.sf.ui.view.MaskViewDynamic) viewDynamic);
                handleMaskLayout.addView(traverseView(dynamicViewHelper, ((com.sensorsdata.sf.ui.view.MaskViewDynamic) viewDynamic).getChildDynamic()));
                return handleMaskLayout;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailed() {
        com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder dynamicViewJsonBuilder;
        try {
            java.util.HashMap<java.lang.String, com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder> hashMap = com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.dynamicViewJsonBuilderHashMap;
            synchronized (hashMap) {
                if (!android.text.TextUtils.isEmpty(this.mUUID) && hashMap.containsKey(this.mUUID) && (dynamicViewJsonBuilder = hashMap.get(this.mUUID)) != null) {
                    dynamicViewJsonBuilder.handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.ACTIVITY_IN_BACKGROUND_FINISH);
                }
                finish();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void initHandlerTimer() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("DialogActivity-Loop-Thread");
        handlerThread.start();
        this.mHandlerTimer = new com.sensorsdata.sf.ui.view.DialogActivity.AnonymousClass1(handlerThread.getLooper());
    }

    private void removeResources() {
        try {
            java.util.HashMap<java.lang.String, com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder> hashMap = com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.dynamicViewJsonBuilderHashMap;
            synchronized (hashMap) {
                if (!android.text.TextUtils.isEmpty(this.mUUID)) {
                    hashMap.remove(this.mUUID);
                }
            }
            android.os.Handler handler = this.mHandlerTimer;
            if (handler != null) {
                handler.removeMessages(0);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendScheduledMsg() {
        try {
            if (this.mHandlerTimer.hasMessages(0)) {
                return;
            }
            this.mHandlerTimer.sendEmptyMessageDelayed(0, 1000L);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private android.view.View traverseView(com.sensorsdata.sf.ui.view.DynamicViewHelper dynamicViewHelper, com.sensorsdata.sf.ui.view.AbstractViewDynamic abstractViewDynamic) {
        android.widget.FrameLayout frameLayout;
        android.widget.LinearLayout linearLayout;
        try {
            if (!(abstractViewDynamic instanceof com.sensorsdata.sf.ui.view.FrameLayoutDynamic) || (frameLayout = (android.widget.FrameLayout) abstractViewDynamic.createView(this)) == null || (linearLayout = ((com.sensorsdata.sf.ui.view.FrameLayoutDynamic) abstractViewDynamic).getLinearLayout()) == null) {
                return null;
            }
            linearLayout.setOnClickListener(new com.sensorsdata.sf.ui.view.DialogActivity.AnonymousClass2());
            for (com.sensorsdata.sf.ui.view.AbstractViewDynamic abstractViewDynamic2 : ((com.sensorsdata.sf.ui.view.FrameLayoutDynamic) abstractViewDynamic).getChildViews()) {
                android.view.View traverseView = abstractViewDynamic2 instanceof com.sensorsdata.sf.ui.view.FrameLayoutDynamic ? traverseView(dynamicViewHelper, abstractViewDynamic2) : buildView(dynamicViewHelper, abstractViewDynamic2);
                if (traverseView != null) {
                    linearLayout.addView(traverseView);
                }
            }
            return frameLayout;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        return null;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        removeResources();
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "onCreate");
        try {
            if (getIntent().hasExtra(com.sensorsdata.sf.ui.view.UIProperty.TAG)) {
                this.mUUID = getIntent().getStringExtra(com.sensorsdata.sf.ui.view.UIProperty.TAG);
                java.lang.String stringExtra = getIntent().getStringExtra(com.sensorsdata.sf.ui.view.UIProperty.plan_id);
                this.mActivityWeakReference = com.sensorsdata.sf.core.SFContextManger.getInstance().getAppStateManager().getWeakCurrentActivity();
                initHandlerTimer();
                android.view.View createView = createView(this.mUUID, stringExtra);
                if (createView != null) {
                    setContentView(createView);
                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, "show activity");
                    return;
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeResources();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "onResume");
        com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.dialogIsShowing = true;
        java.util.HashMap<java.lang.String, com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder> hashMap = com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.dynamicViewJsonBuilderHashMap;
        synchronized (hashMap) {
            if (!android.text.TextUtils.isEmpty(this.mUUID) && hashMap.containsKey(this.mUUID)) {
                com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder dynamicViewJsonBuilder = hashMap.get(this.mUUID);
                if (dynamicViewJsonBuilder != null) {
                    dynamicViewJsonBuilder.handleCampaignSuccess(true);
                }
                hashMap.remove(this.mUUID);
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "onStart");
        sendScheduledMsg();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "onStop");
        com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.dialogIsShowing = false;
        android.os.Handler handler = this.mHandlerTimer;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }
}

package com.baidu.mobads.sdk.api;

/* loaded from: classes29.dex */
public class MobRewardVideoActivity extends android.app.Activity {
    private static com.baidu.mobads.sdk.api.IActivityImpl tempRewardVideo;
    private com.baidu.mobads.sdk.api.IActivityImpl mRewardVideo;

    public static void setActivityImp(com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl) {
        tempRewardVideo = iActivityImpl;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null ? iActivityImpl.onBackPressed() : false) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@androidx.annotation.NonNull android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = tempRewardVideo;
        if (iActivityImpl != null && this.mRewardVideo == null) {
            this.mRewardVideo = iActivityImpl;
            tempRewardVideo = null;
        }
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl2 = this.mRewardVideo;
        if (iActivityImpl2 != null) {
            iActivityImpl2.setActivity(this);
            this.mRewardVideo.onCreate(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
            this.mRewardVideo = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = tempRewardVideo;
        if (iActivityImpl != null && this.mRewardVideo == null) {
            this.mRewardVideo = iActivityImpl;
            tempRewardVideo = null;
        }
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl2 = this.mRewardVideo;
        if (iActivityImpl2 != null) {
            iActivityImpl2.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        try {
            java.lang.ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
                android.os.Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
                if (bundle2 != null) {
                    bundle2.setClassLoader(classLoader);
                }
            }
            super.onRestoreInstanceState(bundle);
            com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
            if (iActivityImpl != null) {
                iActivityImpl.onRestoreInstanceState(bundle);
            }
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(i, i2);
        com.baidu.mobads.sdk.api.IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i, i2);
        }
    }
}

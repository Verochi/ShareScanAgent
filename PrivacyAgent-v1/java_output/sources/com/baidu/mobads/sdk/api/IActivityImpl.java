package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IActivityImpl {
    boolean dispatchKeyEvent(android.view.KeyEvent keyEvent);

    boolean dispatchTouchEvent(android.view.MotionEvent motionEvent);

    void onActivityResult(int i, int i2, android.content.Intent intent);

    void onAttachedToWindow();

    boolean onBackPressed();

    void onConfigurationChanged(android.content.res.Configuration configuration);

    void onCreate(android.os.Bundle bundle);

    void onDestroy();

    void onDetachedFromWindow();

    boolean onKeyDown(int i, android.view.KeyEvent keyEvent);

    boolean onKeyUp(int i, android.view.KeyEvent keyEvent);

    void onNewIntent(android.content.Intent intent);

    void onPause();

    void onRestoreInstanceState(android.os.Bundle bundle);

    void onResume();

    void onSaveInstanceState(android.os.Bundle bundle);

    void onStart();

    void onStop();

    boolean onTouchEvent(android.view.MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void overridePendingTransition(int i, int i2);

    void setActivity(android.app.Activity activity);

    void setLpBussParam(org.json.JSONObject jSONObject);
}

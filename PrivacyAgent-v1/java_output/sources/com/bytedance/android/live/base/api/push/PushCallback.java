package com.bytedance.android.live.base.api.push;

/* loaded from: classes.dex */
public interface PushCallback {
    void onFailed(java.lang.Throwable th);

    void onSuccess(com.bytedance.android.live.base.api.push.model.PushData pushData);
}

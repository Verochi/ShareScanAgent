package com.tencent.tauth;

/* loaded from: classes19.dex */
public interface IUiListener {
    void onCancel();

    void onComplete(java.lang.Object obj);

    void onError(com.tencent.tauth.UiError uiError);

    void onWarning(int i);
}

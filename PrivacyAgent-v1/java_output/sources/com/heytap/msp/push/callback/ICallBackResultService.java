package com.heytap.msp.push.callback;

/* loaded from: classes22.dex */
public interface ICallBackResultService {
    void onError(int i, java.lang.String str);

    void onGetNotificationStatus(int i, int i2);

    void onGetPushStatus(int i, int i2);

    void onRegister(int i, java.lang.String str);

    void onSetPushTime(int i, java.lang.String str);

    void onUnRegister(int i);
}

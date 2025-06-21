package com.huawei.secure.android.common.webview;

/* loaded from: classes22.dex */
public interface WebViewLoadCallBack {

    public enum ErrorCode {
        HTTP_URL,
        URL_NOT_IN_WHITE_LIST,
        OTHER
    }

    void onCheckError(java.lang.String str, com.huawei.secure.android.common.webview.WebViewLoadCallBack.ErrorCode errorCode);
}

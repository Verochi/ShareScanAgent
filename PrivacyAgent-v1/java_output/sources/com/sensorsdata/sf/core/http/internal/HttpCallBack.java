package com.sensorsdata.sf.core.http.internal;

/* loaded from: classes19.dex */
public interface HttpCallBack {
    void onFailure(com.sensorsdata.sf.core.http.internal.HttpCall httpCall, com.sensorsdata.sf.core.http.internal.ResponseBody responseBody);

    void onSuccess(com.sensorsdata.sf.core.http.internal.HttpCall httpCall, com.sensorsdata.sf.core.http.internal.ResponseBody responseBody);
}

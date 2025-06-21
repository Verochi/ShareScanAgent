package com.umeng.analytics.filter;

/* loaded from: classes19.dex */
public class c implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback {
    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
    }

    public boolean onPreProcessImprintKey(java.lang.String str, java.lang.String str2) {
        return false;
    }
}

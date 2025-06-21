package com.tencent.mm.opensdk.diffdev;

/* loaded from: classes19.dex */
public interface IDiffDevOAuth {
    void addListener(com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener);

    boolean auth(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener);

    void detach();

    void removeAllListeners();

    void removeListener(com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener);

    boolean stopAuth();
}

package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTClientBidding {
    void loss(java.lang.Double d, java.lang.String str, java.lang.String str2);

    void setAdInteractionListener(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener);

    void setPrice(java.lang.Double d);

    void win(java.lang.Double d);
}

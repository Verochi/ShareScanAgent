package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTCodeGroupRit {

    public interface TTCodeGroupRitListener {
        void onFail(int i, java.lang.String str);

        void onSuccess(com.bytedance.sdk.openadsdk.TTCodeGroupRit tTCodeGroupRit);
    }

    java.lang.String getRit();

    int getSlotType();
}

package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface FilterWord {
    void addOption(com.bytedance.sdk.openadsdk.FilterWord filterWord);

    java.lang.String getId();

    boolean getIsSelected();

    java.lang.String getName();

    java.util.List<com.bytedance.sdk.openadsdk.FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z);
}

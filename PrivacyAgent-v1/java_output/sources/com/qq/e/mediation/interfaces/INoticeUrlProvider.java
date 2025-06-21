package com.qq.e.mediation.interfaces;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public interface INoticeUrlProvider {
    public static final java.lang.String IMPL_CLASS_NAME = "util.NoticeUrlProviderImpl";

    java.lang.String getAssembledLossNoticeUrl(java.lang.String str, java.lang.String str2, boolean z);

    java.lang.String getAssembledWinNoticeUrl(java.lang.String str, java.lang.String str2, boolean z);

    java.lang.String getOtherAssembledLossNoticeUrl(java.lang.String str, java.lang.String str2);
}

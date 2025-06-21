package com.anythink.expressad.atsignalcommon.mraid;

/* loaded from: classes12.dex */
public interface IMraidSignalCommunication {
    void close();

    void expand(java.lang.String str, boolean z);

    com.anythink.expressad.foundation.d.c getMraidCampaign();

    void open(java.lang.String str);

    void unload();

    void useCustomClose(boolean z);
}

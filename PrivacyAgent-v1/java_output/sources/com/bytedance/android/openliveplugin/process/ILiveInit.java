package com.bytedance.android.openliveplugin.process;

/* loaded from: classes.dex */
public interface ILiveInit {
    void initLiveInMain(com.bytedance.android.live.base.api.ILiveHostContextParam iLiveHostContextParam, java.lang.String str, java.lang.Boolean bool);

    void initLiveProcess(android.content.Context context);

    void registerSubProcessStub();
}

package com.alimm.tanx.core.ad;

/* loaded from: classes.dex */
public interface ITanxCoreManager {
    com.alimm.tanx.core.ad.loader.ITanxRequestLoader createRequestLoader(android.content.Context context);

    java.lang.String getSDKVersion();
}

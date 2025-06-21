package com.alimm.tanx.ui;

/* loaded from: classes.dex */
public class tanxu_for implements com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker {
    public tanxu_for(com.alimm.tanx.ui.TanxThirdInstanceDefault tanxThirdInstanceDefault) {
    }

    @Override // com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker
    public void track(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        com.alimm.tanx.ui.ut.AdUtAnalytics.getInstance().track(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }
}

package com.alimm.tanx.ui.ut;

/* loaded from: classes.dex */
public class AdUtAnalytics implements com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker, com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "AdUtAnalytics";
    private static com.alimm.tanx.ui.ut.AdUtAnalytics sInstance;
    volatile int lastUtItemBeanHashCode = 0;

    private AdUtAnalytics() {
    }

    public static com.alimm.tanx.ui.ut.AdUtAnalytics getInstance() {
        if (sInstance == null) {
            synchronized (com.alimm.tanx.ui.ut.AdUtAnalytics.class) {
                if (sInstance == null) {
                    sInstance = new com.alimm.tanx.ui.ut.AdUtAnalytics();
                }
            }
        }
        return sInstance;
    }

    public static boolean isOpen(java.lang.String str) {
        java.lang.Boolean bool;
        com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null) {
            return true;
        }
        com.alimm.tanx.core.orange.bean.OrangeUtBean orangeUtBean = orangeBean.ut;
        if (orangeUtBean != null && (bool = orangeUtBean.utSwitch) != null && !bool.booleanValue()) {
            return false;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = orangeBean.commonSwitch;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return true;
        }
        return com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(orangeBean.commonSwitch.get(str));
    }

    public synchronized void send(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "start—send-ut");
        try {
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "send UT exception.", e);
        }
        if (!isOpen(str)) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "埋点开关为false，终止上报");
            return;
        }
        if (com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean() != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.alimm.tanx.core.orange.OrangeManager.getInstance().getOrangeBean().version);
            sb.append("");
            map.put("orangeVersion", sb.toString());
        }
        com.alimm.tanx.core.ut.bean.UtItemBean utItemBean = new com.alimm.tanx.core.ut.bean.UtItemBean(str3, str2, str, i, i2, str4, str5, str6, map, str7);
        int hashCode = utItemBean.hashCode();
        if (this.lastUtItemBeanHashCode == 0 || this.lastUtItemBeanHashCode != hashCode) {
            com.alimm.tanx.core.ut.core.UserReportManager.getInstance().send(utItemBean);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("\nlastUtItemBean ");
            sb2.append(this.lastUtItemBeanHashCode);
            java.lang.String sb3 = sb2.toString();
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(sb3);
            sb4.append("\nutItemBean ");
            sb4.append(hashCode);
            java.lang.String sb5 = sb4.toString();
            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
            sb6.append("sendUtData:");
            sb6.append(utItemBean.toString());
            sb6.append(sb5);
            com.alimm.tanx.core.utils.LogUtils.d(TAG, sb6.toString());
            this.lastUtItemBeanHashCode = hashCode;
        } else {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "Send UT End Duplicate Data");
        }
        com.alimm.tanx.core.utils.TanxTestLog.sendLog(str, map);
    }

    @Override // com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker
    public void track(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str7) {
        send(str, str2, str3, i, i2, str4, str5, str6, map, str7);
    }
}

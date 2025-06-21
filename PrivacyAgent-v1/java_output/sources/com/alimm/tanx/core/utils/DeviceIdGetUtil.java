package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class DeviceIdGetUtil implements com.alimm.tanx.core.utils.NotConfused {
    private static final int DEVICE_ID_GET_MAX_COUNT = 3;
    private static final java.lang.String TAG = "DeviceIdGetUtil-";
    private static com.alimm.tanx.core.utils.DeviceIdGetUtil instance;
    private volatile int imeiGetNowCount = 0;
    private volatile int oaidGetNowCount = 0;
    private volatile java.lang.String oaid = "";
    private volatile java.lang.String imei = "";

    /* renamed from: com.alimm.tanx.core.utils.DeviceIdGetUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tanx.onlyid.api.IGetter {
        final /* synthetic */ long tanxc_do;

        public AnonymousClass1(long j) {
            this.tanxc_do = j;
        }

        @Override // com.tanx.onlyid.api.IGetter
        public void oaidError(java.lang.Exception exc) {
            com.alimm.tanx.core.utils.LogUtils.e("DeviceIdGetUtil-oaidGet", exc);
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-oaidGet", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(exc), "");
            }
        }

        @Override // com.tanx.onlyid.api.IGetter
        public void oaidSucc(java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str)) {
                com.alimm.tanx.core.utils.DeviceIdGetUtil.this.oaid = str;
            }
            com.alimm.tanx.core.utils.LogUtils.d("DeviceIdGetUtil-oaidGet", str + "\ntime-> " + (java.lang.System.currentTimeMillis() - this.tanxc_do));
        }
    }

    private DeviceIdGetUtil() {
    }

    private void getImei4OnlyId(android.content.Context context, boolean z) {
        if (android.text.TextUtils.isEmpty(this.imei)) {
            java.lang.String imei = com.alimm.tanx.core.TanxCoreSdk.getConfig().getImei();
            if (!android.text.TextUtils.isEmpty(imei)) {
                this.imei = imei;
            }
            if (context == null) {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "getImei4OnlyId 设备id工具类未初始化，或入参context为空");
                return;
            }
            if (z) {
                this.oaid = com.tanx.onlyid.api.DeviceIdManager.getInstance().getIMEI(context, z);
                return;
            }
            if (com.alimm.tanx.core.TanxCoreSdk.getConfig().isImeiSwitch()) {
                if (this.imeiGetNowCount >= 3) {
                    return;
                }
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "通过api调用获取imei");
                java.lang.String imei2 = com.tanx.onlyid.api.DeviceIdManager.getInstance().getIMEI(context);
                if (!android.text.TextUtils.isEmpty(imei2)) {
                    this.imei = imei2;
                }
                this.imeiGetNowCount++;
            }
            com.alimm.tanx.core.utils.LogUtils.d("DeviceIdGetUtil-imeiGet", this.imei);
        }
    }

    public static com.alimm.tanx.core.utils.DeviceIdGetUtil getInstance() {
        if (instance == null) {
            synchronized (com.tanx.onlyid.api.DeviceIdManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.utils.DeviceIdGetUtil();
                }
            }
        }
        return instance;
    }

    private void getOaid4OnlyId(android.content.Context context, boolean z) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (android.text.TextUtils.isEmpty(this.oaid)) {
            java.lang.String oaid = com.alimm.tanx.core.TanxCoreSdk.getConfig().getOaid();
            if (!android.text.TextUtils.isEmpty(oaid)) {
                this.oaid = oaid;
            }
            if (context == null) {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "getOaid4OnlyId 设备id工具类未初始化，或入参context为空");
                return;
            }
            if (z) {
                this.oaid = com.tanx.onlyid.api.DeviceIdManager.getInstance().getOAID(context, z);
            } else {
                if (!com.alimm.tanx.core.TanxCoreSdk.getConfig().isOaidSwitch() || this.oaidGetNowCount >= 3) {
                    return;
                }
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "通过api调用获取oaid");
                com.tanx.onlyid.api.DeviceIdManager.getInstance().getOAID(context, false, new com.alimm.tanx.core.utils.DeviceIdGetUtil.AnonymousClass1(currentTimeMillis));
                this.oaidGetNowCount++;
            }
        }
    }

    public void getAllIdOnlyCache() {
        try {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "getAllIdOnlyCache");
            getImei(true);
            getOaid(true);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("DeviceIdGetUtil-getAllIdOnlyCache", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-getAllIdOnlyCache", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    public java.lang.String getImei() {
        return getImei(false);
    }

    public java.lang.String getImei(android.content.Context context, boolean z) {
        getImei4OnlyId(context, z);
        return this.imei;
    }

    public java.lang.String getImei(boolean z) {
        return getImei(com.alimm.tanx.core.TanxCoreSdk.getApplication(), z);
    }

    public java.lang.String getOaid() {
        return getOaid(false);
    }

    public java.lang.String getOaid(android.content.Context context, boolean z) {
        getOaid4OnlyId(context, z);
        return this.oaid;
    }

    public java.lang.String getOaid(boolean z) {
        return getOaid(com.alimm.tanx.core.TanxCoreSdk.getApplication(), z);
    }

    public void init(android.app.Application application) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "init");
        com.tanx.onlyid.api.DeviceIdManager.getInstance().init(application);
    }

    public void setImei(java.lang.String str) {
        this.imei = str;
    }

    public void setOaid(java.lang.String str) {
        this.oaid = str;
    }
}

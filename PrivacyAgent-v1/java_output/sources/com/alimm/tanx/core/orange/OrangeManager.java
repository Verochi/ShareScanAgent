package com.alimm.tanx.core.orange;

/* loaded from: classes.dex */
public class OrangeManager implements com.alimm.tanx.core.utils.NotConfused {
    public static final java.lang.String FEED_VIDEO_MAX_SIZE = "feedVideoMaxSize";
    private static final java.lang.String TAG = "OrangeManager";
    private static volatile com.alimm.tanx.core.orange.OrangeManager instance;
    private volatile com.alimm.tanx.core.orange.bean.OrangeBean orangeBean;
    private com.alimm.tanx.core.orange.OrangeInitListener orangeInitListener;

    /* renamed from: com.alimm.tanx.core.orange.OrangeManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.OrangeBean> {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.orange.OrangeManager.TAG, "orange配置拉取失败-> code:" + i + " reqId:" + str + "  error->" + str2);
            com.alimm.tanx.core.orange.OrangeManager.this.callBack2InitSucc();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("orange配置拉取失败-> code:");
            sb.append(i);
            sb.append("  error->");
            sb.append(str2);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(i, com.alimm.tanx.core.orange.OrangeManager.TAG, sb.toString(), "");
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.orange.bean.OrangeBean orangeBean) {
            if (orangeBean != null) {
                com.alimm.tanx.core.orange.OrangeManager.this.checkOrangeVersion2Write(orangeBean, com.alibaba.fastjson.JSON.toJSONString(orangeBean));
                com.alimm.tanx.core.orange.OrangeManager.this.checkNewConfigRequest(orangeBean);
            }
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.orange.OrangeManager.TAG, "Orange diamond服务器版本为->" + orangeBean.version);
        }
    }

    /* renamed from: com.alimm.tanx.core.orange.OrangeManager$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2> {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.orange.OrangeManager.TAG, "newConfigRequest error code:" + i, ",reqId:" + str + ",error:" + str2);
            com.alimm.tanx.core.orange.OrangeManager.this.callBack2InitSucc();
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void succ(com.alimm.tanx.core.orange.bean.TanxConfigTableV2 tanxConfigTableV2) {
            try {
                if (android.text.TextUtils.isEmpty(tanxConfigTableV2.content)) {
                    com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.orange.OrangeManager.TAG, "tanxConfigTableV2.content为空");
                    com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail("", -1L, com.alimm.tanx.core.ut.UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "tanxConfigTableV2.content为空", "");
                } else {
                    com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = (com.alimm.tanx.core.orange.bean.OrangeBean) com.alibaba.fastjson.JSON.parseObject(tanxConfigTableV2.content, com.alimm.tanx.core.orange.bean.OrangeBean.class);
                    if (orangeBean != null) {
                        com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.orange.OrangeManager.TAG, "Orange 新配置接口服务器版本为->" + orangeBean.version);
                        com.alimm.tanx.core.orange.OrangeManager.this.checkOrangeVersion2Write(orangeBean, com.alibaba.fastjson.JSON.toJSONString(tanxConfigTableV2));
                    } else {
                        com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.orange.OrangeManager.TAG, "orangeBean为空");
                    }
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.JSON_PARSE_ERROR;
                com.alimm.tanx.core.ut.impl.TanxCommonUt.sendNewConfigFail("", -1L, utErrorCode.getIntCode(), "OrangeManager,catch:" + utErrorCode.getMsg(), "");
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.orange.OrangeManager.TAG, e);
            }
            com.alimm.tanx.core.orange.OrangeManager.this.callBack2InitSucc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBack2InitSucc() {
        com.alimm.tanx.core.orange.OrangeInitListener orangeInitListener = this.orangeInitListener;
        if (orangeInitListener != null) {
            orangeInitListener.initFinish(this.orangeBean);
        }
    }

    private void checkAndCreateDefaultOrange() {
        try {
            if (this.orangeBean == null) {
                java.lang.String fromAssets = getFromAssets("orange.json");
                if (android.text.TextUtils.isEmpty(fromAssets)) {
                    return;
                }
                this.orangeBean = (com.alimm.tanx.core.orange.bean.OrangeBean) com.alibaba.fastjson.JSON.parseObject(fromAssets, com.alimm.tanx.core.orange.bean.OrangeBean.class);
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "本地初始orange配置->" + fromAssets);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNewConfigRequest(com.alimm.tanx.core.orange.bean.OrangeBean orangeBean) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap;
        if (orangeBean == null || (hashMap = orangeBean.commonSwitch) == null || hashMap.get("useNewConfig") == null) {
            callBack2InitSucc();
        } else if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(orangeBean.commonSwitch.get("useNewConfig"))) {
            newConfigRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOrangeVersion2Write(com.alimm.tanx.core.orange.bean.OrangeBean orangeBean, java.lang.String str) {
        if (this.orangeBean == null || this.orangeBean.version < orangeBean.version) {
            writeOrange(str);
            this.orangeBean = orangeBean;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int defaultFeedInteractionParam(java.lang.String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1059030137:
                if (str.equals("directionSlideDistance")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 103203022:
                if (str.equals("slideDirection")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1348276389:
                if (str.equals("allSlideDistance")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 55;
            case 1:
                return 1;
            case 2:
                return 120;
            default:
                return -1;
        }
    }

    private boolean diamondConfigParse(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.Boolean> hashMap;
        try {
            com.alimm.tanx.core.orange.bean.OrangeBean orangeBean = (com.alimm.tanx.core.orange.bean.OrangeBean) com.alibaba.fastjson.JSON.parseObject(str, com.alimm.tanx.core.orange.bean.OrangeBean.class);
            if (orangeBean != null && (hashMap = orangeBean.adSwitch) != null && hashMap.size() > 0) {
                this.orangeBean = orangeBean;
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    private void diamondRequest() {
        new com.alimm.tanx.core.orange.tanxc_do().tanxc_do(new com.alimm.tanx.core.orange.OrangeManager.AnonymousClass1());
    }

    public static com.alimm.tanx.core.orange.OrangeManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.orange.OrangeManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.orange.OrangeManager();
                }
            }
        }
        return instance;
    }

    private boolean newConfigParse(java.lang.String str) {
        try {
            this.orangeBean = (com.alimm.tanx.core.orange.bean.OrangeBean) com.alibaba.fastjson.JSON.parseObject(((com.alimm.tanx.core.orange.bean.TanxConfigTableV2) com.alibaba.fastjson.JSON.parseObject(str, com.alimm.tanx.core.orange.bean.TanxConfigTableV2.class)).content, com.alimm.tanx.core.orange.bean.OrangeBean.class);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private void newConfigRequest() {
        new com.alimm.tanx.core.request.ConfigRequest().request(new com.alimm.tanx.core.ad.bean.ConfigRequestBean(), (com.alimm.tanx.core.net.callback.NetWorkCallBack<com.alimm.tanx.core.orange.bean.TanxConfigTableV2>) new com.alimm.tanx.core.orange.OrangeManager.AnonymousClass2());
    }

    private void readLocalOrange() {
        try {
            com.alimm.tanx.core.utils.SharedPreferencesHelper sharedPreferencesHelper = com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance();
            com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance();
            java.lang.String string = sharedPreferencesHelper.getString(com.alimm.tanx.core.utils.SharedPreferencesHelper.KEY_ORANGE);
            if (!android.text.TextUtils.isEmpty(string)) {
                if (!diamondConfigParse(string)) {
                    newConfigParse(string);
                }
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "Orange本地版本为->" + this.orangeBean.version);
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "本地orange配置->" + com.alibaba.fastjson.JSON.toJSONString(this.orangeBean));
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
        checkAndCreateDefaultOrange();
    }

    private void writeOrange(java.lang.String str) {
        try {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "覆盖本地orange配置->" + str);
            com.alimm.tanx.core.utils.SharedPreferencesHelper sharedPreferencesHelper = com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance();
            com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance();
            sharedPreferencesHelper.putString(com.alimm.tanx.core.utils.SharedPreferencesHelper.KEY_ORANGE, str);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
    }

    public boolean getAdSwitch(java.lang.String str) {
        if (this.orangeBean == null || this.orangeBean.adSwitch == null || this.orangeBean.adSwitch.get(str) == null || str == null) {
            return true;
        }
        return this.orangeBean.adSwitch.get(str).booleanValue();
    }

    public boolean getAllAppImageSwitch() {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get("AllApp") == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get("AllApp").booleanValue();
    }

    public boolean getCommonSwitch(java.lang.String str) {
        if (this.orangeBean == null || this.orangeBean.commonSwitch == null || this.orangeBean.commonSwitch.get(str) == null) {
            return false;
        }
        return com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(this.orangeBean.commonSwitch.get(str));
    }

    public com.alimm.tanx.core.orange.bean.ExposureConfigBean getExposureConfigBean(int i) {
        try {
            if (this.orangeBean != null && this.orangeBean.exposureConfig != null && this.orangeBean.exposureConfig.size() > 0 && com.alimm.tanx.core.TanxCoreSdk.getConfig() != null && !android.text.TextUtils.isEmpty(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey())) {
                com.alimm.tanx.core.orange.bean.ExposureConfigBean exposureConfigBean = null;
                for (int i2 = 0; i2 < this.orangeBean.exposureConfig.size(); i2++) {
                    if (this.orangeBean.exposureConfig.get(i2).key.equals(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey()) && this.orangeBean.exposureConfig.get(i2).adType == i) {
                        return this.orangeBean.exposureConfig.get(i2);
                    }
                    if (this.orangeBean.exposureConfig.get(i2).key.equals("default") && this.orangeBean.exposureConfig.get(i2).adType == i && exposureConfigBean == null) {
                        exposureConfigBean = this.orangeBean.exposureConfig.get(i2);
                    }
                }
                return exposureConfigBean;
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public java.lang.String getFeedInteractionGifUrlParam(java.lang.String str) {
        if (this.orangeBean == null || this.orangeBean.feedInteractionParam == null) {
            return "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif";
        }
        java.lang.String str2 = this.orangeBean.feedInteractionParam.get(str);
        return android.text.TextUtils.isEmpty(str2) ? "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif" : str2;
    }

    public int getFeedInteractionParam2Integer(java.lang.String str) {
        try {
            if (this.orangeBean != null && this.orangeBean.feedInteractionParam != null) {
                java.lang.String str2 = this.orangeBean.feedInteractionParam.get(str);
                return android.text.TextUtils.isEmpty(str2) ? defaultFeedInteractionParam(str) : java.lang.Integer.parseInt(str2);
            }
            return defaultFeedInteractionParam(str);
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public java.lang.String getFromAssets(java.lang.String str) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(com.alimm.tanx.core.utils.AssetsUtil.getApplicationAssets(com.alimm.tanx.core.TanxCoreSdk.getApplication()).open(str)));
            java.lang.String str2 = "";
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean getImageSwitch(java.lang.String str) {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get(str) == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get(str).booleanValue();
    }

    public java.util.HashMap<java.lang.String, java.lang.Boolean> getInstallSwitch() {
        return (this.orangeBean == null || this.orangeBean.installStatusSwitch == null) ? new java.util.HashMap<>() : this.orangeBean.installStatusSwitch;
    }

    public com.alimm.tanx.core.orange.bean.OrangeBean getOrangeBean() {
        return this.orangeBean;
    }

    public long getThreshold(java.lang.String str) {
        if (this.orangeBean == null || this.orangeBean.threshold == null || this.orangeBean.threshold.get(str) == null) {
            return -1L;
        }
        return this.orangeBean.threshold.get(str).longValue();
    }

    public int getUtUploadMaxCount() {
        if (this.orangeBean == null || this.orangeBean.ut == null) {
            return -1;
        }
        return this.orangeBean.ut.uploadMaxCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: Exception -> 0x008a, TRY_LEAVE, TryCatch #0 {Exception -> 0x008a, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000a, B:8:0x0014, B:10:0x001a, B:14:0x002b, B:16:0x0035, B:27:0x004f, B:18:0x005a, B:21:0x0070, B:23:0x007a, B:32:0x0084, B:35:0x007d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.alimm.tanx.core.orange.bean.WebConfigBean getWebConfigBean() {
        com.alimm.tanx.core.orange.bean.WebConfigBean webConfigBean;
        try {
            if (this.orangeBean != null && this.orangeBean.webConfigBeanList != null && this.orangeBean.webConfigBeanList.size() > 0 && com.alimm.tanx.core.TanxCoreSdk.getConfig() != null && !android.text.TextUtils.isEmpty(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey())) {
                webConfigBean = null;
                for (int i = 0; i < this.orangeBean.webConfigBeanList.size(); i++) {
                    if (this.orangeBean.webConfigBeanList.get(i).key.equals(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey())) {
                        return this.orangeBean.webConfigBeanList.get(i);
                    }
                    if (this.orangeBean.webConfigBeanList.get(i).key.equals("default") && webConfigBean == null) {
                        webConfigBean = this.orangeBean.webConfigBeanList.get(i);
                    }
                }
                return webConfigBean != null ? new com.alimm.tanx.core.orange.bean.WebConfigBean() : webConfigBean;
            }
            webConfigBean = new com.alimm.tanx.core.orange.bean.WebConfigBean();
            if (webConfigBean != null) {
            }
        } catch (java.lang.Exception unused) {
            return new com.alimm.tanx.core.orange.bean.WebConfigBean();
        }
    }

    public boolean getWebSuffixWhiteSwitch(java.lang.String str) {
        if (this.orangeBean != null && this.orangeBean.webSuffixWhiteList != null) {
            if (this.orangeBean.webSuffixWhiteList.get(str) == null) {
                return false;
            }
            return this.orangeBean.webSuffixWhiteList.get(str).booleanValue();
        }
        java.lang.String[] strArr = {"com", com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION, "htm", com.baidu.mobads.sdk.internal.a.f, "php", "tf"};
        for (int i = 0; i < 6; i++) {
            if (strArr[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void init() {
        init(null);
    }

    public void init(com.alimm.tanx.core.orange.OrangeInitListener orangeInitListener) {
        this.orangeInitListener = orangeInitListener;
        readLocalOrange();
        diamondRequest();
    }
}

package com.autonavi.base.amap.mapcore.maploader;

/* loaded from: classes12.dex */
public class AMapLoader implements com.amap.api.mapcore.util.hd.a {
    private static final int GET_METHOD = 0;
    private static final java.lang.String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private static java.lang.String mDiu;
    private com.amap.api.mapcore.util.hd downloadManager;
    com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam mDataRequestParam;
    private int mEngineID;
    com.autonavi.base.ae.gmap.GLMapEngine mGLMapEngine;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;
    private boolean mRequestCancel = false;

    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public java.lang.String requestBaseUrl;
        public java.lang.String requestUrl;
    }

    public static class AMapGridDownloadRequest extends com.amap.api.mapcore.util.cp {
        private final android.content.Context mContext;
        private byte[] postEntityBytes;
        private java.lang.String sUrl;
        private java.lang.String userAgent;

        public AMapGridDownloadRequest(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.mapcore.util.hi
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.mapcore.util.hi
        public java.lang.String getIPV6URL() {
            return com.amap.api.mapcore.util.dl.a(getURL());
        }

        @Override // com.amap.api.mapcore.util.cp, com.amap.api.mapcore.util.hi
        public java.util.Map<java.lang.String, java.lang.String> getParams() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.hi
        public java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
            com.amap.api.mapcore.util.fh a = com.amap.api.mapcore.util.dl.a();
            java.lang.String b = a != null ? a.b() : null;
            java.lang.String f = com.amap.api.mapcore.util.ev.f(this.mContext);
            try {
                f = java.net.URLEncoder.encode(f, "UTF-8");
            } catch (java.lang.Throwable unused) {
            }
            java.util.Hashtable hashtable = new java.util.Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", java.lang.String.format(java.util.Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
            hashtable.put("x-INFO", com.amap.api.mapcore.util.ey.a(this.mContext));
            hashtable.put("key", f);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.mapcore.util.hi
        public java.lang.String getURL() {
            return this.sUrl;
        }

        @Override // com.amap.api.mapcore.util.hi
        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(int i, com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine, com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam) {
        this.mEngineID = 0;
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i;
        this.mGLMapEngine = gLMapEngine;
    }

    private java.lang.String generateQueryString(android.content.Context context, java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        java.lang.String f = com.amap.api.mapcore.util.ev.f(this.mGLMapEngine.getContext());
        try {
            f = java.net.URLEncoder.encode(f, "UTF-8");
        } catch (java.lang.Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(f);
        java.lang.String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        java.lang.String a = com.amap.api.mapcore.util.ey.a();
        stringBuffer.append("&ts=".concat(java.lang.String.valueOf(a)));
        stringBuffer.append("&scode=" + com.amap.api.mapcore.util.ey.a(context, a, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private java.lang.String getEncodeRequestParams(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private java.lang.String getNetworkFailedReason(java.lang.String str) {
        return !this.mGLMapEngine.isNetworkConnected() ? "无网络" : str;
    }

    private void onCancel() {
        com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam;
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.netCancel(this.mEngineID, aDataRequestParam.handler, -1);
    }

    private java.lang.String sortReEncoderParams(java.lang.String str) {
        java.lang.String[] split = str.split("&");
        java.util.Arrays.sort(split);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str2 : split) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append("&");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (java.lang.String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null) {
            com.amap.api.mapcore.util.di.a(gLMapEngine.getContext(), this.mGLMapEngine.hashCode(), java.lang.System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
        }
    }

    private java.lang.String strReEncoder(java.lang.String str) {
        if (str == null) {
            return str;
        }
        try {
            return java.net.URLDecoder.decode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            com.amap.api.mapcore.util.gd.c(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (java.lang.Exception e2) {
            com.amap.api.mapcore.util.gd.c(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
                this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
            } finally {
            }
        }
    }

    public void doCancelAndNotify() {
        doCancel();
        onCancel();
    }

    public void doRequest() {
        if (com.amap.api.mapcore.util.fe.a(this.mGLMapEngine.getContext(), com.amap.api.mapcore.util.dl.a()).a == com.amap.api.mapcore.util.fe.c.SuccessCode && !this.mRequestCancel) {
            com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam = this.mDataRequestParam;
            java.lang.String str = aDataRequestParam.requestBaseUrl;
            java.lang.String str2 = aDataRequestParam.requestUrl;
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            java.lang.String requestParams = getRequestParams(str2.replaceAll(com.alipay.sdk.m.u.i.b, getEncodeRequestParams(com.alipay.sdk.m.u.i.b).toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                stringBuffer.append("&csid=" + java.util.UUID.randomUUID().toString());
            } else {
                stringBuffer.append("csid=" + java.util.UUID.randomUUID().toString());
            }
            try {
                com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapGridDownloadRequest aMapGridDownloadRequest = new com.autonavi.base.amap.mapcore.maploader.AMapLoader.AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(30000);
                aMapGridDownloadRequest.setSoTimeout(30000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.requestMapDataTimestamp = java.lang.System.currentTimeMillis();
                this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0L : aMapGridDownloadRequest.getEntityBytes().length;
                com.amap.api.mapcore.util.hd hdVar = new com.amap.api.mapcore.util.hd(aMapGridDownloadRequest, 0L, -1L, com.amap.api.maps.MapsInitializer.getProtocol() == 2);
                this.downloadManager = hdVar;
                hdVar.a(this);
            } catch (java.lang.Throwable th) {
                try {
                    onException(th);
                } finally {
                    doCancel();
                }
            }
        }
    }

    public java.lang.String getDeviceId(android.content.Context context) {
        if (context != null) {
            return com.amap.api.mapcore.util.ez.s(context);
        }
        return null;
    }

    public java.lang.String getRequestParams(java.lang.String str, boolean z, int i) {
        if (mDiu == null) {
            mDiu = getDeviceId(this.mGLMapEngine.getContext());
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        if (z) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
            stringBuffer.append("&diu=");
            stringBuffer.append(mDiu);
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
            stringBuffer.append("&diu=");
            stringBuffer.append(mDiu);
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public void onDownload(byte[] bArr, long j) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
        com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam;
        if (bArr == null || (gLMapEngine = this.mGLMapEngine) == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        com.amap.api.mapcore.util.di.a(r0.getContext(), r7.mGLMapEngine.hashCode(), !r7.mGLMapEngine.isNetworkConnected() ? 1 : 0, getNetworkFailedReason(r8.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        com.amap.api.mapcore.util.gd.c(r8, "AMapLoader", "download onException");
        com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.e, "map loader exception " + r8.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0094, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r0 == null) goto L26;
     */
    @Override // com.amap.api.mapcore.util.hd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onException(java.lang.Throwable th) {
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine;
        com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam;
        com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam2;
        int indexOf;
        try {
            java.lang.String str = new java.lang.String(th.getMessage().getBytes("UTF-8"), "UTF-8");
            int parseInt = (android.text.TextUtils.isEmpty(str) || (indexOf = str.indexOf(NETWORK_RESPONSE_CODE_STRING)) == -1) ? -1 : java.lang.Integer.parseInt(str.substring(indexOf + 8));
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine2 = this.mGLMapEngine;
            if (gLMapEngine2 != null && (aDataRequestParam2 = this.mDataRequestParam) != null) {
                gLMapEngine2.netError(this.mEngineID, aDataRequestParam2.handler, -1, parseInt);
            }
            gLMapEngine = this.mGLMapEngine;
        } catch (java.lang.Throwable unused) {
            com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine3 = this.mGLMapEngine;
            if (gLMapEngine3 != null && (aDataRequestParam = this.mDataRequestParam) != null) {
                gLMapEngine3.netError(this.mEngineID, aDataRequestParam.handler, -1, -1);
            }
            gLMapEngine = this.mGLMapEngine;
        }
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public void onFinish() {
        com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam;
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.mapcore.util.hd.a
    public void onStop() {
        com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam;
        com.autonavi.base.ae.gmap.GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.netStop(this.mEngineID, aDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}

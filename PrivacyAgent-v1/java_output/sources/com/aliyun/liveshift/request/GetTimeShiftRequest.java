package com.aliyun.liveshift.request;

/* loaded from: classes.dex */
public class GetTimeShiftRequest extends com.aliyun.utils.b {
    private static final java.lang.String TAG = "GetTimeShiftRequest";
    private com.aliyun.utils.d httpClientHelper;
    private java.lang.ref.WeakReference<android.content.Context> mContextWeak;
    private java.lang.String[] mCustomHeaders;
    private java.lang.String mHttpProxy;
    private com.aliyun.player.source.LiveShift mLiveShiftSource;
    private int mNetworkTimeout;
    private java.lang.String mReferer;
    private java.lang.String mUserAgent;

    public GetTimeShiftRequest(android.content.Context context, com.aliyun.player.source.LiveShift liveShift, com.aliyun.utils.b.d dVar) {
        super(context, dVar);
        this.mReferer = null;
        this.mNetworkTimeout = -1;
        this.mHttpProxy = null;
        this.mUserAgent = null;
        this.mCustomHeaders = null;
        this.httpClientHelper = null;
        this.mContextWeak = new java.lang.ref.WeakReference<>(context);
        this.mLiveShiftSource = liveShift;
    }

    @Override // com.aliyun.utils.b
    public void runInBackground() {
        int value;
        java.lang.String str;
        java.lang.String timeLineUrl = this.mLiveShiftSource.getTimeLineUrl();
        if (this.wantStop) {
            sendFailResult(-1, "", "");
            return;
        }
        try {
            com.aliyun.utils.d dVar = new com.aliyun.utils.d(timeLineUrl);
            this.httpClientHelper = dVar;
            dVar.d(this.mReferer);
            this.httpClientHelper.c(this.mHttpProxy);
            this.httpClientHelper.a(this.mNetworkTimeout);
            this.httpClientHelper.e(this.mUserAgent);
            this.httpClientHelper.a(this.mCustomHeaders);
            java.lang.String b = this.httpClientHelper.b();
            if (android.text.TextUtils.isEmpty(b)) {
                sendFailResult(com.aliyun.player.bean.ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(b);
            if (com.aliyun.utils.e.a(jSONObject, "retCode") != 0) {
                sendFailResult(com.aliyun.player.bean.ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
            } else {
                sendSuccessResult(com.aliyun.liveshift.bean.TimeLineContent.getInfoFromJson(jSONObject.getJSONObject("content")), "");
            }
        } catch (org.json.JSONException unused) {
            value = com.aliyun.player.bean.ErrorCode.ERROR_SERVER_LIVESHIFT_DATA_PARSER_ERROR.getValue();
            str = "response not json";
            sendFailResult(value, str, "");
        } catch (java.lang.Exception unused2) {
            value = com.aliyun.player.bean.ErrorCode.ERROR_SERVER_LIVESHIFT_UNKNOWN.getValue();
            str = com.anythink.expressad.playercommon.PlayerErrorConstant.UNKNOW_ERROR;
            sendFailResult(value, str, "");
        }
    }

    public void setCustomHeaders(java.lang.String[] strArr) {
        this.mCustomHeaders = strArr;
    }

    public void setHttpProxy(java.lang.String str) {
        this.mHttpProxy = str;
    }

    public void setRefer(java.lang.String str) {
        this.mReferer = str;
    }

    public void setTimeout(int i) {
        this.mNetworkTimeout = i;
    }

    public void setUerAgent(java.lang.String str) {
        this.mUserAgent = str;
    }

    @Override // com.aliyun.utils.b
    public void stopInner() {
        com.aliyun.utils.d dVar = this.httpClientHelper;
        if (dVar != null) {
            dVar.e();
        }
    }
}

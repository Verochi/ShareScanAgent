package com.tencent.mm.opensdk.openapi;

/* loaded from: classes19.dex */
class BaseWXApiImplV10 implements com.tencent.mm.opensdk.openapi.IWXAPI {
    protected static final java.lang.String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static java.lang.String wxappPayEntryClassname;
    protected java.lang.String appId;
    protected boolean checkSignature;
    protected android.content.Context context;
    protected boolean detached = false;
    private int wxSdkVersion;

    /* renamed from: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CountDownLatch val$countDownWait;

        public AnonymousClass1(java.util.concurrent.CountDownLatch countDownLatch) {
            this.val$countDownWait = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.tencent.mm.opensdk.openapi.MMSharedPreferences mMSharedPreferences = new com.tencent.mm.opensdk.openapi.MMSharedPreferences(com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.this.context);
                com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.this.wxSdkVersion = mMSharedPreferences.getInt("_build_info_sdk_int_", 0);
            } catch (java.lang.Exception e) {
                com.tencent.mm.opensdk.utils.Log.w(com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.TAG, e.getMessage());
            }
            this.val$countDownWait.countDown();
        }
    }

    /* renamed from: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10$2, reason: invalid class name */
    public class AnonymousClass2 implements android.app.PendingIntent.OnFinished {
        public AnonymousClass2() {
        }

        @Override // android.app.PendingIntent.OnFinished
        public void onSendFinished(android.app.PendingIntent pendingIntent, android.content.Intent intent, int i, java.lang.String str, android.os.Bundle bundle) {
            com.tencent.mm.opensdk.utils.Log.d(com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.TAG, "onSendFinished resultCode: " + i + ", resultData: " + str);
        }
    }

    public BaseWXApiImplV10(android.content.Context context, java.lang.String str, boolean z) {
        this.checkSignature = false;
        com.tencent.mm.opensdk.utils.Log.d(TAG, "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
        com.tencent.mm.opensdk.utils.b.a = context.getApplicationContext();
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        java.lang.String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else {
            if (bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
            str = "checkSumConsistent fail, length is different";
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    private boolean createChatroom(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new java.lang.String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private java.lang.String getTokenFromWX(android.content.Context context) {
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new java.lang.String[]{this.appId, "637928960"}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        java.lang.String string = query.getString(0);
        com.tencent.mm.opensdk.utils.Log.i(TAG, "getTokenFromWX token is " + string);
        query.close();
        return string;
    }

    private boolean handleWxInternalRespType(java.lang.String str, com.tencent.mm.opensdk.openapi.IWXAPIEventHandler iWXAPIEventHandler) {
        android.net.Uri parse;
        java.lang.String queryParameter;
        com.tencent.mm.opensdk.utils.Log.i(TAG, "handleWxInternalRespType, extInfo = " + str);
        try {
            parse = android.net.Uri.parse(str);
            queryParameter = parse.getQueryParameter("wx_internal_resptype");
            com.tencent.mm.opensdk.utils.Log.i(TAG, "handleWxInternalRespType, respType = " + queryParameter);
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "handleWxInternalRespType fail, ex = " + e.getMessage());
        }
        if (com.tencent.mm.opensdk.utils.b.b(queryParameter)) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "handleWxInternalRespType fail, respType is null");
            return false;
        }
        if (queryParameter.equals("subscribemessage")) {
            com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Resp resp = new com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Resp();
            java.lang.String queryParameter2 = parse.getQueryParameter("ret");
            if (queryParameter2 != null && queryParameter2.length() > 0) {
                resp.errCode = com.tencent.mm.opensdk.utils.b.a(queryParameter2, 0);
            }
            resp.openId = parse.getQueryParameter("openid");
            resp.templateID = parse.getQueryParameter(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId);
            resp.scene = com.tencent.mm.opensdk.utils.b.a(parse.getQueryParameter(com.umeng.ccg.a.j), 0);
            resp.action = parse.getQueryParameter("action");
            resp.reserved = parse.getQueryParameter("reserved");
            iWXAPIEventHandler.onResp(resp);
            return true;
        }
        if (queryParameter.contains("invoice_auth_insert")) {
            com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp resp2 = new com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp();
            java.lang.String queryParameter3 = parse.getQueryParameter("ret");
            if (queryParameter3 != null && queryParameter3.length() > 0) {
                resp2.errCode = com.tencent.mm.opensdk.utils.b.a(queryParameter3, 0);
            }
            resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp2);
            return true;
        }
        if (queryParameter.contains("payinsurance")) {
            com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp resp3 = new com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp();
            java.lang.String queryParameter4 = parse.getQueryParameter("ret");
            if (queryParameter4 != null && queryParameter4.length() > 0) {
                resp3.errCode = com.tencent.mm.opensdk.utils.b.a(queryParameter4, 0);
            }
            resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp3);
            return true;
        }
        if (queryParameter.contains("nontaxpay")) {
            com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp resp4 = new com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp();
            java.lang.String queryParameter5 = parse.getQueryParameter("ret");
            if (queryParameter5 != null && queryParameter5.length() > 0) {
                resp4.errCode = com.tencent.mm.opensdk.utils.b.a(queryParameter5, 0);
            }
            resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp4);
            return true;
        }
        if (!"subscribeminiprogrammsg".equals(queryParameter) && !"5".equals(queryParameter)) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "this open sdk version not support the request type");
            return false;
        }
        com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Resp resp5 = new com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Resp();
        java.lang.String queryParameter6 = parse.getQueryParameter("ret");
        if (queryParameter6 != null && queryParameter6.length() > 0) {
            resp5.errCode = com.tencent.mm.opensdk.utils.b.a(queryParameter6, 0);
        }
        resp5.openId = parse.getQueryParameter("openid");
        resp5.unionId = parse.getQueryParameter(com.tencent.open.SocialOperation.GAME_UNION_ID);
        resp5.nickname = parse.getQueryParameter("nickname");
        resp5.errStr = parse.getQueryParameter("errmsg");
        iWXAPIEventHandler.onResp(resp5);
        return true;
    }

    private boolean joinChatroom(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new java.lang.String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private void launchWXIfNeed() {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            launchWXUsingPendingIntent();
        }
    }

    private void launchWXUsingPendingIntent() {
        if (this.detached) {
            throw new java.lang.IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "openWXApp failed, not installed or signature check failed");
            return;
        }
        try {
            com.tencent.mm.opensdk.utils.Log.i(TAG, "launchWXUsingPendingIntent");
            android.content.Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            android.content.Context context = this.context;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetActivity(context, 1, launchIntentForPackage, 134217728);
            android.app.PendingIntent activity = android.app.PendingIntent.getActivity(context, 1, launchIntentForPackage, 134217728);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetActivity(activity, context, 1, launchIntentForPackage, 134217728);
            activity.send(this.context, 2, null, new com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.AnonymousClass2(), null);
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "launchWXUsingPendingIntent pendingIntent send failed: " + e.getMessage());
            openWXApp();
        }
    }

    private boolean sendAddCardToWX(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new java.lang.String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new java.lang.String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new java.lang.String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new java.lang.String[]{this.appId, java.lang.String.valueOf(2), java.net.URLEncoder.encode(java.lang.String.format("url=%s", java.net.URLEncoder.encode(((com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToOfflinePayReq(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new java.lang.String[]{this.appId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req req = (com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req) baseReq;
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new java.lang.String[]{this.appId, req.userName, req.path, req.miniprogramType + "", req.extData}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogramWithToken(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new java.lang.String[]{this.appId, ((com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Req) baseReq).token}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new java.lang.String[]{this.appId, java.lang.String.valueOf(3), java.net.URLEncoder.encode(java.lang.String.format("url=%s", java.net.URLEncoder.encode(((com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new java.lang.String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessView(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Req req = (com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Req) baseReq;
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new java.lang.String[]{this.appId, req.businessType, req.query, req.extInfo, req.transaction, req.openId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessWebview(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Req req = (com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Req) baseReq;
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri parse = android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = req.queryInfo;
        android.database.Cursor query = contentResolver.query(parse, null, null, new java.lang.String[]{this.appId, req.businessType + "", (hashMap == null || hashMap.size() <= 0) ? "" : new org.json.JSONObject(req.queryInfo).toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new java.lang.String[0], null);
        if (query == null) {
            return true;
        }
        query.close();
        return true;
    }

    private boolean sendOpenWebview(android.content.Context context, android.os.Bundle bundle) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new java.lang.String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new java.lang.String[]{this.appId, java.lang.String.valueOf(4), java.net.URLEncoder.encode(java.lang.String.format("url=%s", java.net.URLEncoder.encode(((com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(android.content.Context context, android.os.Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new com.tencent.mm.opensdk.openapi.MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            com.tencent.mm.opensdk.utils.Log.d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (java.lang.Exception e) {
                    com.tencent.mm.opensdk.utils.Log.e(TAG, "get from metaData failed : " + e.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                com.tencent.mm.opensdk.utils.Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        com.tencent.mm.opensdk.channel.MMessageActV2.Args args = new com.tencent.mm.opensdk.channel.MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return com.tencent.mm.opensdk.channel.MMessageActV2.send(context, args);
    }

    private boolean sendPreloadWXMiniprogram(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req req = (com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req) baseReq;
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram"), null, null, new java.lang.String[]{this.appId, req.userName, req.path, req.miniprogramType + "", req.extData}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMessage(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Req req = (com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Req) baseReq;
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new java.lang.String[]{this.appId, java.lang.String.valueOf(1), java.lang.String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        android.database.Cursor query = context.getContentResolver().query(android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new java.lang.String[]{this.appId, java.lang.String.valueOf(5), ((com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Req) baseReq).miniProgramAppId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendToWxaRedirectingPage(android.content.Context context, com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        launchWXIfNeed();
        com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req req = (com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req) baseReq;
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri parse = android.net.Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWxaOpenApiRedirectingPage");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(0, this.appId);
        arrayList.addAll(java.util.Arrays.asList(req.toArray()));
        android.database.Cursor query = contentResolver.query(parse, null, null, (java.lang.String[]) arrayList.toArray(new java.lang.String[0]), null);
        if (query == null) {
            return true;
        }
        query.close();
        return true;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void detach() {
        com.tencent.mm.opensdk.utils.Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public int getWXAppSupportAPI() {
        if (this.detached) {
            throw new java.lang.IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        }
        this.wxSdkVersion = 0;
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.tencent.mm.opensdk.utils.b.e.submit(new com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.AnonymousClass1(countDownLatch));
        try {
            countDownLatch.await(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException e) {
            com.tencent.mm.opensdk.utils.Log.w(TAG, e.getMessage());
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "wxSdkVersion = " + this.wxSdkVersion);
        if (this.wxSdkVersion == 0) {
            try {
                this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                com.tencent.mm.opensdk.utils.Log.d(TAG, "OPEN_SDK_VERSION = " + this.wxSdkVersion);
            } catch (java.lang.Exception e2) {
                com.tencent.mm.opensdk.utils.Log.e(TAG, "get from metaData failed : " + e2.getMessage());
            }
        }
        return this.wxSdkVersion;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean handleIntent(android.content.Intent intent, com.tencent.mm.opensdk.openapi.IWXAPIEventHandler iWXAPIEventHandler) {
        try {
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "handleIntent fail, ex = " + e.getMessage());
        }
        if (!com.tencent.mm.opensdk.openapi.WXApiImplComm.isIntentFromWx(intent, com.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
            com.tencent.mm.opensdk.utils.Log.i(TAG, "handleIntent fail, intent not from weixin msg");
            return false;
        }
        if (this.detached) {
            throw new java.lang.IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
        java.lang.String stringExtra = intent.getStringExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CONTENT);
        int intExtra = intent.getIntExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.SDK_VERSION, 0);
        java.lang.String stringExtra2 = intent.getStringExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.APP_PACKAGE);
        if (stringExtra2 != null && stringExtra2.length() != 0) {
            if (!checkSumConsistent(intent.getByteArrayExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.CHECK_SUM), com.tencent.mm.opensdk.channel.a.a.a(stringExtra, intExtra, stringExtra2))) {
                com.tencent.mm.opensdk.utils.Log.e(TAG, "checksum fail");
                return false;
            }
            int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
            com.tencent.mm.opensdk.utils.Log.i(TAG, "handleIntent, cmd = " + intExtra2);
            switch (intExtra2) {
                case 1:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelmsg.SendAuth.Resp(intent.getExtras()));
                    return true;
                case 2:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp(intent.getExtras()));
                    return true;
                case 3:
                    iWXAPIEventHandler.onReq(new com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req(intent.getExtras()));
                    return true;
                case 4:
                    com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req req = new com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req(intent.getExtras());
                    java.lang.String str = req.message.messageExt;
                    if (str != null && str.contains("wx_internal_resptype")) {
                        boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                        com.tencent.mm.opensdk.utils.Log.i(TAG, "handleIntent, extInfo contains wx_internal_resptype, ret = " + handleWxInternalRespType);
                        return handleWxInternalRespType;
                    }
                    if (str != null && str.contains("openbusinesswebview")) {
                        try {
                            android.net.Uri parse = android.net.Uri.parse(str);
                            if (parse != null && "openbusinesswebview".equals(parse.getHost())) {
                                com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp resp = new com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp();
                                java.lang.String queryParameter = parse.getQueryParameter("ret");
                                if (queryParameter != null && queryParameter.length() > 0) {
                                    resp.errCode = com.tencent.mm.opensdk.utils.b.a(queryParameter, 0);
                                }
                                resp.resultInfo = parse.getQueryParameter("resultInfo");
                                resp.errStr = parse.getQueryParameter("errmsg");
                                java.lang.String queryParameter2 = parse.getQueryParameter("type");
                                if (queryParameter2 != null && queryParameter2.length() > 0) {
                                    resp.businessType = com.tencent.mm.opensdk.utils.b.a(queryParameter2, 0);
                                }
                                iWXAPIEventHandler.onResp(resp);
                                return true;
                            }
                            com.tencent.mm.opensdk.utils.Log.d(TAG, "not openbusinesswebview %" + str);
                        } catch (java.lang.Exception e2) {
                            com.tencent.mm.opensdk.utils.Log.e(TAG, "parse fail, ex = " + e2.getMessage());
                        }
                    }
                    iWXAPIEventHandler.onReq(req);
                    return true;
                case 5:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelpay.PayResp(intent.getExtras()));
                    return true;
                case 6:
                    iWXAPIEventHandler.onReq(new com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req(intent.getExtras()));
                    return true;
                case 7:
                case 8:
                case 10:
                case 11:
                case 13:
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                default:
                    com.tencent.mm.opensdk.utils.Log.e(TAG, "unknown cmd = " + intExtra2);
                    return false;
                case 9:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp(intent.getExtras()));
                    return true;
                case 12:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp(intent.getExtras()));
                    return true;
                case 14:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp(intent.getExtras()));
                    return true;
                case 15:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp(intent.getExtras()));
                    return true;
                case 16:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                    return true;
                case 17:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.HandleScanResult.Resp(intent.getExtras()));
                    return true;
                case 19:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp(intent.getExtras()));
                    return true;
                case 24:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp(intent.getExtras()));
                    return true;
                case 25:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp(intent.getExtras()));
                    return true;
                case 26:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp(intent.getExtras()));
                    return true;
                case 27:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp(intent.getExtras()));
                    return true;
                case 28:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Resp(intent.getExtras()));
                    return true;
                case 29:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp(intent.getExtras()));
                    return true;
                case 30:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp(intent.getExtras()));
                    return true;
                case 31:
                    iWXAPIEventHandler.onResp(new com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp(intent.getExtras()));
                    return true;
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, "invalid argument");
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean isWXAppInstalled() {
        if (this.detached) {
            throw new java.lang.IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            android.content.pm.PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
            if (packageInfo == null) {
                return false;
            }
            return com.tencent.mm.opensdk.openapi.WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean openWXApp() {
        java.lang.String str;
        if (this.detached) {
            throw new java.lang.IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (isWXAppInstalled()) {
            try {
                android.content.Context context = this.context;
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                return true;
            } catch (java.lang.Exception e) {
                str = "startActivity fail, exception = " + e.getMessage();
            }
        } else {
            str = "open wx app failed, not installed or signature check failed";
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(java.lang.String str) {
        return registerApp(str, 0L);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(java.lang.String str, long j) {
        if (this.detached) {
            throw new java.lang.IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.opensdk.openapi.WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "register app failed for wechat app signature check failed");
            return false;
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "register app " + this.context.getPackageName());
        com.tencent.mm.opensdk.channel.a.a.C0497a c0497a = new com.tencent.mm.opensdk.channel.a.a.C0497a();
        c0497a.a = "com.tencent.mm";
        c0497a.b = com.tencent.mm.opensdk.constants.ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
        c0497a.c = "weixin://registerapp?appid=" + this.appId;
        c0497a.d = j;
        return com.tencent.mm.opensdk.channel.a.a.a(this.context, c0497a);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendReq(com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        com.tencent.mm.opensdk.modelmsg.WXWebpageObject wXWebpageObject;
        int i;
        java.lang.String str2;
        if (this.detached) {
            throw new java.lang.IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.opensdk.openapi.WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            str2 = "sendReq failed for wechat app signature check failed";
        } else {
            if (baseReq.checkArgs()) {
                com.tencent.mm.opensdk.utils.Log.i(TAG, "sendReq, req type = " + baseReq.getType());
                android.os.Bundle bundle = new android.os.Bundle();
                baseReq.toBundle(bundle);
                if (baseReq.getType() == 5 || baseReq.getType() == 27) {
                    return sendPayReq(this.context, bundle);
                }
                if (baseReq.getType() == 9) {
                    return sendAddCardToWX(this.context, bundle);
                }
                if (baseReq.getType() == 16) {
                    return sendChooseCardFromWX(this.context, bundle);
                }
                if (baseReq.getType() == 11) {
                    return sendOpenRankListReq(this.context, bundle);
                }
                if (baseReq.getType() == 12) {
                    return sendOpenWebview(this.context, bundle);
                }
                if (baseReq.getType() == 25) {
                    return sendOpenBusinessWebview(this.context, baseReq);
                }
                if (baseReq.getType() == 13) {
                    return sendOpenBusiLuckyMoney(this.context, bundle);
                }
                if (baseReq.getType() == 14) {
                    return createChatroom(this.context, bundle);
                }
                if (baseReq.getType() == 15) {
                    return joinChatroom(this.context, bundle);
                }
                if (baseReq.getType() == 17) {
                    return sendHandleScanResult(this.context, bundle);
                }
                if (baseReq.getType() == 18) {
                    return sendSubscribeMessage(this.context, baseReq);
                }
                if (baseReq.getType() == 28) {
                    return sendPreloadWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 29) {
                    return sendLaunchWXMiniprogramWithToken(this.context, baseReq);
                }
                if (baseReq.getType() == 23) {
                    return sendSubscribeMiniProgramMsg(this.context, baseReq);
                }
                if (baseReq.getType() == 19) {
                    return sendLaunchWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 30) {
                    return sendToWxaRedirectingPage(this.context, baseReq);
                }
                if (baseReq.getType() == 26) {
                    return sendOpenBusinessView(this.context, baseReq);
                }
                if (baseReq.getType() == 20) {
                    return sendInvoiceAuthInsert(this.context, baseReq);
                }
                if (baseReq.getType() == 21) {
                    return sendNonTaxPay(this.context, baseReq);
                }
                if (baseReq.getType() == 22) {
                    return sendPayInSurance(this.context, baseReq);
                }
                if (baseReq.getType() == 24) {
                    return sendJumpToOfflinePayReq(this.context, bundle);
                }
                if (baseReq.getType() == 2) {
                    com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req req = (com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req) baseReq;
                    int type = req.message.getType();
                    if (com.tencent.mm.opensdk.utils.b.a(type)) {
                        if (getWXAppSupportAPI() < 620756993) {
                            wXWebpageObject = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject();
                        } else if (type != 46 || getWXAppSupportAPI() >= 620953856) {
                            com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject wXMiniProgramObject = (com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject) req.message.mediaObject;
                            wXMiniProgramObject.userName += "@app";
                            java.lang.String str3 = wXMiniProgramObject.path;
                            if (!com.tencent.mm.opensdk.utils.b.b(str3)) {
                                java.lang.String[] split = str3.split("\\?");
                                if (split.length > 1) {
                                    sb = new java.lang.StringBuilder();
                                    sb.append(split[0]);
                                    sb.append(".html?");
                                    str = split[1];
                                } else {
                                    sb = new java.lang.StringBuilder();
                                    sb.append(split[0]);
                                    str = ".html";
                                }
                                sb.append(str);
                                wXMiniProgramObject.path = sb.toString();
                            }
                            i = req.scene;
                            if (i != 3 && i != 1) {
                                req.scene = 0;
                            }
                            baseReq.toBundle(bundle);
                        } else {
                            wXWebpageObject = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject();
                        }
                        wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                        req.message.mediaObject = wXWebpageObject;
                        i = req.scene;
                        if (i != 3) {
                            req.scene = 0;
                        }
                        baseReq.toBundle(bundle);
                    }
                }
                com.tencent.mm.opensdk.channel.MMessageActV2.Args args = new com.tencent.mm.opensdk.channel.MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendreq?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                if (baseReq.getType() == 2) {
                    try {
                        args.token = getTokenFromWX(this.context);
                    } catch (java.lang.Exception e) {
                        com.tencent.mm.opensdk.utils.Log.e(TAG, "getTokenFromWX fail, exception = " + e.getMessage());
                    }
                }
                return com.tencent.mm.opensdk.channel.MMessageActV2.send(this.context, args);
            }
            str2 = "sendReq checkArgs fail";
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendResp(com.tencent.mm.opensdk.modelbase.BaseResp baseResp) {
        java.lang.String str;
        if (this.detached) {
            throw new java.lang.IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.opensdk.openapi.WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            str = "sendResp failed for wechat app signature check failed";
        } else {
            if (baseResp.checkArgs()) {
                android.os.Bundle bundle = new android.os.Bundle();
                baseResp.toBundle(bundle);
                com.tencent.mm.opensdk.channel.MMessageActV2.Args args = new com.tencent.mm.opensdk.channel.MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendresp?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return com.tencent.mm.opensdk.channel.MMessageActV2.send(this.context, args);
            }
            str = "sendResp checkArgs fail";
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void setLogImpl(com.tencent.mm.opensdk.utils.ILog iLog) {
        com.tencent.mm.opensdk.utils.Log.setLogImpl(iLog);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void unregisterApp() {
        if (this.detached) {
            throw new java.lang.IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.opensdk.openapi.WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "unregister app failed for wechat app signature check failed");
            return;
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "unregisterApp, appId = " + this.appId);
        java.lang.String str = this.appId;
        if (str == null || str.length() == 0) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "unregisterApp fail, appId is empty");
            return;
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "unregister app " + this.context.getPackageName());
        com.tencent.mm.opensdk.channel.a.a.C0497a c0497a = new com.tencent.mm.opensdk.channel.a.a.C0497a();
        c0497a.a = "com.tencent.mm";
        c0497a.b = com.tencent.mm.opensdk.constants.ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
        c0497a.c = "weixin://unregisterapp?appid=" + this.appId;
        com.tencent.mm.opensdk.channel.a.a.a(this.context, c0497a);
    }
}

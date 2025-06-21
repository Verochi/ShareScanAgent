package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
public class DynamicViewJsonBuilder {
    private static final java.lang.String TAG = "DynamicViewJsonBuilder";
    static boolean dialogIsShowing;
    static final java.util.HashMap<java.lang.String, com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder> dynamicViewJsonBuilderHashMap = new java.util.HashMap<>();
    private java.lang.String mAnonymousId;
    private com.sensorsdata.sf.core.AppStateManager mAppStateManager;
    private java.lang.String mContent;
    private android.content.Context mContext;
    private java.lang.String mImageUrl;
    private org.json.JSONObject mJsonPlan;
    private java.lang.String mLoginId;
    private java.lang.String mPlanId;
    private com.sensorsdata.sf.core.entity.PopupPlan mPopupPlan;
    private java.lang.String mTitle;
    private boolean mViewCreatedSucceed;
    private final android.os.Handler mainHandler;

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$popupWindowContent;

        public AnonymousClass1(java.lang.String str) {
            this.val$popupWindowContent = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(this.val$popupWindowContent);
                com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getSensorsFocusCampaignListener();
                java.lang.String optString = jSONObject.optString("content");
                java.lang.String optString2 = jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.popup_type, "PRESET");
                com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign = new com.sensorsdata.sf.core.entity.SFCampaign("", "", optString, com.sensorsdata.sf.core.entity.SFCampaign.Type.valueOf(optString2));
                com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.this.campaignHandler(jSONObject.optString("content"), com.sensorsdata.sf.core.campaign.CampaignManager.setDebugCampaignStatus(optString, optString2, sensorsFocusCampaignListener), "PRESET".equals(optString2), true);
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$errorCode;
        final /* synthetic */ java.lang.String val$errorMessage;
        final /* synthetic */ boolean val$isPreset;

        public AnonymousClass2(boolean z, int i, java.lang.String str) {
            this.val$isPreset = z;
            this.val$errorCode = i;
            this.val$errorMessage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.sf.core.entity.SFCampaign sFCampaign;
            com.sensorsdata.sf.ui.listener.PopupListener windowListener;
            if (this.val$isPreset && (windowListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getWindowListener()) != null) {
                try {
                    windowListener.onPopupLoadFailed(java.lang.String.valueOf(com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.this.mPlanId), this.val$errorCode, this.val$errorMessage);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                }
            }
            com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getSensorsFocusCampaignListener();
            if (sensorsFocusCampaignListener == null || (sFCampaign = com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign) == null) {
                return;
            }
            try {
                sensorsFocusCampaignListener.onCampaignFailed(sFCampaign.m96clone(), this.val$errorCode, this.val$errorMessage);
            } catch (java.lang.Exception e2) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ boolean val$isPreset;

        public AnonymousClass3(boolean z) {
            this.val$isPreset = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.sf.ui.listener.PopupListener windowListener;
            com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getSensorsFocusCampaignListener();
            if (sensorsFocusCampaignListener != null) {
                try {
                    sensorsFocusCampaignListener.onCampaignStart(com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign.m96clone());
                } catch (java.lang.Exception e) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                }
            }
            if (!this.val$isPreset || (windowListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getWindowListener()) == null) {
                return;
            }
            try {
                windowListener.onPopupLoadSuccess(java.lang.String.valueOf(com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.this.mPlanId));
            } catch (java.lang.Exception e2) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus;

        static {
            int[] iArr = new int[com.sensorsdata.sf.core.enums.CampaignStatus.values().length];
            $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus = iArr;
            try {
                iArr[com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_SHOW.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_NOT_START_LISTENER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_CUSTOMIZED_NULL_LISTENER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW_JSON_FAILED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_NOT_START_TRIGGER.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[com.sensorsdata.sf.core.enums.CampaignStatus.CAMPAIGN_TRIGGER_CUSTOMIZED_START.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public DynamicViewJsonBuilder(android.content.Context context) {
        this.mPlanId = "";
        this.mViewCreatedSucceed = true;
        this.mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mContext = context;
    }

    public DynamicViewJsonBuilder(android.content.Context context, com.sensorsdata.sf.core.AppStateManager appStateManager, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.mPlanId = "";
        this.mViewCreatedSucceed = true;
        this.mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        try {
            this.mAnonymousId = str2;
            this.mLoginId = str3;
            this.mContext = context;
            this.mAppStateManager = appStateManager;
            this.mPlanId = str;
            this.mPopupPlan = getPopupPlan();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private com.sensorsdata.sf.ui.view.AbstractViewDynamic buildSubView(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, int i, boolean z) {
        str.hashCode();
        switch (str) {
            case "button":
                return new com.sensorsdata.sf.ui.view.ButtonDynamic(context, jSONObject);
            case "link":
                return new com.sensorsdata.sf.ui.view.LinkViewDynamic(context, jSONObject);
            case "image":
                if (jSONObject != null) {
                    try {
                        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("properties");
                        if (optJSONObject != null) {
                            java.lang.String optString = optJSONObject.optString("image");
                            if (!android.text.TextUtils.isEmpty(optString)) {
                                if (!"image/gif".equals(com.sensorsdata.sf.ui.utils.ImageLoader.getInstance().getImageType(optString)) && !optString.endsWith(".gif")) {
                                    java.lang.String lastPathSegment = android.net.Uri.parse(optString).getLastPathSegment();
                                    if (lastPathSegment != null && lastPathSegment.endsWith(".gif")) {
                                        return handleGifView(context, str, optString, jSONObject, i);
                                    }
                                }
                                return handleGifView(context, str, optString, jSONObject, i);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                    }
                }
                return handleImageView(context, str, jSONObject, i, z);
            case "label":
                return handleTextView(context, jSONObject);
            case "image_button":
                return handleImageButtonView(context, str, jSONObject, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void campaignHandler(java.lang.String str, com.sensorsdata.sf.core.enums.CampaignStatus campaignStatus, boolean z, boolean z2) {
        if (campaignStatus == null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "CampaignStatus is null");
            return;
        }
        try {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "CampaignStatus is " + campaignStatus.toString());
            this.mJsonPlan = com.sensorsdata.sf.ui.track.SFTrackHelper.buildPlanProperty(this.mPopupPlan);
            switch (com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.AnonymousClass4.$SwitchMap$com$sensorsdata$sf$core$enums$CampaignStatus[campaignStatus.ordinal()]) {
                case 1:
                    showDialog(str, z2);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    handleCampaignFailed(z, campaignStatus);
                    break;
                case 7:
                    handleCampaignSuccess(z);
                    break;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private com.sensorsdata.sf.ui.view.FrameLayoutDynamic createSubView(android.content.Context context, org.json.JSONObject jSONObject, boolean z) {
        try {
            com.sensorsdata.sf.ui.view.FrameLayoutDynamic frameLayoutDynamic = new com.sensorsdata.sf.ui.view.FrameLayoutDynamic(context, z, jSONObject);
            int i = frameLayoutDynamic.cornerRadius;
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.sensorsdata.sf.ui.view.UIProperty.subviews);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    org.json.JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    java.lang.String optString = jSONObject2.optString("type");
                    com.sensorsdata.sf.ui.view.AbstractViewDynamic createSubView = isViewGroup(optString) ? createSubView(context, jSONObject2, false) : buildSubView(context, optString, jSONObject2, i, z);
                    if (createSubView == null) {
                        return null;
                    }
                    frameLayoutDynamic.addChildView(createSubView);
                }
            }
            return frameLayoutDynamic;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.ui.view.MaskViewDynamic createViewFromJson(android.content.Context context, org.json.JSONObject jSONObject) {
        com.sensorsdata.sf.ui.view.FrameLayoutDynamic createSubView;
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("properties");
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("template");
            if (optJSONObject2 != null && (createSubView = createSubView(context, optJSONObject2, true)) != null) {
                return handleMaskLayout(context, createSubView, optJSONObject);
            }
            this.mViewCreatedSucceed = false;
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.core.entity.PopupPlan getPopupPlan() {
        try {
            long parseLong = !android.text.TextUtils.isEmpty(this.mPlanId) ? java.lang.Long.parseLong(this.mPlanId) : 0L;
            com.sensorsdata.sf.core.entity.PopupPlan popupPlan = com.sensorsdata.sf.core.SFContextManger.getInstance().getPopupPlan(parseLong);
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "From showDialog popupPlan id = " + parseLong);
            return popupPlan;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.ui.view.GifViewDynamic handleGifView(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, int i) {
        try {
            com.sensorsdata.sf.ui.view.GifViewDynamic gifViewDynamic = new com.sensorsdata.sf.ui.view.GifViewDynamic(context, str, str2, jSONObject, com.sensorsdata.sf.ui.view.GifViewDynamic.LINEAR_LAYOUT, i);
            if ("image".equals(gifViewDynamic.getType())) {
                this.mImageUrl = str2;
            }
            return gifViewDynamic;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.ui.view.ImageButtonViewDynamic handleImageButtonView(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, int i, boolean z) {
        try {
            return new com.sensorsdata.sf.ui.view.ImageButtonViewDynamic(context, str, i, z, jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.ui.view.ImageViewDynamic handleImageView(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, int i, boolean z) {
        try {
            com.sensorsdata.sf.ui.view.ImageViewDynamic imageViewDynamic = new com.sensorsdata.sf.ui.view.ImageViewDynamic(context, str, i, z, jSONObject);
            if ("image".equals(imageViewDynamic.getType())) {
                this.mImageUrl = imageViewDynamic.getImageUrl();
            }
            return imageViewDynamic;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.ui.view.MaskViewDynamic handleMaskLayout(android.content.Context context, com.sensorsdata.sf.ui.view.FrameLayoutDynamic frameLayoutDynamic, org.json.JSONObject jSONObject) {
        try {
            return new com.sensorsdata.sf.ui.view.MaskViewDynamic(context, frameLayoutDynamic, jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private com.sensorsdata.sf.ui.view.TextViewDynamic handleTextView(android.content.Context context, org.json.JSONObject jSONObject) {
        try {
            com.sensorsdata.sf.ui.view.TextViewDynamic textViewDynamic = new com.sensorsdata.sf.ui.view.TextViewDynamic(context, jSONObject);
            if ("title".equals(textViewDynamic.getNameType())) {
                this.mTitle = textViewDynamic.getText();
            } else if ("content".equals(textViewDynamic.getNameType())) {
                this.mContent = textViewDynamic.getText();
            }
            return textViewDynamic;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    private boolean isViewGroup(java.lang.String str) {
        return "row".equals(str) || com.sensorsdata.sf.ui.view.UIProperty.type_column.equals(str);
    }

    private void showDialog(java.lang.String str, boolean z) {
        try {
            if (dialogIsShowing && !z) {
                handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.ACTIVITY_IN_BACKGROUND_FINISH);
                return;
            }
            if (str == null) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "jsonUI is null");
                handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW_JSON_FAILED);
                return;
            }
            com.sensorsdata.sf.ui.view.MaskViewDynamic createViewFromJson = createViewFromJson(this.mContext, new org.json.JSONObject(str));
            if (this.mViewCreatedSucceed && createViewFromJson != null) {
                java.lang.String uuid = java.util.UUID.randomUUID().toString();
                new com.sensorsdata.sf.ui.view.DynamicViewHelper(this.mPlanId, this.mJsonPlan).addViewDynamic(uuid, createViewFromJson);
                startDialogActivity(uuid);
                return;
            }
            handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW_JSON_FAILED);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.DIALOG_NOT_SHOW_JSON_FAILED);
        }
    }

    private void startDialogActivity(java.lang.String str) {
        try {
            com.sensorsdata.sf.core.AppStateManager appStateManager = this.mAppStateManager;
            if (appStateManager != null && (!appStateManager.isAppInForeground() || this.mAppStateManager.isAppFinishing())) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "App is background or isFinishing = " + this.mAppStateManager.isAppFinishing() + " don't show window.");
                handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.ACTIVITY_IN_BACKGROUND_FINISH);
                return;
            }
            dynamicViewJsonBuilderHashMap.put(str, this);
            android.content.Intent intent = new android.content.Intent(this.mContext, (java.lang.Class<?>) com.sensorsdata.sf.ui.view.DialogActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(com.sensorsdata.sf.ui.view.UIProperty.TAG, str);
            intent.putExtra(com.sensorsdata.sf.ui.view.UIProperty.plan_id, this.mPlanId);
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "startDialogActivity");
            this.mContext.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            handleCampaignFailed(true, com.sensorsdata.sf.core.enums.CampaignStatus.ACTIVITY_IN_BACKGROUND_FINISH);
        }
    }

    public void campaignStart(java.lang.String str, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        try {
            com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getSensorsFocusCampaignListener();
            java.lang.String optString = jSONObject.optString("content");
            java.lang.String optString2 = jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.popup_type, "PRESET");
            com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign = new com.sensorsdata.sf.core.entity.SFCampaign(this.mPlanId, str, optString, com.sensorsdata.sf.core.entity.SFCampaign.Type.valueOf(optString2));
            com.sensorsdata.sf.core.entity.PopupPlan popupPlan = this.mPopupPlan;
            campaignHandler(optString, com.sensorsdata.sf.core.campaign.CampaignManager.setCampaignStatus(optString2, z, z2, sensorsFocusCampaignListener, optString, popupPlan != null ? android.text.TextUtils.isEmpty(popupPlan.strategyId) : false), "PRESET".equals(optString2), false);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void campaignStartDebug(java.lang.String str) {
        try {
            new java.lang.Thread(new com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.AnonymousClass1(str)).start();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void handleCampaignFailed(boolean z, com.sensorsdata.sf.core.enums.CampaignStatus campaignStatus) {
        com.sensorsdata.sf.ui.listener.PopupListener internalWindowListener;
        if (campaignStatus == null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "CampaignType is null");
            return;
        }
        try {
            java.lang.String errorMessage = campaignStatus.getErrorMessage();
            int errorCode = campaignStatus.getErrorCode();
            com.sensorsdata.sf.ui.track.SFTrackHelper.trackPlanPopupDisplayFailed(this.mTitle, this.mContent, this.mImageUrl, errorMessage, this.mJsonPlan, this.mAnonymousId, this.mLoginId);
            this.mainHandler.post(new com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.AnonymousClass2(z, errorCode, errorMessage));
            if (!z || (internalWindowListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getInternalWindowListener()) == null) {
                return;
            }
            internalWindowListener.onPopupLoadFailed(java.lang.String.valueOf(this.mPlanId), errorCode, errorMessage);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void handleCampaignSuccess(boolean z) {
        com.sensorsdata.sf.ui.listener.PopupListener internalWindowListener;
        try {
            com.sensorsdata.sf.ui.track.SFTrackHelper.trackPlanPopupDisplaySuccess(this.mTitle, this.mContent, this.mImageUrl, this.mJsonPlan, this.mAnonymousId, this.mLoginId);
            this.mainHandler.post(new com.sensorsdata.sf.ui.view.DynamicViewJsonBuilder.AnonymousClass3(z));
            if (!z || (internalWindowListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getInternalWindowListener()) == null) {
                return;
            }
            internalWindowListener.onPopupLoadSuccess(java.lang.String.valueOf(this.mPlanId));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}

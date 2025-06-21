package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
class DynamicViewHelper {
    private static java.util.Map<java.lang.String, com.sensorsdata.sf.ui.view.AbstractViewDynamic> viewDynamicHashMap = new java.util.HashMap();
    private java.lang.String mContent;
    private java.lang.String mImageUrl;
    private org.json.JSONObject mJsonPlan;
    private java.lang.String mPlanId;
    private com.sensorsdata.sf.ui.listener.PopupListener mPopupListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getWindowListener();
    private java.lang.String mTitle;

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ org.json.JSONObject val$actionJson;
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ android.widget.TextView val$textView;

        public AnonymousClass1(android.widget.TextView textView, org.json.JSONObject jSONObject, android.app.Activity activity) {
            this.val$textView = textView;
            this.val$actionJson = jSONObject;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.ui.view.DynamicViewHelper.this.handleAction("label", java.lang.String.valueOf(this.val$textView.getText()), this.val$actionJson, this.val$activity);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ org.json.JSONObject val$actionJson;
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ android.widget.TextView val$textView;

        public AnonymousClass2(android.widget.TextView textView, org.json.JSONObject jSONObject, android.app.Activity activity) {
            this.val$textView = textView;
            this.val$actionJson = jSONObject;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.ui.view.DynamicViewHelper.this.handleAction(com.sensorsdata.sf.ui.view.UIProperty.type_link, java.lang.String.valueOf(this.val$textView.getText()), this.val$actionJson, this.val$activity);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        final /* synthetic */ org.json.JSONObject val$actionJson;
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ android.widget.Button val$button;

        public AnonymousClass3(android.widget.Button button, org.json.JSONObject jSONObject, android.app.Activity activity) {
            this.val$button = button;
            this.val$actionJson = jSONObject;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.ui.view.DynamicViewHelper.this.handleAction(com.sensorsdata.sf.ui.view.UIProperty.type_button, java.lang.String.valueOf(this.val$button.getText()), this.val$actionJson, this.val$activity);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ org.json.JSONObject val$actionJson;
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass4(org.json.JSONObject jSONObject, android.app.Activity activity) {
            this.val$actionJson = jSONObject;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.ui.view.DynamicViewHelper.this.handleAction("image", "", this.val$actionJson, this.val$activity);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        final /* synthetic */ org.json.JSONObject val$actionJson;
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass5(org.json.JSONObject jSONObject, android.app.Activity activity) {
            this.val$actionJson = jSONObject;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.ui.view.DynamicViewHelper.this.handleAction(com.sensorsdata.sf.ui.view.UIProperty.type_image_button, "", this.val$actionJson, this.val$activity);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        final /* synthetic */ org.json.JSONObject val$actionJson;
        final /* synthetic */ android.app.Activity val$activity;

        public AnonymousClass6(org.json.JSONObject jSONObject, android.app.Activity activity) {
            this.val$actionJson = jSONObject;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.ui.view.DynamicViewHelper.this.handleAction("image", "", this.val$actionJson, this.val$activity);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.view.DynamicViewHelper$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ com.sensorsdata.sf.ui.view.MaskViewDynamic val$maskViewDynamic;

        public AnonymousClass7(com.sensorsdata.sf.ui.view.MaskViewDynamic maskViewDynamic, android.app.Activity activity) {
            this.val$maskViewDynamic = maskViewDynamic;
            this.val$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.sensorsdata.sf.core.entity.SFCampaign sFCampaign;
            try {
                com.sensorsdata.sf.ui.listener.PopupListener internalWindowListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getInternalWindowListener();
                if (internalWindowListener != null) {
                    internalWindowListener.onPopupClose(java.lang.String.valueOf(com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mPlanId));
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.sf_close_type, "POPUP_CLOSE_MASK");
                jSONObject.put("id", this.val$maskViewDynamic.getActionId());
                com.sensorsdata.sf.ui.track.SFTrackHelper.trackPlanPopupClick(com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mTitle, com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mContent, com.sensorsdata.sf.ui.view.UIProperty.type_mask, "", com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mImageUrl, jSONObject, com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mJsonPlan);
                if (com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mPopupListener != null) {
                    jSONObject.put("type", "close");
                    com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mPopupListener.onPopupClick(com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mPlanId, com.sensorsdata.sf.ui.view.DynamicViewHelper.this.getActionModel(jSONObject));
                    com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mPopupListener.onPopupClose(java.lang.String.valueOf(com.sensorsdata.sf.ui.view.DynamicViewHelper.this.mPlanId));
                }
                com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getSensorsFocusCampaignListener();
                if (sensorsFocusCampaignListener != null && (sFCampaign = com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign) != null) {
                    sensorsFocusCampaignListener.onCampaignEnd(sFCampaign.m96clone());
                    com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign = null;
                }
                this.val$activity.finish();
            } catch (org.json.JSONException e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public DynamicViewHelper(java.lang.String str, org.json.JSONObject jSONObject) {
        this.mPlanId = str;
        this.mJsonPlan = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sensorsdata.sf.ui.view.SensorsFocusActionModel getActionModel(org.json.JSONObject jSONObject) {
        char c;
        try {
            java.lang.String optString = jSONObject.optString("type");
            java.lang.String optString2 = jSONObject.optString("value");
            switch (optString.hashCode()) {
                case -503930556:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_link)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3059573:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_copy)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 94756344:
                    if (optString.equals("close")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1611566147:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_customize)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                com.sensorsdata.sf.ui.view.SensorsFocusActionModel sensorsFocusActionModel = com.sensorsdata.sf.ui.view.SensorsFocusActionModel.OPEN_LINK;
                sensorsFocusActionModel.setValue(optString2);
                sensorsFocusActionModel.setExtra(jSONObject.optJSONObject("extra"));
                return sensorsFocusActionModel;
            }
            if (c == 1) {
                com.sensorsdata.sf.ui.view.SensorsFocusActionModel sensorsFocusActionModel2 = com.sensorsdata.sf.ui.view.SensorsFocusActionModel.COPY;
                sensorsFocusActionModel2.setValue(optString2);
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject("extra");
                if (optJSONObject == null) {
                    optJSONObject = new org.json.JSONObject();
                }
                optJSONObject.put(com.sensorsdata.sf.ui.view.UIProperty.copied_tip, jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.copied_tip));
                sensorsFocusActionModel2.setExtra(optJSONObject);
                return sensorsFocusActionModel2;
            }
            if (c == 2) {
                com.sensorsdata.sf.ui.view.SensorsFocusActionModel sensorsFocusActionModel3 = com.sensorsdata.sf.ui.view.SensorsFocusActionModel.CLOSE;
                sensorsFocusActionModel3.setValue(optString2);
                sensorsFocusActionModel3.setExtra(jSONObject.optJSONObject("extra"));
                return sensorsFocusActionModel3;
            }
            if (c != 3) {
                return null;
            }
            com.sensorsdata.sf.ui.view.SensorsFocusActionModel sensorsFocusActionModel4 = com.sensorsdata.sf.ui.view.SensorsFocusActionModel.CUSTOMIZE;
            sensorsFocusActionModel4.setExtra(new org.json.JSONObject(optString2));
            return sensorsFocusActionModel4;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAction(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, android.app.Activity activity) {
        char c;
        com.sensorsdata.sf.core.entity.SFCampaign sFCampaign;
        com.sensorsdata.sf.core.entity.SFCampaign sFCampaign2;
        try {
            java.lang.String optString = jSONObject.optString("type");
            com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getSensorsFocusCampaignListener();
            switch (optString.hashCode()) {
                case -1367751899:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_camera)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -503930556:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_link)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 114009:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_sms)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 114715:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_tel)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3059573:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_copy)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 94756344:
                    if (optString.equals("close")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 96619420:
                    if (optString.equals("email")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1611566147:
                    if (optString.equals(com.sensorsdata.sf.ui.view.UIProperty.action_type_customize)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 4) {
                com.sensorsdata.sf.ui.track.SFTrackHelper.trackPlanPopupClick(this.mTitle, this.mContent, str, str2, this.mImageUrl, jSONObject, this.mJsonPlan);
                com.sensorsdata.sf.ui.listener.PopupListener popupListener = this.mPopupListener;
                if (popupListener != null) {
                    popupListener.onPopupClick(this.mPlanId, getActionModel(jSONObject));
                    this.mPopupListener.onPopupClose(java.lang.String.valueOf(this.mPlanId));
                }
                com.sensorsdata.sf.ui.listener.PopupListener internalWindowListener = com.sensorsdata.sf.core.SFContextManger.getInstance().getInternalWindowListener();
                if (internalWindowListener != null) {
                    internalWindowListener.onPopupClose(java.lang.String.valueOf(this.mPlanId));
                }
                if (sensorsFocusCampaignListener != null && (sFCampaign = com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign) != null) {
                    sensorsFocusCampaignListener.onCampaignEnd(sFCampaign.m96clone());
                    com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign = null;
                }
                activity.finish();
                return;
            }
            if (c == 5) {
                com.sensorsdata.sf.ui.track.SFTrackHelper.trackPlanPopupClick(this.mTitle, this.mContent, str, str2, this.mImageUrl, jSONObject, this.mJsonPlan);
                com.sensorsdata.sf.ui.utils.ActionHelper.copyToClip(activity, jSONObject.optString("value"));
                com.sensorsdata.sf.ui.listener.PopupListener popupListener2 = this.mPopupListener;
                if (popupListener2 != null) {
                    popupListener2.onPopupClick(java.lang.String.valueOf(this.mPlanId), getActionModel(jSONObject));
                    return;
                }
                return;
            }
            if (c == 6 || c == 7) {
                com.sensorsdata.sf.ui.track.SFTrackHelper.trackPlanPopupClick(this.mTitle, this.mContent, str, str2, this.mImageUrl, jSONObject, this.mJsonPlan);
                com.sensorsdata.sf.ui.listener.PopupListener popupListener3 = this.mPopupListener;
                if (popupListener3 != null) {
                    popupListener3.onPopupClick(java.lang.String.valueOf(this.mPlanId), getActionModel(jSONObject));
                    this.mPopupListener.onPopupClose(java.lang.String.valueOf(this.mPlanId));
                }
                com.sensorsdata.sf.ui.listener.PopupListener internalWindowListener2 = com.sensorsdata.sf.core.SFContextManger.getInstance().getInternalWindowListener();
                if (internalWindowListener2 != null) {
                    internalWindowListener2.onPopupClose(java.lang.String.valueOf(this.mPlanId));
                }
                if (sensorsFocusCampaignListener != null && (sFCampaign2 = com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign) != null) {
                    sensorsFocusCampaignListener.onCampaignEnd(sFCampaign2.m96clone());
                    com.sensorsdata.sf.core.campaign.CampaignManager.cacheSFCampaign = null;
                }
                activity.finish();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void addViewDynamic(java.lang.String str, com.sensorsdata.sf.ui.view.AbstractViewDynamic abstractViewDynamic) {
        viewDynamicHashMap.put(str, abstractViewDynamic);
    }

    public com.sensorsdata.sf.ui.view.AbstractViewDynamic getViewDynamic(java.lang.String str) {
        if (viewDynamicHashMap.containsKey(str)) {
            return viewDynamicHashMap.get(str);
        }
        return null;
    }

    public android.widget.Button handleButton(android.app.Activity activity, com.sensorsdata.sf.ui.view.ButtonDynamic buttonDynamic) {
        try {
            android.widget.Button createView = buttonDynamic.createView(activity);
            org.json.JSONObject actionJson = buttonDynamic.getActionJson();
            if (createView != null && actionJson != null) {
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass3(createView, actionJson, activity));
            }
            return createView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public com.sensorsdata.sf.ui.widget.GifView handleGifView(android.app.Activity activity, com.sensorsdata.sf.ui.view.GifViewDynamic gifViewDynamic) {
        try {
            com.sensorsdata.sf.ui.widget.GifView createView = gifViewDynamic.createView(activity);
            if ("image".equals(gifViewDynamic.getType())) {
                this.mImageUrl = gifViewDynamic.getImageUrl();
            }
            org.json.JSONObject actionJson = gifViewDynamic.getActionJson();
            if (createView != null && actionJson != null) {
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass6(actionJson, activity));
            }
            return createView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public android.view.View handleImageView(android.app.Activity activity, com.sensorsdata.sf.ui.view.ImageViewDynamic imageViewDynamic) {
        try {
            android.view.View createView = imageViewDynamic.createView(activity);
            if ("image".equals(imageViewDynamic.getType())) {
                this.mImageUrl = imageViewDynamic.getImageUrl();
            }
            org.json.JSONObject actionJson = imageViewDynamic.getActionJson();
            if (createView == null) {
                return null;
            }
            if ("image".equals(imageViewDynamic.getType()) && actionJson != null) {
                this.mImageUrl = imageViewDynamic.getImageUrl();
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass4(actionJson, activity));
            } else if (com.sensorsdata.sf.ui.view.UIProperty.type_image_button.equals(imageViewDynamic.getType()) && actionJson != null) {
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass5(actionJson, activity));
            }
            return createView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public android.widget.TextView handleLinkTextView(android.app.Activity activity, com.sensorsdata.sf.ui.view.LinkViewDynamic linkViewDynamic) {
        try {
            android.widget.TextView createView = linkViewDynamic.createView(activity);
            org.json.JSONObject actionJson = linkViewDynamic.getActionJson();
            if (actionJson != null) {
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass2(createView, actionJson, activity));
            }
            return createView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public android.widget.FrameLayout handleMaskLayout(android.app.Activity activity, com.sensorsdata.sf.ui.view.MaskViewDynamic maskViewDynamic) {
        try {
            android.widget.FrameLayout createView = maskViewDynamic.createView(activity);
            if (createView == null) {
                return null;
            }
            if (maskViewDynamic.isMaskCloseEnabled()) {
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass7(maskViewDynamic, activity));
            }
            return createView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public android.widget.TextView handleTextView(android.app.Activity activity, com.sensorsdata.sf.ui.view.TextViewDynamic textViewDynamic) {
        try {
            android.widget.TextView createView = textViewDynamic.createView(activity);
            if ("title".equals(textViewDynamic.getNameType())) {
                this.mTitle = textViewDynamic.getText();
            } else if ("content".equals(textViewDynamic.getNameType())) {
                this.mContent = textViewDynamic.getText();
            }
            org.json.JSONObject actionJson = textViewDynamic.getActionJson();
            if (actionJson != null) {
                createView.setOnClickListener(new com.sensorsdata.sf.ui.view.DynamicViewHelper.AnonymousClass1(createView, actionJson, activity));
            }
            return createView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public void removeViewDynamic(java.lang.String str) {
        if (viewDynamicHashMap.containsKey(str)) {
            viewDynamicHashMap.remove(str);
        }
    }
}

package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
final class GifViewDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic implements com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener {
    public static final java.lang.String FRAME_LAYOUT = "FRAME_LAYOUT";
    public static final java.lang.String LINEAR_LAYOUT = "LINEAR_LAYOUT";
    private static final java.lang.String TAG = "GifViewDynamic";
    private int mFrameCornerSize;
    java.lang.String mImageUrl;
    private java.lang.String mParentType;
    com.sensorsdata.sf.ui.widget.GifView mView;

    /* renamed from: com.sensorsdata.sf.ui.view.GifViewDynamic$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String hashKeyForDisk = com.sensorsdata.sf.ui.utils.ImageLoader.getInstance().hashKeyForDisk(com.sensorsdata.sf.ui.view.GifViewDynamic.this.mImageUrl);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.sensorsdata.sf.ui.view.GifViewDynamic.this.mContext.getCacheDir().getPath());
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append("ImageLoader");
            sb.append(str);
            sb.append(hashKeyForDisk);
            sb.append(".0");
            com.sensorsdata.sf.ui.view.GifViewDynamic.this.mView.setFilePath(sb.toString());
            com.sensorsdata.sf.ui.view.GifViewDynamic.this.mView.setBackgroundResource(0);
            com.sensorsdata.sf.ui.view.GifViewDynamic.this.mView.invalidate();
        }
    }

    public GifViewDynamic(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, java.lang.String str3, int i) {
        super(context, jSONObject);
        this.mParentType = str3;
        this.mImageUrl = str2;
        this.mType = str;
        this.mFrameCornerSize = i;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public com.sensorsdata.sf.ui.widget.GifView createView(android.app.Activity activity) {
        try {
            this.width = realSize(this.mContext, this.mLayoutJson.optString("width"));
            this.height = realSize(this.mContext, this.mLayoutJson.optString("height"));
            org.json.JSONObject jSONObject = this.mPropertyJson;
            if (jSONObject != null) {
                this.cornerRadius = realSize(this.mContext, jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.cornerRadius));
            }
            com.sensorsdata.sf.ui.widget.GifView gifView = new com.sensorsdata.sf.ui.widget.GifView(activity, null, this.width, this.height, this.cornerRadius, this.mFrameCornerSize);
            this.mView = gifView;
            com.sensorsdata.sf.core.utils.Utils.setPlaceholderBackground(gifView, this.mContext);
            com.sensorsdata.sf.ui.utils.ImageLoader.getInstance().loadBitmapAsync(this.mImageUrl, this);
            setViewConfig();
            return this.mView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public org.json.JSONObject getActionJson() {
        return this.mActionJson;
    }

    public java.lang.String getImageUrl() {
        return this.mImageUrl;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public com.sensorsdata.sf.ui.widget.GifView getView() {
        return this.mView;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void layoutView(org.json.JSONObject jSONObject) {
        try {
            if (FRAME_LAYOUT.equals(this.mParentType)) {
                return;
            }
            int align = align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.align));
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.margin);
            if (android.text.TextUtils.equals(this.mParentType, FRAME_LAYOUT)) {
                android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = align;
                if (optJSONObject != null) {
                    layoutParams.setMargins(realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
                }
                this.mView.setLayoutParams(layoutParams);
            } else {
                android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-1, -1);
                layoutParams2.gravity = align;
                if (optJSONObject != null) {
                    layoutParams2.setMargins(realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
                }
                this.mView.setLayoutParams(layoutParams2);
            }
            org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.padding);
            if (optJSONObject2 != null) {
                this.mView.setPadding(realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener
    public void onFailed(java.lang.String str) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, "loadImage error message:" + str);
    }

    @Override // com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener
    public void onSuccess(android.graphics.Bitmap bitmap) {
        com.sensorsdata.sf.ui.widget.GifView gifView = this.mView;
        if (gifView != null) {
            gifView.post(new com.sensorsdata.sf.ui.view.GifViewDynamic.AnonymousClass1());
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
    }
}

package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
class ImageViewDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic implements com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener {
    private static final java.lang.String TAG = "ImageViewDynamic";
    protected android.graphics.Bitmap bitmap;
    java.lang.String cornerRadiusString;
    protected java.lang.String mImageUrl;
    protected boolean mIsCornerAll;

    /* renamed from: com.sensorsdata.sf.ui.view.ImageViewDynamic$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap val$loadBitmap;

        public AnonymousClass1(android.graphics.Bitmap bitmap) {
            this.val$loadBitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.sf.ui.view.ImageViewDynamic imageViewDynamic = com.sensorsdata.sf.ui.view.ImageViewDynamic.this;
            imageViewDynamic.bitmap = this.val$loadBitmap;
            imageViewDynamic.setViewBackground(imageViewDynamic.cornerRadiusString);
        }
    }

    public ImageViewDynamic(android.content.Context context, java.lang.String str, int i, boolean z, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
        this.mType = str;
        this.cornerRadius = i;
        this.mIsCornerAll = z;
        org.json.JSONObject jSONObject2 = this.mPropertyJson;
        if (jSONObject2 != null) {
            this.mImageUrl = jSONObject2.optString("image");
        }
    }

    private void loadImage() {
        org.json.JSONObject jSONObject = this.mPropertyJson;
        if (jSONObject != null) {
            java.lang.String optString = jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.localImageName);
            if ("close".equals(optString)) {
                optString = "sensors_focus_close";
            }
            android.content.pm.ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
            int identifier = this.mContext.getResources().getIdentifier(optString, com.anythink.expressad.foundation.h.i.c, applicationInfo.packageName);
            this.cornerRadiusString = this.mPropertyJson.optString(com.sensorsdata.sf.ui.view.UIProperty.cornerRadius);
            if (identifier == 0) {
                identifier = this.mContext.getResources().getIdentifier(optString, "mipmap", applicationInfo.packageName);
            }
            if (identifier != 0) {
                this.bitmap = android.graphics.BitmapFactory.decodeResource(this.mContext.getResources(), identifier);
                setViewBackground(this.cornerRadiusString);
                return;
            }
            if (this.mPropertyJson == null) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "PropertyJson is null");
                return;
            }
            com.sensorsdata.sf.ui.utils.ImageLoader imageLoader = com.sensorsdata.sf.ui.utils.ImageLoader.getInstance();
            android.graphics.Bitmap loadBitmapFromMemory = imageLoader.loadBitmapFromMemory(this.mImageUrl);
            this.bitmap = loadBitmapFromMemory;
            if (loadBitmapFromMemory != null) {
                setViewBackground(this.cornerRadiusString);
            } else {
                setPlaceholderBackground();
                imageLoader.loadBitmapAsync(this.mImageUrl, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewBackground(java.lang.String str) {
        try {
            int i = this.cornerRadius;
            if (i == 0) {
                i = realSize(this.mContext, str);
            }
            this.bitmap = android.graphics.Bitmap.createScaledBitmap(this.bitmap, this.width, this.height, true);
            com.sensorsdata.sf.ui.widget.RoundedBitmapDrawable create = com.sensorsdata.sf.ui.widget.RoundedBitmapDrawableFactory.create(this.mContext.getResources(), this.bitmap, this.mIsCornerAll);
            create.setCornerRadius(i);
            create.setAntiAlias(true);
            this.mView.setBackground(create);
            ((android.widget.ImageView) this.mView).setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public android.view.View createView(android.app.Activity activity) {
        try {
            this.mView = new com.sensorsdata.sf.ui.widget.SFImageView(activity, this.mActionJson);
            return super.createView(activity);
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
    public java.lang.String getText() {
        return this.mText;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getType() {
        return this.mType;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void layoutView(org.json.JSONObject jSONObject) {
        if (this.isPORTRAIT) {
            super.layoutView(jSONObject);
            return;
        }
        try {
            this.width = realSize(this.mContext, jSONObject.optString("width")) / 2;
            this.height = realSize(this.mContext, jSONObject.optString("height")) / 2;
            int align = align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.align));
            if (this.width == 0) {
                this.width = -2;
            }
            if (this.height == 0) {
                this.height = -2;
            }
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(this.width, this.height);
            layoutParams.gravity = align;
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.margin);
            if (optJSONObject != null) {
                layoutParams.setMargins(realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
            }
            this.mView.setLayoutParams(layoutParams);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void onFailed(java.lang.String str) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, java.lang.String.format("Image load failed.error message is %s ", str));
    }

    public void onSuccess(android.graphics.Bitmap bitmap) {
        android.view.View view = this.mView;
        if (view != null) {
            view.post(new com.sensorsdata.sf.ui.view.ImageViewDynamic.AnonymousClass1(bitmap));
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setBackground(android.content.Context context, org.json.JSONObject jSONObject) {
        try {
            loadImage();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void setPlaceholderBackground() {
        com.sensorsdata.sf.core.utils.Utils.setPlaceholderBackground(this.mView, this.mContext);
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
        try {
            setBackground(this.mContext, jSONObject);
            this.mView.setVisibility(visible(jSONObject.optBoolean(com.sensorsdata.sf.ui.view.UIProperty.isHidden, false)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}

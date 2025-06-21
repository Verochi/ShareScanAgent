package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
final class FrameLayoutDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic implements com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener {
    private static final java.lang.String TAG = "FrameLayoutDynamic";
    private android.graphics.Bitmap bitmap;
    private java.util.Queue<com.sensorsdata.sf.ui.view.AbstractViewDynamic> childViews;
    private boolean isOuterView;
    private android.widget.LinearLayout linearLayout;
    private com.sensorsdata.sf.ui.view.GifViewDynamic mGifViewDynamic;
    private java.lang.String mImageUrl;
    private org.json.JSONObject mUIJson;

    /* renamed from: com.sensorsdata.sf.ui.view.FrameLayoutDynamic$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap val$loadBitmap;

        public AnonymousClass1(android.graphics.Bitmap bitmap) {
            this.val$loadBitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.sf.ui.view.FrameLayoutDynamic.this.bitmap = this.val$loadBitmap;
            android.graphics.Bitmap bitmap = com.sensorsdata.sf.ui.view.FrameLayoutDynamic.this.bitmap;
            com.sensorsdata.sf.ui.view.FrameLayoutDynamic frameLayoutDynamic = com.sensorsdata.sf.ui.view.FrameLayoutDynamic.this;
            com.sensorsdata.sf.core.utils.Utils.setViewBackground(bitmap, frameLayoutDynamic.mView, frameLayoutDynamic.mContext);
        }
    }

    public FrameLayoutDynamic(android.content.Context context, boolean z, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
        try {
            this.isOuterView = z;
            this.mUIJson = jSONObject;
            this.childViews = new java.util.ArrayDeque();
            org.json.JSONObject jSONObject2 = this.mPropertyJson;
            if (jSONObject2 != null) {
                this.cornerRadius = realSize(context, jSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.cornerRadius));
                this.mImageUrl = this.mPropertyJson.optString(com.sensorsdata.sf.ui.view.UIProperty.backgroundImage);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void loadImage(java.lang.String str) {
        try {
            com.sensorsdata.sf.ui.utils.ImageLoader imageLoader = com.sensorsdata.sf.ui.utils.ImageLoader.getInstance();
            android.graphics.Bitmap loadBitmapFromMemory = imageLoader.loadBitmapFromMemory(str);
            this.bitmap = loadBitmapFromMemory;
            if (loadBitmapFromMemory == null) {
                com.sensorsdata.sf.core.utils.Utils.setPlaceholderBackground(this.mView, this.mContext);
                imageLoader.loadBitmapAsync(this.mImageUrl, this);
            } else {
                com.sensorsdata.sf.core.utils.Utils.setViewBackground(loadBitmapFromMemory, this.mView, this.mContext);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public void addChildView(com.sensorsdata.sf.ui.view.AbstractViewDynamic abstractViewDynamic) {
        this.childViews.add(abstractViewDynamic);
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public android.widget.FrameLayout createView(android.app.Activity activity) {
        try {
            this.mView = new com.sensorsdata.sf.ui.widget.SFFrameLayout(activity, this.mActionJson);
            this.mType = this.mUIJson.optString("type");
            if (isGif()) {
                com.sensorsdata.sf.ui.view.GifViewDynamic gifViewDynamic = new com.sensorsdata.sf.ui.view.GifViewDynamic(this.mContext, this.mType, this.mImageUrl, this.mUIJson, com.sensorsdata.sf.ui.view.GifViewDynamic.FRAME_LAYOUT, this.cornerRadius);
                this.mGifViewDynamic = gifViewDynamic;
                ((com.sensorsdata.sf.ui.widget.SFFrameLayout) this.mView).addView(gifViewDynamic.createView(activity));
            }
            android.widget.LinearLayout createView = new com.sensorsdata.sf.ui.view.LinearLayoutDynamic(activity, this.mUIJson).createView(activity);
            this.linearLayout = createView;
            ((com.sensorsdata.sf.ui.widget.SFFrameLayout) this.mView).addView(createView);
            return (android.widget.FrameLayout) super.createView(activity);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public java.util.Queue<com.sensorsdata.sf.ui.view.AbstractViewDynamic> getChildViews() {
        return this.childViews;
    }

    public java.lang.String getImageUrl() {
        return this.mImageUrl;
    }

    public android.widget.LinearLayout getLinearLayout() {
        return this.linearLayout;
    }

    public boolean isGif() {
        try {
            if (android.text.TextUtils.isEmpty(this.mImageUrl)) {
                return false;
            }
            if ("image/gif".equals(com.sensorsdata.sf.ui.utils.ImageLoader.getInstance().getImageType(this.mImageUrl)) || this.mImageUrl.endsWith(".gif")) {
                return true;
            }
            java.lang.String lastPathSegment = android.net.Uri.parse(this.mImageUrl).getLastPathSegment();
            if (lastPathSegment != null) {
                return lastPathSegment.endsWith(".gif");
            }
            return false;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return false;
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void layoutView(org.json.JSONObject jSONObject) {
        if (!this.isPORTRAIT) {
            try {
                if (this.isOuterView) {
                    android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.mView.setLayoutParams(layoutParams);
                } else {
                    android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.align));
                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.margin);
                    if (optJSONObject != null) {
                        layoutParams2.setMargins(realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.left)) / 2, realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.top)) / 2, realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.right)) / 2, realSize(this.mContext, optJSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)) / 2);
                    }
                    this.mView.setLayoutParams(layoutParams2);
                }
                org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.padding);
                if (optJSONObject2 != null) {
                    this.mView.setPadding(realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.left)) / 2, realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.top)) / 2, realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.right)) / 2, realSize(this.mContext, optJSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)) / 2);
                    return;
                }
                return;
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                return;
            }
        }
        try {
            this.width = realSize(this.mContext, jSONObject.optString("width"));
            this.height = realSize(this.mContext, jSONObject.optString("height"));
            int align = align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.align));
            org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.margin);
            if (this.width == 0) {
                this.width = -2;
            }
            if (this.height == 0) {
                this.height = -2;
            }
            if (this.isOuterView) {
                android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(this.width, this.height);
                layoutParams3.gravity = 17;
                if (optJSONObject3 != null) {
                    layoutParams3.setMargins(0, com.sensorsdata.sf.ui.utils.SizeUtil.dip2px(this.mContext, -15.0f), 0, 0);
                }
                this.mView.setLayoutParams(layoutParams3);
            } else {
                android.widget.LinearLayout.LayoutParams layoutParams4 = new android.widget.LinearLayout.LayoutParams(this.width, this.height);
                layoutParams4.gravity = align;
                if (optJSONObject3 != null) {
                    layoutParams4.setMargins(realSize(this.mContext, optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject3.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
                }
                this.mView.setLayoutParams(layoutParams4);
            }
            org.json.JSONObject optJSONObject4 = jSONObject.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.padding);
            if (optJSONObject4 != null) {
                this.mView.setPadding(realSize(this.mContext, optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.left)), realSize(this.mContext, optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.top)), realSize(this.mContext, optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.right)), realSize(this.mContext, optJSONObject4.optString(com.sensorsdata.sf.ui.view.UIProperty.bottom)));
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e2);
        }
    }

    @Override // com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener
    public void onFailed(java.lang.String str) {
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, java.lang.String.format("Image load failed.error message is %s ", str));
    }

    @Override // com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener
    public void onSuccess(android.graphics.Bitmap bitmap) {
        try {
            android.view.View view = this.mView;
            if (view != null) {
                view.post(new com.sensorsdata.sf.ui.view.FrameLayoutDynamic.AnonymousClass1(bitmap));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setBackground(android.content.Context context, org.json.JSONObject jSONObject) {
        super.setBackground(context, jSONObject);
        if (!jSONObject.has(com.sensorsdata.sf.ui.view.UIProperty.backgroundImage) || isGif()) {
            return;
        }
        loadImage(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.backgroundImage));
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setBackground(this.mContext, jSONObject);
                this.mView.setVisibility(visible(jSONObject.optBoolean(com.sensorsdata.sf.ui.view.UIProperty.isHidden, false)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }
}

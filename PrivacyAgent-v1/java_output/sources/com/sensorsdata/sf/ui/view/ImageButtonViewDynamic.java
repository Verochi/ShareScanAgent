package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
public class ImageButtonViewDynamic extends com.sensorsdata.sf.ui.view.ImageViewDynamic {
    public ImageButtonViewDynamic(android.content.Context context, java.lang.String str, int i, boolean z, org.json.JSONObject jSONObject) {
        super(context, str, i, z, jSONObject);
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public /* bridge */ /* synthetic */ android.view.View createView(android.app.Activity activity) {
        return super.createView(activity);
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public /* bridge */ /* synthetic */ org.json.JSONObject getActionJson() {
        return super.getActionJson();
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public /* bridge */ /* synthetic */ java.lang.String getText() {
        return super.getText();
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public /* bridge */ /* synthetic */ java.lang.String getType() {
        return super.getType();
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public /* bridge */ /* synthetic */ android.view.View getView() {
        return super.getView();
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic, com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener
    public /* bridge */ /* synthetic */ void onFailed(java.lang.String str) {
        super.onFailed(str);
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic, com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener
    public /* bridge */ /* synthetic */ void onSuccess(android.graphics.Bitmap bitmap) {
        super.onSuccess(bitmap);
    }

    @Override // com.sensorsdata.sf.ui.view.ImageViewDynamic
    public void setPlaceholderBackground() {
        this.mView.setBackgroundColor(android.graphics.Color.parseColor("#EEF0F4"));
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public /* bridge */ /* synthetic */ void setViewConfig() {
        super.setViewConfig();
    }
}

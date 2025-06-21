package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
abstract class eg extends android.app.Dialog {
    public eg(android.content.Context context) {
        super(context);
        b();
    }

    private void b() {
        android.view.Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            a();
            window.getDecorView().setPadding(0, 0, 0, 0);
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    public abstract void a();
}

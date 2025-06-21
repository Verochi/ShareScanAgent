package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final java.lang.String ICON_ID_PREFIX = "com.amap.api.icon_";

    public static com.amap.api.maps.model.BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(com.amap.api.mapcore.util.cy.a.marker_default.name() + ".png");
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor defaultMarker(float f) {
        try {
            float f2 = (((int) (f + 15.0f)) / 30) * 30;
            if (f2 > 330.0f) {
                f2 = 330.0f;
            } else if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            java.lang.String str = "";
            if (f2 == 0.0f) {
                str = "RED";
            } else if (f2 == 30.0f) {
                str = "ORANGE";
            } else if (f2 == 60.0f) {
                str = "YELLOW";
            } else if (f2 == 120.0f) {
                str = "GREEN";
            } else if (f2 == 180.0f) {
                str = "CYAN";
            } else if (f2 == 210.0f) {
                str = "AZURE";
            } else if (f2 == 240.0f) {
                str = "BLUE";
            } else if (f2 == 270.0f) {
                str = "VIOLET";
            } else if (f2 == 300.0f) {
                str = "MAGENTA";
            } else if (f2 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + ".png");
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor fromAsset(java.lang.String str) {
        try {
            android.content.Context context = getContext();
            if (context != null) {
                return fromBitmap(com.amap.api.mapcore.util.dl.a(context, str));
            }
            java.io.InputStream resourceAsStream = com.amap.api.maps.model.BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(java.lang.String.valueOf(str)));
            android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read bitmap from assets failed " + th.getMessage());
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor fromBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new com.amap.api.maps.model.BitmapDescriptor(bitmap, ICON_ID_PREFIX + com.amap.api.mapcore.util.dl.b());
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read bitmap from bitmap failed " + th.getMessage());
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor fromFile(java.lang.String str) {
        try {
            android.content.Context context = getContext();
            if (context == null) {
                return null;
            }
            java.io.FileInputStream openFileInput = context.openFileInput(str);
            android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            com.amap.api.maps.model.BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            com.amap.api.mapcore.util.dl.a(decodeStream);
            return fromBitmap;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor fromPath(java.lang.String str) {
        try {
            return fromBitmap(android.graphics.BitmapFactory.decodeFile(str));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor fromResource(int i) {
        try {
            android.content.Context context = getContext();
            if (context != null) {
                return fromBitmap(android.graphics.BitmapFactory.decodeStream(context.getResources().openRawResource(i)));
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read bitmap from res failed " + th.getMessage());
            return null;
        }
    }

    public static com.amap.api.maps.model.BitmapDescriptor fromView(android.view.View view) {
        try {
            android.content.Context context = getContext();
            if (context == null) {
                return null;
            }
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(com.amap.api.mapcore.util.dl.a(frameLayout));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            com.amap.api.mapcore.util.dn.b(com.amap.api.mapcore.util.dm.f, "read bitmap from view failed " + th.getMessage());
            return null;
        }
    }

    public static android.content.Context getContext() {
        return com.amap.api.mapcore.util.p.a;
    }
}

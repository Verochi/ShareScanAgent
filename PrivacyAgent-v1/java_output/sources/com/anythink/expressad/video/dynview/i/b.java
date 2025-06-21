package com.anythink.expressad.video.dynview.i;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.expressad.video.dynview.i.b a;

    private static android.graphics.Bitmap a(int i) {
        android.graphics.Bitmap bitmap = null;
        try {
            bitmap = android.graphics.Bitmap.createBitmap(100, 100, android.graphics.Bitmap.Config.ARGB_4444);
            if (i == 1) {
                bitmap.eraseColor(android.graphics.Color.parseColor("#FF0000"));
            } else {
                bitmap.eraseColor(android.graphics.Color.parseColor("#FFFFFF"));
            }
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i) {
        android.renderscript.Allocation allocation;
        android.renderscript.RenderScript renderScript;
        android.renderscript.ScriptIntrinsicBlur scriptIntrinsicBlur;
        android.renderscript.Allocation allocation2;
        try {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
            renderScript = android.renderscript.RenderScript.create(com.anythink.core.common.b.o.a().f());
            try {
                scriptIntrinsicBlur = android.renderscript.ScriptIntrinsicBlur.create(renderScript, android.renderscript.Element.U8_4(renderScript));
                try {
                    allocation = android.renderscript.Allocation.createFromBitmap(renderScript, bitmap);
                    try {
                        allocation2 = android.renderscript.Allocation.createFromBitmap(renderScript, createBitmap);
                        try {
                            scriptIntrinsicBlur.setRadius(18.0f);
                            scriptIntrinsicBlur.setInput(allocation);
                            scriptIntrinsicBlur.forEach(allocation2);
                            allocation2.copyTo(createBitmap);
                            if (renderScript != null) {
                                try {
                                    renderScript.destroy();
                                } catch (java.lang.Throwable unused) {
                                }
                            }
                            try {
                                scriptIntrinsicBlur.destroy();
                            } catch (java.lang.Throwable unused2) {
                            }
                            if (allocation != null) {
                                try {
                                    allocation.destroy();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            try {
                                allocation2.destroy();
                            } catch (java.lang.Throwable unused4) {
                            }
                            return createBitmap;
                        } catch (java.lang.Throwable unused5) {
                            if (renderScript != null) {
                            }
                            if (scriptIntrinsicBlur != null) {
                            }
                            if (allocation != null) {
                            }
                            if (allocation2 != null) {
                            }
                            return null;
                        }
                    } catch (java.lang.Throwable unused6) {
                        allocation2 = null;
                    }
                } catch (java.lang.Throwable unused7) {
                    allocation = null;
                    allocation2 = null;
                }
            } catch (java.lang.Throwable unused8) {
                allocation = null;
                scriptIntrinsicBlur = null;
                allocation2 = scriptIntrinsicBlur;
                if (renderScript != null) {
                    try {
                        renderScript.destroy();
                    } catch (java.lang.Throwable unused9) {
                    }
                }
                if (scriptIntrinsicBlur != null) {
                    try {
                        scriptIntrinsicBlur.destroy();
                    } catch (java.lang.Throwable unused10) {
                    }
                }
                if (allocation != null) {
                    try {
                        allocation.destroy();
                    } catch (java.lang.Throwable unused11) {
                    }
                }
                if (allocation2 != null) {
                    try {
                        allocation2.destroy();
                    } catch (java.lang.Throwable unused12) {
                    }
                }
                return null;
            }
        } catch (java.lang.Throwable unused13) {
            allocation = null;
            renderScript = null;
            scriptIntrinsicBlur = null;
        }
    }

    public static com.anythink.expressad.video.dynview.i.b a() {
        if (a == null) {
            synchronized (com.anythink.expressad.video.dynview.i.b.class) {
                if (a == null) {
                    a = new com.anythink.expressad.video.dynview.i.b();
                }
            }
        }
        return a;
    }
}

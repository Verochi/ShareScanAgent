package com.otaliastudios.cameraview.engine.mappers;

/* loaded from: classes19.dex */
public class Camera1Mapper {
    public static com.otaliastudios.cameraview.engine.mappers.Camera1Mapper a;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.Flash, java.lang.String> b;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.WhiteBalance, java.lang.String> c;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.Facing, java.lang.Integer> d;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.Hdr, java.lang.String> e;

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        b = hashMap;
        java.util.HashMap hashMap2 = new java.util.HashMap();
        c = hashMap2;
        java.util.HashMap hashMap3 = new java.util.HashMap();
        d = hashMap3;
        java.util.HashMap hashMap4 = new java.util.HashMap();
        e = hashMap4;
        hashMap.put(com.otaliastudios.cameraview.controls.Flash.OFF, kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        hashMap.put(com.otaliastudios.cameraview.controls.Flash.ON, kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON);
        hashMap.put(com.otaliastudios.cameraview.controls.Flash.AUTO, "auto");
        hashMap.put(com.otaliastudios.cameraview.controls.Flash.TORCH, "torch");
        hashMap3.put(com.otaliastudios.cameraview.controls.Facing.BACK, 0);
        hashMap3.put(com.otaliastudios.cameraview.controls.Facing.FRONT, 1);
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.AUTO, "auto");
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.INCANDESCENT, "incandescent");
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.FLUORESCENT, "fluorescent");
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.DAYLIGHT, "daylight");
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.CLOUDY, "cloudy-daylight");
        hashMap4.put(com.otaliastudios.cameraview.controls.Hdr.OFF, "auto");
        hashMap4.put(com.otaliastudios.cameraview.controls.Hdr.ON, "hdr");
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.engine.mappers.Camera1Mapper get() {
        if (a == null) {
            a = new com.otaliastudios.cameraview.engine.mappers.Camera1Mapper();
        }
        return a;
    }

    @androidx.annotation.Nullable
    public final <C extends com.otaliastudios.cameraview.controls.Control, T> C a(@androidx.annotation.NonNull java.util.Map<C, T> map, @androidx.annotation.NonNull T t) {
        for (C c2 : map.keySet()) {
            if (t.equals(map.get(c2))) {
                return c2;
            }
        }
        return null;
    }

    public int mapFacing(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing) {
        return d.get(facing).intValue();
    }

    @androidx.annotation.NonNull
    public java.lang.String mapFlash(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        return b.get(flash);
    }

    @androidx.annotation.NonNull
    public java.lang.String mapHdr(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        return e.get(hdr);
    }

    @androidx.annotation.NonNull
    public java.lang.String mapWhiteBalance(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        return c.get(whiteBalance);
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.Facing unmapFacing(int i) {
        return (com.otaliastudios.cameraview.controls.Facing) a(d, java.lang.Integer.valueOf(i));
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.Flash unmapFlash(@androidx.annotation.NonNull java.lang.String str) {
        return (com.otaliastudios.cameraview.controls.Flash) a(b, str);
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.Hdr unmapHdr(@androidx.annotation.NonNull java.lang.String str) {
        return (com.otaliastudios.cameraview.controls.Hdr) a(e, str);
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.WhiteBalance unmapWhiteBalance(@androidx.annotation.NonNull java.lang.String str) {
        return (com.otaliastudios.cameraview.controls.WhiteBalance) a(c, str);
    }
}

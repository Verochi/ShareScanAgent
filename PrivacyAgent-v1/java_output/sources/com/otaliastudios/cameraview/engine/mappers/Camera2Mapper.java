package com.otaliastudios.cameraview.engine.mappers;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Camera2Mapper {
    public static com.otaliastudios.cameraview.engine.mappers.Camera2Mapper a;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.Facing, java.lang.Integer> b;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.WhiteBalance, java.lang.Integer> c;
    public static final java.util.Map<com.otaliastudios.cameraview.controls.Hdr, java.lang.Integer> d;

    /* renamed from: com.otaliastudios.cameraview.engine.mappers.Camera2Mapper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.controls.Flash.values().length];
            a = iArr;
            try {
                iArr[com.otaliastudios.cameraview.controls.Flash.ON.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Flash.AUTO.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Flash.OFF.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Flash.TORCH.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        b = hashMap;
        java.util.HashMap hashMap2 = new java.util.HashMap();
        c = hashMap2;
        java.util.HashMap hashMap3 = new java.util.HashMap();
        d = hashMap3;
        hashMap.put(com.otaliastudios.cameraview.controls.Facing.BACK, 1);
        hashMap.put(com.otaliastudios.cameraview.controls.Facing.FRONT, 0);
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.AUTO, 1);
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.CLOUDY, 6);
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.DAYLIGHT, 5);
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.FLUORESCENT, 3);
        hashMap2.put(com.otaliastudios.cameraview.controls.WhiteBalance.INCANDESCENT, 2);
        hashMap3.put(com.otaliastudios.cameraview.controls.Hdr.OFF, 0);
        hashMap3.put(com.otaliastudios.cameraview.controls.Hdr.ON, 18);
    }

    public static com.otaliastudios.cameraview.engine.mappers.Camera2Mapper get() {
        if (a == null) {
            a = new com.otaliastudios.cameraview.engine.mappers.Camera2Mapper();
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
        return b.get(facing).intValue();
    }

    @androidx.annotation.NonNull
    public java.util.List<android.util.Pair<java.lang.Integer, java.lang.Integer>> mapFlash(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = com.otaliastudios.cameraview.engine.mappers.Camera2Mapper.AnonymousClass1.a[flash.ordinal()];
        if (i == 1) {
            arrayList.add(new android.util.Pair(3, 0));
        } else if (i == 2) {
            arrayList.add(new android.util.Pair(2, 0));
            arrayList.add(new android.util.Pair(4, 0));
        } else if (i == 3) {
            arrayList.add(new android.util.Pair(1, 0));
            arrayList.add(new android.util.Pair(0, 0));
        } else if (i == 4) {
            arrayList.add(new android.util.Pair(1, 2));
            arrayList.add(new android.util.Pair(0, 2));
        }
        return arrayList;
    }

    public int mapHdr(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        return d.get(hdr).intValue();
    }

    public int mapWhiteBalance(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        return c.get(whiteBalance).intValue();
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.Facing unmapFacing(int i) {
        return (com.otaliastudios.cameraview.controls.Facing) a(b, java.lang.Integer.valueOf(i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r3 != 4) goto L16;
     */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.Set<com.otaliastudios.cameraview.controls.Flash> unmapFlash(int i) {
        java.util.HashSet hashSet = new java.util.HashSet();
        if (i == 0 || i == 1) {
            hashSet.add(com.otaliastudios.cameraview.controls.Flash.OFF);
            hashSet.add(com.otaliastudios.cameraview.controls.Flash.TORCH);
        } else {
            if (i != 2) {
                if (i == 3) {
                    hashSet.add(com.otaliastudios.cameraview.controls.Flash.ON);
                }
            }
            hashSet.add(com.otaliastudios.cameraview.controls.Flash.AUTO);
        }
        return hashSet;
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.Hdr unmapHdr(int i) {
        return (com.otaliastudios.cameraview.controls.Hdr) a(d, java.lang.Integer.valueOf(i));
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.controls.WhiteBalance unmapWhiteBalance(int i) {
        return (com.otaliastudios.cameraview.controls.WhiteBalance) a(c, java.lang.Integer.valueOf(i));
    }
}

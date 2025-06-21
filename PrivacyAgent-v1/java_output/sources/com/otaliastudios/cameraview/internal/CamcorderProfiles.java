package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class CamcorderProfiles {
    public static final com.otaliastudios.cameraview.CameraLogger a = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.internal.CamcorderProfiles.class.getSimpleName());

    @android.annotation.SuppressLint({"UseSparseArrays"})
    public static java.util.Map<com.otaliastudios.cameraview.size.Size, java.lang.Integer> b;

    /* renamed from: com.otaliastudios.cameraview.internal.CamcorderProfiles$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<com.otaliastudios.cameraview.size.Size> {
        public final /* synthetic */ long n;

        public AnonymousClass1(long j) {
            this.n = j;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.otaliastudios.cameraview.size.Size size, com.otaliastudios.cameraview.size.Size size2) {
            long abs = java.lang.Math.abs((size.getWidth() * size.getHeight()) - this.n);
            long abs2 = java.lang.Math.abs((size2.getWidth() * size2.getHeight()) - this.n);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        b = hashMap;
        hashMap.put(new com.otaliastudios.cameraview.size.Size(176, 144), 2);
        b.put(new com.otaliastudios.cameraview.size.Size(320, 240), 7);
        b.put(new com.otaliastudios.cameraview.size.Size(352, com.anythink.expressad.foundation.g.a.aW), 3);
        b.put(new com.otaliastudios.cameraview.size.Size(720, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH), 4);
        b.put(new com.otaliastudios.cameraview.size.Size(1280, 720), 5);
        b.put(new com.otaliastudios.cameraview.size.Size(1920, com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED), 6);
        b.put(new com.otaliastudios.cameraview.size.Size(3840, 2160), 8);
    }

    @androidx.annotation.NonNull
    public static android.media.CamcorderProfile get(int i, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        long width = size.getWidth() * size.getHeight();
        java.util.ArrayList arrayList = new java.util.ArrayList(b.keySet());
        java.util.Collections.sort(arrayList, new com.otaliastudios.cameraview.internal.CamcorderProfiles.AnonymousClass1(width));
        while (arrayList.size() > 0) {
            int intValue = b.get((com.otaliastudios.cameraview.size.Size) arrayList.remove(0)).intValue();
            if (android.media.CamcorderProfile.hasProfile(i, intValue)) {
                return android.media.CamcorderProfile.get(i, intValue);
            }
        }
        return android.media.CamcorderProfile.get(i, 0);
    }

    @androidx.annotation.NonNull
    public static android.media.CamcorderProfile get(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        try {
            return get(java.lang.Integer.parseInt(str), size);
        } catch (java.lang.NumberFormatException unused) {
            a.w("NumberFormatException for Camera2 id:", str);
            return android.media.CamcorderProfile.get(0);
        }
    }
}

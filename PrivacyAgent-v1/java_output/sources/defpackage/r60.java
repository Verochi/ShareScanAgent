package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class r60 {
    public static boolean a(com.google.android.exoplayer2.drm.DrmSession drmSession) {
        return false;
    }

    public static void b(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.acquire(null);
        }
        if (drmSession != null) {
            drmSession.release(null);
        }
    }
}

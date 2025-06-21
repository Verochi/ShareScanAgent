package com.jd.ad.sdk.jad_vg;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_ju.jad_ly<android.net.Uri, android.graphics.drawable.Drawable> {
    public final android.content.Context jad_an;

    public jad_er(android.content.Context context) {
        this.jad_an = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.jd.ad.sdk.jad_mx.jad_xk jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        android.content.Context createPackageContext;
        java.util.List<java.lang.String> pathSegments;
        int parseInt;
        android.graphics.drawable.Drawable jad_an;
        java.lang.String authority = uri.getAuthority();
        if (!authority.equals(this.jad_an.getPackageName())) {
            try {
                createPackageContext = this.jad_an.createPackageContext(authority, 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                if (!authority.contains(this.jad_an.getPackageName())) {
                    throw new java.lang.IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
                }
            }
            pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                java.util.List<java.lang.String> pathSegments2 = uri.getPathSegments();
                java.lang.String authority2 = uri.getAuthority();
                java.lang.String str = pathSegments2.get(0);
                java.lang.String str2 = pathSegments2.get(1);
                parseInt = createPackageContext.getResources().getIdentifier(str2, str, authority2);
                if (parseInt == 0) {
                    parseInt = android.content.res.Resources.getSystem().getIdentifier(str2, str, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
                }
                if (parseInt == 0) {
                    throw new java.lang.IllegalArgumentException("Failed to find resource id for: " + uri);
                }
            } else {
                if (pathSegments.size() != 1) {
                    throw new java.lang.IllegalArgumentException("Unrecognized Uri format: " + uri);
                }
                try {
                    parseInt = java.lang.Integer.parseInt(uri.getPathSegments().get(0));
                } catch (java.lang.NumberFormatException e2) {
                    throw new java.lang.IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
                }
            }
            jad_an = com.jd.ad.sdk.jad_vg.jad_bo.jad_an(this.jad_an, createPackageContext, parseInt, null);
            if (jad_an == null) {
                return new com.jd.ad.sdk.jad_vg.jad_dq(jad_an);
            }
            return null;
        }
        createPackageContext = this.jad_an;
        pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 2) {
        }
        jad_an = com.jd.ad.sdk.jad_vg.jad_bo.jad_an(this.jad_an, createPackageContext, parseInt, null);
        if (jad_an == null) {
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an(uri);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return uri.getScheme().equals("android.resource");
    }
}

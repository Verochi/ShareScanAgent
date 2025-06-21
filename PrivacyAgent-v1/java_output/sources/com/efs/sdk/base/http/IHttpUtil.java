package com.efs.sdk.base.http;

/* loaded from: classes22.dex */
public interface IHttpUtil {
    @androidx.annotation.NonNull
    com.efs.sdk.base.http.HttpResponse get(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map);

    @androidx.annotation.NonNull
    com.efs.sdk.base.http.HttpResponse post(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.io.File file);

    @androidx.annotation.NonNull
    com.efs.sdk.base.http.HttpResponse post(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, byte[] bArr);

    @androidx.annotation.NonNull
    com.efs.sdk.base.http.HttpResponse postAsFile(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, byte[] bArr);
}

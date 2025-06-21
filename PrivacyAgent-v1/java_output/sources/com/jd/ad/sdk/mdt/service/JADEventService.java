package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADEventService {
    void reportClickEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void reportCloseEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10);

    void reportExceptionEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2);

    void reportExposureEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, java.lang.String str3, int i10, int i11);

    void reportPreloadClickEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void reportPreloadCloseEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10);

    void reportPreloadExposureEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, java.lang.String str3, int i10, int i11);

    void reportPreloadRenderSuccessEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9);

    void reportPreloadResponseEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9);

    void reportRenderFailedEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2, int i2);

    void reportRenderSuccessEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9);

    void reportRequestErrorEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2);

    void reportResponseEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9);

    void reportVideoEvent(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, long j, long j2, long j3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, double d);

    void reportVideoExceptionEvent(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2);
}

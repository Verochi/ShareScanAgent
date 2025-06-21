package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class e {
    private java.lang.String a;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode i;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode j = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE;

    public long a() {
        return this.c;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(android.graphics.Rect rect) {
    }

    public void a(com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode cropMode) {
        this.i = cropMode;
    }

    public void a(com.aliyun.svideosdk.common.struct.common.MediaType mediaType) {
    }

    public void a(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        this.j = videoDisplayMode;
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    public com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode b() {
        return this.i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void b(long j) {
    }

    public int c() {
        return this.h;
    }

    public void c(int i) {
        this.e = i;
    }

    public void c(long j) {
        this.b = j;
    }

    public int d() {
        return this.g;
    }

    public void d(int i) {
        this.d = i;
    }

    public java.lang.String e() {
        return this.a;
    }

    public void e(int i) {
        this.f = i;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.d;
    }

    public long h() {
        return this.b;
    }

    public int i() {
        return this.f;
    }

    public com.aliyun.svideosdk.common.struct.common.VideoDisplayMode j() {
        return this.j;
    }
}

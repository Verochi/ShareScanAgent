package com.aliyun.svideosdk.multirecorder.impl.c;

/* loaded from: classes12.dex */
public interface e extends com.aliyun.svideosdk.multirecorder.impl.c.d {

    public enum a {
        BITMAP,
        TEXTURE_OES_ID
    }

    public interface b<T> {
        void a(T t);
    }

    public interface c {
        void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar);

        void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, com.aliyun.svideosdk.common.struct.common.AliyunBorderParam aliyunBorderParam, int i, int i2);

        void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam);

        void a(com.aliyun.svideosdk.multirecorder.impl.c.e eVar, boolean z);

        void b(com.aliyun.svideosdk.multirecorder.impl.c.e eVar);

        void c(com.aliyun.svideosdk.multirecorder.impl.c.e eVar);
    }

    void a(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource, com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam, com.aliyun.svideosdk.multirecorder.impl.b bVar);

    void a(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar);

    void a(com.aliyun.svideosdk.multirecorder.impl.c.e.c cVar);

    boolean a();

    com.aliyun.svideosdk.common.AliyunRecordVideoSource b();

    com.aliyun.svideosdk.multirecorder.impl.c.e.a e();

    boolean f();

    boolean h();
}

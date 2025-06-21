package com.aliyun.svideo.base.beauty.api.constant;

/* loaded from: classes.dex */
public class BeautyConstant {
    public static final int BEAUTY_INIT_ERROR = -1;
    public static final int BEAUTY_INIT_SUCCEED = 0;
    public static java.util.Map<com.aliyun.svideo.base.beauty.api.constant.BeautySDKType, java.lang.String> beautyManagerImplMap = new com.aliyun.svideo.base.beauty.api.constant.BeautyConstant.AnonymousClass1();

    /* renamed from: com.aliyun.svideo.base.beauty.api.constant.BeautyConstant$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.HashMap<com.aliyun.svideo.base.beauty.api.constant.BeautySDKType, java.lang.String> {
        public AnonymousClass1() {
            put(com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.RACE, "com.aliyun.svideo.beauty.race.manager.RaceManager");
            put(com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.FACEUNITY, "com.aliyun.svideo.beauty.faceunity.FaceUnityManager");
            put(com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.QUEEN, "com.aliyun.svideo.beauty.queen.manager.QueenManager");
        }
    }
}

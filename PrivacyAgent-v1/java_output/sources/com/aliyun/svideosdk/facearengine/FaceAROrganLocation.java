package com.aliyun.svideosdk.facearengine;

/* loaded from: classes12.dex */
public class FaceAROrganLocation {
    public java.util.ArrayList<com.aliyun.svideosdk.facearengine.FaceARFaceResult> mFacePonits;

    public int getFaceCount() {
        java.util.ArrayList<com.aliyun.svideosdk.facearengine.FaceARFaceResult> arrayList = this.mFacePonits;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}

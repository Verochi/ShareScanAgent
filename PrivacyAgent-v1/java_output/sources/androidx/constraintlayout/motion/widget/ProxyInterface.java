package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
interface ProxyInterface {
    int designAccess(int i, java.lang.String str, java.lang.Object obj, float[] fArr, int i2, float[] fArr2, int i3);

    float getKeyFramePosition(java.lang.Object obj, int i, float f, float f2);

    java.lang.Object getKeyframeAtLocation(java.lang.Object obj, float f, float f2);

    java.lang.Boolean getPositionKeyframe(java.lang.Object obj, java.lang.Object obj2, float f, float f2, java.lang.String[] strArr, float[] fArr);

    long getTransitionTimeMs();

    void setAttributes(int i, java.lang.String str, java.lang.Object obj, java.lang.Object obj2);

    void setKeyFrame(java.lang.Object obj, int i, java.lang.String str, java.lang.Object obj2);

    boolean setKeyFramePosition(java.lang.Object obj, int i, int i2, float f, float f2);

    void setToolPosition(float f);
}

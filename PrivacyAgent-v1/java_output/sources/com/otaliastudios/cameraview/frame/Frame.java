package com.otaliastudios.cameraview.frame;

/* loaded from: classes19.dex */
public class Frame {
    public static final com.otaliastudios.cameraview.CameraLogger j = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.frame.Frame.class.getSimpleName());
    public final com.otaliastudios.cameraview.frame.FrameManager a;
    public final java.lang.Class<?> b;
    public java.lang.Object c = null;
    public long d = -1;
    public long e = -1;
    public int f = 0;
    public int g = 0;
    public com.otaliastudios.cameraview.size.Size h = null;
    public int i = -1;

    public Frame(@androidx.annotation.NonNull com.otaliastudios.cameraview.frame.FrameManager frameManager) {
        this.a = frameManager;
        this.b = frameManager.getFrameDataClass();
    }

    public final void a() {
        if (b()) {
            return;
        }
        j.e("Frame is dead! time:", java.lang.Long.valueOf(this.d), "lastTime:", java.lang.Long.valueOf(this.e));
        throw new java.lang.RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
    }

    public final boolean b() {
        return this.c != null;
    }

    public void c(@androidx.annotation.NonNull java.lang.Object obj, long j2, int i, int i2, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, int i3) {
        this.c = obj;
        this.d = j2;
        this.e = j2;
        this.f = i;
        this.g = i2;
        this.h = size;
        this.i = i3;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.otaliastudios.cameraview.frame.Frame) && ((com.otaliastudios.cameraview.frame.Frame) obj).d == this.d;
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"NewApi"})
    public com.otaliastudios.cameraview.frame.Frame freeze() {
        a();
        com.otaliastudios.cameraview.frame.Frame frame = new com.otaliastudios.cameraview.frame.Frame(this.a);
        frame.c(this.a.a(getData()), this.d, this.f, this.g, this.h, this.i);
        return frame;
    }

    @androidx.annotation.NonNull
    public <T> T getData() {
        a();
        return (T) this.c;
    }

    @androidx.annotation.NonNull
    public java.lang.Class<?> getDataClass() {
        return this.b;
    }

    public int getFormat() {
        a();
        return this.i;
    }

    @java.lang.Deprecated
    public int getRotation() {
        return getRotationToUser();
    }

    public int getRotationToUser() {
        a();
        return this.f;
    }

    public int getRotationToView() {
        a();
        return this.g;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.size.Size getSize() {
        a();
        return this.h;
    }

    public long getTime() {
        a();
        return this.d;
    }

    public void release() {
        if (b()) {
            j.v("Frame with time", java.lang.Long.valueOf(this.d), "is being released.");
            java.lang.Object obj = this.c;
            this.c = null;
            this.f = 0;
            this.g = 0;
            this.d = -1L;
            this.h = null;
            this.i = -1;
            this.a.b(this, obj);
        }
    }
}

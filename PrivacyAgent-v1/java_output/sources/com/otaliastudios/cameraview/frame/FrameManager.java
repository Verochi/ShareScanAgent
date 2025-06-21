package com.otaliastudios.cameraview.frame;

/* loaded from: classes19.dex */
public abstract class FrameManager<T> {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.frame.FrameManager.class.getSimpleName());
    public final int a;
    public int b = -1;
    public com.otaliastudios.cameraview.size.Size c = null;
    public int d = -1;
    public final java.lang.Class<T> e;
    public java.util.concurrent.LinkedBlockingQueue<com.otaliastudios.cameraview.frame.Frame> f;
    public com.otaliastudios.cameraview.engine.offset.Angles g;

    public FrameManager(int i, @androidx.annotation.NonNull java.lang.Class<T> cls) {
        this.a = i;
        this.e = cls;
        this.f = new java.util.concurrent.LinkedBlockingQueue<>(i);
    }

    @androidx.annotation.NonNull
    public final T a(@androidx.annotation.NonNull T t) {
        return onCloneFrameData(t);
    }

    public void b(@androidx.annotation.NonNull com.otaliastudios.cameraview.frame.Frame frame, @androidx.annotation.NonNull T t) {
        if (isSetUp()) {
            onFrameDataReleased(t, this.f.offer(frame));
        }
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.frame.Frame getFrame(@androidx.annotation.NonNull T t, long j) {
        if (!isSetUp()) {
            throw new java.lang.IllegalStateException("Can't call getFrame() after releasing or before setUp.");
        }
        com.otaliastudios.cameraview.frame.Frame poll = this.f.poll();
        if (poll == null) {
            LOG.i("getFrame for time:", java.lang.Long.valueOf(j), "NOT AVAILABLE.");
            onFrameDataReleased(t, false);
            return null;
        }
        LOG.v("getFrame for time:", java.lang.Long.valueOf(j), "RECYCLING.");
        com.otaliastudios.cameraview.engine.offset.Angles angles = this.g;
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR;
        com.otaliastudios.cameraview.engine.offset.Reference reference2 = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        com.otaliastudios.cameraview.engine.offset.Axis axis = com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR;
        poll.c(t, j, angles.offset(reference, reference2, axis), this.g.offset(reference, com.otaliastudios.cameraview.engine.offset.Reference.VIEW, axis), this.c, this.d);
        return poll;
    }

    public final int getFrameBytes() {
        return this.b;
    }

    public final java.lang.Class<T> getFrameDataClass() {
        return this.e;
    }

    public final int getPoolSize() {
        return this.a;
    }

    public boolean isSetUp() {
        return this.c != null;
    }

    @androidx.annotation.NonNull
    public abstract T onCloneFrameData(@androidx.annotation.NonNull T t);

    public abstract void onFrameDataReleased(@androidx.annotation.NonNull T t, boolean z);

    public void release() {
        if (!isSetUp()) {
            LOG.w("release called twice. Ignoring.");
            return;
        }
        LOG.i("release: Clearing the frame and buffer queue.");
        this.f.clear();
        this.b = -1;
        this.c = null;
        this.d = -1;
        this.g = null;
    }

    public void setUp(int i, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Angles angles) {
        isSetUp();
        this.c = size;
        this.d = i;
        this.b = (int) java.lang.Math.ceil(((size.getHeight() * size.getWidth()) * android.graphics.ImageFormat.getBitsPerPixel(i)) / 8.0d);
        for (int i2 = 0; i2 < getPoolSize(); i2++) {
            this.f.offer(new com.otaliastudios.cameraview.frame.Frame(this));
        }
        this.g = angles;
    }
}

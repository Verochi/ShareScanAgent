package com.otaliastudios.cameraview.video.encoding;

@androidx.annotation.RequiresApi(api = 18)
/* loaded from: classes19.dex */
public class MediaEncoderEngine {
    public static final int END_BY_MAX_DURATION = 1;
    public static final int END_BY_MAX_SIZE = 2;
    public static final int END_BY_USER = 0;
    public static final com.otaliastudios.cameraview.CameraLogger l = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.class.getSimpleName());
    public final java.util.List<com.otaliastudios.cameraview.video.encoding.MediaEncoder> a;
    public android.media.MediaMuxer b;
    public int c;
    public int d;
    public boolean e;
    public final com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller f;
    public final com.otaliastudios.cameraview.internal.WorkerHandler g;
    public final java.lang.Object h;
    public com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener i;
    public int j;
    public int k;

    public class Controller {

        @android.annotation.SuppressLint({"UseSparseArrays"})
        public java.util.Map<java.lang.Integer, java.lang.Integer> a = new java.util.HashMap();

        /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine$Controller$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.b.start();
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.e = true;
                if (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.i != null) {
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.i.onEncodingStart();
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine$Controller$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.stop();
            }
        }

        /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine$Controller$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.o();
            }
        }

        public Controller() {
        }

        public boolean isStarted() {
            boolean z;
            synchronized (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.h) {
                z = com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.e;
            }
            return z;
        }

        public int notifyStarted(@androidx.annotation.NonNull android.media.MediaFormat mediaFormat) {
            int addTrack;
            synchronized (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.h) {
                if (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.e) {
                    throw new java.lang.IllegalStateException("Trying to start but muxer started already");
                }
                addTrack = com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.b.addTrack(mediaFormat);
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.w("notifyStarted:", "Assigned track", java.lang.Integer.valueOf(addTrack), "to format", mediaFormat.getString("mime"));
                if (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.h(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this) == com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.a.size()) {
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.w("notifyStarted:", "All encoders have started.", "Starting muxer and dispatching onEncodingStart().");
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.g.run(new com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller.AnonymousClass1());
                }
            }
            return addTrack;
        }

        public void notifyStopped(int i) {
            synchronized (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.h) {
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.w("notifyStopped:", "Called for track", java.lang.Integer.valueOf(i));
                if (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.c(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this) == com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.a.size()) {
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.w("requestStop:", "All encoders have been stopped.", "Stopping the muxer.");
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.g.run(new com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller.AnonymousClass3());
                }
            }
        }

        public void requestStop(int i) {
            synchronized (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.h) {
                com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.w("requestStop:", "Called for track", java.lang.Integer.valueOf(i));
                if (com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.i(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this) == 0) {
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.w("requestStop:", "All encoders have requested a stop.", "Stopping them.");
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine = com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this;
                    mediaEncoderEngine.j = mediaEncoderEngine.k;
                    com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.g.run(new com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller.AnonymousClass2());
                }
            }
        }

        public void write(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.OutputBufferPool outputBufferPool, @androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.OutputBuffer outputBuffer) {
            int intValue;
            java.lang.Integer num = this.a.get(java.lang.Integer.valueOf(outputBuffer.trackIndex));
            java.util.Map<java.lang.Integer, java.lang.Integer> map = this.a;
            java.lang.Integer valueOf = java.lang.Integer.valueOf(outputBuffer.trackIndex);
            if (num == null) {
                intValue = 1;
            } else {
                num = java.lang.Integer.valueOf(num.intValue() + 1);
                intValue = num.intValue();
            }
            map.put(valueOf, java.lang.Integer.valueOf(intValue));
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(outputBuffer.info.presentationTimeUs / 1000);
            com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.l.v("write:", "Writing into muxer -", "track:", java.lang.Integer.valueOf(outputBuffer.trackIndex), "presentation:", java.lang.Long.valueOf(outputBuffer.info.presentationTimeUs), "readable:", calendar.get(13) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + calendar.get(14), "count:", num);
            com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.this.b.writeSampleData(outputBuffer.trackIndex, outputBuffer.data, outputBuffer.info);
            outputBufferPool.recycle(outputBuffer);
        }
    }

    public interface Listener {
        @com.otaliastudios.cameraview.video.encoding.EncoderThread
        void onEncodingEnd(int i, @androidx.annotation.Nullable java.lang.Exception exc);

        @com.otaliastudios.cameraview.video.encoding.EncoderThread
        void onEncodingStart();

        @com.otaliastudios.cameraview.video.encoding.EncoderThread
        void onEncodingStop();
    }

    public MediaEncoderEngine(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder videoMediaEncoder, @androidx.annotation.Nullable com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder audioMediaEncoder, int i, long j, @androidx.annotation.Nullable com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener listener) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.a = arrayList;
        this.c = 0;
        this.d = 0;
        this.e = false;
        this.f = new com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller();
        this.g = com.otaliastudios.cameraview.internal.WorkerHandler.get("EncoderEngine");
        this.h = new java.lang.Object();
        this.j = 0;
        this.i = listener;
        arrayList.add(videoMediaEncoder);
        if (audioMediaEncoder != null) {
            arrayList.add(audioMediaEncoder);
        }
        try {
            this.b = new android.media.MediaMuxer(file.toString(), 0);
            java.util.Iterator it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((com.otaliastudios.cameraview.video.encoding.MediaEncoder) it.next()).getEncodedBitRate();
            }
            long j2 = (j / (i2 / 8)) * 1000 * 1000;
            long j3 = i * 1000;
            if (j > 0 && i > 0) {
                this.k = j2 < j3 ? 2 : 1;
                j2 = java.lang.Math.min(j2, j3);
            } else if (j > 0) {
                this.k = 2;
            } else if (i > 0) {
                this.k = 1;
                j2 = j3;
            } else {
                j2 = Long.MAX_VALUE;
            }
            l.w("Computed a max duration of", java.lang.Float.valueOf(j2 / 1000000.0f));
            java.util.Iterator<com.otaliastudios.cameraview.video.encoding.MediaEncoder> it2 = this.a.iterator();
            while (it2.hasNext()) {
                it2.next().g(this.f, j2);
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static /* synthetic */ int c(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine) {
        int i = mediaEncoderEngine.d + 1;
        mediaEncoderEngine.d = i;
        return i;
    }

    public static /* synthetic */ int h(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine) {
        int i = mediaEncoderEngine.c + 1;
        mediaEncoderEngine.c = i;
        return i;
    }

    public static /* synthetic */ int i(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine mediaEncoderEngine) {
        int i = mediaEncoderEngine.c - 1;
        mediaEncoderEngine.c = i;
        return i;
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder getAudioEncoder() {
        if (this.a.size() > 1) {
            return (com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder) this.a.get(1);
        }
        return null;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder getVideoEncoder() {
        return (com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder) this.a.get(0);
    }

    public final void notify(java.lang.String str, java.lang.Object obj) {
        l.v("Passing event to encoders:", str);
        java.util.Iterator<com.otaliastudios.cameraview.video.encoding.MediaEncoder> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(str, obj);
        }
    }

    public final void o() {
        l.i("end:", "Releasing muxer after all encoders have been released.");
        android.media.MediaMuxer mediaMuxer = this.b;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                e = null;
            } catch (java.lang.Exception e) {
                e = e;
            }
            try {
                this.b.release();
            } catch (java.lang.Exception e2) {
                if (e == null) {
                    e = e2;
                }
            }
            this.b = null;
        } else {
            e = null;
        }
        com.otaliastudios.cameraview.CameraLogger cameraLogger = l;
        cameraLogger.w("end:", "Dispatching end to listener - reason:", java.lang.Integer.valueOf(this.j), "error:", e);
        com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener listener = this.i;
        if (listener != null) {
            listener.onEncodingEnd(this.j, e);
            this.i = null;
        }
        this.j = 0;
        this.c = 0;
        this.d = 0;
        this.e = false;
        this.g.destroy();
        cameraLogger.i("end:", "Completed.");
    }

    public final void start() {
        l.i("Passing event to encoders:", "START");
        java.util.Iterator<com.otaliastudios.cameraview.video.encoding.MediaEncoder> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public final void stop() {
        l.i("Passing event to encoders:", "STOP");
        java.util.Iterator<com.otaliastudios.cameraview.video.encoding.MediaEncoder> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Listener listener = this.i;
        if (listener != null) {
            listener.onEncodingStop();
        }
    }
}

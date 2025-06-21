package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public class VideoResult {
    public static final int REASON_MAX_DURATION_REACHED = 2;
    public static final int REASON_MAX_SIZE_REACHED = 1;
    public static final int REASON_USER = 0;
    public final boolean a;
    public final android.location.Location b;
    public final int c;
    public final com.otaliastudios.cameraview.size.Size d;
    public final java.io.File e;
    public final java.io.FileDescriptor f;
    public final com.otaliastudios.cameraview.controls.Facing g;
    public final com.otaliastudios.cameraview.controls.VideoCodec h;
    public final com.otaliastudios.cameraview.controls.AudioCodec i;
    public final com.otaliastudios.cameraview.controls.Audio j;
    public final long k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;

    public static class Stub {
        public com.otaliastudios.cameraview.controls.Audio audio;
        public int audioBitRate;
        public com.otaliastudios.cameraview.controls.AudioCodec audioCodec;
        public int endReason;
        public com.otaliastudios.cameraview.controls.Facing facing;
        public java.io.File file;
        public java.io.FileDescriptor fileDescriptor;
        public boolean isSnapshot;
        public android.location.Location location;
        public int maxDuration;
        public long maxSize;
        public int rotation;
        public com.otaliastudios.cameraview.size.Size size;
        public int videoBitRate;
        public com.otaliastudios.cameraview.controls.VideoCodec videoCodec;
        public int videoFrameRate;
    }

    public VideoResult(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        this.a = stub.isSnapshot;
        this.b = stub.location;
        this.c = stub.rotation;
        this.d = stub.size;
        this.e = stub.file;
        this.f = stub.fileDescriptor;
        this.g = stub.facing;
        this.h = stub.videoCodec;
        this.i = stub.audioCodec;
        this.j = stub.audio;
        this.k = stub.maxSize;
        this.l = stub.maxDuration;
        this.m = stub.endReason;
        this.n = stub.videoBitRate;
        this.o = stub.videoFrameRate;
        this.p = stub.audioBitRate;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Audio getAudio() {
        return this.j;
    }

    public int getAudioBitRate() {
        return this.p;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.AudioCodec getAudioCodec() {
        return this.i;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Facing getFacing() {
        return this.g;
    }

    @androidx.annotation.NonNull
    public java.io.File getFile() {
        java.io.File file = this.e;
        if (file != null) {
            return file;
        }
        throw new java.lang.RuntimeException("File is only available when takeVideo(File) is used.");
    }

    @androidx.annotation.NonNull
    public java.io.FileDescriptor getFileDescriptor() {
        java.io.FileDescriptor fileDescriptor = this.f;
        if (fileDescriptor != null) {
            return fileDescriptor;
        }
        throw new java.lang.RuntimeException("FileDescriptor is only available when takeVideo(FileDescriptor) is used.");
    }

    @androidx.annotation.Nullable
    public android.location.Location getLocation() {
        return this.b;
    }

    public int getMaxDuration() {
        return this.l;
    }

    public long getMaxSize() {
        return this.k;
    }

    public int getRotation() {
        return this.c;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.size.Size getSize() {
        return this.d;
    }

    public int getTerminationReason() {
        return this.m;
    }

    public int getVideoBitRate() {
        return this.n;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.VideoCodec getVideoCodec() {
        return this.h;
    }

    public int getVideoFrameRate() {
        return this.o;
    }

    public boolean isSnapshot() {
        return this.a;
    }
}

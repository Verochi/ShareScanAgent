package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public class PictureResult {
    public final boolean a;
    public final android.location.Location b;
    public final int c;
    public final com.otaliastudios.cameraview.size.Size d;
    public final com.otaliastudios.cameraview.controls.Facing e;
    public final byte[] f;
    public final com.otaliastudios.cameraview.controls.PictureFormat g;

    public static class Stub {
        public byte[] data;
        public com.otaliastudios.cameraview.controls.Facing facing;
        public com.otaliastudios.cameraview.controls.PictureFormat format;
        public boolean isSnapshot;
        public android.location.Location location;
        public int rotation;
        public com.otaliastudios.cameraview.size.Size size;
    }

    public PictureResult(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub) {
        this.a = stub.isSnapshot;
        this.b = stub.location;
        this.c = stub.rotation;
        this.d = stub.size;
        this.e = stub.facing;
        this.f = stub.data;
        this.g = stub.format;
    }

    @androidx.annotation.NonNull
    public byte[] getData() {
        return this.f;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Facing getFacing() {
        return this.e;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.PictureFormat getFormat() {
        return this.g;
    }

    @androidx.annotation.Nullable
    public android.location.Location getLocation() {
        return this.b;
    }

    public int getRotation() {
        return this.c;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.size.Size getSize() {
        return this.d;
    }

    public boolean isSnapshot() {
        return this.a;
    }

    public void toBitmap(int i, int i2, @androidx.annotation.NonNull com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
        com.otaliastudios.cameraview.controls.PictureFormat pictureFormat = this.g;
        if (pictureFormat == com.otaliastudios.cameraview.controls.PictureFormat.JPEG) {
            com.otaliastudios.cameraview.CameraUtils.d(getData(), i, i2, new android.graphics.BitmapFactory.Options(), this.c, bitmapCallback);
            return;
        }
        if (pictureFormat == com.otaliastudios.cameraview.controls.PictureFormat.DNG && android.os.Build.VERSION.SDK_INT >= 24) {
            com.otaliastudios.cameraview.CameraUtils.d(getData(), i, i2, new android.graphics.BitmapFactory.Options(), this.c, bitmapCallback);
            return;
        }
        throw new java.lang.UnsupportedOperationException("PictureResult.toBitmap() does not support this picture format: " + this.g);
    }

    public void toBitmap(@androidx.annotation.NonNull com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
        toBitmap(-1, -1, bitmapCallback);
    }

    public void toFile(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.otaliastudios.cameraview.FileCallback fileCallback) {
        com.otaliastudios.cameraview.CameraUtils.writeToFile(getData(), file, fileCallback);
    }
}

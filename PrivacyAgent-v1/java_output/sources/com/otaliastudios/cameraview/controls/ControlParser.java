package com.otaliastudios.cameraview.controls;

/* loaded from: classes19.dex */
public class ControlParser {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public ControlParser(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        this.a = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPreview, com.otaliastudios.cameraview.controls.Preview.DEFAULT.value());
        this.b = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFacing, com.otaliastudios.cameraview.controls.Facing.DEFAULT(context).value());
        this.c = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFlash, com.otaliastudios.cameraview.controls.Flash.DEFAULT.value());
        this.d = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGrid, com.otaliastudios.cameraview.controls.Grid.DEFAULT.value());
        this.e = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraWhiteBalance, com.otaliastudios.cameraview.controls.WhiteBalance.DEFAULT.value());
        this.f = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraMode, com.otaliastudios.cameraview.controls.Mode.DEFAULT.value());
        this.g = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraHdr, com.otaliastudios.cameraview.controls.Hdr.DEFAULT.value());
        this.h = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraAudio, com.otaliastudios.cameraview.controls.Audio.DEFAULT.value());
        this.i = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoCodec, com.otaliastudios.cameraview.controls.VideoCodec.DEFAULT.value());
        this.j = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraAudioCodec, com.otaliastudios.cameraview.controls.AudioCodec.DEFAULT.value());
        this.k = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraEngine, com.otaliastudios.cameraview.controls.Engine.DEFAULT.value());
        this.l = typedArray.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureFormat, com.otaliastudios.cameraview.controls.PictureFormat.DEFAULT.value());
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Audio getAudio() {
        return com.otaliastudios.cameraview.controls.Audio.fromValue(this.h);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.AudioCodec getAudioCodec() {
        return com.otaliastudios.cameraview.controls.AudioCodec.fromValue(this.j);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Engine getEngine() {
        return com.otaliastudios.cameraview.controls.Engine.fromValue(this.k);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Facing getFacing() {
        return com.otaliastudios.cameraview.controls.Facing.fromValue(this.b);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Flash getFlash() {
        return com.otaliastudios.cameraview.controls.Flash.fromValue(this.c);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Grid getGrid() {
        return com.otaliastudios.cameraview.controls.Grid.fromValue(this.d);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Hdr getHdr() {
        return com.otaliastudios.cameraview.controls.Hdr.fromValue(this.g);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Mode getMode() {
        return com.otaliastudios.cameraview.controls.Mode.fromValue(this.f);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.PictureFormat getPictureFormat() {
        return com.otaliastudios.cameraview.controls.PictureFormat.fromValue(this.l);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Preview getPreview() {
        return com.otaliastudios.cameraview.controls.Preview.fromValue(this.a);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.VideoCodec getVideoCodec() {
        return com.otaliastudios.cameraview.controls.VideoCodec.fromValue(this.i);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.WhiteBalance getWhiteBalance() {
        return com.otaliastudios.cameraview.controls.WhiteBalance.fromValue(this.e);
    }
}

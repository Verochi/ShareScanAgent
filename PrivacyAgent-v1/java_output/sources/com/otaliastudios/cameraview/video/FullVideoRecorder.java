package com.otaliastudios.cameraview.video;

/* loaded from: classes19.dex */
public abstract class FullVideoRecorder extends com.otaliastudios.cameraview.video.VideoRecorder {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.FullVideoRecorder.class.getSimpleName());
    public android.media.CamcorderProfile f;
    public boolean g;
    protected android.media.MediaRecorder mMediaRecorder;

    /* renamed from: com.otaliastudios.cameraview.video.FullVideoRecorder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.MediaRecorder.OnInfoListener {
        public AnonymousClass1() {
        }

        @Override // android.media.MediaRecorder.OnInfoListener
        public void onInfo(android.media.MediaRecorder mediaRecorder, int i, int i2) {
            boolean z;
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.video.FullVideoRecorder.LOG;
            cameraLogger.i("OnInfoListener:", "Received info", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), "Thread: ", java.lang.Thread.currentThread());
            switch (i) {
                case 800:
                    com.otaliastudios.cameraview.video.FullVideoRecorder.this.a.endReason = 2;
                    z = true;
                    break;
                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                case 802:
                    com.otaliastudios.cameraview.video.FullVideoRecorder.this.a.endReason = 1;
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                cameraLogger.i("OnInfoListener:", "Stopping");
                com.otaliastudios.cameraview.video.FullVideoRecorder.this.stop(false);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.video.FullVideoRecorder$2, reason: invalid class name */
    public class AnonymousClass2 implements android.media.MediaRecorder.OnErrorListener {
        public AnonymousClass2() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(android.media.MediaRecorder mediaRecorder, int i, int i2) {
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.video.FullVideoRecorder.LOG;
            cameraLogger.e("OnErrorListener: got error", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), ". Stopping.");
            com.otaliastudios.cameraview.video.FullVideoRecorder fullVideoRecorder = com.otaliastudios.cameraview.video.FullVideoRecorder.this;
            fullVideoRecorder.a = null;
            fullVideoRecorder.mError = new java.lang.RuntimeException("MediaRecorder error: " + i + " " + i2);
            cameraLogger.i("OnErrorListener:", "Stopping");
            com.otaliastudios.cameraview.video.FullVideoRecorder.this.stop(false);
        }
    }

    public FullVideoRecorder(@androidx.annotation.Nullable com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener videoResultListener) {
        super(videoResultListener);
    }

    public final boolean a(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, boolean z) {
        java.lang.String str;
        char c = 2;
        LOG.i("prepareMediaRecorder:", "Preparing on thread", java.lang.Thread.currentThread());
        this.mMediaRecorder = new android.media.MediaRecorder();
        this.f = getCamcorderProfile(stub);
        applyVideoSource(stub, this.mMediaRecorder);
        com.otaliastudios.cameraview.controls.Audio audio = stub.audio;
        int i = audio == com.otaliastudios.cameraview.controls.Audio.ON ? this.f.audioChannels : audio == com.otaliastudios.cameraview.controls.Audio.MONO ? 1 : audio == com.otaliastudios.cameraview.controls.Audio.STEREO ? 2 : 0;
        boolean z2 = i > 0;
        if (z2) {
            this.mMediaRecorder.setAudioSource(0);
        }
        com.otaliastudios.cameraview.controls.VideoCodec videoCodec = stub.videoCodec;
        if (videoCodec == com.otaliastudios.cameraview.controls.VideoCodec.H_264) {
            android.media.CamcorderProfile camcorderProfile = this.f;
            camcorderProfile.videoCodec = 2;
            camcorderProfile.fileFormat = 2;
        } else if (videoCodec == com.otaliastudios.cameraview.controls.VideoCodec.H_263) {
            android.media.CamcorderProfile camcorderProfile2 = this.f;
            camcorderProfile2.videoCodec = 1;
            camcorderProfile2.fileFormat = 2;
        }
        com.otaliastudios.cameraview.controls.AudioCodec audioCodec = stub.audioCodec;
        char c2 = 4;
        if (audioCodec == com.otaliastudios.cameraview.controls.AudioCodec.AAC) {
            this.f.audioCodec = 3;
        } else if (audioCodec == com.otaliastudios.cameraview.controls.AudioCodec.HE_AAC) {
            this.f.audioCodec = 4;
        } else if (audioCodec == com.otaliastudios.cameraview.controls.AudioCodec.AAC_ELD) {
            this.f.audioCodec = 5;
        }
        this.mMediaRecorder.setOutputFormat(this.f.fileFormat);
        if (stub.videoFrameRate <= 0) {
            stub.videoFrameRate = this.f.videoFrameRate;
        }
        if (stub.videoBitRate <= 0) {
            stub.videoBitRate = this.f.videoBitRate;
        }
        if (stub.audioBitRate <= 0 && z2) {
            stub.audioBitRate = this.f.audioBitRate;
        }
        if (z) {
            android.media.CamcorderProfile camcorderProfile3 = this.f;
            java.lang.String str2 = "audio/3gpp";
            switch (camcorderProfile3.audioCodec) {
                case 2:
                    str2 = "audio/amr-wb";
                    break;
                case 3:
                case 4:
                case 5:
                    str2 = "audio/mp4a-latm";
                    break;
                case 6:
                    str2 = "audio/vorbis";
                    break;
            }
            int i2 = camcorderProfile3.videoCodec;
            if (i2 != 1) {
                str = "video/avc";
                if (i2 != 2) {
                    if (i2 == 3) {
                        str = "video/mp4v-es";
                    } else if (i2 == 4) {
                        str = "video/x-vnd.on2.vp8";
                    } else if (i2 == 5) {
                        str = "video/hevc";
                    }
                }
            } else {
                str = "video/3gpp";
            }
            boolean z3 = stub.rotation % 180 != 0;
            if (z3) {
                stub.size = stub.size.flip();
            }
            int i3 = 0;
            com.otaliastudios.cameraview.size.Size size = null;
            boolean z4 = false;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (!z4) {
                com.otaliastudios.cameraview.CameraLogger cameraLogger = LOG;
                java.lang.Object[] objArr = new java.lang.Object[6];
                objArr[0] = "prepareMediaRecorder:";
                objArr[1] = "Checking DeviceEncoders...";
                objArr[c] = "videoOffset:";
                objArr[3] = java.lang.Integer.valueOf(i6);
                objArr[c2] = "audioOffset:";
                objArr[5] = java.lang.Integer.valueOf(i7);
                cameraLogger.i(objArr);
                try {
                    com.otaliastudios.cameraview.size.Size size2 = size;
                    com.otaliastudios.cameraview.internal.DeviceEncoders deviceEncoders = new com.otaliastudios.cameraview.internal.DeviceEncoders(0, str, str2, i6, i7);
                    try {
                        size = deviceEncoders.getSupportedVideoSize(stub.size);
                        try {
                            i3 = deviceEncoders.getSupportedVideoBitRate(stub.videoBitRate);
                            int supportedVideoFrameRate = deviceEncoders.getSupportedVideoFrameRate(size, stub.videoFrameRate);
                            try {
                                deviceEncoders.tryConfigureVideo(str, size, supportedVideoFrameRate, i3);
                                if (z2) {
                                    int supportedAudioBitRate = deviceEncoders.getSupportedAudioBitRate(stub.audioBitRate);
                                    try {
                                        deviceEncoders.tryConfigureAudio(str2, supportedAudioBitRate, this.f.audioSampleRate, i);
                                        i4 = supportedAudioBitRate;
                                    } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e) {
                                        e = e;
                                        i5 = supportedVideoFrameRate;
                                        i4 = supportedAudioBitRate;
                                        LOG.i("prepareMediaRecorder:", "Got AudioException:", e.getMessage());
                                        i7++;
                                        c = 2;
                                        c2 = 4;
                                    } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e2) {
                                        e = e2;
                                        i5 = supportedVideoFrameRate;
                                        i4 = supportedAudioBitRate;
                                        LOG.i("prepareMediaRecorder:", "Got VideoException:", e.getMessage());
                                        i6++;
                                        c = 2;
                                        c2 = 4;
                                    }
                                }
                                i5 = supportedVideoFrameRate;
                                z4 = true;
                            } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e3) {
                                e = e3;
                                i5 = supportedVideoFrameRate;
                            } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e4) {
                                e = e4;
                                i5 = supportedVideoFrameRate;
                            }
                        } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e5) {
                            e = e5;
                        } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e6) {
                            e = e6;
                        }
                    } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException e7) {
                        e = e7;
                        size = size2;
                    } catch (com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException e8) {
                        e = e8;
                        size = size2;
                    }
                    c = 2;
                    c2 = 4;
                } catch (java.lang.RuntimeException unused) {
                    LOG.w("prepareMediaRecorder:", "Could not respect encoders parameters.", "Trying again without checking encoders.");
                    return a(stub, false);
                }
            }
            com.otaliastudios.cameraview.size.Size size3 = size;
            stub.size = size3;
            stub.videoBitRate = i3;
            stub.audioBitRate = i4;
            stub.videoFrameRate = i5;
            if (z3) {
                stub.size = size3.flip();
            }
        }
        boolean z5 = stub.rotation % 180 != 0;
        this.mMediaRecorder.setVideoSize(z5 ? stub.size.getHeight() : stub.size.getWidth(), z5 ? stub.size.getWidth() : stub.size.getHeight());
        this.mMediaRecorder.setVideoFrameRate(stub.videoFrameRate);
        this.mMediaRecorder.setVideoEncoder(this.f.videoCodec);
        this.mMediaRecorder.setVideoEncodingBitRate(stub.videoBitRate);
        if (z2) {
            this.mMediaRecorder.setAudioChannels(i);
            this.mMediaRecorder.setAudioSamplingRate(this.f.audioSampleRate);
            this.mMediaRecorder.setAudioEncoder(this.f.audioCodec);
            this.mMediaRecorder.setAudioEncodingBitRate(stub.audioBitRate);
        }
        android.location.Location location = stub.location;
        if (location != null) {
            this.mMediaRecorder.setLocation((float) location.getLatitude(), (float) stub.location.getLongitude());
        }
        java.io.File file = stub.file;
        if (file != null) {
            this.mMediaRecorder.setOutputFile(file.getAbsolutePath());
        } else {
            java.io.FileDescriptor fileDescriptor = stub.fileDescriptor;
            if (fileDescriptor == null) {
                throw new java.lang.IllegalStateException("file and fileDescriptor are both null.");
            }
            this.mMediaRecorder.setOutputFile(fileDescriptor);
        }
        this.mMediaRecorder.setOrientationHint(stub.rotation);
        android.media.MediaRecorder mediaRecorder = this.mMediaRecorder;
        long j = stub.maxSize;
        if (j > 0) {
            j = java.lang.Math.round(j / 0.9d);
        }
        mediaRecorder.setMaxFileSize(j);
        LOG.i("prepareMediaRecorder:", "Increased max size from", java.lang.Long.valueOf(stub.maxSize), com.huawei.hms.push.constant.RemoteMessageConst.TO, java.lang.Long.valueOf(java.lang.Math.round(stub.maxSize / 0.9d)));
        this.mMediaRecorder.setMaxDuration(stub.maxDuration);
        this.mMediaRecorder.setOnInfoListener(new com.otaliastudios.cameraview.video.FullVideoRecorder.AnonymousClass1());
        this.mMediaRecorder.setOnErrorListener(new com.otaliastudios.cameraview.video.FullVideoRecorder.AnonymousClass2());
        try {
            this.mMediaRecorder.prepare();
            this.g = true;
            this.mError = null;
            return true;
        } catch (java.lang.Exception e9) {
            LOG.w("prepareMediaRecorder:", "Error while preparing media recorder.", e9);
            this.g = false;
            this.mError = e9;
            return false;
        }
    }

    public abstract void applyVideoSource(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull android.media.MediaRecorder mediaRecorder);

    @androidx.annotation.NonNull
    public abstract android.media.CamcorderProfile getCamcorderProfile(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub);

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStart() {
        if (!prepareMediaRecorder(this.a)) {
            this.a = null;
            stop(false);
            return;
        }
        try {
            this.mMediaRecorder.start();
            dispatchVideoRecordingStart();
        } catch (java.lang.Exception e) {
            LOG.w("start:", "Error while starting media recorder.", e);
            this.a = null;
            this.mError = e;
            stop(false);
        }
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public void onStop(boolean z) {
        if (this.mMediaRecorder != null) {
            dispatchVideoRecordingEnd();
            try {
                com.otaliastudios.cameraview.CameraLogger cameraLogger = LOG;
                cameraLogger.i("stop:", "Stopping MediaRecorder...");
                this.mMediaRecorder.stop();
                cameraLogger.i("stop:", "Stopped MediaRecorder.");
            } catch (java.lang.Exception e) {
                this.a = null;
                if (this.mError == null) {
                    LOG.w("stop:", "Error while closing media recorder.", e);
                    this.mError = e;
                }
            }
            try {
                com.otaliastudios.cameraview.CameraLogger cameraLogger2 = LOG;
                cameraLogger2.i("stop:", "Releasing MediaRecorder...");
                this.mMediaRecorder.release();
                cameraLogger2.i("stop:", "Released MediaRecorder.");
            } catch (java.lang.Exception e2) {
                this.a = null;
                if (this.mError == null) {
                    LOG.w("stop:", "Error while releasing media recorder.", e2);
                    this.mError = e2;
                }
            }
        }
        this.f = null;
        this.mMediaRecorder = null;
        this.g = false;
        dispatchResult();
    }

    public final boolean prepareMediaRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        if (this.g) {
            return true;
        }
        return a(stub, true);
    }
}

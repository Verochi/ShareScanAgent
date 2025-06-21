package com.aliyun.svideosdk.player.impl;

/* loaded from: classes12.dex */
class AliyunSVideoPlayer extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader implements com.aliyun.svideosdk.player.AliyunISVideoPlayer {
    private static final java.lang.String TAG = "com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer";
    private boolean mIsInited;
    private com.aliyun.common.log.reporter.AlivcPlayerReporter mReporter;
    private final java.lang.String mPlayerTrackID = com.aliyun.common.log.util.UUIDGenerator.generateUUID();
    private com.aliyun.svideosdk.editor.NativeEditor mEditor = new com.aliyun.svideosdk.editor.NativeEditor();
    private com.aliyun.svideosdk.player.PlayerCallback mCallback = null;
    private com.aliyun.svideosdk.transcode.NativeParser mParser = new com.aliyun.svideosdk.transcode.NativeParser();
    private com.aliyun.svideosdk.editor.EditorCallBack mEditorCallback = new com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer.AnonymousClass1();

    /* renamed from: com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer$1, reason: invalid class name */
    public class AnonymousClass1 extends com.aliyun.svideosdk.editor.EditorCallBack {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3) {
            return 0;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            if (com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer.this.mCallback != null) {
                com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer.this.mCallback.onPlayComplete();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
            if (com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer.this.mCallback != null) {
                com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer.this.mCallback.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3) {
            return 0;
        }
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int draw(long j) {
        return this.mEditor.draw(j * 1000);
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public long getCurrentPosition() {
        return this.mEditor.getPlayTime();
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int init(android.content.Context context) {
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = new com.aliyun.common.log.reporter.AlivcPlayerReporter(context, this.mPlayerTrackID);
        this.mReporter = alivcPlayerReporter;
        int init = this.mEditor.init(1, 1, 0, alivcPlayerReporter.getReportId(), this.mEditorCallback);
        if (init == 0) {
            this.mIsInited = true;
        }
        this.mReporter.sendInitEvent();
        return init;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int pause() {
        int pause = this.mEditor.pause();
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendPauseEvent();
        }
        return pause;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int play() {
        if (!this.mEditor.isNativePrepared()) {
            this.mEditor.prepare();
        }
        int start = this.mEditor.start();
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendPlayEvent();
        }
        return start;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public void release() {
        this.mEditor.release();
        this.mEditor.dispose();
        this.mParser.dispose();
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendReleaseEvent();
            this.mReporter.release();
        }
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int resume() {
        int resume = this.mEditor.resume();
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendResumeEvent();
        }
        return resume;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int seek(long j) {
        return this.mEditor.seek(j * 1000);
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int setDisplay(android.view.Surface surface) {
        if (!this.mIsInited) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e(TAG, "Editor not initialized!");
            return -4;
        }
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendSetDisplayEvent();
        }
        int display = (surface == null || !surface.isValid()) ? 0 : this.mEditor.setDisplay(surface);
        if (display == 0) {
            int mode = this.mEditor.setMode(com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY);
            this.mEditor.setDisplayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE.getDisplayMode());
            return mode;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e(TAG, "set surface failed! ret is" + display);
        return display;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int setDisplaySize(int i, int i2) {
        int displaySize = this.mEditor.setDisplaySize(i, i2);
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendSetDisplaySizeEvent(i, i2);
        }
        return displaySize;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public void setPlayerCallback(com.aliyun.svideosdk.player.PlayerCallback playerCallback) {
        this.mCallback = playerCallback;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int setSource(java.lang.String str) {
        int i;
        if (str != null && !str.isEmpty()) {
            this.mParser.init(str);
            try {
                long parseLong = java.lang.Long.parseLong(this.mParser.getValue(3));
                int parseInt = java.lang.Integer.parseInt(this.mParser.getValue(6));
                int parseInt2 = java.lang.Integer.parseInt(this.mParser.getValue(7));
                int parseInt3 = java.lang.Integer.parseInt(this.mParser.getValue(14));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    i = parseInt2;
                } else {
                    i = parseInt;
                    parseInt = parseInt2;
                }
                com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
                if (alivcPlayerReporter != null) {
                    alivcPlayerReporter.sendSetSourceEvent(str);
                }
                this.mEditor.addVideoElement(str, 0L, parseLong, new com.aliyun.svideosdk.common.struct.effect.TransitionBase(), i, parseInt, 1.0f, 0.0f);
                this.mParser.release();
                int prepare = this.mEditor.prepare();
                this.mEditor.draw(0L);
                com.aliyun.svideosdk.player.PlayerCallback playerCallback = this.mCallback;
                if (playerCallback != null) {
                    playerCallback.onDataSize(i, parseInt);
                }
                return prepare;
            } catch (java.lang.Exception unused) {
            }
        }
        return -20011015;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int stop() {
        int stop = this.mEditor.stop();
        com.aliyun.common.log.reporter.AlivcPlayerReporter alivcPlayerReporter = this.mReporter;
        if (alivcPlayerReporter != null) {
            alivcPlayerReporter.sendStopEvent();
        }
        return stop;
    }
}

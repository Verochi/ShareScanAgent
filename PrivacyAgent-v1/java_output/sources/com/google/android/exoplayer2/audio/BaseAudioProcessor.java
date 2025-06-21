package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public abstract class BaseAudioProcessor implements com.google.android.exoplayer2.audio.AudioProcessor {
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat a;
    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat b;
    public java.nio.ByteBuffer c;
    public java.nio.ByteBuffer d;
    public boolean e;
    protected com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat inputAudioFormat;
    protected com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat outputAudioFormat;

    public BaseAudioProcessor() {
        java.nio.ByteBuffer byteBuffer = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        this.c = byteBuffer;
        this.d = byteBuffer;
        com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        this.a = audioFormat;
        this.b = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat configure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        this.a = audioFormat;
        this.b = onConfigure(audioFormat);
        return isActive() ? this.b : com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.d = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        this.e = false;
        this.inputAudioFormat = this.a;
        this.outputAudioFormat = this.b;
        onFlush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @androidx.annotation.CallSuper
    public java.nio.ByteBuffer getOutput() {
        java.nio.ByteBuffer byteBuffer = this.d;
        this.d = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    public final boolean hasPendingOutput() {
        return this.d.hasRemaining();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.b != com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @androidx.annotation.CallSuper
    public boolean isEnded() {
        return this.e && this.d == com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
    }

    public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) throws com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException {
        return com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
    }

    public void onFlush() {
    }

    public void onQueueEndOfStream() {
    }

    public void onReset() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.e = true;
        onQueueEndOfStream();
    }

    public final java.nio.ByteBuffer replaceOutputBuffer(int i) {
        if (this.c.capacity() < i) {
            this.c = java.nio.ByteBuffer.allocateDirect(i).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.c.clear();
        }
        java.nio.ByteBuffer byteBuffer = this.c;
        this.d = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.c = com.google.android.exoplayer2.audio.AudioProcessor.EMPTY_BUFFER;
        com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat = com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
        this.a = audioFormat;
        this.b = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
        onReset();
    }
}

package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class OutputStub implements com.ss.android.socialbase.downloader.segment.IOutput {
    private final com.ss.android.socialbase.downloader.segment.IOutput output;
    private final com.ss.android.socialbase.downloader.segment.IOutput target;

    public OutputStub(com.ss.android.socialbase.downloader.segment.IOutput iOutput, com.ss.android.socialbase.downloader.segment.IOutput iOutput2) {
        this.output = iOutput;
        this.target = iOutput2;
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.segment.Buffer buffer) throws java.io.IOException {
        buffer.output = this.target;
        this.output.write(buffer);
    }
}

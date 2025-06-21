package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class SegmentOutput implements com.ss.android.socialbase.downloader.segment.IOutput {
    private final com.ss.android.socialbase.downloader.model.RandomAccessOutputStream output;
    private final com.ss.android.socialbase.downloader.segment.Segment segment;
    private final com.ss.android.socialbase.downloader.segment.IOutput stub;

    public SegmentOutput(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.segment.BufferQueue bufferQueue, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException {
        this.segment = segment;
        this.output = createOutStream(downloadInfo, segment);
        this.stub = new com.ss.android.socialbase.downloader.segment.OutputStub(bufferQueue, this);
    }

    private com.ss.android.socialbase.downloader.model.RandomAccessOutputStream createOutStream(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException {
        com.ss.android.socialbase.downloader.model.RandomAccessOutputStream createOutputStream = com.ss.android.socialbase.downloader.utils.DownloadUtils.createOutputStream(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.FLUSH_BUFFER_SIZE_BYTE, -1));
        try {
            createOutputStream.seek(segment.getCurrentOffsetRead());
            return createOutputStream;
        } catch (java.io.IOException e) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_RANDOM_ACCESS_SEEK_IO, e);
        }
    }

    public void close() {
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(this.output);
    }

    public void flush() throws java.io.IOException {
        this.output.flush();
    }

    public com.ss.android.socialbase.downloader.segment.Segment getSegment() {
        return this.segment;
    }

    public com.ss.android.socialbase.downloader.segment.IOutput getStub() {
        return this.stub;
    }

    public void sync() throws java.io.IOException {
        this.output.sync();
    }

    @Override // com.ss.android.socialbase.downloader.segment.IOutput
    public void write(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.segment.Buffer buffer) throws java.io.IOException {
        this.output.write(buffer.data, 0, buffer.size);
        this.segment.increaseCurrentOffset(buffer.size);
    }
}

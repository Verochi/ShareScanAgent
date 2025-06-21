package com.aliyun.svideosdk.transcode;

/* loaded from: classes12.dex */
public class NativeTranscode2InitStruct {
    public java.lang.String intputPath;
    public java.lang.String outputPath;
    public com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback cb = null;
    public long reportId = -1;
    public long logId = -1;
    public boolean needAudio = true;
    public boolean needVideo = true;
    public long startTime = 0;
    public long endTime = 0;
    public int cropMode = 1;
    public int cropX = 0;
    public int cropY = 0;
    public int cropWidth = 0;
    public int cropHeight = 0;
    public int cropBackColor = 0;
    public int outputWidth = 0;
    public int outputHeight = 0;
    public boolean useHWEncoder = true;
    public boolean useHWDecoder = true;
}

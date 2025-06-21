package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class p33 {
    public static int a(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) throws java.io.IOException {
        return trackOutput.sampleData(dataReader, i, z, 0);
    }

    public static void b(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        trackOutput.sampleData(parsableByteArray, i, 0);
    }
}

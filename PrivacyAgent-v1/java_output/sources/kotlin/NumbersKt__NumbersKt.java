package kotlin;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0006"}, d2 = {"", "", "bitCount", "rotateLeft", "rotateRight", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/NumbersKt")
/* loaded from: classes14.dex */
class NumbersKt__NumbersKt extends kotlin.NumbersKt__NumbersJVMKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final byte rotateLeft(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> (8 - i2)) | (b << i2));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final short rotateLeft(short s2, int i) {
        int i2 = i & 15;
        return (short) (((s2 & 65535) >>> (16 - i2)) | (s2 << i2));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final byte rotateRight(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> i2) | (b << (8 - i2)));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final short rotateRight(short s2, int i) {
        int i2 = i & 15;
        return (short) (((s2 & 65535) >>> i2) | (s2 << (16 - i2)));
    }
}

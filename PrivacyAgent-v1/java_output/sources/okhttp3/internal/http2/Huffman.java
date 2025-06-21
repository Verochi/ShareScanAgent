package okhttp3.internal.http2;

/* loaded from: classes24.dex */
class Huffman {
    public static final int[] b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, com.getui.gtc.extension.distribution.gbd.d.g.aH, 115, com.igexin.push.config.c.E, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    public static final byte[] c = {13, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.FS, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.DC4, 19, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, 19, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.EM, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.SUB};
    public static final okhttp3.internal.http2.Huffman d = new okhttp3.internal.http2.Huffman();
    public final okhttp3.internal.http2.Huffman.Node a = new okhttp3.internal.http2.Huffman.Node();

    public static final class Node {
        public final okhttp3.internal.http2.Huffman.Node[] a;
        public final int b;
        public final int c;

        public Node() {
            this.a = new okhttp3.internal.http2.Huffman.Node[256];
            this.b = 0;
            this.c = 0;
        }

        public Node(int i, int i2) {
            this.a = null;
            this.b = i;
            int i3 = i2 & 7;
            this.c = i3 == 0 ? 8 : i3;
        }
    }

    public Huffman() {
        b();
    }

    public static okhttp3.internal.http2.Huffman f() {
        return d;
    }

    public final void a(int i, int i2, byte b2) {
        okhttp3.internal.http2.Huffman.Node node = new okhttp3.internal.http2.Huffman.Node(i, b2);
        okhttp3.internal.http2.Huffman.Node node2 = this.a;
        while (b2 > 8) {
            b2 = (byte) (b2 - 8);
            int i3 = (i2 >>> b2) & 255;
            okhttp3.internal.http2.Huffman.Node[] nodeArr = node2.a;
            if (nodeArr == null) {
                throw new java.lang.IllegalStateException("invalid dictionary: prefix not unique");
            }
            if (nodeArr[i3] == null) {
                nodeArr[i3] = new okhttp3.internal.http2.Huffman.Node();
            }
            node2 = node2.a[i3];
        }
        int i4 = 8 - b2;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            node2.a[i7] = node;
        }
    }

    public final void b() {
        int i = 0;
        while (true) {
            byte[] bArr = c;
            if (i >= bArr.length) {
                return;
            }
            a(i, b[i], bArr[i]);
            i++;
        }
    }

    public byte[] c(byte[] bArr) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        okhttp3.internal.http2.Huffman.Node node = this.a;
        int i = 0;
        int i2 = 0;
        for (byte b2 : bArr) {
            i = (i << 8) | (b2 & 255);
            i2 += 8;
            while (i2 >= 8) {
                node = node.a[(i >>> (i2 - 8)) & 255];
                if (node.a == null) {
                    byteArrayOutputStream.write(node.b);
                    i2 -= node.c;
                    node = this.a;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            okhttp3.internal.http2.Huffman.Node node2 = node.a[(i << (8 - i2)) & 255];
            if (node2.a != null || node2.c > i2) {
                break;
            }
            byteArrayOutputStream.write(node2.b);
            i2 -= node2.c;
            node = this.a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void d(okio.ByteString byteString, okio.BufferedSink bufferedSink) throws java.io.IOException {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < byteString.size(); i2++) {
            int i3 = byteString.getByte(i2) & 255;
            int i4 = b[i3];
            byte b2 = c[i3];
            j = (j << b2) | i4;
            i += b2;
            while (i >= 8) {
                i -= 8;
                bufferedSink.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            bufferedSink.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public int e(okio.ByteString byteString) {
        long j = 0;
        for (int i = 0; i < byteString.size(); i++) {
            j += c[byteString.getByte(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }
}

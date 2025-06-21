package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class DataInput extends java.io.DataInputStream {
    public char[] n;

    public DataInput(java.io.InputStream inputStream) {
        super(inputStream);
        this.n = new char[32];
    }

    public final void a(int i, int i2, int i3) throws java.io.IOException {
        char[] cArr = this.n;
        while (true) {
            switch (i3 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    cArr[i2] = (char) i3;
                    break;
                case 12:
                case 13:
                    cArr[i2] = (char) (((i3 & 31) << 6) | (read() & 63));
                    break;
                case 14:
                    cArr[i2] = (char) (((i3 & 15) << 12) | ((read() & 63) << 6) | (read() & 63));
                    break;
            }
            i2++;
            if (i2 >= i) {
                return;
            } else {
                i3 = read() & 255;
            }
        }
    }

    public int readInt(boolean z) throws java.io.IOException {
        int read = read();
        int i = read & 127;
        if ((read & 128) != 0) {
            int read2 = read();
            i |= (read2 & 127) << 7;
            if ((read2 & 128) != 0) {
                int read3 = read();
                i |= (read3 & 127) << 14;
                if ((read3 & 128) != 0) {
                    int read4 = read();
                    i |= (read4 & 127) << 21;
                    if ((read4 & 128) != 0) {
                        i |= (read() & 127) << 28;
                    }
                }
            }
        }
        return z ? i : (i >>> 1) ^ (-(i & 1));
    }

    public java.lang.String readString() throws java.io.IOException {
        int readInt = readInt(true);
        if (readInt == 0) {
            return null;
        }
        if (readInt == 1) {
            return "";
        }
        int i = readInt - 1;
        if (this.n.length < i) {
            this.n = new char[i];
        }
        char[] cArr = this.n;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            i3 = read();
            if (i3 > 127) {
                break;
            }
            cArr[i2] = (char) i3;
            i2++;
        }
        if (i2 < i) {
            a(i, i2, i3);
        }
        return new java.lang.String(cArr, 0, i);
    }
}

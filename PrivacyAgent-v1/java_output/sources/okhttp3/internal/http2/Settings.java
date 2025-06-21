package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public final class Settings {
    public int a;
    public final int[] b = new int[10];

    public void a() {
        this.a = 0;
        java.util.Arrays.fill(this.b, 0);
    }

    public int b(int i) {
        return this.b[i];
    }

    public int c() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    public int d() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public int e(int i) {
        return (this.a & 16) != 0 ? this.b[4] : i;
    }

    public int f(int i) {
        return (this.a & 32) != 0 ? this.b[5] : i;
    }

    public boolean g(int i) {
        return ((1 << i) & this.a) != 0;
    }

    public void h(okhttp3.internal.http2.Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.g(i)) {
                i(i, settings.b(i));
            }
        }
    }

    public okhttp3.internal.http2.Settings i(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.a = (1 << i) | this.a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public int j() {
        return java.lang.Integer.bitCount(this.a);
    }
}

package com.tencent.open.log;

/* loaded from: classes19.dex */
public class f implements java.lang.Iterable<java.lang.String> {
    private java.util.concurrent.ConcurrentLinkedQueue<java.lang.String> a;
    private java.util.concurrent.atomic.AtomicInteger b;

    public f() {
        this.a = null;
        this.b = null;
        this.a = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.b = new java.util.concurrent.atomic.AtomicInteger(0);
    }

    public int a() {
        return this.b.get();
    }

    public int a(java.lang.String str) {
        int length = str.length();
        this.a.add(str);
        return this.b.addAndGet(length);
    }

    public void a(java.io.Writer[] writerArr, char[] cArr) throws java.io.IOException {
        if (writerArr == null || cArr == null || cArr.length == 0 || writerArr.length < 2) {
            return;
        }
        java.io.Writer writer = writerArr[0];
        java.io.Writer writer2 = writerArr[1];
        int length = cArr.length;
        java.util.Iterator<java.lang.String> it = iterator();
        int i = length;
        int i2 = 0;
        while (it.hasNext()) {
            java.lang.String next = it.next();
            int length2 = next.length();
            int i3 = 0;
            while (length2 > 0) {
                int i4 = i > length2 ? length2 : i;
                int i5 = i3 + i4;
                next.getChars(i3, i5, cArr, i2);
                i -= i4;
                i2 += i4;
                length2 -= i4;
                if (i == 0) {
                    if (writer != null) {
                        try {
                            writer.write(cArr, 0, length);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.write(cArr, 0, length);
                        } catch (java.lang.Exception unused2) {
                        }
                    }
                    i = length;
                    i3 = i5;
                    i2 = 0;
                } else {
                    i3 = i5;
                }
            }
        }
        if (i2 > 0) {
            if (writer != null) {
                try {
                    writer.write(cArr, 0, i2);
                } catch (java.lang.Exception unused3) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.write(cArr, 0, i2);
                } catch (java.lang.Exception unused4) {
                }
            }
        }
        if (writer != null) {
            try {
                writer.flush();
            } catch (java.lang.Exception unused5) {
            }
        }
        if (writer2 != null) {
            try {
                writer2.flush();
            } catch (java.lang.Exception unused6) {
            }
        }
    }

    public void b() {
        this.a.clear();
        this.b.set(0);
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<java.lang.String> iterator() {
        return this.a.iterator();
    }
}

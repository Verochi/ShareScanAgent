package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class l {
    public static void a(com.bytedance.pangle.res.a.g gVar) {
        gVar.b(0);
        int readInt = gVar.readInt();
        int readInt2 = gVar.readInt();
        int readInt3 = gVar.readInt();
        gVar.skipBytes(4);
        int readInt4 = gVar.readInt();
        int readInt5 = gVar.readInt();
        gVar.skipBytes(readInt2 * 4);
        if (readInt3 != 0) {
            gVar.skipBytes(readInt3 * 4);
        }
        gVar.skipBytes((readInt5 == 0 ? readInt : readInt5) - readInt4);
        if (readInt5 == 0) {
            return;
        }
        int i = readInt - readInt5;
        gVar.skipBytes(i);
        int i2 = i % 4;
        if (i2 <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            gVar.readByte();
            i2 = i3;
        }
    }
}

package com.aliyun.svideosdk.editor.impl.text;

/* loaded from: classes12.dex */
public class b extends com.aliyun.svideosdk.editor.impl.text.a {
    @Override // com.aliyun.svideosdk.editor.impl.text.a
    public android.text.StaticLayout c() {
        android.text.StaticLayout b;
        float f;
        int i = this.n;
        float f2 = i;
        float f3 = (f2 + 0.0f) / 2.0f;
        int i2 = this.o;
        if (i2 > 0) {
            return b(i2);
        }
        float f4 = f2;
        float f5 = f3;
        float f6 = 0.0f;
        while (true) {
            b = b(f5);
            if (f5 == f6) {
                break;
            }
            if (f5 == f4) {
                f5 = f6;
            } else {
                int height = b.getHeight();
                if (height >= i) {
                    if (height <= i) {
                        break;
                    }
                    f = (f6 + f5) / 2.0f;
                    f4 = f5;
                } else {
                    f = (f5 + f4) / 2.0f;
                    f6 = f5;
                }
                f5 = f;
            }
        }
        return b;
    }
}

package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class GradientColorParser implements com.airbnb.lottie.parser.ValueParser<com.airbnb.lottie.model.content.GradientColor> {
    public int a;

    public GradientColorParser(int i) {
        this.a = i;
    }

    public final void a(com.airbnb.lottie.model.content.GradientColor gradientColor, java.util.List<java.lang.Float> list) {
        int i = this.a * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < gradientColor.getSize(); i3++) {
            int i4 = gradientColor.getColors()[i3];
            gradientColor.getColors()[i3] = android.graphics.Color.argb(b(gradientColor.getPositions()[i3], dArr, dArr2), android.graphics.Color.red(i4), android.graphics.Color.green(i4), android.graphics.Color.blue(i4));
        }
    }

    @androidx.annotation.IntRange(from = 0, to = tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    public final int b(double d, double[] dArr, double[] dArr2) {
        double d2;
        int i = 1;
        while (true) {
            if (i >= dArr.length) {
                d2 = dArr2[dArr2.length - 1];
                break;
            }
            int i2 = i - 1;
            double d3 = dArr[i2];
            double d4 = dArr[i];
            if (d4 >= d) {
                d2 = com.airbnb.lottie.utils.MiscUtils.lerp(dArr2[i2], dArr2[i], com.airbnb.lottie.utils.MiscUtils.clamp((d - d3) / (d4 - d3), 0.0d, 1.0d));
                break;
            }
            i++;
        }
        return (int) (d2 * 255.0d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public com.airbnb.lottie.model.content.GradientColor parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z = jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(java.lang.Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i = this.a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = android.graphics.Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        com.airbnb.lottie.model.content.GradientColor gradientColor = new com.airbnb.lottie.model.content.GradientColor(fArr, iArr);
        a(gradientColor, arrayList);
        return gradientColor;
    }
}

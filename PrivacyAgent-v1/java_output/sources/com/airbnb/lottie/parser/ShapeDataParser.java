package com.airbnb.lottie.parser;

/* loaded from: classes.dex */
public class ShapeDataParser implements com.airbnb.lottie.parser.ValueParser<com.airbnb.lottie.model.content.ShapeData> {
    public static final com.airbnb.lottie.parser.ShapeDataParser INSTANCE = new com.airbnb.lottie.parser.ShapeDataParser();
    public static final com.airbnb.lottie.parser.moshi.JsonReader.Options a = com.airbnb.lottie.parser.moshi.JsonReader.Options.of("c", "v", "i", "o");

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public com.airbnb.lottie.model.content.ShapeData parse(com.airbnb.lottie.parser.moshi.JsonReader jsonReader, float f) throws java.io.IOException {
        if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        java.util.List<android.graphics.PointF> list = null;
        java.util.List<android.graphics.PointF> list2 = null;
        java.util.List<android.graphics.PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(a);
            if (selectName == 0) {
                z = jsonReader.nextBoolean();
            } else if (selectName == 1) {
                list = com.airbnb.lottie.parser.JsonUtils.f(jsonReader, f);
            } else if (selectName == 2) {
                list2 = com.airbnb.lottie.parser.JsonUtils.f(jsonReader, f);
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                list3 = com.airbnb.lottie.parser.JsonUtils.f(jsonReader, f);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == com.airbnb.lottie.parser.moshi.JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new java.lang.IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new com.airbnb.lottie.model.content.ShapeData(new android.graphics.PointF(), false, java.util.Collections.emptyList());
        }
        int size = list.size();
        android.graphics.PointF pointF = list.get(0);
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        for (int i = 1; i < size; i++) {
            android.graphics.PointF pointF2 = list.get(i);
            int i2 = i - 1;
            arrayList.add(new com.airbnb.lottie.model.CubicCurveData(com.airbnb.lottie.utils.MiscUtils.addPoints(list.get(i2), list3.get(i2)), com.airbnb.lottie.utils.MiscUtils.addPoints(pointF2, list2.get(i)), pointF2));
        }
        if (z) {
            android.graphics.PointF pointF3 = list.get(0);
            int i3 = size - 1;
            arrayList.add(new com.airbnb.lottie.model.CubicCurveData(com.airbnb.lottie.utils.MiscUtils.addPoints(list.get(i3), list3.get(i3)), com.airbnb.lottie.utils.MiscUtils.addPoints(pointF3, list2.get(0)), pointF3));
        }
        return new com.airbnb.lottie.model.content.ShapeData(pointF, z, arrayList);
    }
}

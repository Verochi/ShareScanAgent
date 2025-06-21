package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes22.dex */
final class TtmlNode {

    @androidx.annotation.Nullable
    public final java.lang.String a;

    @androidx.annotation.Nullable
    public final java.lang.String b;
    public final boolean c;
    public final long d;
    public final long e;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.text.ttml.TtmlStyle f;

    @androidx.annotation.Nullable
    public final java.lang.String[] g;
    public final java.lang.String h;

    @androidx.annotation.Nullable
    public final java.lang.String i;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.text.ttml.TtmlNode j;
    public final java.util.HashMap<java.lang.String, java.lang.Integer> k;
    public final java.util.HashMap<java.lang.String, java.lang.Integer> l;
    public java.util.List<com.google.android.exoplayer2.text.ttml.TtmlNode> m;

    public TtmlNode(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, long j, long j2, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, @androidx.annotation.Nullable java.lang.String[] strArr, java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode) {
        this.a = str;
        this.b = str2;
        this.i = str4;
        this.f = ttmlStyle;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        this.h = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str3);
        this.j = ttmlNode;
        this.k = new java.util.HashMap<>();
        this.l = new java.util.HashMap<>();
    }

    public static com.google.android.exoplayer2.text.ttml.TtmlNode c(@androidx.annotation.Nullable java.lang.String str, long j, long j2, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle, @androidx.annotation.Nullable java.lang.String[] strArr, java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode) {
        return new com.google.android.exoplayer2.text.ttml.TtmlNode(str, null, j, j2, ttmlStyle, strArr, str2, str3, ttmlNode);
    }

    public static com.google.android.exoplayer2.text.ttml.TtmlNode d(java.lang.String str) {
        return new com.google.android.exoplayer2.text.ttml.TtmlNode(null, com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static void e(android.text.SpannableStringBuilder spannableStringBuilder) {
        for (com.google.android.exoplayer2.text.ttml.DeleteTextSpan deleteTextSpan : (com.google.android.exoplayer2.text.ttml.DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.google.android.exoplayer2.text.ttml.DeleteTextSpan.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == '\n') {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    public static android.text.SpannableStringBuilder k(java.lang.String str, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.Cue.Builder> map) {
        if (!map.containsKey(str)) {
            com.google.android.exoplayer2.text.Cue.Builder builder = new com.google.android.exoplayer2.text.Cue.Builder();
            builder.setText(new android.text.SpannableStringBuilder());
            map.put(str, builder);
        }
        return (android.text.SpannableStringBuilder) com.google.android.exoplayer2.util.Assertions.checkNotNull(map.get(str).getText());
    }

    public void a(com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode) {
        if (this.m == null) {
            this.m = new java.util.ArrayList();
        }
        this.m.add(ttmlNode);
    }

    public final void b(java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, com.google.android.exoplayer2.text.Cue.Builder builder, int i, int i2) {
        com.google.android.exoplayer2.text.ttml.TtmlStyle f = com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.f(this.f, this.g, map);
        android.text.SpannableStringBuilder spannableStringBuilder = (android.text.SpannableStringBuilder) builder.getText();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new android.text.SpannableStringBuilder();
            builder.setText(spannableStringBuilder);
        }
        android.text.SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f != null) {
            com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.a(spannableStringBuilder2, i, i2, f, this.j, map);
            builder.setTextAlignment(f.k());
        }
    }

    public com.google.android.exoplayer2.text.ttml.TtmlNode f(int i) {
        java.util.List<com.google.android.exoplayer2.text.ttml.TtmlNode> list = this.m;
        if (list != null) {
            return list.get(i);
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    public int g() {
        java.util.List<com.google.android.exoplayer2.text.ttml.TtmlNode> list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public java.util.List<com.google.android.exoplayer2.text.Cue> h(long j, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map2, java.util.Map<java.lang.String, java.lang.String> map3) {
        java.util.List<android.util.Pair<java.lang.String, java.lang.String>> arrayList = new java.util.ArrayList<>();
        n(j, this.h, arrayList);
        java.util.TreeMap treeMap = new java.util.TreeMap();
        p(j, false, this.h, treeMap);
        o(j, map, treeMap);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (android.util.Pair<java.lang.String, java.lang.String> pair : arrayList) {
            java.lang.String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = android.util.Base64.decode(str, 0);
                android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(decode, 0, decode.length);
                com.google.android.exoplayer2.text.ttml.TtmlRegion ttmlRegion = (com.google.android.exoplayer2.text.ttml.TtmlRegion) com.google.android.exoplayer2.util.Assertions.checkNotNull(map2.get(pair.first));
                arrayList2.add(new com.google.android.exoplayer2.text.Cue.Builder().setBitmap(decodeByteArray).setPosition(ttmlRegion.b).setPositionAnchor(0).setLine(ttmlRegion.c, 0).setLineAnchor(ttmlRegion.e).setSize(ttmlRegion.f).setBitmapHeight(ttmlRegion.g).setVerticalType(ttmlRegion.j).build());
            }
        }
        for (java.util.Map.Entry entry : treeMap.entrySet()) {
            com.google.android.exoplayer2.text.ttml.TtmlRegion ttmlRegion2 = (com.google.android.exoplayer2.text.ttml.TtmlRegion) com.google.android.exoplayer2.util.Assertions.checkNotNull(map2.get(entry.getKey()));
            com.google.android.exoplayer2.text.Cue.Builder builder = (com.google.android.exoplayer2.text.Cue.Builder) entry.getValue();
            e((android.text.SpannableStringBuilder) com.google.android.exoplayer2.util.Assertions.checkNotNull(builder.getText()));
            builder.setLine(ttmlRegion2.c, ttmlRegion2.d);
            builder.setLineAnchor(ttmlRegion2.e);
            builder.setPosition(ttmlRegion2.b);
            builder.setSize(ttmlRegion2.f);
            builder.setTextSize(ttmlRegion2.i, ttmlRegion2.h);
            builder.setVerticalType(ttmlRegion2.j);
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    public final void i(java.util.TreeSet<java.lang.Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.a);
        boolean equals2 = "div".equals(this.a);
        if (z || equals || (equals2 && this.i != null)) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(java.lang.Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(java.lang.Long.valueOf(j2));
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            this.m.get(i).i(treeSet, z || equals);
        }
    }

    public long[] j() {
        java.util.TreeSet<java.lang.Long> treeSet = new java.util.TreeSet<>();
        int i = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        java.util.Iterator<java.lang.Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    @androidx.annotation.Nullable
    public java.lang.String[] l() {
        return this.g;
    }

    public boolean m(long j) {
        long j2 = this.d;
        return (j2 == -9223372036854775807L && this.e == -9223372036854775807L) || (j2 <= j && this.e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.e) || (j2 <= j && j < this.e));
    }

    public final void n(long j, java.lang.String str, java.util.List<android.util.Pair<java.lang.String, java.lang.String>> list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (m(j) && "div".equals(this.a) && this.i != null) {
            list.add(new android.util.Pair<>(str, this.i));
            return;
        }
        for (int i = 0; i < g(); i++) {
            f(i).n(j, str, list);
        }
    }

    public final void o(long j, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.Cue.Builder> map2) {
        int i;
        if (m(j)) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Integer>> it = this.l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.util.Map.Entry<java.lang.String, java.lang.Integer> next = it.next();
                java.lang.String key = next.getKey();
                i = this.k.containsKey(key) ? this.k.get(key).intValue() : 0;
                int intValue = next.getValue().intValue();
                if (i != intValue) {
                    b(map, (com.google.android.exoplayer2.text.Cue.Builder) com.google.android.exoplayer2.util.Assertions.checkNotNull(map2.get(key)), i, intValue);
                }
            }
            while (i < g()) {
                f(i).o(j, map, map2);
                i++;
            }
        }
    }

    public final void p(long j, boolean z, java.lang.String str, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.Cue.Builder> map) {
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
            return;
        }
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (this.c && z) {
            k(str, map).append((java.lang.CharSequence) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b));
            return;
        }
        if ("br".equals(this.a) && z) {
            k(str, map).append('\n');
            return;
        }
        if (m(j)) {
            for (java.util.Map.Entry<java.lang.String, com.google.android.exoplayer2.text.Cue.Builder> entry : map.entrySet()) {
                this.k.put(entry.getKey(), java.lang.Integer.valueOf(((java.lang.CharSequence) com.google.android.exoplayer2.util.Assertions.checkNotNull(entry.getValue().getText())).length()));
            }
            boolean equals = "p".equals(this.a);
            for (int i = 0; i < g(); i++) {
                f(i).p(j, z || equals, str, map);
            }
            if (equals) {
                com.google.android.exoplayer2.text.ttml.TtmlRenderUtil.c(k(str, map));
            }
            for (java.util.Map.Entry<java.lang.String, com.google.android.exoplayer2.text.Cue.Builder> entry2 : map.entrySet()) {
                this.l.put(entry2.getKey(), java.lang.Integer.valueOf(((java.lang.CharSequence) com.google.android.exoplayer2.util.Assertions.checkNotNull(entry2.getValue().getText())).length()));
            }
        }
    }
}

package com.aliyun.svideosdk.font;

/* loaded from: classes12.dex */
abstract class c {
    protected java.lang.String a;
    protected boolean b;
    protected int c;
    protected int d;
    protected android.text.StaticLayout e;
    protected float f = 0.0f;
    protected boolean g = false;
    protected java.util.ArrayList<java.util.ArrayList<com.aliyun.svideosdk.font.c.b>> h;
    protected android.graphics.RectF[] i;
    protected android.graphics.RectF j;
    protected android.graphics.RectF k;
    protected float l;

    public static class b {
        public android.graphics.PointF a;
        public android.graphics.RectF b;
        public android.graphics.RectF c;
        public android.graphics.Path f;
        public int i;
        public boolean d = false;
        public boolean e = false;
        public int g = 0;
        public int h = 0;
    }

    /* renamed from: com.aliyun.svideosdk.font.c$c, reason: collision with other inner class name */
    public static class C0101c {
        public int a;
        public int b;
        public int c;
        public int d;
        public float e;
        public boolean f;
        public float g;
        public float h;

        private C0101c() {
        }

        public /* synthetic */ C0101c(com.aliyun.svideosdk.font.c.a aVar) {
            this();
        }
    }

    public static class d {
        java.util.ArrayList<com.aliyun.svideosdk.font.c.C0101c> a;
        int b = 0;

        public d(java.util.ArrayList<com.aliyun.svideosdk.font.c.C0101c> arrayList) {
            this.a = arrayList;
        }

        private float a() {
            com.aliyun.svideosdk.font.c.C0101c c0101c = this.a.get(this.b);
            float f = c0101c.g;
            float f2 = c0101c.h;
            if (f == f2) {
                return !c0101c.f ? f : f - c0101c.e;
            }
            int i = this.b;
            if (i == 0) {
                return !c0101c.f ? f : f2 - c0101c.e;
            }
            com.aliyun.svideosdk.font.c.C0101c c0101c2 = this.a.get(i - 1);
            if (c0101c.f) {
                float f3 = c0101c.g;
                return f3 < c0101c2.g ? f3 - c0101c.e : c0101c.h - c0101c.e;
            }
            float f4 = c0101c.g;
            return f4 < c0101c2.g ? c0101c.h : f4;
        }

        public float b() {
            if (this.b >= this.a.size()) {
                return 0.0f;
            }
            float a = a();
            this.b++;
            return a;
        }
    }

    public c(java.lang.String str, android.text.TextPaint textPaint, float f, boolean z, int i, int i2, int i3, int i4) {
        this.c = 129;
        this.d = 1;
        this.l = 0.0f;
        this.b = z;
        if (str != null) {
            this.a = str;
            this.c = i;
            this.d = i2;
            try {
                this.l = textPaint.getTextSize() * 0.05f;
                textPaint.measureText("X");
                a(textPaint, f, i3, i4);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("");
                sb.append(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void a(android.text.TextPaint textPaint, float f, int i, int i2) {
        android.text.StaticLayout staticLayout;
        float f2;
        android.text.StaticLayout.Builder obtain;
        int min = i > 0 ? java.lang.Math.min((int) java.lang.Math.ceil(android.text.Layout.getDesiredWidth(this.a, textPaint)), i) : (int) java.lang.Math.ceil(android.text.Layout.getDesiredWidth(this.a, textPaint));
        android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
        if ((this.c & 4) != 0) {
            alignment = android.text.Layout.Alignment.ALIGN_CENTER;
        }
        android.text.Layout.Alignment alignment2 = alignment;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            java.lang.String str = this.a;
            obtain = android.text.StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, min);
            obtain.setAlignment(alignment2);
            obtain.setLineSpacing(f, 1.0f);
            obtain.setIncludePad(false);
            staticLayout = obtain.build();
        } else {
            staticLayout = new android.text.StaticLayout(this.a, textPaint, min, alignment2, 1.0f, f, false);
        }
        if (i2 > 0) {
            float height = staticLayout.getHeight();
            int i3 = this.c;
            if ((i3 & 64) != 0) {
                f2 = i2 - height;
            } else if ((i3 & 128) != 0) {
                f2 = (i2 - height) / 2.0f;
            }
            this.f = f2;
        }
        this.e = staticLayout;
    }

    private boolean a(java.lang.String str, int i, int i2) {
        if (i2 == i + 1 && str.charAt(i) == ' ') {
            return false;
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 8205 && charAt != 8204) {
                if (!java.lang.Character.isHighSurrogate(charAt)) {
                    java.lang.Character.UnicodeBlock of = java.lang.Character.UnicodeBlock.of(charAt);
                    if (of != java.lang.Character.UnicodeBlock.VARIATION_SELECTORS && of != java.lang.Character.UnicodeBlock.ARROWS && of != java.lang.Character.UnicodeBlock.BASIC_LATIN && of != java.lang.Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && of != java.lang.Character.UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS && of != java.lang.Character.UnicodeBlock.DINGBATS && of != java.lang.Character.UnicodeBlock.ENCLOSED_ALPHANUMERICS && of != java.lang.Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS && of != java.lang.Character.UnicodeBlock.GENERAL_PUNCTUATION && of != java.lang.Character.UnicodeBlock.GEOMETRIC_SHAPES && of != java.lang.Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS && of != java.lang.Character.UnicodeBlock.LATIN_1_SUPPLEMENT && of != java.lang.Character.UnicodeBlock.LETTERLIKE_SYMBOLS && of != java.lang.Character.UnicodeBlock.MISCELLANEOUS_TECHNICAL && of != java.lang.Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS && of != java.lang.Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS && of != java.lang.Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_B) {
                        return false;
                    }
                } else {
                    if (i >= i2 - 1) {
                        return false;
                    }
                    i++;
                    char charAt2 = str.charAt(i);
                    if (!java.lang.Character.isLowSurrogate(charAt2)) {
                        return false;
                    }
                    int codePoint = java.lang.Character.toCodePoint(charAt, charAt2);
                    java.lang.Character.UnicodeBlock of2 = java.lang.Character.UnicodeBlock.of(codePoint);
                    if (of2 != java.lang.Character.UnicodeBlock.VARIATION_SELECTORS_SUPPLEMENT && of2 != java.lang.Character.UnicodeBlock.TAGS && ((codePoint < 128512 || codePoint > 128591) && ((codePoint < 127744 || codePoint > 128511) && ((codePoint < 129280 || codePoint > 129535) && ((codePoint < 128640 || codePoint > 128767) && ((codePoint < 126976 || codePoint > 127023) && ((codePoint < 127136 || codePoint > 127231) && ((codePoint < 127232 || codePoint > 127487) && ((codePoint < 127488 || codePoint > 127743) && ((codePoint < 128896 || codePoint > 129023) && (codePoint < 129648 || codePoint > 129791))))))))))) {
                        return false;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private boolean b(java.lang.String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt >= 1536 && charAt <= 1791) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0410, code lost:
    
        if (r3 == 4) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0434, code lost:
    
        r2 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x042f, code lost:
    
        r2 = (r6 - r2) / 2.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0420, code lost:
    
        if (r3 == 4) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x042d, code lost:
    
        if (r3 == 2) goto L126;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x046d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x037f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        int i;
        float f;
        float f2;
        float width;
        int i2;
        float f3;
        if (this.g) {
            return;
        }
        this.g = true;
        android.text.StaticLayout staticLayout = this.e;
        if (staticLayout != null) {
            android.graphics.Paint.FontMetrics fontMetrics = staticLayout.getPaint().getFontMetrics();
            float f4 = fontMetrics.ascent;
            float f5 = fontMetrics.descent;
            boolean z = (this.e.getPaint().getTypeface() != null && this.e.getPaint().getTypeface().isItalic()) || this.e.getPaint().getTextSkewX() != 0.0f;
            this.j = new android.graphics.RectF();
            int lineCount = this.e.getLineCount();
            this.i = new android.graphics.RectF[lineCount];
            this.h = new java.util.ArrayList<>();
            int i3 = 0;
            int i4 = 0;
            float f6 = 0.0f;
            while (i3 < lineCount) {
                this.i[i3] = new android.graphics.RectF();
                java.util.ArrayList<com.aliyun.svideosdk.font.c.b> arrayList = new java.util.ArrayList<>();
                this.h.add(arrayList);
                int lineBaseline = this.e.getLineBaseline(i3);
                int lineStart = this.e.getLineStart(i3);
                int lineEnd = this.e.getLineEnd(i3);
                float[] fArr = new float[lineEnd - lineStart];
                this.e.getPaint().getTextWidths(this.a, lineStart, lineEnd, fArr);
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int i5 = lineStart;
                while (true) {
                    if (i5 >= lineEnd) {
                        i2 = lineCount;
                        f3 = f6;
                        break;
                    }
                    i2 = lineCount;
                    int i6 = i5 + 1;
                    while (i6 < lineEnd && fArr[i6 - lineStart] == 0.0f) {
                        i6++;
                    }
                    int i7 = lineEnd;
                    f3 = f6;
                    if (i6 - i5 == 1 && this.a.charAt(i5) == '\n') {
                        break;
                    }
                    com.aliyun.svideosdk.font.c.C0101c c0101c = new com.aliyun.svideosdk.font.c.C0101c(null);
                    c0101c.a = i4;
                    c0101c.b = this.a.codePointAt(i5);
                    c0101c.c = i5;
                    c0101c.d = i6;
                    c0101c.e = fArr[i5 - lineStart];
                    c0101c.f = this.e.isRtlCharAt(i5);
                    c0101c.g = this.e.getPrimaryHorizontal(i5);
                    c0101c.h = this.e.getSecondaryHorizontal(i5);
                    arrayList2.add(c0101c);
                    i4++;
                    i5 = i6;
                    lineEnd = i7;
                    lineCount = i2;
                    f6 = f3;
                }
                int i8 = i4 + 1;
                com.aliyun.svideosdk.font.c.d dVar = new com.aliyun.svideosdk.font.c.d(arrayList2);
                int i9 = 0;
                while (i9 < arrayList2.size()) {
                    com.aliyun.svideosdk.font.c.C0101c c0101c2 = (com.aliyun.svideosdk.font.c.C0101c) arrayList2.get(i9);
                    int i10 = c0101c2.c;
                    java.util.ArrayList arrayList3 = arrayList2;
                    int i11 = c0101c2.d;
                    int i12 = i8;
                    com.aliyun.svideosdk.font.c.b bVar = new com.aliyun.svideosdk.font.c.b();
                    bVar.g = i10;
                    bVar.h = i11;
                    int i13 = i3;
                    bVar.d = false;
                    bVar.i = c0101c2.b;
                    bVar.e = b(this.a, i10, i11);
                    float b2 = dVar.b();
                    com.aliyun.svideosdk.font.c.d dVar2 = dVar;
                    int i14 = lineBaseline;
                    bVar.a = new android.graphics.PointF(b2, lineBaseline + this.f);
                    bVar.b = new android.graphics.RectF();
                    bVar.c = new android.graphics.RectF();
                    bVar.f = new android.graphics.Path();
                    android.text.TextPaint paint = this.e.getPaint();
                    java.lang.String str = this.a;
                    android.graphics.PointF pointF = bVar.a;
                    int i15 = i9;
                    paint.getTextPath(str, i10, i11, pointF.x, pointF.y, bVar.f);
                    if (bVar.f.isEmpty()) {
                        if (a(this.a, i10, i11)) {
                            bVar.d = true;
                        }
                        android.graphics.Rect rect = new android.graphics.Rect();
                        this.e.getPaint().getTextBounds(this.a, i10, i11, rect);
                        bVar.b.set(rect);
                        android.graphics.RectF rectF = bVar.b;
                        android.graphics.PointF pointF2 = bVar.a;
                        rectF.offset(pointF2.x, pointF2.y);
                        if (z && bVar.d) {
                            android.graphics.RectF rectF2 = bVar.b;
                            float f7 = rectF2.right;
                            rectF2.right = f7 + ((f7 - rectF2.left) * 0.1f);
                        }
                    } else if (bVar.e) {
                        float f8 = fArr[i10 - lineStart];
                        android.graphics.RectF rectF3 = bVar.b;
                        rectF3.left = b2;
                        float f9 = b2 + f8;
                        rectF3.right = f9;
                        if (z) {
                            rectF3.right = f9 + ((int) (f8 * 0.3f));
                        }
                        float f10 = bVar.a.y;
                        rectF3.top = fontMetrics.ascent + f10;
                        rectF3.bottom = f10 + fontMetrics.descent;
                    } else {
                        bVar.f.computeBounds(bVar.b, false);
                    }
                    bVar.c.set(bVar.b);
                    android.graphics.RectF rectF4 = bVar.c;
                    float f11 = bVar.a.y;
                    rectF4.top = f11 + f4;
                    rectF4.bottom = f11 + f5;
                    arrayList.add(bVar);
                    i9 = i15 + 1;
                    arrayList2 = arrayList3;
                    i8 = i12;
                    i3 = i13;
                    dVar = dVar2;
                    lineBaseline = i14;
                }
                int i16 = i3;
                int i17 = i8;
                int i18 = lineBaseline;
                this.i[i16].left = this.e.getLineLeft(i16);
                this.i[i16].right = this.e.getLineRight(i16);
                this.i[i16].top = this.e.getLineTop(i16) + this.f;
                this.i[i16].bottom = this.e.getLineBottom(i16) + this.f;
                f6 = !this.i[i16].isEmpty() ? java.lang.Math.max(f3, this.i[i16].width()) : f3;
                if (this.b && !arrayList.isEmpty()) {
                    android.graphics.RectF rectF5 = this.i[i16];
                    float f12 = rectF5.left;
                    float f13 = rectF5.right;
                    float f14 = i18 + f5 + this.f;
                    float f15 = this.l + f14;
                    com.aliyun.svideosdk.font.c.b bVar2 = new com.aliyun.svideosdk.font.c.b();
                    bVar2.a = new android.graphics.PointF();
                    android.graphics.Path path = new android.graphics.Path();
                    bVar2.f = path;
                    path.moveTo(f12, f14);
                    bVar2.f.lineTo(f13, f14);
                    bVar2.f.lineTo(f13, f15);
                    bVar2.f.lineTo(f12, f15);
                    bVar2.f.lineTo(f12, f14);
                    bVar2.f.close();
                    android.graphics.RectF rectF6 = new android.graphics.RectF();
                    bVar2.b = rectF6;
                    bVar2.f.computeBounds(rectF6, true);
                    bVar2.c = new android.graphics.RectF(bVar2.b);
                    arrayList.add(bVar2);
                }
                i3 = i16 + 1;
                lineCount = i2;
                i4 = i17;
            }
            int i19 = lineCount;
            float f16 = f6;
            if ((this.c & 3) != 0) {
                i = i19;
                for (int i20 = 0; i20 < i; i20++) {
                    if (!this.i[i20].isEmpty()) {
                        int paragraphDirection = this.e.getParagraphDirection(i20);
                        float lineRight = this.e.getLineRight(i20) - this.e.getLineLeft(i20);
                        int i21 = this.c;
                        if ((i21 & 1) != 0) {
                            if (paragraphDirection == -1) {
                                width = -(this.e.getWidth() - lineRight);
                                if (width == 0.0f) {
                                    this.i[i20].offset(width, 0.0f);
                                    java.util.Iterator<com.aliyun.svideosdk.font.c.b> it = this.h.get(i20).iterator();
                                    while (it.hasNext()) {
                                        com.aliyun.svideosdk.font.c.b next = it.next();
                                        next.a.offset(width, 0.0f);
                                        next.b.offset(width, 0.0f);
                                        android.graphics.Path path2 = next.f;
                                        if (path2 != null) {
                                            path2.offset(width, 0.0f);
                                        }
                                    }
                                }
                            }
                            width = 0.0f;
                            if (width == 0.0f) {
                            }
                        } else {
                            if ((i21 & 2) != 0 && paragraphDirection == 1) {
                                width = this.e.getWidth() - lineRight;
                                if (width == 0.0f) {
                                }
                            }
                            width = 0.0f;
                            if (width == 0.0f) {
                            }
                        }
                    }
                }
            } else {
                i = i19;
            }
            for (int i22 = 0; i22 < i; i22++) {
                if (this.j.isEmpty()) {
                    this.j.set(this.i[i22]);
                } else if (!this.i[i22].isEmpty()) {
                    this.j.union(this.i[i22]);
                }
            }
            if (this.b && !this.j.isEmpty()) {
                android.graphics.RectF rectF7 = this.j;
                float f17 = rectF7.top;
                float f18 = this.l;
                rectF7.top = f17 - f18;
                rectF7.bottom += f18;
            }
            android.graphics.RectF rectF8 = new android.graphics.RectF();
            this.k = rectF8;
            android.graphics.RectF rectF9 = this.j;
            rectF8.set(0.0f, 0.0f, rectF9.right + rectF9.left, rectF9.bottom + this.f);
            if ((this.c & 7) != this.d) {
                for (int i23 = 0; i23 < i; i23++) {
                    if (!this.i[i23].isEmpty()) {
                        float width2 = this.i[i23].width();
                        int i24 = this.c;
                        if ((i24 & 1) != 0) {
                            int i25 = this.d;
                            if (i25 == 2) {
                                f = f16 - width2;
                                f2 = 0.0f;
                                if (f == f2) {
                                    this.i[i23].offset(f, f2);
                                    java.util.Iterator<com.aliyun.svideosdk.font.c.b> it2 = this.h.get(i23).iterator();
                                    while (it2.hasNext()) {
                                        com.aliyun.svideosdk.font.c.b next2 = it2.next();
                                        next2.a.offset(f, f2);
                                        next2.b.offset(f, f2);
                                        android.graphics.Path path3 = next2.f;
                                        if (path3 != null) {
                                            path3.offset(f, f2);
                                        }
                                    }
                                }
                            }
                        } else if ((i24 & 2) != 0) {
                            int i26 = this.d;
                            if (i26 == 1) {
                                f = -(f16 - width2);
                            }
                        } else {
                            int i27 = this.d;
                            if (i27 != 1) {
                            }
                            f = (-(f16 - width2)) / 2.0f;
                        }
                        f2 = 0.0f;
                        if (f == f2) {
                        }
                    }
                }
            }
        }
    }

    public int a(int i) {
        java.util.ArrayList<java.util.ArrayList<com.aliyun.svideosdk.font.c.b>> arrayList;
        f();
        if (i < 0 || (arrayList = this.h) == null || i >= arrayList.size() || this.h.get(i) == null) {
            return 0;
        }
        return this.h.get(i).size();
    }

    public android.text.Layout a() {
        return this.e;
    }

    public com.aliyun.svideosdk.font.c.b a(int i, int i2) {
        java.util.ArrayList<java.util.ArrayList<com.aliyun.svideosdk.font.c.b>> arrayList;
        f();
        if (i < 0 || (arrayList = this.h) == null || i >= arrayList.size() || this.h.get(i) == null) {
            return null;
        }
        java.util.ArrayList<com.aliyun.svideosdk.font.c.b> arrayList2 = this.h.get(i);
        if (i2 < 0 || i2 >= arrayList2.size()) {
            return null;
        }
        return arrayList2.get(i2);
    }

    public android.graphics.RectF b() {
        f();
        android.graphics.RectF rectF = this.k;
        return rectF != null ? rectF : new android.graphics.RectF();
    }

    public int c() {
        f();
        java.util.ArrayList<java.util.ArrayList<com.aliyun.svideosdk.font.c.b>> arrayList = this.h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public java.lang.String d() {
        return this.a;
    }

    public void f() {
        try {
            e();
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("");
            sb.append(e.getMessage());
            e.printStackTrace();
        }
    }
}

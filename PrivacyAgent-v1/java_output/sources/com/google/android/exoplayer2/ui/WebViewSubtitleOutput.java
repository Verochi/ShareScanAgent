package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
final class WebViewSubtitleOutput extends android.widget.FrameLayout implements com.google.android.exoplayer2.ui.SubtitleView.Output {
    public final com.google.android.exoplayer2.ui.CanvasSubtitleOutput n;
    public final android.webkit.WebView t;
    public java.util.List<com.google.android.exoplayer2.text.Cue> u;
    public com.google.android.exoplayer2.text.CaptionStyleCompat v;
    public float w;
    public int x;
    public float y;

    /* renamed from: com.google.android.exoplayer2.ui.WebViewSubtitleOutput$1, reason: invalid class name */
    public class AnonymousClass1 extends android.webkit.WebView {
        public AnonymousClass1(com.google.android.exoplayer2.ui.WebViewSubtitleOutput webViewSubtitleOutput, android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.WebViewSubtitleOutput$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[android.text.Layout.Alignment.values().length];
            a = iArr;
            try {
                iArr[android.text.Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[android.text.Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[android.text.Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput(android.content.Context context) {
        this(context, null);
    }

    public WebViewSubtitleOutput(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u = java.util.Collections.emptyList();
        this.v = com.google.android.exoplayer2.text.CaptionStyleCompat.DEFAULT;
        this.w = 0.0533f;
        this.x = 0;
        this.y = 0.08f;
        com.google.android.exoplayer2.ui.CanvasSubtitleOutput canvasSubtitleOutput = new com.google.android.exoplayer2.ui.CanvasSubtitleOutput(context, attributeSet);
        this.n = canvasSubtitleOutput;
        com.google.android.exoplayer2.ui.WebViewSubtitleOutput.AnonymousClass1 anonymousClass1 = new com.google.android.exoplayer2.ui.WebViewSubtitleOutput.AnonymousClass1(this, context, attributeSet);
        this.t = anonymousClass1;
        anonymousClass1.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(anonymousClass1);
    }

    public static int a(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static java.lang.String b(@androidx.annotation.Nullable android.text.Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = com.google.android.exoplayer2.ui.WebViewSubtitleOutput.AnonymousClass2.a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : com.anythink.expressad.foundation.d.c.bT;
    }

    public static java.lang.String c(com.google.android.exoplayer2.text.CaptionStyleCompat captionStyleCompat) {
        int i = captionStyleCompat.edgeType;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unset" : com.google.android.exoplayer2.util.Util.formatInvariant("-0.05em -0.05em 0.15em %s", com.google.android.exoplayer2.ui.HtmlUtils.b(captionStyleCompat.edgeColor)) : com.google.android.exoplayer2.util.Util.formatInvariant("0.06em 0.08em 0.15em %s", com.google.android.exoplayer2.ui.HtmlUtils.b(captionStyleCompat.edgeColor)) : com.google.android.exoplayer2.util.Util.formatInvariant("0.1em 0.12em 0.15em %s", com.google.android.exoplayer2.ui.HtmlUtils.b(captionStyleCompat.edgeColor)) : com.google.android.exoplayer2.util.Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", com.google.android.exoplayer2.ui.HtmlUtils.b(captionStyleCompat.edgeColor));
    }

    public static java.lang.String e(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public final java.lang.String d(int i, float f) {
        float a = com.google.android.exoplayer2.ui.SubtitleViewUtils.a(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return a == -3.4028235E38f ? "unset" : com.google.android.exoplayer2.util.Util.formatInvariant("%.2fpx", java.lang.Float.valueOf(a / getContext().getResources().getDisplayMetrics().density));
    }

    public void f() {
        this.t.destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0148, code lost:
    
        if (r13 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x014d, code lost:
    
        r20 = com.sensorsdata.sf.ui.view.UIProperty.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014f, code lost:
    
        r21 = com.sensorsdata.sf.ui.view.UIProperty.top;
        r13 = 2;
        r22 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014b, code lost:
    
        if (r13 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        java.lang.String formatInvariant;
        int i;
        boolean z;
        float f;
        java.lang.String str;
        int i2;
        int i3;
        java.lang.String str2;
        int i4;
        java.util.Iterator it;
        com.google.android.exoplayer2.ui.WebViewSubtitleOutput webViewSubtitleOutput = this;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char c = 0;
        int i5 = 1;
        float f2 = 1.2f;
        sb.append(com.google.android.exoplayer2.util.Util.formatInvariant("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2fem;text-shadow:%s;'>", com.google.android.exoplayer2.ui.HtmlUtils.b(webViewSubtitleOutput.v.foregroundColor), webViewSubtitleOutput.d(webViewSubtitleOutput.x, webViewSubtitleOutput.w), java.lang.Float.valueOf(1.2f), c(webViewSubtitleOutput.v)));
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.google.android.exoplayer2.ui.HtmlUtils.a("default_bg"), com.google.android.exoplayer2.util.Util.formatInvariant("background-color:%s;", com.google.android.exoplayer2.ui.HtmlUtils.b(webViewSubtitleOutput.v.backgroundColor)));
        int i6 = 0;
        while (i6 < webViewSubtitleOutput.u.size()) {
            com.google.android.exoplayer2.text.Cue cue = webViewSubtitleOutput.u.get(i6);
            float f3 = cue.position;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int a = a(cue.positionAnchor);
            float f5 = cue.line;
            if (f5 == -3.4028235E38f) {
                java.lang.Object[] objArr = new java.lang.Object[i5];
                objArr[c] = java.lang.Float.valueOf((1.0f - webViewSubtitleOutput.y) * 100.0f);
                formatInvariant = com.google.android.exoplayer2.util.Util.formatInvariant("%.2f%%", objArr);
                i = -100;
            } else if (cue.lineType != i5) {
                java.lang.Object[] objArr2 = new java.lang.Object[i5];
                objArr2[c] = java.lang.Float.valueOf(f5 * 100.0f);
                formatInvariant = com.google.android.exoplayer2.util.Util.formatInvariant("%.2f%%", objArr2);
                i = cue.verticalType == i5 ? -a(cue.lineAnchor) : a(cue.lineAnchor);
            } else if (f5 >= 0.0f) {
                java.lang.Object[] objArr3 = new java.lang.Object[i5];
                objArr3[c] = java.lang.Float.valueOf(f5 * f2);
                formatInvariant = com.google.android.exoplayer2.util.Util.formatInvariant("%.2fem", objArr3);
                i = 0;
            } else {
                java.lang.Object[] objArr4 = new java.lang.Object[i5];
                objArr4[c] = java.lang.Float.valueOf(((-f5) - 1.0f) * f2);
                formatInvariant = com.google.android.exoplayer2.util.Util.formatInvariant("%.2fem", objArr4);
                i = 0;
                z = true;
                f = cue.size;
                if (f == -3.4028235E38f) {
                    java.lang.Object[] objArr5 = new java.lang.Object[i5];
                    objArr5[0] = java.lang.Float.valueOf(f * 100.0f);
                    str = com.google.android.exoplayer2.util.Util.formatInvariant("%.2f%%", objArr5);
                } else {
                    str = "fit-content";
                }
                java.lang.String b = b(cue.textAlignment);
                java.lang.String e = e(cue.verticalType);
                java.lang.String d = webViewSubtitleOutput.d(cue.textSizeType, cue.textSize);
                java.lang.String b2 = com.google.android.exoplayer2.ui.HtmlUtils.b(!cue.windowColorSet ? cue.windowColor : webViewSubtitleOutput.v.windowColor);
                int i7 = i;
                i2 = cue.verticalType;
                java.lang.String str3 = com.sensorsdata.sf.ui.view.UIProperty.right;
                java.lang.String str4 = com.sensorsdata.sf.ui.view.UIProperty.left;
                java.lang.String str5 = com.sensorsdata.sf.ui.view.UIProperty.top;
                if (i2 == 1) {
                    if (i2 != 2) {
                        if (z) {
                            str5 = com.sensorsdata.sf.ui.view.UIProperty.bottom;
                        }
                        i3 = 2;
                    }
                }
                if (i2 != i3 || i2 == 1) {
                    str2 = "height";
                    i4 = i7;
                    i7 = a;
                } else {
                    str2 = "width";
                    i4 = a;
                }
                com.google.android.exoplayer2.ui.SpannedToHtmlConverter.HtmlAndCss a2 = com.google.android.exoplayer2.ui.SpannedToHtmlConverter.a(cue.text, getContext().getResources().getDisplayMetrics().density);
                it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    java.util.Iterator it2 = it;
                    java.lang.String str6 = (java.lang.String) it.next();
                    java.lang.String str7 = (java.lang.String) hashMap.put(str6, (java.lang.String) hashMap.get(str6));
                    com.google.android.exoplayer2.util.Assertions.checkState(str7 == null || str7.equals(hashMap.get(str6)));
                    it = it2;
                }
                sb.append(com.google.android.exoplayer2.util.Util.formatInvariant("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", str4, java.lang.Float.valueOf(f4), str5, formatInvariant, str2, str, b, e, d, b2, java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i7)));
                sb.append(com.google.android.exoplayer2.util.Util.formatInvariant("<span class='%s'>", "default_bg"));
                sb.append(a2.html);
                sb.append("</span>");
                sb.append("</div>");
                i6++;
                f2 = 1.2f;
                c = 0;
                webViewSubtitleOutput = this;
                i5 = 1;
            }
            z = false;
            f = cue.size;
            if (f == -3.4028235E38f) {
            }
            java.lang.String b3 = b(cue.textAlignment);
            java.lang.String e2 = e(cue.verticalType);
            java.lang.String d2 = webViewSubtitleOutput.d(cue.textSizeType, cue.textSize);
            java.lang.String b22 = com.google.android.exoplayer2.ui.HtmlUtils.b(!cue.windowColorSet ? cue.windowColor : webViewSubtitleOutput.v.windowColor);
            int i72 = i;
            i2 = cue.verticalType;
            java.lang.String str32 = com.sensorsdata.sf.ui.view.UIProperty.right;
            java.lang.String str42 = com.sensorsdata.sf.ui.view.UIProperty.left;
            java.lang.String str52 = com.sensorsdata.sf.ui.view.UIProperty.top;
            if (i2 == 1) {
            }
            if (i2 != i3) {
            }
            str2 = "height";
            i4 = i72;
            i72 = a;
            com.google.android.exoplayer2.ui.SpannedToHtmlConverter.HtmlAndCss a22 = com.google.android.exoplayer2.ui.SpannedToHtmlConverter.a(cue.text, getContext().getResources().getDisplayMetrics().density);
            it = hashMap.keySet().iterator();
            while (it.hasNext()) {
            }
            sb.append(com.google.android.exoplayer2.util.Util.formatInvariant("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", str42, java.lang.Float.valueOf(f4), str52, formatInvariant, str2, str, b3, e2, d2, b22, java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i72)));
            sb.append(com.google.android.exoplayer2.util.Util.formatInvariant("<span class='%s'>", "default_bg"));
            sb.append(a22.html);
            sb.append("</span>");
            sb.append("</div>");
            i6++;
            f2 = 1.2f;
            c = 0;
            webViewSubtitleOutput = this;
            i5 = 1;
        }
        sb.append("</div></body></html>");
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("<html><head><style>");
        for (java.lang.String str8 : hashMap.keySet()) {
            sb2.append(str8);
            sb2.append("{");
            sb2.append((java.lang.String) hashMap.get(str8));
            sb2.append(com.alipay.sdk.m.u.i.d);
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.t.loadData(android.util.Base64.encodeToString(sb.toString().getBytes(com.google.common.base.Charsets.UTF_8), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.u.isEmpty()) {
            return;
        }
        g();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void update(java.util.List<com.google.android.exoplayer2.text.Cue> list, com.google.android.exoplayer2.text.CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.v = captionStyleCompat;
        this.w = f;
        this.x = i;
        this.y = f2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.text.Cue cue = list.get(i2);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.u.isEmpty() || !arrayList2.isEmpty()) {
            this.u = arrayList2;
            g();
        }
        this.n.update(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }
}

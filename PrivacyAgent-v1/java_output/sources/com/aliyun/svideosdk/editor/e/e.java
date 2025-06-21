package com.aliyun.svideosdk.editor.e;

/* loaded from: classes12.dex */
class e {

    public static class a implements java.io.FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.toLowerCase().endsWith(".ttf");
        }
    }

    private static int a(android.widget.TextView textView) {
        android.graphics.Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return (int) (fontMetrics.descent - fontMetrics.ascent);
    }

    private static com.aliyun.svideosdk.common.struct.asset.TypefaceConfig a(java.lang.String str) {
        com.aliyun.svideosdk.common.struct.asset.TypefaceConfig typefaceConfig;
        if (android.text.TextUtils.isEmpty(str)) {
            return new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
        }
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig(android.graphics.Typeface.createFromFile(str));
            } else {
                java.io.File parentFile = file.getParentFile();
                java.lang.String[] list = parentFile.list(new com.aliyun.svideosdk.editor.e.e.a());
                if (list == null || list.length <= 0) {
                    typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
                } else {
                    java.io.File file2 = new java.io.File(parentFile, list[0]);
                    if (file2.exists()) {
                        typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig(android.graphics.Typeface.createFromFile(file2));
                    } else {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Font file[");
                        sb.append(file2.getAbsolutePath());
                        sb.append("] not exist!");
                        typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
                    }
                }
            }
            return typefaceConfig;
        } catch (java.lang.Exception unused) {
            return new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
        }
    }

    public static com.aliyun.svideosdk.editor.e.d.c a(android.content.Context context, java.lang.String str, com.aliyun.svideosdk.editor.e.c cVar, int i, int i2) {
        com.aliyun.svideosdk.editor.e.f.b bVar = new com.aliyun.svideosdk.editor.e.f.b(context);
        bVar.setMaxLines(1);
        bVar.setMinTextSize(8);
        bVar.setTextSize(cVar.e(), cVar.d());
        bVar.setMaxTextSize(96.0f);
        bVar.setText(str);
        bVar.setTypeface(a(cVar.a()).typeface);
        int i3 = i / 10;
        bVar.measure(android.view.View.MeasureSpec.makeMeasureSpec((i - i3) - ((int) ((i / 20) + ((new java.util.Random().nextInt(100) / 100.0f) * ((i / 5) - r4)))), Integer.MIN_VALUE), android.view.View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        bVar.layout(0, 0, bVar.getMeasuredWidth(), bVar.getMeasuredHeight());
        com.aliyun.svideosdk.editor.e.d.c cVar2 = new com.aliyun.svideosdk.editor.e.d.c();
        cVar2.a = (int) bVar.getTextSize();
        cVar2.f = b(bVar);
        int a2 = a(bVar);
        cVar2.g = a2;
        int i4 = cVar2.f;
        cVar2.d = i4;
        cVar2.e = a2;
        cVar2.b = i3 + (i4 / 2);
        cVar2.c = i2 / 2;
        return cVar2;
    }

    private static int b(android.widget.TextView textView) {
        android.text.Layout layout = textView.getLayout();
        return layout != null ? layout.getWidth() : textView.getMeasuredWidth();
    }
}

package com.autonavi.base.ae.gmap.bean;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class NativeTextGenerate {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private static volatile com.autonavi.base.ae.gmap.bean.NativeTextGenerate instance;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private android.text.TextPaint text_paint_bitmap;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private android.text.TextPaint text_paint_size;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private float density = 1.0f;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final int kTextLayoutLeftToRight = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final int kTextLayoutUpToDown = 1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final int kTextAlignmentCenter = 0;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final int kTextAlignmentLeft = 1;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private final int kTextAlignmentRight = 2;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class TextGeneratePOIStyleDesc {
        int fontSize = 0;
        int fontColor = 0;
        int fontBorderColor = 0;
        int fontBgColor = 0;
        int boldFont = 0;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class TextGenerateTextBitmap {
        byte[] data;
        public int dataId;
        int dataLength;
        double height;
        com.amap.api.maps.model.BitmapDescriptor imageData;
        java.lang.String text;
        double width;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static class TextGenerateTextStyle {
        int singleLineCharaterLimit = 7;
        int textAlignment = 0;
        int layoutDirection = 0;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.text_paint_size = new android.text.TextPaint();
        this.text_paint_bitmap = new android.text.TextPaint();
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static com.autonavi.base.ae.gmap.bean.NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (com.autonavi.base.ae.gmap.bean.NativeTextGenerate.class) {
                if (instance == null) {
                    instance = new com.autonavi.base.ae.gmap.bean.NativeTextGenerate();
                }
            }
        }
        return instance;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    private android.text.StaticLayout setPaintStyle(android.text.TextPaint textPaint, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGenerateTextBitmap textGenerateTextBitmap, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGenerateTextStyle textGenerateTextStyle, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f = textGeneratePOIStyleDesc.fontSize * this.density;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f);
        textPaint.setStyle(android.graphics.Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? android.graphics.Typeface.DEFAULT_BOLD : android.graphics.Typeface.DEFAULT);
        int i = textGenerateTextStyle.textAlignment;
        if (i == 0) {
            textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        } else if (i != 2) {
            textPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(android.graphics.Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i2 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > i2 || length % i2 != 0) {
            int i3 = (length / i2) + 1;
            i2 = (length / i3) + (length % i3 <= 0 ? 0 : 1);
        }
        return new android.text.StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f * i2), android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void calculateTextBoundSize(com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGenerateTextBitmap textGenerateTextBitmap, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGenerateTextStyle textGenerateTextStyle, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        android.text.StaticLayout paintStyle = setPaintStyle(this.text_paint_size, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        float measureText = this.text_paint_size.measureText(textGenerateTextBitmap.text);
        android.graphics.Paint.FontMetrics fontMetrics = this.text_paint_size.getFontMetrics();
        textGenerateTextBitmap.width = measureText;
        textGenerateTextBitmap.height = fontMetrics.descent - fontMetrics.ascent;
        textGenerateTextBitmap.width = paintStyle.getWidth();
        textGenerateTextBitmap.height = paintStyle.getHeight();
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void generateTextBitmap(com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGenerateTextBitmap textGenerateTextBitmap, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGenerateTextStyle textGenerateTextStyle, com.autonavi.base.ae.gmap.bean.NativeTextGenerate.TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        android.text.StaticLayout paintStyle = setPaintStyle(this.text_paint_bitmap, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        int i = textGenerateTextStyle.textAlignment;
        if (i == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (i == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(android.graphics.Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        int i2 = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.dataLength = i2;
        textGenerateTextBitmap.data = new byte[i2];
        textGenerateTextBitmap.dataId = com.amap.api.mapcore.util.dl.b();
        createBitmap.copyPixelsToBuffer(java.nio.ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public com.amap.api.maps.model.BitmapDescriptor getIconBitmap(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] uncompress = com.autonavi.base.amap.mapcore.FileUtil.uncompress(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssetsByPreName(com.amap.api.mapcore.util.p.a, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME, str + "_"));
            if (uncompress != null) {
                return com.amap.api.maps.model.BitmapDescriptorFactory.fromBitmap(android.graphics.BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
        }
        return null;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public byte[] getMapStyleJsonData() {
        try {
            return com.autonavi.base.amap.mapcore.FileUtil.uncompress(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(com.amap.api.mapcore.util.p.a, "map_custom/terrain/terrainStyle.data"));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public void setDensity(float f) {
        this.density = f;
    }
}

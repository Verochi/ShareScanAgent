package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class BitmapFont implements com.badlogic.gdx.utils.Disposable {
    public final com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData a;
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> b;
    public final com.badlogic.gdx.graphics.g2d.BitmapFontCache c;
    public boolean d;
    public boolean e;
    public boolean f;

    public static class BitmapFontData {
        public float ascent;
        public float blankLineScale;
        public char[] breakChars;
        public char[] capChars;
        public float capHeight;
        public float cursorX;
        public float descent;
        public float down;
        public boolean flipped;
        public com.badlogic.gdx.files.FileHandle fontFile;
        public final com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[][] glyphs;
        public java.lang.String[] imagePaths;
        public float lineHeight;
        public boolean markupEnabled;
        public com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph missingGlyph;
        public float padBottom;
        public float padLeft;
        public float padRight;
        public float padTop;
        public float scaleX;
        public float scaleY;
        public float spaceWidth;
        public char[] xChars;
        public float xHeight;

        public BitmapFontData() {
            this.capHeight = 1.0f;
            this.blankLineScale = 1.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.glyphs = new com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[128][];
            this.xHeight = 1.0f;
            this.xChars = new char[]{'x', 'e', 'a', 'o', 'n', 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'c', 'u', 'm', 'v', 'w', 'z'};
            this.capChars = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }

        public BitmapFontData(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
            this.capHeight = 1.0f;
            this.blankLineScale = 1.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.glyphs = new com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[128][];
            this.xHeight = 1.0f;
            this.xChars = new char[]{'x', 'e', 'a', 'o', 'n', 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'c', 'u', 'm', 'v', 'w', 'z'};
            this.capChars = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            this.fontFile = fileHandle;
            this.flipped = z;
            load(fileHandle, z);
        }

        public com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph getFirstGlyph() {
            for (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[] glyphArr : this.glyphs) {
                if (glyphArr != null) {
                    for (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph : glyphArr) {
                        if (glyph != null && glyph.height != 0 && glyph.width != 0) {
                            return glyph;
                        }
                    }
                }
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No glyphs found.");
        }

        public com.badlogic.gdx.files.FileHandle getFontFile() {
            return this.fontFile;
        }

        public com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph getGlyph(char c) {
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[] glyphArr = this.glyphs[c / 512];
            if (glyphArr != null) {
                return glyphArr[c & 511];
            }
            return null;
        }

        public void getGlyphs(com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun glyphRun, java.lang.CharSequence charSequence, int i, int i2, boolean z) {
            boolean z2 = this.markupEnabled;
            float f = this.scaleX;
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph = this.missingGlyph;
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array = glyphRun.glyphs;
            com.badlogic.gdx.utils.FloatArray floatArray = glyphRun.xAdvances;
            int i3 = i2 - i;
            array.ensureCapacity(i3);
            floatArray.ensureCapacity(i3 + 1);
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph2 = null;
            while (i < i2) {
                int i4 = i + 1;
                char charAt = charSequence.charAt(i);
                com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph3 = getGlyph(charAt);
                if (glyph3 == null) {
                    if (glyph == null) {
                        i = i4;
                    } else {
                        glyph3 = glyph;
                    }
                }
                array.add(glyph3);
                if (glyph2 == null) {
                    floatArray.add((!z || glyph3.fixedWidth) ? 0.0f : ((-glyph3.xoffset) * f) - this.padLeft);
                } else {
                    floatArray.add((glyph2.xadvance + glyph2.getKerning(charAt)) * f);
                }
                if (z2 && charAt == '[' && i4 < i2 && charSequence.charAt(i4) == '[') {
                    i4++;
                }
                i = i4;
                glyph2 = glyph3;
            }
            if (glyph2 != null) {
                floatArray.add(((!z || glyph2.fixedWidth) ? glyph2.xadvance : (glyph2.xoffset + glyph2.width) - this.padRight) * f);
            }
        }

        public java.lang.String getImagePath(int i) {
            return this.imagePaths[i];
        }

        public java.lang.String[] getImagePaths() {
            return this.imagePaths;
        }

        public int getWrapIndex(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> array, int i) {
            int i2 = i - 1;
            while (i2 >= 1 && isWhitespace((char) array.get(i2).id)) {
                i2--;
            }
            while (i2 >= 1) {
                char c = (char) array.get(i2).id;
                if (isWhitespace(c) || isBreakChar(c)) {
                    return i2 + 1;
                }
                i2--;
            }
            return 0;
        }

        public boolean hasGlyph(char c) {
            return (this.missingGlyph == null && getGlyph(c) == null) ? false : true;
        }

        public boolean isBreakChar(char c) {
            char[] cArr = this.breakChars;
            if (cArr == null) {
                return false;
            }
            for (char c2 : cArr) {
                if (c == c2) {
                    return true;
                }
            }
            return false;
        }

        public boolean isWhitespace(char c) {
            return c == '\t' || c == '\n' || c == '\r' || c == ' ';
        }

        /* JADX WARN: Removed duplicated region for block: B:116:0x027a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:120:0x017b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:130:0x0190 A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:136:0x01ae A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:139:0x01cb A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:145:0x01d9 A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:148:0x01e9 A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x01f7 A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0236 A[Catch: all -> 0x0378, Exception -> 0x037a, TRY_LEAVE, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:183:0x0222 A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cd A[Catch: all -> 0x0378, Exception -> 0x037a, TryCatch #3 {Exception -> 0x037a, blocks: (B:6:0x0014, B:8:0x001a, B:10:0x003b, B:12:0x006d, B:14:0x0077, B:16:0x0081, B:18:0x009a, B:20:0x00aa, B:22:0x00ae, B:25:0x00b6, B:26:0x00c6, B:28:0x00cd, B:30:0x00d3, B:32:0x00e3, B:34:0x00e7, B:38:0x00ee, B:39:0x0104, B:43:0x0106, B:44:0x011c, B:45:0x011d, B:47:0x012d, B:49:0x014d, B:50:0x0154, B:52:0x0155, B:53:0x015c, B:55:0x015d, B:56:0x0160, B:59:0x016c, B:61:0x027f, B:64:0x0289, B:95:0x02a3, B:69:0x02ab, B:71:0x02f3, B:72:0x030c, B:74:0x031f, B:75:0x0322, B:89:0x0328, B:77:0x0332, B:80:0x0336, B:83:0x033a, B:92:0x02fe, B:68:0x02a8, B:100:0x0174, B:101:0x017b, B:128:0x018a, B:130:0x0190, B:132:0x019f, B:133:0x01a3, B:134:0x01aa, B:136:0x01ae, B:137:0x01be, B:139:0x01cb, B:141:0x01d4, B:145:0x01d9, B:146:0x01dd, B:148:0x01e9, B:150:0x01f2, B:154:0x01f7, B:156:0x01fd, B:160:0x021f, B:161:0x0202, B:163:0x0206, B:165:0x020a, B:167:0x020e, B:172:0x0213, B:171:0x021c, B:178:0x0227, B:180:0x0236, B:183:0x0222, B:103:0x0182, B:105:0x0240, B:114:0x0268, B:117:0x027a, B:192:0x0348, B:193:0x034f, B:194:0x0350, B:195:0x0357, B:196:0x0358, B:197:0x035f, B:198:0x0360, B:199:0x0367, B:200:0x0368, B:201:0x036f, B:202:0x0370, B:203:0x0377), top: B:5:0x0014, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0289 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0287 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void load(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
            int i;
            int i2;
            java.lang.String readLine;
            java.lang.String readLine2;
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph;
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph2;
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph3;
            int i3;
            java.util.StringTokenizer stringTokenizer;
            int parseInt;
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph4;
            java.lang.String str;
            if (this.imagePaths != null) {
                throw new java.lang.IllegalStateException("Already loaded.");
            }
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileHandle.read()), 512);
            try {
                try {
                    java.lang.String readLine3 = bufferedReader.readLine();
                    if (readLine3 == null) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("File is empty.");
                    }
                    java.lang.String substring = readLine3.substring(readLine3.indexOf("padding=") + 8);
                    if (substring.substring(0, substring.indexOf(32)).split(",", 4).length != 4) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid padding.");
                    }
                    this.padTop = java.lang.Integer.parseInt(r1[0]);
                    this.padRight = java.lang.Integer.parseInt(r1[1]);
                    this.padBottom = java.lang.Integer.parseInt(r1[2]);
                    this.padLeft = java.lang.Integer.parseInt(r1[3]);
                    float f = this.padTop + this.padBottom;
                    java.lang.String readLine4 = bufferedReader.readLine();
                    if (readLine4 == null) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Missing common header.");
                    }
                    java.lang.String[] split = readLine4.split(" ", 7);
                    if (split.length < 3) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid common header.");
                    }
                    if (!split[1].startsWith("lineHeight=")) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Missing: lineHeight");
                    }
                    this.lineHeight = java.lang.Integer.parseInt(split[1].substring(11));
                    if (!split[2].startsWith("base=")) {
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Missing: base");
                    }
                    float parseInt2 = java.lang.Integer.parseInt(split[2].substring(5));
                    if (split.length >= 6 && (str = split[5]) != null && str.startsWith("pages=")) {
                        try {
                            i = java.lang.Math.max(1, java.lang.Integer.parseInt(split[5].substring(6)));
                        } catch (java.lang.NumberFormatException unused) {
                        }
                        this.imagePaths = new java.lang.String[i];
                        for (i2 = 0; i2 < i; i2++) {
                            java.lang.String readLine5 = bufferedReader.readLine();
                            if (readLine5 == null) {
                                throw new com.badlogic.gdx.utils.GdxRuntimeException("Missing additional page definitions.");
                            }
                            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(".*id=(\\d+)").matcher(readLine5);
                            if (matcher.find()) {
                                java.lang.String group = matcher.group(1);
                                try {
                                    if (java.lang.Integer.parseInt(group) != i2) {
                                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Page IDs must be indices starting at 0: " + group);
                                    }
                                } catch (java.lang.NumberFormatException e) {
                                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Invalid page id: " + group, e);
                                }
                            }
                            java.util.regex.Matcher matcher2 = java.util.regex.Pattern.compile(".*file=\"?([^\"]+)\"?").matcher(readLine5);
                            if (!matcher2.find()) {
                                throw new com.badlogic.gdx.utils.GdxRuntimeException("Missing: file");
                            }
                            this.imagePaths[i2] = fileHandle.parent().child(matcher2.group(1)).path().replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                        }
                        this.descent = 0.0f;
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null && !readLine.startsWith("kernings ")) {
                                if (!readLine.startsWith("char ")) {
                                    com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph5 = new com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph();
                                    java.util.StringTokenizer stringTokenizer2 = new java.util.StringTokenizer(readLine, " =");
                                    stringTokenizer2.nextToken();
                                    stringTokenizer2.nextToken();
                                    int parseInt3 = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    if (parseInt3 <= 0) {
                                        this.missingGlyph = glyph5;
                                    } else if (parseInt3 <= 65535) {
                                        setGlyph(parseInt3, glyph5);
                                    }
                                    glyph5.id = parseInt3;
                                    stringTokenizer2.nextToken();
                                    glyph5.srcX = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    stringTokenizer2.nextToken();
                                    glyph5.srcY = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    stringTokenizer2.nextToken();
                                    glyph5.width = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    stringTokenizer2.nextToken();
                                    glyph5.height = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    stringTokenizer2.nextToken();
                                    glyph5.xoffset = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    stringTokenizer2.nextToken();
                                    if (z) {
                                        glyph5.yoffset = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    } else {
                                        glyph5.yoffset = -(glyph5.height + java.lang.Integer.parseInt(stringTokenizer2.nextToken()));
                                    }
                                    stringTokenizer2.nextToken();
                                    glyph5.xadvance = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                    if (stringTokenizer2.hasMoreTokens()) {
                                        stringTokenizer2.nextToken();
                                    }
                                    if (stringTokenizer2.hasMoreTokens()) {
                                        try {
                                            glyph5.page = java.lang.Integer.parseInt(stringTokenizer2.nextToken());
                                        } catch (java.lang.NumberFormatException unused2) {
                                        }
                                    }
                                    if (glyph5.width > 0 && glyph5.height > 0) {
                                        this.descent = java.lang.Math.min(glyph5.yoffset + parseInt2, this.descent);
                                    }
                                }
                            }
                        }
                        this.descent += this.padBottom;
                        while (true) {
                            readLine2 = bufferedReader.readLine();
                            if (readLine2 != null || !readLine2.startsWith("kerning ")) {
                                break;
                            }
                            stringTokenizer = new java.util.StringTokenizer(readLine2, " =");
                            stringTokenizer.nextToken();
                            stringTokenizer.nextToken();
                            parseInt = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                            stringTokenizer.nextToken();
                            int parseInt4 = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                            if (parseInt >= 0 && parseInt <= 65535 && parseInt4 >= 0 && parseInt4 <= 65535) {
                                glyph4 = getGlyph((char) parseInt);
                                stringTokenizer.nextToken();
                                int parseInt5 = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                                if (glyph4 == null) {
                                    glyph4.setKerning(parseInt4, parseInt5);
                                }
                            }
                        }
                        glyph = getGlyph(' ');
                        if (glyph == null) {
                            glyph = new com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph();
                            glyph.id = 32;
                            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph6 = getGlyph(com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT);
                            if (glyph6 == null) {
                                glyph6 = getFirstGlyph();
                            }
                            glyph.xadvance = glyph6.xadvance;
                            setGlyph(32, glyph);
                        }
                        if (glyph.width == 0) {
                            float f2 = this.padLeft;
                            glyph.width = (int) (glyph.xadvance + f2 + this.padRight);
                            glyph.xoffset = (int) (-f2);
                        }
                        this.spaceWidth = glyph.width;
                        glyph2 = null;
                        glyph3 = null;
                        for (char c : this.xChars) {
                            glyph3 = getGlyph(c);
                            if (glyph3 != null) {
                                break;
                            }
                        }
                        if (glyph3 == null) {
                            glyph3 = getFirstGlyph();
                        }
                        this.xHeight = glyph3.height - f;
                        for (char c2 : this.capChars) {
                            glyph2 = getGlyph(c2);
                            if (glyph2 != null) {
                                break;
                            }
                        }
                        if (glyph2 != null) {
                            for (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[] glyphArr : this.glyphs) {
                                if (glyphArr != null) {
                                    for (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph7 : glyphArr) {
                                        if (glyph7 != null && (i3 = glyph7.height) != 0 && glyph7.width != 0) {
                                            this.capHeight = java.lang.Math.max(this.capHeight, i3);
                                        }
                                    }
                                }
                            }
                        } else {
                            this.capHeight = glyph2.height;
                        }
                        float f3 = this.capHeight - f;
                        this.capHeight = f3;
                        float f4 = parseInt2 - f3;
                        this.ascent = f4;
                        float f5 = -this.lineHeight;
                        this.down = f5;
                        if (z) {
                            this.ascent = -f4;
                            this.down = -f5;
                        }
                    }
                    i = 1;
                    this.imagePaths = new java.lang.String[i];
                    while (i2 < i) {
                    }
                    this.descent = 0.0f;
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!readLine.startsWith("char ")) {
                        }
                    }
                    this.descent += this.padBottom;
                    while (true) {
                        readLine2 = bufferedReader.readLine();
                        if (readLine2 != null) {
                            break;
                        }
                        stringTokenizer = new java.util.StringTokenizer(readLine2, " =");
                        stringTokenizer.nextToken();
                        stringTokenizer.nextToken();
                        parseInt = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                        stringTokenizer.nextToken();
                        int parseInt42 = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                        if (parseInt >= 0) {
                            glyph4 = getGlyph((char) parseInt);
                            stringTokenizer.nextToken();
                            int parseInt52 = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                            if (glyph4 == null) {
                            }
                        }
                    }
                    glyph = getGlyph(' ');
                    if (glyph == null) {
                    }
                    if (glyph.width == 0) {
                    }
                    this.spaceWidth = glyph.width;
                    glyph2 = null;
                    glyph3 = null;
                    while (r7 < r3) {
                    }
                    if (glyph3 == null) {
                    }
                    this.xHeight = glyph3.height - f;
                    while (r7 < r3) {
                    }
                    if (glyph2 != null) {
                    }
                    float f32 = this.capHeight - f;
                    this.capHeight = f32;
                    float f42 = parseInt2 - f32;
                    this.ascent = f42;
                    float f52 = -this.lineHeight;
                    this.down = f52;
                    if (z) {
                    }
                } catch (java.lang.Exception e2) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Error loading font file: " + fileHandle, e2);
                }
            } finally {
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(bufferedReader);
            }
        }

        public void scale(float f) {
            setScale(this.scaleX + f, this.scaleY + f);
        }

        public void setGlyph(int i, com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph) {
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[][] glyphArr = this.glyphs;
            int i2 = i / 512;
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[] glyphArr2 = glyphArr[i2];
            if (glyphArr2 == null) {
                glyphArr2 = new com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[512];
                glyphArr[i2] = glyphArr2;
            }
            glyphArr2[i & 511] = glyph;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setGlyphRegion(com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph, com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
            float f;
            float f2;
            com.badlogic.gdx.graphics.Texture texture = textureRegion.getTexture();
            float width = 1.0f / texture.getWidth();
            float height = 1.0f / texture.getHeight();
            float f3 = textureRegion.b;
            float f4 = textureRegion.c;
            float regionWidth = textureRegion.getRegionWidth();
            float regionHeight = textureRegion.getRegionHeight();
            float f5 = 0.0f;
            if (textureRegion instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) {
                com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = (com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) textureRegion;
                f = atlasRegion.offsetX;
                f2 = (atlasRegion.originalHeight - atlasRegion.packedHeight) - atlasRegion.offsetY;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            int i = glyph.srcX;
            float f6 = i;
            int i2 = glyph.width;
            float f7 = i + i2;
            int i3 = glyph.srcY;
            float f8 = i3;
            int i4 = glyph.height;
            float f9 = i3 + i4;
            if (f > 0.0f) {
                f6 -= f;
                if (f6 < 0.0f) {
                    glyph.width = (int) (i2 + f6);
                    glyph.xoffset = (int) (glyph.xoffset - f6);
                    f6 = 0.0f;
                }
                f7 -= f;
                if (f7 > regionWidth) {
                    glyph.width = (int) (glyph.width - (f7 - regionWidth));
                    if (f2 > 0.0f) {
                        float f10 = f8 - f2;
                        if (f10 < 0.0f) {
                            glyph.height = (int) (i4 + f10);
                        } else {
                            f5 = f10;
                        }
                        f9 -= f2;
                        if (f9 > regionHeight) {
                            float f11 = f9 - regionHeight;
                            glyph.height = (int) (glyph.height - f11);
                            glyph.yoffset = (int) (glyph.yoffset + f11);
                            f8 = f5;
                            glyph.u = (f6 * width) + f3;
                            glyph.u2 = f3 + (regionWidth * width);
                            if (this.flipped) {
                                glyph.v = (f8 * height) + f4;
                                glyph.v2 = f4 + (regionHeight * height);
                                return;
                            } else {
                                glyph.v2 = (f8 * height) + f4;
                                glyph.v = f4 + (regionHeight * height);
                                return;
                            }
                        }
                        f8 = f5;
                    }
                    regionHeight = f9;
                    glyph.u = (f6 * width) + f3;
                    glyph.u2 = f3 + (regionWidth * width);
                    if (this.flipped) {
                    }
                }
            }
            regionWidth = f7;
            if (f2 > 0.0f) {
            }
            regionHeight = f9;
            glyph.u = (f6 * width) + f3;
            glyph.u2 = f3 + (regionWidth * width);
            if (this.flipped) {
            }
        }

        public void setLineHeight(float f) {
            float f2 = f * this.scaleY;
            this.lineHeight = f2;
            if (!this.flipped) {
                f2 = -f2;
            }
            this.down = f2;
        }

        public void setScale(float f) {
            setScale(f, f);
        }

        public void setScale(float f, float f2) {
            if (f == 0.0f) {
                throw new java.lang.IllegalArgumentException("scaleX cannot be 0.");
            }
            if (f2 == 0.0f) {
                throw new java.lang.IllegalArgumentException("scaleY cannot be 0.");
            }
            float f3 = f / this.scaleX;
            float f4 = f2 / this.scaleY;
            this.lineHeight *= f4;
            this.spaceWidth *= f3;
            this.xHeight *= f4;
            this.capHeight *= f4;
            this.ascent *= f4;
            this.descent *= f4;
            this.down *= f4;
            this.padTop *= f4;
            this.padLeft *= f4;
            this.padBottom *= f4;
            this.padRight *= f4;
            this.scaleX = f;
            this.scaleY = f2;
        }
    }

    public static class Glyph {
        public boolean fixedWidth;
        public int height;
        public int id;
        public byte[][] kerning;
        public int page = 0;
        public int srcX;
        public int srcY;
        public float u;
        public float u2;
        public float v;
        public float v2;
        public int width;
        public int xadvance;
        public int xoffset;
        public int yoffset;

        public int getKerning(char c) {
            byte[] bArr;
            byte[][] bArr2 = this.kerning;
            if (bArr2 == null || (bArr = bArr2[c >>> '\t']) == null) {
                return 0;
            }
            return bArr[c & 511];
        }

        public void setKerning(int i, int i2) {
            if (this.kerning == null) {
                this.kerning = new byte[128][];
            }
            byte[][] bArr = this.kerning;
            int i3 = i >>> 9;
            byte[] bArr2 = bArr[i3];
            if (bArr2 == null) {
                bArr2 = new byte[512];
                bArr[i3] = bArr2;
            }
            bArr2[i & 511] = (byte) i2;
        }

        public java.lang.String toString() {
            return java.lang.Character.toString((char) this.id);
        }
    }

    public BitmapFont() {
        this(com.badlogic.gdx.Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), com.badlogic.gdx.Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"), false, true);
    }

    public BitmapFont(com.badlogic.gdx.files.FileHandle fileHandle) {
        this(fileHandle, false);
    }

    public BitmapFont(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, boolean z) {
        this(fileHandle, fileHandle2, z, true);
    }

    public BitmapFont(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2, boolean z, boolean z2) {
        this(new com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData(fileHandle, z), new com.badlogic.gdx.graphics.g2d.TextureRegion(new com.badlogic.gdx.graphics.Texture(fileHandle2, false)), z2);
        this.f = true;
    }

    public BitmapFont(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        this(fileHandle, textureRegion, false);
    }

    public BitmapFont(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, boolean z) {
        this(new com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData(fileHandle, z), textureRegion, true);
    }

    public BitmapFont(com.badlogic.gdx.files.FileHandle fileHandle, boolean z) {
        this(new com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData(fileHandle, z), (com.badlogic.gdx.graphics.g2d.TextureRegion) null, true);
    }

    public BitmapFont(com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData, com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, boolean z) {
        this(bitmapFontData, (com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion>) (textureRegion != null ? com.badlogic.gdx.utils.Array.with(textureRegion) : null), z);
    }

    public BitmapFont(com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> array, boolean z) {
        this.d = bitmapFontData.flipped;
        this.a = bitmapFontData;
        this.e = z;
        if (array == null || array.size == 0) {
            int length = bitmapFontData.imagePaths.length;
            this.b = new com.badlogic.gdx.utils.Array<>(length);
            for (int i = 0; i < length; i++) {
                com.badlogic.gdx.files.FileHandle fileHandle = bitmapFontData.fontFile;
                this.b.add(new com.badlogic.gdx.graphics.g2d.TextureRegion(new com.badlogic.gdx.graphics.Texture(fileHandle == null ? com.badlogic.gdx.Gdx.files.internal(bitmapFontData.imagePaths[i]) : com.badlogic.gdx.Gdx.files.getFileHandle(bitmapFontData.imagePaths[i], fileHandle.type()), false)));
            }
            this.f = true;
        } else {
            this.b = array;
            this.f = false;
        }
        this.c = newFontCache();
        load(bitmapFontData);
    }

    public BitmapFont(boolean z) {
        this(com.badlogic.gdx.Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), com.badlogic.gdx.Gdx.files.classpath("com/badlogic/gdx/utils/arial-15.png"), z, true);
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        if (!this.f) {
            return;
        }
        int i = 0;
        while (true) {
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> array = this.b;
            if (i >= array.size) {
                return;
            }
            array.get(i).getTexture().dispose();
            i++;
        }
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout draw(com.badlogic.gdx.graphics.g2d.Batch batch, java.lang.CharSequence charSequence, float f, float f2) {
        this.c.clear();
        com.badlogic.gdx.graphics.g2d.GlyphLayout addText = this.c.addText(charSequence, f, f2);
        this.c.draw(batch);
        return addText;
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout draw(com.badlogic.gdx.graphics.g2d.Batch batch, java.lang.CharSequence charSequence, float f, float f2, float f3, int i, boolean z) {
        this.c.clear();
        com.badlogic.gdx.graphics.g2d.GlyphLayout addText = this.c.addText(charSequence, f, f2, f3, i, z);
        this.c.draw(batch);
        return addText;
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout draw(com.badlogic.gdx.graphics.g2d.Batch batch, java.lang.CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z) {
        this.c.clear();
        com.badlogic.gdx.graphics.g2d.GlyphLayout addText = this.c.addText(charSequence, f, f2, i, i2, f3, i3, z);
        this.c.draw(batch);
        return addText;
    }

    public com.badlogic.gdx.graphics.g2d.GlyphLayout draw(com.badlogic.gdx.graphics.g2d.Batch batch, java.lang.CharSequence charSequence, float f, float f2, int i, int i2, float f3, int i3, boolean z, java.lang.String str) {
        this.c.clear();
        com.badlogic.gdx.graphics.g2d.GlyphLayout addText = this.c.addText(charSequence, f, f2, i, i2, f3, i3, z, str);
        this.c.draw(batch);
        return addText;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, com.badlogic.gdx.graphics.g2d.GlyphLayout glyphLayout, float f, float f2) {
        this.c.clear();
        this.c.addText(glyphLayout, f, f2);
        this.c.draw(batch);
    }

    public float getAscent() {
        return this.a.ascent;
    }

    public com.badlogic.gdx.graphics.g2d.BitmapFontCache getCache() {
        return this.c;
    }

    public float getCapHeight() {
        return this.a.capHeight;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.c.getColor();
    }

    public com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData getData() {
        return this.a;
    }

    public float getDescent() {
        return this.a.descent;
    }

    public float getLineHeight() {
        return this.a.lineHeight;
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion() {
        return this.b.first();
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion(int i) {
        return this.b.get(i);
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> getRegions() {
        return this.b;
    }

    public float getScaleX() {
        return this.a.scaleX;
    }

    public float getScaleY() {
        return this.a.scaleY;
    }

    public float getSpaceWidth() {
        return this.a.spaceWidth;
    }

    public float getXHeight() {
        return this.a.xHeight;
    }

    public boolean isFlipped() {
        return this.d;
    }

    public void load(com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData) {
        for (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph[] glyphArr : bitmapFontData.glyphs) {
            if (glyphArr != null) {
                for (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph : glyphArr) {
                    if (glyph != null) {
                        bitmapFontData.setGlyphRegion(glyph, this.b.get(glyph.page));
                    }
                }
            }
        }
        com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph2 = bitmapFontData.missingGlyph;
        if (glyph2 != null) {
            bitmapFontData.setGlyphRegion(glyph2, this.b.get(glyph2.page));
        }
    }

    public com.badlogic.gdx.graphics.g2d.BitmapFontCache newFontCache() {
        return new com.badlogic.gdx.graphics.g2d.BitmapFontCache(this, this.e);
    }

    public boolean ownsTexture() {
        return this.f;
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.c.getColor().set(f, f2, f3, f4);
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.c.getColor().set(color);
    }

    public void setFixedWidthGlyphs(java.lang.CharSequence charSequence) {
        int i;
        com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData bitmapFontData = this.a;
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph = bitmapFontData.getGlyph(charSequence.charAt(i3));
            if (glyph != null && (i = glyph.xadvance) > i2) {
                i2 = i;
            }
        }
        int length2 = charSequence.length();
        for (int i4 = 0; i4 < length2; i4++) {
            com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph glyph2 = bitmapFontData.getGlyph(charSequence.charAt(i4));
            if (glyph2 != null) {
                glyph2.xoffset += java.lang.Math.round((i2 - glyph2.xadvance) / 2);
                glyph2.xadvance = i2;
                glyph2.kerning = null;
                glyph2.fixedWidth = true;
            }
        }
    }

    public void setOwnsTexture(boolean z) {
        this.f = z;
    }

    public void setUseIntegerPositions(boolean z) {
        this.e = z;
        this.c.setUseIntegerPositions(z);
    }

    public java.lang.String toString() {
        com.badlogic.gdx.files.FileHandle fileHandle = this.a.fontFile;
        return fileHandle != null ? fileHandle.nameWithoutExtension() : super.toString();
    }

    public boolean usesIntegerPositions() {
        return this.e;
    }
}

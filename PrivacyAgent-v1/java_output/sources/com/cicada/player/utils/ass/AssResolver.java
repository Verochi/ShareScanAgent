package com.cicada.player.utils.ass;

/* loaded from: classes31.dex */
public class AssResolver {
    private static final java.lang.String TAG = "AssResolver";
    public static final java.lang.String TEXT_PATTERN = "\\{[^\\{]+\\}";
    public static final java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(TEXT_PATTERN);
    private com.cicada.player.utils.ass.AssHeader mAssHeader;
    private com.cicada.player.utils.ass.TextViewPool mTextViewPool;
    private int videoDisplayWidth = -1;
    private int videoDisplayHeight = -1;

    /* loaded from: classes22.dex */
    public static class ContentAttribute {
        public java.lang.String fontName;
        public double fontSize;
        public int mBackColour;
        public boolean mBold;
        public int mBorderStyle;
        public boolean mItalic;
        public int mOutlineColour;
        public double mOutlineWidth;
        public int mPrimaryColour;
        public int mSecondaryColour;
        public double mShadow;
        public boolean mStrikeOut;
        public boolean mUnderline;
        public java.lang.String overrideStyle;
        public java.lang.String text;

        private ContentAttribute() {
        }

        public /* synthetic */ ContentAttribute(com.cicada.player.utils.ass.AssResolver.AnonymousClass1 anonymousClass1) {
            this();
        }

        public java.lang.String toString() {
            return "ContentAttribute{text='" + this.text + "', overrideStyle='" + this.overrideStyle + "', fontName='" + this.fontName + "', fontSize=" + this.fontSize + ", mPrimaryColour=" + this.mPrimaryColour + ", mSecondaryColour=" + this.mSecondaryColour + ", mBold=" + this.mBold + ", mItalic=" + this.mItalic + ", mUnderline=" + this.mUnderline + ", mStrikeOut=" + this.mStrikeOut + ", mOutlineColour=" + this.mOutlineColour + ", mOutlineWidth=" + this.mOutlineWidth + ", mBorderStyle=" + this.mBorderStyle + ", mBackColour=" + this.mBackColour + ", mShadow=" + this.mShadow + '}';
        }
    }

    /* loaded from: classes22.dex */
    public static class LocationAttribute {
        public int mAlignment;
        public double mAngle;
        public double mScaleX;
        public double mScaleY;
        public int marginL;
        public int marginR;
        public int marginV;
        public double posX;
        public double posY;

        private LocationAttribute() {
        }

        public /* synthetic */ LocationAttribute(com.cicada.player.utils.ass.AssResolver.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public AssResolver(android.content.Context context) {
        this.mTextViewPool = new com.cicada.player.utils.ass.TextViewPool(context);
    }

    private java.lang.String convertRgbColor(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String substring;
        if (str.length() == 8) {
            sb = new java.lang.StringBuilder();
            sb.append(str.substring(6, 8));
            sb.append(str.substring(4, 6));
            substring = str.substring(2, 4);
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(str.substring(4, 6));
            sb.append(str.substring(2, 4));
            substring = str.substring(0, 2);
        }
        sb.append(substring);
        return sb.toString();
    }

    private void fillContentAttribute(com.cicada.player.utils.ass.AssStyle assStyle, java.util.LinkedList<com.cicada.player.utils.ass.AssResolver.ContentAttribute> linkedList, com.cicada.player.utils.ass.AssResolver.LocationAttribute locationAttribute) {
        java.util.Map<java.lang.String, java.lang.Object> parseOverrideStyle;
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            com.cicada.player.utils.ass.AssResolver.ContentAttribute contentAttribute = linkedList.get(i);
            contentAttribute.text = contentAttribute.text.replace("\\N", "\n").replace("\\n", "\n");
            contentAttribute.fontName = assStyle.mFontName;
            contentAttribute.fontSize = scaleYSize(assStyle.mFontSize);
            contentAttribute.mBold = assStyle.mBold == 1;
            contentAttribute.mItalic = assStyle.mItalic == 1;
            contentAttribute.mStrikeOut = assStyle.mStrikeOut == 1;
            contentAttribute.mUnderline = assStyle.mUnderline == 1;
            contentAttribute.mBorderStyle = assStyle.mBorderStyle;
            contentAttribute.mOutlineWidth = scaleYSize(assStyle.mOutline);
            contentAttribute.mShadow = scaleYSize(assStyle.mShadow);
            contentAttribute.mBackColour = rgbaToArgb(assStyle.mBackColour);
            contentAttribute.mOutlineColour = rgbaToArgb(assStyle.mOutlineColour);
            contentAttribute.mPrimaryColour = rgbaToArgb(assStyle.mPrimaryColour);
            contentAttribute.mSecondaryColour = rgbaToArgb(assStyle.mSecondaryColour);
            if (!android.text.TextUtils.isEmpty(contentAttribute.overrideStyle) && (parseOverrideStyle = parseOverrideStyle(contentAttribute.overrideStyle)) != null) {
                if (parseOverrideStyle.containsKey("primaryColour")) {
                    contentAttribute.mPrimaryColour = ((java.lang.Integer) parseOverrideStyle.get("primaryColour")).intValue();
                }
                if (parseOverrideStyle.containsKey("strikeOut")) {
                    contentAttribute.mStrikeOut = ((java.lang.Boolean) parseOverrideStyle.get("strikeOut")).booleanValue();
                }
                if (parseOverrideStyle.containsKey("underline")) {
                    contentAttribute.mUnderline = ((java.lang.Boolean) parseOverrideStyle.get("underline")).booleanValue();
                }
                if (parseOverrideStyle.containsKey("italic")) {
                    contentAttribute.mItalic = ((java.lang.Boolean) parseOverrideStyle.get("italic")).booleanValue();
                }
                if (parseOverrideStyle.containsKey("bold")) {
                    contentAttribute.mBold = ((java.lang.Boolean) parseOverrideStyle.get("bold")).booleanValue();
                }
                if (parseOverrideStyle.containsKey("fontSize")) {
                    contentAttribute.fontSize = scaleYSize(((java.lang.Double) parseOverrideStyle.get("fontSize")).doubleValue());
                }
                if (parseOverrideStyle.containsKey("fontName")) {
                    contentAttribute.fontName = (java.lang.String) parseOverrideStyle.get("fontName");
                }
                if (parseOverrideStyle.containsKey("posX")) {
                    locationAttribute.posX = ((java.lang.Double) parseOverrideStyle.get("posX")).doubleValue();
                }
                if (parseOverrideStyle.containsKey("posY")) {
                    locationAttribute.posY = ((java.lang.Double) parseOverrideStyle.get("posY")).doubleValue();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private android.text.SpannableStringBuilder getFinalStr(java.util.LinkedList<com.cicada.player.utils.ass.AssResolver.ContentAttribute> linkedList) {
        android.text.style.StyleSpan styleSpan;
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        java.util.Iterator<com.cicada.player.utils.ass.AssResolver.ContentAttribute> it = linkedList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            com.cicada.player.utils.ass.AssResolver.ContentAttribute next = it.next();
            i += next.text.length();
            spannableStringBuilder.append((java.lang.CharSequence) next.text);
            if (next.mOutlineWidth > 0.0d) {
                com.cicada.player.utils.ass.BorderedSpan.BorderStyle borderStyle = new com.cicada.player.utils.ass.BorderedSpan.BorderStyle();
                borderStyle.fontName = next.fontName;
                borderStyle.fontSize = next.fontSize;
                borderStyle.mPrimaryColour = next.mPrimaryColour;
                borderStyle.mSecondaryColour = next.mSecondaryColour;
                borderStyle.mBold = next.mBold;
                borderStyle.mItalic = next.mItalic;
                borderStyle.mUnderline = next.mUnderline;
                borderStyle.mStrikeOut = next.mStrikeOut;
                borderStyle.mOutlineColour = next.mOutlineColour;
                borderStyle.mOutlineWidth = next.mOutlineWidth;
                if (next.mBorderStyle == 1) {
                    borderStyle.mShadowWidth = next.mShadow;
                    borderStyle.mShadowColor = next.mBackColour;
                }
                spannableStringBuilder.setSpan(new com.cicada.player.utils.ass.BorderedSpan(borderStyle), i2, i, 33);
            }
            spannableStringBuilder.setSpan(new android.text.style.TypefaceSpan(next.fontName), i2, i, 33);
            spannableStringBuilder.setSpan(new android.text.style.AbsoluteSizeSpan((int) next.fontSize), i2, i, 33);
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(next.mPrimaryColour), i2, i, 33);
            boolean z = next.mBold;
            if (z && next.mItalic) {
                styleSpan = new android.text.style.StyleSpan(3);
            } else if (z) {
                styleSpan = new android.text.style.StyleSpan(1);
            } else {
                if (next.mItalic) {
                    styleSpan = new android.text.style.StyleSpan(2);
                }
                if (next.mUnderline) {
                    spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i2, i, 33);
                }
                if (!next.mStrikeOut) {
                    spannableStringBuilder.setSpan(new android.text.style.StrikethroughSpan(), i2, i, 33);
                }
                i2 += next.text.length();
            }
            spannableStringBuilder.setSpan(styleSpan, i2, i, 33);
            if (next.mUnderline) {
            }
            if (!next.mStrikeOut) {
            }
            i2 += next.text.length();
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x006e. Please report as an issue. */
    private android.widget.RelativeLayout.LayoutParams getLayoutParams(com.cicada.player.utils.ass.AssResolver.LocationAttribute locationAttribute, float f, float f2) {
        int i;
        int scaleXSize;
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        double d = locationAttribute.posX;
        if (d > 0.0d || locationAttribute.posY > 0.0d) {
            int i2 = locationAttribute.mAlignment;
            double scaleXSize2 = scaleXSize(d);
            double scaleYSize = scaleYSize(locationAttribute.posY);
            switch (i2) {
                case 1:
                    layoutParams.leftMargin = (int) scaleXSize2;
                    i = (int) (scaleYSize - f2);
                    break;
                case 2:
                default:
                    f /= 2.0f;
                    scaleXSize2 -= f;
                    layoutParams.leftMargin = (int) scaleXSize2;
                    i = (int) (scaleYSize - f2);
                    break;
                case 3:
                    scaleXSize2 -= f;
                    layoutParams.leftMargin = (int) scaleXSize2;
                    i = (int) (scaleYSize - f2);
                    break;
                case 4:
                    layoutParams.leftMargin = (int) scaleXSize2;
                    f2 /= 2.0f;
                    i = (int) (scaleYSize - f2);
                    break;
                case 5:
                    f /= 2.0f;
                    scaleXSize2 -= f;
                    layoutParams.leftMargin = (int) scaleXSize2;
                    f2 /= 2.0f;
                    i = (int) (scaleYSize - f2);
                    break;
                case 6:
                    scaleXSize2 -= f;
                    layoutParams.leftMargin = (int) scaleXSize2;
                    f2 /= 2.0f;
                    i = (int) (scaleYSize - f2);
                    break;
                case 7:
                    scaleXSize = (int) scaleXSize(scaleXSize2);
                    layoutParams.leftMargin = scaleXSize;
                    i = (int) scaleYSize(scaleYSize);
                    break;
                case 8:
                    f /= 2.0f;
                    scaleXSize = (int) (scaleXSize2 - f);
                    layoutParams.leftMargin = scaleXSize;
                    i = (int) scaleYSize(scaleYSize);
                    break;
                case 9:
                    scaleXSize = (int) (scaleXSize2 - f);
                    layoutParams.leftMargin = scaleXSize;
                    i = (int) scaleYSize(scaleYSize);
                    break;
            }
        } else {
            switch (locationAttribute.mAlignment) {
                case 1:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case 2:
                default:
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case 4:
                    layoutParams.addRule(15);
                    layoutParams.addRule(9);
                    break;
                case 5:
                    layoutParams.addRule(13);
                    break;
                case 6:
                    layoutParams.addRule(15);
                    layoutParams.addRule(11);
                    break;
                case 7:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 8:
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case 9:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            layoutParams.leftMargin = locationAttribute.marginL;
            layoutParams.rightMargin = locationAttribute.marginR;
            i = locationAttribute.marginV;
        }
        layoutParams.topMargin = i;
        return layoutParams;
    }

    private com.cicada.player.utils.ass.AssResolver.LocationAttribute getLocationAttribute(com.cicada.player.utils.ass.AssDialogue assDialogue, com.cicada.player.utils.ass.AssStyle assStyle) {
        com.cicada.player.utils.ass.AssResolver.LocationAttribute locationAttribute = new com.cicada.player.utils.ass.AssResolver.LocationAttribute(null);
        locationAttribute.mAlignment = assStyle.mAlignment;
        locationAttribute.marginL = assStyle.mMarginL;
        locationAttribute.marginR = assStyle.mMarginR;
        locationAttribute.marginV = assStyle.mMarginV;
        int i = assDialogue.mMarginL;
        if (i != 0) {
            locationAttribute.marginL = i;
        }
        int i2 = assDialogue.mMarginR;
        if (i2 != 0) {
            locationAttribute.marginR = i2;
        }
        int i3 = assDialogue.mMarginV;
        if (i3 != 0) {
            locationAttribute.marginV = i3;
        }
        locationAttribute.mAngle = assStyle.mAngle;
        locationAttribute.mScaleX = assStyle.mScaleX;
        locationAttribute.mScaleY = assStyle.mScaleY;
        return locationAttribute;
    }

    private java.util.Map<java.lang.String, java.lang.Object> parseOverrideStyle(java.lang.String str) {
        java.lang.StringBuilder sb;
        java.lang.String substring;
        java.lang.Object valueOf;
        java.lang.String str2;
        java.lang.String replaceAll = str.substring(str.indexOf("{") + 1, str.lastIndexOf(com.alipay.sdk.m.u.i.d)).replaceAll("\\\\", "\\$");
        if (!replaceAll.contains("$")) {
            return null;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str3 : replaceAll.split("\\$")) {
            if (str3.startsWith("fn")) {
                valueOf = str3.substring(2).trim();
                str2 = "fontName";
            } else {
                if (str3.startsWith(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_SIZE)) {
                    try {
                        hashMap.put("fontSize", java.lang.Double.valueOf(str3.substring(2).trim()));
                    } catch (java.lang.Exception unused) {
                    }
                } else if (str3.startsWith("b")) {
                    valueOf = java.lang.Boolean.valueOf(str3.startsWith("b1"));
                    str2 = "bold";
                } else if (str3.startsWith("i")) {
                    valueOf = java.lang.Boolean.valueOf(str3.startsWith("i1"));
                    str2 = "italic";
                } else if (str3.startsWith(com.umeng.analytics.pro.bo.aN)) {
                    valueOf = java.lang.Boolean.valueOf(str3.startsWith("u1"));
                    str2 = "underline";
                } else if (str3.startsWith("s")) {
                    valueOf = java.lang.Boolean.valueOf(str3.startsWith(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1));
                    str2 = "strikeOut";
                } else if (str3.startsWith("c&H") || str3.startsWith("1c&H")) {
                    java.lang.String trim = str3.substring(0, str3.lastIndexOf("&")).trim();
                    if (trim.startsWith("c&H")) {
                        sb = new java.lang.StringBuilder();
                        sb.append("#");
                        substring = trim.substring(3);
                    } else {
                        sb = new java.lang.StringBuilder();
                        sb.append("#");
                        substring = trim.substring(4);
                    }
                    sb.append(convertRgbColor(substring.trim()));
                    valueOf = java.lang.Integer.valueOf(android.graphics.Color.parseColor(sb.toString()));
                    str2 = "primaryColour";
                } else if (str3.startsWith("pos")) {
                    java.lang.String[] split = str3.substring(4, str3.length() - 1).split(",");
                    hashMap.put("posX", java.lang.Double.valueOf(split[0]));
                    valueOf = java.lang.Double.valueOf(split[1]);
                    str2 = "posY";
                }
            }
            hashMap.put(str2, valueOf);
        }
        return hashMap;
    }

    private int rgbaToArgb(int i) {
        return android.graphics.Color.parseColor("#" + java.lang.String.format("%02x", java.lang.Integer.valueOf(255 - (i & 255))) + java.lang.String.format("%06x", java.lang.Integer.valueOf(i >>> 8)));
    }

    private double scaleXSize(double d) {
        int i;
        int i2 = this.videoDisplayWidth;
        return (i2 <= 0 || (i = this.mAssHeader.mPlayResX) <= 0) ? d : (d * i2) / i;
    }

    private double scaleYSize(double d) {
        int i;
        int i2 = this.videoDisplayHeight;
        return (i2 <= 0 || (i = this.mAssHeader.mPlayResY) <= 0) ? d : (d * i2) / i;
    }

    private java.util.LinkedList<com.cicada.player.utils.ass.AssResolver.ContentAttribute> splitContent(com.cicada.player.utils.ass.AssDialogue assDialogue) {
        com.cicada.player.utils.ass.AssResolver.ContentAttribute contentAttribute;
        java.util.LinkedList<com.cicada.player.utils.ass.AssResolver.ContentAttribute> linkedList = new java.util.LinkedList<>();
        java.util.regex.Matcher matcher = pattern.matcher(assDialogue.mText);
        if (matcher.find()) {
            java.lang.String[] split = assDialogue.mText.split(TEXT_PATTERN, -1);
            for (int i = 0; i < split.length; i++) {
                if (android.text.TextUtils.isEmpty(split[i])) {
                    contentAttribute = null;
                } else {
                    contentAttribute = new com.cicada.player.utils.ass.AssResolver.ContentAttribute(null);
                    contentAttribute.text = split[i];
                }
                if (i != 0) {
                    java.lang.String group = matcher.group();
                    if (contentAttribute != null) {
                        contentAttribute.overrideStyle = group;
                    }
                }
                if (contentAttribute != null) {
                    linkedList.add(contentAttribute);
                }
            }
        } else {
            com.cicada.player.utils.ass.AssResolver.ContentAttribute contentAttribute2 = new com.cicada.player.utils.ass.AssResolver.ContentAttribute(null);
            contentAttribute2.text = assDialogue.mText;
            linkedList.add(contentAttribute2);
        }
        return linkedList;
    }

    public void destroy() {
    }

    public void dismiss(com.cicada.player.utils.ass.AssTextView assTextView) {
        com.cicada.player.utils.ass.TextViewPool textViewPool = this.mTextViewPool;
        if (textViewPool != null) {
            textViewPool.recycle(assTextView);
        }
    }

    public com.cicada.player.utils.ass.AssTextView setAssDialog(java.lang.String str) {
        com.cicada.player.utils.ass.AssTextView obtain = this.mTextViewPool.obtain();
        obtain.setContent(str);
        com.cicada.player.utils.ass.AssDialogue parseAssDialogue = com.cicada.player.utils.ass.AssUtils.parseAssDialogue(this.mAssHeader, str);
        com.cicada.player.utils.ass.AssStyle assStyle = this.mAssHeader.mStyles.get(parseAssDialogue.mStyle.replace("*", ""));
        if (parseAssDialogue.mText.contains("{\\p0}")) {
            return obtain;
        }
        java.util.LinkedList<com.cicada.player.utils.ass.AssResolver.ContentAttribute> splitContent = splitContent(parseAssDialogue);
        com.cicada.player.utils.ass.AssResolver.LocationAttribute locationAttribute = getLocationAttribute(parseAssDialogue, assStyle);
        fillContentAttribute(assStyle, splitContent, locationAttribute);
        obtain.setText(getFinalStr(splitContent), android.widget.TextView.BufferType.SPANNABLE);
        obtain.setScaleX((float) locationAttribute.mScaleX);
        obtain.setScaleY((float) locationAttribute.mScaleY);
        obtain.setRotation((float) locationAttribute.mAngle);
        obtain.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        float measuredWidth = obtain.getMeasuredWidth();
        float measuredHeight = obtain.getMeasuredHeight();
        android.widget.RelativeLayout.LayoutParams layoutParams = getLayoutParams(locationAttribute, measuredWidth, measuredHeight);
        layoutParams.width = (int) measuredWidth;
        layoutParams.height = (int) measuredHeight;
        obtain.setLayoutParams(layoutParams);
        obtain.setGravity(17);
        return obtain;
    }

    public void setAssHeaders(java.lang.String str) {
        this.mAssHeader = com.cicada.player.utils.ass.AssUtils.parseAssHeader(str);
    }

    public void setFontTypeMap(java.util.Map<java.lang.String, android.graphics.Typeface> map) {
    }

    public void setVideoDisplaySize(int i, int i2) {
        this.videoDisplayWidth = i;
        this.videoDisplayHeight = i2;
    }
}

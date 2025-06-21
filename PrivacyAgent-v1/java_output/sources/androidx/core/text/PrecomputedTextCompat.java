package androidx.core.text;

/* loaded from: classes.dex */
public class PrecomputedTextCompat implements android.text.Spannable {
    private static final char LINE_FEED = '\n';

    @androidx.annotation.NonNull
    @androidx.annotation.GuardedBy("sLock")
    private static java.util.concurrent.Executor sExecutor;
    private static final java.lang.Object sLock = new java.lang.Object();

    @androidx.annotation.NonNull
    private final int[] mParagraphEnds;

    @androidx.annotation.NonNull
    private final androidx.core.text.PrecomputedTextCompat.Params mParams;

    @androidx.annotation.NonNull
    private final android.text.Spannable mText;

    @androidx.annotation.Nullable
    private final android.text.PrecomputedText mWrapped;

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;

        @androidx.annotation.NonNull
        private final android.text.TextPaint mPaint;

        @androidx.annotation.Nullable
        private final android.text.TextDirectionHeuristic mTextDir;
        final android.text.PrecomputedText.Params mWrapped;

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;

            @androidx.annotation.NonNull
            private final android.text.TextPaint mPaint;
            private android.text.TextDirectionHeuristic mTextDir;

            public Builder(@androidx.annotation.NonNull android.text.TextPaint textPaint) {
                this.mPaint = textPaint;
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    this.mBreakStrategy = 1;
                    this.mHyphenationFrequency = 1;
                } else {
                    this.mHyphenationFrequency = 0;
                    this.mBreakStrategy = 0;
                }
                this.mTextDir = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @androidx.annotation.NonNull
            public androidx.core.text.PrecomputedTextCompat.Params build() {
                return new androidx.core.text.PrecomputedTextCompat.Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            @androidx.annotation.RequiresApi(23)
            public androidx.core.text.PrecomputedTextCompat.Params.Builder setBreakStrategy(int i) {
                this.mBreakStrategy = i;
                return this;
            }

            @androidx.annotation.RequiresApi(23)
            public androidx.core.text.PrecomputedTextCompat.Params.Builder setHyphenationFrequency(int i) {
                this.mHyphenationFrequency = i;
                return this;
            }

            @androidx.annotation.RequiresApi(18)
            public androidx.core.text.PrecomputedTextCompat.Params.Builder setTextDirection(@androidx.annotation.NonNull android.text.TextDirectionHeuristic textDirectionHeuristic) {
                this.mTextDir = textDirectionHeuristic;
                return this;
            }
        }

        @androidx.annotation.RequiresApi(28)
        public Params(@androidx.annotation.NonNull android.text.PrecomputedText.Params params) {
            android.text.TextPaint textPaint;
            android.text.TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.mPaint = textPaint;
            textDirection = params.getTextDirection();
            this.mTextDir = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.mBreakStrategy = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.mHyphenationFrequency = hyphenationFrequency;
            this.mWrapped = android.os.Build.VERSION.SDK_INT < 29 ? null : params;
        }

        @android.annotation.SuppressLint({"NewApi"})
        public Params(@androidx.annotation.NonNull android.text.TextPaint textPaint, @androidx.annotation.NonNull android.text.TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            android.text.PrecomputedText.Params.Builder breakStrategy;
            android.text.PrecomputedText.Params.Builder hyphenationFrequency;
            android.text.PrecomputedText.Params.Builder textDirection;
            android.text.PrecomputedText.Params build;
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                breakStrategy = new android.text.PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(i2);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                build = textDirection.build();
                this.mWrapped = build;
            } else {
                this.mWrapped = null;
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = i;
            this.mHyphenationFrequency = i2;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof androidx.core.text.PrecomputedTextCompat.Params)) {
                return false;
            }
            androidx.core.text.PrecomputedTextCompat.Params params = (androidx.core.text.PrecomputedTextCompat.Params) obj;
            return equalsWithoutTextDirection(params) && this.mTextDir == params.getTextDirection();
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params) {
            android.os.LocaleList textLocales;
            android.os.LocaleList textLocales2;
            boolean equals;
            int i = android.os.Build.VERSION.SDK_INT;
            if ((i >= 23 && (this.mBreakStrategy != params.getBreakStrategy() || this.mHyphenationFrequency != params.getHyphenationFrequency())) || this.mPaint.getTextSize() != params.getTextPaint().getTextSize() || this.mPaint.getTextScaleX() != params.getTextPaint().getTextScaleX() || this.mPaint.getTextSkewX() != params.getTextPaint().getTextSkewX() || this.mPaint.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !android.text.TextUtils.equals(this.mPaint.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()) || this.mPaint.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i >= 24) {
                textLocales = this.mPaint.getTextLocales();
                textLocales2 = params.getTextPaint().getTextLocales();
                equals = textLocales.equals(textLocales2);
                if (!equals) {
                    return false;
                }
            } else if (!this.mPaint.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            return this.mPaint.getTypeface() == null ? params.getTextPaint().getTypeface() == null : this.mPaint.getTypeface().equals(params.getTextPaint().getTypeface());
        }

        @androidx.annotation.RequiresApi(23)
        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        @androidx.annotation.RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RequiresApi(18)
        public android.text.TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        @androidx.annotation.NonNull
        public android.text.TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            android.os.LocaleList textLocales;
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return androidx.core.util.ObjectsCompat.hash(java.lang.Float.valueOf(this.mPaint.getTextSize()), java.lang.Float.valueOf(this.mPaint.getTextScaleX()), java.lang.Float.valueOf(this.mPaint.getTextSkewX()), java.lang.Float.valueOf(this.mPaint.getLetterSpacing()), java.lang.Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), java.lang.Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, java.lang.Integer.valueOf(this.mBreakStrategy), java.lang.Integer.valueOf(this.mHyphenationFrequency));
            }
            textLocales = this.mPaint.getTextLocales();
            return androidx.core.util.ObjectsCompat.hash(java.lang.Float.valueOf(this.mPaint.getTextSize()), java.lang.Float.valueOf(this.mPaint.getTextScaleX()), java.lang.Float.valueOf(this.mPaint.getTextSkewX()), java.lang.Float.valueOf(this.mPaint.getLetterSpacing()), java.lang.Integer.valueOf(this.mPaint.getFlags()), textLocales, this.mPaint.getTypeface(), java.lang.Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, java.lang.Integer.valueOf(this.mBreakStrategy), java.lang.Integer.valueOf(this.mHyphenationFrequency));
        }

        public java.lang.String toString() {
            java.lang.String fontVariationSettings;
            android.os.LocaleList textLocales;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("{");
            sb.append("textSize=" + this.mPaint.getTextSize());
            sb.append(", textScaleX=" + this.mPaint.getTextScaleX());
            sb.append(", textSkewX=" + this.mPaint.getTextSkewX());
            int i = android.os.Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            if (i >= 24) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(", textLocale=");
                textLocales = this.mPaint.getTextLocales();
                sb2.append(textLocales);
                sb.append(sb2.toString());
            } else {
                sb.append(", textLocale=" + this.mPaint.getTextLocale());
            }
            sb.append(", typeface=" + this.mPaint.getTypeface());
            if (i >= 26) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(", variationSettings=");
                fontVariationSettings = this.mPaint.getFontVariationSettings();
                sb3.append(fontVariationSettings);
                sb.append(sb3.toString());
            }
            sb.append(", textDir=" + this.mTextDir);
            sb.append(", breakStrategy=" + this.mBreakStrategy);
            sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }
    }

    public static class PrecomputedTextFutureTask extends java.util.concurrent.FutureTask<androidx.core.text.PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements java.util.concurrent.Callable<androidx.core.text.PrecomputedTextCompat> {
            private androidx.core.text.PrecomputedTextCompat.Params mParams;
            private java.lang.CharSequence mText;

            public PrecomputedTextCallback(@androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
                this.mParams = params;
                this.mText = charSequence;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public androidx.core.text.PrecomputedTextCompat call() throws java.lang.Exception {
                return androidx.core.text.PrecomputedTextCompat.create(this.mText, this.mParams);
            }
        }

        public PrecomputedTextFutureTask(@androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
            super(new androidx.core.text.PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback(params, charSequence));
        }
    }

    @androidx.annotation.RequiresApi(28)
    private PrecomputedTextCompat(@androidx.annotation.NonNull android.text.PrecomputedText precomputedText, @androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params) {
        this.mText = precomputedText;
        this.mParams = params;
        this.mParagraphEnds = null;
        this.mWrapped = android.os.Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    private PrecomputedTextCompat(@androidx.annotation.NonNull java.lang.CharSequence charSequence, @androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params, @androidx.annotation.NonNull int[] iArr) {
        this.mText = new android.text.SpannableString(charSequence);
        this.mParams = params;
        this.mParagraphEnds = iArr;
        this.mWrapped = null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static androidx.core.text.PrecomputedTextCompat create(@androidx.annotation.NonNull java.lang.CharSequence charSequence, @androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params) {
        android.text.StaticLayout.Builder obtain;
        android.text.StaticLayout.Builder breakStrategy;
        android.text.StaticLayout.Builder hyphenationFrequency;
        android.text.StaticLayout.Builder textDirection;
        android.text.PrecomputedText.Params params2;
        android.text.PrecomputedText create;
        androidx.core.util.Preconditions.checkNotNull(charSequence);
        androidx.core.util.Preconditions.checkNotNull(params);
        try {
            androidx.core.os.TraceCompat.beginSection("PrecomputedText");
            if (android.os.Build.VERSION.SDK_INT >= 29 && (params2 = params.mWrapped) != null) {
                create = android.text.PrecomputedText.create(charSequence, params2);
                return new androidx.core.text.PrecomputedTextCompat(create, params);
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = android.text.TextUtils.indexOf(charSequence, LINE_FEED, i, length);
                i = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(java.lang.Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((java.lang.Integer) arrayList.get(i2)).intValue();
            }
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                obtain = android.text.StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE);
                breakStrategy = obtain.setBreakStrategy(params.getBreakStrategy());
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(params.getHyphenationFrequency());
                textDirection = hyphenationFrequency.setTextDirection(params.getTextDirection());
                textDirection.build();
            } else {
                new android.text.StaticLayout(charSequence, params.getTextPaint(), Integer.MAX_VALUE, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new androidx.core.text.PrecomputedTextCompat(charSequence, params, iArr);
        } finally {
            androidx.core.os.TraceCompat.endSection();
        }
    }

    @androidx.annotation.UiThread
    public static java.util.concurrent.Future<androidx.core.text.PrecomputedTextCompat> getTextFuture(@androidx.annotation.NonNull java.lang.CharSequence charSequence, @androidx.annotation.NonNull androidx.core.text.PrecomputedTextCompat.Params params, @androidx.annotation.Nullable java.util.concurrent.Executor executor) {
        androidx.core.text.PrecomputedTextCompat.PrecomputedTextFutureTask precomputedTextFutureTask = new androidx.core.text.PrecomputedTextCompat.PrecomputedTextFutureTask(params, charSequence);
        if (executor == null) {
            synchronized (sLock) {
                if (sExecutor == null) {
                    sExecutor = java.util.concurrent.Executors.newFixedThreadPool(1);
                }
                executor = sExecutor;
            }
        }
        executor.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.mText.charAt(i);
    }

    @androidx.annotation.IntRange(from = 0)
    @android.annotation.SuppressLint({"NewApi"})
    public int getParagraphCount() {
        int paragraphCount;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return this.mParagraphEnds.length;
        }
        paragraphCount = this.mWrapped.getParagraphCount();
        return paragraphCount;
    }

    @androidx.annotation.IntRange(from = 0)
    @android.annotation.SuppressLint({"NewApi"})
    public int getParagraphEnd(@androidx.annotation.IntRange(from = 0) int i) {
        int paragraphEnd;
        androidx.core.util.Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return this.mParagraphEnds[i];
        }
        paragraphEnd = this.mWrapped.getParagraphEnd(i);
        return paragraphEnd;
    }

    @androidx.annotation.IntRange(from = 0)
    @android.annotation.SuppressLint({"NewApi"})
    public int getParagraphStart(@androidx.annotation.IntRange(from = 0) int i) {
        int paragraphStart;
        androidx.core.util.Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            paragraphStart = this.mWrapped.getParagraphStart(i);
            return paragraphStart;
        }
        if (i == 0) {
            return 0;
        }
        return this.mParagraphEnds[i - 1];
    }

    @androidx.annotation.NonNull
    public androidx.core.text.PrecomputedTextCompat.Params getParams() {
        return this.mParams;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(28)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.text.PrecomputedText getPrecomputedText() {
        android.text.Spannable spannable = this.mText;
        if (spannable instanceof android.text.PrecomputedText) {
            return (android.text.PrecomputedText) spannable;
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(java.lang.Object obj) {
        return this.mText.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(java.lang.Object obj) {
        return this.mText.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(java.lang.Object obj) {
        return this.mText.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @android.annotation.SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, java.lang.Class<T> cls) {
        java.lang.Object[] spans;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return (T[]) this.mText.getSpans(i, i2, cls);
        }
        spans = this.mWrapped.getSpans(i, i2, cls);
        return (T[]) spans;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, java.lang.Class cls) {
        return this.mText.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    @android.annotation.SuppressLint({"NewApi"})
    public void removeSpan(java.lang.Object obj) {
        if (obj instanceof android.text.style.MetricAffectingSpan) {
            throw new java.lang.IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.removeSpan(obj);
        } else {
            this.mText.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @android.annotation.SuppressLint({"NewApi"})
    public void setSpan(java.lang.Object obj, int i, int i2, int i3) {
        if (obj instanceof android.text.style.MetricAffectingSpan) {
            throw new java.lang.IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.setSpan(obj, i, i2, i3);
        } else {
            this.mText.setSpan(obj, i, i2, i3);
        }
    }

    @Override // java.lang.CharSequence
    public java.lang.CharSequence subSequence(int i, int i2) {
        return this.mText.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return this.mText.toString();
    }
}

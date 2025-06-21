package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class I18NBundle {
    public static final java.util.Locale e = new java.util.Locale("", "", "");
    public static boolean f = false;
    public static boolean g = true;
    public com.badlogic.gdx.utils.I18NBundle a;
    public java.util.Locale b;
    public com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.String> c;
    public com.badlogic.gdx.utils.TextFormatter d;

    public static boolean a(com.badlogic.gdx.files.FileHandle fileHandle) {
        try {
            fileHandle.read().close();
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        throw new java.util.MissingResourceException("Can't find bundle for base file handle " + r9.path() + ", locale " + r10, r9 + "_" + r10, "");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.badlogic.gdx.utils.I18NBundle b(com.badlogic.gdx.files.FileHandle fileHandle, java.util.Locale locale, java.lang.String str) {
        com.badlogic.gdx.utils.I18NBundle f2;
        com.badlogic.gdx.utils.I18NBundle i18NBundle = null;
        if (fileHandle == null) {
            throw null;
        }
        if (locale == null) {
            throw null;
        }
        if (str == null) {
            throw null;
        }
        java.util.Locale locale2 = locale;
        do {
            java.util.List<java.util.Locale> c = c(locale2);
            f2 = f(fileHandle, str, c, 0, i18NBundle);
            if (f2 != null) {
                java.util.Locale locale3 = f2.getLocale();
                boolean equals = locale3.equals(e);
                if (!equals || locale3.equals(locale) || (c.size() == 1 && locale3.equals(c.get(0)))) {
                    break;
                }
                if (equals && i18NBundle == null) {
                    i18NBundle = f2;
                }
            }
            locale2 = d(locale2);
        } while (locale2 != null);
        return f2;
    }

    public static java.util.List<java.util.Locale> c(java.util.Locale locale) {
        java.lang.String language = locale.getLanguage();
        java.lang.String country = locale.getCountry();
        java.lang.String variant = locale.getVariant();
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        if (variant.length() > 0) {
            arrayList.add(locale);
        }
        if (country.length() > 0) {
            arrayList.add(arrayList.size() == 0 ? locale : new java.util.Locale(language, country));
        }
        if (language.length() > 0) {
            if (arrayList.size() != 0) {
                locale = new java.util.Locale(language);
            }
            arrayList.add(locale);
        }
        arrayList.add(e);
        return arrayList;
    }

    public static com.badlogic.gdx.utils.I18NBundle createBundle(com.badlogic.gdx.files.FileHandle fileHandle) {
        return b(fileHandle, java.util.Locale.getDefault(), "UTF-8");
    }

    public static com.badlogic.gdx.utils.I18NBundle createBundle(com.badlogic.gdx.files.FileHandle fileHandle, java.lang.String str) {
        return b(fileHandle, java.util.Locale.getDefault(), str);
    }

    public static com.badlogic.gdx.utils.I18NBundle createBundle(com.badlogic.gdx.files.FileHandle fileHandle, java.util.Locale locale) {
        return b(fileHandle, locale, "UTF-8");
    }

    public static com.badlogic.gdx.utils.I18NBundle createBundle(com.badlogic.gdx.files.FileHandle fileHandle, java.util.Locale locale, java.lang.String str) {
        return b(fileHandle, locale, str);
    }

    public static java.util.Locale d(java.util.Locale locale) {
        java.util.Locale locale2 = java.util.Locale.getDefault();
        if (locale.equals(locale2)) {
            return null;
        }
        return locale2;
    }

    public static com.badlogic.gdx.utils.I18NBundle e(com.badlogic.gdx.files.FileHandle fileHandle, java.lang.String str, java.util.Locale locale) {
        com.badlogic.gdx.utils.I18NBundle i18NBundle;
        java.io.Reader reader = null;
        try {
            try {
                com.badlogic.gdx.files.FileHandle h = h(fileHandle, locale);
                if (a(h)) {
                    i18NBundle = new com.badlogic.gdx.utils.I18NBundle();
                    reader = h.reader(str);
                    i18NBundle.load(reader);
                } else {
                    i18NBundle = null;
                }
                if (i18NBundle != null) {
                    i18NBundle.g(locale);
                }
                return i18NBundle;
            } catch (java.io.IOException e2) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException(e2);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(reader);
        }
    }

    public static com.badlogic.gdx.utils.I18NBundle f(com.badlogic.gdx.files.FileHandle fileHandle, java.lang.String str, java.util.List<java.util.Locale> list, int i, com.badlogic.gdx.utils.I18NBundle i18NBundle) {
        com.badlogic.gdx.utils.I18NBundle i18NBundle2;
        java.util.Locale locale = list.get(i);
        if (i != list.size() - 1) {
            i18NBundle2 = f(fileHandle, str, list, i + 1, i18NBundle);
        } else {
            if (i18NBundle != null && locale.equals(e)) {
                return i18NBundle;
            }
            i18NBundle2 = null;
        }
        com.badlogic.gdx.utils.I18NBundle e2 = e(fileHandle, str, locale);
        if (e2 == null) {
            return i18NBundle2;
        }
        e2.a = i18NBundle2;
        return e2;
    }

    public static boolean getExceptionOnMissingKey() {
        return g;
    }

    public static boolean getSimpleFormatter() {
        return f;
    }

    public static com.badlogic.gdx.files.FileHandle h(com.badlogic.gdx.files.FileHandle fileHandle, java.util.Locale locale) {
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(fileHandle.name());
        if (!locale.equals(e)) {
            java.lang.String language = locale.getLanguage();
            java.lang.String country = locale.getCountry();
            java.lang.String variant = locale.getVariant();
            boolean equals = "".equals(language);
            boolean equals2 = "".equals(country);
            boolean equals3 = "".equals(variant);
            if (!equals || !equals2 || !equals3) {
                stringBuilder.append('_');
                if (!equals3) {
                    stringBuilder.append(language).append('_').append(country).append('_').append(variant);
                } else if (equals2) {
                    stringBuilder.append(language);
                } else {
                    stringBuilder.append(language).append('_').append(country);
                }
            }
        }
        return fileHandle.sibling(stringBuilder.append(".properties").toString());
    }

    public static void setExceptionOnMissingKey(boolean z) {
        g = z;
    }

    public static void setSimpleFormatter(boolean z) {
        f = z;
    }

    public java.lang.String format(java.lang.String str, java.lang.Object... objArr) {
        return this.d.a(get(str), objArr);
    }

    public final void g(java.util.Locale locale) {
        this.b = locale;
        this.d = new com.badlogic.gdx.utils.TextFormatter(locale, !f);
    }

    public final java.lang.String get(java.lang.String str) {
        java.lang.String str2 = this.c.get(str);
        if (str2 == null) {
            com.badlogic.gdx.utils.I18NBundle i18NBundle = this.a;
            if (i18NBundle != null) {
                str2 = i18NBundle.get(str);
            }
            if (str2 == null) {
                if (g) {
                    throw new java.util.MissingResourceException("Can't find bundle key " + str, getClass().getName(), str);
                }
                return "???" + str + "???";
            }
        }
        return str2;
    }

    public java.util.Locale getLocale() {
        return this.b;
    }

    public void load(java.io.Reader reader) throws java.io.IOException {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.String> objectMap = new com.badlogic.gdx.utils.ObjectMap<>();
        this.c = objectMap;
        com.badlogic.gdx.utils.PropertiesUtils.load(objectMap, reader);
    }
}

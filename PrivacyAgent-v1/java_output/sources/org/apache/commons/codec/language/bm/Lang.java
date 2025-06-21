package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public class Lang {
    public static final java.util.Map<org.apache.commons.codec.language.bm.NameType, org.apache.commons.codec.language.bm.Lang> c = new java.util.EnumMap(org.apache.commons.codec.language.bm.NameType.class);
    public final org.apache.commons.codec.language.bm.Languages a;
    public final java.util.List<org.apache.commons.codec.language.bm.Lang.LangRule> b;

    public static final class LangRule {
        public final boolean a;
        public final java.util.Set<java.lang.String> b;
        public final java.util.regex.Pattern c;

        public LangRule(java.util.regex.Pattern pattern, java.util.Set<java.lang.String> set, boolean z) {
            this.c = pattern;
            this.b = set;
            this.a = z;
        }

        public /* synthetic */ LangRule(java.util.regex.Pattern pattern, java.util.Set set, boolean z, org.apache.commons.codec.language.bm.Lang.AnonymousClass1 anonymousClass1) {
            this(pattern, set, z);
        }

        public boolean c(java.lang.String str) {
            return this.c.matcher(str).find();
        }
    }

    static {
        for (org.apache.commons.codec.language.bm.NameType nameType : org.apache.commons.codec.language.bm.NameType.values()) {
            c.put(nameType, loadFromResource("org/apache/commons/codec/language/bm/lang.txt", org.apache.commons.codec.language.bm.Languages.getInstance(nameType)));
        }
    }

    public Lang(java.util.List<org.apache.commons.codec.language.bm.Lang.LangRule> list, org.apache.commons.codec.language.bm.Languages languages) {
        this.b = java.util.Collections.unmodifiableList(list);
        this.a = languages;
    }

    public static org.apache.commons.codec.language.bm.Lang instance(org.apache.commons.codec.language.bm.NameType nameType) {
        return c.get(nameType);
    }

    public static org.apache.commons.codec.language.bm.Lang loadFromResource(java.lang.String str, org.apache.commons.codec.language.bm.Languages languages) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.InputStream resourceAsStream = org.apache.commons.codec.language.bm.Lang.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new java.lang.IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt");
        }
        java.util.Scanner scanner = new java.util.Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                java.lang.String nextLine = scanner.nextLine();
                if (z) {
                    if (nextLine.endsWith("*/")) {
                        break;
                    }
                } else if (nextLine.startsWith("/*")) {
                    z = true;
                } else {
                    int indexOf = nextLine.indexOf("//");
                    java.lang.String trim = (indexOf >= 0 ? nextLine.substring(0, indexOf) : nextLine).trim();
                    if (trim.length() != 0) {
                        java.lang.String[] split = trim.split("\\s+");
                        if (split.length != 3) {
                            java.lang.System.err.println("Warning: malformed line '" + nextLine + "'");
                        } else {
                            arrayList.add(new org.apache.commons.codec.language.bm.Lang.LangRule(java.util.regex.Pattern.compile(split[0]), new java.util.HashSet(java.util.Arrays.asList(split[1].split("\\+"))), split[2].equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE), null));
                        }
                    }
                }
            }
            return new org.apache.commons.codec.language.bm.Lang(arrayList, languages);
        }
    }

    public java.lang.String guessLanguage(java.lang.String str) {
        org.apache.commons.codec.language.bm.Languages.LanguageSet guessLanguages = guessLanguages(str);
        return guessLanguages.isSingleton() ? guessLanguages.getAny() : org.apache.commons.codec.language.bm.Languages.ANY;
    }

    public org.apache.commons.codec.language.bm.Languages.LanguageSet guessLanguages(java.lang.String str) {
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
        java.util.HashSet hashSet = new java.util.HashSet(this.a.getLanguages());
        for (org.apache.commons.codec.language.bm.Lang.LangRule langRule : this.b) {
            if (langRule.c(lowerCase)) {
                if (langRule.a) {
                    hashSet.retainAll(langRule.b);
                } else {
                    hashSet.removeAll(langRule.b);
                }
            }
        }
        org.apache.commons.codec.language.bm.Languages.LanguageSet from = org.apache.commons.codec.language.bm.Languages.LanguageSet.from(hashSet);
        return from.equals(org.apache.commons.codec.language.bm.Languages.NO_LANGUAGES) ? org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE : from;
    }
}

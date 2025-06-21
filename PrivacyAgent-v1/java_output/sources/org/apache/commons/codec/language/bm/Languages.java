package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public class Languages {
    public static final java.lang.String ANY = "any";
    public static final org.apache.commons.codec.language.bm.Languages.LanguageSet ANY_LANGUAGE;
    public static final org.apache.commons.codec.language.bm.Languages.LanguageSet NO_LANGUAGES;
    public static final java.util.Map<org.apache.commons.codec.language.bm.NameType, org.apache.commons.codec.language.bm.Languages> b = new java.util.EnumMap(org.apache.commons.codec.language.bm.NameType.class);
    public final java.util.Set<java.lang.String> a;

    /* renamed from: org.apache.commons.codec.language.bm.Languages$1, reason: invalid class name */
    public static class AnonymousClass1 extends org.apache.commons.codec.language.bm.Languages.LanguageSet {
        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(java.lang.String str) {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public java.lang.String getAny() {
            throw new java.util.NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return true;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public org.apache.commons.codec.language.bm.Languages.LanguageSet restrictTo(org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
            return this;
        }

        public java.lang.String toString() {
            return "NO_LANGUAGES";
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Languages$2, reason: invalid class name */
    public static class AnonymousClass2 extends org.apache.commons.codec.language.bm.Languages.LanguageSet {
        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(java.lang.String str) {
            return true;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public java.lang.String getAny() {
            throw new java.util.NoSuchElementException("Can't fetch any language from the any language set.");
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            return false;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public org.apache.commons.codec.language.bm.Languages.LanguageSet restrictTo(org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
            return languageSet;
        }

        public java.lang.String toString() {
            return "ANY_LANGUAGE";
        }
    }

    public static abstract class LanguageSet {
        public static org.apache.commons.codec.language.bm.Languages.LanguageSet from(java.util.Set<java.lang.String> set) {
            return set.isEmpty() ? org.apache.commons.codec.language.bm.Languages.NO_LANGUAGES : new org.apache.commons.codec.language.bm.Languages.SomeLanguages(set, null);
        }

        public abstract boolean contains(java.lang.String str);

        public abstract java.lang.String getAny();

        public abstract boolean isEmpty();

        public abstract boolean isSingleton();

        public abstract org.apache.commons.codec.language.bm.Languages.LanguageSet restrictTo(org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet);
    }

    public static final class SomeLanguages extends org.apache.commons.codec.language.bm.Languages.LanguageSet {
        public final java.util.Set<java.lang.String> a;

        public SomeLanguages(java.util.Set<java.lang.String> set) {
            this.a = java.util.Collections.unmodifiableSet(set);
        }

        public /* synthetic */ SomeLanguages(java.util.Set set, org.apache.commons.codec.language.bm.Languages.AnonymousClass1 anonymousClass1) {
            this(set);
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean contains(java.lang.String str) {
            return this.a.contains(str);
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public java.lang.String getAny() {
            return this.a.iterator().next();
        }

        public java.util.Set<java.lang.String> getLanguages() {
            return this.a;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public boolean isSingleton() {
            return this.a.size() == 1;
        }

        @Override // org.apache.commons.codec.language.bm.Languages.LanguageSet
        public org.apache.commons.codec.language.bm.Languages.LanguageSet restrictTo(org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
            if (languageSet == org.apache.commons.codec.language.bm.Languages.NO_LANGUAGES) {
                return languageSet;
            }
            if (languageSet == org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE) {
                return this;
            }
            org.apache.commons.codec.language.bm.Languages.SomeLanguages someLanguages = (org.apache.commons.codec.language.bm.Languages.SomeLanguages) languageSet;
            if (someLanguages.a.containsAll(this.a)) {
                return this;
            }
            java.util.HashSet hashSet = new java.util.HashSet(this.a);
            hashSet.retainAll(someLanguages.a);
            return org.apache.commons.codec.language.bm.Languages.LanguageSet.from(hashSet);
        }

        public java.lang.String toString() {
            return "Languages(" + this.a.toString() + ")";
        }
    }

    static {
        for (org.apache.commons.codec.language.bm.NameType nameType : org.apache.commons.codec.language.bm.NameType.values()) {
            b.put(nameType, getInstance(a(nameType)));
        }
        NO_LANGUAGES = new org.apache.commons.codec.language.bm.Languages.AnonymousClass1();
        ANY_LANGUAGE = new org.apache.commons.codec.language.bm.Languages.AnonymousClass2();
    }

    public Languages(java.util.Set<java.lang.String> set) {
        this.a = set;
    }

    public static java.lang.String a(org.apache.commons.codec.language.bm.NameType nameType) {
        return java.lang.String.format("org/apache/commons/codec/language/bm/%s_languages.txt", nameType.getName());
    }

    public static org.apache.commons.codec.language.bm.Languages getInstance(java.lang.String str) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.io.InputStream resourceAsStream = org.apache.commons.codec.language.bm.Languages.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new java.lang.IllegalArgumentException("Unable to resolve required resource: " + str);
        }
        java.util.Scanner scanner = new java.util.Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                java.lang.String trim = scanner.nextLine().trim();
                if (z) {
                    if (trim.endsWith("*/")) {
                        break;
                    }
                } else if (trim.startsWith("/*")) {
                    z = true;
                } else if (trim.length() > 0) {
                    hashSet.add(trim);
                }
            }
            return new org.apache.commons.codec.language.bm.Languages(java.util.Collections.unmodifiableSet(hashSet));
        }
    }

    public static org.apache.commons.codec.language.bm.Languages getInstance(org.apache.commons.codec.language.bm.NameType nameType) {
        return b.get(nameType);
    }

    public java.util.Set<java.lang.String> getLanguages() {
        return this.a;
    }
}

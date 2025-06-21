package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public class PhoneticEngine {
    public static final java.util.Map<org.apache.commons.codec.language.bm.NameType, java.util.Set<java.lang.String>> e;
    public final org.apache.commons.codec.language.bm.Lang a;
    public final org.apache.commons.codec.language.bm.NameType b;
    public final org.apache.commons.codec.language.bm.RuleType c;
    public final boolean d;

    /* renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.CharSequence {
        public final /* synthetic */ java.lang.CharSequence n;
        public final /* synthetic */ java.lang.CharSequence[][] t;

        public AnonymousClass1(java.lang.CharSequence charSequence, java.lang.CharSequence[][] charSequenceArr) {
            this.n = charSequence;
            this.t = charSequenceArr;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.n.charAt(i);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.n.length();
        }

        @Override // java.lang.CharSequence
        public java.lang.CharSequence subSequence(int i, int i2) {
            if (i == i2) {
                return "";
            }
            int i3 = i2 - 1;
            java.lang.CharSequence charSequence = this.t[i][i3];
            if (charSequence != null) {
                return charSequence;
            }
            java.lang.CharSequence subSequence = this.n.subSequence(i, i2);
            this.t[i][i3] = subSequence;
            return subSequence;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[org.apache.commons.codec.language.bm.NameType.values().length];
            a = iArr;
            try {
                iArr[org.apache.commons.codec.language.bm.NameType.SEPHARDIC.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[org.apache.commons.codec.language.bm.NameType.ASHKENAZI.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[org.apache.commons.codec.language.bm.NameType.GENERIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static final class PhonemeBuilder {
        public final java.util.Set<org.apache.commons.codec.language.bm.Rule.Phoneme> a;

        public PhonemeBuilder(java.util.Set<org.apache.commons.codec.language.bm.Rule.Phoneme> set) {
            this.a = set;
        }

        public /* synthetic */ PhonemeBuilder(java.util.Set set, org.apache.commons.codec.language.bm.PhoneticEngine.AnonymousClass1 anonymousClass1) {
            this(set);
        }

        public static org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder c(org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
            return new org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder(java.util.Collections.singleton(new org.apache.commons.codec.language.bm.Rule.Phoneme("", languageSet)));
        }

        public org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder a(java.lang.CharSequence charSequence) {
            java.util.HashSet hashSet = new java.util.HashSet();
            java.util.Iterator<org.apache.commons.codec.language.bm.Rule.Phoneme> it = this.a.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().append(charSequence));
            }
            return new org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder(hashSet);
        }

        public org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder b(org.apache.commons.codec.language.bm.Rule.PhonemeExpr phonemeExpr) {
            java.util.HashSet hashSet = new java.util.HashSet();
            for (org.apache.commons.codec.language.bm.Rule.Phoneme phoneme : this.a) {
                java.util.Iterator<org.apache.commons.codec.language.bm.Rule.Phoneme> it = phonemeExpr.getPhonemes().iterator();
                while (it.hasNext()) {
                    org.apache.commons.codec.language.bm.Rule.Phoneme join = phoneme.join(it.next());
                    if (!join.getLanguages().isEmpty()) {
                        hashSet.add(join);
                    }
                }
            }
            return new org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder(hashSet);
        }

        public java.util.Set<org.apache.commons.codec.language.bm.Rule.Phoneme> d() {
            return this.a;
        }

        public java.lang.String e() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (org.apache.commons.codec.language.bm.Rule.Phoneme phoneme : this.a) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(phoneme.getPhonemeText());
            }
            return sb.toString();
        }
    }

    public static final class RulesApplication {
        public final java.util.List<org.apache.commons.codec.language.bm.Rule> a;
        public final java.lang.CharSequence b;
        public org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder c;
        public int d;
        public boolean e;

        public RulesApplication(java.util.List<org.apache.commons.codec.language.bm.Rule> list, java.lang.CharSequence charSequence, org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder phonemeBuilder, int i) {
            if (list == null) {
                throw new java.lang.NullPointerException("The finalRules argument must not be null");
            }
            this.a = list;
            this.c = phonemeBuilder;
            this.b = charSequence;
            this.d = i;
        }

        public int a() {
            return this.d;
        }

        public org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder b() {
            return this.c;
        }

        public org.apache.commons.codec.language.bm.PhoneticEngine.RulesApplication c() {
            int i = 0;
            this.e = false;
            java.util.Iterator<org.apache.commons.codec.language.bm.Rule> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                org.apache.commons.codec.language.bm.Rule next = it.next();
                int length = next.getPattern().length();
                if (next.patternAndContextMatches(this.b, this.d)) {
                    this.c = this.c.b(next.getPhoneme());
                    this.e = true;
                    i = length;
                    break;
                }
                i = length;
            }
            this.d += this.e ? i : 1;
            return this;
        }

        public boolean d() {
            return this.e;
        }
    }

    static {
        java.util.EnumMap enumMap = new java.util.EnumMap(org.apache.commons.codec.language.bm.NameType.class);
        e = enumMap;
        enumMap.put((java.util.EnumMap) org.apache.commons.codec.language.bm.NameType.ASHKENAZI, (org.apache.commons.codec.language.bm.NameType) java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList("bar", "ben", "da", com.anythink.expressad.video.dynview.a.a.S, "van", "von"))));
        enumMap.put((java.util.EnumMap) org.apache.commons.codec.language.bm.NameType.SEPHARDIC, (org.apache.commons.codec.language.bm.NameType) java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList("al", "el", "da", "dal", com.anythink.expressad.video.dynview.a.a.S, "del", "dela", "de la", "della", "des", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, com.anythink.expressad.foundation.d.d.f238s, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS, com.umeng.analytics.pro.f.ac, "van", "von"))));
        enumMap.put((java.util.EnumMap) org.apache.commons.codec.language.bm.NameType.GENERIC, (org.apache.commons.codec.language.bm.NameType) java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList("da", "dal", com.anythink.expressad.video.dynview.a.a.S, "del", "dela", "de la", "della", "des", com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, com.anythink.expressad.foundation.d.d.f238s, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS, com.umeng.analytics.pro.f.ac, "van", "von"))));
    }

    public PhoneticEngine(org.apache.commons.codec.language.bm.NameType nameType, org.apache.commons.codec.language.bm.RuleType ruleType, boolean z) {
        org.apache.commons.codec.language.bm.RuleType ruleType2 = org.apache.commons.codec.language.bm.RuleType.RULES;
        if (ruleType == ruleType2) {
            throw new java.lang.IllegalArgumentException("ruleType must not be " + ruleType2);
        }
        this.b = nameType;
        this.c = ruleType;
        this.d = z;
        this.a = org.apache.commons.codec.language.bm.Lang.instance(nameType);
    }

    public static java.lang.CharSequence b(java.lang.CharSequence charSequence) {
        return new org.apache.commons.codec.language.bm.PhoneticEngine.AnonymousClass1(charSequence, (java.lang.CharSequence[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.CharSequence.class, charSequence.length(), charSequence.length()));
    }

    public static java.lang.String c(java.lang.Iterable<java.lang.String> iterable, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<java.lang.String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public final org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder a(org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder phonemeBuilder, java.util.List<org.apache.commons.codec.language.bm.Rule> list) {
        if (list == null) {
            throw new java.lang.NullPointerException("finalRules can not be null");
        }
        if (list.isEmpty()) {
            return phonemeBuilder;
        }
        java.util.TreeSet treeSet = new java.util.TreeSet(org.apache.commons.codec.language.bm.Rule.Phoneme.COMPARATOR);
        for (org.apache.commons.codec.language.bm.Rule.Phoneme phoneme : phonemeBuilder.d()) {
            org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder c = org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder.c(phoneme.getLanguages());
            java.lang.CharSequence b = b(phoneme.getPhonemeText());
            int i = 0;
            while (i < b.length()) {
                org.apache.commons.codec.language.bm.PhoneticEngine.RulesApplication c2 = new org.apache.commons.codec.language.bm.PhoneticEngine.RulesApplication(list, b, c, i).c();
                boolean d = c2.d();
                org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder b2 = c2.b();
                org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder a = !d ? b2.a(b.subSequence(i, i + 1)) : b2;
                i = c2.a();
                c = a;
            }
            treeSet.addAll(c.d());
        }
        return new org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder(treeSet, null);
    }

    public java.lang.String encode(java.lang.String str) {
        return encode(str, this.a.guessLanguages(str));
    }

    public java.lang.String encode(java.lang.String str, org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
        java.lang.String str2;
        java.util.List<org.apache.commons.codec.language.bm.Rule> rule = org.apache.commons.codec.language.bm.Rule.getInstance(this.b, org.apache.commons.codec.language.bm.RuleType.RULES, languageSet);
        java.util.List<org.apache.commons.codec.language.bm.Rule> rule2 = org.apache.commons.codec.language.bm.Rule.getInstance(this.b, this.c, "common");
        java.util.List<org.apache.commons.codec.language.bm.Rule> rule3 = org.apache.commons.codec.language.bm.Rule.getInstance(this.b, this.c, languageSet);
        java.lang.String trim = str.toLowerCase(java.util.Locale.ENGLISH).replace('-', ' ').trim();
        int i = 0;
        if (this.b == org.apache.commons.codec.language.bm.NameType.GENERIC) {
            if (trim.length() >= 2 && trim.substring(0, 2).equals("d'")) {
                java.lang.String substring = trim.substring(2);
                return "(" + encode(substring) + ")-(" + encode("d" + substring) + ")";
            }
            for (java.lang.String str3 : e.get(this.b)) {
                if (trim.startsWith(str3 + " ")) {
                    java.lang.String substring2 = trim.substring(str3.length() + 1);
                    return "(" + encode(substring2) + ")-(" + encode(str3 + substring2) + ")";
                }
            }
        }
        java.util.List asList = java.util.Arrays.asList(trim.split("\\s+"));
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        int i2 = org.apache.commons.codec.language.bm.PhoneticEngine.AnonymousClass2.a[this.b.ordinal()];
        if (i2 == 1) {
            java.util.Iterator it = asList.iterator();
            while (it.hasNext()) {
                java.lang.String[] split = ((java.lang.String) it.next()).split("'");
                arrayList.add(split[split.length - 1]);
            }
            arrayList.removeAll(e.get(this.b));
        } else if (i2 == 2) {
            arrayList.addAll(asList);
            arrayList.removeAll(e.get(this.b));
        } else {
            if (i2 != 3) {
                throw new java.lang.IllegalStateException("Unreachable case: " + this.b);
            }
            arrayList.addAll(asList);
        }
        if (this.d) {
            str2 = c(arrayList, " ");
        } else {
            if (arrayList.size() != 1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (java.lang.String str4 : arrayList) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(encode(str4));
                }
                return sb.substring(1);
            }
            str2 = (java.lang.String) asList.iterator().next();
        }
        org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder c = org.apache.commons.codec.language.bm.PhoneticEngine.PhonemeBuilder.c(languageSet);
        java.lang.CharSequence b = b(str2);
        while (i < b.length()) {
            org.apache.commons.codec.language.bm.PhoneticEngine.RulesApplication c2 = new org.apache.commons.codec.language.bm.PhoneticEngine.RulesApplication(rule, b, c, i).c();
            i = c2.a();
            c = c2.b();
        }
        return a(a(c, rule2), rule3).e();
    }

    public org.apache.commons.codec.language.bm.Lang getLang() {
        return this.a;
    }

    public org.apache.commons.codec.language.bm.NameType getNameType() {
        return this.b;
    }

    public org.apache.commons.codec.language.bm.RuleType getRuleType() {
        return this.c;
    }

    public boolean isConcat() {
        return this.d;
    }
}

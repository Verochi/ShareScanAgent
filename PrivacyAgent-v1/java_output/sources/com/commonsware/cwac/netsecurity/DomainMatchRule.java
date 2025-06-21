package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public abstract class DomainMatchRule {

    public static class Composite extends com.commonsware.cwac.netsecurity.DomainMatchRule {
        private final boolean isOr;
        private final java.util.List<com.commonsware.cwac.netsecurity.DomainMatchRule> rules;

        public Composite(boolean z, java.util.List<com.commonsware.cwac.netsecurity.DomainMatchRule> list) {
            this.isOr = z;
            this.rules = list;
        }

        public Composite(boolean z, com.commonsware.cwac.netsecurity.DomainMatchRule... domainMatchRuleArr) {
            this(z, (java.util.List<com.commonsware.cwac.netsecurity.DomainMatchRule>) java.util.Arrays.asList(domainMatchRuleArr));
        }

        @Override // com.commonsware.cwac.netsecurity.DomainMatchRule
        public boolean matches(java.lang.String str) {
            java.util.Iterator<com.commonsware.cwac.netsecurity.DomainMatchRule> it = this.rules.iterator();
            while (it.hasNext()) {
                boolean matches = it.next().matches(str);
                if (matches && this.isOr) {
                    return true;
                }
                if (!matches && !this.isOr) {
                    return false;
                }
            }
            return !this.isOr;
        }
    }

    public static class Not extends com.commonsware.cwac.netsecurity.DomainMatchRule {
        private final com.commonsware.cwac.netsecurity.DomainMatchRule rule;

        public Not(com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule) {
            this.rule = domainMatchRule;
        }

        @Override // com.commonsware.cwac.netsecurity.DomainMatchRule
        public boolean matches(java.lang.String str) {
            return !this.rule.matches(str);
        }
    }

    public static class Regex extends com.commonsware.cwac.netsecurity.DomainMatchRule {
        private final java.util.regex.Pattern pattern;

        public Regex(java.lang.String str) {
            this(java.util.regex.Pattern.compile(str.replaceAll("\\.", "\\\\.").replaceAll("\\*", "\\.\\*")));
        }

        public Regex(java.util.regex.Pattern pattern) {
            this.pattern = pattern;
        }

        @Override // com.commonsware.cwac.netsecurity.DomainMatchRule
        public boolean matches(java.lang.String str) {
            return this.pattern.matcher(str).matches();
        }
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule allOf(java.util.List<com.commonsware.cwac.netsecurity.DomainMatchRule> list) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Composite(false, list);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule allOf(com.commonsware.cwac.netsecurity.DomainMatchRule... domainMatchRuleArr) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Composite(false, domainMatchRuleArr);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule anyOf(java.util.List<com.commonsware.cwac.netsecurity.DomainMatchRule> list) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Composite(true, list);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule anyOf(com.commonsware.cwac.netsecurity.DomainMatchRule... domainMatchRuleArr) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Composite(true, domainMatchRuleArr);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule blacklist(java.lang.String... strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            arrayList.add(not(is(str)));
        }
        return allOf(arrayList);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule is(java.lang.String str) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Regex(str);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule is(java.util.regex.Pattern pattern) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Regex(pattern);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule not(com.commonsware.cwac.netsecurity.DomainMatchRule domainMatchRule) {
        return new com.commonsware.cwac.netsecurity.DomainMatchRule.Not(domainMatchRule);
    }

    public static com.commonsware.cwac.netsecurity.DomainMatchRule whitelist(java.lang.String... strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            arrayList.add(is(str));
        }
        return anyOf(arrayList);
    }

    public abstract boolean matches(java.lang.String str);
}

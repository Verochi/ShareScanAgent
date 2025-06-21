package com.google.android.gms.common;

/* loaded from: classes22.dex */
public final class AccountPicker {

    public static class AccountChooserOptions {

        @androidx.annotation.Nullable
        public android.accounts.Account a;
        public boolean b;

        @androidx.annotation.Nullable
        public java.util.ArrayList<android.accounts.Account> c;

        @androidx.annotation.Nullable
        public java.util.ArrayList<java.lang.String> d;
        public boolean e;

        @androidx.annotation.Nullable
        public java.lang.String f;

        @androidx.annotation.Nullable
        public android.os.Bundle g;
        public boolean h;
        public int i;

        @androidx.annotation.Nullable
        public java.lang.String j;
        public boolean k;

        @androidx.annotation.Nullable
        public com.google.android.gms.common.AccountPicker.AccountChooserOptions.zza l;

        @androidx.annotation.Nullable
        public java.lang.String m;
        public boolean n;

        public static class Builder {

            @androidx.annotation.Nullable
            public android.accounts.Account a;

            @androidx.annotation.Nullable
            public java.util.ArrayList<android.accounts.Account> b;

            @androidx.annotation.Nullable
            public java.util.ArrayList<java.lang.String> c;

            @androidx.annotation.Nullable
            public java.lang.String e;

            @androidx.annotation.Nullable
            public android.os.Bundle f;
            public boolean d = false;
            public boolean g = false;
            public int h = 0;
            public boolean i = false;

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions build() {
                com.google.android.gms.common.internal.Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                com.google.android.gms.common.internal.Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions = new com.google.android.gms.common.AccountPicker.AccountChooserOptions();
                accountChooserOptions.d = this.c;
                accountChooserOptions.c = this.b;
                accountChooserOptions.e = this.d;
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.d(accountChooserOptions, null);
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.e(accountChooserOptions, null);
                accountChooserOptions.g = this.f;
                accountChooserOptions.a = this.a;
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.l(accountChooserOptions, false);
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.o(accountChooserOptions, false);
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.i(accountChooserOptions, null);
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.a(accountChooserOptions, 0);
                accountChooserOptions.f = this.e;
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.q(accountChooserOptions, false);
                com.google.android.gms.common.AccountPicker.AccountChooserOptions.s(accountChooserOptions, false);
                return accountChooserOptions;
            }

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder setAllowableAccounts(@androidx.annotation.Nullable java.util.List<android.accounts.Account> list) {
                this.b = list == null ? null : new java.util.ArrayList<>(list);
                return this;
            }

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder setAllowableAccountsTypes(@androidx.annotation.Nullable java.util.List<java.lang.String> list) {
                this.c = list == null ? null : new java.util.ArrayList<>(list);
                return this;
            }

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder setAlwaysShowAccountPicker(@androidx.annotation.RecentlyNonNull boolean z) {
                this.d = z;
                return this;
            }

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder setOptionsForAddingAccount(@androidx.annotation.Nullable android.os.Bundle bundle) {
                this.f = bundle;
                return this;
            }

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder setSelectedAccount(@androidx.annotation.Nullable android.accounts.Account account) {
                this.a = account;
                return this;
            }

            @androidx.annotation.RecentlyNonNull
            public com.google.android.gms.common.AccountPicker.AccountChooserOptions.Builder setTitleOverrideText(@androidx.annotation.Nullable java.lang.String str) {
                this.e = str;
                return this;
            }
        }

        public static class zza {
        }

        public static /* synthetic */ int a(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, int i) {
            accountChooserOptions.i = 0;
            return 0;
        }

        public static /* synthetic */ com.google.android.gms.common.AccountPicker.AccountChooserOptions.zza d(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, com.google.android.gms.common.AccountPicker.AccountChooserOptions.zza zzaVar) {
            accountChooserOptions.l = null;
            return null;
        }

        public static /* synthetic */ java.lang.String e(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, java.lang.String str) {
            accountChooserOptions.j = null;
            return null;
        }

        public static /* synthetic */ java.lang.String i(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, java.lang.String str) {
            accountChooserOptions.m = null;
            return null;
        }

        public static /* synthetic */ boolean l(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, boolean z) {
            accountChooserOptions.b = false;
            return false;
        }

        public static /* synthetic */ boolean o(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, boolean z) {
            accountChooserOptions.h = false;
            return false;
        }

        public static /* synthetic */ boolean q(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, boolean z) {
            accountChooserOptions.k = false;
            return false;
        }

        public static /* synthetic */ boolean s(com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions, boolean z) {
            accountChooserOptions.n = false;
            return false;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @java.lang.Deprecated
    public static android.content.Intent newChooseAccountIntent(@androidx.annotation.Nullable android.accounts.Account account, @androidx.annotation.Nullable java.util.ArrayList<android.accounts.Account> arrayList, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.RecentlyNonNull boolean z, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.content.Intent intent = new android.content.Intent();
        com.google.android.gms.common.internal.Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (java.lang.String) null);
        return intent;
    }

    @androidx.annotation.RecentlyNonNull
    public static android.content.Intent newChooseAccountIntent(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.AccountPicker.AccountChooserOptions accountChooserOptions) {
        android.content.Intent intent = new android.content.Intent();
        com.google.android.gms.common.internal.Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        com.google.android.gms.common.internal.Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        com.google.android.gms.common.internal.Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, accountChooserOptions.c);
        if (accountChooserOptions.d != null) {
            intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, (java.lang.String[]) accountChooserOptions.d.toArray(new java.lang.String[0]));
        }
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, accountChooserOptions.g);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_SELECTED_ACCOUNT, accountChooserOptions.a);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, accountChooserOptions.e);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, accountChooserOptions.f);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_REAL_CLIENT_PACKAGE, (java.lang.String) null);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        intent.putExtra(com.huawei.hms.common.AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (java.lang.String) null);
        android.os.Bundle bundle = new android.os.Bundle();
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}

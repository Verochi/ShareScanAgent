package com.huawei.hms.common;

/* loaded from: classes22.dex */
public final class AccountPicker {
    public static final java.lang.String CHOOSE_ACCOUNT = "com.huawei.hms.common.account.CHOOSE_ACCOUNT";
    public static final int CUSTOM_THEME_ACCOUNT_CHIPS = 2;
    public static final int CUSTOM_THEME_GAMES = 1;
    public static final int CUSTOM_THEME_NONE = 0;
    public static final java.lang.String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
    public static final java.lang.String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
    public static final java.lang.String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
    public static final java.lang.String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
    public static final java.lang.String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
    public static final java.lang.String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
    public static final java.lang.String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
    public static final java.lang.String EXTRA_HOSTED_DOMAIN_FILTER = "hostedDomainFilter";
    public static final java.lang.String EXTRA_IS_ACCOUNT_CHIPS_ACCOUNT_PICKER = "pickedFromAccountChips";
    public static final java.lang.String EXTRA_OVERRIDE_CUSTOM_THEME = "overrideCustomTheme";
    public static final java.lang.String EXTRA_OVERRIDE_THEME = "overrideTheme";
    public static final java.lang.String EXTRA_REAL_CLIENT_PACKAGE = "realClientPackage";
    public static final java.lang.String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
    public static final java.lang.String EXTRA_SET_HMS_CORE_ACCOUNT = "setHmsCoreAccount";
    private static final java.lang.String HMS_PACKAGE = "com.huawei.hms";
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_LIGHT = 1;

    private AccountPicker() {
    }

    public static android.content.Intent newChooseAccountIntent(android.accounts.Account account, java.util.ArrayList<android.accounts.Account> arrayList, java.lang.String[] strArr, boolean z, java.lang.String str, java.lang.String str2, java.lang.String[] strArr2, android.os.Bundle bundle) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(CHOOSE_ACCOUNT);
        intent.setPackage("com.huawei.hms");
        intent.putExtra(EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z);
        intent.putExtra(EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra(EXTRA_SET_HMS_CORE_ACCOUNT, false);
        intent.putExtra(EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        return intent;
    }
}

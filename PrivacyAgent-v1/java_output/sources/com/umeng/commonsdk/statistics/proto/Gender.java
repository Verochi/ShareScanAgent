package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public enum Gender implements com.umeng.analytics.pro.cg {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);

    private final int value;

    Gender(int i) {
        this.value = i;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender findByValue(int i) {
        if (i == 0) {
            return MALE;
        }
        if (i == 1) {
            return FEMALE;
        }
        if (i != 2) {
            return null;
        }
        return UNKNOWN;
    }

    @Override // com.umeng.analytics.pro.cg
    public int getValue() {
        return this.value;
    }
}

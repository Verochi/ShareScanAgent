package com.google.android.flexbox;

/* loaded from: classes22.dex */
interface FlexContainer {
    int getAlignContent();

    int getAlignItems();

    int getChildHeightMeasureSpec(int i, int i2, int i3);

    int getChildWidthMeasureSpec(int i, int i2, int i3);

    int getDecorationLengthCrossAxis(android.view.View view);

    int getDecorationLengthMainAxis(android.view.View view, int i, int i2);

    int getFlexDirection();

    android.view.View getFlexItemAt(int i);

    int getFlexItemCount();

    java.util.List<com.google.android.flexbox.FlexLine> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    android.view.View getReorderedFlexItemAt(int i);

    int getSumOfCrossSize();

    boolean isMainAxisDirectionHorizontal();

    void onNewFlexItemAdded(android.view.View view, int i, int i2, com.google.android.flexbox.FlexLine flexLine);

    void onNewFlexLineAdded(com.google.android.flexbox.FlexLine flexLine);

    void setFlexLines(java.util.List<com.google.android.flexbox.FlexLine> list);

    void updateViewCache(int i, android.view.View view);
}

package androidx.constraintlayout.widget;

/* loaded from: classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams mParams;
    android.view.View mView;

    public ConstraintProperties(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams)) {
            throw new java.lang.RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
        }
        this.mParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams;
        this.mView = view;
    }

    private java.lang.String sideToString(int i) {
        switch (i) {
            case 1:
                return com.sensorsdata.sf.ui.view.UIProperty.left;
            case 2:
                return com.sensorsdata.sf.ui.view.UIProperty.right;
            case 3:
                return com.sensorsdata.sf.ui.view.UIProperty.top;
            case 4:
                return com.sensorsdata.sf.ui.view.UIProperty.bottom;
            case 5:
                return "baseline";
            case 6:
                return com.anythink.expressad.foundation.d.c.bT;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public androidx.constraintlayout.widget.ConstraintProperties addToHorizontalChain(int i, int i2) {
        connect(1, i, i == 0 ? 1 : 2, 0);
        connect(2, i2, i2 == 0 ? 2 : 1, 0);
        if (i != 0) {
            new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i2 != 0) {
            new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i2)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        connect(6, i, i == 0 ? 6 : 7, 0);
        connect(7, i2, i2 == 0 ? 7 : 6, 0);
        if (i != 0) {
            new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i2 != 0) {
            new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i2)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties addToVerticalChain(int i, int i2) {
        connect(3, i, i == 0 ? 3 : 4, 0);
        connect(4, i2, i2 == 0 ? 4 : 3, 0);
        if (i != 0) {
            new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i2 != 0) {
            new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i2)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties alpha(float f) {
        this.mView.setAlpha(f);
        return this;
    }

    public void apply() {
    }

    public androidx.constraintlayout.widget.ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (i3 < 0) {
            throw new java.lang.IllegalArgumentException("margin must be > 0");
        }
        if (i6 < 0) {
            throw new java.lang.IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i2 == 1 || i2 == 2) {
            connect(1, i, i2, i3);
            connect(2, i4, i5, i6);
            this.mParams.horizontalBias = f;
        } else if (i2 == 6 || i2 == 7) {
            connect(6, i, i2, i3);
            connect(7, i4, i5, i6);
            this.mParams.horizontalBias = f;
        } else {
            connect(3, i, i2, i3);
            connect(4, i4, i5, i6);
            this.mParams.verticalBias = f;
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, 2, 0, i, 1, 0, 0.5f);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(1, i, i2, i3);
        connect(2, i4, i5, i6);
        this.mParams.horizontalBias = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, 7, 0, i, 6, 0, 0.5f);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(6, i, i2, i3);
        connect(7, i4, i5, i6);
        this.mParams.horizontalBias = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, 4, 0, i, 3, 0, 0.5f);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(3, i, i2, i3);
        connect(4, i4, i5, i6);
        this.mParams.verticalBias = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties connect(int i, int i2, int i3, int i4) {
        switch (i) {
            case 1:
                if (i3 == 1) {
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i2;
                    layoutParams.leftToRight = -1;
                } else {
                    if (i3 != 2) {
                        throw new java.lang.IllegalArgumentException("Left to " + sideToString(i3) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i2;
                    layoutParams2.leftToLeft = -1;
                }
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i4;
                return this;
            case 2:
                if (i3 == 1) {
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i2;
                    layoutParams3.rightToRight = -1;
                } else {
                    if (i3 != 2) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i2;
                    layoutParams4.rightToLeft = -1;
                }
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i4;
                return this;
            case 3:
                if (i3 == 3) {
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i2;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                } else {
                    if (i3 != 4) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i2;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                }
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).topMargin = i4;
                return this;
            case 4:
                if (i3 == 4) {
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i2;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                } else {
                    if (i3 != 3) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i2;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                }
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i4;
                return this;
            case 5:
                if (i3 != 5) {
                    throw new java.lang.IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                }
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                layoutParams9.baselineToBaseline = i2;
                layoutParams9.bottomToBottom = -1;
                layoutParams9.bottomToTop = -1;
                layoutParams9.topToTop = -1;
                layoutParams9.topToBottom = -1;
                return this;
            case 6:
                if (i3 == 6) {
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.startToStart = i2;
                    layoutParams10.startToEnd = -1;
                } else {
                    if (i3 != 7) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.startToEnd = i2;
                    layoutParams11.startToStart = -1;
                }
                this.mParams.setMarginStart(i4);
                return this;
            case 7:
                if (i3 == 7) {
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.endToEnd = i2;
                    layoutParams12.endToStart = -1;
                } else {
                    if (i3 != 6) {
                        throw new java.lang.IllegalArgumentException("right to " + sideToString(i3) + " undefined");
                    }
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.endToStart = i2;
                    layoutParams13.endToEnd = -1;
                }
                this.mParams.setMarginEnd(i4);
                return this;
            default:
                throw new java.lang.IllegalArgumentException(sideToString(i) + " to " + sideToString(i3) + " unknown");
        }
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainDefaultHeight(int i) {
        this.mParams.matchConstraintDefaultHeight = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainDefaultWidth(int i) {
        this.mParams.matchConstraintDefaultWidth = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainHeight(int i) {
        ((android.view.ViewGroup.MarginLayoutParams) this.mParams).height = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainMaxHeight(int i) {
        this.mParams.matchConstraintMaxHeight = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainMaxWidth(int i) {
        this.mParams.matchConstraintMaxWidth = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainMinHeight(int i) {
        this.mParams.matchConstraintMinHeight = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainMinWidth(int i) {
        this.mParams.matchConstraintMinWidth = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties constrainWidth(int i) {
        ((android.view.ViewGroup.MarginLayoutParams) this.mParams).width = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties dimensionRatio(java.lang.String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties elevation(float f) {
        this.mView.setElevation(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties goneMargin(int i, int i2) {
        switch (i) {
            case 1:
                this.mParams.goneLeftMargin = i2;
                return this;
            case 2:
                this.mParams.goneRightMargin = i2;
                return this;
            case 3:
                this.mParams.goneTopMargin = i2;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i2;
                return this;
            case 5:
                throw new java.lang.IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i2;
                return this;
            case 7:
                this.mParams.goneEndMargin = i2;
                return this;
            default:
                throw new java.lang.IllegalArgumentException("unknown constraint");
        }
    }

    public androidx.constraintlayout.widget.ConstraintProperties horizontalBias(float f) {
        this.mParams.horizontalBias = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties horizontalChainStyle(int i) {
        this.mParams.horizontalChainStyle = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties horizontalWeight(float f) {
        this.mParams.horizontalWeight = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties margin(int i, int i2) {
        switch (i) {
            case 1:
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i2;
                return this;
            case 2:
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i2;
                return this;
            case 3:
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).topMargin = i2;
                return this;
            case 4:
                ((android.view.ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i2;
                return this;
            case 5:
                throw new java.lang.IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i2);
                return this;
            case 7:
                this.mParams.setMarginEnd(i2);
                return this;
            default:
                throw new java.lang.IllegalArgumentException("unknown constraint");
        }
    }

    public androidx.constraintlayout.widget.ConstraintProperties removeConstraints(int i) {
        switch (i) {
            case 1:
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.goneLeftMargin = -1;
                return this;
            case 2:
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                ((android.view.ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                layoutParams2.goneRightMargin = -1;
                return this;
            case 3:
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                ((android.view.ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                layoutParams3.goneTopMargin = -1;
                return this;
            case 4:
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                ((android.view.ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                layoutParams4.goneBottomMargin = -1;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = -1;
                return this;
            case 7:
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = -1;
                return this;
            default:
                throw new java.lang.IllegalArgumentException("unknown constraint");
        }
    }

    public androidx.constraintlayout.widget.ConstraintProperties removeFromHorizontalChain() {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i = layoutParams.leftToRight;
        int i2 = layoutParams.rightToLeft;
        if (i == -1 && i2 == -1) {
            int i3 = layoutParams.startToEnd;
            int i4 = layoutParams.endToStart;
            if (i3 != -1 || i4 != -1) {
                androidx.constraintlayout.widget.ConstraintProperties constraintProperties = new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i3));
                androidx.constraintlayout.widget.ConstraintProperties constraintProperties2 = new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i4));
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                if (i3 != -1 && i4 != -1) {
                    constraintProperties.connect(7, i4, 6, 0);
                    constraintProperties2.connect(6, i, 7, 0);
                } else if (i != -1 || i4 != -1) {
                    int i5 = layoutParams2.rightToRight;
                    if (i5 != -1) {
                        constraintProperties.connect(7, i5, 7, 0);
                    } else {
                        int i6 = layoutParams2.leftToLeft;
                        if (i6 != -1) {
                            constraintProperties2.connect(6, i6, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
        } else {
            androidx.constraintlayout.widget.ConstraintProperties constraintProperties3 = new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i));
            androidx.constraintlayout.widget.ConstraintProperties constraintProperties4 = new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i2));
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
            if (i != -1 && i2 != -1) {
                constraintProperties3.connect(2, i2, 1, 0);
                constraintProperties4.connect(1, i, 2, 0);
            } else if (i != -1 || i2 != -1) {
                int i7 = layoutParams3.rightToRight;
                if (i7 != -1) {
                    constraintProperties3.connect(2, i7, 2, 0);
                } else {
                    int i8 = layoutParams3.leftToLeft;
                    if (i8 != -1) {
                        constraintProperties4.connect(1, i8, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
        }
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties removeFromVerticalChain() {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i = layoutParams.topToBottom;
        int i2 = layoutParams.bottomToTop;
        if (i != -1 || i2 != -1) {
            androidx.constraintlayout.widget.ConstraintProperties constraintProperties = new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i));
            androidx.constraintlayout.widget.ConstraintProperties constraintProperties2 = new androidx.constraintlayout.widget.ConstraintProperties(((android.view.ViewGroup) this.mView.getParent()).findViewById(i2));
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i != -1 && i2 != -1) {
                constraintProperties.connect(4, i2, 3, 0);
                constraintProperties2.connect(3, i, 4, 0);
            } else if (i != -1 || i2 != -1) {
                int i3 = layoutParams2.bottomToBottom;
                if (i3 != -1) {
                    constraintProperties.connect(4, i3, 4, 0);
                } else {
                    int i4 = layoutParams2.topToTop;
                    if (i4 != -1) {
                        constraintProperties2.connect(3, i4, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties rotation(float f) {
        this.mView.setRotation(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties rotationX(float f) {
        this.mView.setRotationX(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties rotationY(float f) {
        this.mView.setRotationY(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties scaleX(float f) {
        this.mView.setScaleY(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties scaleY(float f) {
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties transformPivot(float f, float f2) {
        this.mView.setPivotX(f);
        this.mView.setPivotY(f2);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties transformPivotX(float f) {
        this.mView.setPivotX(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties transformPivotY(float f) {
        this.mView.setPivotY(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties translation(float f, float f2) {
        this.mView.setTranslationX(f);
        this.mView.setTranslationY(f2);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties translationX(float f) {
        this.mView.setTranslationX(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties translationY(float f) {
        this.mView.setTranslationY(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties translationZ(float f) {
        this.mView.setTranslationZ(f);
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties verticalBias(float f) {
        this.mParams.verticalBias = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties verticalChainStyle(int i) {
        this.mParams.verticalChainStyle = i;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties verticalWeight(float f) {
        this.mParams.verticalWeight = f;
        return this;
    }

    public androidx.constraintlayout.widget.ConstraintProperties visibility(int i) {
        this.mView.setVisibility(i);
        return this;
    }
}

package com.aliyun.svideo.editor.effects.caption;

/* loaded from: classes12.dex */
public class TextDialog extends android.app.DialogFragment {
    public static final int EFFECT_DOWN = 2;
    public static final int EFFECT_FADE = 5;
    public static final int EFFECT_LEFT = 3;
    public static final int EFFECT_LINEARWIPE = 6;
    public static final int EFFECT_NONE = 0;
    public static final int EFFECT_RIGHT = 4;
    public static final int EFFECT_SCALE = 7;
    public static final int EFFECT_UP = 1;
    private static final int FONT_TYPE = 1;
    com.aliyun.svideo.editor.effects.caption.TextDialog.FontAdapter fontAdapter;
    android.widget.GridView fontList;
    com.aliyun.svideosdk.common.struct.effect.ActionBase mActionBase;
    private int mAnimationSelectPosition;
    private android.view.View mBack;
    private android.view.View mConfirm;
    private com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo mEditInfo;
    private com.aliyun.svideo.editor.widget.AutoResizingEditText mEditView;
    java.util.List<com.aliyun.svideo.editor.widget.WheelView.DataModel> mFontDataList;
    java.util.List<com.aliyun.svideosdk.common.struct.form.FontForm> mFormList;
    private com.aliyun.svideo.editor.effects.caption.TextDialog.OnStateChangeListener mOnStateChangeListener;
    private com.aliyun.svideo.base.widget.control.ViewStack mPagerViewStack;
    private int mSelectedIndex;
    private boolean mShowAnimation;
    private com.google.android.material.tabs.TabLayout mTabLayout;
    private com.aliyun.svideo.editor.widget.WheelView mWva;
    private android.widget.FrameLayout pageContainer;
    private android.widget.TextView textLimit;
    private static final int[] ID_TITLE_ARRAY = {com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_keyboard, com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_color, com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_font, com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_effect};
    private static final int[] ID_ICON_ARRAY = {com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_keyboard, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_color, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_font, com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_animation};
    public static final int[] POSITION_FONT_ANIM_ARRAY = {0, 1, 4, 3, 2, 6, 5, 7};
    public static boolean sIsShowing = false;
    private boolean flag = false;
    private boolean mUseInvert = false;
    private com.aliyun.svideo.editor.effects.caption.TextDialog.OnItemClickListener mOnItemClickListener = new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass6();
    private com.google.android.material.tabs.TabLayout.OnTabSelectedListener mOnTabSelectedListener = new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass7();
    java.util.ArrayList<android.text.style.BackgroundColorSpan> masks = new java.util.ArrayList<>();
    private com.aliyun.svideo.editor.effects.caption.TextDialog.MyTextWatcher textWatch = new com.aliyun.svideo.editor.effects.caption.TextDialog.MyTextWatcher(this, null);
    private java.lang.Runnable mOpenKeyboardRunnable = new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass11();

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnKeyListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            dialogInterface.dismiss();
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$10, reason: invalid class name */
    public class AnonymousClass10 implements android.view.View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo = com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditInfo;
            com.aliyun.svideo.editor.effects.caption.TextDialog textDialog = com.aliyun.svideo.editor.effects.caption.TextDialog.this;
            editTextInfo.mAnimation = textDialog.mActionBase;
            textDialog.mEditInfo.mAnimationSelect = com.aliyun.svideo.editor.effects.caption.TextDialog.this.mAnimationSelectPosition;
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.removeTextChangedListener(com.aliyun.svideo.editor.effects.caption.TextDialog.this.textWatch);
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.filterComposingText(com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.getText());
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        public AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.getActivity() == null) {
                return;
            }
            try {
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.requestFocusForKeyboard();
                if (((android.view.inputmethod.InputMethodManager) com.aliyun.svideo.editor.effects.caption.TextDialog.this.getActivity().getSystemService("input_method")).showSoftInput(com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView, 0)) {
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setSelection(com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.getText().length());
                } else {
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.openKeyboard();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.editor.ColorViewHolder.OnItemClickListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.editor.ColorViewHolder.OnItemClickListener
        public void onItemClick(com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem colorItem) {
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setCurrentColor(colorItem.color);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.editor.ColorViewHolder.OnItemClickListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.editor.ColorViewHolder.OnItemClickListener
        public void onItemClick(com.aliyun.svideo.editor.editor.ColorViewHolder.ColorItem colorItem) {
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setTextStrokeColor(colorItem.strokeColor);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$4, reason: invalid class name */
    public class AnonymousClass4 implements android.widget.AdapterView.OnItemClickListener {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.io.FilenameFilter {
            public AnonymousClass1() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(java.io.File file, java.lang.String str) {
                return str.toLowerCase().endsWith(".ttf");
            }
        }

        public AnonymousClass4() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            java.lang.String url = ((com.aliyun.svideosdk.common.struct.form.FontForm) adapterView.getItemAtPosition(i)).getUrl();
            java.io.File file = new java.io.File(url);
            boolean z = file.exists() && file.isDirectory();
            if (!z) {
                file = new java.io.File(url + "tmp");
                z = file.exists() && file.isDirectory();
            }
            if (z) {
                java.lang.String[] list = file.list(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass4.AnonymousClass1());
                if (list.length > 0) {
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setFontPath(new java.io.File(file, list[0]).getAbsolutePath());
                }
            }
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.fontList.setItemChecked(i, true);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$5, reason: invalid class name */
    public class AnonymousClass5 extends com.aliyun.svideo.editor.widget.WheelView.OnWheelViewListener {

        /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.io.FilenameFilter {
            public AnonymousClass1() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(java.io.File file, java.lang.String str) {
                return str.toLowerCase().endsWith(".ttf");
            }
        }

        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.widget.WheelView.OnWheelViewListener
        public void onSelected(int i, java.lang.String str) {
            if (i == 0) {
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setTypeface(android.graphics.Typeface.DEFAULT);
            } else {
                java.lang.String url = com.aliyun.svideo.editor.effects.caption.TextDialog.this.mFormList.get(i).getUrl();
                java.io.File file = new java.io.File(url);
                boolean z = file.exists() && file.isDirectory();
                if (!z) {
                    file = new java.io.File(url + "tmp");
                    z = file.exists() && file.isDirectory();
                }
                if (z) {
                    java.lang.String[] list = file.list(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass5.AnonymousClass1());
                    if (list.length > 0) {
                        com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setFontPath(new java.io.File(file, list[0]).getAbsolutePath());
                    }
                }
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("selectedIndex: ");
            sb.append(i);
            sb.append(", item: ");
            sb.append(str);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.svideo.editor.effects.caption.TextDialog.OnItemClickListener {
        public AnonymousClass6() {
        }

        @Override // com.aliyun.svideo.editor.effects.caption.TextDialog.OnItemClickListener
        public void onItemClick(int i) {
            if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.mUseInvert) {
                com.aliyun.svideo.editor.util.FixedToastUtils.show(com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.getContext(), com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.getContext().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_tip_not_support));
            }
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.mAnimationSelectPosition = i;
            switch (i) {
                case 0:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = null;
                    break;
                case 1:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setToPointY(1.0f);
                    break;
                case 2:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setToPointY(-1.0f);
                    break;
                case 3:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setToPointX(-1.0f);
                    break;
                case 4:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionTranslate) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setToPointX(1.0f);
                    break;
                case 5:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionFade();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionFade) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setFromAlpha(1.0f);
                    ((com.aliyun.svideosdk.common.struct.effect.ActionFade) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setToAlpha(0.2f);
                    break;
                case 6:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionWipe();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionWipe) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setWipeMode(1);
                    ((com.aliyun.svideosdk.common.struct.effect.ActionWipe) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setDirection(2);
                    break;
                case 7:
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase = new com.aliyun.svideosdk.common.struct.effect.ActionScale();
                    ((com.aliyun.svideosdk.common.struct.effect.ActionScale) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setFromScale(1.0f);
                    ((com.aliyun.svideosdk.common.struct.effect.ActionScale) com.aliyun.svideo.editor.effects.caption.TextDialog.this.mActionBase).setToScale(0.25f);
                    break;
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$7, reason: invalid class name */
    public class AnonymousClass7 implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
        public AnonymousClass7() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onTabSelected(com.google.android.material.tabs.TabLayout.Tab tab) {
            int position = tab.getPosition();
            if (position == 0) {
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.pageContainer.setVisibility(8);
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setEnabled(true);
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.openKeyboard();
            } else {
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.pageContainer.setVisibility(0);
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.closeKeyboard();
                com.aliyun.svideo.editor.effects.caption.TextDialog.this.mPagerViewStack.setActiveIndex(position);
                if (position != 1) {
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setEnabled(false);
                } else if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.fontList.getCheckedItemPosition() == -1) {
                    int lastCheckedPosition = ((com.aliyun.svideo.editor.effects.caption.TextDialog.FontAdapter) com.aliyun.svideo.editor.effects.caption.TextDialog.this.fontList.getAdapter()).getLastCheckedPosition(null);
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.fontList.setItemChecked(lastCheckedPosition, true);
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.fontList.smoothScrollToPosition(lastCheckedPosition);
                }
                if (position == 2 && com.aliyun.svideo.editor.effects.caption.TextDialog.this.mWva != null) {
                    com.aliyun.svideo.editor.effects.caption.TextDialog.this.mWva.setSelection(com.aliyun.svideo.editor.effects.caption.TextDialog.this.mSelectedIndex);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnTouchListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            com.google.android.material.tabs.TabLayout.Tab tabAt;
            if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.mTabLayout.getSelectedTabPosition() == 0 || motionEvent.getAction() != 0 || (tabAt = com.aliyun.svideo.editor.effects.caption.TextDialog.this.mTabLayout.getTabAt(0)) == null) {
                return false;
            }
            tabAt.select();
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.TextDialog$9, reason: invalid class name */
    public class AnonymousClass9 implements android.view.View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class EditTextInfo implements java.io.Serializable {
        public int dTextColor;
        public int dTextStrokeColor;
        public java.lang.String font;
        public boolean isShowAnimation;
        public boolean isTextOnly;
        public int layoutWidth;
        public com.aliyun.svideosdk.common.struct.effect.ActionBase mAnimation;
        public int mAnimationSelect;
        public java.lang.String text;
        public int textColor;
        public int textHeight;
        public int textStrokeColor;
        public int textWidth;
    }

    public class FontAdapter extends android.widget.BaseAdapter {
        private java.util.List<com.aliyun.svideosdk.common.struct.form.FontForm> list;

        private FontAdapter() {
            this.list = new java.util.ArrayList();
        }

        public /* synthetic */ FontAdapter(com.aliyun.svideo.editor.effects.caption.TextDialog textDialog, defpackage.l03 l03Var) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.size();
        }

        public java.util.List<com.aliyun.svideosdk.common.struct.form.FontForm> getData() {
            return this.list;
        }

        @Override // android.widget.Adapter
        public com.aliyun.svideosdk.common.struct.form.FontForm getItem(int i) {
            return this.list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        public int getLastCheckedPosition(java.lang.String str) {
            return 0;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            android.view.View view2;
            com.aliyun.svideo.editor.effects.caption.TextDialog.FontItemViewMediator fontItemViewMediator;
            if (view == null) {
                fontItemViewMediator = com.aliyun.svideo.editor.effects.caption.TextDialog.this.new FontItemViewMediator(viewGroup);
                view2 = fontItemViewMediator.getView();
            } else {
                view2 = view;
                fontItemViewMediator = (com.aliyun.svideo.editor.effects.caption.TextDialog.FontItemViewMediator) view.getTag();
            }
            fontItemViewMediator.setData(getItem(i));
            if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.fontList.getCheckedItemPosition() == i) {
                fontItemViewMediator.setSelected(true);
            } else {
                fontItemViewMediator.setSelected(false);
            }
            return view2;
        }

        public void setData(java.util.List<com.aliyun.svideosdk.common.struct.form.FontForm> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    public static class FontDateBean implements com.aliyun.svideo.editor.widget.WheelView.DataModel {
        private java.lang.String name;

        public FontDateBean(java.lang.String str) {
            this.name = str;
        }

        @Override // com.aliyun.svideo.editor.widget.WheelView.DataModel
        public java.lang.String getText() {
            return this.name;
        }
    }

    public class FontItemViewMediator {
        private com.aliyun.svideosdk.common.struct.form.FontForm fontInfo;
        private android.widget.ImageView image;
        private android.widget.ImageView indiator;
        private android.widget.TextView name;
        private android.view.View root;
        private android.view.View select;

        public FontItemViewMediator(android.view.ViewGroup viewGroup) {
            android.view.View inflate = android.view.View.inflate(viewGroup.getContext(), com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_text_item_font_effect, null);
            this.root = inflate;
            this.select = inflate.findViewById(com.aliyun.svideo.editor.R.id.selected);
            this.image = (android.widget.ImageView) this.root.findViewById(com.aliyun.svideo.editor.R.id.font_item_image);
            this.indiator = (android.widget.ImageView) this.root.findViewById(com.aliyun.svideo.editor.R.id.indiator);
            this.name = (android.widget.TextView) this.root.findViewById(com.aliyun.svideo.editor.R.id.item_name);
            this.root.setTag(this);
        }

        public android.view.View getView() {
            return this.root;
        }

        public void setData(com.aliyun.svideosdk.common.struct.form.FontForm fontForm) {
            this.fontInfo = fontForm;
            this.name.setText(fontForm.getName());
            new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(com.aliyun.svideo.editor.effects.caption.TextDialog.this.getActivity(), fontForm.getBanner()).into(this.image);
        }

        public void setSelected(boolean z) {
            this.select.setVisibility(z ? 0 : 8);
        }
    }

    public class MyTextWatcher implements android.text.TextWatcher {
        private java.lang.String text;

        private MyTextWatcher() {
        }

        public /* synthetic */ MyTextWatcher(com.aliyun.svideo.editor.effects.caption.TextDialog textDialog, defpackage.m03 m03Var) {
            this();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
            int i;
            this.text = com.aliyun.svideo.editor.effects.caption.TextDialog.this.filterComposingText(editable);
            int length = editable.length();
            if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.isTextOnly()) {
                i = 90;
            } else {
                android.widget.TextView textView = com.aliyun.svideo.editor.effects.caption.TextDialog.this.textLimit;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                i = 10;
                if (length > 10) {
                    length = 10;
                }
                sb.append(length);
                sb.append(" / 10");
                textView.setText(sb.toString());
            }
            if (editable.length() > i) {
                com.aliyun.svideo.common.utils.ToastUtils.show(com.aliyun.svideo.editor.effects.caption.TextDialog.this.getActivity(), com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_tip_text_limit);
                int length2 = editable.length() - i;
                int selectionStart = com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.getSelectionStart();
                int i2 = selectionStart - length2;
                if (i2 < 0) {
                    i2 = 0;
                }
                if (selectionStart > editable.length()) {
                    selectionStart = editable.length();
                }
                if (i2 > selectionStart) {
                    i2 = selectionStart;
                }
                editable.delete(i2, selectionStart);
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.aliyun.svideo.editor.effects.caption.TextDialog.lineFeedText(editable.toString()));
            if (com.aliyun.svideo.editor.effects.caption.TextDialog.this.flag) {
                return;
            }
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.flag = true;
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setText(stringBuffer);
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.mEditView.setSelection(stringBuffer.length());
            com.aliyun.svideo.editor.effects.caption.TextDialog.this.flag = false;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        public java.lang.String getText() {
            return this.text;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public interface OnStateChangeListener {
        void onTextEditCompleted(com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo);
    }

    private void callbackResult() {
        if (this.mOnStateChangeListener != null) {
            android.text.Editable text = this.mEditView.getText();
            this.mEditInfo.text = android.text.TextUtils.isEmpty(text) ? null : text.toString();
            if (android.text.TextUtils.isEmpty(text)) {
                this.mEditInfo.text = null;
            } else {
                this.mEditInfo.text = lineFeedText(text.toString());
            }
            this.mEditInfo.textColor = this.mEditView.getCurrentTextColor();
            this.mEditInfo.textStrokeColor = this.mEditView.getTextStrokeColor();
            this.mEditInfo.font = this.mEditView.getFontPath();
            this.mEditInfo.textWidth = this.mEditView.getWidth();
            this.mEditInfo.textHeight = this.mEditView.getHeight();
            this.mOnStateChangeListener.onTextEditCompleted(this.mEditInfo);
        }
    }

    private int count(java.lang.String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            int charCount = java.lang.Character.charCount(codePointAt);
            if (codePointAt != 10) {
                if (isChinese(str.substring(i, i + charCount))) {
                    i3++;
                } else {
                    i2++;
                }
            }
            i += charCount;
        }
        int i4 = i2 % 2;
        int i5 = i2 / 2;
        if (i4 != 0) {
            i5++;
        }
        return i3 + i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String filterComposingText(android.text.Editable editable) {
        int i;
        int i2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.Object[] spans = editable.getSpans(0, editable.length(), java.lang.Object.class);
        if (spans != null) {
            for (int length = spans.length - 1; length >= 0; length--) {
                java.lang.Object obj = spans[length];
                int spanFlags = editable.getSpanFlags(obj);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("SpanFlag : ");
                sb2.append(spanFlags);
                sb2.append(" is composing");
                int i3 = spanFlags & 256;
                sb2.append(i3);
                if (i3 != 0) {
                    i = editable.getSpanStart(obj);
                    i2 = editable.getSpanEnd(obj);
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("startAnimation : ");
                    sb3.append(i);
                    sb3.append(" end : ");
                    sb3.append(i2);
                    break;
                }
            }
        }
        i = 0;
        i2 = 0;
        sb.append(editable.subSequence(0, i));
        sb.append(editable.subSequence(i2, editable.length()));
        if (i != i2) {
            android.text.style.BackgroundColorSpan backgroundColorSpan = new android.text.style.BackgroundColorSpan(getResources().getColor(com.aliyun.svideo.editor.R.color.accent_material_dark));
            editable.setSpan(backgroundColorSpan, i, i2, 33);
            this.masks.add(backgroundColorSpan);
        } else if (this.masks.size() > 0) {
            java.util.Iterator<android.text.style.BackgroundColorSpan> it = this.masks.iterator();
            while (it.hasNext()) {
                editable.removeSpan(it.next());
            }
            this.masks.clear();
        }
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append("str : ");
        sb4.append(sb.toString());
        return sb.toString();
    }

    private java.util.List<com.aliyun.svideosdk.common.struct.form.FontForm> getFontList() {
        java.util.List<com.aliyun.svideo.downloader.FileDownloaderModel> resourceByType = com.aliyun.svideo.downloader.DownloaderManager.getInstance().getDbController().getResourceByType(1);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.aliyun.svideosdk.common.struct.form.FontForm fontForm = new com.aliyun.svideosdk.common.struct.form.FontForm();
        fontForm.setName(getResources().getString(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_caption_font_system));
        arrayList.add(fontForm);
        int i = 0;
        for (com.aliyun.svideo.downloader.FileDownloaderModel fileDownloaderModel : resourceByType) {
            com.aliyun.svideosdk.common.struct.form.FontForm fontForm2 = new com.aliyun.svideosdk.common.struct.form.FontForm();
            fontForm2.setId(fileDownloaderModel.getId());
            fontForm2.setName(fileDownloaderModel.getName());
            fontForm2.setBanner(fileDownloaderModel.getBanner());
            fontForm2.setUrl(fileDownloaderModel.getPath());
            arrayList.add(fontForm2);
            if ((fileDownloaderModel.getPath() + com.aliyun.svideo.editor.contant.CaptionConfig.FONT_NAME).equals(this.mEditInfo.font)) {
                this.mSelectedIndex = i;
            }
            i++;
        }
        return arrayList;
    }

    private void initFontAnimationView(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view.findViewById(com.aliyun.svideo.editor.R.id.font_animation_view);
        com.aliyun.svideo.editor.effects.caption.FontAnimationAdapter fontAnimationAdapter = new com.aliyun.svideo.editor.effects.caption.FontAnimationAdapter(view.getContext());
        fontAnimationAdapter.setSelectPosition(this.mEditInfo.mAnimationSelect);
        fontAnimationAdapter.setOnItemClickListener(this.mOnItemClickListener);
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new com.aliyun.svideo.editor.effects.control.SpaceItemDecoration(view.getContext().getResources().getDimensionPixelSize(com.aliyun.svideo.editor.R.dimen.list_item_space)));
        recyclerView.setAdapter(fontAnimationAdapter);
    }

    private void initTableView(android.view.View view) {
        com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) view.findViewById(com.aliyun.svideo.editor.R.id.tl_tab);
        this.mTabLayout = tabLayout;
        tabLayout.setTabMode(0);
        int length = ID_TITLE_ARRAY.length;
        if (!this.mShowAnimation) {
            length--;
        }
        for (int i = 0; i < length; i++) {
            android.view.View inflate = android.view.LayoutInflater.from(view.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_text_item_tab, (android.view.ViewGroup) view, false);
            ((android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_icon)).setImageResource(ID_ICON_ARRAY[i]);
            ((android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.tv_title)).setText(ID_TITLE_ARRAY[i]);
            com.google.android.material.tabs.TabLayout tabLayout2 = this.mTabLayout;
            tabLayout2.addTab(tabLayout2.newTab().setCustomView(inflate));
        }
        this.mTabLayout.setSelectedTabIndicatorColor(androidx.core.content.ContextCompat.getColor(view.getContext(), com.aliyun.svideo.editor.R.color.alivc_common_bg_cyan_light));
        this.mTabLayout.addOnTabSelectedListener(this.mOnTabSelectedListener);
    }

    private void initWLView(android.view.View view) {
        java.util.List<com.aliyun.svideosdk.common.struct.form.FontForm> fontList = getFontList();
        this.mFormList = fontList;
        if (fontList == null) {
            return;
        }
        this.mFontDataList = new java.util.ArrayList(this.mFormList.size());
        java.util.Iterator<com.aliyun.svideosdk.common.struct.form.FontForm> it = this.mFormList.iterator();
        while (it.hasNext()) {
            this.mFontDataList.add(new com.aliyun.svideo.editor.effects.caption.TextDialog.FontDateBean(it.next().getName()));
        }
        com.aliyun.svideo.editor.widget.WheelView wheelView = (com.aliyun.svideo.editor.widget.WheelView) view.findViewById(com.aliyun.svideo.editor.R.id.font_custom_view);
        this.mWva = wheelView;
        wheelView.setOffset(2);
        this.mWva.setItems(this.mFontDataList);
        this.mWva.setOnWheelViewListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass5());
    }

    private boolean isChinese(char c) {
        java.lang.Character.UnicodeBlock of = java.lang.Character.UnicodeBlock.of(c);
        return of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == java.lang.Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == java.lang.Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || of == java.lang.Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    private boolean isChinese(java.lang.String str) {
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTextOnly() {
        return this.mEditInfo.isTextOnly;
    }

    public static java.lang.String lineFeedText(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 <= charArray.length; i3++) {
            if (i >= 11) {
                sb.insert((i3 + i2) - 1, '\n');
                i2++;
                i = 1;
            }
            if (i3 == charArray.length) {
                break;
            }
            i = charArray[i3] != '\n' ? i + 1 : 0;
        }
        return sb.toString();
    }

    public static com.aliyun.svideo.editor.effects.caption.TextDialog newInstance(com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo, boolean z) {
        if (sIsShowing) {
            return null;
        }
        sIsShowing = true;
        com.aliyun.svideo.editor.effects.caption.TextDialog textDialog = new com.aliyun.svideo.editor.effects.caption.TextDialog();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putSerializable(com.aliyun.vod.log.core.AliyunLogCommon.SubModule.EDIT, editTextInfo);
        bundle.putBoolean("invert", z);
        textDialog.setArguments(bundle);
        return textDialog;
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    private void setOnClick() {
        this.mEditView.addTextChangedListener(this.textWatch);
        this.mEditView.setOnTouchListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass8());
        android.view.View view = this.mBack;
        if (view != null) {
            view.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass9());
        }
        this.mConfirm.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass10());
    }

    public void closeKeyboard() {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(this.mEditView.getWindowToken(), 0);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Dialog oncreate的时间：");
        sb.append(java.lang.System.currentTimeMillis());
        setStyle(2, com.aliyun.svideo.editor.R.style.TextDlgStyle);
    }

    @Override // android.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            onCreateDialog.setOnKeyListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass1());
            onCreateDialog.getWindow().setSoftInputMode(16);
        }
        return onCreateDialog;
    }

    @Override // android.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View inflate = android.view.View.inflate(getActivity(), com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_text, null);
        this.mEditInfo = (com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo) getArguments().getSerializable(com.aliyun.vod.log.core.AliyunLogCommon.SubModule.EDIT);
        this.mUseInvert = getArguments().getBoolean("invert");
        com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo = this.mEditInfo;
        if (editTextInfo == null) {
            dismiss();
            return inflate;
        }
        this.mShowAnimation = editTextInfo.isShowAnimation;
        this.mActionBase = editTextInfo.mAnimation;
        initTableView(inflate);
        this.mEditView = (com.aliyun.svideo.editor.widget.AutoResizingEditText) inflate.findViewById(com.aliyun.svideo.editor.R.id.qupai_overlay_content_text);
        this.mConfirm = inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_confirm);
        this.mBack = inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_back);
        this.mEditView.setTextOnly(this.mEditInfo.isTextOnly);
        this.mEditView.setText(this.mEditInfo.text);
        this.mEditView.setFontPath(this.mEditInfo.font);
        this.mEditView.setCurrentColor(this.mEditInfo.textColor);
        this.mEditView.setTextStrokeColor(this.mEditInfo.textStrokeColor);
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.fl_editText);
        android.view.ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = this.mEditInfo.layoutWidth;
        frameLayout.setLayoutParams(layoutParams);
        com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo2 = this.mEditInfo;
        if (!editTextInfo2.isTextOnly) {
            this.mEditView.setTextWidth(editTextInfo2.textWidth);
            this.mEditView.setTextHeight(this.mEditInfo.textHeight);
        }
        this.mEditView.setTextSize(android.util.TypedValue.applyDimension(2, 6.0f, getResources().getDisplayMetrics()));
        this.pageContainer = (android.widget.FrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.container);
        com.aliyun.svideo.base.widget.control.ViewStack viewStack = new com.aliyun.svideo.base.widget.control.ViewStack(8);
        this.mPagerViewStack = viewStack;
        viewStack.addView(new android.view.View(getActivity()));
        this.mPagerViewStack.addView(inflate.findViewById(com.aliyun.svideo.editor.R.id.color_container));
        this.mPagerViewStack.addView(inflate.findViewById(com.aliyun.svideo.editor.R.id.font_layout_new));
        this.mPagerViewStack.addView(inflate.findViewById(com.aliyun.svideo.editor.R.id.font_animation));
        initWLView(inflate);
        com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.color_tab_host);
        androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) inflate.findViewById(com.aliyun.svideo.editor.R.id.color_viewpager);
        com.aliyun.svideo.editor.editor.ColorViewPagerAdapter colorViewPagerAdapter = new com.aliyun.svideo.editor.editor.ColorViewPagerAdapter();
        initFontAnimationView(inflate);
        com.aliyun.svideo.editor.editor.ColorViewHolder colorViewHolder = new com.aliyun.svideo.editor.editor.ColorViewHolder(getActivity().getApplicationContext(), getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_color), false, this.mEditInfo.dTextColor);
        com.aliyun.svideo.editor.editor.ColorViewHolder colorViewHolder2 = new com.aliyun.svideo.editor.editor.ColorViewHolder(getActivity().getApplicationContext(), getString(com.aliyun.svideo.editor.R.string.alivc_editor_effect_text_stroke), true, this.mEditInfo.dTextStrokeColor);
        colorViewHolder.setItemClickListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass2());
        colorViewHolder2.setItemClickListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass3());
        colorViewPagerAdapter.addViewHolder(colorViewHolder);
        colorViewPagerAdapter.addViewHolder(colorViewHolder2);
        viewPager.setAdapter(colorViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        this.fontList = (android.widget.GridView) inflate.findViewById(com.aliyun.svideo.editor.R.id.font_list);
        com.aliyun.svideo.editor.effects.caption.TextDialog.FontAdapter fontAdapter = new com.aliyun.svideo.editor.effects.caption.TextDialog.FontAdapter(this, null);
        this.fontAdapter = fontAdapter;
        fontAdapter.setData(getFontList());
        this.fontList.setAdapter((android.widget.ListAdapter) this.fontAdapter);
        this.fontList.setItemChecked(this.mSelectedIndex, true);
        this.fontList.setOnItemClickListener(new com.aliyun.svideo.editor.effects.caption.TextDialog.AnonymousClass4());
        android.view.WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        getActivity().getSharedPreferences("AppGlobalSetting", 0).getBoolean("font_category_new", false);
        setOnClick();
        this.textLimit = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.message);
        requestFocusForKeyboard();
        if (isTextOnly()) {
            this.textLimit.setVisibility(8);
        } else {
            android.text.Editable text = this.mEditView.getText();
            if (android.text.TextUtils.isEmpty(text)) {
                this.textLimit.setText("0 / 10");
            } else {
                this.textLimit.setText(count(text.toString()) + " / 10");
            }
        }
        return inflate;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.mEditView.removeTextChangedListener(this.textWatch);
        callbackResult();
        sIsShowing = false;
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(-1, -1);
        }
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        closeKeyboard();
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        openKeyboard();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void openKeyboard() {
        this.mEditView.postDelayed(this.mOpenKeyboardRunnable, 300L);
    }

    public void requestFocusForKeyboard() {
        this.mEditView.setFocusable(true);
        this.mEditView.setFocusableInTouchMode(true);
        this.mEditView.requestFocus();
        this.mEditView.requestFocusFromTouch();
    }

    public void setOnStateChangeListener(com.aliyun.svideo.editor.effects.caption.TextDialog.OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}

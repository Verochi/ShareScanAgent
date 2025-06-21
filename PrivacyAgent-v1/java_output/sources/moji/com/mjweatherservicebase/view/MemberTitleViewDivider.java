package moji.com.mjweatherservicebase.view;

/* loaded from: classes20.dex */
public class MemberTitleViewDivider extends android.widget.LinearLayout {
    public android.widget.TextView n;
    public android.widget.ImageView t;
    public java.lang.CharSequence u;
    public boolean v;
    public android.view.View.OnClickListener w;

    public MemberTitleViewDivider(android.content.Context context) {
        this(context, null);
    }

    public MemberTitleViewDivider(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MemberTitleViewDivider(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.view.LayoutInflater.from(getContext()).inflate(moji.com.mjweatherservicebase.R.layout.member_title_divider_item, this);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, moji.com.mjweatherservicebase.R.styleable.MemberTitleViewDivider, i, moji.com.mjweatherservicebase.R.style.MemberTitleViewDivider_Default);
        this.u = obtainStyledAttributes.getText(obtainStyledAttributes.getIndex(moji.com.mjweatherservicebase.R.styleable.MemberTitleViewDivider_title_left_text));
        this.v = obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(moji.com.mjweatherservicebase.R.styleable.MemberTitleViewDivider_title_show_right_arrow), false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        android.widget.TextView textView = (android.widget.TextView) findViewById(moji.com.mjweatherservicebase.R.id.sakura_title_text);
        this.n = textView;
        textView.getPaint().setFakeBoldText(true);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(moji.com.mjweatherservicebase.R.id.ivMore);
        this.t = imageView;
        imageView.setVisibility(this.v ? 0 : 8);
        this.n.setText(this.u);
        this.t.setOnClickListener(this.w);
    }

    public void setRightArrowVisible(boolean z) {
        this.t.setVisibility(z ? 0 : 4);
    }

    public void setRightMoreInvisible() {
        android.widget.ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void setRightOnLickListener(android.view.View.OnClickListener onClickListener) {
        this.w = onClickListener;
        android.widget.ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.n.setText(charSequence);
    }
}

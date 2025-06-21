package moji.com.mjweatherservicebase.view;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lmoji/com/mjweatherservicebase/view/SubscribeIconAction;", "Lcom/moji/titlebar/DarkModeIconAction;", "defaultWhite", "", "(Z)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public abstract class SubscribeIconAction extends com.moji.titlebar.DarkModeIconAction {
    @kotlin.jvm.JvmOverloads
    public SubscribeIconAction() {
        this(false, 1, null);
    }

    @kotlin.jvm.JvmOverloads
    public SubscribeIconAction(boolean z) {
        super(moji.com.mjweatherservicebase.R.drawable.subscribe_white_icon, moji.com.mjweatherservicebase.R.drawable.subscribe_icon, z);
    }

    public /* synthetic */ SubscribeIconAction(boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}

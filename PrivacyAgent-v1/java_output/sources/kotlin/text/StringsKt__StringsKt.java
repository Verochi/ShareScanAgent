package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000h\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0012\u001a$\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\bø\u0001\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\n\u0010\n\u001a\u00020\t\"\u00020\u0002\u001a\u0016\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0002\u001a\u0016\u0010\u0007\u001a\u00020\u0006*\u00020\u00062\n\u0010\n\u001a\u00020\t\"\u00020\u0002\u001a\u0016\u0010\b\u001a\u00020\u0000*\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0002\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00062\n\u0010\n\u001a\u00020\t\"\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0000*\u00020\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0002\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0086\u0002\u001a\u0012\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000b\u001a\u0012\u0010\u0016\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u0012\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u0012\u0010\u0016\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u001c\u0010\u001a\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001a\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a\"\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0000\u001a\u001a\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0000\u001a\u001a\u0010\"\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b\u001a\u0012\u0010\"\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014\u001a\u0012\u0010$\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\u0000\u001a\u0012\u0010$\u001a\u00020\u0006*\u00020\u00062\u0006\u0010#\u001a\u00020\u0000\u001a\u0012\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010%\u001a\u00020\u0000\u001a\u0012\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010%\u001a\u00020\u0000\u001a\u001a\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000\u001a\u001a\u0010'\u001a\u00020\u0006*\u00020\u00062\u0006\u0010#\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000\u001a\u0012\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000\u001a\u0012\u0010'\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0000\u001a$\u0010(\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010(\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010*\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010*\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010+\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a$\u0010+\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u001a4\u00100\u001a\u00020\u0003*\u00020\u00002\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0003H\u0000\u001a\u001c\u00102\u001a\u00020\u0003*\u00020\u00002\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u0003\u001a\u001c\u00103\u001a\u00020\u0003*\u00020\u00002\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u0003\u001a\u001c\u00102\u001a\u00020\u0003*\u00020\u00002\u0006\u0010#\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u0003\u001a$\u00102\u001a\u00020\u0003*\u00020\u00002\u0006\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a\u001c\u00103\u001a\u00020\u0003*\u00020\u00002\u0006\u0010%\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u0003\u001a\u001c\u00104\u001a\u00020\u0006*\u00020\u00002\u0006\u0010-\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u0003\u001a\u001c\u00105\u001a\u00020\u0006*\u00020\u00002\u0006\u0010-\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u0003\u001a&\u00106\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a&\u00107\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a=\u00109\u001a\u00020\u000b*\u00020\u00002\u0006\u0010-\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b9\u0010:\u001aG\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010=*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060;2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b>\u0010?\u001a:\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010=*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060;2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a:\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010=*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060;2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a,\u00106\u001a\u00020\u000b*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060;2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a,\u00107\u001a\u00020\u000b*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060;2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a&\u0010B\u001a\u00020\u000b*\u00020\u00002\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a&\u0010B\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a&\u0010D\u001a\u00020\u000b*\u00020\u00002\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a&\u0010D\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u0003\u001a\u001f\u0010E\u001a\u00020\u0003*\u00020\u00002\u0006\u0010-\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u0003H\u0086\u0002\u001a\u001f\u0010E\u001a\u00020\u0003*\u00020\u00002\u0006\u00101\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u0003H\u0086\u0002\u001a?\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00140H*\u00020\u00002\u0006\u0010F\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bI\u0010J\u001aG\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00140H*\u00020\u00002\u000e\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060K2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bL\u0010M\u001a\u0010\u0010O\u001a\u00020N2\u0006\u0010G\u001a\u00020\u000bH\u0000\u001a?\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060H*\u00020\u00002\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060K\"\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000b¢\u0006\u0004\bP\u0010Q\u001a?\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060R*\u00020\u00002\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060K\"\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000b¢\u0006\u0004\bS\u0010T\u001a0\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060H*\u00020\u00002\n\u0010F\u001a\u00020\t\"\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000b\u001a0\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060R*\u00020\u00002\n\u0010F\u001a\u00020\t\"\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u000b\u001a1\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00060R*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0004\bU\u0010V\u001a\u0010\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060H*\u00020\u0000\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00060R*\u00020\u0000\u001a\u0018\u0010Y\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010-\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\u0018\u0010Z\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010-\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\f\u0010[\u001a\u00020\u0003*\u00020\u0006H\u0007\u001a\u0015\u0010\\\u001a\u0004\u0018\u00010\u0003*\u00020\u0006H\u0007¢\u0006\u0004\b\\\u0010]\"\u0015\u0010`\u001a\u00020\u0014*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b^\u0010_\"\u0015\u0010c\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\ba\u0010b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006d"}, d2 = {"", "Lkotlin/Function1;", "", "", "predicate", "trim", "", "trimStart", "trimEnd", "", "chars", "", "length", "padChar", "padStart", "padEnd", "Lkotlin/collections/CharIterator;", "iterator", "index", "hasSurrogatePairAt", "Lkotlin/ranges/IntRange;", "range", "substring", "subSequence", com.alibaba.sdk.android.oss.common.RequestParameters.DELIMITER, "missingDelimiterValue", "substringBefore", "substringAfter", "substringBeforeLast", "substringAfterLast", "startIndex", "endIndex", "replacement", "replaceRange", "removeRange", com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, "removePrefix", "suffix", "removeSuffix", "removeSurrounding", "replaceBefore", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "thisOffset", "other", "otherOffset", "ignoreCase", "regionMatchesImpl", "char", "startsWith", "endsWith", "commonPrefixWith", "commonSuffixWith", "indexOfAny", "lastIndexOfAny", "last", "d", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lkotlin/Pair;", "c", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findAnyOf", "findLastAnyOf", "indexOf", com.anythink.expressad.foundation.h.i.g, "lastIndexOf", "contains", "delimiters", "limit", "Lkotlin/sequences/Sequence;", "f", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "", "g", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "", "requireNonNegativeLimit", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "j", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "lineSequence", "lines", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
public class StringsKt__StringsKt extends kotlin.text.StringsKt__StringsJVMKt {
    public static final kotlin.Pair<java.lang.Integer, java.lang.String> c(java.lang.CharSequence charSequence, java.util.Collection<java.lang.String> collection, int i, boolean z, boolean z2) {
        int coerceAtMost;
        kotlin.ranges.IntProgression downTo;
        java.lang.Object obj;
        java.lang.Object obj2;
        int coerceAtLeast;
        if (!z && collection.size() == 1) {
            java.lang.String str = (java.lang.String) kotlin.collections.CollectionsKt___CollectionsKt.single(collection);
            int indexOf$default = !z2 ? indexOf$default(charSequence, str, i, false, 4, (java.lang.Object) null) : lastIndexOf$default(charSequence, str, i, false, 4, (java.lang.Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            return kotlin.TuplesKt.to(java.lang.Integer.valueOf(indexOf$default), str);
        }
        if (z2) {
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence));
            downTo = kotlin.ranges.RangesKt___RangesKt.downTo(coerceAtMost, 0);
        } else {
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(i, 0);
            downTo = new kotlin.ranges.IntRange(coerceAtLeast, charSequence.length());
        }
        if (charSequence instanceof java.lang.String) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    java.util.Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        java.lang.String str2 = (java.lang.String) obj2;
                        if (kotlin.text.StringsKt__StringsJVMKt.regionMatches(str2, 0, (java.lang.String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    java.lang.String str3 = (java.lang.String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return kotlin.TuplesKt.to(java.lang.Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = downTo.getFirst();
            int last2 = downTo.getLast();
            int step2 = downTo.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    java.util.Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        java.lang.String str4 = (java.lang.String) obj;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    java.lang.String str5 = (java.lang.String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return kotlin.TuplesKt.to(java.lang.Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String commonPrefixWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence other, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int min = java.lang.Math.min(charSequence.length(), other.length());
        int i = 0;
        while (i < min && kotlin.text.CharsKt__CharKt.equals(charSequence.charAt(i), other.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(charSequence, i2) || hasSurrogatePairAt(other, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static /* synthetic */ java.lang.String commonPrefixWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String commonSuffixWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence other, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int length = charSequence.length();
        int min = java.lang.Math.min(length, other.length());
        int i = 0;
        while (i < min && kotlin.text.CharsKt__CharKt.equals(charSequence.charAt((length - i) - 1), other.charAt((r1 - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i) - 1) || hasSurrogatePairAt(other, (r1 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ java.lang.String commonSuffixWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, char c, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return indexOf$default(charSequence, c, 0, z, 2, (java.lang.Object) null) >= 0;
    }

    public static boolean contains(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence other, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof java.lang.String) {
            if (indexOf$default(charSequence, (java.lang.String) other, 0, z, 2, (java.lang.Object) null) >= 0) {
                return true;
            }
        } else if (e(charSequence, other, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(java.lang.CharSequence charSequence, char c, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static /* synthetic */ boolean contains$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence, @org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence2) {
        if ((charSequence instanceof java.lang.String) && (charSequence2 instanceof java.lang.String)) {
            return kotlin.text.StringsKt__StringsJVMKt.equals((java.lang.String) charSequence, (java.lang.String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!kotlin.text.CharsKt__CharKt.equals(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence, @org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence2) {
        if ((charSequence instanceof java.lang.String) && (charSequence2 instanceof java.lang.String)) {
            return kotlin.jvm.internal.Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static final int d(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        int coerceAtMost;
        int coerceAtLeast;
        kotlin.ranges.IntProgression downTo;
        int coerceAtLeast2;
        int coerceAtMost2;
        if (z2) {
            coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence));
            coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(i2, 0);
            downTo = kotlin.ranges.RangesKt___RangesKt.downTo(coerceAtMost, coerceAtLeast);
        } else {
            coerceAtLeast2 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(i, 0);
            coerceAtMost2 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i2, charSequence.length());
            downTo = new kotlin.ranges.IntRange(coerceAtLeast2, coerceAtMost2);
        }
        if ((charSequence instanceof java.lang.String) && (charSequence2 instanceof java.lang.String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (!kotlin.text.StringsKt__StringsJVMKt.regionMatches((java.lang.String) charSequence2, 0, (java.lang.String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = downTo.getFirst();
        int last2 = downTo.getLast();
        int step2 = downTo.getStep();
        if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
            return -1;
        }
        while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    public static /* synthetic */ int e(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, java.lang.Object obj) {
        return d(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static final boolean endsWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, char c, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && kotlin.text.CharsKt__CharKt.equals(charSequence.charAt(getLastIndex(charSequence)), c, z);
    }

    public static final boolean endsWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence suffix, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suffix, "suffix");
        return (!z && (charSequence instanceof java.lang.String) && (suffix instanceof java.lang.String)) ? kotlin.text.StringsKt__StringsJVMKt.endsWith$default((java.lang.String) charSequence, (java.lang.String) suffix, false, 2, null) : regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(java.lang.CharSequence charSequence, char c, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static /* synthetic */ boolean endsWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static final kotlin.sequences.Sequence<kotlin.ranges.IntRange> f(java.lang.CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new kotlin.text.DelimitedRangesSequence(charSequence, i, i2, new kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z));
    }

    @org.jetbrains.annotations.Nullable
    public static final kotlin.Pair<java.lang.Integer, java.lang.String> findAnyOf(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.String> strings, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        return c(charSequence, strings, i, z, false);
    }

    public static /* synthetic */ kotlin.Pair findAnyOf$default(java.lang.CharSequence charSequence, java.util.Collection collection, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i, z);
    }

    @org.jetbrains.annotations.Nullable
    public static final kotlin.Pair<java.lang.Integer, java.lang.String> findLastAnyOf(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.String> strings, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        return c(charSequence, strings, i, z, true);
    }

    public static /* synthetic */ kotlin.Pair findLastAnyOf$default(java.lang.CharSequence charSequence, java.util.Collection collection, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i, z);
    }

    public static final kotlin.sequences.Sequence<kotlin.ranges.IntRange> g(java.lang.CharSequence charSequence, java.lang.String[] strArr, int i, boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new kotlin.text.DelimitedRangesSequence(charSequence, i, i2, new kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2(kotlin.collections.ArraysKt___ArraysJvmKt.asList(strArr), z));
    }

    @org.jetbrains.annotations.NotNull
    public static kotlin.ranges.IntRange getIndices(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new kotlin.ranges.IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ kotlin.sequences.Sequence h(java.lang.CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return f(charSequence, cArr, i, z, i2);
    }

    public static final boolean hasSurrogatePairAt(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new kotlin.ranges.IntRange(0, charSequence.length() + (-2)).contains(i) && java.lang.Character.isHighSurrogate(charSequence.charAt(i)) && java.lang.Character.isLowSurrogate(charSequence.charAt(i + 1));
    }

    public static /* synthetic */ kotlin.sequences.Sequence i(java.lang.CharSequence charSequence, java.lang.String[] strArr, int i, boolean z, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return g(charSequence, strArr, i, z, i2);
    }

    public static final int indexOf(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, char c, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof java.lang.String)) ? indexOfAny(charSequence, new char[]{c}, i, z) : ((java.lang.String) charSequence).indexOf(c, i);
    }

    public static final int indexOf(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.String string, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return (z || !(charSequence instanceof java.lang.String)) ? e(charSequence, string, i, charSequence.length(), z, false, 16, null) : ((java.lang.String) charSequence).indexOf(string, i);
    }

    public static /* synthetic */ int indexOf$default(java.lang.CharSequence charSequence, char c, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int indexOf$default(java.lang.CharSequence charSequence, java.lang.String str, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static final int indexOfAny(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.String> strings, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.Pair<java.lang.Integer, java.lang.String> c = c(charSequence, strings, i, z, false);
        if (c != null) {
            return c.getFirst().intValue();
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final int indexOfAny(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char[] chars, int i, boolean z) {
        int coerceAtLeast;
        boolean z2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof java.lang.String)) {
            return ((java.lang.String) charSequence).indexOf(kotlin.collections.ArraysKt___ArraysKt.single(chars), i);
        }
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(i, 0);
        ?? it = new kotlin.ranges.IntRange(coerceAtLeast, getLastIndex(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (kotlin.text.CharsKt__CharKt.equals(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return nextInt;
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOfAny$default(java.lang.CharSequence charSequence, java.util.Collection collection, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, (java.util.Collection<java.lang.String>) collection, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(java.lang.CharSequence charSequence, char[] cArr, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.CharIterator iterator(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new kotlin.text.StringsKt__StringsKt$iterator$1(charSequence);
    }

    public static final java.util.List<java.lang.String> j(java.lang.CharSequence charSequence, java.lang.String str, boolean z, int i) {
        requireNonNegativeLimit(i);
        int i2 = 0;
        int indexOf = indexOf(charSequence, str, 0, z);
        if (indexOf == -1 || i == 1) {
            return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        java.util.ArrayList arrayList = new java.util.ArrayList(z2 ? kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, indexOf).toString());
            i2 = str.length() + indexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            indexOf = indexOf(charSequence, str, i2, z);
        } while (indexOf != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static final int lastIndexOf(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, char c, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z || !(charSequence instanceof java.lang.String)) ? lastIndexOfAny(charSequence, new char[]{c}, i, z) : ((java.lang.String) charSequence).lastIndexOf(c, i);
    }

    public static final int lastIndexOf(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.String string, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return (z || !(charSequence instanceof java.lang.String)) ? d(charSequence, string, i, 0, z, true) : ((java.lang.String) charSequence).lastIndexOf(string, i);
    }

    public static /* synthetic */ int lastIndexOf$default(java.lang.CharSequence charSequence, char c, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(java.lang.CharSequence charSequence, java.lang.String str, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOfAny(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.Collection<java.lang.String> strings, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.Pair<java.lang.Integer, java.lang.String> c = c(charSequence, strings, i, z, true);
        if (c != null) {
            return c.getFirst().intValue();
        }
        return -1;
    }

    public static final int lastIndexOfAny(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char[] chars, int i, boolean z) {
        int coerceAtMost;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof java.lang.String)) {
            return ((java.lang.String) charSequence).lastIndexOf(kotlin.collections.ArraysKt___ArraysKt.single(chars), i);
        }
        for (coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)); -1 < coerceAtMost; coerceAtMost--) {
            char charAt = charSequence.charAt(coerceAtMost);
            int length = chars.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (kotlin.text.CharsKt__CharKt.equals(chars[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return coerceAtMost;
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(java.lang.CharSequence charSequence, java.util.Collection collection, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, (java.util.Collection<java.lang.String>) collection, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(java.lang.CharSequence charSequence, char[] cArr, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.String> lineSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return splitToSequence$default(charSequence, new java.lang.String[]{"\r\n", "\n", "\r"}, false, 0, 6, (java.lang.Object) null);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> lines(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.toList(lineSequence(charSequence));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence padEnd(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, char c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i);
        sb.append(charSequence);
        ?? it = new kotlin.ranges.IntRange(1, i - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.nextInt();
            sb.append(c);
        }
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String padEnd(@org.jetbrains.annotations.NotNull java.lang.String str, int i, char c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return padEnd((java.lang.CharSequence) str, i, c).toString();
    }

    public static /* synthetic */ java.lang.CharSequence padEnd$default(java.lang.CharSequence charSequence, int i, char c, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(charSequence, i, c);
    }

    public static /* synthetic */ java.lang.String padEnd$default(java.lang.String str, int i, char c, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(str, i, c);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence padStart(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, char c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(i);
        ?? it = new kotlin.ranges.IntRange(1, i - charSequence.length()).iterator();
        while (it.hasNext()) {
            it.nextInt();
            sb.append(c);
        }
        sb.append(charSequence);
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String padStart(@org.jetbrains.annotations.NotNull java.lang.String str, int i, char c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((java.lang.CharSequence) str, i, c).toString();
    }

    public static /* synthetic */ java.lang.CharSequence padStart$default(java.lang.CharSequence charSequence, int i, char c, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(charSequence, i, c);
    }

    public static /* synthetic */ java.lang.String padStart$default(java.lang.String str, int i, char c, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(str, i, c);
    }

    public static final boolean regionMatchesImpl(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, @org.jetbrains.annotations.NotNull java.lang.CharSequence other, int i2, int i3, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!kotlin.text.CharsKt__CharKt.equals(charSequence.charAt(i + i4), other.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence removePrefix(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence prefix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        return startsWith$default(charSequence, prefix, false, 2, (java.lang.Object) null) ? charSequence.subSequence(prefix.length(), charSequence.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String removePrefix(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.CharSequence prefix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!startsWith$default((java.lang.CharSequence) str, prefix, false, 2, (java.lang.Object) null)) {
            return str;
        }
        java.lang.String substring = str.substring(prefix.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence removeRange(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i2 < i) {
            throw new java.lang.IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        }
        if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(charSequence.length() - (i2 - i));
        sb.append(charSequence, 0, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
        sb.append(charSequence, i2, charSequence.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence removeRange(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        return removeRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence removeSuffix(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence suffix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suffix, "suffix");
        return endsWith$default(charSequence, suffix, false, 2, (java.lang.Object) null) ? charSequence.subSequence(0, charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String removeSuffix(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.CharSequence suffix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!endsWith$default((java.lang.CharSequence) str, suffix, false, 2, (java.lang.Object) null)) {
            return str;
        }
        java.lang.String substring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence removeSurrounding(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence delimiter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(charSequence, delimiter, delimiter);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence removeSurrounding(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence prefix, @org.jetbrains.annotations.NotNull java.lang.CharSequence suffix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suffix, "suffix");
        return (charSequence.length() >= prefix.length() + suffix.length() && startsWith$default(charSequence, prefix, false, 2, (java.lang.Object) null) && endsWith$default(charSequence, suffix, false, 2, (java.lang.Object) null)) ? charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length()) : charSequence.subSequence(0, charSequence.length());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String removeSurrounding(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.CharSequence delimiter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(str, delimiter, delimiter);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String removeSurrounding(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.CharSequence prefix, @org.jetbrains.annotations.NotNull java.lang.CharSequence suffix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !startsWith$default((java.lang.CharSequence) str, prefix, false, 2, (java.lang.Object) null) || !endsWith$default((java.lang.CharSequence) str, suffix, false, 2, (java.lang.Object) null)) {
            return str;
        }
        java.lang.String substring = str.substring(prefix.length(), str.length() - suffix.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceAfter(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange(str, indexOf$default + 1, str.length(), replacement).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceAfter(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange(str, indexOf$default + delimiter.length(), str.length(), replacement).toString();
    }

    public static /* synthetic */ java.lang.String replaceAfter$default(java.lang.String str, char c, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c, str2, str3);
    }

    public static /* synthetic */ java.lang.String replaceAfter$default(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceAfterLast(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange(str, lastIndexOf$default + 1, str.length(), replacement).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceAfterLast(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange(str, lastIndexOf$default + delimiter.length(), str.length(), replacement).toString();
    }

    public static /* synthetic */ java.lang.String replaceAfterLast$default(java.lang.String str, char c, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
    }

    public static /* synthetic */ java.lang.String replaceAfterLast$default(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceBefore(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange(str, 0, indexOf$default, replacement).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceBefore(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        return indexOf$default == -1 ? missingDelimiterValue : replaceRange(str, 0, indexOf$default, replacement).toString();
    }

    public static /* synthetic */ java.lang.String replaceBefore$default(java.lang.String str, char c, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c, str2, str3);
    }

    public static /* synthetic */ java.lang.String replaceBefore$default(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceBeforeLast(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange(str, 0, lastIndexOf$default, replacement).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceBeforeLast(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String replacement, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        return lastIndexOf$default == -1 ? missingDelimiterValue : replaceRange(str, 0, lastIndexOf$default, replacement).toString();
    }

    public static /* synthetic */ java.lang.String replaceBeforeLast$default(java.lang.String str, char c, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c, str2, str3);
    }

    public static /* synthetic */ java.lang.String replaceBeforeLast$default(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence replaceRange(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, int i2, @org.jetbrains.annotations.NotNull java.lang.CharSequence replacement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i2 >= i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(charSequence, 0, i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(charSequence, i2, charSequence.length());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new java.lang.IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence replaceRange(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range, @org.jetbrains.annotations.NotNull java.lang.CharSequence replacement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        return replaceRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        throw new java.lang.IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> split(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char[] delimiters, boolean z, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return j(charSequence, java.lang.String.valueOf(delimiters[0]), z, i);
        }
        java.lang.Iterable asIterable = kotlin.sequences.SequencesKt___SequencesKt.asIterable(h(charSequence, delimiters, 0, z, i, 2, null));
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        java.util.Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (kotlin.ranges.IntRange) it.next()));
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> split(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.String[] delimiters, boolean z, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            java.lang.String str = delimiters[0];
            if (!(str.length() == 0)) {
                return j(charSequence, str, z, i);
            }
        }
        java.lang.Iterable asIterable = kotlin.sequences.SequencesKt___SequencesKt.asIterable(i(charSequence, delimiters, 0, z, i, 2, null));
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        java.util.Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (kotlin.ranges.IntRange) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ java.util.List split$default(java.lang.CharSequence charSequence, char[] cArr, boolean z, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    public static /* synthetic */ java.util.List split$default(java.lang.CharSequence charSequence, java.lang.String[] strArr, boolean z, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.String> splitToSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char[] delimiters, boolean z, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return kotlin.sequences.SequencesKt___SequencesKt.map(h(charSequence, delimiters, 0, z, i, 2, null), new kotlin.text.StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.String> splitToSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.String[] delimiters, boolean z, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        return kotlin.sequences.SequencesKt___SequencesKt.map(i(charSequence, delimiters, 0, z, i, 2, null), new kotlin.text.StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ kotlin.sequences.Sequence splitToSequence$default(java.lang.CharSequence charSequence, char[] cArr, boolean z, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, cArr, z, i);
    }

    public static /* synthetic */ kotlin.sequences.Sequence splitToSequence$default(java.lang.CharSequence charSequence, java.lang.String[] strArr, boolean z, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    public static final boolean startsWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, char c, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && kotlin.text.CharsKt__CharKt.equals(charSequence.charAt(0), c, z);
    }

    public static final boolean startsWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence prefix, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        return (!z && (charSequence instanceof java.lang.String) && (prefix instanceof java.lang.String)) ? kotlin.text.StringsKt__StringsJVMKt.startsWith$default((java.lang.String) charSequence, (java.lang.String) prefix, i, false, 4, null) : regionMatchesImpl(charSequence, i, prefix, 0, prefix.length(), z);
    }

    public static final boolean startsWith(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.lang.CharSequence prefix, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        return (!z && (charSequence instanceof java.lang.String) && (prefix instanceof java.lang.String)) ? kotlin.text.StringsKt__StringsJVMKt.startsWith$default((java.lang.String) charSequence, (java.lang.String) prefix, false, 2, null) : regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(java.lang.CharSequence charSequence, char c, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static /* synthetic */ boolean startsWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    public static /* synthetic */ boolean startsWith$default(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence subSequence(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substring(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substring(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.ranges.IntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        java.lang.String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringAfter(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(indexOf$default + 1, str.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringAfter(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(indexOf$default + delimiter.length(), str.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ java.lang.String substringAfter$default(java.lang.String str, char c, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    public static /* synthetic */ java.lang.String substringAfter$default(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String substringAfterLast(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(lastIndexOf$default + 1, str.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringAfterLast(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(lastIndexOf$default + delimiter.length(), str.length());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ java.lang.String substringAfterLast$default(java.lang.String str, char c, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    public static /* synthetic */ java.lang.String substringAfterLast$default(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringBefore(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(0, indexOf$default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringBefore(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = indexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(0, indexOf$default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ java.lang.String substringBefore$default(java.lang.String str, char c, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static /* synthetic */ java.lang.String substringBefore$default(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringBeforeLast(@org.jetbrains.annotations.NotNull java.lang.String str, char c, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, c, 0, false, 6, (java.lang.Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(0, lastIndexOf$default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String substringBeforeLast(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String delimiter, @org.jetbrains.annotations.NotNull java.lang.String missingDelimiterValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((java.lang.CharSequence) str, delimiter, 0, false, 6, (java.lang.Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        java.lang.String substring = str.substring(0, lastIndexOf$default);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ java.lang.String substringBeforeLast$default(java.lang.String str, char c, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    public static /* synthetic */ java.lang.String substringBeforeLast$default(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final boolean toBooleanStrict(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (kotlin.jvm.internal.Intrinsics.areEqual(str, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
            return true;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(str, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            return false;
        }
        throw new java.lang.IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Boolean toBooleanStrictOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (kotlin.jvm.internal.Intrinsics.areEqual(str, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
            return java.lang.Boolean.TRUE;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(str, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            return java.lang.Boolean.FALSE;
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.CharSequence trim(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = kotlin.text.CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trim(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trim(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char... chars) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = kotlin.collections.ArraysKt___ArraysKt.contains(chars, charSequence.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trim(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = predicate.invoke(java.lang.Character.valueOf(str.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trim(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull char... chars) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = kotlin.collections.ArraysKt___ArraysKt.contains(chars, str.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trimEnd(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!kotlin.text.CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trimEnd(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i = length - 1;
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i < 0) {
                return "";
            }
            length = i;
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trimEnd(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char... chars) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!kotlin.collections.ArraysKt___ArraysKt.contains(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trimEnd(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        java.lang.CharSequence charSequence;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!predicate.invoke(java.lang.Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trimEnd(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull char... chars) {
        java.lang.CharSequence charSequence;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!kotlin.collections.ArraysKt___ArraysKt.contains(chars, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trimStart(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!kotlin.text.CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trimStart(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!predicate.invoke(java.lang.Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence trimStart(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull char... chars) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!kotlin.collections.ArraysKt___ArraysKt.contains(chars, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trimStart(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> predicate) {
        java.lang.CharSequence charSequence;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(java.lang.Character.valueOf(str.charAt(i))).booleanValue()) {
                charSequence = str.subSequence(i, str.length());
                break;
            }
            i++;
        }
        return charSequence.toString();
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trimStart(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull char... chars) {
        java.lang.CharSequence charSequence;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            }
            if (!kotlin.collections.ArraysKt___ArraysKt.contains(chars, str.charAt(i))) {
                charSequence = str.subSequence(i, str.length());
                break;
            }
            i++;
        }
        return charSequence.toString();
    }
}

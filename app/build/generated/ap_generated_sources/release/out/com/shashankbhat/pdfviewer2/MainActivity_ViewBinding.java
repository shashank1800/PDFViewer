// Generated code from Butter Knife. Do not modify!
package com.shashankbhat.pdfviewer2;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import es.voghdev.pdfviewpager.library.PDFViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.linearLayout, "field 'linearLayout'", LinearLayout.class);
    target.pdfViewPager = Utils.findRequiredViewAsType(source, R.id.pdfViewPager, "field 'pdfViewPager'", PDFViewPager.class);
    target.showPdfButton = Utils.findRequiredViewAsType(source, R.id.show_pdf, "field 'showPdfButton'", Button.class);
    target.url_edit_text = Utils.findRequiredViewAsType(source, R.id.url_edit_text, "field 'url_edit_text'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linearLayout = null;
    target.pdfViewPager = null;
    target.showPdfButton = null;
    target.url_edit_text = null;
  }
}

package views.webview;

import presenters.screenpresenter.ScreenView;
import presenters.screenpresenter.ScreenViewModel;

public class WebView implements ScreenView {
    @Override
    public void showView(ScreenViewModel model) {
        System.out.println("Showing web view...");
    }
}

package views.pdfview;

import presenters.printpresenter.PrintView;
import presenters.printpresenter.PrintViewModel;

public class PdfView implements PrintView {
    @Override
    public void showPrintView(PrintViewModel model) {
        System.out.println("Showing print view...");
    }
}

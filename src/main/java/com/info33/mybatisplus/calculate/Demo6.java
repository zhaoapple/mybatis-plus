//package com.info33.mybatisplus.calculate;
//
//import com.itextpdf.text.pdf.PdfReader;
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import org.apache.poi.xslf.usermodel.XMLSlideShow;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class Demo6 {
//    static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
//    static final int wdFormatPDF = 17;// word转PDF 格式
//
//    public static void main(String[] args) throws IOException {
//		word2pdf("F:\\6\\3344.doc",
//				"F:\\6\\1197.pdf");
//        int pdfPage = getPdfPage("F:\\6\\1197.pdf");
//        System.out.println("pdfPage = " + pdfPage);
////        int pdfPage = getPdfPage("xxx.pdf");
////        System.out.println(pdfPage);
////        int excelPage = countExcelPage("xxx.xlsx");
////        System.out.println(excelPage);
////        int PPTPage = countPPTPage("xxx.ppt");
////        System.out.println(PPTPage);
//
//
//    }
//
//    /**
//     * 计算Word转化成的pdf格式文档的页数
//     * @param filepath 文件路径
//     * @return pagecount页数
//     */
//    public static int getPdfPage(String filepath){
//        int pagecount = 0;
//        PdfReader reader;
//        try {
//            reader = new PdfReader(filepath);
//            pagecount= reader.getNumberOfPages();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(pagecount);
//        return pagecount;
//    }
//
//    /**
//     * 计算Excel格式文档的页数
//     * @return result 页数
//     */
//    public static int countExcelPage(String filePath){
//        try{
//            InputStream myxls = new FileInputStream(filePath);
//            XSSFWorkbook wb     = new XSSFWorkbook(myxls);
//
//            int result = wb.getNumberOfSheets() ;
//            return result ;
//
//        }catch(Exception e){
//            e.printStackTrace() ;
//            return -1 ;
//        }
//    }
//    /**
//     * 计算PPT格式文档的页数
//     * @param filePath 文件路径
//     * @return pages 页数
//     */
//    public static int countPPTPage(String filePath) throws IOException{
//        FileInputStream fis = new FileInputStream(filePath);
//        XMLSlideShow pptxfile = new XMLSlideShow(fis);
//        int pages = pptxfile.getSlides().length;
//        return pages;
//    }
//
//    /**
//     * 将Word文件装换为PDF格式的
//     * @param source 源文件路径
//     * @param target 目标文件路径
//     * @return 表示转换是否成功
//     */
//    public static boolean word2pdf(String source, String target) {
//        System.out.println("Word转PDF开始启动...");
//        long start = System.currentTimeMillis();
//        ActiveXComponent app = null;
//        try {
//            app = new ActiveXComponent("Word.Application");
//            app.setProperty("Visible", false);
//            Dispatch docs = app.getProperty("Documents").toDispatch();
//            System.out.println("打开文档：" + source);
//            Dispatch doc = Dispatch.call(docs, "Open", source, false, true).toDispatch();
//            System.out.println("转换文档到PDF：" + target);
//            File tofile = new File(target);
//            if (tofile.exists()) {
//                tofile.delete();
//            }
//            Dispatch.call(doc, "SaveAs", target, wdFormatPDF);
//            Dispatch.call(doc, "Close", false);
//            long end = System.currentTimeMillis();
//            System.out.println("转换完成，用时：" + (end - start) + "ms");
//            return true;
//        } catch (Exception e) {
//            System.out.println("Word转PDF出错：" + e.getMessage());
//            return false;
//        } finally {
//            if (app != null) {
//                app.invoke("Quit", wdDoNotSaveChanges);
//            }
//        }
//    }
//}
//
//

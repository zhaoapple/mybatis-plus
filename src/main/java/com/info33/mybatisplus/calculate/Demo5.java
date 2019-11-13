//package com.info33.mybatisplus.calculate;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//
//public class Demo5 {
//    public static void main(String[] args) {
//        String filePath = "F:\\6\\111.doc";// word文档所在路径
//        // 建立ActiveX部件
//        ActiveXComponent wordCom = new ActiveXComponent("Word.Application");
//        //word应用程序不可见
//        wordCom.setProperty("Visible", false);
//        // 返回wrdCom.Documents的Dispatch
//        Dispatch wrdDocs = wordCom.getProperty("Documents").toDispatch();//Documents表示word的所有文档窗口（word是多文档应用程序）
//        // 调用wrdCom.Documents.Open方法打开指定的word文档，返回wordDoc
//        Dispatch wordDoc = Dispatch.call(wrdDocs, "Open", filePath, false, true, false).toDispatch();
//        Dispatch selection = Dispatch.get(wordCom, "Selection").toDispatch();
//        int pages = Integer.parseInt(Dispatch.call(selection, "information", 4).toString());//总页数 //显示修订内容的最终状态
//        System.out.println(pages);
//        //关闭文档且不保存
//        Dispatch.call(wordDoc, "Close", new Variant(false));
//        //退出进程对象
//        wordCom.invoke("Quit", new Variant[]{});
//    }
//}

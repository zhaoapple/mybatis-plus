package com.info33.mybatisplus.calculate;

public class fybxd {
//    public static void main(String[] args) {
//
//        System.out.println("------------------------------费用报销------------------------------");
//        String wglhresult21 = "";
//        String wglhresult22 = "";
//
//        String sql = "select * from _app_fybxd where status=2 and erp_status=0 ";
//
//        List<Map<String, Object>> maplist = dao.getList(sql, null);
//        System.out.println(maplist.toString());
//        if (maplist.size() != 0) {
//            Service se = new Service();
//            ServiceSoap sep = se.getServiceSoap();
//            // 组装erp数据
//            for (Map<String, Object> map2 : maplist) {
//                // 凭证1(APINV)
//                // 凭证号1
//                String muser0 = map2.get("xm").toString();
//                String usersql = "select * from _erp_users where vndnam='" + muser0 + "'";
//                Map<String, Object> usermap = dao.getMap(usersql, null);
//                String muser = "0" + usermap.get("vendor").toString();
//
//                String fybxdid = map2.get("id").toString();// 费用报销id
//                String sql2 = "SELECT a.*,SUM(je)AS mamnt FROM _app_fybxd_mx AS a WHERE fybxd_id=" + fybxdid
//                        + "  GROUP BY a.km";
//                List<Map<String, Object>> mxlist = dao.getList(sql2, null);
//                /**
//                 * 需要一个科目来生成凭证
//                 * 在凭证中循环
//                 */
//                for (Map<String, Object> m2 : mxlist) {
//
//                    System.out.println("-----接口第一次   获取最大凭证号-----" + sep.getMaxJnen());
//                    System.out.println("-----接口第一次   获取最大凭证号-----" + sep.getMaxJnen());
//                    System.out.println("-----接口第一次   获取最大凭证号-----" + sep.getMaxJnen());
//
//                    String mjnen0 = sep.getMaxJnen().substring(2);
//                    DecimalFormat df = new DecimalFormat("0000000");
//                    String mjnen1 = "OX" + df.format(Integer.parseInt(mjnen0) + 3);
//                    String mdte1 = sep.getDate();
//                    String mtim1 = sep.getTime();
//                    String mmms1 = sep.getMms();
//
//                    String mtrno0 = sep.getMaxTrno();// 事件号-----------------------
//
//                    System.out.println("-----接口获取最大事件号----" + mtrno0);
//                    System.out.println("-----接口获取最大事件号----" + mtrno0);
//                    System.out.println("-----接口获取最大事件号----" + mtrno0);
//                    Calendar cal = Calendar.getInstance();
//                    String myear = String.valueOf(cal.get(Calendar.YEAR));
//
//                    String date0 = map2.get("pzrq").toString();
//                    String newdate = date0.substring(0, 4) + date0.substring(5, 7) + date0.substring(8, 10);
//                    String newtime = date0.substring(11, 13) + date0.substring(14, 16) + date0.substring(17, 19);
//
//                    // 创建凭证头
//                    String createresult1 = sep.createGHHtmp(mjnen1, "BFIN06", mdte1, mtim1, mmms1);
//
//                    System.out.println("创建凭证头1-APINV返回=========" + createresult1);
//                    if ("OK".equals(createresult1)) {// 开始写凭证头
//                        System.out.println(m2);
//                        System.out.println(m2);
//                        System.out.println(m2);
//
//                        String fybm = m2.get("fybm").toString().trim();
//                        String glfy = m2.get("glfy").toString().trim();
//                        String zjlz = null == m2.get("zjlz") ? " " : m2.get("zjlz").toString().trim();
//
//                        String mcoa0 = m2.get("km").toString().trim(); // 科目值----------------------------------
//                        String mcoa = fybm + mcoa0;
//                        String mamnt = m2.get("mamnt").toString();
//
//                        String mdgr = "BIJUR";
//                        String mbook = "ACTCNY";
//                        String mperd = map2.get("qd").toString();// 期段------------------------------------
//                        String mevnt1 = "APINV";
//                        String mtrno = df.format(Integer.parseInt(mtrno0) + 3);
//                        String mjmnd = "APINV";
//
//                        // 写凭证头1
//                        System.out.println("-----入参事件号1----" + mtrno);
//                        System.out.println("-----入参事件号1----" + mtrno);
//                        //计算总金额
//                        BigDecimal totalMoney = new BigDecimal("0");
//                        int num = 1;
//                        for (Map<String, Object> m3 : mxlist) {
//                            BigDecimal b2 = new BigDecimal(m3.get("mamnt").toString());
//                            totalMoney = totalMoney.add(b2);
//                            num++;
//                        }
//                        System.out.println("--------写入的总行数为："+num);
//                        System.out.println("--------写入的总金额为："+totalMoney);
//                        String aa = sep.writeGHH(mcoa, totalMoney.toString(), mdgr, mbook, myear, mperd, String.valueOf(num), mevnt1, mjmnd, mtrno,
//                                "APINV", "BFIN06", mdte1, mtim1, mmms1);
//                        sep.chgGHHDAYTIME(myear, mperd, "BFIN06", mdte1, mtim1, mmms1, newdate, newtime);
//
//                        System.out.println("-----写凭证头1-APINV----" + aa);
//                        System.out.println("-----写凭证头1-APINV----" + aa);
//                        System.out.println("-----写凭证头1-APINV----" + aa);
//
//                        // 创建凭证行1
//                        String mdteh1 = sep.getDate();
//                        String mtimh1 = sep.getTime();
//                        String mmmsh1 = sep.getMms();
//                        String glhresult1 = sep.createGLHtmp("BFIN06", mdteh1, mtimh1, mmmsh1);
//                        System.out.println("创建凭证行1-APINV-------------------------" + glhresult1);
//                        if ("OK".equals(glhresult1)) {
//                            // 写凭证行1
//                            String mdes = muser + muser0 + "费用报销";// 行说明
//                            String mdes1 = muser0;// 报销凭证注解1-------------------------
//                            String mdes2 = "";// 报销凭证注解2----------------------
//                            String mperd2 = map2.get("qd").toString();// 期段------------------------------------
//                            String mamnt2 = m2.get("mamnt").toString();
//                            // 写凭证行
//                            System.out.println("------------------APINV写行参数-------------");
//                            System.out.println("fybm===================>" + fybm + "---------");
//                            System.out.println("glfy===================>" + glfy + "----------");
//                            System.out.println("mcoa0科目==================>" + mcoa0 + "---------");
//                            System.out.println("zjlz==================>" + zjlz + "-----------");
//                            System.out.println("muser==================>" + muser + "---------");
//                            for (Map<String, Object> m3 : mxlist) {
//                                String mamnt3 = m3.get("mamnt").toString();
//                                System.out.println("各行mamnt单行金额为==================>" + mamnt3 + "---------");
//                            }
//                            System.out.println("totalMoney总金额==================>" + totalMoney + "---------");
//
////							wglhresult21 = sep.writeGLHA(mcoa, mjnen1, mdes, mdes1, mdes2, "APINV", mamnt2, mdgr, mbook,
////									myear, mperd2, "1", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime, muser, fybm,
////									glfy, mcoa0, zjlz);
////							System.out.println("写凭证行1--------" + wglhresult21);
////							wglhresult22 = sep.writeGLHA(mcoa, mjnen1, mdes, mdes1, mdes2, "APINV", "10", mdgr,
////									mbook, myear, mperd2, "2", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime,
////									muser, fybm, glfy, mcoa0, zjlz);
////							System.out.println("-----写 凭证行2返回------" + wglhresult22);
////							String wglhresult23 = sep.writeGLHA(mcoa, mjnen1, mdes, mdes1, mdes2, "APINV", "20", mdgr,
////									mbook, myear, mperd2, "3", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime,
////									muser, fybm, glfy, mcoa0, zjlz);
////							System.out.println("-----写 凭证行3返回------" + wglhresult23);
//
//
//                            //第一行生成凭证行，计算总金额，不参与循环
//                            wglhresult21 = sep.writeGLHA(mcoa, mjnen1, mdes, mdes1, mdes2, "APINV", totalMoney.toString(), mdgr, mbook,
//                                    myear, mperd2, "1", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime, muser, fybm,
//                                    glfy, mcoa0, zjlz);
//                            System.out.println("写凭证行1--------" + wglhresult21);
//                            for(int i=1;i<=mxlist.size();i++) {
//                                String sumJe = mxlist.get(i-1).get("mamnt").toString();
//                                String fybm1 = mxlist.get(i-1).get("fybm").toString().trim();
//                                String glfy1 = mxlist.get(i-1).get("glfy").toString().trim();
//                                String zjlz1 = null == mxlist.get(i-1).get("zjlz") ? " " : mxlist.get(i-1).get("zjlz").toString().trim();
//                                String mcoa01 = mxlist.get(i-1).get("km").toString().trim(); // 科目值----------------------------------
//                                String mcoa1 = fybm1 + mcoa01;
//                                String res3 = sep.testWriteGLHA(mcoa, mjnen1, mdes, mdes1, mdes2, "APINV", mamnt, mdgr, mbook, myear, mperd,
//                                        String.valueOf(i+1), "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime, muser, fybm, glfy, mcoa01, zjlz1);
//                                System.out.println("-----开始写第"+(i+1)+"凭证行，测试------"+res3);
//                                wglhresult22 = sep.writeGLHA(mcoa1, mjnen1, mdes, mdes1, mdes2, "APINV", sumJe, mdgr,
//                                        mbook, myear, mperd2, String.valueOf(i+1), "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime,
//                                        muser, fybm1, glfy1, mcoa01, zjlz1);
//                                System.out.println("-----写 凭证行"+(i+1)+"返回------" + wglhresult22);
//                            }
//
////							wglhresult21 = sep.writeGLHA("0001000", mjnen1, mdes, mdes1, mdes2, "APINV", "40", mdgr, mbook,
////									myear, mperd2, "1", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime, "09240011", "000",
////									"1001", "1000", "1021");
////							System.out.println("写凭证行1--------" + wglhresult21);
////							wglhresult22 = sep.writeGLHA("0001000", mjnen1, mdes, mdes1, mdes2, "APINV", "10", mdgr,
////									mbook, myear, mperd2, "2", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime,
////									"09240011", "000", "1001", "1000", "1021");
////							System.out.println("-----写 凭证行2返回------" + wglhresult22);
////							String wglhresult23 = sep.writeGLHA("0001000", mjnen1, mdes, mdes1, mdes2, "APINV", "20", "BIJUR",
////									"ACTCNY", myear, mperd2, "3", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime,
////									"09240011", "000", "1001", "1022", "1021");
////							System.out.println("-----写 凭证行3返回------" + wglhresult23);
////							String wglhresult24 = sep.writeGLHA("0001000", mjnen1, mdes, mdes1, mdes2, "APINV", "10", mdgr,
////									mbook, myear, mperd2, "4", "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime,
////									"09240011", "000", "1001", "1021", "1021");
////							System.out.println("-----写 凭证行4返回------" + wglhresult24);
//
//                            sep.chgGLHDAYTIME(myear, mperd2, "BFIN06", mdteh1, mtimh1, mmmsh1, newdate, newtime);
//                        }
////						String mtsql = "update _app_fybxd_mx set sjh1='" + mtrno + "'where fybxd_id='" + fybxdid
////								+ "'and km='" + m2.get("km").toString() + "'";
//                        String mtsql = "update _app_fybxd_mx set sjh1='" + mtrno + "'where fybxd_id='" + fybxdid+"'";
//                        dao.CUD(mtsql, null);
//                    }
//
//                    // 凭证2(10MPAY)
//
//                    // 凭证号2
//                    System.out.println("-----接口第2次   获取最大凭证号-----" + sep.getMaxJnen());
//                    System.out.println("-----接口第2次   获取最大凭证号-----" + sep.getMaxJnen());
//                    System.out.println("-----接口第2次   获取最大凭证号-----" + sep.getMaxJnen());
//                    String mjnen00 = sep.getMaxJnen().substring(2);
//                    // DecimalFormat df=new DecimalFormat("00000000");
//                    String mjnen2 = "OX" + df.format(Integer.parseInt(mjnen00) + 4);
//
//                    String mdte4 = sep.getDate();
//                    String mtim4 = sep.getTime();
//                    String mmms4 = sep.getMms();
//
//                    // 创建凭证头
//                    String createresult2 = sep.createGHHtmp(mjnen2, "BFIN06", mdte4, mtim4, mmms4);
//
//                    if ("OK".equals(createresult2)) {// 写凭证头
//                        String fybm = m2.get("fybm2").toString().trim();
//                        String glfy = m2.get("glfy2").toString().trim();
//
//                        String zjlz = null == m2.get("zjlz2") ? " " : m2.get("zjlz2").toString().trim();
//
//                        // 创建凭证头
//                        String mcoa0 = m2.get("km2").toString().trim(); // 科目值----------------------------------
//                        String mcoa = fybm + mcoa0;
//                        String mamnt = m2.get("mamnt").toString();
//
//                        String mdgr = "BIJUR";
//                        String mbook = "ACTCNY";
//
//                        // String myear = map2.get("pzrq").toString().replaceAll("-", "");
//                        // 年度-----------------------------------
//
//                        String mperd = map2.get("qd").toString();// 期段------------------------------------
//
//                        String mevnt1 = "10MPAY";
//
//                        String mtrno22 = sep.getMaxTrno();// 事件号-----------------------
//                        System.out.println("接口第2次获取最大事件号" + mtrno22);
//                        System.out.println("接口第2次获取最大事件号" + mtrno22);
//                        System.out.println("接口第2次获取最大事件号" + mtrno22);
//                        System.out.println("接口第2次获取最大事件号" + mtrno22);
//                        String mtrno = df.format(Integer.parseInt(mtrno22) + 4);
//
//                        // if(null!=map2.get("ykdh")||!("").equals(map2.get("ykdh").toString().trim()))
//                        // {
//                        // String ykdh=map2.get("ykdh").toString().trim();
//                        // String yksql="update _app_yksq set sjh2='"+mtrno+"'where ykdh= '"+ykdh+"'";
//
//                        // dao.CUD(yksql, null);
//                        // }
//
//                        String mjmnd = "10MPAY";
//                        System.out.println("-----------入参事件号2----------" + mtrno);
//                        System.out.println("-----------入参事件号2----------" + mtrno);
//                        System.out.println("-----------入参事件号2----------" + mtrno);
//                        System.out.println("-----------入参事件号2----------" + mtrno);
//                        sep.writeGHH(mcoa, mamnt, mdgr, mbook, myear, mperd, "1", mevnt1, mjmnd, mtrno, "MPAY",
//                                "BFIN06", mdte4, mtim4, mmms4);
//
//                        sep.chgGHHDAYTIME(myear, mperd, "BFIN06", mdte4, mtim4, mmms4, newdate, newtime);
//
//                        // 创建凭证行
//                        String mdteh2 = sep.getDate();
//                        String mtimh2 = sep.getTime();
//                        String mmmsh2 = sep.getMms();
//                        String glhresult1 = sep.createGLHtmp("BFIN06", mdteh2, mtimh2, mmmsh2);
//                        if ("OK".equals(glhresult1)) {
//                            // 写凭证行1
//                            // String mcoa=""; //科目值----------------------------------
//                            // String mdes = map2.get("bz").toString();
//                            String mdes = muser + muser0 + "费用报销";// 行说明
//                            String mdes1 = muser0;// 报销凭证注解1-------------------------
//                            String mdes2 = "";// 报销凭证注解2----------------------
//
//                            String mperd2 = map2.get("qd").toString();// 期段------------------------------------
//                            // String mline2="1";//凭证行数量----------------------
//
//                            // String mres2=UUID.randomUUID().toString();//原因码--------------------------
//
//                            // 单行金额
//                            String mamnt2 = m2.get("mamnt").toString();
//                            // 写凭证行
//                            System.out.println("-------10MPAY写入的参数--------");
//                            System.out.println("fybm===================>" + fybm);
//                            System.out.println("glfy===================>" + glfy);
//                            System.out.println("mcoa0=================>" + mcoa0);
//                            System.out.println("zjlz=================>" + zjlz + "-----------");
//                            System.out.println("ykdh------------->" + map2.get("ykdh"));
//                            if (null != map2.get("ykdh")) {
//
//                                wglhresult21 = sep.writeGLHB(mcoa, mjnen2, mdes, mdes1, mdes2, "APINV", mamnt2, mdgr,
//                                        mbook, myear, mperd2, "1", "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime,
//                                        muser, fybm, glfy, mcoa0, zjlz);
//                                wglhresult22 = sep.writeGLHB(mcoa, mjnen2, mdes, mdes1, mdes2, "MPAY", mamnt2, mdgr,
//                                        mbook, myear, mperd2, "2", "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime,
//                                        muser, fybm, glfy, mcoa0, zjlz);
//                                System.out.println("writeGLHB返回----wglhresult21-----------" + wglhresult21);
//                                System.out.println("writeGLHB返回----wglhresult22-----------" + wglhresult22);
//                                sep.chgGLHDAYTIME(myear, mperd2, "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime);
//
//                            } else {
//                                String res1 = sep.testWriteGLHA(mcoa, mjnen2, mdes, mdes1, mdes2, "MPAY", mamnt2, mdgr,
//                                        mbook, myear, mperd2, "1", "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime,
//                                        muser, fybm, glfy, mcoa0, zjlz);
//                                System.out.println("-------10Mpay  测试凭证行1返回--------------" + res1);
//                                System.out.println("-------10Mpay  测试凭证行1返回--------------" + res1);
//                                wglhresult21 = sep.writeGLHA(mcoa, mjnen2, mdes, mdes1, mdes2, "MPAY", mamnt2, mdgr,
//                                        mbook, myear, mperd2, "1", "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime,
//                                        muser, fybm, glfy, mcoa0, zjlz);
//
//                                String res2 = sep.testWriteGLHA(mcoa, mjnen2, mdes, mdes1, mdes2, "MPAY", mamnt2, mdgr,
//                                        mbook, myear, mperd2, "2", "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime,
//                                        muser, fybm, glfy, mcoa0, zjlz);
//                                System.out.println("-------10Mpay  测试凭证行2返回--------------" + res2);
//                                System.out.println("-------10Mpay  测试凭证行2返回--------------" + res2);
//                                wglhresult22 = sep.writeGLHA(mcoa, mjnen2, mdes, mdes1, mdes2, "MPAY", mamnt2, mdgr,
//                                        mbook, myear, mperd2, "2", "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime,
//                                        muser, fybm, glfy, mcoa0, zjlz);
//                                sep.chgGLHDAYTIME(myear, mperd2, "BFIN06", mdteh2, mtimh2, mmmsh2, newdate, newtime);
//                            }
////							String mtsql = "update _app_fybxd_mx set sjh2='" + mtrno + "'where fybxd_id='" + fybxdid
////									+ "'and km='" + m2.get("km").toString() + "'";
//                            String mtsql = "update _app_fybxd_mx set sjh2='" + mtrno + "'where fybxd_id='" + fybxdid+"'";;
//                            dao.CUD(mtsql, null);
//                        }
//                    }
//                    int id = Integer.parseInt(map2.get("id").toString());
//                    String sql3 = "update _app_fybxd set erp_status=1 where id=" + id;
//                    dao.CUD(sql3, null);
//                    break;
//                }
//                System.out.println("okokokokoko--------------------------fybxd");
//            }
//        }
//        Map<String, Object> rm = new HashMap<String, Object>();
//        rm.put("state", "ok");
//        return rm;
//
//    }
}

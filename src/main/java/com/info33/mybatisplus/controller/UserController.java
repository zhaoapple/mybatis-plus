package com.info33.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.info33.mybatisplus.entity.Demo;
import com.info33.mybatisplus.entity.User;
import com.info33.mybatisplus.service.DemoService;
import com.info33.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    DemoService demoService;

    @GetMapping("ff")
    @ResponseBody
    public List getLevel4(){
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletionService<User> completionService = new ExecutorCompletionService<User>(threadPool);
        List returnInfos = new ArrayList();
        for (int i = 1; i < 3; i++) {
//            CompletionService用于提交一组Callable任务，其take方法返回已完成的一个Callable任务对应的Future对象。
            int j = i;
            completionService.submit(new Callable<User>() {
                @Override
                public User call() throws Exception {
                    User user1 = service.getById(j);
                    return user1;
                };
            });
            try {
                User user = completionService.take().get();
                returnInfos.add(user);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return returnInfos;
    }
    @PostMapping("ee")
    @ResponseBody
    public void getLevel4(@RequestBody Map map){
        for (Object o : map.keySet()) {
            System.out.println("map.get(o) = " + map.get(o));
        }
    }


    @GetMapping("dd")
    @ResponseBody
    public Boolean getLevel3(){
        /**
         * 匿名内部类
         */
        new Thread(){
            public void run(){
//                User user = new User();
//                user.setAge(10);
//                user.setGender("男");
//                user.setAddress("10000000000");
//                user.setName("test");
//                for (int i = 0; i < 1000; i++) {
//                    service.save(user);
//                    System.out.println(Thread.currentThread().getName()+"：第"+i+"次执行");
//                }
                Map map = new HashMap();
                map.put("age",10);
                service.removeByMap(map);
            }
        }.start();
        new Thread(
            new Runnable() {
                @Override
                public void run() {
//                    Demo demo = new Demo();
//                    demo.setName("测试");
//                    demo.setPid(100);
//                    for (int i = 0; i < 1000; i++) {
//                        demoService.save(demo);
//                        System.out.println(Thread.currentThread().getName()+"：第"+i+"次执行");
//                    }
                    Map map = new HashMap();
                    map.put("pid",100);
                    demoService.removeByMap(map);
                }
            }
        ).start();
        return true;
    }
    @GetMapping("cc")
    @ResponseBody
    public List getLevel2(){
        //主线程去干自己的事
        List<Demo> list = demoService.list();
        new Thread(){
            public synchronized void  run(){
                int i = 1000;
                while(i>0){
                    System.out.println("----"+Thread.currentThread().getName()+"----"+i);
                    i--;
                }
            }
        }.start();
        return list;
    }
    @GetMapping("bb")
    @ResponseBody
    public Integer getLevel(){
        Long id = 1L;
        Integer count = 0;
        Demo id1 = demoService.getOne(new QueryWrapper<Demo>().eq("id", id));
        if(id1.getPid() == 0){
            return 1;
        }else{
            while(id != 0){
                Demo one = demoService.getOne(new QueryWrapper<Demo>().eq("id", id));
                id = one.getPid();
                count ++;
            }
        }
        System.out.println(count);
        return count;
    }


    @GetMapping("aa")
    @ResponseBody
    public List createTable2(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.apply("DATE_FORMAT(create_time,'%e') = 20");
//        wrapper.last("where DATE_FORMAT(create_time,'%e') = 20");
        wrapper.select("*","DATE_FORMAT(create_time,'%e') as dateStr");
        return service.list(wrapper);
    }



    @RequestMapping("/save")
    public User save(){
        User user = new User();
        user.setName("王五");
        user.setAddress("江苏");
        user.setAge(16);
        user.setGender("男");
        service.save(user);
        return service.getOne(new QueryWrapper<User>(user));
    }

    @RequestMapping("/delete")
    public Boolean delete(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",null);
        map.put("gender",null);
        return service.removeByMap(map);
    }

    @RequestMapping("/update")
    public Boolean update(){
//        User user = new User();
//        user.setName("王");
//        user.setAge(19);
//        user.setGender("女");
//        int count = service.count(new QueryWrapper<User>(user));
//        System.out.println(count);
//        User user1 = new User();
//        user1.setAddress("苏州");
        service.update(new UpdateWrapper<User>().eq("name","王四").set("age",56).set("name",null));
        return true;
    }

    @RequestMapping("/list")
    public List<User> list(){
        int count = service.count();
        System.out.println(count);

        User user = new User();
        user.setName("王四");
        user.setAge(19);
        user.setGender("女");

        return service.list(new QueryWrapper<User>(user));
    }

    @RequestMapping("/page")
    public IPage<User> page(){
        IPage<User> page = new Page<User>(0,2);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        return service.page(page,queryWrapper);
    }




//    @RequestMapping("/user")
//    @ResponseBody
//    public void index(){
//        User user = new User();
//        user.setName("11");
//        QueryWrapper<User> wrapper = new QueryWrapper(user);
////        List<Integer> list = new ArrayList<>();
////        list.add(2);
////        list.add(3);
////        wrapper
////        .orderBy(true,true,"id")
////        .groupBy("name").having("sum(age)>30");
////        wrapper.eq("name","11").and(value ->value.le("age",10));
//        User one = service.getOne(wrapper);
//        System.out.println(one);
//
////        List<User> list1 = service.list(wrapper);
////        for (User user1 : list1) {
////            System.out.println(user1);
////        }
//    }
//    @RequestMapping("/insert")
//    public void index2(){
//        User user = new User();
//        user.setAge(10);
//        user.setName("哈哈");
////        service.save(user);
//        QueryWrapper<User> wrapper = new QueryWrapper<User>();
////        List<User> ages = service.list(wrapper.between("age", 0, 8));
//        IPage<User> page = service.page(new Page<>(1, 2), wrapper.like("name", "小"));
//        List<User> records = page.getRecords();
//        for (User age : records) {
//            System.out.println(age);
//        }
//    }
//    @RequestMapping("/page")
//    public IPage<User> index5(){
//        return service.page(new Page<User>(0,2));
//    }
//    @RequestMapping("/update")
//    public boolean index6(){
//        Boolean flag = false;
//
////        User user = new User();
////        user.setId(32);
////        user.setAge(19);
////        user.setGender("女");
//        flag = service.update(new UpdateWrapper<User>().set("address","安徽"));
////        flag = service.update(user,new UpdateWrapper<User>().set("address","南京"));
//
//        return flag;
//    }
//
//
//    @RequestMapping("/insertBatch")
//    @ResponseBody
//    public List<User> index8(){
//        List<User> list = new ArrayList<>();
//        User user = new User();
//        user.setName("88");
//        User user2 = new User();
//        user2.setName("99");
//        list.add(user);
//        list.add(user2);
//
//        boolean b = service.saveBatch(list, 1);
//        System.out.println(b);
//        return list;
//    }
//    @RequestMapping("/removeMap")
//    @ResponseBody
//    public void index9(){
//        Map<String ,Object> map = new HashMap<>();
//        map.put("name","测试");
//        map.put("age",10);
////        boolean b = service.removeByMap(map);
//        boolean b = service.remove(new QueryWrapper<User>().eq("age",12));
//        System.out.println(b);
//    }
//    @RequestMapping("hello")
//    public String index10(){
//        return "page/hello";
//    }
//    @RequestMapping("query")
//    @ResponseBody
//    public List<User> index11(){
//        return service.list();
//    }
//    @RequestMapping("update2")
//    @ResponseBody
//    public boolean index12(){
//        User user = new User();
//        user.setName("12");
//        UpdateWrapper<User> up = new UpdateWrapper<>();
//        up.eq("name","测试");
//        return service.update(user,up);
//    }
//    @RequestMapping("list3")
//    @ResponseBody
//    public List<User> index13(){
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        List<User> ulist = (List<User>) service.listByIds(list);
//        return ulist;
//    }
//    @RequestMapping("one")
//    @ResponseBody
//    public User index14(){
//        QueryWrapper<User> wrapper = new QueryWrapper();
//        wrapper.eq("name","王二");
//        User user = service.getOne(wrapper,true);
//        System.out.println(service.getMap(new QueryWrapper<User>().eq("gender", "女")));
//        System.out.println(service.count(new QueryWrapper<User>().eq("gender", "女")));
//        return user;
//    }
//    @RequestMapping("list6")
//    @ResponseBody
//    public void index15(){
//        QueryWrapper<User> wrapper = new QueryWrapper();
//        wrapper.eq("name","王二");
//        System.out.println(service.list(wrapper));
//    }
//    @RequestMapping("page2")
//    @ResponseBody
//    public void index16(){
//        QueryWrapper<User> wrapper = new QueryWrapper();
//        wrapper.eq("name","王二");
//        IPage<User> page = service.page(new Page<>(0, 2), wrapper);
//        System.out.println(page.getRecords());
//        System.out.println(page.getPages());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotal());
//    }
//
//    @RequestMapping("update3")
//    public User update3(){
//        User user = new User();
//        user.setName("王四");
//        user.setAddress("北京");
//        QueryWrapper<User> wapper = new QueryWrapper<>();
//        wapper.eq("gender","女");
//        service.update(user,wapper);
//        return user;
//    }

//    @RequestMapping("page9")
//    public IPage<User> ipage9(){
//        return service.page(new Page<User>(2,3),new QueryWrapper<User>());
//    }

}

package com.lc.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * 生产实践：https://juejin.cn/post/6844903538183634952
 */
public class EventBusStudy {
    public static void main(String[] args) {
        //创建EventBus对象和名称
        EventBus epidemicEventBus = new EventBus("epidemic");
        // EventBus epidemicEventBus = new AsyncEventBus("epidemic", new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1024)));

        //注册所有的订阅者
        epidemicEventBus.register(new OfficialListener());
        epidemicEventBus.register(new NationalListener());

        //发布疫情爆发事件
        System.out.println("发布疫情爆发事件");
        epidemicEventBus.post(new EpidemicEvent("疫情爆发"));
        // epidemicEventBus.post(2);
        System.out.println("发布一个普通事件");
        epidemicEventBus.post("普通事件");
    }
}
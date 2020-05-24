package com.midea.thread;

import java.rmi.StubNotFoundException;


//锁的种类: 乐观锁（自旋锁） ，悲观锁（synchronized） ，共享锁(读锁) ， 排他锁（写锁） ， 阶段锁

//compare and swap
public class CAS {
    //cas(v,期待值，新值)
    //if v==E
    //   v=new
    //   否则继续尝试或者失败
    //   CAS 是cpu指令级别的操作 是无法打断的


    //ABA问题 用版本号

    /**
     * unsafe这个类可以 直接操作jvm内存
     *                 直接生成类实例
     *                 直接操作类或实例变量
     *                 比如操作某个类的属性 可以直接从unsafe直接从内存中改
     */

}

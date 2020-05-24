package com.midea.thread;

public class Thread_0 {

    //创建线程两种方式 1.实现runnable接口 2.继承线程重写run方法 3使用lambda表达式
    public static class MyRunnable implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                System.out.println("该线程加入");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class Mythread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }

    /**
     * 用法
     **
     * wait()和notify()和notifyAll()
     * wait()方法则会在线程休眠的同时释放掉机锁，其他线程可以访问该对象。
     * wait()必须在同步的代码块中执行。当一个线程执行到wait()方法时，
     * 它就进入到一个和该对象相关的等待池中，同时失去了对象的机锁，
     * 可以允许其它的线程执行一些同步操作。
     * 但是wait()可以通过interrupt()方法打断线程的暂停状态，
     * 从而使线程立刻抛出InterruptedException。
     *
     * wait可以让同步方法或者同步块暂时放弃对象锁,而将它暂时让给其它需要对象锁的人(这里应该是程序块,或线程)用,这意味着可在执行wait()期间调用线程对象中的其他同步方法!在其它情况下(sleep啊,suspend啊),这是不可能的.但是注意我前面说的,只是暂时放弃对象锁,暂时给其它线程使用,我wait所在的线程还是要把这个对象锁收回来的呀.wait什么?就是wait别人用完了还给我啊！
     *
     * 好,那怎么把对象锁收回来呢?
     *
     * 第一种方法,限定借出去的时间.在wait()中设置参数,比如wait(1000),以毫秒为单位,就表明我只借出去1秒中,一秒钟之后,我自动收回.
     *
     * 第二种方法,让借出去的人通知我,他用完了,要还给我了.这时,我马上就收回来.哎,假如我设了1小时之后收回,别人只用了半小时就完了,那怎么办呢?靠!当然用完了就收回了,还管我设的是多长时间啊.
     *
     * 那么别人怎么通知我呢?相信大家都可以想到了,notify(),这就是最后一句话"而且只有在一个notify()或notifyAll()发生变化的时候，线程才会被唤醒"的意思了.
     *
     * notify()唤醒在此对象监视器上等待的单个线程。
     * 当它被一个notify()方法唤醒时，等待池中的线程就被放到了锁池中。
     * 该线程将等待从锁池中获得机锁，然后回到wait()前的中断现场。
     *
     * notifyAll()唤醒在此对象监视器上等待的所有线程。
     *
     *
     * suspend和resume()
     * join()
     * join()方法使当前线程停下来等待，直至另一个调用join方法的线程终止。值得注意的是，线程的在被激活后不一定马上就运行，而是进入到可运行线程的队列中。但是join()可以通过interrupt()方法打断线程的暂停状态，从而使线程立刻抛出InterruptedException。
     *
     * yield()
     * Yield()方法是停止当前线程，让同等优先权的线程运行。如果没有同等优先权的线程，那么Yield()方法将不会起作用。
     *
     * interrupt()
     * interrupt()中断线程。需要注意的是，InterruptedException是线程自己从内部抛出的，并不是interrupt()方法抛出的。对某一线程调用interrupt()时，如果该线程正在执行普通的代码，那么该线程根本就不会抛出InterruptedException。但是，一旦该线程进入到wait()/sleep()/join()后，就会立刻抛出InterruptedException。
     * @param args
     */
    public static void main(String[] args) {
        Thread thread2=new Thread(new MyRunnable());

        thread2.start();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    System.out.println("开始执行了 等待线程加入");
                    thread2.join();
                    Thread.sleep(1000);
                    System.out.println("11111");
                }catch (Exception e){

                }
            }
        });
        new Thread(()->{
            System.out.println("哈哈哈哈");
        }).start();
//       thread.run();
        thread.start();//start 是线程启动，主线程会继续执行 如果是run主线程则等待run方法内代码执行完成在执行主线程

        System.out.println(22222);
    }
}

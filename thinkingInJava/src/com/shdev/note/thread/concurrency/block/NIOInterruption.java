package com.shdev.note.thread.concurrency.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;

/**
 * Created by ouyangkongli on 2017/4/28.
 */
class NIOBlocked implements Runnable {
    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read() in " + this);
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println(this + "  " + e.getClass().getSimpleName());
        } catch (AsynchronousCloseException e) {
            System.out.println(this + "  " + e.getClass().getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting NIOBlocked.run()" + this);
    }
}

public class NIOInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Runnable runnable1 = new NIOBlocked(sc1);
        Runnable runnable2 = new NIOBlocked(sc2);
        System.out.println("1:" + runnable1);
        System.out.println("2:" + runnable2);
        Future<?> f = executorService.submit(runnable1);
        executorService.execute(runnable2);
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}




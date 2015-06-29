package demo.facade;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void startup() {
        System.out.println("start computer");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start finished");
    }

    public void shutdown() {
        System.out.println("shutdown computer");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("shutdown finished");
    }
}

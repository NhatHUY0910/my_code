package demo.ViDu;

public class ViDuThread extends Thread {
    private String name;

    public ViDuThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            System.out.println("Thread " + i + " " + name + " đang chạy");
        }
    }
}

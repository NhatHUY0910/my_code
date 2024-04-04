package demo.ViDu;

import java.io.IOException;

public class viDuThrow {
    void m1() throws IOException {
        throw new IOException("Lỗi gì đó...");
    }

    void m2() throws IOException {
        m2();
    }

    void m3() {
        try {
            m3();
        } catch (Exception e) {
            System.out.println("Hết lỗi");
        }
    }

}

import org.junit.Test;

import java.io.*;

public class GameTest {
    private class Tester {
        String filename;
        String result;
        public Tester(String filename, String result){
            this.filename = filename;
            this.result = result;
        }
        public void proceed() throws IOException {
            assert Solution.proceed(this.filename).equals(this.result);
        }
    }

    Tester[] tests = {
            new Tester("testExample.txt", "6"),
            new Tester("testSmall.txt", "11"),
            new Tester("testDirectAccess.txt", "1"),
            new Tester("testNoPath.txt", "NO PATH"),
            new Tester("test10sCube.txt", "14"),
            new Tester("test13sCube.txt", "95"),
            new Tester("testMultiPath1.txt", "138"),
            new Tester("testMultiPath2.txt", "102"),
            new Tester("testSpace.txt", "30"),
            new Tester("testCodingame.txt", "17")

    };

    @Test
    public void Test1() throws IOException {
        this.tests[0].proceed();
    }
    @Test
    public void Test2() throws IOException {
        this.tests[1].proceed();
    }
    @Test
    public void Test3() throws IOException {
        this.tests[2].proceed();
    }
    @Test
    public void Test4() throws IOException {
        this.tests[3].proceed();
    }
    @Test
    public void Test5() throws IOException {
        this.tests[4].proceed();
    }
    @Test
    public void Test6() throws IOException {
        this.tests[5].proceed();
    }
    /*
    @Test
    public void Test7() throws IOException {
        this.tests[6].proceed();
    }
    @Test
    public void Test8() throws IOException {
        this.tests[7].proceed();
    }
    @Test
    public void Test9() throws IOException {
        this.tests[8].proceed();
    }*/
    @Test
    public void Test10() throws IOException {
        this.tests[9].proceed();
    }
}

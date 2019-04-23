package SubArrayAvgSumGreaterThanAvgOfRemaining;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int ni() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nl() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static Reader sc = new Reader();
    //static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out, true);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //code here
        int n = sc.ni();
        int arr[] = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.ni();
            sum += arr[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            double temp = 0;
            for (int j = i; j < n; j++) {
                temp += arr[j];
                if (temp / (1 + j - i) > (sum - temp) / (n - (1 + j - i)) || ((n - (1 + j - i)) == 0)) {
                    count++;
                    sb.append(i + 1);
                    sb.append(" ");
                    sb.append(j + 1);
                    sb.append("\n");
                }
            }
        }
        System.out.println(count);


        pw.print(sb);
        pw.flush();
        pw.close();
    }
}
package feizhu;

import java.io.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author qingtong
 * @since 2023-08-11 19:18
 **/
public class Counter {

    AtomicLong count = new AtomicLong(0);


    /**
     * 题目一
     * 现有 /tmp/access.log 日志，日志大小超过2G，格式为time|url|code|platform，如下为示例日志内容
     * ……
     * 2020-09-01 10:01:00|http://www.taobao.com/hello|200|iOS
     * 2020-09-01 10:01:00|http://www.taobao.com/hello|200|iOS
     * 2020-09-01 10:01:00|http://www.taobao.com/hello|200|iOS
     * 2020-09-01 10:01:02|http://www.taobao.com/hello|200|Android
     * 2020-09-01 10:01:03|http://www.taobao.com/hello|200|iOS
     */
    public long IOSCounter(String[] contents) throws IOException {
        File file = new File("/tmp/access.log");
        if (!file.exists()) {
            return 0;
        }

        splitFile(file, 100);

        // 文件进行切割
        for (int i = 0; i < 100; i++) {
            BufferedReader reader = new BufferedReader(new FileReader("/access_" + i + ".tmp"));
            if (reader.ready()) {
                reader.lines().forEach(content -> CompletableFuture.runAsync(() -> {
                    if (content == null || "".equals(content)) {
                        // 数据不合法
                        return;
                    }

                    String[] str = content.split("|");
                    if (str.length != 4) {
                        // 数据不合法
                        return;
                    }

                    String system = str[3];
                    if ("iOS".equals(system)) {
                        count.addAndGet(1);
                    }
                }));
            }
        }

        return count.longValue();
    }

    /**
     * 文件分割方法
     */
    public static void splitFile(File targetFile, long size) {
        //计算切割文件大小
        int count = targetFile.length() % size == 0 ? (int) (targetFile.length() / size) : (int) (targetFile.length() / size + 1);
        try (RandomAccessFile raf = new RandomAccessFile(targetFile, "r")) {
            //获取目标文件
            long length = raf.length();
            long maxSize = length / count;
            long offSet = 0L;

            for (int i = 0; i < count - 1; i++) {
                long begin = offSet;
                long end = (i + 1) * maxSize;
                offSet = getWrite(targetFile.getAbsolutePath(), i, begin, end);
            }

            if (length - offSet > 0) {
                getWrite(targetFile.getAbsolutePath(), count - 1, offSet, length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOEException");
        }
    }

    /**
     * 指定文件每一份的边界，写入不同文件中
     */
    public static long getWrite(String file, int index, long begin, long end) throws IOException {

        long endPointer = 0L;
        // 准备切割的文件
        RandomAccessFile in = new RandomAccessFile(new File(file), "r");
        // 申明切割后小文件的具体位置
        File mFile = new File("/access_" + index + ".tmp");
        RandomAccessFile out = new RandomAccessFile(mFile, "rw");

        try {
            int n = 0;
            //从指定位置读取文件字节流
            in.seek(begin);
            byte[] b = new byte[1024];
            while ((n = in.read(b)) != -1 && in.getFilePointer() <= end) {
                //从指定每一份文件的范围，写入不同的文件
                out.write(b, 0, n);
            }
            //定义当前读取文件的指针
            endPointer = in.getFilePointer();

        } finally {
            //关闭输入流
            in.close();
            out.close();
        }
        return endPointer;
    }

}

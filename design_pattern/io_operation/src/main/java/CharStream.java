import java.io.*;

/**
 * @author nonpool
 * @version 1.0
 * @since 2020/2/23
 */
public class CharStream {
    // 使用字符流 一次拷贝一个字节
    private static void copyFile1(String src, String dest) throws IOException {
        //1. 创建流
        Reader reader = new FileReader(src);
        Writer writer = new FileWriter(dest);

        //2. 读写数据
        int size = 0;
        while ((size = reader.read()) != -1) {
            writer.write(size);
        }

        //3. 关闭流
        reader.close();
        writer.close();
    }


    // 一次拷贝一个 字符数组
    public static void copyFile2(String src, String dest) throws IOException {
        //1. 创建流
        Reader reader = new FileReader(src);
        Writer writer = new FileWriter(dest);

        char[] chars = new char[1024];
        int size = 0;
        while ((size = reader.read(chars)) != -1){
           writer.write(chars,0,size);
        }
        reader.close();
        writer.close();
    }

    // 一次拷贝一个一整行的 字符串
    private static void copyFile3(String src, String dest) throws IOException {
        //1. 创建转换流
        BufferedReader reader = new BufferedReader(new FileReader(src));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest));

        //2. 拷贝数据
        String data = reader.readLine();
        while (data != null) {
            writer.write(data);
            writer.newLine();
            data = reader.readLine();
        }
        //3.关闭流
        reader.close();
        writer.close();
    }

}

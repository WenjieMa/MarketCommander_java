package com.utils.common;

import com.pojo.InfoItem;
import com.pojo.InfoUser;
import org.springframework.cglib.core.Constants;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * Created by xiaoma on 2018/5/19.
 */
public class ImageUtil {

    public static String saveImg(MultipartFile multipartFile, String path) throws IOException {
        File file = new File(path);

        deleteFile(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID() + ".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

    public static String getFilePath(InfoUser infoUser) {
        return "\\headpic\\id" + infoUser.getId();
    }

    public static String getFilePath(InfoItem infoItem) {
        return "\\goods\\id" + infoItem.getId();
    }


    public static String getFilePath(Long picid) {
        return "/homepage/id" + picid + "/";
    }

    public static void deleteFile(String delpath) {
        File file = new File(delpath);
        // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
        if (!file.isDirectory()) {
            file.delete();
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File delfile = new File(delpath + "\\" + filelist[i]);
                if (!delfile.isDirectory()) {
                    delfile.delete();
                    System.out.println(delfile.getAbsolutePath() + "删除文件成功");
                } else if (delfile.isDirectory()) {
                    deleteFile(delpath + "\\" + filelist[i]);
                }
            }
            System.out.println(file.getAbsolutePath() + "删除成功");
            file.delete();
        }
    }
}

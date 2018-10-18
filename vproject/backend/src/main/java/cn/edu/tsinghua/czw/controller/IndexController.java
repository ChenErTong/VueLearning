package cn.edu.tsinghua.czw.controller;

import cn.edu.tsinghua.czw.model.Table;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @PostMapping("/upload")
    public ResponseEntity<Table> getEntity(@RequestParam(value = "file") MultipartFile file) {
        String line = null;
        String[] header = null;
        List<String[]> rows = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            header = br.readLine().split(",");
            while((line = br.readLine()) != null){
                rows.add(line.split(","));
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new Table(header, rows), HttpStatus.OK);
    }
}
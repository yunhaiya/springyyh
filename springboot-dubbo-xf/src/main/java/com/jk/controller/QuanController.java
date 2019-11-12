package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.QxModel;
import com.jk.service.QuanService;
import com.jk.util.ExportExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuanController {
    @Reference(version = "1.0")
    private QuanService service;
    /**
     * 1.使用饼状图展示2019年每一个月的销量
     * 2.使用折线图展示每一周的销量
     * 3.使用面积图展示每个品牌的销量
     * 4.使用柱状图展示一个月内每一天的销量
     */
 //--------------------------------------------to柱状图------------------------------------------------
    @RequestMapping("toqueryZhu")
    public String toqueryZhu() {
        return "quanxian/queryZhu";
    }
//--------------------------------------------柱状图------------------------------------------------
    @RequestMapping("queryZhu")
    @ResponseBody
    public List<Map<String,Object>> queryZhu(){
        List<Map<String,Object>> map =service.queryZhu();

        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map1:map) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("data",map1.get("count"));
            map2.add(map3);

        }
        return map;
    }
    //--------------------------------------------面积图------------------------------------------------
 /*   @RequestMapping("queryMian")
    @ResponseBody
    public List<Map<String,Object>> queryMian(){
        List<Map<String,Object>> map1 =service.queryZhu();

        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map:map1) {
            Map<String,Object> map3=new HashMap<>();

            if(map.get("名称").toString().equals("保时捷")){
                map3.put("baoshi",map.get("xiao"));
                map3.put("bsname","保时捷");
            }else if(map.get("类型").toString().equals("奥迪")){
                map3.put("name","奥迪");
            }else if(map.get("类型").toString().equals("宝马")){
                map3.put("name","宝马");
            }
            else if(map.get("类型").toString().equals("尼桑")){
                map3.put("name","尼桑");
            }else {
                map3.put("name","布加迪");
                //map3.put("data",map.get("布加迪"));
            }
            map2.add(map3);

        }
        return map2;
    }*/
//--------------------------------------------周节点图------------------------------------------------
    @RequestMapping("queryZhou")
    @ResponseBody
    public List<Map<String,Object>> queryZhou(){
        List<Map<String,Object>> map =service.queryZhou();

        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map1:map) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("data",map1.get("count"));
            map2.add(map3);

        }
        return map;
    }



    //--------------------------------------------to饼状图------------------------------------------------
    @RequestMapping("toShow")
    public String toShow() {
        return "quanxian/Show";
    }

    //--------------------------------------------饼状图------------------------------------------------
    @RequestMapping("queryBing")
    @ResponseBody
    public  List<Map<String,Object>> queryShowBing(){
        //查询数据库数据
        List<Map<String,Object>> map1 =service.queryShowBing();
        //返回前台的数据
        List<Map<String,Object>> map2=new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map:map1){
            Map<String,Object> map3=new HashMap<>();
            map3.put("y",map.get("y"));
            map3.put("name",map.get("name"));
            map2.add(map3);
        }
        return map2;
    }

    @RequestMapping("toqueryQuan")
    public String toqueryQuan() {
        return "quanxian/queryQuan";
    }

    @RequestMapping("queryQuan1")
    @ResponseBody
    public List<QxModel> queryQuan() {
        return service.queryQuanList();
    }
    //删除权限
    @RequestMapping("deleteQuan")
    @ResponseBody
    public String deleteQuan(String ids){
        service.deleteQuan(ids);
        return "s";
    }

    @RequestMapping("toqueryQuanOne")
    public String toqueryQuanOne(Model model, String ids){
        QxModel qx=service.queryQuanOne(ids);
        model.addAttribute("a",qx);


        return "/quanxian/updatequan";
    }

    @RequestMapping("updateQuanOne")
    @ResponseBody
    public String updateQuanOne(QxModel ids){
        service.updateQuanOne(ids);

        return "a";
    }

    @RequestMapping("toadd")
    public String toadd() {
        return "quanxian/addQuan";
    }

    @RequestMapping("addQuanOne")
    @ResponseBody
    public String addQuanOne(QxModel ids){
        service.addQuanOne(ids);
        return "a";
    }

    @RequestMapping("export")
    public void export(HttpServletResponse response){
        List<QxModel> list= new ArrayList<QxModel>();
        try {
            list = service.queryQuanList();

            //定义表格的标题
            String title ="权限列表";
            //定义列名
            String[] rowName={"编号","权限名称"};
            //定义工具类要的数据
            List<Object[]>  dataList = new ArrayList<Object[]>();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


            //循环数据把数据存放到 List<Object[]>
            for (QxModel qx:list) {
                Object[] obj=new Object[rowName.length];
                obj[0]=qx.getQxid();
                obj[1]= qx.getQxname();

                dataList.add(obj);
            }
            ExportExcel exportExcel=new ExportExcel(title,rowName,dataList,response);
            exportExcel.export();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file, HttpServletResponse response){
        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //生成新的文件名称
        String filePath = "./src/main/resources/templates/fileupload/";

        //创建list集合接收传递的参数
        List<QxModel> list= new ArrayList<QxModel>();

        //上传文件
        try {
            uploadFile(file.getBytes(), filePath, fileName);

            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            //通过文件创建流
            FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
            //创建操作excel的对象   因为xls的文件需要HSSFWorkbook  xlsx需要的XSSFWorkbook 因此直接使用workBook对象就行了
            Workbook workbook= WorkbookFactory.create(fileInputStream) ;
            //通过workbook获得sheet页  sheet有可能有多个
            for(int i=0;i<workbook.getNumberOfSheets();i++){
                //创建sheet对象
                Sheet sheetAt = workbook.getSheetAt(i);
                //根绝sheet创建行  row
                for(int j = 3; j< ((Sheet) sheetAt).getPhysicalNumberOfRows(); j++){
                    //创建row对象
                    Row row = sheetAt.getRow(j);

                    //创建对象接收从文件读取的内容
                    QxModel qx=new QxModel();
                    if( !"".equals(row.getCell(1)) && row.getCell(1)!=null){
                        qx.setQxid(row.getCell(1).toString());
                    }
                    if( !"".equals(row.getCell(2)) && row.getCell(2)!=null){
                        qx.setQxname(row.getCell(2).toString());
                    }


                    list.add(qx);
                }

            }
            service.addQuanAll((QxModel) list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "quanxian/queryQuan";
    }

    //上传文件的方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
package cn.likegirl.excel;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class UnknowFormatResolve {


  @Test
  public void test01() throws Exception {
    System.out.println(System.getProperty("user.dir"));
    System.out.println(this.getClass().getResource("/").getPath());

    System.out.println(System.getProperty("user.dir") + "\\" + "异常 - 副本.xlsx");

    InputStream inputStream = new FileInputStream(
        System.getProperty("user.dir") + "\\" + "异常 - 副本.xlsx");

//    List<List<RowFormat>> lists = ExcelUtil.readExcel(inputStream, "20190506-153727.xlsx");
//
//    lists.forEach(item -> {
//      System.out.println("============================");
//      item.forEach(System.out::println);
//      System.out.println("============================");
//    });

    easyExcelResolve(inputStream);

//    poiResolve(inputStream);



    //    List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
    inputStream.close();
//    print(data);
  }

  public void easyExcelResolve(InputStream inputStream){

    ExcelListener excelListener = new ExcelListener();

    EasyExcelFactory.readBySax(inputStream, new Sheet(1, 0), excelListener);

//    ExcelReader reader = new ExcelReader(inputStream, null, new AnalysisEventListener<List<String>>() {
//      @Override
//      public void invoke(List<String> object, AnalysisContext context) {
//        System.out.println(
//            "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
//                + " data:" + object);
//      }
//      @Override
//      public void doAfterAllAnalysed(AnalysisContext context) {
//
//      }
//    });
//    reader.read();

  }

  public void poiResolve(InputStream inputStream) throws IOException {
    // 构造 XSSFWorkbook 对象，strPath 传入文件路径
    XSSFWorkbook xwb = new XSSFWorkbook(inputStream);
    // 读取第一章表格内容
    XSSFSheet sheet = xwb.getSheetAt(0);
    Object value = null;
    XSSFRow row = null;
    XSSFCell cell = null;
    int firstRowNum = sheet.getFirstRowNum();
    int total = sheet.getPhysicalNumberOfRows();
    for (int i = firstRowNum; i < total; i++) {
      row = sheet.getRow(i);
      if (row != null) {
        short firstCellNum = row.getFirstCellNum();
        int totalCellNum = row.getPhysicalNumberOfCells();
        for (int j = firstCellNum; j < totalCellNum; j++) {
          cell = row.getCell(j);
          if (cell != null) {
            System.out.print(cell.getStringCellValue() + "=" + cell.getReference());
            System.out.print("|");

          }
        }
        System.out.println();
      }
    }
  }


  public void print(List<Object> datas) {
    int i = 0;
    for (Object ob : datas) {
      System.out.println(i++);
      System.out.println(ob);
    }
  }
}




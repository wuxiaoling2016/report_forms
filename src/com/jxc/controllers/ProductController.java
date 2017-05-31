package com.jxc.controllers;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.jxc.model.Product;
import com.jxc.service.ProductService;

@Controller
@RequestMapping(value="/")
public class ProductController {
	@Resource(name="productService")
	private ProductService service;
	@RequestMapping(value="addProduct")
	public String addProduct(Product product,MultipartFile myfile,HttpSession session, PrintWriter out) throws IllegalStateException, IOException{
		String fileName=myfile.getOriginalFilename();
		String path=session.getServletContext().getRealPath("/images");
		File file=new File(path,fileName);
		//将上传的文件转存入指定位置
		myfile.transferTo(file);
		product.setPicture(path+File.separator+fileName);
		service.addProduct(product);
		out.print("ok");
		return "product/add";
	}
	@ResponseBody
	@RequestMapping(value="listProduct")
	public Object listProduct(){
		
		List<Product> products=service.findAll();
		Map<String, Object> jsonMap=new HashMap<String, Object>();
		jsonMap.put("rows", products);
		jsonMap.put("total", products.size());
		
		
		return jsonMap;
	}
	@RequestMapping(value="printProduct")
	public String print() throws IOException{
		List<Product> products=service.findAll();
		System.out.println("进入打印");
		String[] title = new String[]{"产品编号","产品名称","产品品牌","数量","价格","成本"};
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		int rowNo = 0;										//行号
		int colNo = 0;										//列号
		Row nRow = null;
		Cell nCell = null;
		
		sheet.setColumnWidth(0, 30*256);					//设置列宽
		
		nRow = sheet.createRow(rowNo);
		nRow.setHeightInPoints(40);
		sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 0, 5));			//合并单元格，新对象，不会覆盖合并的那些单元格，只是遮住
		rowNo++;
		
		nCell = nRow.createCell(0);
		nCell.setCellValue("手机产品列表");
		nCell.setCellStyle(this.bigTilteStyle(wb));
		
		
		//写标题
		nRow = sheet.createRow(rowNo++);
		nRow.setHeightInPoints(28);							//设置行高
		
				
		for(int i=0;i<title.length;i++){
			nCell = nRow.createCell(i);
			nCell.setCellValue(title[i]);
			nCell.setCellStyle(this.titleStyle(wb));		//绑定样式
		}
		
		//写数据
		for(int j=0;j<products.size();j++){
			colNo = 0;										//初始化
			Product p = products.get(j);					//获取到每条厂家记录
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(21);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(p.getPid());
			nCell.setCellStyle(this.textStyle(wb));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(p.getPname());
			nCell.setCellStyle(this.textStyle(wb));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(p.getBrand());
			nCell.setCellStyle(this.textStyle(wb));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(p.getQuantity());
			nCell.setCellStyle(this.textStyle(wb));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(p.getPrice());
			nCell.setCellStyle(this.textStyle(wb));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(p.getCost());
			nCell.setCellStyle(this.textStyle(wb));
			
		}
		
		FileOutputStream os = new FileOutputStream("E:\\products.xls");			//输出流
		wb.write(os);							//写入到文件中
		os.flush();								//清空缓存
		os.close();								//关闭
		return "product/list";
	}
	
	//大标题样式
		private CellStyle bigTilteStyle(Workbook wb){
			//创建一个单元格样式对象
			CellStyle curStyle = wb.createCellStyle();
			curStyle.setAlignment(CellStyle.ALIGN_CENTER);						//横向居中
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);			//纵向居中
			
			Font curFont = wb.createFont();										//创建字体对象
			curFont.setFontName("华文隶书");										//设置字体
			curFont.setFontHeightInPoints((short)30);							//设置字体大小
			
			curStyle.setFont(curFont);											//将字体对象绑定到样式对象上
			
			return curStyle;
		}
		
		//标题样式
		private CellStyle titleStyle(Workbook wb){
			//创建一个单元格样式对象
			CellStyle curStyle = wb.createCellStyle();
			curStyle.setAlignment(CellStyle.ALIGN_CENTER);						//横向居中
			curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);			//纵向居中
			
			Font curFont = wb.createFont();										//创建字体对象
			curFont.setFontName("微软雅黑");										//设置字体
			curFont.setFontHeightInPoints((short)12);							//设置字体大小
			
			curStyle.setFont(curFont);											//将字体对象绑定到样式对象上
			
			//画线
			curStyle.setBorderTop(CellStyle.BORDER_THIN);						//细实线
			curStyle.setBorderBottom(CellStyle.BORDER_THIN);
			curStyle.setBorderLeft(CellStyle.BORDER_THIN);
			curStyle.setBorderRight(CellStyle.BORDER_THIN);
			
			
			return curStyle;
		}
		//文本样式
		private CellStyle textStyle(Workbook wb){
			CellStyle xStyle = wb.createCellStyle();
			Font xFont = wb.createFont();
			xStyle.setFont(xFont);
			
			xStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);			//纵向居中
			
			//画线
			xStyle.setBorderTop(CellStyle.BORDER_THIN);						//细实线
			xStyle.setBorderBottom(CellStyle.BORDER_THIN);
			xStyle.setBorderLeft(CellStyle.BORDER_THIN);
			xStyle.setBorderRight(CellStyle.BORDER_THIN);
			
			return xStyle;
		}
		
		
}

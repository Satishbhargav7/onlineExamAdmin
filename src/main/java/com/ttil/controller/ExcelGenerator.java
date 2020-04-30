package com.ttil.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ttil.entity.Candidate;

public class ExcelGenerator {

	public static ByteArrayInputStream candidaterecordToExcel(List<Candidate> d) throws IOException {
	    String[] COLUMNs = {"Exam_Name","Location_name", "Exam_location_sess_id","session_timings","RollNo", "Full_name","Father_Name","gender","dob","category","mobile_no","email_id"};
	    try(	        Workbook workbook = new XSSFWorkbook();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    )
	    {
	       
	      Sheet sheet = workbook.createSheet("CandidateDetails");
	   
	      Font headerFont = workbook.createFont();
	      headerFont.setBold(true);
	      headerFont.setColor(IndexedColors.BLUE.getIndex());
	   
	      CellStyle headerCellStyle = workbook.createCellStyle();
	      headerCellStyle.setFont(headerFont);
	  
	      Row headerRow = sheet.createRow(0);
	   
	      // Header
	      for (int col = 0; col < COLUMNs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(COLUMNs[col]);
	        cell.setCellStyle(headerCellStyle);
	      }
	      
	      int rowIdx = 1;
	      for (Candidate  c1: d) {
	        Row row = sheet.createRow(rowIdx++);
	   
	        row.createCell(0).setCellValue(String.valueOf(c1.getExam_name()));
	        row.createCell(1).setCellValue(String.valueOf(c1.getLocation_name()));
	        row.createCell(2).setCellValue(String.valueOf(c1.getExam_loc_session_id()));
	        row.createCell(3).setCellValue(String.valueOf(c1.getSession_timings()));
	        row.createCell(4).setCellValue(c1.getRollno());
	        row.createCell(5).setCellValue(c1.getFull_name());
	        row.createCell(6).setCellValue(c1.getFather_name());
	        row.createCell(7).setCellValue(c1.getGender());
	        row.createCell(8).setCellValue(c1.getDob());
	        row.createCell(9).setCellValue(c1.getCategory());
	        row.createCell(10).setCellValue(c1.getMobile_no());
	        row.createCell(11).setCellValue(c1.getEmail_id());
	      
	      }
	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    }
	  }
}

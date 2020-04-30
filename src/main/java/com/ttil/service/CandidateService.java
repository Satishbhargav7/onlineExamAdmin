package com.ttil.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ttil.entity.Candidate;
import com.ttil.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	public void getData(Candidate candidate)
	{
		/*
		 * String start_time = candidate.getStart_time(); String end_time =
		 * candidate.getEnd_time();
		 * 
		 * String add = start_time + '-' + end_time; String session1 = new
		 * Formatter().format(add, start_time,end_time).toString();
		 * candidate.setSession_timings(session1);
		 */
		
	 candidateRepository.save(candidate);
	 
	}
	public List<Candidate>getCanResult()
	{
		return (List<Candidate>) candidateRepository.findAll();
	}
	/*
	 * public Candidate var1(String exam_name) { Candidate cr =
	 * candidateRepository.find1(exam_name); return cr; }
	 */
	
	public void importCodexlsx(MultipartFile filePart ,String a,String b,String c ) throws IOException {

		InputStream inputStream = filePart.getInputStream();

		if (inputStream != null) {
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);

			int noOfCols = 0;
			Cell cell = null;
			String exam_name="",exam_loc_session_id="", location_name="",session_timings="",rollno="",full_name="",father_name="",gender="",dob="",
					category="",mobile_no="",email_id="";
		

			int rowCount = 0;
			for (Row row : sheet) {

				if (rowCount >= 1) {
					exam_name= "";
					location_name="";
					exam_loc_session_id= "";
					session_timings="";
					rollno = "";
					full_name = "";
					father_name = "";
					gender = "";
					dob="";
					category = "";
					mobile_no = "";
					email_id= "";
					
					noOfCols = row.getPhysicalNumberOfCells(); 
					// System.out.println("noOfCols="+noOfCols);
					
					
					for (int i = 0; i < noOfCols; i++) {
						
						cell = row.getCell(i);
										
						if (i == 0) {
							if (cell.getCellType() == CellType.STRING) {
								exam_name = cell.getStringCellValue();
								exam_name = exam_name.replaceAll("'", "");
								exam_name =exam_name.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								exam_name = cell.getNumericCellValue() + "";

							}

						}
						if (i == 1) {
							if (cell.getCellType() == CellType.STRING) {
								location_name = cell.getStringCellValue();
								location_name = location_name.replaceAll("'", "");
								location_name =location_name.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								location_name = cell.getNumericCellValue() + "";

							}

						}
						if (i == 2) {
							if (cell.getCellType() == CellType.STRING) {
								exam_loc_session_id = cell.getStringCellValue();
								exam_loc_session_id = exam_loc_session_id.replaceAll("'", "");
								exam_loc_session_id =exam_loc_session_id.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								exam_loc_session_id = cell.getNumericCellValue() + "";

							}

						}
						
						if (i == 3) {
							if (cell.getCellType() == CellType.STRING) {
								session_timings = cell.getStringCellValue();
								session_timings =	session_timings.replaceAll("'", "");
								session_timings =	session_timings.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								session_timings= cell.getNumericCellValue() + "";

							}
						}
						if (i == 4) {
							if (cell.getCellType() == CellType.STRING) {
								rollno = cell.getStringCellValue();
								rollno  = rollno .replaceAll("'", "");
								rollno  = rollno .trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								rollno  = cell.getNumericCellValue() + "";

							}
						}

						if (i == 5) {
							if (cell.getCellType() == CellType.STRING) {
								full_name = cell.getStringCellValue();
								full_name =   full_name.replaceAll("'", "");
								full_name =   full_name.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								full_name = cell.getNumericCellValue() + "";

							}
						}
						if (i == 6) {
							if (cell.getCellType() == CellType.STRING) {
								father_name = cell.getStringCellValue();
								father_name= 	 father_name.replaceAll("'", "");
								father_name = 	 father_name.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								father_name = cell.getNumericCellValue() + "";

							}
						}
						if (i == 7) {
							if (cell.getCellType() == CellType.STRING) {
								gender = cell.getStringCellValue();
								gender = gender.replaceAll("'", "");
								gender =  gender.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								gender= cell.getNumericCellValue() + "";

							}
						}
						if (i == 8) {
							if (cell.getCellType() == CellType.STRING) {
								dob = cell.getStringCellValue();
								dob =  dob.replaceAll("'", "");
								dob =dob.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								dob = cell.getNumericCellValue() + "";

							}
						}
						if (i == 9) {
							if (cell.getCellType() == CellType.STRING) {
								category = cell.getStringCellValue();
								category = category.replaceAll("'", "");
								category =category.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								category = cell.getNumericCellValue() + "";

							}
						}
						if (i == 10) {
							if (cell.getCellType() == CellType.STRING) {
								mobile_no = cell.getStringCellValue();
								mobile_no=mobile_no.replaceAll("'", "");
								mobile_no= mobile_no.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								mobile_no = cell.getNumericCellValue() + "";

							}
						}
						
						if (i == 11) {
							if (cell.getCellType() == CellType.STRING) {
								email_id = cell.getStringCellValue();
								email_id=email_id.replaceAll("'", "");
								email_id= email_id.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								email_id = cell.getNumericCellValue() + "";

							}
						}

						
						
					}
					if (rowCount >= 1) {
						Candidate cb=new Candidate();
						cb.setExam_name(exam_name);
						cb.setLocation_name(location_name);
						cb.setExam_loc_session_id(exam_loc_session_id);
						cb.setSession_timings(session_timings);
						cb.setRollno(rollno);
						cb.setFull_name(full_name);
						cb.setFather_name(father_name);
						cb.setGender(gender);
						cb.setDob(dob);
						cb.setCategory(category);
						cb.setMobile_no(mobile_no);
						cb.setEmail_id(email_id);
						
						
						  if(cb.getExam_name().equalsIgnoreCase(a)&&(cb.getLocation_name().equalsIgnoreCase(b))&&(cb.getSession_timings().equalsIgnoreCase(c))) {
						 
							getData(cb);
						 } 
						
						
					}
				
				
			}
				rowCount++;
				
			}
		}

	}

	public void importCodexls(MultipartFile filePart,String a,String b,String c) throws IOException {
		InputStream inputStream = filePart.getInputStream();

		if (inputStream != null) {
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = wb.getSheetAt(0);

			int noOfCols = 0;
			Cell cell = null;
			String exam_name="",location_name="",exam_loc_session_id="",session_timings="",rollno="",full_name="",father_name="",gender="",dob="",
					category="",mobile_no="",email_id="";
		

			int rowCount = 0;
			for (Row row : sheet) {

				if (rowCount >= 1) {
					exam_name= "";
					location_name="";
					exam_loc_session_id= "";
					session_timings="";
					rollno = "";
					full_name = "";
					father_name = "";
					gender = "";
					dob="";
					category = "";
					mobile_no = "";
					email_id= "";
					
					noOfCols = row.getPhysicalNumberOfCells(); 
					// System.out.println("noOfCols="+noOfCols);
									
					for (int i = 0; i < noOfCols; i++) {
						
						cell = row.getCell(i);
										
						if (i == 0) {
							if (cell.getCellType() == CellType.STRING) {
								exam_name = cell.getStringCellValue();
								exam_name = exam_name.replaceAll("'", "");
								exam_name =exam_name.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								exam_name = cell.getNumericCellValue() + "";

							}

						}
						if (i == 1) {
							if (cell.getCellType() == CellType.STRING) {
								location_name = cell.getStringCellValue();
								location_name = location_name.replaceAll("'", "");
								location_name =location_name.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								location_name = cell.getNumericCellValue() + "";

							}

						}
						if (i == 2) {
							if (cell.getCellType() == CellType.STRING) {
								exam_loc_session_id = cell.getStringCellValue();
								exam_loc_session_id = exam_loc_session_id.replaceAll("'", "");
								exam_loc_session_id =exam_loc_session_id.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								exam_loc_session_id = cell.getNumericCellValue() + "";

							}

						}
						
						if (i == 3) {
							if (cell.getCellType() == CellType.STRING) {
								session_timings = cell.getStringCellValue();
								session_timings =	session_timings.replaceAll("'", "");
								session_timings =	session_timings.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								session_timings= cell.getNumericCellValue() + "";

							}
						}
						if (i == 4) {
							if (cell.getCellType() == CellType.STRING) {
								rollno = cell.getStringCellValue();
								rollno  = rollno .replaceAll("'", "");
								rollno  = rollno .trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								rollno  = cell.getNumericCellValue() + "";

							}
						}

						if (i == 5) {
							if (cell.getCellType() == CellType.STRING) {
								full_name = cell.getStringCellValue();
								full_name =   full_name.replaceAll("'", "");
								full_name =   full_name.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								full_name = cell.getNumericCellValue() + "";

							}
						}
						if (i == 6) {
							if (cell.getCellType() == CellType.STRING) {
								father_name = cell.getStringCellValue();
								father_name= 	 father_name.replaceAll("'", "");
								father_name = 	 father_name.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								father_name = cell.getNumericCellValue() + "";

							}
						}
						if (i == 7) {
							if (cell.getCellType() == CellType.STRING) {
								gender = cell.getStringCellValue();
								gender = gender.replaceAll("'", "");
								gender =  gender.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								gender= cell.getNumericCellValue() + "";

							}
						}
						if (i == 8) {
							if (cell.getCellType() == CellType.STRING) {
								dob = cell.getStringCellValue();
								dob =  dob.replaceAll("'", "");
								dob =dob.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								dob = cell.getNumericCellValue() + "";

							}
						}
						if (i == 9) {
							if (cell.getCellType() == CellType.STRING) {
								category = cell.getStringCellValue();
								category = category.replaceAll("'", "");
								category =category.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								category = cell.getNumericCellValue() + "";

							}
						}
						if (i == 10) {
							if (cell.getCellType() == CellType.STRING) {
								mobile_no = cell.getStringCellValue();
								mobile_no=mobile_no.replaceAll("'", "");
								mobile_no= mobile_no.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								mobile_no = cell.getNumericCellValue() + "";

							}
						}
						
						if (i == 11) {
							if (cell.getCellType() == CellType.STRING) {
								email_id = cell.getStringCellValue();
								email_id=email_id.replaceAll("'", "");
								email_id= email_id.trim();

							} else if (cell.getCellType() == CellType.NUMERIC) {
								email_id = cell.getNumericCellValue() + "";

							}
						}
						
					}
					if (rowCount >= 1) {
						Candidate cb=new Candidate();
						cb.setExam_name(exam_name);
						cb.setLocation_name(location_name);
						cb.setExam_loc_session_id(exam_loc_session_id);
						cb.setSession_timings(session_timings);
						cb.setRollno(rollno);
						cb.setFull_name(full_name);
						cb.setFather_name(father_name);
						cb.setGender(gender);
						cb.setDob(dob);
						cb.setCategory(category);
						cb.setMobile_no(mobile_no);
						cb.setEmail_id(email_id);
												
						if(cb.getExam_name().equalsIgnoreCase(a)&&(cb.getLocation_name().equalsIgnoreCase(b))&&(cb.getSession_timings().equalsIgnoreCase(c)))
						{
							getData(cb);
						 } 
						
						
					}
				
				
			}
				rowCount++;
				
			}
		}
}
	public List<Candidate> var(String exam_name,String location_name,String session_timings) {
		return candidateRepository.find(exam_name,location_name,session_timings);
	}
	
	public List<Candidate> findByExamAndLocation(String exam_name, String location_name,String session_timings) {
		return candidateRepository.findByExam_nameAndLocation_nameAndSession_timings(exam_name, location_name,session_timings);
	}
	
	public ByteArrayInputStream PdfReport(List<Candidate> list) {
		// final Logger logger = LoggerFactory.getLogger(PdfConvort.class);

		Document document = new Document();

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {

			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100);
			float[] columnWidths = new float[] { 30f, 40f, 50f, 30f, 15f, 20f, 15f, 20f };
			table.setWidths(columnWidths);
			Rectangle rect = new Rectangle(612, 861);
			rect.enableBorderSide(1);
			rect.enableBorderSide(2);
			rect.enableBorderSide(4);
			rect.enableBorderSide(8);
			rect.setBorderColor(BaseColor.GRAY);
			rect.setBorderWidth(1);
			Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("exam_name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("location_name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			/*
			 * hcell = new PdfPCell(new Phrase("exam_loc_session_id", headFont));
			 * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 */

			  hcell = new PdfPCell(new Phrase("session_timings", headFont));
			  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  table.addCell(hcell);
			
			  hcell = new PdfPCell(new Phrase("rollno", headFont));
			  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  table.addCell(hcell);
			 

			hcell = new PdfPCell(new Phrase("full_name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("father_name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			/*
			 * hcell = new PdfPCell(new Phrase("gender", headFont));
			 * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 */

			
			/*
			 * hcell = new PdfPCell(new Phrase("dob", headFont));
			 * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 */
			 

			/*
			 * hcell = new PdfPCell(new Phrase("category", headFont));
			 * hcell.setHorizontalAlignment(Element.ALIGN_CENTER); table.addCell(hcell);
			 */

			hcell = new PdfPCell(new Phrase("mobile_no", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("email_id", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
			
			for (Candidate qw : list) {
				PdfPCell cell;
				cell = new PdfPCell(new Phrase(String.valueOf(qw.getExam_name())));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase(qw.getLocation_name()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				/*
				 * cell = new PdfPCell(new Phrase(String.valueOf(qw.getExam_loc_session_id())));
				 * cell.setPaddingLeft(5); cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * cell.setHorizontalAlignment(Element.ALIGN_LEFT); table.addCell(cell);
				 */
				
				  cell = new PdfPCell(new Phrase(qw.getSession_timings())); cell.setPaddingLeft(5);
				  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				  cell.setHorizontalAlignment(Element.ALIGN_LEFT); table.addCell(cell);
				 
				cell = new PdfPCell(new Phrase(qw.getRollno()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase(String.valueOf(qw.getFull_name())));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase(String.valueOf(qw.getFather_name())));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(cell);
				
				/*
				 * cell = new PdfPCell(new Phrase(String.valueOf(qw.getGender())));
				 * cell.setPaddingLeft(5); cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * cell.setHorizontalAlignment(Element.ALIGN_LEFT); table.addCell(cell);
				 * 
				 * cell = new PdfPCell(new Phrase(String.valueOf(qw.getDob())));
				 * cell.setPaddingLeft(5); cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * cell.setHorizontalAlignment(Element.ALIGN_LEFT); table.addCell(cell); cell =
				 * new PdfPCell(new Phrase(String.valueOf(qw.getCategory())));
				 * cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * cell.setHorizontalAlignment(Element.ALIGN_LEFT); cell.setPaddingRight(5);
				 * table.addCell(cell);
				 */
				cell = new PdfPCell(new Phrase(String.valueOf(qw.getMobile_no())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setPaddingRight(5);
				table.addCell(cell);
				cell = new PdfPCell(new Phrase(String.valueOf(qw.getEmail_id())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(table);
			document.add(rect);
			document.close();
		} catch (DocumentException ex) {
			
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}

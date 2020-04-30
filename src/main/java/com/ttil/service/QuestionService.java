package com.ttil.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ttil.entity.ExamBean;
import com.ttil.entity.StoringQuestionAndAnswer;
import com.ttil.repository.ExamRepository;
import com.ttil.repository.QuestionRepo;

@Service
public class QuestionService {
	@Autowired

	ExamRepository examRepository;
	@Autowired
	QuestionRepo questionRepo;

	public List<ExamBean> findExamNames() {
		return examRepository.findExamNames();
	}

	public void save(StoringQuestionAndAnswer storingQuestionAndAnswer) {
		questionRepo.save(storingQuestionAndAnswer);
	}

	public void saveQuestions(MultipartFile file, String examName, String setNo) throws IOException {
		InputStream inputStream = file.getInputStream();
		if (inputStream != null) {
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);

			int noOfCols = 0;
			Cell cell = null;
			String question = "", option_1 = "", option_2 = "", option_3 = "", option_4 = "";
			int rowCount = 0;
			for (Row row : sheet) {
				if (rowCount >= 1) {
					question = "";
					option_1 = "";
					option_2 = "";
					option_3 = "";
					option_4 = "";
					noOfCols = row.getPhysicalNumberOfCells();
					for (int i = 0; i < noOfCols; i++) {
						cell = row.getCell(i);
						if (i == 0) {
							if (cell.getCellType() == CellType.STRING) {
								question = cell.getStringCellValue();
								question = question.replaceAll("'", "");
								question = question.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								question = cell.getNumericCellValue() + "";

							}

						}

						if (i == 1) {
							if (cell.getCellType() == CellType.STRING) {
								option_1 = cell.getStringCellValue();
								option_1 = option_1.replaceAll("'", "");
								option_1 = option_1.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								option_1 = cell.getNumericCellValue() + "";

							}

						}
						if (i == 2) {
							if (cell.getCellType() == CellType.STRING) {
								option_2 = cell.getStringCellValue();
								option_2 = option_2.replaceAll("'", "");
								option_2 = option_2.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								option_2 = cell.getNumericCellValue() + "";

							}

						}
						if (i == 3) {
							if (cell.getCellType() == CellType.STRING) {
								option_3 = cell.getStringCellValue();
								option_3 = option_3.replaceAll("'", "");
								option_3 = option_3.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								option_3 = cell.getNumericCellValue() + "";

							}
						}
						if (i == 4) {
							if (cell.getCellType() == CellType.STRING) {
								option_4 = cell.getStringCellValue();
								option_4 = option_4.replaceAll("'", "");
								option_4 = option_4.trim();
							} else if (cell.getCellType() == CellType.NUMERIC) {
								option_4 = cell.getNumericCellValue() + "";

							}
						}
					}
					if (rowCount >= 1) {
						StoringQuestionAndAnswer questionAndAnswer = new StoringQuestionAndAnswer();
						questionAndAnswer.setQuestion(question);
						questionAndAnswer.setOption1(option_1);
						questionAndAnswer.setOption2(option_2);
						questionAndAnswer.setOption3(option_3);
						questionAndAnswer.setOption4(option_4);
						questionAndAnswer.setExamName(examName);
						questionAndAnswer.setSetNo(setNo);
						System.out.println(questionAndAnswer);
						save(questionAndAnswer);
					}
				}
				rowCount++;

			}
		}
	}

}

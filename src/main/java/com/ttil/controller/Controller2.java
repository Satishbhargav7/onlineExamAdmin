package com.ttil.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ttil.entity.Candidate;
import com.ttil.entity.ExamBean;
import com.ttil.entity.ExamLocationSess;
import com.ttil.service.CandidateService;
import com.ttil.service.ExamLocationService;
import com.ttil.service.ExamService;

@Controller

public class Controller2 {
	@Autowired
	private ExamService examService;
	
	@Autowired
	private ExamLocationService examLocService;

	@Autowired
	private ExamLocationService examLocationService;
	@Autowired
	private CandidateService candidateService;

	
	@PersistenceContext
	EntityManager em;

	@RequestMapping("/locationNameWithSession")
	public String redirect2(Model model) {

		model.addAttribute("values", examService.getResult());
		return "examLocationWithSession";

	}

	@RequestMapping("/createLocationSession")
	public String insertLocation(Model model, @ModelAttribute("examLocationSess") ExamLocationSess examLocationSess) {

		/*
		 * String id = examLocationSess.getExamId(); String dbId =
		 * examLocService.getId(); System.out.println("db id is : " + dbId);
		 * 
		 * if (dbId == null) { String str[] = id.split(","); List<String> al = new
		 * ArrayList<String>(); al = Arrays.asList(str); for (String s : al) {
		 * System.out.println("output" + s); }
		 * 
		 * System.out.println("aRRAY SIZE :" + al.size()); int size = al.size();
		 * 
		 * for (int i = 0; i < size; i++) {
		 * 
		 * String examIds = al.get(i);
		 * 
		 * System.out.println("Exam ID is : " + examIds);
		 * 
		 * int locid = examLocService.getHibernateId();
		 * System.out.println("Before increment fetching id from bean : " + locid);
		 * 
		 * System.out.println(",,,,,," + locid); int locid2 = locid + 1;
		 * 
		 * System.out.println("incremented id is : " + locid2);
		 * examLocationSess.setId(locid2);
		 * System.out.println("After increment fetching id from bean : "
		 * +examLocationSess.getId()); examLocationSess.setId(locid2);
		 * 
		 * examLocService.saveData(examLocationSess);
		 * 
		 * } }
		 * 
		 * else { String str[] = id.split(","); List<String> al = new
		 * ArrayList<String>(); al = Arrays.asList(str); for (String s : al) {
		 * System.out.println("output" + s); }
		 * 
		 * System.out.println("aRRAY SIZE :" + al.size()); int size = al.size();
		 * 
		 * for (int i = 0; i < size; i++) {
		 * 
		 * String examIds = al.get(i);
		 * 
		 * System.out.println("Exam ID is : " + examIds);
		 * 
		 * int locid = examLocService.getMaxid();
		 * System.out.println("Before increment fetching id from bean : " + locid);
		 * 
		 * System.out.println(",,,,,," + locid); int locid2 = locid + 1;
		 * 
		 * System.out.println("incremented id is : " + locid2);
		 * examLocationSess.setId(locid2);
		 * System.out.println("After increment fetching id from bean : " +
		 * examLocationSess.getId()); examLocationSess.setId(locid2);
		 */
		/*
		 * }
		 * 
		 * }
		 */
		examLocService.saveData(examLocationSess);
		model.addAttribute("values", examService.getResult());
		model.addAttribute("msg", "Successfully Created the location Session");
		return "examLocationWithSession";

	}

	@RequestMapping("/cindexurl")
	public String redirect1() {
		return "cindex";
	}

	@RequestMapping("/createcandidate")
	public String candidateData(Model model) {

		model.addAttribute("values", examService.getResult());
		model.addAttribute("value", examLocationService.getData());

		return "candidate";
	}

	@RequestMapping("/candidateurl")
	public String redirectCandidate(Model model, @ModelAttribute("candidate") Candidate candidate) {

		model.addAttribute("values", examService.getResult());
		model.addAttribute("value", examLocationService.getData());
		candidateService.getData(candidate);
		return "candidate";
	}

	@RequestMapping("/uploadurl")
	public String uploadData(Model model) {
		model.addAttribute("values", examService.getResult());
		model.addAttribute("value", examLocationService.getData());
		return "uploadCandidateData";
	}

	@RequestMapping(value = ("/uploadcandidatedata"), headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public String importCode(@RequestParam("file") MultipartFile file, @RequestParam("exam_name") String exam_name,
			@RequestParam("location_name") String location_name,
			@RequestParam("session_timings") String session_timings, Model model,
			@ModelAttribute("candidate") Candidate candidate) {

		try {

			String filePath = file.getOriginalFilename();
			if (filePath.endsWith(".xlsx")) {
				candidateService.importCodexlsx(file, exam_name, location_name, session_timings);
				// candidateService.getData(candidate);

			}

			else {
				candidateService.importCodexls(file, exam_name, location_name, session_timings);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return "success";

	}

	@RequestMapping("/downloadurl")
	public String downloadData(Model model, @ModelAttribute("candidate") Candidate candidate,
			@ModelAttribute("examBean") ExamBean examBean,
			@ModelAttribute("examLocationSess") ExamLocationSess examLocationSess)

	{
		model.addAttribute("values", examService.getResult());
		model.addAttribute("value", examLocationService.getData());
		return "downloadCandidate";
	}

	@RequestMapping("/downloadCandidate")
	public ResponseEntity<InputStreamResource> excelCustomersReport(Model model, @ModelAttribute("t") Candidate t)
			throws IOException {

		model.addAttribute("values", examService.getResult());
		model.addAttribute("value", examLocationService.getData());
		List<Candidate> c1 = (List<Candidate>) candidateService.var(t.getExam_name(), t.getLocation_name(),
				t.getSession_timings());
		ByteArrayInputStream bis = ExcelGenerator.candidaterecordToExcel(c1);
		model.addAttribute("msg", c1);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=CandidateDetails.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));

	}

	@RequestMapping("/resulturl")
	public String resultProcess(Model model, @ModelAttribute("t") Candidate t) {
		model.addAttribute("values", examService.getResult());
		model.addAttribute("value", examLocationService.getData());
		return "resultsReport";
	}

	
	@RequestMapping(value = "/pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> pdf(@RequestParam("exam_name") String exam_name,@RequestParam("location_name") String location_name,
			@RequestParam("session_timings") String session_timings,Model model) throws Exception {
		
		ByteArrayInputStream bis = candidateService
				.PdfReport(candidateService.findByExamAndLocation(exam_name,location_name,session_timings));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Candidate_data_" + exam_name + location_name+session_timings+".pdf");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
	}
	
}

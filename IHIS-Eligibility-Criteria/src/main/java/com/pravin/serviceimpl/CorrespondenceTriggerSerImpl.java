package com.pravin.serviceimpl;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pravin.entity.CitizenApp;
import com.pravin.entity.CitizenPlan;
import com.pravin.entity.CorrespondenceTrigger;
import com.pravin.entity.EligibleDetails;
import com.pravin.repository.CitizenAppRepository;
import com.pravin.repository.CorrespondenceTriggerRepository;
import com.pravin.repository.EligibleDetailsRepository;
import com.pravin.service.CorrespondenceTriggerService;
import com.pravin.util.EmailUtil;

@Service
public class CorrespondenceTriggerSerImpl implements CorrespondenceTriggerService{
	
	private final String FILE_PATH = "C:\\Users\\pravi\\pdf";

	
	@Autowired
	private CorrespondenceTriggerRepository correspondenceTriggerRepository;
	
	@Autowired
	private EligibleDetailsRepository eligibleDetailsRepository;
	
	@Autowired
	private CitizenAppRepository citizenAppRepository;

	
	@Autowired
	private  EmailUtil emailUtil;

	@Override
	public Map<String, Integer> genrateNotice() {
		
		Map<String, Integer>  count = new HashMap<>();
		
		Integer success = 0;
		List<CorrespondenceTrigger> triggers= correspondenceTriggerRepository.findByTrigerStatus("PENDING");
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ExecutorCompletionService<Object> pool = new ExecutorCompletionService<>(executorService);
		
		for (CorrespondenceTrigger correspondenceTrigger : triggers) {
			pool.submit(new Callable<Object>() {
				
				@Override
				public Object call() throws Exception {
					processTriger(correspondenceTrigger);
					return null;
				}
			});
			
		}
		
		count.put("success Count ", success);
		count.put("total Count ", triggers.size());
		return count;
	}

	private void processTriger(CorrespondenceTrigger correspondenceTrigger) {
		
		EligibleDetails details = eligibleDetailsRepository.findByCaseNo(correspondenceTrigger.getCaseNo());
		CitizenApp citizenApp = citizenAppRepository.findByCaseNum(correspondenceTrigger.getCaseNo()).get();

		
		//genrating the pdf
		generatepdf(details, citizenApp);
		
		// send the pdf
		sendPdf(citizenApp);
		
//		correspondenceTrigger.setNotice(new File(citizenApp.getCaseNum()+".pdf"));
		correspondenceTrigger.setTrigerStatus("Completed");
		correspondenceTriggerRepository.save(correspondenceTrigger);
		
	}

	private void sendPdf(CitizenApp citizenApp) {
		
		String subject ="Your eligibilty Notice";
		
		String body ="";
		
		emailUtil.sendEamil(citizenApp.getEmail(), subject, body, new File(FILE_PATH + citizenApp.getCaseNum()+".pdf"));
		
		
	}

	private void generatepdf(EligibleDetails details, CitizenApp citizenApp) {
		try {
		Document document = new Document();
		
		FileOutputStream outputStream = new FileOutputStream(new File(FILE_PATH + details.getCaseNo()+".pdf"));
		
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		
		document.open();
		
		Font font = new Font( Font.HELVETICA, 16, Font.BOLDITALIC, Color.red);
		
		Paragraph paragraph = new Paragraph("Eligibilty Details", font);
		
		document.add(paragraph);
		
		PdfPTable table = new PdfPTable(2);
		
		table.addCell("HOLDER NAME");
		table.addCell(citizenApp.getFullName());
		table.addCell("HOLDER SSN");
		table.addCell(citizenApp.getSsn().toString());
		table.addCell("PLAN NAME");
		table.addCell(details.getPlanName());
		table.addCell("PLAN STATUS");
		table.addCell(details.getPlanStatus());
		table.addCell("START DATE");
		table.addCell(details.getStartDate().toString());
		table.addCell("END DATE");
		table.addCell(details.getEndDate().toString());
		table.addCell("BENEFIT AMT");
		table.addCell(details.getBenefitAmt());
		table.addCell("DENIAL REASON");
		table.addCell(details.getDaniealReason());
		
		document.add(table);
		document.close();
		writer.close();
		
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
	private IDocumentService service;
//1)to show Document upload page
     @RequestMapping("/show")
    public String showDocuments() {
    	return "Documents";
    }
//2)to upload documents
     @RequestMapping(value="/upload",method=RequestMethod.POST)
     public String uploadDoc(@RequestParam CommonsMultipartFile file,ModelMap map) {
    	 if(file!=null) {
    		 Document doc=new Document();
    		 doc.setFileName(file.getOriginalFilename());
    		 doc.setFileData(file.getBytes());
    		 int fileId=service.saveDocument(doc);
    		 map.addAttribute("message", "uploaded fileid successfully");
    	 }
    		return "Documents"; 
    	 }
  //3)to display at ui
        @RequestMapping("/get")
         public String getData(ModelMap map) {
        List<Object[]> docs=service.getDocumentIdAndName();
        map.addAttribute("docs", docs);
        	return "Document";
        }
//4)download document
        
        @RequestMapping("/download")
        public void downloadDoc(@RequestParam("docId") int docId,HttpServletResponse resp) {
        	  Document doc=service.getDocumenyById(docId);
        	  //header param
        	  resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
        	  //copy body
        	  try {
              FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
        	  }catch (Exception e) {
               e.printStackTrace();
        	  }        		  
        }

}

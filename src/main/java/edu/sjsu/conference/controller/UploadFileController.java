package edu.sjsu.conference.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.uploadfiles.DropboxTest;
import edu.sjsu.conference.uploadfiles.FileDialog;
import edu.sjsu.oauth.LinkedInHelper;

@Controller
@RequestMapping("/dropbox")

public class UploadFileController {
	
		
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView setup(HttpServletRequest request) throws URISyntaxException, HttpException, IOException, JSONException {

		String code = request.getParameter("code");
		System.out.println("DropBox Code :: " + code);
		FileDialog fileDialog = new FileDialog();
		File selectedFile = fileDialog.openDialog();
		if(selectedFile != null)
		{
			DropboxTest.uploadDocuments(code,selectedFile);
			return new ModelAndView("Upload");
		}
		else
			return new ModelAndView("error");
		}
	}

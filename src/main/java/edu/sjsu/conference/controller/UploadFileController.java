package edu.sjsu.conference.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.conference.domain.Conference;
import edu.sjsu.conference.repository.ConferenceRepository;
import edu.sjsu.conference.uploadfiles.DropboxTest;
import edu.sjsu.conference.uploadfiles.FileDialog;
import edu.sjsu.oauth.LinkedInHelper;

@Controller
@RequestMapping("/dropbox")
@Scope("request")
public class UploadFileController {

	@Autowired
	Conference sessionConference;
	
	@Autowired
	ConferenceRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView setup(HttpServletRequest request)
			throws URISyntaxException, HttpException, IOException,
			JSONException {

		String code = request.getParameter("code");
		System.out.println("DropBox Code :: " + code);
		FileDialog fileDialog = new FileDialog();
		File selectedFile = fileDialog.openDialog();
		if (selectedFile != null) {
			DropboxTest.uploadDocuments(code, selectedFile);
			System.out.println("conf id after getting drop box link : " +sessionConference.getId());
			repository.addDropBoxLink(sessionConference.getId(), DropboxTest.sharedURL);
			return new ModelAndView("Upload");
		} else
			return new ModelAndView("error");
	}
}

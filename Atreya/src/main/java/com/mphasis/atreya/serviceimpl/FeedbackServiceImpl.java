package com.mphasis.atreya.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.atreya.dao.FeedbackDao;
import com.mphasis.atreya.entities.Feedback;
import com.mphasis.atreya.exceptions.ClinicExceptions;
import com.mphasis.atreya.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao feedbackDao;
	
	
	public void setFeddbackDao(FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}


	public void addFeedback(Feedback feedback) throws ClinicExceptions{
	   feedbackDao.createFedback(feedback);
		
	}
}



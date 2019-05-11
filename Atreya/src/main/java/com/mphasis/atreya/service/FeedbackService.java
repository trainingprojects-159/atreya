package com.mphasis.atreya.service;

import com.mphasis.atreya.entities.Feedback;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface FeedbackService {
	
	public void addFeedback(Feedback feedback) throws ClinicExceptions;

}

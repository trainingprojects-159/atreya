package com.mphasis.atreya.dao;

import com.mphasis.atreya.entities.Feedback;
import com.mphasis.atreya.exceptions.ClinicExceptions;

public interface FeedbackDao {

	public void createFedback(Feedback feedback) throws ClinicExceptions;
}

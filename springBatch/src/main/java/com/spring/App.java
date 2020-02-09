package com.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		// Add xml file
		//String[] springConfig = { "job.xml"};

		// Application context object creation - load bean from XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("job.xml");

		// Job Launcher object creation
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		// Job object creation
		Job job = (Job) context.getBean("myFirstJob");

		// Job Execution object creation
		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println(execution.getStatus());
			
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}

	}

}

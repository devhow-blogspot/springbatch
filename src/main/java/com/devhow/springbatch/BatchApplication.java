package com.devhow.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This class will launch a batch: the job will start by reading rows from database (Table employee)
 * and will write employees in XML file 
 *
 */
public class BatchApplication {
	public static void main(String[] args) {
		String[] springConfig = new String[] {
				"configs/context.xml",
				"jobs/job-read-employees.xml" };

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("employeeJob");

		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}

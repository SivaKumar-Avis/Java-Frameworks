package com.spring;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Tutorial,Tutorial>{

	public Tutorial process(Tutorial obj) throws Exception {

		return obj;
	}

}

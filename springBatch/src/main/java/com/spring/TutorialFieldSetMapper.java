package com.spring;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class TutorialFieldSetMapper implements FieldSetMapper<Tutorial> {

	public Tutorial mapFieldSet(FieldSet fieldSet) throws BindException {
		Tutorial tutorial = new Tutorial();
		tutorial.setId(fieldSet.readString("id"));
		tutorial.setName(fieldSet.readString("name"));
		return tutorial;
	}

}

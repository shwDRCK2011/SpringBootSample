package com.bugReport.transformer;

import org.springframework.stereotype.Service;

import com.bugReport.domain.Designation;
import com.bugReport.dto.DesignationDto;

@Service
public class DesignationTransformer implements BaseTransformer<Designation, DesignationDto>{

	@Override
	public DesignationDto transform(Designation designation) {
		DesignationDto designationDto = new DesignationDto();
		designationDto.setDesignationId(designation.getDesignationId());
		designationDto.setDesignationName(designation.getDesignationName());
		return designationDto;
	}

	@Override
	public Designation reverseTransform(DesignationDto designationDto) {
		Designation designation = new Designation();
		designation.setDesignationId(designationDto.getDesignationId());
		designation.setDesignationName(designationDto.getDesignationName());
		return designation;
	}

}

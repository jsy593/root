package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.bases.jpaentities.Information;

public interface InformationService
{
	@Transactional
	public boolean addInformation(Information information);

	@Transactional
	public boolean modifyInformation(Information information);

	@Transactional
	public boolean removeInformation(Information information);

	public Information findInformation(Information information);

	public List<InformationDTO> listInformation(int teacherId);
	
	public InformationDTO findInformationDTO(InformationDTO informationDTO);
	
}

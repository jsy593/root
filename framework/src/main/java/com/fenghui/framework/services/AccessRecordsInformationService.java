package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.AccessRecordInformation;

public interface AccessRecordsInformationService
{
	@Transactional
	public boolean addAccessRecordsInformation(AccessRecordInformation accessRecordsInformation);

	@Transactional
	public boolean modifyAccessRecordsInformation(AccessRecordInformation accessRecordsInformation);

	@Transactional
	public boolean removeAccessRecordsInformation(AccessRecordInformation accessRecordsInformation);

	public AccessRecordInformation findAccessRecordsInformation(AccessRecordInformation accessRecordsInformation);

	public List<AccessRecordInformation> listAccessRecordsInformation();
	
}

package com.fenghui.framework.services;

import java.util.List;

import com.fenghui.bases.handlejpa.Transactional;
import com.fenghui.bases.jpaentities.AccessRecordViewpoint;

public interface AccessRecordViewpointService
{
		@Transactional
		public boolean addAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint);
		
		@Transactional
		public boolean cancelAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint);
			
		@Transactional
		public AccessRecordViewpoint findAccessRecordViewpoint(AccessRecordViewpoint accessRecordViewpoint);
		
		public List<AccessRecordViewpoint> listAccessRecordViewpoint();
}

package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpadtos.ViewpointDTO;
import com.fenghui.beans.webapp.ViewPointInfoBean;

@ManagedBean(name = "viewPointInfoController")
@SessionScoped
public class ViewPointInfoController extends ControllerBase implements Serializable
{

	private static final long serialVersionUID = 5271453531568278026L;
	ViewPointInfoBean viewPointInfoBean=new ViewPointInfoBean();
	
	private ViewpointDTO viewPointDto=new ViewpointDTO();
	
	public String findViewPointInfo()
	{
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		String viewPointId = params.get("viewPointId");
		viewPointDto.setId(Integer.parseInt(viewPointId));
		viewPointDto = viewPointInfoBean.findViewPointInfo(viewPointDto);
		return "articleArticle.xhtml";
	}

	public ViewpointDTO getViewPointDto()
	{
		return viewPointDto;
	}

	public void setViewPointDto(ViewpointDTO viewPointDto)
	{
		this.viewPointDto = viewPointDto;
	}



		
}

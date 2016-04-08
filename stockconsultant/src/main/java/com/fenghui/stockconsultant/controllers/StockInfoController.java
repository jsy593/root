package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpadtos.InformationDTO;
import com.fenghui.beans.webapp.StockInfoBean;

@ManagedBean(name = "stockInfoController")
@SessionScoped
public class StockInfoController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = 9150660467365172158L;

	private InformationDTO informationDTO = new InformationDTO();
	private StockInfoBean stockInfoBean = new StockInfoBean();

	public String findInformationDTO()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		String informationId = params.get("informationId");
		informationDTO.setId(Integer.parseInt(informationId));
		informationDTO = stockInfoBean.findInformationDTO(informationDTO);
		return "stock.xhtml";
	}

	public InformationDTO getInformationDTO()
	{
		return informationDTO;
	}

	public void setInformationDTO(InformationDTO informationDTO)
	{
		this.informationDTO = informationDTO;
	}

}

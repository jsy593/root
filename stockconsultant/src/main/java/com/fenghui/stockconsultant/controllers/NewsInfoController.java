package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.beans.webapp.NewsInfoBean;

@ManagedBean(name = "newsInfoController")
@SessionScoped
public class NewsInfoController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = -4227369536155323933L;
	
	NewsInfoBean newsInfoBean = new NewsInfoBean();
	private News news = new News();

	public String findNews()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		String newsId = params.get("newsId");
		news.setId(Integer.parseInt(newsId));
		news = newsInfoBean.findNews(news);
		/*System.out.println("findNews()" + news.getId());*/
		return "/newsInfo.xhtml";
	}

	public NewsInfoBean getNewsBean()
	{
		return newsInfoBean;
	}

	public void setNewsBean(NewsInfoBean newsInfoBean)
	{
		this.newsInfoBean = newsInfoBean;
	}

	public News getNews()
	{
		return news;
	}

	public void setNews(News news)
	{
		this.news = news;
	}

}

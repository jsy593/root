package com.fenghui.stockconsultant.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fenghui.bases.handlejpa.ControllerBase;
import com.fenghui.bases.jpaentities.News;
import com.fenghui.beans.webapp.NewsBean;

@ManagedBean(name = "newsController")
@SessionScoped
public class NewsController extends ControllerBase implements Serializable
{
	private static final long serialVersionUID = -2283404138839337451L;

	NewsBean newsBean = new NewsBean();
	private News news = new News();
	private News updatingNews = new News();
	private List<News> newsList = newsBean.listNews();

	public String addNews()
	{
		System.out.println("addNews()");
		newsBean.addNews(news);
		news = new News();
		newsList = newsBean.listNews();
		return "/ajaxAddNews.xhtml";
	}

	public String findNews()
	{
		System.out.println("findNews()");
		newsBean.findNews(news);
		return "/articleArticle.xhtml";
	}

	public String listNews()
	{
		System.out.println("listNews()");
		newsBean.listNews();
		return "/stock2.xhtml";
	}

	public String removeNews()
	{
		System.out.println("removeNews()");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		String newsID = params.get("newsId");

		News uselessNews = new News();
		uselessNews.setId(Integer.parseInt(newsID));

		/*System.out.println(Utils.objectToJsonByGson(uselessNews));*/

		boolean ifSuccess = newsBean.removeNews(uselessNews);

		newsList = newsBean.listNews();

		if (ifSuccess)
		{
			return "/ajaxAddNews.xhtml";
		}
		else
		{
			return "/ajaxAddNews.xhtml";
		}
	}

	public String showModifyNews()
	{
		System.out.println("showModifyNews()");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, String> params = externalContext.getRequestParameterMap();
		String newsId = params.get("newsId");

		updatingNews.setId(Integer.parseInt(newsId));
		updatingNews = newsBean.findNews(updatingNews);

		return "/modifyNews.xhtml";
	}

	public String modifyNews()
	{
		System.out.println("modifyNews()");
		if (newsBean.modifyNews(updatingNews))
		{
			updatingNews = new News();
			newsList = newsBean.listNews();
			return "/ajaxAddNews.xhtml";
		}
		else
			return "/error.xhtml";
	}

	public NewsBean getNewsBean()
	{
		return newsBean;
	}

	public void setNewsBean(NewsBean newsBean)
	{
		this.newsBean = newsBean;
	}

	public News getNews()
	{
		return news;
	}

	public void setNews(News news)
	{
		this.news = news;
	}

	public News getUpdatingNews()
	{
		return updatingNews;
	}

	public void setUpdatingNews(News updatingNews)
	{
		this.updatingNews = updatingNews;
	}

	public List<News> getNewsList()
	{
		return newsList;
	}

	public void setNewsList(List<News> newsList)
	{
		this.newsList = newsList;
	}

	
}

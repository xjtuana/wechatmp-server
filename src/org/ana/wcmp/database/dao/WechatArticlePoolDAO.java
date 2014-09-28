package org.ana.wcmp.database.dao;

import java.sql.Blob;

public class WechatArticlePoolDAO {

	private long pk_article;
	private String article_name;
	private Blob article_title;
	private Blob article_desc;
	private String article_url;
	private String article_pic_uri;
	private String article_thumb_pic_uri;
	
	public long getPk_article() {
		return pk_article;
	}
	public void setPk_article(long pk_article) {
		this.pk_article = pk_article;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public Blob getArticle_title() {
		return article_title;
	}
	public void setArticle_title(Blob article_title) {
		this.article_title = article_title;
	}
	public Blob getArticle_desc() {
		return article_desc;
	}
	public void setArticle_desc(Blob article_desc) {
		this.article_desc = article_desc;
	}
	public String getArticle_url() {
		return article_url;
	}
	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}
	public String getArticle_pic_uri() {
		return article_pic_uri;
	}
	public void setArticle_pic_uri(String article_pic_uri) {
		this.article_pic_uri = article_pic_uri;
	}
	public String getArticle_thumb_pic_uri() {
		return article_thumb_pic_uri;
	}
	public void setArticle_thumb_pic_uri(String article_thumb_pic_uri) {
		this.article_thumb_pic_uri = article_thumb_pic_uri;
	}
	
}

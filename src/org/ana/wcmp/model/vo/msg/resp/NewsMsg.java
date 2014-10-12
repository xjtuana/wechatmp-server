package org.ana.wcmp.model.vo.msg.resp;

/**
 * 图文消息类，含有多组图文（不多于10项，第一项默认为大图，头条新闻）（对图文类利用List<>产生了一组对象），消息包含：
 * 图文条数：ArticleCount   图文内容组：Articles
 * 
 * @author Godrick
 *	Referring to <WeChat Public Platform Application Developing> (by Liufeng) 
 */
public class NewsMsg extends CommonInfoResp{

	private int ArticleCount;
	private Article[] Articles;
	
	public int getArticleCount(){
		return ArticleCount;
	}
	
	public Article[] getArticles(){
		return Articles;
	}
	
	public void setArticleCount(int newarticlecount){
		ArticleCount = newarticlecount;
	}
	
	public void setArticles(Article[] newarticles){
		Articles = newarticles;
	}
}
